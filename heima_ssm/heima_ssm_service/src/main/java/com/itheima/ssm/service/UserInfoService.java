package com.itheima.ssm.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/10 19:39
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

public interface UserInfoService extends UserDetailsService {

//   查找用户
    List<UserInfo> findAll(Integer page, Integer size);

//    根据ID查
    UserInfo findById(String id);

    //添加用户
    void save(UserInfo userInfo);

    //查询该用户下没有的角色
    UserInfo findOtherRoleByUserId(String id);

//    根据username 模糊查询
    List<UserInfo> findByName(String username,int page, int size);
}
