package com.sm.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Log;
import com.sm.crm.mapper.LogMapper;
import com.sm.crm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public PageInfo<Log> findAllLogs(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Log> allLogs = logMapper.findAllLogs();
        PageInfo<Log> logPageInfo = new PageInfo<>(allLogs);

        return logPageInfo;
    }
}
