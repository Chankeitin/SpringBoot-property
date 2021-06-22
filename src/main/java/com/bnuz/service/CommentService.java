package com.bnuz.service;

import com.bnuz.dto.CommentDto;
import com.bnuz.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
public interface CommentService extends IService<Comment> {
    /**
     *查询全部评论
     */
    public List<CommentDto> queryCommentList(Integer tagId);

    /**
     *查询指定用户最后评论
     */
    public Integer queryLastCommentByUserId(Integer userId);
}
