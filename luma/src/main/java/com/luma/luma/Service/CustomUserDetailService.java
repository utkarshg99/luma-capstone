package com.luma.luma.Service;

import com.luma.luma.Model.User;
import com.luma.luma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> o_user = userRepository.findById(username);
        if(o_user.isEmpty()) throw new UsernameNotFoundException(username);
        final User act_user = o_user.get();
        UserDetails user = org.springframework.security.core.userdetails.User
                .withUsername(act_user.getUid()).password(act_user.getPassword()).authorities("USER").build();
        return user;
    }
}
