package com.sunshine.expsystem.service.impl;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.NoteService;
import com.sunshine.mapper.TbNoteCatMapper;
import com.sunshine.mapper.TbNoteMapper;
import com.sunshine.pojo.TbNote;
import com.sunshine.pojo.TbNoteCat;
import com.sunshine.pojo.TbNoteCatExample;
import com.sunshine.pojo.TbNoteExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kong on 16/6/25.
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private TbNoteCatMapper tbNoteCatMapper;

    @Autowired
    private TbNoteMapper tbNoteMapper;

    @Override
    public CommonResult getNoteCategories(Long parentid) {
        TbNoteCatExample example = new TbNoteCatExample();
        example.setOrderByClause("sort_order");
        example.createCriteria().andParentIdEqualTo(parentid).andStatusEqualTo(1);

        List<TbNoteCat> tbNoteCats = tbNoteCatMapper.selectByExample(example);

        return CommonResult.ok(tbNoteCats);
    }

    @Override
    public CommonResult findNoteByCid(Long cid,Byte status){
        TbNoteExample example = new TbNoteExample();
        example.createCriteria().andCidEqualTo(cid).andStatusEqualTo(status);

        List<TbNote> tbNotes = tbNoteMapper.selectByExample(example);

        return CommonResult.ok(tbNotes);
    }
}
