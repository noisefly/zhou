package com.itheima.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/12 19:17
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface UserInfo_RoleDao {

    //     将 uid rid  添加到user_role中间表    mybatis 默认只会找  第一个参数 不使用param 注解不能识别第二个
    void addRoleToUser(@Param("uid") String userId, @Param("rid") String roleId);
}
