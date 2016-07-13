package com.sunshine.expsystem.service.impl;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.dao.JedisClient;
import com.sunshine.expsystem.service.EssayService;
import com.sunshine.mapper.TbEssayCatMapper;
import com.sunshine.mapper.TbEssayContentMapper;
import com.sunshine.mapper.TbEssayMapper;
import com.sunshine.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by kong on 16/6/29.
 */
@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private TbEssayCatMapper tbEssayCatMapper;

    @Autowired
    private TbEssayMapper tbEssayMapper;

    @Autowired
    private TbEssayContentMapper tbEssayContentMapper;

    @Value("${ESSAY_KEY}")
    private String ESSAY_KEY;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public CommonResult getEssayCategories(Long parentid, Integer status) {
        TbEssayCatExample example = new TbEssayCatExample();
        example.setOrderByClause("sort_order");
        example.createCriteria().andParentIdEqualTo(parentid).andStatusEqualTo(status);

        List<TbEssayCat> tbEssayCats = tbEssayCatMapper.selectByExample(example);

        return CommonResult.ok(tbEssayCats);
    }

    @Override
    public CommonResult findEssayByCid(Long cid, Byte status) {
        TbEssayExample essayExample = new TbEssayExample();
        essayExample.createCriteria().andCidEqualTo(cid).andStatusEqualTo(status);

        List<TbEssay> tbEssays = tbEssayMapper.selectByExample(essayExample);

        return CommonResult.ok(tbEssays);
    }

    @Override
    public CommonResult findEssayContentById(String id) {
        TbEssayContent content = tbEssayContentMapper.selectByPrimaryKey(id);
        return CommonResult.ok(content);
    }

    @Override
    public CommonResult findEssayById(String id) {
        TbEssay essay = tbEssayMapper.selectByPrimaryKey(id);
        return CommonResult.ok(essay);
    }

    @Override
    public CommonResult insertEssay(TbEssay tbEssay,TbEssayContent tbEssayContent) {
        long key = jedisClient.incr(ESSAY_KEY);

        tbEssay.setId(String.valueOf(key));
        tbEssay.setAuther(1L);
        tbEssay.setAuthername("yaolang");
        tbEssay.setStatus(new Byte("1"));
        tbEssay.setCollectnum(0);
        tbEssay.setCommentnum(0);
        tbEssay.setCreated(new Date());
        tbEssay.setUpdated(new Date());

        tbEssayContent.setessayid(String.valueOf(key));
        tbEssayContent.setCreated(new Date());
        tbEssayContent.setUpdated(new Date());

        System.out.println(tbEssay.getTitle());
        tbEssayMapper.insert(tbEssay);
        tbEssayContentMapper.insert(tbEssayContent);
        return CommonResult.ok();
    }
}
