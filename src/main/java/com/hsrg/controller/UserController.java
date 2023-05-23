package com.hsrg.controller;


import com.hsrg.entity.Result;
import com.hsrg.entity.User;
import com.hsrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/initOneUser")
    public Result initOneUser(@RequestBody User user){
        userService.initOneUser(user);
        return Result.success();
    }

    @PostMapping("/updateOneUser")
    public Result updateOneUser(@RequestBody User user){
        userService.updateOneUser(user);
        return Result.success();
    }

    @PostMapping("/deleteOneUser")
    public Result deleteOneUser(@RequestBody User user){
        userService.deleteOneUser(user.getUserId());
        return Result.success();
    }

    @PostMapping("/selectByUserId")
    public Result selectByUserId(@RequestBody User user){
        return Result.success(userService.selectByUserId(user.getUserId()));
    }
}

