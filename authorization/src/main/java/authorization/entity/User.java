package authorization.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "USER")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String password;

    private String email;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Builder
    public User(String userId, String password, String email, String nickname, UserType userType) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.type = userType;
    }
}
