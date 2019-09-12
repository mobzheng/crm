package com.sm.crm.mapper;

import com.sm.crm.entity.Right;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RightMapper {
    List<Right> findAllRights();

    int updateRightMenu(@Param("rid") Integer rid, @Param("menuId") Integer[] menuId);

    void deleteRightMenuByrid(Integer rid);
}
