package com.example.first.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hu
 * @date 2020/5/2 12:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private String userId;
    private String commodityId;
    private Integer amount;
    private BigDecimal totalPrice;
    private String payment;
    private BigDecimal fee;
    private String status;
    private String remarks;
    private Date crateDate;
    private Date updateDate;
    private String delFlag;


}
