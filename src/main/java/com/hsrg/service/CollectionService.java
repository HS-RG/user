package com.hsrg.service;

import com.hsrg.pojo.Collection;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
public interface CollectionService {

    void createCollection(Collection collection);
    void deleteCollection(Collection collection);

    List<Collection> listCollectionByUserId(Long userId,Integer pageNumber, Integer pageSize);

    Long countCollectionByFile(String fileId);
}
