package com.gaga.mapper;

import com.gaga.po.Orders;
import com.gaga.po.OrdersExtend;

import java.util.List;

public interface OrderMapper {

     List<OrdersExtend> queryOrderUser();
     List<Orders> queryOrderUser01();
     List<Orders> queryOO();
}
