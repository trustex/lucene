package com.xywy.lucene.mapper;


import com.xywy.lucene.model.Baike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaikeMapper {
    List<Baike> getAllBaike(@Param("limit") int limit,@Param("offset") int offset);
}