package com.itheima.ssm.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/10 20:17
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface RoleDao {

//    根据userId查
//    @Select("select * from ROLE where id in (select ROLEID from USERINFO_ROLE where USERID=#{userId})")
    public List<Role>findByUserId(String userId);

    //    跟据角色id查
    public List<Role> findById(String id);

    //  查询角色
    List<Role> findAll();

//    添加角色
    void save(Role role);

    //    跟据roleId 查询角色详情页(含权限信息)
    Role findByRId(String id);

    //    根据userId查Role排除已有的role
    public List<Role>findOtherByUserId(String userId);

//    根据 rid 查 其它  没有的  权限
    Role findOtherPermissionByRid(String rid);
}
