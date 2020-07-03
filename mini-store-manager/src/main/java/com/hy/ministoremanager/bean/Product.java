package com.hy.ministoremanager.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private Integer id;
    private String productName;
    private String price;
    private Integer volumn;
    private String indexImg;
    private Integer detailImg;
    private Integer classes;
    private String address;
    private String material;






}
