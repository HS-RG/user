package com.hsrg.service.impl;

import com.hsrg.pojo.Collection;
import com.hsrg.mapper.CollectionMapper;
import com.hsrg.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void createCollection(Collection collection) {
        collectionMapper.createCollection(collection);
    }

    @Override
    public void deleteCollection(Collection collection) {
        collectionMapper.deleteCollection(collection);
    }
}
