package com.example.jwtspringsecurity.controller;

import com.example.jwtspringsecurity.dto.BaseResponceDto;
import com.example.jwtspringsecurity.dto.UserLoginDto;
import com.example.jwtspringsecurity.service.UserService;
import com.example.jwtspringsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/auth/register")
    public BaseResponceDto registerUser(@RequestBody User newUser){
        if(userService.createUser(newUser)){
            return new BaseResponceDto("success");
        }else {
            return new BaseResponceDto("failed");
        }
    }

    @PostMapping("/api/auth/login")
    public BaseResponceDto loginUser(@RequestBody UserLoginDto loginDetails){
        if(userService.checkUserNameExists(loginDetails.getEmail())){
            if(userService.verifyUser(loginDetails.getEmail(), loginDetails.getPassword())){
                Map<String, Object> data = new HashMap<>();
                data.put("token", userService.generateToken(loginDetails.getEmail(), loginDetails.getPassword()));
                return new BaseResponceDto("success", data);
            }else {
                return new BaseResponceDto("wrong password");
            }
        }else {
            return new BaseResponceDto("user not exist");
        }
    }

    
}

