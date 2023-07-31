package com.winters.be.service;

import com.winters.be.db.entity.MemberEntity;
import com.winters.be.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberEntity> selectAll() {
       return memberRepository.selectAll();
    }
}
