package com.lanou.sm.admin.service;

import com.lanou.sm.admin.domain.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
public interface AdminService {
    Admin findAdmin(String adminName);
    
    List<Admin> findAll();
} 
