package com.example.secondTry;

import com.example.secondTry.member.Member;
import com.example.secondTry.service.MemberService;
import com.example.secondTry.service.MemberServiceImpl;
import com.example.secondTry.member.Grade;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);

        System.out.println("new member=" + member.getName());
        System.out.println("find member= "+ findmember.getName());
    }
}
