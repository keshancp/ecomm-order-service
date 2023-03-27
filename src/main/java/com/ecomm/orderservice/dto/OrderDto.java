package com.ecomm.orderservice.dto;

import com.ecomm.orderservice.model.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String orderNumber;

    @JsonIgnore
    private List<ItemDto> itemList=new ArrayList<>();

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
