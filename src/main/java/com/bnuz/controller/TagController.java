package com.bnuz.controller;


import com.bnuz.common.Result;
import com.bnuz.pojo.Tag;
import com.bnuz.service.TagService;
import com.bnuz.util.AnonymousAccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Api(tags = "标签模块")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    //@AnonymousAccess
    @ApiOperation(value = "查询全部标签")
    @GetMapping("/allTag")
    public Result getTagList(){
        List<Tag> list = tagService.list();
        return Result.ok().data("TagList",list);
    }
}

