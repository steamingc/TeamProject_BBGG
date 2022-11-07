package com.example.mainProject.controller;

import com.example.mainProject.domain.Role;
import com.example.mainProject.domain.entity.MemberEntity;
import com.example.mainProject.domain.repository.MemberRepository;
import com.example.mainProject.domain.request.LoginRequest;
import com.example.mainProject.domain.request.RegistryRequest;
//import com.example.mainProject.dto.MemberDto;
import com.example.mainProject.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;


@Slf4j
@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;



    // 회원가입 페이지
    @GetMapping("/user/signUp")
    public String dispSignUp(Model model) {
        model.addAttribute("member", new RegistryRequest());
        return "/user/signUp";
    }

    // 회원가입 처리
    @PostMapping("/user/signUp")
    public String execSignUp(@ModelAttribute RegistryRequest registryRequest) {
        MemberEntity member = MemberEntity.builder()
                .email(registryRequest.getEmail())
                .password(passwordEncoder.encode(registryRequest.getPassword()))
                .name(registryRequest.getUsername())
                .phone(registryRequest.getPhone())
                .role(registryRequest.getRole())
                .build();
        memberRepository.save(member);

        return "redirect:/user/login";
    }

    @ModelAttribute("roles")
    public Map<String, Role> roles() {
        Map<String, Role> map = new LinkedHashMap<>();
        map.put("관리자", Role.ROLE_ADMIN);
        map.put("일반 사용자", Role.ROLE_MEMBER);
        return map;
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin(Model model) {
        model.addAttribute("member", new LoginRequest());
        return "/user/login";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 로그인 성공 페이지
    @GetMapping("/success")
    public String dispLoginResult() {
        return "/user/loginSuccess";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }




}
