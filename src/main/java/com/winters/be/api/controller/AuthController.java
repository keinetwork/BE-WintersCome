package com.winters.be.api.controller;

import com.winters.be.comm.WCUtil;
import com.winters.be.dto.MemberReq;
import com.winters.be.dto.MemberRes;
import com.winters.be.dto.ResultDto;
import com.winters.be.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    //    private final Logger logger = LoggerFactory.getLogger("AuthController");
    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "회원가입", description = "[@Operation] 회원가입 API")
//    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<ResultDto<MemberRes>> register(
            @Valid MemberReq.Signup signup, BindingResult bindingResult) throws Exception {
        log.info(WCUtil.ConvertObjectToJson(signup));
        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .location(URI.create("/auth/signup.html"))
                    .build();
        }
        if(!signup.getPassword().equals(signup.getPasswordConfim())){
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .location(URI.create("/page/auth/signup"))
                    .build();
        }
        ResultDto<MemberRes> resultDto = authService.signup(signup);
        if("SUCCESS".equals(resultDto.getCode())) {
            return ResponseEntity.status(HttpStatus.OK)
                    .location(URI.create("redirect:/page/"))
                    .body(resultDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .location(URI.create("/page/auth/signup"))
                    .body(resultDto);
        }
    }

    // 로그인
    @PostMapping("/login")
    @Operation(summary="로그인", description = "[@Operation] 로그인 API")
    public ResponseEntity<ResultDto<MemberRes>> login(@RequestParam(name = "username") String id,
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
