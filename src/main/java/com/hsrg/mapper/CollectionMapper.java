package com.hsrg.mapper;

import com.hsrg.pojo.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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

    @Delete("delete from collection where user_id = #{userId} and file_id = #{fileId}")
    public void deleteCollection(Collection collection);


}
