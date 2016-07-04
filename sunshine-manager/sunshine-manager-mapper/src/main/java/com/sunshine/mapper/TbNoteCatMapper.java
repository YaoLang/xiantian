package com.sunshine.mapper;

import com.sunshine.pojo.TbNoteCat;
import com.sunshine.pojo.TbNoteCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoteCatMapper {
    int countByExample(TbNoteCatExample example);

    int deleteByExample(TbNoteCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbNoteCat record);

    int insertSelective(TbNoteCat record);

    List<TbNoteCat> selectByExample(TbNoteCatExample example);

    TbNoteCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbNoteCat record, @Param("example") TbNoteCatExample example);

    int updateByExample(@Param("record") TbNoteCat record, @Param("example") TbNoteCatExample example);

    int updateByPrimaryKeySelective(TbNoteCat record);

    int updateByPrimaryKey(TbNoteCat record);
}