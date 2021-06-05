package com.neu.service;

import com.neu.po.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAll();

    int update(Cart cart);

    Cart getById(String bid);

    int insert(Cart cart);
    int delete();

}
