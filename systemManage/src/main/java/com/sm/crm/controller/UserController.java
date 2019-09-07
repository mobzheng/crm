package com.sm.crm.controller;

import com.sm.crm.entity.User;
import com.sm.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(User user) {
        String message = userService.findUser(user) == null ? "success" : "fail";
        return ResponseEntity.ok("success");
    }

    @GetMapping("findAllUser")
    public ResponseEntity<List<User>> findAll(){
        List<User> allUser = userService.findAllUser();
        return ResponseEntity.ok(allUser);
    }

    
}
