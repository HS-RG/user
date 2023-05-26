package com.hsrg.mapper;

import com.hsrg.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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


    @Insert("insert into user(user_id, username, nickname, image_url, update_time, create_time) " +
            "VALUES (#{userId},#{username},#{nickname},#{imageUrl},#{updateTime},#{createTime})")
    public void insertOneUser(User user);

    public void upDataUser(User user);

    @Delete("delete from user where user_id = #{userId}")
    public void deleteOneUser(Long userId);

    @Select("select * from user where user_id = #{userId}")
    public User selectByUserId(Long userId);

    public List<User> listByNickname(String nickname, Integer pageNumber, Integer pageSize);

}
