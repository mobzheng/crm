package com.sm.crm.service.impl;

import com.sm.crm.entity.Department;
import com.sm.crm.mapper.DepartmentMapper;
import com.sm.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepm();
    }
}
