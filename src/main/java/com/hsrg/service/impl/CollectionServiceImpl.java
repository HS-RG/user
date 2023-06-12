package com.hsrg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hsrg.clients.FileClient;
import com.hsrg.pojo.Collection;
import com.hsrg.mapper.CollectionMapper;
import com.hsrg.pojo.File;
import com.hsrg.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private FileClient fileClient;

    @Override
    public void createCollection(Collection collection) {
        collection.setCreateTime(LocalDateTime.now());
        collectionMapper.createCollection(collection);
    }

    @Override
    public void deleteCollection(Collection collection) {
        collectionMapper.deleteCollection(collection);
    }

    @Override
    public List<Object> listCollectionByUserId(Long userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);

        List<File> list1 = collectionMapper.listCollectionByUserId(userId, pageNumber, pageSize);
        List<Object> list = new ArrayList<Object>();
        list1.forEach(file -> {
            list.add(fileClient.QueryFileByFileId(file));
        });

        Map map = new HashMap<String,Integer>();
        map.put(new String("length"),collectionMapper.countCollectionByUserId(userId));
        list.add(map);

        return list;
    }

    @Override
    public Long countCollectionByFile(String fileId) {
        return collectionMapper.countCollectionByFile(fileId);
    }

    @Override
    public Boolean determineIsCollected(Long userId, Long fileId) {
        return collectionMapper.selectByUserIdAndFileId(userId,fileId);
    }
}
