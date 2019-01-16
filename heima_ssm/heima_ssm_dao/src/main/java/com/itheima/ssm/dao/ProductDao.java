package com.itheima.ssm.dao;

import com.itheima.domain.Product;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 12:31
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

public interface ProductDao {
//    查询所有产品信息
    public List<Product> findAll();
//添加商品
    Integer save(Product product);

//    根据productId查product
    public Product findByProductId(String productId);

//    模糊查询 根据productname
    List<Product> findByName(String likeproductname);

//    根据id 删除
    void deleteById(String pid);
}
