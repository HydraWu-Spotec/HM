package cn.com.uestc.hm.service.impl;

import cn.com.uestc.base.KVPair;
import cn.com.uestc.hm.entity.param.RoleOpParam;
import cn.com.uestc.hm.entity.pojo.AdminRole;
import cn.com.uestc.hm.entity.pojo.AdminRoleResource;
import cn.com.uestc.hm.entity.vo.AdminRoleDetailVO;
import cn.com.uestc.hm.mapper.AdminRoleMapper;
import cn.com.uestc.hm.mapper.AdminRoleResourceMapper;
import cn.com.uestc.hm.service.AdminRoleService;
import cn.com.uestc.utils.BinSearchUtil;
import cn.com.uestc.utils.ListOptionalUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

    private final AdminRoleResourceMapper adminRoleResourceMapper;

    /**
     * 添加角色
     * @param roleOpParam
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRole(RoleOpParam roleOpParam) {
//        主表插入
        var adminRole = BeanUtil.toBean(roleOpParam, AdminRole.class);
        baseMapper.insert(adminRole);

//        资源填充
        fillResource(adminRole.getId(), roleOpParam.getResourceBitList());
    }

    /**
     * 角色修改
     * @param id
     * @param roleOpParam
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void modifyRole(Long id, RoleOpParam roleOpParam) {
//        主表修改
        var adminRole = BeanUtil.toBean(roleOpParam, AdminRole.class);
        adminRole.setId(id);
        baseMapper.updateById(adminRole);

//        移除权限
        ChainWrappers.lambdaUpdateChain(adminRoleResourceMapper).eq(AdminRoleResource::getRoleId, id).remove();

//        重新填充权限
        fillResource(id, roleOpParam.getResourceBitList());
    }

    /**
     * 角色详情
     * @param id
     * @return
     */
    @Override
    public AdminRoleDetailVO detail(Long id) {
//        主表查询
        var adminRole = baseMapper.selectById(id);
        var adminRoleDetailVO = BeanUtil.toBean(adminRole, AdminRoleDetailVO.class);
//        资源表查询
        var resourceList = ChainWrappers.lambdaQueryChain(adminRoleResourceMapper).eq(AdminRoleResource::getRoleId, id).list();
        List<KVPair<Integer, Integer>> resourceBitList = new LinkedList<>();
        ListOptionalUtil.ofNull(resourceList, list ->
            resourceList.forEach(item -> {
                var resourceBitmap = item.getResourceBitmap();
//                二分查找,找到二进数的长度,作为循环次数
                for (int i = 0; i < BinSearchUtil.intLength(resourceBitmap); i++) {
//                    根据长度遍历,当前位是否为1,为1则当前bit权限有效,返回位
                    if ((resourceBitmap & 1 << i) == 1 << i) {
                        KVPair<Integer, Integer> resourceKVPair = new KVPair<>();
                        resourceKVPair.setKey(item.getResourceGroup());
                        resourceKVPair.setVal(i + 1);
                        resourceBitList.add(resourceKVPair);
                    }
                }
            })
        );
        adminRoleDetailVO.setResourceBitList(resourceBitList);
        return adminRoleDetailVO;
    }

    /**
     * 填充角色和资源绑定数据
     * @param id 角色ID
     * @param resourceBitList 资源位集合
     */
    private void fillResource(Long id, List<KVPair<Integer, Integer>> resourceBitList) {
//        相同组封装到同一个list map key=组 val=资源位
        var collect = resourceBitList.stream().collect(Collectors.groupingBy(KVPair::getKey));
        var bit = new AtomicInteger(0);

        var adminRoleResource = new AdminRoleResource();
        adminRoleResource.setRoleId(id);
        collect.forEach((k, val) -> {
//            计算当前组的资源值
            val.forEach(v -> bit.updateAndGet(v1 -> v1 | 1 << (v.getVal() - 1)));

//            资源插入
            adminRoleResource.setResourceGroup(k);
            adminRoleResource.setResourceBitmap(bit.get());
            adminRoleResourceMapper.insert(adminRoleResource);
        });
    }

}
