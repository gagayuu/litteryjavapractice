package com.gaga.mapper;

import com.gaga.po.Items;

public interface ItemsMapper {

    Items queryItemsById(int id) throws  Exception;
}
