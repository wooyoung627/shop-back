package spring.proj.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring.proj.shop.dto.user.JoinUserDto;
import spring.proj.shop.entity.user.User;
import spring.proj.shop.service.user.UserService;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommonController {

    private final UserService userService;

    @GetMapping
    public String get() {
        log.info("get test");
        return "OK";
    }

    @GetMapping("/param")
    public String param(@RequestParam String userId) {
        log.info("param test : {}", userId);
        return "OK";
    }

    @PostMapping
    public String post(@RequestParam String userId, @RequestParam String password) {
        log.info("userId : {}, password: {}", userId, password);
        return "OK";
    }

    @PostMapping("/login-test")
    public String loginTest(@RequestParam String id, @RequestParam String password) {
        System.out.println("id = " + id);
        System.out.println("password = " + password);
        return "ok";
    }

    @PostMapping("/join")
    public User join(@RequestBody JoinUserDto userDto) {
        return userService.join(userDto);
    }
}

