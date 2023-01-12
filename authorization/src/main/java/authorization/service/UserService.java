package authorization.service;

import authorization.dto.UserDto;
import authorization.entity.User;
import authorization.entity.UserType;
import authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void saveUser(UserDto userDto) {
        userRepository.save(User.builder().
                userId(userDto.getUserId()).
                password(encodePassword(userDto.getPassword())).
                email(userDto.getEmail()).
                nickname(userDto.getNickname()).
                userType(UserType.USER).
                build());
    }

    public boolean checkExistId(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
