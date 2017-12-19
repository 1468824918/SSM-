package com.lanou.sm.role.controller;

import com.lanou.sm.admin.utils.AjaxResult;
import com.lanou.sm.cost.domain.Cost;
import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import com.lanou.sm.role.service.RoleService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
@Controller
public class RoleController {
    @Resource(name = "roleServices")
    private RoleService roleService;

    /**
     * 角色查询
     *
     * @return
     */
    @RequestMapping("role_list")
    @ResponseBody
    public AjaxResult role_List() {
        return new AjaxResult(roleService.findAll());
    }

    /**
     * 插入角色
     *
     * @param roleInfo
     * @param moduleId
     * @return
     */
    @RequestMapping("role_adds")
    @ResponseBody
    public String role_add(RoleInfo roleInfo, String[] moduleId) {
        String s = roleService.insertRole(roleInfo, moduleId);
        return s;
    }

    /**
     * 删除角色
     *
     * @param roleInfo
     * @return
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public String deleteRole(RoleInfo roleInfo) {
        return roleService.deleteRole(roleInfo);
    }

    /**
     * 修改
     * @param roleInfo
     * @param moduleId
     * @return
     */
    @RequestMapping("/updateRoleInfo")
    @ResponseBody
    public String updateRole(RoleInfo roleInfo, String[] moduleId) {
        String s = roleService.insertUpdateRoleInfo(roleInfo, moduleId);
        return s;
    }

    @RequestMapping("findModuleInfo")
    @ResponseBody
    public AjaxResult findModule_Info(){
        return new AjaxResult(roleService.findModule_Info());
    }


}
