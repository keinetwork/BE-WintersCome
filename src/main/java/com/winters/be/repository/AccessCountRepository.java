package com.winters.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.winters.be.entity.AccessCount;

@Repository
public interface AccessCountRepository extends JpaRepository<AccessCount, Long> {
	public Optional<AccessCount> findByIpAddr(String ipAddr);
}
