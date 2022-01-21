package engineer.saylee.BOOKMYTICKET.repository;

import engineer.saylee.BOOKMYTICKET.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
