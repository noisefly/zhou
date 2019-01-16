package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 20:26
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

/*    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Orders> ordersList = ordersService.findAll();
        model.addAttribute("ordersList", ordersList);
        return "orders-list";
    }*/


    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size, Model model) {
        List<Orders> ordersList = ordersService.findAll(page, size);
        //分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        model.addAttribute("pageInfo", pageInfo);
        return "orders-list-page";
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam(name = "id", required = true) String orderId, Model model) {
        Orders orders = ordersService.findById(orderId);
        model.addAttribute("orders", orders);
        return "orders-show";
    }
}
