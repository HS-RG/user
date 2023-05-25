package com.hsrg.controller;


import com.hsrg.pojo.Collection;
import com.hsrg.pojo.Result;
import com.hsrg.service.CollectionService;
import com.hsrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService CollectionService;

    @PostMapping("/createCollection")
    public Result createCollection(@RequestBody Collection collection) {
        CollectionService.createCollection(collection);
        return Result.success();
    }

    @PostMapping("/deleteCollection")
    public Result deleteCollection(@RequestBody Collection collection) {
        CollectionService.deleteCollection(collection);
        return Result.success();
    }

}

