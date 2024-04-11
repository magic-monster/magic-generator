package com.magic.generator;

import com.magic.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir") + File.separator + "magic-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("magic");
        mainTemplateConfig.setOutputText("我的输出结果");
        mainTemplateConfig.setLoop(true);
        doGenerator(inputPath,outputPath,mainTemplateConfig);
    }

    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        //new 出 Configuration 对象，参数为FreeMarker 版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateDir);

        //设置模板文件使用的字符集
        cfg.setDefaultEncoding("UTF-8");
        //创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);

        //数据模型
        Writer out = new FileWriter(outputPath);
        template.process(model,out);
        out.close();
    }
}
