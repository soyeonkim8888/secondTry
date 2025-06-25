package com.example.secondTry.member;

import com.example.secondTry.AppConfig;
import com.example.secondTry.order.Order;
import com.example.secondTry.service.MemberService;
import com.example.secondTry.service.MemberServiceImpl;
import com.example.secondTry.order.OrderService;
import com.example.secondTry.order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }


}
