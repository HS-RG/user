package com.hsrg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hsrg.mapper.CollectionMapper;
import com.hsrg.pojo.Collection;
import com.hsrg.pojo.User;
import com.hsrg.mapper.UserMapper;
import com.hsrg.service.UserService;
import com.hsrg.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private CollectionMapper collectionMapper;


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
        User user = new User();
        user.setUpdateTime(LocalDateTime.now());
        user.setUserId(userId);
        user.setUsername(userId.toString());
        user.setNickname("账号已注销");
        user.setImageUrl("delete");
        userMapper.upDataUser(user);
        Collection collection =new Collection();
        collection.setUserId(userId);
        collectionMapper.deleteCollection(collection);
    }

    @Override
    public User selectByUserId(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public List<Object> listByNickname(String nickname, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber ,pageSize);

        List<Object> list = userMapper.listByNickname(nickname ,pageNumber ,pageSize);
        Map map = new HashMap<String,Integer>();
        map.put(new String("length"),userMapper.countByNickname(nickname));
        list.add(map);
        return list;
    }

    @Override
    public User getMyDetail(String jwt) {

        Claims claims = JwtUtils.parseJWT(jwt);
        Long userId = (Long) claims.get("userId");
        return userMapper.selectByUserId(userId);

    }

}
