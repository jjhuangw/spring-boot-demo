package hello.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.entity.NotificationEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisRepositoryTest {
	
	@Autowired
	private RedisRepository redisRepository;
	  
	@Test
	void testFindNotification() {
		NotificationEntity entity = new NotificationEntity();
		entity.setTitle("test");
		redisRepository.store(entity);
		Assert.assertEquals(entity.title, redisRepository.get(entity.title).title);
	}
}
