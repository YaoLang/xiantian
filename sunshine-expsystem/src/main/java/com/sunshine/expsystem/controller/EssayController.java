package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.EssayCatService;
import com.sunshine.expsystem.service.EssayService;
import com.sunshine.pojo.TbEssay;
import com.sunshine.pojo.TbEssayCat;
import com.sunshine.pojo.TbEssayContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kong on 16/6/29.
 */
@Controller
public class EssayController {

    @Autowired
    private EssayService essayService;

    @Autowired
    private EssayCatService essayCatService;

    @RequestMapping("/essay/{cid}")
    public String  getEssayByCid(@PathVariable Long cid,Model model){
        CommonResult commonResult =  essayService.findEssayByCid(cid, new Byte("1"));

        TbEssayCat cat = essayCatService.getEssayCatById(cid);

        model.addAttribute("essaylist",commonResult);
        if(cat!=null)
            model.addAttribute("essaycatname",cat.getName());
        return "item";
    }

    @RequestMapping("/essaycontent/{id}")
    public String essay(@PathVariable String id,Model model){
        CommonResult result = essayService.findEssayContentById(id);
        model.addAttribute("essaycontent",result);

        CommonResult note = essayService.findEssayById(id);
        model.addAttribute("essaytitle",note);
        return "essay";
    }

    @RequestMapping(value = "/essay",method = RequestMethod.POST)
    public String addEssay(String title,String subtitle,Long cid,@RequestParam(value="editorValue") String desc){

        TbEssay tbEssay = new TbEssay();
        tbEssay.setSubtitle(subtitle);
        tbEssay.setTitle(title);
        tbEssay.setCid(cid);

        TbEssayContent tbEssayContent = new TbEssayContent();
        tbEssayContent.setContentDesc(desc);
        essayService.insertEssay(tbEssay,tbEssayContent);
        return "200";
    }

}
