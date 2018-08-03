package com.xywy.lucene.mapper;

import com.xywy.lucene.model.Doctor;
import com.xywy.lucene.model.DoctorExample;
import com.xywy.lucene.model.DoctorWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorMapper {
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DoctorWithBLOBs record);

    int insertSelective(DoctorWithBLOBs record);

    List<DoctorWithBLOBs> selectByExampleWithBLOBs(DoctorExample example);

    List<Doctor> selectByExample(DoctorExample example);

    DoctorWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DoctorWithBLOBs record, @Param("example") DoctorExample example);

    int updateByExampleWithBLOBs(@Param("record") DoctorWithBLOBs record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(DoctorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DoctorWithBLOBs record);

    int updateByPrimaryKey(Doctor record);

    List<DoctorWithBLOBs> getDoctors(@Param("limit")Integer limit,@Param("offset")Integer offset);
}