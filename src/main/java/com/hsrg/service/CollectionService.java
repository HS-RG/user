package com.hsrg.service;

import com.hsrg.pojo.Collection;

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
}
