package com.bnuz.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chanchitin
 * @date 2021/6/2
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User列表返回对象", description="")
public class UserListDto implements Serializable {
    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "权限")
    private String auth;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "个人简介")
    private String introduction;

    @ApiModelProperty(value = "逻辑删除 0:存在 1:已删")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty(value = "ip地址")
    private String ipAddress;

    @ApiModelProperty(value = "ip定位")
    private String ipPosition;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date lastLoginTime;
}