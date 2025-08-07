package com.job.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.job.pojo.Product;
import com.job.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    //查询商品信息
    @RequestMapping("findAll.do")
    public String findAll(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(name = "size", required = false, defaultValue = "4") Integer size,
                          Model model) {
        PageHelper.startPage(page, size);
        List<Product> productList = productService.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        model.addAttribute("pageInfo", pageInfo);
        return "product-list";
    }

    //新增商品信息
    @RequestMapping("save.do")
    public String save(Product product) {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
