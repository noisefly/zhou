package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 15:48
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

/*

    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) {
        List<Product> productList = productService.findAll(page,size);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        model.addAttribute("pageInfo", pageInfo);
        return "product-list-page";
    }
*/

    @RequestMapping("/save")
    public String save(Product product) {
        try {
            int save = productService.save(product);
            if (save > 0) {
                return "redirect:/product/findByName";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product-list-page";
    }


    //    模糊查询  根据productname
    @RequestMapping("/findByName")
    public String findByName(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                             @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
                             @RequestParam(name = "productname", defaultValue = "") String likeproductname) {

        List<Product> userList = productService.findByName(likeproductname, page, size);
        PageInfo<Product> pageInfo = new PageInfo<>(userList);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("likeproductname", likeproductname);

        return "product-list-page";
    }


    //    删除产品
    @RequestMapping("/deleteByIds")
    public String deleteByIds(@RequestParam(name = "ids")List<String>pids) {
        productService.deleteByIds(pids);
        return "forward:/product/findByName";
//        return "redirect:/product/findByName";
        /*重定向不会出现删除日志记录*/
    }
}
