package org.spring.testbook.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.spring.testbook.entity.account;

@Mapper
public interface UserMapper {

    /**
     *
     * @param username 用户名
     *
     */
    @Select("SELECT * from  user where username = #{username}")
    account getUserName(String username);

}
