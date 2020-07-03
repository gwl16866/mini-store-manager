package com.hy.ministoremanager.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsCar {

    private Integer id;
    private String productName;
    private String material;
    private String address;
    private String model;
    private String color;
    private BigDecimal price;
    private Integer counts;
    private String indexImg;




}
