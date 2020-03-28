package hello.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@Configuration
@Slf4j
public class TestRedisConfiguration {

	private RedisServer redisServer;

	public TestRedisConfiguration(RedisProperties redisProperties) {
		this.redisServer = new RedisServer(redisProperties.getRedisPort());
	}

	@PostConstruct
	public void postConstruct() {
		try {
			redisServer.start();
			log.warn("A local embedded RedisServer is starting....");
		} catch (Exception e) {
			log.error(
					"Port was bloked (6370) by other process."
					+ " You can Kill the blocked port process with cmd => kill -9  $(lsof -t -i:6370)");
			e.printStackTrace();
		}
	}

	@PreDestroy
	public void preDestroy() {
		redisServer.stop();
	}
}