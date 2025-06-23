package com.example.secondTry.service;

import com.example.secondTry.repository.MemberRepository;
import com.example.secondTry.repository.MemoryMemberRepository;
import com.example.secondTry.member.Member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
