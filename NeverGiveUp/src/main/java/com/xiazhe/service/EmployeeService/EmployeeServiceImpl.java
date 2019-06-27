package com.xiazhe.service.EmployeeService;

import com.xiazhe.bean.Employee;
import com.xiazhe.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper mymapper;

    @Override
    public List<Employee> getList() {
        List<Employee> list = mymapper.getList();
        return list;
    }
}
