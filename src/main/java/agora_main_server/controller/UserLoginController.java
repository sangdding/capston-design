package agora_main_server.controller;

import agora_main_server.dto.ResultDto;
import agora_main_server.dto.UserFormDto;
import agora_main_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Log4j2
public class UserLoginController {

    private final UserService userService;

    // 로그인
    @PostMapping(value = "/login")
    public ResultDto<Object> login(@RequestParam String userId, String password) {
       log.info("#login page");
       return ResultDto.ofSuccess();
    }

    // 회원가입
    @PostMapping(value = "/register")
    @ResponseBody
    public ResultDto<Object> register(@RequestBody UserFormDto userFormDto) {
        log.info("#register page");
        try {
            userService.saveUser(userService.createUser(userFormDto));
            return ResultDto.ofSuccess();
        } catch (Exception e) {
            return ResultDto.ofFail(e.getMessage());
        }
    }
}
