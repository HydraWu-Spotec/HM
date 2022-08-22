package cn.com.uestc.hm.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

public class DateColumnMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        var now = LocalDateTime.now();
        setDateField(metaObject, "createTime", now);
        setDateField(metaObject, "updateTime", now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setDateField(metaObject, "updateTime", LocalDateTime.now());
    }

    private void setDateField(MetaObject metaObject, String dateField, LocalDateTime value) {
        //验证是否有set方法
        var bol = metaObject.hasSetter(dateField);
        var obj = getFieldValByName(dateField, metaObject);
        //存在set方法并且值为空
        if (bol && obj == null) {
            setFieldValByName(dateField, value, metaObject);
        }
    }
}