package com.fh.product.brand.service.impl;

import com.fh.common.ServerResponse;
import com.fh.product.brand.mapper.BrandMapper;
import com.fh.product.brand.model.Brand;
import com.fh.product.brand.service.BrandService;
import com.fh.utils.OssUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-13 19:47
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public ServerResponse getData(Brand brand) {
        List<Brand> brandList = brandMapper.getData(brand);
        long count = brandMapper.getDatacount(brand);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("brandlist",brandList);
        map.put("count",count);
        return ServerResponse.success(map);
    }

    @Override
    public ServerResponse add(Brand brand) {
        brand.setBrandisdel(1);
        brand.setBrandauthor("admin");
        brand.setBrandcreateDate(new Date());
        brandMapper.add(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse update(Brand brand) {
        brand.setBrandauthor("admin");
        brand.setBrandupdateDate(new Date());
        if (StringUtils.isNoneBlank(brand.getNewbrandimgpath())){
            OssUtil.deleteFile(brand.getBrandimgpath());
            brand.setBrandimgpath(brand.getNewbrandimgpath());
        }
        brandMapper.update(brand);
        return ServerResponse.success();
    }
}
