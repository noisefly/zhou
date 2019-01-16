package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.Role_PermissionDao;
import com.itheima.ssm.service.Role_PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/12 23:19
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Service
@Transactional
public class Role_PermissionServiceImpl implements Role_PermissionService {
    @Autowired
    private Role_PermissionDao role_permissionDao;

    @Override
    public void addPermissionToRole(String rid, List<String> pids) {
        for (String pid : pids) {
            role_permissionDao.addPermissionToRole(rid,pid);
        }
    }


}
