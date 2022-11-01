package agora_main_server.service;

import agora_main_server.entity.User;
import agora_main_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private UserRepository userRepository;

    // user 저장
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
