package lt.papersoda.eboz.domain.user.repository;

import lt.papersoda.eboz.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
