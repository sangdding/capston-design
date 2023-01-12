package authorization.service;


import authorization.repository.MemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class UserServiceTest {

    private final MemoryRepository memoryRepository = new MemoryRepository();
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserService userService = new UserService(memoryRepository, passwordEncoder);

    @Test
    public void passwordEncodeTest() {
        String rawPassword = "sang7952@";
        String encodedPassword = userService.encodePassword(rawPassword);
        System.out.println(encodedPassword);
        Assertions.assertNotEquals(encodedPassword, rawPassword);
    }
}