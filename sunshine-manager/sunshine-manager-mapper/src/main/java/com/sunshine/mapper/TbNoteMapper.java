package com.sunshine.mapper;

import com.sunshine.pojo.TbNote;
import com.sunshine.pojo.TbNoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoteMapper {
    int countByExample(TbNoteExample example);

    int deleteByExample(TbNoteExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbNote record);

    int insertSelective(TbNote record);

    List<TbNote> selectByExample(TbNoteExample example);

    TbNote selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByExample(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByPrimaryKeySelective(TbNote record);

    int updateByPrimaryKey(TbNote record);
}