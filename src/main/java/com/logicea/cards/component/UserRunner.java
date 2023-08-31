package com.logicea.cards.component;

import com.logicea.cards.dto.UserDto;
import com.logicea.cards.models.Roles;
import com.logicea.cards.models.Users;
import com.logicea.cards.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRunner implements CommandLineRunner {
    private final UserRepository userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        if (userService.count() > 0) {
            return;
        }

        List<UserDto> userDtoList = List.of(
                new UserDto("john@example.com", "John", "Doe", "password", Roles.USER),
                new UserDto("george@example.com", "George", "Bush", "password", Roles.USER),
                new UserDto("jomo@example.com", "Jomo", "Kenyatta", "password", Roles.USER),
                new UserDto("test@example.com", "Test", "Test1", "password", Roles.USER),
                new UserDto("admin@example.com", "Admin", "Admin", "password", Roles.ADMIN)
        );

        userDtoList.stream().forEach(userDto -> {
            try {
                Users user = new Users();
                user.setEmail(userDto.email());
                user.setSurname(userDto.surname());
                user.setFirstName(userDto.firstName());
                user.setPassword(passwordEncoder.encode(userDto.password()));
                user.setRole(userDto.role());
                user.setCreatedAt(LocalDateTime.now());
                this.userService.save(user);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
