package com.hy.ministoremanager.bean;

import lombok.Data;

import java.util.List;

@Data
public class BigClass {

    private Integer id;
    private String text;
    private List<BigClassTwo> children;

}
