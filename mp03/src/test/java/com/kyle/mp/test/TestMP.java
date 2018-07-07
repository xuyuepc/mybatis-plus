package com.kyle.mp.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kyle.mp.beans.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMP {

    @Test
    public void testGenerator() {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("kyle") //作者
                .setOutputDir("D:\\Learn\\IdeaGitee\\mybatis-plus\\mp03\\src\\main\\java") //生成路径
                .setFileOverride(true)//文件覆盖
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO); //主键策略

        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("root");

        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) //表名 字段名 是否使用下滑线命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tbl_employee") //生成的表
                .setTablePrefix("tbl_"); // 表前缀

        //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.kyle.mp")
                .setController("controller")
                .setEntity("beans")
                .setService("service");
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        ag.execute();
    }

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR 分页复杂查询
     */
    @Test
    public void testARPage(){
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<>(1, 1),
                new EntityWrapper<Employee>().like("last_name", "Y"));
        List<Employee> records = page.getRecords();
        System.out.println(records);


    }
}
