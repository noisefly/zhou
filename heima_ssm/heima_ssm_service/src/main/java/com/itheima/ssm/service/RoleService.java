package com.itheima.ssm.service;

import com.itheima.domain.Orders;
import com.itheima.domain.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/11 16:39
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */


public interface RoleService {

    List<Role> findAll(Integer page,Integer size);

    void save(Role role);

//    跟据roleId 查询角色详情页(含权限信息)
    Role findByRId(String id);


//    根据rid 查 其它没有的权限
    Role findOtherPermissionByRid(String rid);
}
