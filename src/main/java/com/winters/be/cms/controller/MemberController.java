package com.winters.be.cms.controller;

import com.winters.be.db.entity.MemberEntity;
import com.winters.be.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/cms")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    List<MemberEntity> getMembers() {
        return memberService.selectAll();
    }
}
