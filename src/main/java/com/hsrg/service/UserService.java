package com.hsrg.service;

import com.hsrg.pojo.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
public interface UserService {
    void initOneUser(User user);

    void updateOneUser(User user);

    void deleteOneUser(Long userId);

    User selectByUserId(Long userId);

    List<User> listByNickname(String nickname, Integer pageNumber, Integer pageSize);
}
