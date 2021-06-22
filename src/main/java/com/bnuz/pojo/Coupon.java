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
 * @since 2021-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_coupon")
@ApiModel(value="Coupon对象", description="")
public class Coupon implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "优惠券主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商店id")
    private Integer shopId;

    @ApiModelProperty(value = "优惠券内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "是否可用")
    private Boolean disabled;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;


}
