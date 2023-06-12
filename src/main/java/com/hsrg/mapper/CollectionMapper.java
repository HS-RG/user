package com.hsrg.mapper;

import com.hsrg.pojo.Collection;
import com.hsrg.pojo.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface CollectionMapper {
    @Insert("insert into collection(user_id ,file_id ,create_time )"+
    "values (#{userId} ,#{fileId} ,#{createTime})")
    public void createCollection(Collection collection);

    public void deleteCollection(Collection collection);


    public List<File> listCollectionByUserId(Long userId, Integer pageNumber, Integer pageSize);

    public Integer countCollectionByUserId(Long userId);


    @Select("select count(*) from collection where file_id = #{fileId}")
    public Long countCollectionByFile(String fileId);

    @Select("select * from collection where file_id=#{fileId} and user_id=#{userId}")
    Boolean selectByUserIdAndFileId(Long userId, Long fileId);
}
