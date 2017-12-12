package com.lanou.sm.admin.mapper;
import com.lanou.sm.admin.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:myBatis.xml")
public class AdminMapperTest {



    @Resource
    private AdminMapper adminMapper;

    //管理员登录
    @Test
    public void findAdmin() throws Exception {
        Admin admin = new Admin("admin");
        adminMapper.findAdmin(admin);
    }

    //查询所有管理员
    @Test
    public void findAll() throws Exception {
        adminMapper.findAllAdmin();
    }




}