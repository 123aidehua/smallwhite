package com.itheima.pojo;

public class IdCard {private Integer id;                 // 主键id
    private String code;              // 身份证号码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // 省略getter/setter方法
    @Override
    public String toString() {

        return "IdCard [id=" + id + ", code=" + code + "]";
    }
    }
