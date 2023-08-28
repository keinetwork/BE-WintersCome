package com.winters.be;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Application home page and login.
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String root(Locale locale) {
        return "redirect:/index.html";
    }

    /** Home page. */
    @GetMapping("/index.html")
    public String index() {
        return "/index";
    }

    /** User zone index. */
    @GetMapping("/user/index.html")
    public String userIndex() {
        return "/page/user/index";
    }

    /** Administration zone index. */
    @GetMapping("/admin/index.html")
    public String adminIndex() {
        return "/page/admin/index";
    }

    /** Shared zone index. */
    @GetMapping("/shared/index.html")
    public String sharedIndex() {
        System.out.println("/shared/index.html");
        return "/page/shared/index";
    }

    /** Login form. */
    @GetMapping("/login.html")
    public String login() {
        return "/login";
    }

    /** Login form with error. */
    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }

    /** Simulation of an exception. */
    @GetMapping("/simulateError.html")
    public void simulateError() {
        throw new RuntimeException("This is a simulated error message");
    }

    /** Error page. */
    @GetMapping("/error.html")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(HtmlEscape.escapeHtml5(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "/error";
    }

    /** Error page. */
    @GetMapping("/403.html")
    public String forbidden() {
        return "/403";
    }

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