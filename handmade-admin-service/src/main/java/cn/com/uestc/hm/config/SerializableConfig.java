package cn.com.uestc.hm.config;

import cn.com.uestc.serializable.HydraSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

/**
 * 全局序列化配置
 */
@Configuration
public class SerializableConfig {

    @Bean
    @Primary
    public ObjectMapper hydraObjectMapper() {
        var objectMapper = new ObjectMapper();

        var javaTimeModule = new JavaTimeModule();
//        LDT的序列化与反序列化
        javaTimeModule.addSerializer(LocalDateTime.class, new HydraSerializable.LocalDateTimeSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new HydraSerializable.LocalDateTimeDeserializer());

        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

}
