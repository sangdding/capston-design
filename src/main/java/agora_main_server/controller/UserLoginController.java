package agora_main_server.controller;

import agora_main_server.dto.UserFormDto;
import agora_main_server.entity.User;
import agora_main_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/login")
@Log4j2
public class UserLoginController {

    private final UserService userService;

    // 로그인
    @PostMapping(value = "/")
    public String login(@RequestParam String userId, String password) {
       log.info("#login page");
       return "/main";
    }

    // 회원가입
    @PostMapping(value = "/register")
    public String register(@RequestParam UserFormDto userFormDto) {
        log.info("#register page");
        userService.saveUser(userService.createUser(userFormDto));
        return "/login";
    }

}
