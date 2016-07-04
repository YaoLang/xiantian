package com.sunshine.mapper;

import com.sunshine.pojo.TbNoteComment;
import com.sunshine.pojo.TbNoteCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoteCommentMapper {
    int countByExample(TbNoteCommentExample example);

    int deleteByExample(TbNoteCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbNoteComment record);

    int insertSelective(TbNoteComment record);

    List<TbNoteComment> selectByExampleWithBLOBs(TbNoteCommentExample example);

    List<TbNoteComment> selectByExample(TbNoteCommentExample example);

    TbNoteComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbNoteComment record, @Param("example") TbNoteCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbNoteComment record, @Param("example") TbNoteCommentExample example);

    int updateByExample(@Param("record") TbNoteComment record, @Param("example") TbNoteCommentExample example);

    int updateByPrimaryKeySelective(TbNoteComment record);

    int updateByPrimaryKeyWithBLOBs(TbNoteComment record);

    int updateByPrimaryKey(TbNoteComment record);
}