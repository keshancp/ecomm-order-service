package com.ecomm.orderservice.controller.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private Long id;
	private String itemCode;
	private BigDecimal price;
	private Integer quantity;
	
}
