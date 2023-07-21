package com.winters.be.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class AccessCount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ipAddr;
	private int totalCount;
	private int yearCount;
	private int monthCount;
	private int dayCount;
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	private void setInfo(String ip, int total, int year, int month, int day) {
		this.ipAddr = ip;
		this.totalCount = total;
		this.yearCount = year;
		this.monthCount= month;
		this.dayCount = day;
	}
	
	@Builder
	public AccessCount(Long id, String ip, int total, int year, int month, int day) {
		this.id = id;
		setInfo(ip, total, year, month, day);
	}
	@Builder
	public AccessCount(String ip, int total, int year, int month, int day) {
		setInfo(ip, total, year, month, day);
	}
	
}
