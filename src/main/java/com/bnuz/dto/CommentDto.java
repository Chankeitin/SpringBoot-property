package com.bnuz.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Chanchitin
 * @date 2021/5/30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class CommentDto implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "评论主键id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty(value = "当前用户id")
    private Integer userId;

    @ApiModelProperty(value = "发帖用户id")
    private Integer pid;

    @ApiModelProperty(value = "回复对方id")
    private Integer responder;

    @ApiModelProperty(value = "评论内容")
    private String comments;

    @ApiModelProperty(value = "评论图片")
    private String picture;

    @ApiModelProperty(value = "评论地址 0:本小区 1:附近")
    private Boolean commentAddress;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "社区标签主键id")
    private Integer tagId;

    @ApiModelProperty(value = "标签名")
    private String tagName;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "回复人列表")
    private List<CommentDto> childComment;


}