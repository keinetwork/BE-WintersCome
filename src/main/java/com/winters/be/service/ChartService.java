package com.winters.be.service;

import com.winters.be.db.mybatis.dao.ChartDAO;
import com.winters.be.db.mybatis.vo.GraphVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartService {
    private final ChartDAO chartDAO;
    public List<GraphVO> countTurtle(GraphVO vo) {
        return chartDAO.countTurtle(vo);
    }
}
