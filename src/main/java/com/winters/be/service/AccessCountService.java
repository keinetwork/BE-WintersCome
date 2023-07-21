package com.winters.be.service;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.winters.be.entity.AccessCount;
import com.winters.be.repository.AccessCountRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AccessCountService {
	private final AccessCountRepository accessCountRepository;
	
	public AccessCount getAccessCount(String ip) {
		Optional<AccessCount> acOptional = accessCountRepository.findByIpAddr(ip);
		AccessCount acEntity;	
		if(acOptional.isPresent()) {
			acEntity = acOptional.get();
			acEntity.setTotalCount(acEntity.getTotalCount()+1);
			LocalDateTime today = LocalDateTime.now();
			if(acEntity.getUpdatedAt().getYear() != today.getYear()) {
				acEntity.setYearCount(1);
			}
			else {
				acEntity.setYearCount(acEntity.getYearCount()+1);
			}
			if(acEntity.getUpdatedAt().getMonth() != today.getMonth()) {
				acEntity.setMonthCount(1);
			}else {
				acEntity.setMonthCount(acEntity.getMonthCount()+1);
			}
			if(acEntity.getUpdatedAt().getDayOfYear() != today.getDayOfYear()) {
				acEntity.setDayCount(1);
			}else {
				acEntity.setDayCount(acEntity.getDayCount()+1);
			}
		}else {
			acEntity = AccessCount.builder().ip(ip).total(1).year(1).month(1).day(1).build();	
		}
		
		return accessCountRepository.save(acEntity);
	}
}
