package com.sm.crm.controller;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Log;
import com.sm.crm.entity.User;
import com.sm.crm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("findAll")
    public ResponseEntity<PageInfo<Log>> findAllLogs(Integer currentPage, Integer pageSize){
        PageInfo<Log> allLogs = logService.findAllLogs(currentPage, pageSize);
        return ResponseEntity.ok(allLogs);

    }
}
