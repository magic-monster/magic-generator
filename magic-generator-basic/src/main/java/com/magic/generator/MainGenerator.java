package com.magic.generator;

import com.magic.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        //获取整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();

        //输入路径
        String inputPath = new File(parentFile,"magic-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        //递归拷贝
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态文件生成
        String dynamicinputPath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String dynamicoutputPath = projectPath + File.separator + "acm-template/src/com/magic/acm/MainTemplate.java";
        DynamicGenerator.doGenerator(dynamicinputPath,dynamicoutputPath,model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("magic");
        mainTemplateConfig.setOutputText("我的输出结果");
        mainTemplateConfig.setLoop(true);
        doGenerator(mainTemplateConfig);
    }
}
