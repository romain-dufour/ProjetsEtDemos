package com.m2ibank.controller;




import com.m2ibank.dto.BaseResponseDto;
import com.m2ibank.dto.UserLoginDto;
import com.m2ibank.model.User;
import com.m2ibank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/api/auth/register")
    public BaseResponseDto registerUser(@RequestBody User newUser){
        if(userService.createUser(newUser)){
            return new BaseResponseDto("success");
        }else {
            return new BaseResponseDto("failed");
        }
    }

    @PostMapping("/api/auth/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto loginDetails){
        if(userService.checkUserNameExists(loginDetails.getEmail())){
            if(userService.verifyUser(loginDetails.getEmail(), loginDetails.getPassword())){
                Map<String, Object> data = new HashMap<>();
                data.put("token", userService.generateToken(loginDetails.getEmail(), loginDetails.getPassword()));
                return new BaseResponseDto("success", data);
            }else {
                return new BaseResponseDto("wrong password");
            }
        }else {
            return new BaseResponseDto("user not exist");
        }
    }


}


