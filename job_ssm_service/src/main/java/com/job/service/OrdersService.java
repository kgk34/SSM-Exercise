package com.job.service;

import com.job.pojo.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll();

    Orders findById(Integer id);
}
