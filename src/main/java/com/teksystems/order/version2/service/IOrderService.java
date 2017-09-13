package com.teksystems.order.version2.service;

import com.teksystems.order.version2.model.OrderLine;

public interface IOrderService {

	void add(OrderLine orderLine) throws Exception;

	int size();

	OrderLine get(int index);

	void clear();
}