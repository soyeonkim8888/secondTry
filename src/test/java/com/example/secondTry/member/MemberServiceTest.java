package com.example.secondTry.member;

import com.example.secondTry.AppConfig;
import com.example.secondTry.service.MemberService;
import com.example.secondTry.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "byebye", Grade.VIP);

        //when
        memberService.join(member);

        //then
        Member member1 = memberService.findMember(1L);
        assertThat(member).isEqualTo(member1);
    }
}
