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
 * @since 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_tag_comment")
@ApiModel(value="TagComment对象", description="")
public class TagComment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标签评论主键id")
    @TableId(value = "tag_comment_id", type = IdType.AUTO)
    private Integer tagCommentId;

    @ApiModelProperty(value = "标签id")
    private Integer tagId;

    @ApiModelProperty(value = "评论id")
    private Integer commentId;


}
