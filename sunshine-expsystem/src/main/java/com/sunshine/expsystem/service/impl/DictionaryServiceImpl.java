package com.sunshine.expsystem.service.impl;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.DictionaryService;
import com.sunshine.mapper.TbPropertiesDictionaryMapper;
import com.sunshine.pojo.TbPropertiesDictionary;
import com.sunshine.pojo.TbPropertiesDictionaryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by kong on 16/7/26.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private TbPropertiesDictionaryMapper tbPropertiesDictionaryMapper;

    @Override
    public CommonResult insertDictionary(String name,Integer value, Long parentid) {
        TbPropertiesDictionary dictionary = new TbPropertiesDictionary();
        dictionary.setName(name);
        dictionary.setParentid(parentid);
        dictionary.setSortOrder(1);
        dictionary.setStatus(1);
        dictionary.setValue(value);
        dictionary.setCreated(new Date());
        dictionary.setUpdated(new Date());
        tbPropertiesDictionaryMapper.insertSelective(dictionary);
        return CommonResult.ok(dictionary);
    }

    @Override
    public CommonResult updateDictionary(TbPropertiesDictionary dictionary) {
        dictionary.setUpdated(new Date());
        int result = tbPropertiesDictionaryMapper.updateByPrimaryKeySelective(dictionary);
        return CommonResult.ok(result);
    }

    @Override
    public CommonResult getDictionarysByParentid(Long parentid) {
        TbPropertiesDictionaryExample example = new TbPropertiesDictionaryExample();
        example.createCriteria().andParentidEqualTo(parentid);

        List<TbPropertiesDictionary> dictionaries = tbPropertiesDictionaryMapper.selectByExample(example);
        return CommonResult.ok(dictionaries);
    }
}
