package com.lanou.sm.admin.service;

import com.lanou.sm.admin.domain.Admin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
public interface AdminService {

    String findAdmin(Admin admin, HttpSession session ,String code);

    List<Admin> findAllAdmin();

} 
