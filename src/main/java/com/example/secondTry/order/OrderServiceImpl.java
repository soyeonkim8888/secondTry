package com.example.secondTry.order;


import com.example.secondTry.discount.DiscountPolicy;
// import com.example.secondTry.discount.RateDiscountPolicy;  구현체를 할당하지 않기 때문에 더이상 필요없음
import com.example.secondTry.member.Member;
import com.example.secondTry.repository.MemberRepository;
// import com.example.secondTry.repository.MemoryMemberRepository; 구현체를 할당하지 않기 때문에 더이상 필요없음

public class OrderServiceImpl implements OrderService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemNames, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemNames, itemPrice, discountPrice);
    }
}

