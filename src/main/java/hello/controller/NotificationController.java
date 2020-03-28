package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.service.NotificationService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@Api(tags = "Hello API - embedded DB")
@AllArgsConstructor
public class NotificationController {

	private NotificationService notificationService;

	@GetMapping(path = "/notification/h2")
	public ResponseEntity<?> findNotification(@RequestParam String name) {
		return new ResponseEntity<>(notificationService.findNotifications(name),
				HttpStatus.OK);
	}
}
