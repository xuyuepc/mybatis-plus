package com.kyle.mp.service.impl;

import com.kyle.mp.beans.Employee;
import com.kyle.mp.mapper.EmployeeMapper;
import com.kyle.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kyle
 * @since 2018-07-07
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
