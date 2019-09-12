package com.sm.crm.service;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Log;

public interface LogService {

    PageInfo<Log> findAllLogs(Integer currentPage, Integer pageSize);
}
