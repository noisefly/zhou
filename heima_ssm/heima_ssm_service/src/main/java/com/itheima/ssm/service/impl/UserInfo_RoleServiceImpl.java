package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.UserInfo_RoleDao;
import com.itheima.ssm.service.UserInfo_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/12 19:27
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Service
@Transactional
public class UserInfo_RoleServiceImpl implements UserInfo_RoleService {

    @Autowired
    private UserInfo_RoleDao userInfo_roleDao;
    //    选择添加没有的角色
    @Override
    public void addRoleToUser(String userId, List<String> roleIds) {
        for (String roleId : roleIds) {
            userInfo_roleDao.addRoleToUser(userId,roleId);
        }
    }

}
