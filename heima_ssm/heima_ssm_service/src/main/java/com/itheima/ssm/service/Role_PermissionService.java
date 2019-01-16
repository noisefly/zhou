package com.itheima.ssm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


public interface Role_PermissionService {

//  在角色小 添加 没有的 权限
     void addPermissionToRole(String rid, List<String> pids);
}
