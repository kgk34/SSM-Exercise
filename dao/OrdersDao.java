package com.job.dao;

import com.job.pojo.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Results(id = "orderMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.job.dao.ProductDao.findProductById")),
    })
    @Select("select * from orders")
    List<Orders> findAll();

    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.job.dao.ProductDao.findProductById")),
            @Result(column = "memberId", property = "member",
                    one = @One(select = "com.job.dao.MemberDao.findMemberById")),
            @Result(column = "id", property = "travellers",
                    many = @Many(select = "com.job.dao.TravellerDao.findTravellerByOrderId"))
    })
    @Select("select * from orders where id=#{id}")
    Orders findById(Integer id);
}
