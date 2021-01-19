package com.fh.product.property.service.impl;

import com.fh.common.ServerResponse;

import com.fh.product.property.mapper.PropertyMapper;
import com.fh.product.property.model.Property;
import com.fh.product.property.model.PropertyPrice;
import com.fh.product.property.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-14 20:28
 */
@Service

public class PropertyServiceImpl implements PropertyService {
     @Resource
    private PropertyMapper propertyMapper;


    @Override
    public ServerResponse getDate(Property property) {
        List<Property> propertylist=propertyMapper.getData(property);
        long count=propertyMapper.getDatacount(property);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("propertylist",propertylist);
        map.put("count",count);
        return ServerResponse.success(map);
    }

    @Override
    public ServerResponse add(Property property) {
        property.setPropertycreateDate(new Date());
        property.setPropertyauthor("admin");
        property.setPropertyisDel(1);
        propertyMapper.add(property);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse update(Property property) {
        property.setPropertyupdateDate(new Date());
        propertyMapper.update(property);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse delete(Integer propertyid) {
        propertyMapper.delete(propertyid);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse getPropertyPrice(Integer propertyid) {
        List<PropertyPrice> propertyPriceList=propertyMapper.getPropertyPrice(propertyid);
        return ServerResponse.success(propertyPriceList);
    }

    @Override
    public ServerResponse addPrice(PropertyPrice propertyPrice) {
        propertyPrice.setPropertyPriceisDel(1);
        propertyMapper.addPrice(propertyPrice);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updatePrice(PropertyPrice propertyPrice) {
        propertyMapper.updatePrice(propertyPrice);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse getPropertyDataByCategoryId(Integer propertytypeId) {
        List<Property> propertyList = propertyMapper.getPropertyDataByCategoryId(propertytypeId);
        return ServerResponse.success(propertyList);
    }
}
