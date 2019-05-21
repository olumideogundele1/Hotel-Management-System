//package com.academy.hms.hms.service;
//
//import com.academy.hms.hms.entity.User;
//import com.academy.hms.hms.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//
//@Service
//@Transactional
//public class CustomUserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userRepository.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));
//
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(user));
//    }
//
//    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
//
//        String[] userRoles = user.getRoles()
//        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//
//        return authorities;
//    }
//}
