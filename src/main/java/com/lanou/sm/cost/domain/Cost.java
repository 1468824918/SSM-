package com.lanou.sm.cost.domain;

import java.util.Date;

/**
 * Created by dllo on 17/12/18.
 */
public class Cost {
    private int costId;
    private String costName;
    private int base_duration;
    private int base_cost;
    private int unit_cost;
    private String status;
    private String descr;
    private Date creaTime;
    private Date starTime;
    private String cost_type;

    public Cost(int costId) {
        this.costId = costId;
    }

    public Cost() {
    }

    public Cost(int costId, String costName, int base_duration, int base_cost, int unit_cost, String status, String descr, Date creaTime, Date starTime, String cost_type) {
        this.costId = costId;
        this.costName = costName;
        this.base_duration = base_duration;
        this.base_cost = base_cost;
        this.unit_cost = unit_cost;
        this.status = status;
        this.descr = descr;
        this.creaTime = creaTime;
        this.starTime = starTime;
        this.cost_type = cost_type;
    }

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public int getBase_duration() {
        return base_duration;
    }

    public void setBase_duration(int base_duration) {
        this.base_duration = base_duration;
    }

    public int getBase_cost() {
        return base_cost;
    }

    public void setBase_cost(int base_cost) {
        this.base_cost = base_cost;
    }

    public int getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(int unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCreaTime() {
        return creaTime;
    }

    public void setCreaTime(Date creaTime) {
        this.creaTime = creaTime;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public String getCost_type() {
        return cost_type;
    }

    public void setCost_type(String cost_type) {
        this.cost_type = cost_type;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costId=" + costId +
                ", costName='" + costName + '\'' +
                ", base_duration=" + base_duration +
                ", base_cost=" + base_cost +
                ", unit_cost=" + unit_cost +
                ", status='" + status + '\'' +
                ", descr='" + descr + '\'' +
                ", creaTime=" + creaTime +
                ", starTime=" + starTime +
                ", cost_type='" + cost_type + '\'' +
                '}';
    }
}
