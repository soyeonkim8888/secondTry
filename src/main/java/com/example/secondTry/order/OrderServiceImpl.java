package com.example.secondTry.order;


import com.example.secondTry.discount.DiscountPolicy;
import com.example.secondTry.discount.FixDiscountPolicy;
import com.example.secondTry.member.Member;
import com.example.secondTry.repository.MemberRepository;
import com.example.secondTry.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemNames, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemNames, itemPrice, discountPrice);
    }
}

