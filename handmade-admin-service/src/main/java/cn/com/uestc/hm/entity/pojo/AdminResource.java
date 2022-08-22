package cn.com.uestc.hm.entity.pojo;

import cn.com.uestc.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理端-权限资源(AdminResource)实体类
 *
 * @author makejava
 * @since 2022-08-20 16:28:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("admin_resource")
public class AdminResource extends BaseEntity {

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 资源分组
     */
    @TableField("`group`")
    private Integer group;

    /**
     * 资源标识
     */
    @TableField("flag_bit")
    private Integer flagBit;

    /**
     * 父级资源ID
     */
    @TableField("parent_id")
    private Long parentId;

}

