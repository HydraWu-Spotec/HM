package cn.com.uestc.hm.config;

import cn.com.uestc.hm.config.handler.DateColumnMetaObjectHandler;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * mybatis配置
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        var mybatisPlusInterceptor = new MybatisPlusInterceptor();
        var paginationInnerInterceptor = new PaginationInnerInterceptor();
        //最大分页数为1000
        paginationInnerInterceptor.setMaxLimit(1000L);
        //设置数据库类型
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        mybatisPlusInterceptor.setInterceptors(Collections.singletonList(paginationInnerInterceptor));
        return mybatisPlusInterceptor;
    }

    /**
     * 实现公共字段自动维护 create_time update_time
     * @return
     */
    @Bean
    public DateColumnMetaObjectHandler dateColumnMetaObjectHandler() {
        return new DateColumnMetaObjectHandler();
    }
}
