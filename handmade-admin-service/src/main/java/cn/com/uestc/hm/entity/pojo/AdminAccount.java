package cn.com.uestc.hm.entity.pojo;

import cn.com.uestc.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("admin_account")
@EqualsAndHashCode(callSuper = true)
public class AdminAccount extends BaseEntity {

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

}
