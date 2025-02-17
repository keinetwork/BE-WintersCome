package com.winters.be.db.mybatis.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberVO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String nickName;
    private String role;
    private Integer age;
    private String phoneNumber;
    private String zipcode;
    private String address;
    private String addressDetail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Builder
    public MemberVO(Long id, String username, String password, String email, String nickName, String role,
                    Integer age, String phoneNumber, String zipcode, String address, String addressDetail,
                    LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.zipcode = zipcode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.createdAt = createAt;
        this.updatedAt = updateAt;
    }
}
