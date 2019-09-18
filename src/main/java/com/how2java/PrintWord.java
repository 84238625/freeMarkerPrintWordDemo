package com.how2java;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PrintWord{
  public   static void main(String[] args) throws IOException, TemplateException {


        Configuration cfg=new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("D:/模板/")); //模板存放地址
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template template=cfg.getTemplate("测试.xml");

        Map root = new HashMap();
        root.put("user","小明");
        Map latest=new HashMap();
        root.put("latestProduct",latest);
        latest.put("url","www.baidu.com");
        latest.put("name","冰激凌");


      String fileName="办理打印单"+".doc";
       Writer out =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:/模板/" + fileName + "")), "utf-8"));//doc文件输出地址
        template.process(root,out);
        out.flush();
    }
}

