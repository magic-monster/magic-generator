package com.magic.generator;

import com.magic.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //静态文件生成
        //获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath = projectPath + File.separator +"magic-generator-demo-projects"+ File.separator +"acm-template";
        //输出路径
        String outputPath = projectPath;
        //递归拷贝
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态文件生成
        String dynamicinputPath = projectPath + File.separator + "magic-generator-basic"+ File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String dynamicoutputPath = projectPath + File.separator + "acm-template/src/com/magic/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("magic");
        mainTemplateConfig.setOutputText("我的输出结果");
        mainTemplateConfig.setLoop(true);
        DynamicGenerator.doGenerator(dynamicinputPath,dynamicoutputPath,mainTemplateConfig);
    }
}
