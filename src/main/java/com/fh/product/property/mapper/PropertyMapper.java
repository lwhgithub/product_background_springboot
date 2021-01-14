package com.fh.product.property.mapper;

import com.fh.product.property.model.Property;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-14 20:29
 */
public interface PropertyMapper {
    List<Property> getData(Property property);

    long getDatacount(Property property);

    void add(Property property);
}
