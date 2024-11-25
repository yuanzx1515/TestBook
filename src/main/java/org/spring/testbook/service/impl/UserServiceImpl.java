package org.spring.testbook.service.impl;

import jakarta.annotation.Resource;
import org.spring.testbook.Mapper.UserMapper;
import org.spring.testbook.entity.account;
import org.spring.testbook.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         account account = userMapper.getUserName(username);
         if (account == null) {
             throw new UsernameNotFoundException("没密码别登录");
         }
         return User
                 .withUsername(account.getUsername())
                 .password(account.getPassword())
                 .authorities(account.getRole())
                 .build();
    }
}
