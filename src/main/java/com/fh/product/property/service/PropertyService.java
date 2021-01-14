package com.fh.product.property.service;

import com.fh.common.ServerResponse;
import com.fh.product.property.model.Property;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-14 20:28
 */
public interface PropertyService {
    ServerResponse getDate(Property property);

    ServerResponse add(Property property);
}
