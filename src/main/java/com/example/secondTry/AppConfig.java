package com.example.secondTry;

import com.example.secondTry.discount.DiscountPolicy;
import com.example.secondTry.discount.RateDiscountPolicy;
import com.example.secondTry.order.OrderService;
import com.example.secondTry.order.OrderServiceImpl;
import com.example.secondTry.repository.MemberRepository;
import com.example.secondTry.repository.MemoryMemberRepository;
import com.example.secondTry.service.MemberService;
import com.example.secondTry.service.MemberServiceImpl;

//애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
