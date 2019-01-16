package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Role;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/11 16:40
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


//    查询所有
    @Override
    public List<Role> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

//    添加角色
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }


    //    跟据roleId 查询角色详情页(含权限信息)
    @Override
    public Role findByRId(String id) {
        return roleDao.findByRId(id);
    }

    //    根据rid 查 其它没有的权限
    @Override
    public Role findOtherPermissionByRid(String rid) {
        return roleDao.findOtherPermissionByRid(rid);
    }
}
