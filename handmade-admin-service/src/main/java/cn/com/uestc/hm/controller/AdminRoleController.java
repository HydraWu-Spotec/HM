package cn.com.uestc.hm.controller;

import cn.com.uestc.base.ApiResult;
import cn.com.uestc.base.PageRequest;
import cn.com.uestc.base.PageVO;
import cn.com.uestc.hm.entity.param.RoleOpParam;
import cn.com.uestc.hm.entity.pojo.AdminRole;
import cn.com.uestc.hm.entity.vo.AdminRoleDetailVO;
import cn.com.uestc.hm.entity.vo.AdminRoleVO;
import cn.com.uestc.hm.service.AdminRoleService;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

/**
 * 管理端角色
 */
@Api(tags = {"Admin Role"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {

    private final AdminRoleService adminRoleService;

    @ApiOperation("管理端-角色分页")
    @GetMapping("/page")
    public ApiResult<PageVO<AdminRoleVO>> adminAccountPage(PageRequest pageRequest) {
        return ApiResult.okParamResult(
                () -> new Page<AdminRole>(pageRequest.getPage(), pageRequest.getSize()),
                page -> {
                    adminRoleService.page(page);
                    return page;
                },
                result -> PageVO.of(result.getCurrent(),
                        result.getSize(),
                        BeanUtil.copyToList(result.getRecords(), AdminRoleVO.class))
        );
    }

    @ApiOperation("管理端-角色新增")
    @PostMapping("/add")
    public ApiResult<Void> addRole(@RequestBody RoleOpParam roleOpParam) {
        return ApiResult.ok(() -> adminRoleService.addRole(roleOpParam));
    }

    @ApiOperation("管理端-角色修改")
    @PutMapping("/modify/{id}")
    public ApiResult<Void> modifyRole(@PathVariable Long id, @RequestBody RoleOpParam roleOpParam) {
        return ApiResult.ok(() -> adminRoleService.modifyRole(id, roleOpParam));
    }

    @ApiOperation("管理端-角色详情")
    @GetMapping("/detail/{id}")
    public ApiResult<AdminRoleDetailVO> detail(@PathVariable Long id) {
        return ApiResult.okResult(
                () -> adminRoleService.detail(id),
                Function.identity());
    }

}
