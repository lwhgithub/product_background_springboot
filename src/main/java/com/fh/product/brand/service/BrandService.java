package com.fh.product.brand.service;

import com.fh.common.ServerResponse;
import com.fh.product.brand.model.Brand;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-13 19:44
 */
public interface BrandService {
    ServerResponse getData(Brand brand);

    ServerResponse add(Brand brand);

    ServerResponse update(Brand brand);
}
