package com.example.mainProject.config;

import com.example.mainProject.domain.entity.MemberEntity;
import com.example.mainProject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<MemberEntity> findMember = memberRepository.findByEmail(email);
        if (!findMember.isPresent()) throw new UsernameNotFoundException("존재하지 않는 username 입니다.");

        log.info("loadUserByUsername member.useremail = {}", email);

        return new SecurityUser(findMember.get());
    }
}