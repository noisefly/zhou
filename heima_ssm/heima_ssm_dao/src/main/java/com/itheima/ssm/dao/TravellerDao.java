package com.itheima.ssm.dao;

import com.itheima.domain.Traveller;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/10 15:59
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public interface TravellerDao{

    //    根据orderId 查traveller List
    public List<Traveller> findByOrderId(String orderId);
}
