package hello.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.ApplicationServlet;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationServlet.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class NotificationRepositoryTest {
	
	@Autowired
    private NotificationRepository notificationRepository;
	
	@Test
	void testFindNotifications() {
		Assert.assertEquals(1, notificationRepository.findNotifications("hello spring boot").size());
	}

}
