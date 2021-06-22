package com.bnuz.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnuz.common.Result;
import com.bnuz.dto.CommentDto;
import com.bnuz.pojo.Comment;
import com.bnuz.pojo.TagComment;
import com.bnuz.service.CommentService;
import com.bnuz.service.TagCommentService;
import com.bnuz.util.AnonymousAccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Api(tags = "评论模块")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagCommentService tagCommentService;

    @ApiOperation(value = "获取展示评论列表")
    @GetMapping("/getCommentList")
    public Result getCommentList(@RequestParam(name = "tagId",required = false) Integer tagId){
        List<CommentDto> list = commentService.queryCommentList(tagId);
        return Result.ok().data("CommentList",list);
    }


    @ApiOperation(value = "添加帖子")
    @GetMapping("/addComment")
    public Result getCommentList(@RequestParam(name = "userId") Integer userId,
                                @RequestParam(name = "comments") String comments,
                                 @RequestParam(name = "tagId") Integer tagId,
                                 @RequestParam(name = "picture",required = false) String picture,
                                 @RequestParam(name = "address",required = false,defaultValue = "false") boolean address,
                                 @RequestParam(name = "pid",required = false,defaultValue = "0") Integer pid,
                                 @RequestParam(name = "responder",required = false,defaultValue = "0") Integer responder){
        //添加帖子
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setComments(comments);
        comment.setPicture(picture);
        comment.setCommentAddress(address);
        comment.setPid(pid);
        comment.setResponder(responder);
        commentService.getBaseMapper().insert(comment);
        //添加标签
        Integer getCommentId = commentService.queryLastCommentByUserId(userId);
        TagComment tagComment = new TagComment();
        tagComment.setTagId(tagId);
        tagComment.setCommentId(getCommentId);
        tagCommentService.getBaseMapper().insert(tagComment);
        return Result.ok().message("评论添加成功");
    }
}

