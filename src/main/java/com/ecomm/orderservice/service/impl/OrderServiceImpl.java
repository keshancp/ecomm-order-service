package com.ecomm.orderservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;



import com.ecomm.orderservice.dto.OrderDto;
import com.ecomm.orderservice.exception.ECommOrderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.orderservice.dto.ItemDto;
import com.ecomm.orderservice.dto.OrderRequestDto;
import com.ecomm.orderservice.model.Item;
import com.ecomm.orderservice.model.Orders;
import com.ecomm.orderservice.repository.ItemRepository;
import com.ecomm.orderservice.repository.OrderRepository;
import com.ecomm.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public OrderDto placeOrder(OrderRequestDto orderRequestDto,String traceId) throws ECommOrderException {

		Orders order= Orders.builder().orderNumber(UUID.randomUUID().toString())
				.itemList(orderRequestDto.getItemList().stream().map(itemDto -> mapToEntity(itemDto)).collect(Collectors.toList())).build();

		//save order and items
		Orders newOrder= orderRepository.save(order);
		
		//update order id
		itemRepository.saveAll(order.getItemList().stream().map(item->setOrderId(order,item)).collect(Collectors.toList()));

		OrderDto newOrderDto=objectMapper.convertValue(newOrder,OrderDto.class);

		return newOrderDto;
	}

	private Item mapToEntity(ItemDto itemDto) {
		Item item = new Item();
		item.setPrice(itemDto.getPrice());
		item.setItemCode(itemDto.getItemCode());
		item.setQuantity(itemDto.getQuantity());
		return item;
	}
	
	private Item setOrderId(Orders order,Item item) {
		item.setOrder(order);
		return item;
	}

}
