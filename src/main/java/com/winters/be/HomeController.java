package com.winters.be;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
    @GetMapping({"/", "/index.html"})
    public String index() {
        return "redirect:/page/";
    }
}
