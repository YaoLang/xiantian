package com.sunshine.mapper;

import com.sunshine.pojo.TbNoteContent;
import com.sunshine.pojo.TbNoteContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoteContentMapper {
    int countByExample(TbNoteContentExample example);

    int deleteByExample(TbNoteContentExample example);

    int deleteByPrimaryKey(String noteid);

    int insert(TbNoteContent record);

    int insertSelective(TbNoteContent record);

    List<TbNoteContent> selectByExampleWithBLOBs(TbNoteContentExample example);

    List<TbNoteContent> selectByExample(TbNoteContentExample example);

    TbNoteContent selectByPrimaryKey(String noteid);

    int updateByExampleSelective(@Param("record") TbNoteContent record, @Param("example") TbNoteContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbNoteContent record, @Param("example") TbNoteContentExample example);

    int updateByExample(@Param("record") TbNoteContent record, @Param("example") TbNoteContentExample example);

    int updateByPrimaryKeySelective(TbNoteContent record);

    int updateByPrimaryKeyWithBLOBs(TbNoteContent record);

    int updateByPrimaryKey(TbNoteContent record);
}