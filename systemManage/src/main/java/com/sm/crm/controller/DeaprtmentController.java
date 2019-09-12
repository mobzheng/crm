package com.sm.crm.controller;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Department;
import com.sm.crm.entity.Log;
import com.sm.crm.service.DepartmentService;
import com.sm.crm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/department")
public class DeaprtmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("findAll")
    public ResponseEntity<List<Department>> findAllLogs(){
        List<Department> allDepartment = departmentService.findAllDepartment();
        return ResponseEntity.ok(allDepartment);
    }
}
