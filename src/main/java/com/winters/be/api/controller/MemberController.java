package com.winters.be.api.controller;

import com.winters.be.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "[@Tag] member", description = "회원관리")
public class MemberController {
    private final MemberService memberService;
}
