package com.winters.be.api.controller;

import com.winters.be.comm.WCUtil;
import com.winters.be.dto.MemberRegistReq;
import com.winters.be.dto.MemberRegistRes;
import com.winters.be.dto.ResultDto;
import com.winters.be.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "[@Tag] member", description = "회원관리")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    @Operation(summary = "회원가입", description = "[@Operation] 회원가입 API")
//    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<ResultDto<MemberRegistRes>> register(
           @Valid @RequestBody MemberRegistReq reqBody) throws Exception {
        log.info(WCUtil.ConvertObjectToJson(reqBody));

        ResultDto<MemberRegistRes> resultDto = memberService.register(reqBody);
        if("SUCCESS".equals(resultDto.getCode())) {
            return ResponseEntity.status(HttpStatus.OK).body(resultDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultDto);
        }
    }
    @GetMapping("/login")
    public String login() {
        return "/page/login";
    }

    @PostMapping("/login")
    public @ResponseBody String signin(@RequestParam HashMap<String, String> reqParam){
        log.info(reqParam.toString());
        return reqParam.toString();
    }


}
