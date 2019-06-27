package com.xiazhe.service.DepartmentService;

import com.xiazhe.bean.Department;
import com.xiazhe.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartMentService {
    @Autowired
    DepartmentMapper mymapper1;

    @Override
    public List<Department> getList() {
        List<Department> list = mymapper1.getList();
        return list;
    }
}
