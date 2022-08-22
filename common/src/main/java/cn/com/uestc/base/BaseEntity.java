package cn.com.uestc.base;

import cn.com.uestc.serializable.HydraSerializable;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonSerialize(using = HydraSerializable.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = HydraSerializable.LocalDateTimeDeserializer.class)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonSerialize(using = HydraSerializable.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = HydraSerializable.LocalDateTimeDeserializer.class)
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
