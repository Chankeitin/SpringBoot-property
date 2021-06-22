package com.bnuz.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bnuz.pojo.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author Chanchitin
 * @date 2021/6/9
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Coupon列表返回对象", description="")
public class CouponDto {

    @ApiModelProperty(value = "商家主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商家名字")
    private String storeName;

    @ApiModelProperty(value = "商家头像")
    private String avatar;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "优惠券子集")
    private List<Coupon> CouponChild;

}
