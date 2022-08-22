package cn.com.uestc.hm.service.impl;

import cn.com.uestc.hm.entity.pojo.AdminAccount;
import cn.com.uestc.hm.mapper.AdminAccountMapper;
import cn.com.uestc.hm.service.AdminAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountServiceImpl extends ServiceImpl<AdminAccountMapper, AdminAccount> implements AdminAccountService {
}
