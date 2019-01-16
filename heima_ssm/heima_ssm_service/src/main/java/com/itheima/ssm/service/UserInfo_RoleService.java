package com.itheima.ssm.service;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/12 19:26
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface UserInfo_RoleService {

//  将没有的角色 添加到中间表 role_userInfo
     void addRoleToUser(String userId, List<String> roleIds);

}
