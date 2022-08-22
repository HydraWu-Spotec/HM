package cn.com.uestc.hm.entity.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("管理端-资源树")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AdminResourceTreeVO {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "父级资源ID")
    private Long parentId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "分组标识", required = true)
    private Integer group;

    @ApiModelProperty(value = "资源位", required = true)
    private Integer flagBit;

//    @JsonBackReference
    @ApiModelProperty(value = "子集资源")
    private List<AdminResourceTreeVO> children;
}
