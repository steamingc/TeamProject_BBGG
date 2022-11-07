package com.example.mainProject.domain;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_ADMIN("관리자"),
    ROLE_MEMBER("회원");

    private String value;

    Role(String value) {
        this.value = value;
    }
}