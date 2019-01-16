package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.ssm.service.PermissionService;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 20:26
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
/*
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Permission> permissionList= permissionService.findAll();
        model.addAttribute("permissionList", permissionList);
        return "permission-list";
    }*/
   @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                          @RequestParam(name = "size",required = true,defaultValue = "5")Integer size) {
        List<Permission> permissionList= permissionService.findAll(page,size);
       PageInfo<Permission> pageInfo = new PageInfo<>(permissionList);
       model.addAttribute("pageInfo", pageInfo);
        return "permission-list-page";
    }

    @RequestMapping("/save")
    public  String save(Permission permission){
       permissionService.save(permission);
        return "redirect:/permission/findAll";
    }


}
