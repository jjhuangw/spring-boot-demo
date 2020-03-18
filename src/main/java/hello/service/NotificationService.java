package hello.service;

import java.util.Date;
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
@Slf4j(topic = "NotificationServiceNotificationService")
public class NotificationService {

	private NotificationRepository notificationRepository;

	public void createNotification(String title, String content) {
		NotificationEntity entity = new NotificationEntity();
		entity.setTitle(title);
		entity.setContent(content);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		notificationRepository.save(entity);
	}

	public List<NotificationEntity> findNotifications(String name) {
		log.info("hello " + name);
		createNotification("test_1", "hello 1");
		createNotification("test_2", "hello 2");
		createNotification("test_3", "hello 3");
		return notificationRepository.findNotifications();
	}
}
