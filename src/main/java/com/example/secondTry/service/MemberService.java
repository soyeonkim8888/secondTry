package com.example.secondTry.service;

import com.example.secondTry.member.Member;


public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
