package com.fh.product.brand.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-13 19:28
 */
public class Brand {
    private Integer brandid;//  主键
    private String brandname;//    名称
    private String brandE;// 首字母
    private String brandimgpath ;//  图片log
    private String brandDesc;//  品牌介绍
    private Integer brandord;// 排序字段
    private Integer brandisdel;//逻辑删除
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date brandcreateDate ;//  创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date brandupdateDate;//   修改时间
    private String brandauthor;//   操作人

    private long pagingStart=0;
    private long pagingSize=10;

    private String newbrandimgpath;

    public String getNewbrandimgpath() {
        return newbrandimgpath;
    }

    public void setNewbrandimgpath(String newbrandimgpath) {
        this.newbrandimgpath = newbrandimgpath;
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

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBrandE() {
        return brandE;
    }

    public void setBrandE(String brandE) {
        this.brandE = brandE;
    }

    public String getBrandimgpath() {
        return brandimgpath;
    }

    public void setBrandimgpath(String brandimgpath) {
        this.brandimgpath = brandimgpath;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Integer getBrandord() {
        return brandord;
    }

    public void setBrandord(Integer brandord) {
        this.brandord = brandord;
    }

    public Integer getBrandisdel() {
        return brandisdel;
    }

    public void setBrandisdel(Integer brandisdel) {
        this.brandisdel = brandisdel;
    }

    public Date getBrandcreateDate() {
        return brandcreateDate;
    }

    public void setBrandcreateDate(Date brandcreateDate) {
        this.brandcreateDate = brandcreateDate;
    }

    public Date getBrandupdateDate() {
        return brandupdateDate;
    }

    public void setBrandupdateDate(Date brandupdateDate) {
        this.brandupdateDate = brandupdateDate;
    }

    public String getBrandauthor() {
        return brandauthor;
    }

    public void setBrandauthor(String brandauthor) {
        this.brandauthor = brandauthor;
    }
}
