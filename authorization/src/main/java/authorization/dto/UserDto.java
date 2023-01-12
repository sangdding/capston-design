package authorization.dto;

import authorization.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    public UserDto(String userId, String password, String email, String nickname) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }
}


