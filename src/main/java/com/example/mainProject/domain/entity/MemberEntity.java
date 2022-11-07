package com.example.mainProject.domain.entity;
import com.example.mainProject.domain.Board;
import com.example.mainProject.domain.Role;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Booking> bookingList = new ArrayList<>();





    @Builder
    public MemberEntity(String email, String password, String name, String phone, Role role) {
        this.email = email;
        this.password = password;
        this.name=name;
        this.phone=phone;
        this.role = role;
    }
}