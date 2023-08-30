package com.winters.be.service;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.jpa.repository.MemberRepository;
import com.winters.be.db.mybatis.dao.MembersDAO;
import com.winters.be.db.mybatis.vo.MemberVO;
import com.winters.be.db.mybatis.vo.MembersVO;
import com.winters.be.dto.MemberReq;
import com.winters.be.dto.MemberRes;
import com.winters.be.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final MembersDAO memberDAO;
    private final MembersDAO membersDAO;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public ResultDto<MemberRes> register(MemberReq.Signup signup) {
        try {
            signup.setPassword(passwordEncoder.encode(signup.getPassword()));
            Optional<MemberEntity> findMember = memberRepository.findByUsername(signup.getUsername());
            if( findMember.isEmpty() ) {
                MemberEntity saveMember = MemberEntity.builder()
                        .username(signup.getUsername())
                        .password(signup.getPassword())
                        .email(signup.getEmail())
                        .role("USER")
    //                    .nickName(signup.getNickName())
    //                    .age(signup.getAge())
    //                    .phoneNumber(signup.getPhoneNumber())
    //                    .zipcode(signup.getZipcode())
    //                    .address(signup.getAddress())
    //                    .addressDetail(signup.getAddressDetail())
                        .build();
                memberRepository.save(saveMember);
                return ResultDto.ofSuccess("회원가입 성공", new MemberRes(saveMember));
            } else {
                return ResultDto.ofFail("아이디 중복");
            }
        }catch (Exception e) {
            return ResultDto.ofFail(e.getMessage());
        }
    }

    public ResultDto<MemberRes> signup(MemberReq.Signup signup) {
        signup.setPassword(passwordEncoder.encode(signup.getPassword()));
        Optional<MemberEntity> findMember = memberRepository.findByUsername(signup.getUsername());
        if( findMember.isEmpty() ) {
            MemberEntity saveMember = MemberEntity.builder()
                    .username(signup.getUsername())
                    .password(signup.getPassword())
                    .email(signup.getEmail())
                    .role("USER")
                    //                    .nickName(signup.getNickName())
                    //                    .age(signup.getAge())
                    //                    .phoneNumber(signup.getPhoneNumber())
                    //                    .zipcode(signup.getZipcode())
                    //                    .address(signup.getAddress())
                    //                    .addressDetail(signup.getAddressDetail())
                    .build();
            memberRepository.save(saveMember);
            return ResultDto.ofSuccess("회원가입 성공", new MemberRes(saveMember));
        } else {
            return ResultDto.ofFail("아이디 중복");
        }
    }

    /// jpa로 변경
    public ResultDto<MemberRes> login(String id, String pwd){
        Optional<MemberVO> loginMember = memberDAO.getLoginMember(id, pwd);
        if(loginMember.isPresent()) {
            return ResultDto.ofSuccess("로그인 성공", new MemberRes(loginMember.get()));
        }else {
            return ResultDto.ofFail("ID/Password 가 일치하지 않습니다");
        }
    }

    ////////////////Mybatis///////////////////////////////////////////////////////////////////////////////
    public MembersVO myInsertMembers(MembersVO vo) {
        membersDAO.insertMembers(vo);
        return vo;
    }

    public MembersVO myLogin(String id) {
        return membersDAO.signIn(id);
    }
}
