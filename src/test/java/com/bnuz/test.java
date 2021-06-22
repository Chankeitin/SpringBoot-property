package com.bnuz;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnuz.dto.CommentDto;
import com.bnuz.dto.MenuDto;
import com.bnuz.mapper.CommentMapper;
import com.bnuz.mapper.TagCommentMapper;
import com.bnuz.mapper.UserMapper;
import com.bnuz.pojo.Comment;
import com.bnuz.pojo.Tag;
import com.bnuz.pojo.TagComment;
import com.bnuz.pojo.User;
import com.bnuz.service.CommentService;
import com.bnuz.service.MenuService;
import com.bnuz.service.TagService;
import com.bnuz.service.UserService;
import com.google.errorprone.annotations.Var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author Chanchitin
 * @date 2021/5/30
 */
@SpringBootTest
public class test {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TagCommentMapper tagCommentMapper;
    @Autowired
    private MenuService menuService;
    @Test
    public void testInsert(){
        User user = new User();
        user.setPassword(passwordEncoder.encode("123456"));
        user.setUsername("用户2");
        user.setNickname("用户昵称2");
        user.setDescription("password123456");
        userMapper.insert(user);
    }

    @Test
    public void testCommentList(){
        //List<CommentDto> commentDtos = commentService.queryCommentList(1);
        List<CommentDto> commentDtos = commentMapper.queryCommentList(0);
        System.out.println(commentDtos);
    }

    @Test
    public void testregister(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username","cqt1");
        User user = userService.getBaseMapper().selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testtag(){
        List<Tag> list = tagService.list();
        System.out.println(list);
    }

    //添加评论
    @Test
    public void testInsertComment(){
        Comment comment = new Comment();
        comment.setUserId(2);
        comment.setCommentAddress(true);
        comment.setComments("附近帮忙第一条");
        commentMapper.insert(comment);
        TagComment tagComment = new TagComment();
        tagComment.setCommentId(10);
        tagComment.setTagId(4);
        tagCommentMapper.insert(tagComment);
    }
//    menuService.queryMenuList();
//添加菜单
    @Test
    public void testquerymenu(){
        List<MenuDto> menuDtos = menuService.queryMenuList();
        System.out.println(menuDtos);

    }
}
