package draft1.TheArenaApp1.repository.jparepository;

import draft1.TheArenaApp1.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository <User,Integer> {

    Optional<User> findUserByUsername(String username);
    List<User> findUsersByEmail(String email);
    List<User> findUsersByUsername(String username);

}