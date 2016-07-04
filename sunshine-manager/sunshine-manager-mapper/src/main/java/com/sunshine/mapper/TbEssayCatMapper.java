package com.sunshine.mapper;

import com.sunshine.pojo.TbEssayCat;
import com.sunshine.pojo.TbEssayCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEssayCatMapper {
    int countByExample(TbEssayCatExample example);

    int deleteByExample(TbEssayCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbEssayCat record);

    int insertSelective(TbEssayCat record);

    List<TbEssayCat> selectByExample(TbEssayCatExample example);

    TbEssayCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbEssayCat record, @Param("example") TbEssayCatExample example);

    int updateByExample(@Param("record") TbEssayCat record, @Param("example") TbEssayCatExample example);

    int updateByPrimaryKeySelective(TbEssayCat record);

    int updateByPrimaryKey(TbEssayCat record);
}