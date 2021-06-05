package com.neu.service;

import com.neu.mapper.CartMapper;
import com.neu.po.Cart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Resource
    private CartMapper cartMapper;

    @Override
    public List<Cart> getAll() {
        return cartMapper.getAll();
    }

    @Override
    public int update(Cart cart) {
        return cartMapper.update(cart);
    }

    @Override
    public Cart getById(String bid) {
        return cartMapper.getById(bid);
    }

    @Override
    public int insert(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public int delete() {
        return cartMapper.delete();
    }


}
