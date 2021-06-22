package com.bnuz.service.impl;

import com.bnuz.dto.CommentDto;
import com.bnuz.pojo.Comment;
import com.bnuz.mapper.CommentMapper;
import com.bnuz.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentDto> queryCommentList(Integer tagId) {
        //查询所有评论
        List<CommentDto> list = commentMapper.queryCommentList(tagId);
        //一级评论数组
        List<CommentDto> rootlist = new ArrayList<>();
        for (CommentDto commentDto : list) {
            if(commentDto.getPid().equals(0)){
                //找到根节点菜单的时候，寻找子菜单
                findChild(commentDto,list);
                //添加到根节点的列表
                rootlist.add(commentDto);
            }
        }
        return rootlist;
    }

    @Override
    public Integer queryLastCommentByUserId(Integer userId) {
        return commentMapper.queryLastCommentByUserId(userId);
    }

    private void findChild(CommentDto commentDto, List<CommentDto> list) {
        ArrayList<CommentDto> childComments = new ArrayList<>();
        for (CommentDto comment : list) {
            if(commentDto.getCommentId().equals(comment.getPid()))
                childComments.add(comment);

        }
        //子节点不存在直接返回
        if(childComments.size()==0)
            return;
        //设置父节点的子节点列表
        commentDto.setChildComment(childComments);
    }
}
