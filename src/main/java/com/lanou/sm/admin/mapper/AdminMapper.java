package com.lanou.sm.admin.mapper;

import com.lanou.sm.admin.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
@Repository
public interface AdminMapper {
    //管理员登录
    Admin findAdmin(Admin admin);

    List<Admin> findAllAdmin();


}
