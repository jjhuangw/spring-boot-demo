package hello.service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;

import hello.entity.NotificationEntity;
import hello.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Notification Service
 *
 * @author chienchang.a.huang, tianxiong.xie
 */
@Service
@AllArgsConstructor
@Slf4j(topic = "NotificationService")
public class NotificationService {

	private NotificationRepository notificationRepository;

	public void createNotification(NotificationEntity content) {
		Instant instant = Instant.now();
		content.setCreateTime(instant.atZone(ZoneId.of("Japan")));
		content.setUpdateTime(instant.atZone(ZoneId.of("Japan")));
		notificationRepository.save(content);
	}

	public List<NotificationEntity> findNotifications(String name) {
		return notificationRepository.findNotifications(name);
	}
}
