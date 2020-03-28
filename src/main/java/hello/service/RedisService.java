package hello.service;

import java.time.Instant;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import hello.entity.NotificationEntity;
import hello.repository.RedisRepository;
import lombok.AllArgsConstructor;

/**
 * Notification Service
 *
 * @author chienchang.a.huang, tianxiong.xie
 */
@Service
@AllArgsConstructor
public class RedisService {

	private RedisRepository redisRepository;

	public void createNotification(NotificationEntity content) {
		Instant instant = Instant.now();
		content.setCreateTime(instant.atZone(ZoneId.of("Japan")));
		content.setUpdateTime(instant.atZone(ZoneId.of("Japan")));
		redisRepository.store(content);
	}

	public NotificationEntity findNotification(String title) {
		return redisRepository.get(title);
	}
	
	public void removeNotification(String title) {
		redisRepository.remove(title);
	}
}
