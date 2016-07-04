package com.sunshine.expsystem.service;

import com.sunshine.common.pojo.CommonResult;

/**
 * Created by kong on 16/6/25.
 */
public interface NoteService {

    /**
     * 获取分类
     * @param parentid
     * @return
     */
    public CommonResult getNoteCategories(Long parentid);

    /**
     * 根据分类查询帖子
     * @param cid
     * @param status
     * @return
     */
    public CommonResult findNoteByCid(Long cid,Byte status);
}
