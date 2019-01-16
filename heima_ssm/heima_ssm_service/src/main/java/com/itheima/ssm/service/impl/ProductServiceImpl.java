package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Product;
import com.itheima.ssm.dao.ProductDao;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 12:35
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(Integer page,Integer size) {
        //        分页查询  页码 每页显示条数  必须写在findAll前
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public Integer save(Product product) {
     return  productDao.save(product);
    }


//    根据模糊查询  productname
    @Override
    public List<Product> findByName(String likeproductname, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return productDao.findByName("%"+likeproductname+"%");
    }

    @Override
    public void deleteByIds(List<String> pids) {
        for (String pid : pids) {
            productDao.deleteById(pid);
        }
    }
}
