package cn.com.uestc.hm.entity.vo;

import cn.com.uestc.base.KVPair;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("管理端-角色详情")
public class AdminRoleDetailVO {

    @ApiModelProperty(value = "ID", required = true)
    private Long id;

    @ApiModelProperty(value = "角色名称", required = true)
    private String name;

    @ApiModelProperty(value = "角色备注")
    private String remark;

    @ApiModelProperty(value = "资源集合", required = true)
    private List<KVPair<Integer, Integer>> resourceBitList;
}
