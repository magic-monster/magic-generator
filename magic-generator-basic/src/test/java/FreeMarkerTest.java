
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        //new 出 Configuration 对象，参数为FreeMarker 版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        //指定模版文件所在路径
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/template"));
        //设置模板文件使用的字符集
        cfg.setDefaultEncoding("UTF-8");
        //创建模板对象，加载指定模板
        Template template = cfg.getTemplate("myweb.html.ftl");

        //数据模型
        HashMap<Object, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2024);
        ArrayList<Object> menuItems = new ArrayList<>();

        HashMap<Object, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url","https://codefather.cn");
        menuItem1.put("label","编程导航");

        HashMap<Object, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url","https://laoyujianli.com");
        menuItem2.put("label","老于简介");

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);

        dataModel.put("menuItems",menuItems);

        Writer out = new FileWriter("myweb.html");

        template.process(dataModel,out);
        out.close();
    }

}
