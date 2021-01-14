package com.fh.product.property.controller;

import com.fh.common.ServerResponse;
import com.fh.product.property.model.Property;
import com.fh.product.property.service.PropertyService;
import org.apache.catalina.Server;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-14 20:26
 */
@RestController
@RequestMapping("api/property/")
public class PropertyController {
    @Resource
    private PropertyService propertyService;
//      http://192.168.2.1:8111/api/property/getData
//      get
//      无必须参数，默认查询id最大的10条数据 根据id倒序排列
//      返回json
    @GetMapping("getData")
    public ServerResponse getDate(Property property){
        return propertyService.getDate(property);
    }
    @PostMapping("add")
    public ServerResponse add(Property property){
        return propertyService.add(property);
    }
    @PutMapping("update")
    public ServerResponse update(Property property){
        return propertyService.update(property);
    }




}
