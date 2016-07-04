package com.sunshine.expsystem.service;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbEssay;
import com.sunshine.pojo.TbEssayContent;

/**
 * Created by kong on 16/6/29.
 */
public interface EssayService {

    /**
     * 获取知识库分类
     * @param parentid
     * @param status
     * @return
     */
    public CommonResult getEssayCategories(Long parentid,Integer status);

    /**
     * 根据分类查询知识库
     * @param cid
     * @param status
     * @return
     */
    public CommonResult findEssayByCid(Long cid,Byte status);

    /**
     * 获取知识详细内容
     * @param id
     * @return
     */
    public CommonResult findEssayContentById(String id);

    /**
     * 根据ID查询知识
     * @param id
     * @return
     */
    public CommonResult findEssayById(String id);

    /**
     * 添加文档
     * @param tbEssa
     * @param tbEssayContent
     * @return
     */
    public CommonResult insertEssay(TbEssay tbEssa,TbEssayContent tbEssayContent);

}
