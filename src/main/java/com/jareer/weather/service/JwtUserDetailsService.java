package com.jareer.weather.service;

import com.jareer.weather.entity.User;
import com.jareer.weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository usersRepo;


    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found."));
    }
//        if (user.isPresent()) {
//            User appUser = user.get();
//            if(appUser.getEmail().equals(email)){
//                appUser.setId(appUser.getId());
//                usersRepo.save(appUser);
//                return new User(appUser.getId(), appUser.getEmail(), appUser.getPassword());
//            }
//        }
//        throw new UsernameNotFoundException("Email "+email+" not found.");
//    }
}
