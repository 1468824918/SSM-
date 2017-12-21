package com.lanou.sm.cost.service;

import com.lanou.sm.cost.domain.Cost;

import java.util.List;

/**
 * Created by dllo on 17/12/18.
 */
public interface CostService {
    List<Cost> findAllCost();

    String deleteCost(Cost cost);

    List<Cost> updateCost(Cost cost);

    Cost findCostById(String costId);

    List<Cost> findCostDesc();

    List<Cost> findCostAsc();

    List<Cost> findCostTimeDesc();

    List<Cost> findCostTimeAsc();
}
