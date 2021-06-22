package com.bnuz.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_menu")
@ApiModel(value="Menu对象", description="")
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父菜单id")
    private Integer parentId;

    @ApiModelProperty(value = "菜单名")
    private String menuName;

    @ApiModelProperty(value = "菜单路径")
    private String url;

    @ApiModelProperty(value = "菜单icon")
    private String icon;

    @ApiModelProperty(value = "类型 0菜单 1按钮")
    private String type;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    @ApiModelProperty(value = "是否可用")
    private Boolean disabled;

    @ApiModelProperty(value = "是否展开")
    private Boolean open;


}
