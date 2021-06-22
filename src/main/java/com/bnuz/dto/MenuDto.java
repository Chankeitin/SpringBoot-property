package com.bnuz.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chanchitin
 * @date 2021/6/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Menu返回对象", description="")
public class MenuDto implements Serializable {
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

    @ApiModelProperty(value = "是否可用 0不可用 1可用")
    private Boolean disabled;

    @ApiModelProperty(value = "是否展开 0不展开 1展开")
    private Boolean open;

    @ApiModelProperty(value = "子菜单")
    private List<MenuDto> childMenus;
}