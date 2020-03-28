package hello.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.entity.NotificationEntity;

public interface NotificationRepository
		extends JpaRepository<NotificationEntity, Integer>, JpaSpecificationExecutor<NotificationEntity> {

	@Query(value = "select * from notification w where title = :title", nativeQuery = true)
	List<NotificationEntity> findNotifications(@Param(value="title") String title);
}
