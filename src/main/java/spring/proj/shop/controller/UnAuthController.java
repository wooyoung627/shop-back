package spring.proj.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring.proj.shop.dto.user.JoinUserDto;
import spring.proj.shop.entity.user.User;
import spring.proj.shop.service.user.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UnAuthController {

    private final UserService userService;

    @GetMapping
    public String test() {
        log.info("un auth test");
        return "OK";
    }

    @PostMapping("/join")
    public User join(@RequestBody JoinUserDto userDto) {
        return userService.join(userDto);
    }
}

