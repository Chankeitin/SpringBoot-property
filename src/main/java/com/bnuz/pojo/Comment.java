package com.bnuz.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

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


}
