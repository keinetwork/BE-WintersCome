package com.winters.be.controller.cms;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.dto.ResultDto;
import com.winters.be.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/cms")
@RequiredArgsConstructor
@Tag(name = "[@Tag] member", description = "회원관리")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
//    @ApiResponse(responseCode = "404", description = "Not Found")
    @Operation(summary = "회원목록 조회", description = "[@Operation] 회원목록 조회 API")
    ResponseEntity<ResultDto<List<MemberEntity>>> getMembers(
    ) {
        return ResponseEntity.ok().body(ResultDto.ofSuccess(null, memberService.selectAll()));
    }
//            @Parameter(name="id", description = "아이디", example = "stive") @PathVariable String id,
//            @Parameter(name="name", description = "이름", example = "stive") @RequestParam(required = false) String name,
}