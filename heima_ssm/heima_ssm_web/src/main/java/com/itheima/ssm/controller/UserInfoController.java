package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.ssm.service.UserInfoService;
import com.itheima.ssm.service.UserInfo_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/11 10:17
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfo_RoleService userInfo_roleService;
/*

    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                          @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) {
        List<UserInfo> userList = userInfoService.findAll(page, size);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userList);
        model.addAttribute("pageInfo", pageInfo);
        return "user-list-page";
    }
*/

    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam(name = "id", required = true) String id) {
        UserInfo userInfo = userInfoService.findById(id);
        model.addAttribute("user", userInfo);
        return "user-show";
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        userInfoService.save(userInfo);
        return "redirect:/user/findByName";
    }

//    在用户下添加角色
//    1.先查用户没有的角色
//    2.把  没有的角色 和 userId 显示到user-role-add.jsp

    @RolesAllowed({"SSSVIP", "SVIP"})
    @RequestMapping("/findOtherRoleByUserId")
    public String findOtherRoleByUserId(Model model, @RequestParam(name = "id", required = true) String id) {
        UserInfo userInfo = userInfoService.findOtherRoleByUserId(id);
        model.addAttribute("userInfo", userInfo);

        return "user-role-add";
    }

    //有SSSVIP 权限 的才能访问这个方法********
    @RolesAllowed({"SSSVIP", "SVIP"})
    //      3.访问/add 再添加到user_role 关联表中
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId") String userId,
                                @RequestParam(name = "ids") List<String> roleIds) {
        userInfo_roleService.addRoleToUser(userId, roleIds);
        return "redirect:/user/findByName";
    }

    //    模糊查询  根据username
    @RolesAllowed({"SSSVIP", "SVIP"})
    @RequestMapping("/findByName")
    public String findByName(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                             @RequestParam(name = "size", required = true, defaultValue = "4") Integer size,
                             @RequestParam(name = "username", defaultValue = "") String likeusername) {

        List<UserInfo> userList = userInfoService.findByName(likeusername, page, size);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userList);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("likeusername", likeusername);

        return "user-list-page";
    }

}
