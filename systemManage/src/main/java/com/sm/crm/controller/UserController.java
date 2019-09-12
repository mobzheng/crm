package com.sm.crm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.User;
import com.sm.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.List;

/**
 * 用户controller层
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @param user
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        User user1 = userService.findUser(user);
        request.getSession().setAttribute("user", user1);
        String message = user1 == null ? "success" : "fail";
        return ResponseEntity.ok("success");
    }

    /**
     * 查询所有用户
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("findAllUser")
    public ResponseEntity<PageInfo<User>> findAll(Integer currentPage, Integer pageSize) {
        PageInfo<User> allUser = userService.findAllUser(currentPage, pageSize);
        return ResponseEntity.ok(allUser);
    }


    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PutMapping(value = "updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        System.out.println(user);
        userService.updateUser(user);
        return ResponseEntity.ok("success");
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("success");
    }


    /**
     * 删除用户
     *
     * @param uid
     * @return
     */
    @DeleteMapping("deleteUser")
    public ResponseEntity<String> deleteUser(Integer uid) {
        userService.deleteUser(uid);
        return ResponseEntity.ok("success");
    }


    /**
     * 按条件查询用户列表
     *
     * @param user
     * @return
     */
    @PostMapping("findUsers")
    public ResponseEntity<List<User>> findUsers(@RequestBody User user, @RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        List<User> users = userService.findUsers(user);
        return ResponseEntity.ok(users);
    }
}
