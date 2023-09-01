package com.winters.be.controller.page;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpServletRequest;

/**
 * Application home page and login.
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/page")
public class MainController {

    /** Home page. */
    @GetMapping({"/index.html"})
    public String index() {
        return "/page/index";
    }

    /** User zone index. */
    @GetMapping("/user/index.html")
    public String userIndex() {
        System.out.println("/page/user/index");
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
        return "/page/error";
    }

    /** Error page. */
    @GetMapping("/403.html")
    public String forbidden() {
        return "/page/403";
    }

    /** Error page. */
    @GetMapping({"/","/dashboard.html"})
    public String dashboard() {
        return "/page/dashboard";
    }

    /** Error page. */
    @GetMapping({"/accesscount.html"})
    public String accesscount() {
        return "/page/accesscount";
    }
}