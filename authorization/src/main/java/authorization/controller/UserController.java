package authorization.controller;

import authorization.dto.ResultDto;
import authorization.dto.UserDto;
import authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입
    @PostMapping("/signUp")
    public ResultDto register(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResultDto.ofSuccess();
    }

    // 중복 id 확인
    @PostMapping("/signUp/duplicatedId")
    public ResultDto checkId(@RequestParam String userId) {
        if (userService.checkExistId(userId)) {
            return ResultDto.ofFail("이미 존재하는 ID입니다.");
        } else {
            return ResultDto.ofSuccess();
        }
    }
}
