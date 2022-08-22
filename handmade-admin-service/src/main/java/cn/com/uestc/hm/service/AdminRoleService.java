package cn.com.uestc.hm.service;

import cn.com.uestc.hm.entity.param.RoleOpParam;
import cn.com.uestc.hm.entity.pojo.AdminRole;
import cn.com.uestc.hm.entity.vo.AdminRoleDetailVO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AdminRoleService extends IService<AdminRole> {

    /**
     * 添加角色
     * @param roleOpParam
     */
    void addRole(RoleOpParam roleOpParam);

    /**
     * 角色修改
     * @param id
     * @param roleOpParam
     */
    void modifyRole(Long id, RoleOpParam roleOpParam);

    /**
     * 角色详情
     * @param id
     * @return
     */
    AdminRoleDetailVO detail(Long id);
}
