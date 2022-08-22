package cn.com.uestc.hm.entity.pojo;

import cn.com.uestc.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理端-角色(AdminRole)实体类
 *
 * @author makejava
 * @since 2022-08-20 15:42:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("admin_role")
public class AdminRole extends BaseEntity {

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

}

