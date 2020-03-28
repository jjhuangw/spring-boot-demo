package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.entity.NotificationEntity;
import hello.service.RedisService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@Api(tags = "Hello API - embedded Redis")
@AllArgsConstructor
public class RedisController {

	private RedisService redisService;

	@GetMapping(path = "/notification/redis")
	public ResponseEntity<?> findNotification(@RequestParam String name) {
		return new ResponseEntity<>(redisService.findNotification(name),
				HttpStatus.OK);
	}
	
	@PostMapping(path = "/notification/redis")
	public ResponseEntity<?> savedNotification(@RequestBody NotificationEntity content) {
		redisService.createNotification(content);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
