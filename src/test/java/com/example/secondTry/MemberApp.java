package com.example.secondTry;

import com.example.secondTry.member.Grade;
import com.example.secondTry.member.Member;
import com.example.secondTry.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //MemberService memberService = new MemberServiceImpl();
        // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);

        System.out.println("new member=" + member.getName());
        System.out.println("find member= "+ findmember.getName());
    }
}
