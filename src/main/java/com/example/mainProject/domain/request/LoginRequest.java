package com.example.mainProject.domain.request;

import com.example.mainProject.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String username;

    private String password;

    private String email;

    private String phone;

    private Role role;
}
