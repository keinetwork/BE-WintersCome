package com.winters.be.controller.page;

import com.winters.be.comm.WCUtil;
import com.winters.be.db.mybatis.vo.MembersVO;
import com.winters.be.dto.MemberReq;
import com.winters.be.dto.MemberRes;
import com.winters.be.dto.ResultDto;
import com.winters.be.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/page/auth")
public class AuthController {
    //    private final Logger logger = LoggerFactory.getLogger("AuthController");
    private final AuthService authService;
//    private final MemberService memberService;

    @GetMapping("/signup.html")
    public String signup(MemberReq.Signup signup){
        System.out.println("/page/auth/signup");
        return "/page/auth/signup";
    }
    // 회원가입
    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "[@Operation] 회원가입 API")
//    @ApiResponse(responseCode = "404", description = "Not Found")
//    public ResponseEntity<ResultDto<MemberRes>> signup(
    public String signup(
            @Valid MemberReq.Signup signup, BindingResult bindingResult) {
        log.info(WCUtil.ConvertObjectToJson(signup));
        if(bindingResult.hasErrors()) {
            return "/page/auth/signup";
        }
        if(!signup.getPassword().equals(signup.getPasswordConfim())){
            bindingResult.rejectValue("password", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "/page/auth/signup";
        }

        try{
            ResultDto<MemberRes> resultDto = authService.signup(signup);
            if(!"SUCCESS".equals(resultDto.getCode())) {
                bindingResult.reject(resultDto.getCode(), resultDto.getMessage());
                return "/page/auth/signup";
            }
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자 입니다.");
            return "/page/auth/signup";
        } catch (Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "/page/auth/signup";
        }

        return "redirect:/page/";
    }

    /** Login form. */
    @GetMapping("/login.html")
    public String login() {
        return "/page/auth/login";
    }

    /** Login form with error. */
    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/page/auth/login";
    }

    // 로그인
//    @PostMapping("/signin")
//    @Operation(summary="로그인", description = "[@Operation] 로그인 API")
//    public ResponseEntity<ResultDto<MemberRes>> signin(@RequestParam(name = "username") String id,
//                                                       @RequestParam(name="password") String pwd){
////        logger.info("login: "+id+"/"+pwd);
//        log.info("login: "+id+"/"+pwd);
//        ResultDto<MemberRes> resultDto = authService.login(id, pwd);
//        if("SUCCESS".equals(resultDto.getCode())) {
//            return ResponseEntity.status(HttpStatus.OK).body(resultDto);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultDto);
//        }
//    }
    @GetMapping("/mySignup")
    public @ResponseBody MembersVO mySignup(){
        MembersVO vo = new MembersVO();
        vo.setMb_id("cobook");
        vo.setMb_nick("코북");
        vo.setMb_pwd("1234");
        vo.setMb_name("김코북");
        vo.setMb_yy("2021");
        vo.setMb_mm("10");
        vo.setMb_dd("25");
        vo.setMb_birthdate(vo.getMb_yy()+vo.getMb_mm()+vo.getMb_dd());
        vo.setMb_sex("남자");
        vo.setMb_email("test@gmail.com");
        authService.myInsertMembers(vo);
        return vo;
    }
    @GetMapping("/myLogin")
    public @ResponseBody MembersVO myLogin(String id) {
        return authService.myLogin(id);
    }
}
