package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.ssm.dao.UserInfoDao;
import com.itheima.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/10 19:40
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired(required = false)
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserInfoDao userInfoDao;


//    分页查询所有
    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return userInfoDao.findAll();
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo userInfo = userInfoDao.findById(id);
        System.out.println(userInfo);
        return userInfo;
    }

//    添加用户
    @Override
    public void save(UserInfo userInfo) {
        //使用spring security 加密密码
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoDao.save(userInfo);
    }


    //查询该用户下没有的角色
    @Override
    public UserInfo findOtherRoleByUserId(String id) {
        return userInfoDao.findOtherRoleByUserId(id);
    }


    /*根据username 模糊查询*/
    @Override
    public List<UserInfo> findByName(String username, int page, int size) {
      PageHelper.startPage(page,size);
        return userInfoDao.findByName("%"+username+"%");

    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoDao.findByUsername(s);
        //将查询的UserInfo  封装成UserDetails  并获得权限                                           账户激活     账户未过期             身份未过期                   账户未锁定
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true, getAuthority(userInfo.getRoles()));

        return user;
    }

    //获取用户权限
    public List<SimpleGrantedAuthority> getAuthority(List<Role>roles) {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }



}

