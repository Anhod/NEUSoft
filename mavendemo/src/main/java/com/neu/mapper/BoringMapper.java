package com.neu.mapper;

import com.neu.po.Boring;

public interface BoringMapper {
    Boring getById(int bid);

    Integer insert(Boring boring);
}
