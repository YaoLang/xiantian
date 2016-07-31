package com.sunshine.expsystem.service;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbPropertiesDictionary;

/**
 * Created by kong on 16/7/26.
 */
public interface DictionaryService {

    /**
     * 插入字典
     * @param name
     * @param parentid
     * @return
     */
    CommonResult insertDictionary(String name,Integer value,Long parentid);

    /**
     * 更新字典
     * @param dictionary
     * @return
     */
    CommonResult updateDictionary(TbPropertiesDictionary dictionary);

    /**
     * 查询父ID下所有子元素
     * @param parentid
     * @return
     */
    CommonResult getDictionarysByParentid(Long parentid);
}
