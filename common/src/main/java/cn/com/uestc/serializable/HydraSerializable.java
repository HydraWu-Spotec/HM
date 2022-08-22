package cn.com.uestc.serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public interface HydraSerializable {

    /**
     * LocalDateTime序列化为时间戳
     */
    class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime localDateTime, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(localDateTime.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli());
        }
    }

    /**
     * 时间戳反序列化为LocalDateTime
     */
    class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException {
            return Instant.ofEpochMilli(p.getLongValue()).atZone(OffsetDateTime.now().getOffset()).toLocalDateTime();
        }
    }
}
