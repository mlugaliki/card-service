package com.logicea.cards.services.impl;

import com.logicea.cards.dto.UserDto;
import com.logicea.cards.models.Users;
import com.logicea.cards.repositories.UserRepository;
import com.logicea.cards.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    /**
     * @param id
     */
    @Override
    public Users findById(long id) {
        return this.userRepository.getReferenceById(id);
    }

    /**
     * @param users
     * @return
     */
    @Override
    public Users save(UserDto userDto) {
        try {
            Users user = new Users();
            user.setEmail(userDto.email());
            user.setSurname(userDto.surname());
            user.setFirstName(userDto.firstName());
            //user.setPassword(passwordEncoder.encode(userDto.password()));
            user.setCreatedAt(LocalDateTime.now());
            return this.userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Users findByEmail(String email) {
        try {
            if (!ObjectUtils.isEmpty(email)) {
                return this.userRepository.findByEmail(email).orElse(null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * @return
     */
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }


}
