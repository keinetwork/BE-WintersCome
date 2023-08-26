package com.winters.be.service;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.jpa.repository.MemberRepository;
import com.winters.be.dto.MemberRegistReq;
import com.winters.be.dto.MemberRegistRes;
import com.winters.be.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberEntity> selectAll() {
       return memberRepository.selectAll();
    }

    public ResultDto<MemberRegistRes> register(MemberRegistReq reqMember) {
        Optional<MemberEntity> findMember = memberRepository.findByUserid(reqMember.getEmail());
        if( findMember.isEmpty() ) {
            MemberEntity saveMember = MemberEntity.builder()
                    .email(reqMember.getEmail())
                    .password(reqMember.getPassword())
                    .nickName(reqMember.getNickName())
                    .role("USER")
                    .age(reqMember.getAge())
                    .phoneNumber(reqMember.getPhoneNumber())
                    .zipcode(reqMember.getZipcode())
                    .address(reqMember.getAddress())
                    .addressDetail(reqMember.getAddressDetail())
                    .build();
            memberRepository.save(saveMember);
            return ResultDto.ofSuccess("회원가입 성공", new MemberRegistRes(saveMember));
        } else {
            return ResultDto.ofFail("이메일 중복");
        }
    }
}
