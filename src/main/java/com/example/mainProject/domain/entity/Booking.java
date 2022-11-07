package com.example.mainProject.domain.entity;

import com.example.mainProject.dto.GHInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long book_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "API_ID")
    private GHInfo api;

    @Column(columnDefinition = "varchar(20) default '2022/10/26'")
    private String chkin;

    @Column(columnDefinition = "varchar(20) default '2022/10/27'")
    private String chkout;
}
