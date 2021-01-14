package com.fh.product.brand.controller;

import com.fh.common.ServerResponse;
import com.fh.product.brand.model.Brand;
import com.fh.product.brand.service.BrandService;
import com.fh.utils.OssUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-13 19:40
 */
@RestController
@RequestMapping("api/brand/")
public class BrandController {



//我范围分为个味儿噶喏个
    @Resource
    private BrandService brandService;
//      http://192.168.2.1:8111/api/brand/getData
//      get
//      无必须参数，默认查询id最大的10条数据 根据id倒序排列
//      返回json
    @GetMapping("getData")
    public ServerResponse getData(Brand brand){
        return brandService.getData(brand);
    }
    @PostMapping("add")
    public ServerResponse add(Brand brand) {
        return brandService.add(brand);
    }
    @PutMapping("update")
    public ServerResponse update(Brand brand){
        return brandService.update(brand);
    }
    @RequestMapping("uploadFile")
    @CrossOrigin
    public ServerResponse importPhoto(MultipartFile file){
        return OssUtil.uploadFile(file);
    }

}
