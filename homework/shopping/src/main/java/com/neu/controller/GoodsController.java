package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.po.Cart;
import com.neu.po.Goods;
import com.neu.service.CartService;
import com.neu.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @Resource
    private CartService cartService;

    // 分页
    @RequestMapping("getPaged")
    public String getPaged(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "4") int pageSize, Model model){
        pageSize = 5;
        PageInfo<Goods> pageInfo = goodsService.getPaged(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);

        return "goods/pagedAll";
    }

    @RequestMapping("buy")
    public String buy(String gid,Model model){
        Goods goods = goodsService.getById(gid);
        Cart cart = cartService.getById(goods.getGid());

        if (cart==null){
            cartService.insert(new Cart(goods.getGid(),goods.getGname(),goods.getPrice(),1));
        }else {
            cart.setCount(cart.getCount()+1);
            cartService.update(cart);
        }

        List<Cart> carts = cartService.getAll();
        model.addAttribute("carts",carts);

        return "goods/cart";
    }

    @RequestMapping("submit")
    public String submit(){
        cartService.delete();

        return "redirect:/goods/getPaged";
    }
}
