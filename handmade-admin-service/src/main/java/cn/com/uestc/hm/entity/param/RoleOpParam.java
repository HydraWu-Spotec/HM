package cn.com.uestc.hm.entity.param;

import cn.com.uestc.base.KVPair;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("管理端-角色-操作")
public class RoleOpParam {

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色备注")
    private String remark;

    @ApiModelProperty("资源位集合 key=分组 val=资源位")
    private List<KVPair<Integer, Integer>> resourceBitList;
}
