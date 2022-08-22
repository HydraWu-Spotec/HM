package cn.com.uestc.hm;

import cn.com.uestc.base.BaseEntity;
import cn.com.uestc.hm.entity.pojo.AdminResource;
import cn.com.uestc.hm.entity.pojo.AdminRole;
import cn.com.uestc.hm.service.AdminResourceService;
import cn.com.uestc.hm.service.AdminRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("dev")
public class RoleTest {

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AdminResourceService adminResourceService;


    @Test
    void list() {
        List<AdminRole> list = adminRoleService.lambdaQuery().eq(BaseEntity::getId, 100L).list();
    }

    @Test
    void create() {

        for (int i = 1; i <= 64; i++) {
            var adminResource = new AdminResource();
            adminResource.setName("Resource " + i);
            adminResource.setGroup((i / 31) + 1);
            adminResource.setFlagBit((i % 31));
            adminResourceService.save(adminResource);
        }
    }
}
