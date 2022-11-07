package com.luma.luma.Service;

import com.luma.luma.Model.User;
import com.luma.luma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User act_user = userRepository.findByUid(username);
        if (act_user == null) throw new UsernameNotFoundException(username);
        UserDetails user = org.springframework.security.core.userdetails.User
                .withUsername(act_user.getUid()).password(act_user.getPassword()).authorities("USER").build();
        return user;
    }
}
