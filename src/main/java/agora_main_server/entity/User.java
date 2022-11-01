package agora_main_server.entity;

import agora_main_server.dto.UserFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;    // PK

    @Column(unique = true)
    private String userId;  // 사용자 아이디

    @Column(unique = true)
    private String email;   // 사용자 이메일

    private String password;    // 사용자 pw

    @Column(unique = true)
    private String nickname;    // 사용자 닉네임

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String userId, String email, String password, String nickname, UserRole role) {

        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        User user = User.builder()
                .userId(userFormDto.getUserId())
                .email(userFormDto.getEmail())
                .password(passwordEncoder.encode(userFormDto.getPassword()))
                .nickname(userFormDto.getNickname())
                .role(UserRole.USER)
                .build();
        return user;
    }
}
