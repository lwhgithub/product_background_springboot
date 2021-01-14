package com.fh.utils;

import com.aliyun.oss.OSSClient;
import com.fh.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OssUtil {

    // 阿里云oss上传文件相关属性值
    // 阿里云API的外网域名
    public static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    // 阿里云API的密钥
    public static final String ACCESS_KEY_ID = "LTAI4G6LWmep4VZdbcF75qjM";
    // 阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = "cbzKCX9HfhkN3HzuItXBeIhvDIQYxG";
    // 阿里云API的bucket名称
    public static final String BACKET_NAME = "lwhsndy";
    // 阿里云API的文件夹名称
    public static final String FOLDER = "phone/";
    public static final String URL = "https://lwhsndy.oss-cn-beijing.aliyuncs.com/";

    /**
     * 上传文件
     * @param file
     * @return
     */
    public static ServerResponse uploadFile(MultipartFile file){
        InputStream is = null;
        OSSClient ossClient = null;
        try {
            // 1.创建OssClient客户端对象
            ossClient = new OSSClient(ENDPOINT,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
            // 2.获取文件名
            String originalFilename = file.getOriginalFilename();
            // 3.获取文件的后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 4.给文件重命名，为了防止文件被覆盖
            String newFileName = UUID.randomUUID().toString()+suffix;
            // 5.通过当前日期创建文件夹
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String folderName = sdf.format(new Date());
            // 6.创建文件输入流
            is = file.getInputStream();
            // 7.调用OssClient中的putObject方法进行上传
            ossClient.putObject(BACKET_NAME,folderName+"/"+newFileName,is);
            return ServerResponse.success(URL+folderName+"/"+newFileName);
        }catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.error();
        } finally {
            // 关流
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 关闭oss客户端
            if (ossClient != null){
                ossClient.shutdown();
            }
        }
    }

    public static void deleteFile(String filePath){
        String photoName = filePath.replace(URL, "");
        OSSClient ossClient = new OSSClient(ENDPOINT,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
        ossClient.deleteObject(BACKET_NAME,photoName);
    }
}
