package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.ssm.service.RoleService;
import com.itheima.ssm.service.Role_PermissionService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private Role_PermissionService role_permissionService;

/*    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "role-list";
    }*/


    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                          @RequestParam(name = "size", required = true, defaultValue = "3") Integer size) {
        List<Role> roleList = roleService.findAll(page, size);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        model.addAttribute("pageInfo", pageInfo);
        return "role-list-page";
    }


    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/findAll";
    }


    //    查询角色详情页(需要显示权限)
    @RequestMapping("/findById")
    public String findById(String id, Model model) {
        Role role = roleService.findByRId(id);
        model.addAttribute("role", role);
        return "role-show";
    }


    //给角色添加 原来没有的权限
//    1.先用roleId 查权限 显示到 role-permission-add.jsp
    @RequestMapping("/findOtherPermissionByRid")
    public String findOtherPermissionByRid(Model model,@RequestParam(name = "id")String rid){
        Role role = roleService.findOtherPermissionByRid(rid);
        model.addAttribute("role",role);
        return "role-permission-add";
    }

//2.在 中间表中 添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId")String rid,@RequestParam(name = "ids")List<String>pids){
        role_permissionService.addPermissionToRole(rid,pids);
        return "redirect:/role/findAll";
    }


}
