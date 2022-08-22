package cn.com.uestc.hm.service.impl;

import cn.com.uestc.hm.entity.pojo.AdminResource;
import cn.com.uestc.hm.entity.vo.AdminResourceTreeVO;
import cn.com.uestc.hm.mapper.AdminResourceMapper;
import cn.com.uestc.hm.service.AdminResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminResourceServiceImpl extends ServiceImpl<AdminResourceMapper, AdminResource> implements AdminResourceService {


}
