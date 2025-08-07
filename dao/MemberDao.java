package com.job.dao;

import com.job.pojo.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id=#{id}")
    Member findMemberById(Integer id);
}
