package com.hsrg.mapper;

import com.hsrg.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(user_id, nick_name, image_url, update_time, create_time) " +
            "VALUES (#{userId},#{nickName},#{imageUrl},#{updateTime},#{createTime})")
    public void insertOneUser(User user);

    @Update("update user set nick_name = #{nickName} ,image_url = #{imageUrl} ,update_time = #{updateTime} " +
            "where user_id = #{userId} ")
    public void upDataUser(User user);

    @Delete("delete from user where user_id = #{userId}")
    public void deleteOneUser(Long userId);

    @Select("select * from user where user_id = #{userId}")
    public User selectByUserId(Long userId);
}
