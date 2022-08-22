package cn.com.uestc.hm;

import cn.com.uestc.base.BaseEntity;
import cn.com.uestc.hm.entity.pojo.AdminRole;
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

    @Test
    void list() {
        List<AdminRole> list = adminRoleService.lambdaQuery().eq(BaseEntity::getId, 100L).list();
    }
}
