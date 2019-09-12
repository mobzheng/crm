package com.sm.crm.controller;

import com.sm.crm.entity.Menu;
import com.sm.crm.entity.User;
import com.sm.crm.service.MenuService;
import com.sm.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.List;

@Controller
@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有的菜单
     * @param request
     * @param response
     * @return
     */
    @GetMapping("findMenus")
    public ResponseEntity<List<Menu>> findAll(HttpServletRequest request,HttpServletResponse response){

        List<Menu> allUser = menuService.findMenuByUid(null);
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("findMenusByrid")
    public ResponseEntity<List<Menu>> findMenusByrid(Integer rid){
        List<Menu> menusByrid = menuService.findMenusByrid(rid);
        return ResponseEntity.ok(menusByrid);
    }

}
