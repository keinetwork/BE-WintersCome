package com.winters.be.page.controller;

import com.winters.be.db.mybatis.vo.GraphVO;
import com.winters.be.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page/chart")
public class ChartController {
    private final ChartService chartService;

    @GetMapping({"/", "/index.html"})
    public String index(){
        return "/page/chart/index";
    }

    @GetMapping("/countTurtle.html")
    public @ResponseBody List<GraphVO> GetCountTurtle(@RequestParam Map<String,String> reqParam, Model model) {
        System.out.println(reqParam.toString());
        GraphVO vo = new GraphVO();
        vo.setMb_id(reqParam.get("mb_id"));
        vo.setPos_type(reqParam.get("pos_type"));
        List<GraphVO> turtle = chartService.countTurtle(vo);
        model.addAttribute("turtle", turtle);
        return turtle;
    }

    @PostMapping(value = {"/countTurtle.html"})
    public @ResponseBody List<GraphVO> PostCountTurtle(@RequestBody(required = false) Map<String,String> reqBody, Model model) {
        System.out.println(reqBody.toString());
        GraphVO vo = new GraphVO();
        vo.setMb_id(reqBody.get("mb_id"));
        vo.setPos_type(reqBody.get("pos_type"));
        List<GraphVO> turtle = chartService.countTurtle(vo);
        model.addAttribute("turtle", turtle);
        return turtle;
    }
}
