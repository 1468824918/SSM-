package com.lanou.sm.cost.mapper;

import com.lanou.sm.cost.domain.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/12/18.
 */
@Repository
public interface CostMapper {
    //查询资费
    List<Cost> findAllCost();

    //删除资费
    int deleteCost(Cost cost);

    //启用
    int update(Cost cost);

    //根据id查资费
    Cost findCostById(String costId);

    //基费
    List<Cost> findCostDesc();

    //时长
    List<Cost> findCostTime();

}
