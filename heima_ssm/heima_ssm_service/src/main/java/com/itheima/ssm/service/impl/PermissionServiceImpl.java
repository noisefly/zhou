package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.ssm.dao.PermissionDao;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/11 17:24
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
