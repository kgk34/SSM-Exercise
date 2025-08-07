package com.job.dao;

import com.job.pojo.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerid from order_traveller where orderid=#{id})")
    List<Traveller> findTravellerByOrderId(Integer id);
}
