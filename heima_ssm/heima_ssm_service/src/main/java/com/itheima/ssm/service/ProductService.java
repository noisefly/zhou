package com.itheima.ssm.service;

import com.itheima.domain.Product;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 12:34
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */


public interface ProductService {
    public List<Product> findAll(Integer page ,Integer size);

    Integer save(Product product);

//    模糊查询 根据productname
    List<Product> findByName(String likeproductname, Integer page, Integer size);

//    根据ids 删除
    void deleteByIds(List<String> pids);
}
