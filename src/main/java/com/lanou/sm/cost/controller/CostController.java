package com.lanou.sm.cost.controller;

import com.lanou.sm.admin.utils.AjaxResult;
import com.lanou.sm.cost.domain.Cost;
import com.lanou.sm.cost.service.CostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/18.
 */
@Controller
public class CostController {
    @Resource(name = "costMappers")
    private CostService costService;

    /**
     * 查询资费
     * @return
     */
    @RequestMapping("findAllCost")
    @ResponseBody
    public AjaxResult findAllCost(){
        return new AjaxResult(costService.findAllCost());
    }

    /**
     * 删除资费
     * @param cost
     * @return
     */
    @RequestMapping("deleteCost")
    @ResponseBody
    public String deleteCost(Cost cost){
        String s = costService.deleteCost(cost);
        return s;
    }

    /**
     * 启用
     * @param cost
     * @return
     */
    @RequestMapping("startCost")
    @ResponseBody
    public AjaxResult startCost(Cost cost){
         costService.updateCost(cost);
        return new AjaxResult(costService.findAllCost());
    }

    @RequestMapping("updateCost")
    public String updateCost(){
        return "fee/fee_modi";
    }
}
