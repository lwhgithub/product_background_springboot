package com.fh.utils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Map;
import java.util.UUID;

public class FreemarkerUtil {

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
