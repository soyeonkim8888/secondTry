package com.example.secondTry;

import com.example.secondTry.member.Grade;
import com.example.secondTry.member.Member;
import com.example.secondTry.order.Order;
import com.example.secondTry.order.OrderService;
import com.example.secondTry.order.OrderServiceImpl;
import com.example.secondTry.service.MemberService;
import com.example.secondTry.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService  = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);

        System.out.println("order = "+order);
        System.out.println("order.caculatePrice = "+order.calculatePrice());
    }

}
