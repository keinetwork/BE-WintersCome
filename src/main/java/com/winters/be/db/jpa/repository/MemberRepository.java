package com.winters.be.db.jpa.repository;

import com.winters.be.db.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryQuery {
    Optional<MemberEntity> findByUsername(String username);
}
