package com.winters.be.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Schema(description = "멤버생성 요청정보")
public class MemberRegistReq {
    @NotNull(message="아이디는 필수 입력값입니다")
    @Schema(description = "닉네임", example = "stive", maxLength = 50)
    private String nickName;
    @Email
    @NotNull(message="이메일 형식에 맞게 입력하세요")
    @Schema(description = "이메일", example = "stive@gmail.com", maxLength = 50)
    private String email;
    @NotNull
    @Schema(description = "패스워드", example = "qwerQW!@", maxLength = 50)
    private String password;
    @Min(value=10, message="나이는 최소 10살 이상입니다")
    @Schema(description = "나이", requiredMode = RequiredMode.REQUIRED)
    private Integer age;
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "10~11 자리의 숫자만 입력가능합니다")
    @Schema(description = "폰번호",example = "010-1234-1234", requiredMode = RequiredMode.REQUIRED)
    private String phoneNumber;
    @Schema(description = "우편번호", minLength = 5, maxLength = 6)
    private String zipcode;
    @Schema(description = "주소", maxLength = 50)
    private String address;
    @Schema(description = "상세주소", maxLength = 100)
    private String addressDetail;
}
