package com.fh.product.property.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-14 20:13
 */
public class Property {
    private Integer propertyid;//    主键
    private String propertyname;//  属性名   color
    private String propertynameCH;//  属性中文名   颜色
    private Integer propertytypeId;//   分类的主键
    private Integer propertytype;//     属性的类型    0 下拉框     1 单选框      2  复选框   3  输入框
    private Integer propertyisSKU;//  是否为sku属性
    private Integer propertyisDel;//   逻辑删除
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date propertycreateDate;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date propertyupdateDate;//
    private String propertyauthor;// 操作人

//
    private long pagingStart=0;
    private long pagingSize=10;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public String getPropertynameCH() {
        return propertynameCH;
    }

    public void setPropertynameCH(String propertynameCH) {
        this.propertynameCH = propertynameCH;
    }

    public Integer getPropertytypeId() {
        return propertytypeId;
    }

    public void setPropertytypeId(Integer propertytypeId) {
        this.propertytypeId = propertytypeId;
    }

    public Integer getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(Integer propertytype) {
        this.propertytype = propertytype;
    }

    public Integer getPropertyisSKU() {
        return propertyisSKU;
    }

    public void setPropertyisSKU(Integer propertyisSKU) {
        this.propertyisSKU = propertyisSKU;
    }

    public Integer getPropertyisDel() {
        return propertyisDel;
    }

    public void setPropertyisDel(Integer propertyisDel) {
        this.propertyisDel = propertyisDel;
    }

    public Date getPropertycreateDate() {
        return propertycreateDate;
    }

    public void setPropertycreateDate(Date propertycreateDate) {
        this.propertycreateDate = propertycreateDate;
    }

    public Date getPropertyupdateDate() {
        return propertyupdateDate;
    }

    public void setPropertyupdateDate(Date propertyupdateDate) {
        this.propertyupdateDate = propertyupdateDate;
    }

    public String getPropertyauthor() {
        return propertyauthor;
    }

    public void setPropertyauthor(String propertyauthor) {
        this.propertyauthor = propertyauthor;
    }

    public long getPagingStart() {
        return pagingStart;
    }

    public void setPagingStart(long pagingStart) {
        this.pagingStart = pagingStart;
    }

    public long getPagingSize() {
        return pagingSize;
    }

    public void setPagingSize(long pagingSize) {
        this.pagingSize = pagingSize;
    }
}
