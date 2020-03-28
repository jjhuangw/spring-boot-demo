package hello.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "notification")
@Proxy(lazy = false)
public class NotificationEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "notification_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer notificationId;

	@Column(name = "title", nullable = false)
	public String title;

	@Column(name = "content")
	public String content;

	@Column(name = "create_time", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public ZonedDateTime createTime;

	@Column(name = "update_time", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public ZonedDateTime updateTime;
}
