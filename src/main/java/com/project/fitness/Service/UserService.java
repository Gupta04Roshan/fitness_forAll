package com.project.fitness.Service;

import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import com.project.fitness.Repository.UserRepository;
import com.project.fitness.Dto.LoginRequest;
import com.project.fitness.Dto.RegisterRequest;
import com.project.fitness.Dto.UserResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

//import static jdk.jpackage.internal.util.CompositeProxy.build;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserResponse register(RegisterRequest registerRequest) {
        UserRole role =registerRequest.getRole()!=null?registerRequest.getRole(): UserRole.USER;
        User user= User.builder()
                .password(registerRequest.getPassword())

                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .role(role)
                .build();
//        User user= new User(null,
//                registerRequest.getEmail(),
//                registerRequest.getPassword(),
//                registerRequest.getFirstname(),
//                registerRequest.getLastname(),
//                Instant.parse("2026-01-21T07:06:03.792Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//                Instant.parse("2026-01-21T07:06:03.792Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//                List.of(),
//                List.of());
       User savedUser = userRepository.save(user);
      return mapToResponse(savedUser);
    }

    public UserResponse mapToResponse(User savedUser) {
        UserResponse response= new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstname(savedUser.getFirstname());
        response.setLastname(savedUser.getLastname());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }


}

