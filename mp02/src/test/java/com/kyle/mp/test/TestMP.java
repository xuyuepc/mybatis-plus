package com.kyle.mp.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kyle.mp.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMP {

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
