package com.example.secondTry.discount;

import com.example.secondTry.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.secondTry.service.MemberService;
// import com.example.secondTry.service.MemberServiceImpl; Appconfig 구현으로 필요없음
import com.example.secondTry.order.OrderService;
//import com.example.secondTry.order.OrderServiceImpl; Appconfig 구현으로 필요없음
import com.example.secondTry.member.Member;
import com.example.secondTry.member.Grade;

class RateDiscountPolicyTest {
    //MemberService memberService = new MemberServiceImpl(); Appconfig 구현으로 필요없음
    //OrderService orderService = new OrderServiceImpl(); Appconfig 구현으로 필요없음
    //RateDiscountPolicy discountPolicy = new RateDiscountPolicy(); Appconfig 구현으로 필요없음

    MemberService memberService;
    OrderService orderService;
    DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않습니다.")
    void vip_x(){
        //given
        Long memberId = 2L;
        Member member = new Member(memberId, "memberB", Grade.Basic);
        memberService.join(member);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}