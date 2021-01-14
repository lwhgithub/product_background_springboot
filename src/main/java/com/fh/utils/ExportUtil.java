package com.fh.utils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

/**
 * @author winter
 * @create 2020-10-13 9:58
 */
public class ExportUtil {
    /**
     * 文件下载
     * @param file
     * @param fileName
     * @param response
     */
    public static void downloadFile(File file, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os = response.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(os);
        //解决下载文件名中文乱码问题
        if(request.getHeader("User-Agent").toLowerCase().indexOf("firefox")!=-1){
            fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
        }else{
            fileName = URLEncoder.encode(fileName,"utf-8");
        }
        response.reset(); // 重点突出
        response.setCharacterEncoding("UTF-8"); // 重点突出
        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //定义一个长度为4096的字节数组
        byte[] bytes = new byte[4096];
        //先读他个4096字节
        int read = bis.read(bytes);
        while(read > 0){
            bos.write(bytes,0,read);
            read = bis.read(bytes);
        }
        bos.close();
        bis.close();
    }


    /**
     * 生成word和excel方法
     * @param folderName
     * @param templateName
     * @param dataMap
     * @param request
     * @return
     */
    public static File generatePdf(String folderName, String templateName, Map dataMap, HttpServletRequest request){
        File file = null;
        try {
            // 1.创建配置类d
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("utf-8");
            // 2.设置模板所在目录
            cfg.setClassForTemplateLoading(FreemarkerUtil.class,folderName);
            // 3.获取具体的模板
            Template template = cfg.getTemplate(templateName);
            // 5.创建Write对象
            Writer writer= new StringWriter();
            // 6.调用模板对象中的process方法填充数据并输出内容到指定的文件
            template.process(dataMap,writer);
            // 7.从Writer对象中得到生成的html内容
            String html = writer.toString();
            // 8.创建Pdf渲染器
            ITextRenderer renderer = new ITextRenderer();
            // 9.设置字体，目前只支持黑体和宋体，否则Pdf中的中文将不会显示
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("/template/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 10.将html内容放到Pdf渲染器中
            renderer.setDocumentFromString(html);
            // 11.调用Pdf渲染器中layout方法
            renderer.layout();
            // 获取项目发布的绝对路径
            String realPath = request.getServletContext().getRealPath("/");
            file = new File(realPath + UUID.randomUUID().toString() + ".pdf");
            FileOutputStream os = new FileOutputStream(file);
            // 13.调用PDF渲染器中创建PDF文件的方法
            renderer.createPDF(os);
            renderer.finishPDF();
            os.close();
            writer.close();
        } catch (IOException | TemplateException | DocumentException e) {
            e.printStackTrace();
        }
        return file;
    }


    public static File generateWord(String folderName, String templateName, Map dataMap, HttpServletRequest request){
        File file = null;
        try {
            // 1.创建配置类d
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("utf-8");
            // 2.设置模板所在目录
            cfg.setClassForTemplateLoading(FreemarkerUtil.class,folderName);
            // 3.获取具体的模板
            Template template = cfg.getTemplate(templateName);
            // 获取项目发布的绝对路径
            String realPath = request.getServletContext().getRealPath("/");
            file = new File(realPath + UUID.randomUUID().toString() + ".docx");
            // 5.创建Write对象
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            // 6.调用template中的process方法将数据推送给模板进行输出
            template.process(dataMap,osw);
            osw.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return file;
    }
}
