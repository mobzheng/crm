package com.sm.crm.mapper;

import com.sm.crm.entity.Log;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface LogMapper {
    void insertLog(Log log);

    List<Log> findAllLogs();

}
