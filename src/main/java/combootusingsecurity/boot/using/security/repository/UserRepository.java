package combootusingsecurity.boot.using.security.repository;

import combootusingsecurity.boot.using.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
