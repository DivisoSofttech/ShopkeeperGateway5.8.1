package com.diviso.graeshoppe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diviso.graeshoppe.client.sale.model.Sale;
import com.diviso.graeshoppe.client.sale.model.TicketLine;

public interface SaleQueryService {

	public Page<Sale> findSales(String storeId, Pageable pageable);

	public List<TicketLine> findTicketLinesBySaleId(Long saleId);
}
