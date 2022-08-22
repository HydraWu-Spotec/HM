package cn.com.uestc.hm.entity.pojo;

import cn.com.uestc.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理端-角色资源匹配(AdminRoleResource)实体类
 *
 * @author makejava
 * @since 2022-08-20 19:40:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("admin_role_resource")
public class AdminRoleResource extends BaseEntity {

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 资源组标识
     */
    @TableField("resource_group")
    private Integer resourceGroup;
    /**
     * 资源计算值
     */
    @TableField("resource_bitmap")
    private Integer resourceBitmap;

}

