package com.example.mainProject.controller;

import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.config.SecurityUser;
import com.example.mainProject.domain.Board;
import com.example.mainProject.domain.entity.Booking;
import com.example.mainProject.dto.GHInfo;
import com.example.mainProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ForumController {
    MemberService memberService;

    // 내 정보 페이지
//    @GetMapping("/profile")
//    public String profile(){
//
//        return "/user/users-profile";
//    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal SecurityUser principal, Model model) {
        if (principal != null) {
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getValue());

            if(principal.getMember().getBookingList().size() != 0) {
                Booking booking = principal.getMember().getBookingList().get(0);
                GHInfo ghInfo = booking.getApi();

                String message1 = "예약 번호 : [20221026?"+booking.getBook_id()+"]";
                model.addAttribute("message", message1);


                String message2 = "숙소명 : " + ghInfo.getSMM_NAME();
                model.addAttribute("message2", message2);

                String message3 = "체크인 - 체크아웃 : 2022/10/26 - 2022/10/27";
                model.addAttribute("message3", message3);
            } else {
                model.addAttribute("message", "예약 내역이 없습니다.");
            }

        }
        return "/user/users-profile";

    }

    @GetMapping("/getBoardList")
    public String getBoardList(@AuthenticationPrincipal SecurityUser principal, Model model,  Board board) {
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);

        if (principal != null) {
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getValue());

            if(principal.getMember().getBookingList().size() != 0) {
                Booking booking = principal.getMember().getBookingList().get(0);
                GHInfo ghInfo = booking.getApi();

                String message1 = "예약 번호 : [20221026?"+booking.getBook_id()+"]";
                model.addAttribute("message", message1);


                String message2 = "숙소명 : " + ghInfo.getSMM_NAME();
                model.addAttribute("message2", message2);

                String message3 = "체크인 - 체크아웃 : 2022/10/26 - 2022/10/27";
                model.addAttribute("message3", message3);
            } else {
                model.addAttribute("message", "예약 내역이 없습니다.");
            }

        }
        return "getBoardList";
    }


    //회원 정보 수정
//    @PostMapping("/updateMember")
//    public String updateMember(@AuthenticationPrincipal SecurityUser principal) throws Exception {
//        //기존 회원 담아오기
//        MemberEntity member = principal.getMember();
//        MemberEntity memberTemp = memberService.memberView(member);
//
//        //기존에 있던 내용을 새오운 내용으로 덮어씌운다.
//        memberTemp.setName(member.getName());
//        memberTemp.setPhone(member.getPhone());
//
//        memberService.updateMember(memberTemp);
//
//        return "redirect:/user/users-profile";
//    }


    // 내 정보
    @GetMapping("/user/connection")
    public String profileConnection(){

        return "/user/users-connection";
    }

    // 비밀번호 변경
    @GetMapping("/passwordChange")
    public String passwordChange(){

        return "/user/users-passwordChange";
    }



}
