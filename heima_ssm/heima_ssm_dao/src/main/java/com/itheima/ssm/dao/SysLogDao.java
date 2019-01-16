package com.itheima.ssm.dao;

import com.itheima.domain.SysLog;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/13 18:00
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface SysLogDao {

    void save(SysLog sysLog);

    List<SysLog> findByName(String username);
}
