package cn.com.uestc.hm.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("管理端-角色")
public class AdminRoleVO {

    @ApiModelProperty(value = "ID", required = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    @ApiModelProperty(value = "密码", required = true)
    private String remark;

    @ApiModelProperty(value = "创建日期", required = true)
    private LocalDateTime createTime;
}
