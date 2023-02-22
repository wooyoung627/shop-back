package spring.proj.shop.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.proj.shop.dto.user.JoinUserDto;
import spring.proj.shop.dto.user.LoginUserDto;
import spring.proj.shop.entity.user.User;
import spring.proj.shop.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User join(JoinUserDto userDto) {
        String password = passwordEncoder.encode(userDto.getPassword());
        User saveUser = User.builder().userId(userDto.getUserId()).password(password).role(userDto.getRole()).build();
        return userRepository.save(saveUser);
    }

    public LoginUserDto login(String userId, String password) {
        User findUser = userRepository.findByUserId(userId);

        if(findUser == null)
            throw new UsernameNotFoundException("user is not exists");

        if(!passwordEncoder.matches(password, findUser.getPassword()))
            throw new BadCredentialsException("password is not matches");

        return new LoginUserDto(findUser);
    }

}
