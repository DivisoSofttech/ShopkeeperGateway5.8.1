package com.diviso.graeshoppe.shopkeepergateway.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.AuxilaryOrderLine;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.Notification;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.Order;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.OrderLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderMaster;

/**
 * 
 * @author Prince
 *
 */
public interface OrderQueryService {

	/**
	 * @param statusName
	 * @param storeid
	 * @param deliveryType
	 * @param pageable
	 */
	public Page<OrderMaster> findOrderByStatusNameAndStoreIdAndDeliveryType(LocalDate date, String statusName, String storeId,
			String deliveryType, Pageable pageable);

	/**
	 * @param storeId
	 */
	public Page<Order> findOrderByStoreId(String storeId, Pageable pageable);

	/**
	 * @param orderId
	 * @return
	 */
	List<OrderLine> findOrderLinesByOrderId(Long orderId);

	/**
	 * 
	 * @param receiverId
	 * @param pageable
	 * @return
	 */
	public Page<Notification> findNotificationByReceiverId(String receiverId, Pageable pageable);

	// public Long findOrderCountByDateAndStatusName(String statusName, Instant
	// date);

	/**
	 * 
	 * @param from
	 * @param to
	 * @param storeId
	 * @return
	 */
	public Page<Order> findOrderByDatebetweenAndStoreId(Instant from, Instant to, String storeId, Pageable pageable);

	/**
	 * 
	 * @param status
	 * @param receiverId
	 * @return
	 */
	public Long getNotificationCountByReceiveridAndStatus(String status, String receiverId);

	/**
	 * 
	 * @param receiverId
	 * @param status
	 * @return
	 */
	//public Long findNotificationCountByReceiverIdAndStatusName(String receiverId, String status);

	/**
	 * @param orderId
	 */
	public Order findOrderByOrderId(String orderId);

	public Long orderCountByCustomerIdAndStoreId(String customerId, String storeId);

	//public ResponseEntity<OpenTask> getTaskDetails(String taskName, String orderId, String storeId);

	/*
	 * public ResponseEntity<List<Order>> getTasks(String assignee, String
	 * assigneeLike, String candidateGroup, String candidateGroups, String
	 * candidateUser, String createdAfter, String createdBefore, String createdOn,
	 * String name, String nameLike);
	 */

	public Page<com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.OrderLine> findAllOrderLinesByOrderId(Long orderId, Pageable pageable);

	public Page<AuxilaryOrderLine> findAuxilaryOrderLineByOrderLineId(Long orderLineId, Pageable pageable);

	// List<OrderLine> findOrderLinesByOrderId(Long orderId, Pageable pageable);
}
