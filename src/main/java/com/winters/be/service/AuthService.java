package com.winters.be.service;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.jpa.repository.MemberRepository;
import com.winters.be.db.mybatis.dao.MemberDAO;
import com.winters.be.db.mybatis.vo.MemberVO;
import com.winters.be.dto.MemberReq;
import com.winters.be.dto.MemberRes;
import com.winters.be.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberDAO memberDAO;
    private final MemberRepository memberRepository;


    public ResultDto<MemberRes> register(MemberReq reqMember) {
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
            return ResultDto.ofSuccess("회원가입 성공", new MemberRes(saveMember));
        } else {
            return ResultDto.ofFail("이메일 중복");
        }
    }

    public ResultDto<MemberRes> login(String id, String pwd){
        Optional<MemberVO> loginMember = memberDAO.getLoginMember(id, pwd);
        if(loginMember.isPresent()) {
            return ResultDto.ofSuccess("로그인 성공", new MemberRes(loginMember.get()));
        }else {
            return ResultDto.ofFail("ID/Password 가 일치하지 않습니다");
        }
    }
}
