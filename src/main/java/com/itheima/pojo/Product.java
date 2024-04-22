package com.itheima.pojo;
import java.util.List;
public class Product {
    private Integer id;                    // 主键id
    private String goodsname;     //  商品名称
    private double price;              //  价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 省略getter/setter方法
    @Override
    public String toString() {
        return "Product{" +"id=" + id + ", goodsname='" + goodsname +", price=" + price + '}';   }

}
