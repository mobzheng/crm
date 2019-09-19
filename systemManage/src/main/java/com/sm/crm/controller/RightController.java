package com.sm.crm.controller;

import com.sm.crm.entity.Right;
import com.sm.crm.entity.User;
import com.sm.crm.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/right")
public class RightController {

    @Autowired
    private RightService rightService;

    /**
     * 查询所有的权限
     *
     * @return
     */
    @GetMapping("findAll")
    public ResponseEntity<List<Right>> findAllRights() {
        List<Right> allRight = rightService.findAllRight();
        return ResponseEntity.ok(allRight);
    }


    /**
     * 修改权限-菜单映射
     *
     * @param rid
     * @param menuId
     * @return
     */
    @PutMapping("updateRightMenu")
    public ResponseEntity<String> updateRightMenu(Integer rid, Integer[] menuId) {
        rightService.deleteRightMenuByrid(rid);
        rightService.updateRightMenu(rid, menuId);
        return ResponseEntity.ok("success");
    }
}
