package com.whs.dubbonacosmybatisplusprovider.Utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGeneration {

    //根据表生成相关的java代码
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");//输出文件路径
        gc.setOutputDir(projectPath + "/dubbo-nacos-mybatisplus-provider/src/main/java");//输出文件路径
        System.out.println("projectpath:"+projectPath);
        gc.setOpen(false);

        gc.setFileOverride(true);
        gc.setActiveRecord(false);           // 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);           // XML 二级缓存
        gc.setBaseResultMap(true);          // XML ResultMap
        gc.setBaseColumnList(false);        // XML columList
        gc.setAuthor("巫浩盛");             //设置作者
        gc.setDateType(DateType.ONLY_DATE);//设置生成时间

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
        //    gc.setMapperName("%sMapper");
        gc.setMapperName("%sDao");
        //    gc.setXmlName("%sMapper");
//        gc.setXmlName("%sDao");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/learn?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");   //旧的驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        //设置文件的生成的包的位置：修改为自己的项目路径
        pc.setParent("com.whs.dubbonacosmybatisplusprovider");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("serviceimpl");
        pc.setMapper("dao");
        pc.setEntity("entity");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        //下面的代码需要用到freemarker的相关依赖
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//                return projectPath + "/src/main/resources/mapper/" + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;//设置mapper文件生成路径
//                return projectPath + "/src/main/resources/mapper/" + "/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;//设置mapper.xml文件生成路径
                return projectPath + "/dubbo-nacos-mybatisplus-provider/src/main/resources/mapper/" + "/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;//设置mapper.xml文件生成路径
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
        //strategy.setEntityLombokModel(true);//是否系列化类
        strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//        strategy.setInclude(scanner("表名"));    //原来的
        strategy.setInclude(new String[] { "person" });    //设置要生成的实体类的表名
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
