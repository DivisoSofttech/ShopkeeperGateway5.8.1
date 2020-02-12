package com.diviso.graeshoppe.shopkeepergateway.service;

import org.springframework.http.ResponseEntity;

import com.diviso.graeshoppe.shopkeepergateway.client.order.model.ApprovalDetailsDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.CommandResource;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.NotificationDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.OrderDTO;

public interface OrderCommandService {

	ResponseEntity<OrderDTO> updateOrder(OrderDTO orderDTO);
	
	public ResponseEntity<NotificationDTO> updateNotification(NotificationDTO notificationDTO);
	
	public ResponseEntity<CommandResource> createApprovalDetails(String taskId,ApprovalDetailsDTO approvalDetailsDTO);
}
