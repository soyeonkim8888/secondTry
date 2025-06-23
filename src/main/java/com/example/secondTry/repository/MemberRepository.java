package com.example.secondTry.repository;

import com.example.secondTry.member.Member;


public interface MemberRepository {
    Member save(Member member);
    Member findById(Long memberId);
}
