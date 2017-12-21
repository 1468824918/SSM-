package com.lanou.sm.cost.controller;

import com.lanou.sm.admin.utils.AjaxResult;
import com.lanou.sm.cost.domain.Cost;
import com.lanou.sm.cost.service.CostService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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



    @RequestMapping("fee_detail")
    @ResponseBody
    public String fee_detail(String costId, HttpSession session){
        session.setAttribute("costId",costId);
        return "success";
    }

    @RequestMapping("detail")
    public String detail(){
        return "fee/fee_detail";
    }

    @RequestMapping("findCostById")
    @ResponseBody
    public AjaxResult findCostById(HttpSession session){
        String costId = (String) session.getAttribute("costId");
        return new AjaxResult(costService.findCostById(costId));
    }

    /**
     * 时长
     * @return
     */
    @RequestMapping("findCostDesc")
    @ResponseBody
    public AjaxResult findCostDesc(){
        return new AjaxResult(costService.findCostDesc());
    }

    @RequestMapping("findCostAsc")
    @ResponseBody
    public AjaxResult findCostAsc(){
        return new AjaxResult(costService.findCostAsc());
    }

    /**
     * 基费
     * @return
     */
    @RequestMapping("findCostTimeDesc")
    @ResponseBody
    public AjaxResult findCostTimeDesc(){
        return new AjaxResult(costService.findCostTimeDesc());
    }

    @RequestMapping("findCostTimeAsc")
    @ResponseBody
    public AjaxResult findCostTimeAsc(){
        return new AjaxResult(costService.findCostTimeAsc());
    }




}
