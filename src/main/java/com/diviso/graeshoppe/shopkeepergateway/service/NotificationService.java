package com.diviso.graeshoppe.shopkeepergateway.service;

import com.corundumstudio.socketio.SocketIOServer;
import com.diviso.graeshoppe.notification.avro.Notification;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.NotificationDTO;
import com.diviso.graeshoppe.shopkeepergateway.config.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class NotificationService {

    private final Logger log = LoggerFactory.getLogger(NotificationService.class);
    @Autowired
	private SocketIOServer socketIOServer;
    @Value("${topic.notification.destination}")
    private String notificationTopic;
    private final KafkaProperties kafkaProperties;
    private ExecutorService sseExecutorService = Executors.newCachedThreadPool();

    public NotificationService(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    
    public void consumeNotification() {
        log.debug("REST request to consume records from Kafka topics {}", notificationTopic);
        Map<String, Object> consumerProps = kafkaProperties.getConsumerProps();
        consumerProps.remove("topic");

        sseExecutorService.execute(() -> {
            KafkaConsumer<String, Notification> consumer = new KafkaConsumer<>(consumerProps);
            consumer.subscribe(Collections.singletonList(notificationTopic));
            boolean exitLoop = false;
            while(!exitLoop) {
                try {
                    ConsumerRecords<String, Notification> records = consumer.poll(Duration.ofSeconds(5));
                    for (ConsumerRecord<String, Notification> record : records) {
                    	sendNotification(record.value());
                    }
                } catch (Exception ex) {
                    log.trace("Complete with error {}", ex.getMessage(), ex);
                    exitLoop = true;
                }
            }
            consumer.close();
        });
    }

    private void sendNotification(Notification message) {
		log.info("Notification is send via socket server");
		NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO
				.setDate(OffsetDateTime.ofInstant(Instant.ofEpochMilli(message.getDate()), ZoneId.systemDefault()));
		notificationDTO.setTitle(message.getTitle());
		notificationDTO.setMessage(message.getMessage());
		notificationDTO.setTargetId(message.getTargetId());
		notificationDTO.setReceiverId(message.getReceiverId());
		notificationDTO.setId(message.getId());
		notificationDTO.setStatus(message.getStatus());
		socketIOServer.getBroadcastOperations().sendEvent(message.getReceiverId(), notificationDTO);
	}
}
