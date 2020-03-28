package hello.repository;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import hello.entity.NotificationEntity;

@Component
public class RedisRepository {

	private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public RedisRepository(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void store(NotificationEntity entity) {
        redisTemplate.execute((RedisCallback<Long>) connection -> {
            connection.set(entity.getTitle().getBytes(), SerializationUtils.serialize(entity), Expiration.from(10, TimeUnit.MINUTES), SetOption.UPSERT);
            return 1L;
        });
    }

    public NotificationEntity get(String code) {
    	return redisTemplate.execute((RedisCallback<NotificationEntity>) connection -> {
            byte[] value = connection.get(code.getBytes());
            return value == null ? null : (NotificationEntity)SerializationUtils.deserialize(value);
        });
    }

    public NotificationEntity remove(final String code) {
        return redisTemplate.execute((RedisCallback<NotificationEntity>) connection -> {
            byte[] keyByte = code.getBytes();
            byte[] valueByte = connection.get(keyByte);

            if (valueByte != null) {
                connection.del(keyByte);
                return (NotificationEntity) SerializationUtils.deserialize(valueByte);
            }

            return null;
        });
    }
}
