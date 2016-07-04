package com.sunshine.mapper;

import com.sunshine.pojo.TbEssayContent;
import com.sunshine.pojo.TbEssayContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEssayContentMapper {
    int countByExample(TbEssayContentExample example);

    int deleteByExample(TbEssayContentExample example);

    int deleteByPrimaryKey(String noteid);

    int insert(TbEssayContent record);

    int insertSelective(TbEssayContent record);

    List<TbEssayContent> selectByExampleWithBLOBs(TbEssayContentExample example);

    List<TbEssayContent> selectByExample(TbEssayContentExample example);

    TbEssayContent selectByPrimaryKey(String noteid);

    int updateByExampleSelective(@Param("record") TbEssayContent record, @Param("example") TbEssayContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbEssayContent record, @Param("example") TbEssayContentExample example);

    int updateByExample(@Param("record") TbEssayContent record, @Param("example") TbEssayContentExample example);

    int updateByPrimaryKeySelective(TbEssayContent record);

    int updateByPrimaryKeyWithBLOBs(TbEssayContent record);

    int updateByPrimaryKey(TbEssayContent record);
}