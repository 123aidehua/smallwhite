package com.itheima.pojo;
import java.util.List;
public class Category {
    private Integer id;                                // 主键id
    private String typename;                     // 类别名称
    private List<Product> productList;     // 商品集合

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // 省略getter/etter方法
    @Override
    public String toString() {
        return "Category{" +"id=" + id + ", typename='" + 	typename +", productList=" + productList + '}'; }

}
