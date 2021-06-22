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
@TableName("t_store")
@ApiModel(value="Store对象", description="")
public class Store implements Serializable {

    private static final long serialVersionUID=1L;

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


}
