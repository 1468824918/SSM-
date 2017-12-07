package com.lanou.sm.admin.service.impl;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.mapper.AdminMapper;
import com.lanou.sm.admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
@Service("adminServices")
public class AdminServiceImpl implements AdminService {

    @Resource(name = "adminMapper")
    private AdminMapper adminMapper;

    @Override
    public Admin findAdmin(String adminName) {
        return adminMapper.findAdmin(adminName);
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }
}
