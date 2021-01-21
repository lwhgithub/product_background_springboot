package com.fh.product.product.model;

import org.apache.zookeeper.data.Id;

import java.math.BigDecimal;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-21 12:02
 */
public class ProductPropertyPrice {

    private Integer id;
    private Integer productId;
    private String productProperty;
    private Integer productStocks;
    private BigDecimal productPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(String productProperty) {
        this.productProperty = productProperty;
    }

    public Integer getProductStocks() {
        return productStocks;
    }

    public void setProductStocks(Integer productStocks) {
        this.productStocks = productStocks;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
