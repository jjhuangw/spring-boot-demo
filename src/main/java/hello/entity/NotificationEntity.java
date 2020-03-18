package hello.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Data;

@Entity
@Data
@Table(name = "notification")
@Proxy(lazy = false)
public class NotificationEntity {

	@Id
	@Column(name = "notification_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer notificationId;

	@Column(name = "title", nullable = false)
	public String title;

	@Column(name = "content")
	public String content;

	@Column(name = "create_time", nullable = false)
	public Date createTime;

	@Column(name = "update_time", nullable = false)
	public Date updateTime;
}
