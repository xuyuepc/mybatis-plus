package com.kyle.mp;

import com.kyle.mp.mapper.EmployeeMapper;
import com.kyle.mp.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class TestMP {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper =
            ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testDataSource() throws Exception {
        DataSource ds  = ioc.getBean("dataSource",DataSource.class);
        System.out.println(ds);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

    /**
     * 通用 插入操作
     */
    @Test
    public void testCommonInsert() {

        //初始化Employee对象
        Employee employee  = new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@itheima.com");
        //employee.setGender(1);
        //employee.setAge(22);
        employee.setSalary(20000.0);
        //插入到数据库
        // insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        //Integer result = employeeMapper.insert(employee);

        //insertAllColumn方法在插入时， 不管属性是否非空， 属性所对应的字段都会出现到SQL语句中.
        Integer result = employeeMapper.insertAllColumn(employee);

        System.out.println("result: " + result );

        //获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key:" + key );
    }
}
