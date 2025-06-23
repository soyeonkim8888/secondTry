package com.example.secondTry.discount;

import com.example.secondTry.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
