package com.example.secondTry.repository;

import com.example.secondTry.member.Member;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{
    public static Map<Long, Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
