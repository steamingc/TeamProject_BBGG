//package com.example.mainProject.dto;
//
//import com.example.mainProject.domain.entity.MemberEntity;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//public class MemberDto {
//    private Long id;
//    private String email;
//    private String password;
//    private String name;
//
//    private String phone;
//
//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;
//
//    public MemberEntity toEntity(){
//        return MemberEntity.builder()
//                .id(id)
//                .email(email)
//                .password(password)
//                .name(name)
//                .phone(phone)
//                .build();
//    }
//
//    @Builder
//    public MemberDto(Long id, String email, String password, String name, String phone) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.phone = phone;
//    }
//}