package com.example.mainProject.config;

import com.example.mainProject.domain.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Slf4j
@Getter @Setter
public class SecurityUser extends User {

    private MemberEntity member;

    public SecurityUser(MemberEntity member) {
        super(member.getName(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().getValue()));


        log.info("SecurityUser member.username = {}", member.getName());
        log.info("SecurityUser member.password = {}", member.getPassword());
        log.info("SecurityUser member.role = {}", member.getRole().getValue());

        this.member = member;
    }

}