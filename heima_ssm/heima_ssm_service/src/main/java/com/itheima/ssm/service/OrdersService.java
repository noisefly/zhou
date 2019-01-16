package com.itheima.ssm.service;

import com.itheima.domain.Orders;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 20:30
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */


public interface OrdersService {

    List<Orders> findAll(Integer page,Integer pageSize);

//根据Id查询订单
    Orders findById(String orderId);
}
