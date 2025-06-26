package com.example.secondTry;

import com.example.secondTry.discount.DiscountPolicy;
import com.example.secondTry.discount.RateDiscountPolicy;
import com.example.secondTry.member.Grade;
import com.example.secondTry.member.Member;
import com.example.secondTry.order.OrderService;
import com.example.secondTry.order.OrderServiceImpl;
import com.example.secondTry.repository.MemberRepository;
import com.example.secondTry.repository.MemoryMemberRepository;
import com.example.secondTry.service.MemberService;
import com.example.secondTry.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
public class AppConfig {//DI 컨테이너
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }}



