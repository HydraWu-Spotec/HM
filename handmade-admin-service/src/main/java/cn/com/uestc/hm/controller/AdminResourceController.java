package cn.com.uestc.hm.controller;

import cn.com.uestc.base.ApiResult;
import cn.com.uestc.hm.entity.pojo.AdminResource;
import cn.com.uestc.hm.entity.vo.AdminResourceTreeVO;
import cn.com.uestc.hm.service.AdminResourceService;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 管理端权限资源
 */
@Api(tags = {"Admin Resource"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/resource")
public class AdminResourceController {

    private final AdminResourceService adminResourceService;

    @ApiOperation("管理端-资源树")
    @GetMapping("/tree")
    public ApiResult<List<AdminResourceTreeVO>> adminResourceTree() {
        return ApiResult.okResult(
                adminResourceService::list,
                list -> {
//                    po转vo,转换后填充默认children,封装到Map
                    var resourceMap = list.stream().map(item -> {
                        var adminResourceTreeVO = BeanUtil.toBean(item, AdminResourceTreeVO.class);
                        adminResourceTreeVO.setChildren(new LinkedList<>());
                        return adminResourceTreeVO;
                    }).collect(Collectors.toMap(AdminResourceTreeVO::getId, Function.identity()));

//                    遍历map,为每个元素匹配父级
                    resourceMap.forEach((k, val) ->
                        Optional.ofNullable(val.getParentId()).ifPresent(item -> resourceMap.get(val.getParentId()).getChildren().add(val))
                    );

//                    返回处理,筛除子集对象
                    return resourceMap.values().stream().filter(i -> Objects.isNull(i.getParentId())).collect(Collectors.toList());
                }
        );
    }

}
