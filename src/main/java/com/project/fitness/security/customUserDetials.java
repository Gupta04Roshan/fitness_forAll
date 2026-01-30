//package com.project.fitness.security;
//
//import com.project.fitness.Model.User;
//import com.project.fitness.Repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.jspecify.annotations.Nullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//@Service
//@RequiredArgsConstructor
////public class customUserDetials implements UserDetailsService {
////
////private final UserRepository userRepository;
////
////
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        User user = userRepository.findByEmail(email);
////        if (user==null){
////            throw new RuntimeException("User not found "+email);
////        }
////
////        return org.springframework.security.core.userdetails.User.builder()
////                .username(user.getEmail())
////                .password(user.getPassword())
////                .roles(user.getRole().name())
////                .build();
////    }
////}
