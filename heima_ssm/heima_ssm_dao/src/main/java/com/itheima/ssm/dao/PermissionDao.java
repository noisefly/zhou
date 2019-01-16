package com.itheima.ssm.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/11 13:03
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

public interface PermissionDao {
//    跟据 角色id 查权限
    public List<Permission> findByRoleId(String roleId);


//    查询所有权限
    List<Permission> findAll();

    //添加权限
    void save(Permission permission );

    //    跟据 角色id 查 没有的 权限
    public List<Permission> findOtherByRid(String roleId);


}
