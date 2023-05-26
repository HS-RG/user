package com.hsrg.controller;


import com.hsrg.pojo.Collection;
import com.hsrg.pojo.Result;
import com.hsrg.pojo.User;
import com.hsrg.service.CollectionService;
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
public class CollectionController {

    @Autowired
    private CollectionService CollectionService;

    @PostMapping("/user/createCollection")
    public Result createCollection(@RequestBody Collection collection) {
        CollectionService.createCollection(collection);
        return Result.success();
    }

    @PostMapping("/user/deleteCollection")
    public Result deleteCollection(@RequestBody Collection collection) {
        CollectionService.deleteCollection(collection);
        return Result.success();
    }

    @PostMapping("/user/listCollectionByUserId")
    public Result listCollectionByUserId(@RequestBody User user, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return Result.success(CollectionService.listCollectionByUserId(user.getUserId(), pageNumber, pageSize));
    }

    @PostMapping("/user/countCollectionByFile")
    public Result countCollectionByFile(@RequestBody Collection collection) {
        return Result.success(CollectionService.countCollectionByFile(collection.getFileId()));
    }
}

