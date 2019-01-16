package com.itheima.ssm.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/11 17:06
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface PermissionService {
    List<Permission> findAll(Integer page,Integer size);

    void save(Permission permission);


}
