package authorization.repository;

import authorization.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class MemoryRepository {

    HashMap<Long, User> repository = new HashMap<>();

    public Optional<User> findByUserId(String userId) {
        User check = null;
        for (User user : repository.values()) {
            if (user.getUserId().equals(userId)) {
                check = user;
            }
        }
        return Optional.ofNullable(check);
    }

    public void save(User user) {
        repository.put(user.getId(), user);
    }
}
