package com.itheima.ssm.dao;

import org.apache.ibatis.annotations.Param;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/12 23:21
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface Role_PermissionDao {

//    在 中间表中 添加权限
    void addPermissionToRole(@Param("rid") String rid, @Param("pid") String pid);
}
