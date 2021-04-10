package com.example.apacheshiro.model;

/**
 * @Author zeroback13
 * @Date 2021/4/5 1:17
 * @Version 1.0
 */
public class Permission {
    private Integer pid;
    private String name;
    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
