package com.fh.product.property.model;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-17 19:32
 */
public class PropertyPrice {
    private Integer propertyPriceId;//  主键
    private String propertyPriceName;//
    private String propertyPriceNameCH;
    private Integer propertyId;//  属性id
    private Integer propertyPriceisDel;//

    private String propertynameCH;

    public String getPropertynameCH() {
        return propertynameCH;
    }

    public void setPropertynameCH(String propertynameCH) {
        this.propertynameCH = propertynameCH;
    }

    public Integer getPropertyPriceId() {
        return propertyPriceId;
    }

    public void setPropertyPriceId(Integer propertyPriceId) {
        this.propertyPriceId = propertyPriceId;
    }

    public String getPropertyPriceName() {
        return propertyPriceName;
    }

    public void setPropertyPriceName(String propertyPriceName) {
        this.propertyPriceName = propertyPriceName;
    }

    public String getPropertyPriceNameCH() {
        return propertyPriceNameCH;
    }

    public void setPropertyPriceNameCH(String propertyPriceNameCH) {
        this.propertyPriceNameCH = propertyPriceNameCH;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getPropertyPriceisDel() {
        return propertyPriceisDel;
    }

    public void setPropertyPriceisDel(Integer propertyPriceisDel) {
        this.propertyPriceisDel = propertyPriceisDel;
    }
}
