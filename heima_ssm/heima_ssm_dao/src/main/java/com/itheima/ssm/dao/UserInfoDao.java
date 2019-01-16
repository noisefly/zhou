package com.itheima.ssm.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/10 19:50
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface UserInfoDao {
    //    根据用户名查
    public UserInfo findByUsername(String s);

    //    查找 所有
    List<UserInfo> findAll();

    //根据用户id查
    UserInfo findById(String id);

    //添加用户
    void save(UserInfo userInfo);


    //查询该用户下没有的 角色
    UserInfo findOtherRoleByUserId(String id);

    /*根据 username 模糊查询*/
    List<UserInfo> findByName(String username);
}
