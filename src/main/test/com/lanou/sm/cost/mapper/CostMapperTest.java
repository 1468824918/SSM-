package com.lanou.sm.cost.mapper;

import com.lanou.sm.cost.domain.Cost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:myBatis.xml")
public class CostMapperTest {



    @Resource
    private CostMapper costMapper;

    @Test
    public void findAllCost() throws Exception {
        costMapper.findAllCost();
    }

    @Test
    public void update() throws Exception {
        Cost cost = new Cost(6);
        costMapper.update(cost);
    }

    @Test
    public void findCostById() throws Exception {
        costMapper.findCostById("1");
    }

    @Test
    public void findCostDesc() throws Exception {
        costMapper.findCostDesc();
    }

    @Test
    public void findCostTime() throws Exception {
        costMapper.findCostTimeDesc();
    }

}