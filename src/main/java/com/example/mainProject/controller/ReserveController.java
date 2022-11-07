package com.example.mainProject.controller;

import com.example.mainProject.config.SecurityUser;
import com.example.mainProject.domain.Board;
import com.example.mainProject.domain.entity.Booking;
import com.example.mainProject.domain.entity.MemberEntity;
import com.example.mainProject.domain.repository.BookingRepository;
import com.example.mainProject.domain.request.LoginRequest;
import com.example.mainProject.dto.GHInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class ReserveController {
    @Autowired
    BookingRepository bookingRepository;


    // 예약하기 버튼
//    @Transactional
//    @GetMapping("/user/reserve")
//    public String userreserve(@AuthenticationPrincipal SecurityUser principal, Model model, GHInfo ghInfo) {
//
//            //로그인 안했으면 로그인해라
//        if (principal == null) {
//            model.addAttribute("member", new LoginRequest());
//            return "/user/login";
//
//            //로그인 되어 있다면
//        } else {
//            Booking booking = new Booking();
//
//            MemberEntity member = principal.getMember();
//            booking.setMember(member);
//            booking.setApi(ghInfo);
//
//
//
//            ghInfo.getBookingList().add(booking);
//            member.getBookingList().add(booking);
//
//            bookingRepository.save(booking);
//
//            log.info("booking.setApi(ghInfo) = {}", booking.getApi().getSMM_NAME());
//
//            model.addAttribute("principal", principal.getMember());
////            model.addAttribute("role", principal.getMember().getRole().getValue());
//
//            return "/reservationSuccess";
//        }
//    }


    @Transactional
    @GetMapping ("/reserve")
    public String userreserve(@AuthenticationPrincipal SecurityUser principal, Model model, GHInfo ghInfo) {

        //로그인 안했으면 로그인해라
        if (principal == null) {
            model.addAttribute("member", new LoginRequest());
            return "/user/login";

            //로그인 되어 있다면
        } else {
            Booking booking = new Booking();

            MemberEntity member = principal.getMember();
            booking.setMember(member);
            booking.setApi(ghInfo);

//            booking.setChkin("2022/10/26");
//            booking.setChkout("2022/10/27");


            ghInfo.getBookingList().add(booking);
            member.getBookingList().add(booking);

            bookingRepository.save(booking);

            log.info("booking.setApi(ghInfo).getSMM_NAME = {}", booking.getApi().getSMM_NAME());

            model.addAttribute("principal", principal.getMember());
//            model.addAttribute("role", principal.getMember().getRole().getValue());

            return "/reservationSuccess";
        }
    }

}