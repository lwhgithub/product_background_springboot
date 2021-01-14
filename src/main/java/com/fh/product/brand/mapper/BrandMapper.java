package com.fh.product.brand.mapper;

import com.fh.product.brand.model.Brand;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-13 19:47
 */
public interface BrandMapper {
    List<Brand> getData(Brand brand);

    long getDatacount(Brand brand);

    void add(Brand brand);

    void update(Brand brand);
}
