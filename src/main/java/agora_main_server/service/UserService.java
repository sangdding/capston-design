package agora_main_server.service;

import agora_main_server.dto.UserFormDto;
import agora_main_server.entity.User;
import agora_main_server.entity.UserRole;
import agora_main_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    // user 저장
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // user password 암호화
    public User createUser(UserFormDto userFormDto) {
        return User.builder()
                .userId(userFormDto.getUserId())
                .password(passwordEncoder.encode(userFormDto.getPassword()))
                .email(userFormDto.getEmail())
                .nickname(userFormDto.getNickname())
                .role(UserRole.USER).build();
    }
}
