package com.ecomm.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ECommInventoryResponse {

    private int statusCode;
    private String message;
    private Object data;

    public ECommInventoryResponse(int statusCode, String message){
        this.statusCode=statusCode;
        this.message=message;
    }

    public ECommInventoryResponse(Object data){
        this.data=data;
    }

    public ECommInventoryResponse(String message){
        this.message=message;
    }


    public ECommInventoryResponse(String message, Object data){
        this.message=message;
        this.data=data;
    }

}
