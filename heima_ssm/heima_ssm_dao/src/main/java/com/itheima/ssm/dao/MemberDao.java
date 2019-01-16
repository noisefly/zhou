package com.itheima.ssm.dao;

import com.itheima.domain.Member;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/10 15:57
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface MemberDao {

//    根据memberId 查Member
public Member findByMemberId(String memberId);
}
