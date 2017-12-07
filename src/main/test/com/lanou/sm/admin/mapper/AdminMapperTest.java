package com.lanou.sm.admin.mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class AdminMapperTest {


    @Resource(name = "adminMapper")
    private AdminMapper adminMapper;

    //管理员登录
    @Test
    public void findAdmin() throws Exception {
        adminMapper.findAdmin("admin");
    }


    //管理员查询
    @Test
    public void findAll() throws Exception {
        adminMapper.findAll();
    }

}