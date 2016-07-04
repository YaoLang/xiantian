package com.sunshine.mapper;

import com.sunshine.pojo.TbEssay;
import com.sunshine.pojo.TbEssayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEssayMapper {
    int countByExample(TbEssayExample example);

    int deleteByExample(TbEssayExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbEssay record);

    int insertSelective(TbEssay record);

    List<TbEssay> selectByExample(TbEssayExample example);

    TbEssay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEssay record, @Param("example") TbEssayExample example);

    int updateByExample(@Param("record") TbEssay record, @Param("example") TbEssayExample example);

    int updateByPrimaryKeySelective(TbEssay record);

    int updateByPrimaryKey(TbEssay record);
}