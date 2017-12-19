package com.lanou.sm.cost.service.impl;

import com.lanou.sm.cost.domain.Cost;
import com.lanou.sm.cost.mapper.CostMapper;
import com.lanou.sm.cost.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/18.
 */
@Service("costMappers")
public class CostServiceImpl implements CostService {
    @Resource(name = "costMapper")
    private CostMapper costMapper;

    @Override
    public List<Cost> findAllCost() {
        return costMapper.findAllCost();
    }

    @Override
    public String deleteCost(Cost cost) {
        costMapper.deleteCost(cost);
        return "success";
    }

    @Override
    public List<Cost> updateCost(Cost cost) {
        costMapper.update(cost);
        return costMapper.findAllCost();
    }

    @Override
    public Cost findCostById(String costId) {
        return costMapper.findCostById(costId);
    }

    @Override
    public List<Cost> findCostDesc() {
        return costMapper.findCostDesc();
    }

    @Override
    public List<Cost> findCostTime() {
        return costMapper.findCostTime();
    }
}
