package hello.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import hello.entity.NotificationEntity;
import hello.repository.NotificationRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class NotificationServiceTest {

	@Mock
	private NotificationRepository notificationRepository;
	
	@InjectMocks
	private NotificationService notebookService;
	
	@Test
	void testFindNotifications() {
		List<NotificationEntity> list = new ArrayList<NotificationEntity>();
		NotificationEntity e = new NotificationEntity();
		list.add(e);
		Mockito.when(
				notificationRepository.findNotifications("John"))
				.thenReturn(list);
		Assert.assertEquals(list.size(), notebookService.findNotifications("John").size());
	}

}
