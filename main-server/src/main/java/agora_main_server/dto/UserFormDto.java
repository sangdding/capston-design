package agora_main_server.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class UserFormDto {

    @NotBlank(message = "ID는 필수 입력 값입니다.")
    private String userId;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String nickname;

    @Builder
    public UserFormDto(String userId, String email, String password, String nickname) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
