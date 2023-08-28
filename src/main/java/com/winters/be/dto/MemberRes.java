package com.winters.be.dto;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.mybatis.vo.MemberVO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Schema(description = "멤버생성 응답정보")
public class MemberRes {
    @NotNull(message="아이디는 필수 입력값입니다")
    @Schema(description = "아이디", example = "stive", required = true)
    private String username;
    @NotNull(message="아이디는 필수 입력값입니다")
    @Schema(description = "닉네임", example = "stive", required = true)
    private String nickName;
    @Email
    @NotNull(message="이메일 형식에 맞게 입력하세요")
    @Schema(description = "이메일", required = true)
    private String email;
    @Min(value=10, message="나이는 최소 10살 이상입니다")
    private Integer age;
    @Parameter
    private String phoneNumber;
    @Parameter
    private String zipcode;
    @Parameter
    private String address;
    @Parameter
    private String addressDetail;
    public MemberRes(MemberEntity memberEntity) {
        this.username = memberEntity.getUsername();
        this.email = memberEntity.getEmail();
        this.nickName = memberEntity.getNickName();
        this.age = memberEntity.getAge();
        this.phoneNumber = memberEntity.getPhoneNumber();
        this.zipcode = memberEntity.getZipcode();
        this.address = memberEntity.getAddress();
        this.addressDetail = memberEntity.getAddressDetail();
    }
    public MemberRes(MemberVO memberVO) {
        this.username = memberVO.getUsername();
        this.email = memberVO.getEmail();
        this.nickName = memberVO.getNickName();
        this.age = memberVO.getAge();
        this.phoneNumber = memberVO.getPhoneNumber();
        this.zipcode = memberVO.getZipcode();
        this.address = memberVO.getAddress();
        this.addressDetail = memberVO.getAddressDetail();
    }
}
