package cn.com.uestc.hm.controller;

import cn.com.uestc.base.ApiResult;
import cn.com.uestc.base.PageRequest;
import cn.com.uestc.base.PageVO;
import cn.com.uestc.hm.entity.pojo.AdminAccount;
import cn.com.uestc.hm.entity.vo.AdminAccountVO;
import cn.com.uestc.hm.service.AdminAccountService;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理端用户
 */
@Api(tags = {"Admin User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/account")
public class AdminAccountController {

    private final AdminAccountService adminAccountService;

    @ApiOperation("管理端-用户分页")
    @GetMapping("/page")
    public ApiResult<PageVO<AdminAccountVO>> adminAccountPage(PageRequest pageRequest) {
        return ApiResult.okParamResult(
                () -> new Page<AdminAccount>(pageRequest.getPage(), pageRequest.getSize()),
                page -> {
                    adminAccountService.page(page);
                    return page;
                },
                result -> PageVO.of(result.getCurrent(),
                        result.getSize(),
                        BeanUtil.copyToList(result.getRecords(), AdminAccountVO.class))
        );
    }
}
