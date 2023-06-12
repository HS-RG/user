package com.hsrg.controller;


import com.hsrg.clients.FileClient;
import com.hsrg.pojo.Result;
import com.hsrg.pojo.User;
import com.hsrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FileClient fileClient;


    @PostMapping("/initOneUser")
    public Result initOneUser(@RequestBody User user){
        userService.initOneUser(user);
        return Result.success();
    }

    @PostMapping("/user/updateOneUser")
    public Result updateOneUser(Long userId, String nickname, MultipartFile image){
        User user = new User();
        user.setUserId(userId);
        user.setNickname(nickname);
        user.setUpdateTime(LocalDateTime.now());
        if(!image.isEmpty()){
            user.setImageUrl(fileClient.uploadImage(image).getData().toString());
        }
        userService.updateOneUser(user);
        return Result.success();
    }

    @PostMapping("/deleteOneUser")
    public Result deleteOneUser(@RequestBody User user){
        userService.deleteOneUser(user.getUserId());
        return Result.success();
    }

    @PostMapping("/user/selectByUserId")
    public Result selectByUserId(@RequestBody User user){
        return Result.success(userService.selectByUserId(user.getUserId()));
    }


    //之后需要改进为pageBean减少搜索次数
    //使用通配符搜索
    @PostMapping("/user/listByNickname")
    public Result listByNickname(@RequestParam(required = false) String nickname,@RequestParam Integer pageNumber,@RequestParam Integer pageSize) {
        return Result.success(userService.listByNickname(nickname ,pageNumber ,pageSize));
    }

    @PostMapping("/user/getMyDetail")
    public Result getMyDetail(@RequestHeader("Authorization") String jwt){
        return Result.success(userService.getMyDetail(jwt));
    }

}

