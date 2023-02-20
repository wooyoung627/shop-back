package spring.proj.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.proj.shop.dto.user.JoinUserDto;
import spring.proj.shop.entity.user.User;
import spring.proj.shop.service.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/un-auth")
public class UnAuthController {

    private final UserService userService;

    @PostMapping("/join")
    public User join(@RequestBody JoinUserDto userDto) {
        return userService.join(userDto);
    }

}

