package com.bnuz.mapper;

import com.bnuz.dto.CommentDto;
import com.bnuz.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     *查询全部评论
     */
    List<CommentDto> queryCommentList(Integer tagId);
    /**
     *查询指定用户最后评论
     */
    Integer queryLastCommentByUserId(Integer userId);
}
