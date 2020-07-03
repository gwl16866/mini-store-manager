package com.hy.ministoremanager.bean;

import lombok.Data;

@Data
public class ResUpload {

    private String msg;
    private String url;

    public ResUpload(String msg, String url) {
        this.msg = msg;
        this.url = url;
    }
}
