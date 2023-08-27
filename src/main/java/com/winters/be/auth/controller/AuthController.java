package com.winters.be.auth.controller;

import com.winters.be.comm.WCUtil;
import com.winters.be.dto.MemberReq;
import com.winters.be.dto.MemberRes;
import com.winters.be.dto.ResultDto;
import com.winters.be.service.AuthService;
import com.winters.be.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
//    private final Logger logger = LoggerFactory.getLogger("AuthController");
    private final AuthService authService;
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/register")
    @Operation(summary = "회원가입", description = "[@Operation] 회원가입 API")
//    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<ResultDto<MemberRes>> register(
            @Valid @RequestBody MemberReq reqBody) throws Exception {
        log.info(WCUtil.ConvertObjectToJson(reqBody));

        ResultDto<MemberRes> resultDto = authService.register(reqBody);
        if("SUCCESS".equals(resultDto.getCode())) {
            return ResponseEntity.status(HttpStatus.OK).body(resultDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultDto);
        }
    }

    // 로그인 View
    @RequestMapping("/login.html")
    public String login() {
        return "/login.html";
    }
    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/page/login2";
    }

    // 로그인
    @PostMapping("/login2")
    @Operation(summary="로그인", description = "[@Operation] 로그인 API")
    public ResponseEntity<ResultDto<MemberRes>> signin(@RequestParam(name = "username") String id,
                                       @RequestParam(name="password") String pwd){
//        logger.info("login: "+id+"/"+pwd);
        log.info("login: "+id+"/"+pwd);
        ResultDto<MemberRes> resultDto = authService.login(id, pwd);
        if("SUCCESS".equals(resultDto.getCode())) {
            return ResponseEntity.status(HttpStatus.OK).body(resultDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultDto);
        }
    }
}
