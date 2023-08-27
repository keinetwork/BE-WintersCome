package com.winters.be.db.jpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String userid;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50)
    private String password;
    @Column(length = 50, nullable = false)
    private String nickName;
    @Column(length = 5, nullable = false)
    private String role;
    private Integer age;
    @Column(length = 50)
    private String phoneNumber;
    @Column(length = 6)
    private String zipcode;
    @Column(length = 50)
    private String address;
    @Column(length = 100)
    private String addressDetail;
    @CreatedDate
    @Column(nullable = false, updatable=false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public MemberEntity(Long id, String userid, String email, String password, String nickName, String role,
            Integer age, String phoneNumber, String zipcode, String address, String addressDetail,
            LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.userid = userid;
        this.email = email;
        this.password = password;
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
