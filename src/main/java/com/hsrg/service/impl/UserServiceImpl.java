package com.hsrg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hsrg.pojo.User;
import com.hsrg.mapper.UserMapper;
import com.hsrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void initOneUser(User user) {
        userMapper.insertOneUser(user);
    }

    @Override
    public void updateOneUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.upDataUser(user);
    }

    @Override
    public void deleteOneUser(Long userId) {
        userMapper.deleteOneUser(userId);
    }

    @Override
    public User selectByUserId(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public List<User> listByNickname(String nickname, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber ,pageSize);

        List<User> list = userMapper.listByNickname(nickname ,pageNumber ,pageSize);
        return list;
    }

}
