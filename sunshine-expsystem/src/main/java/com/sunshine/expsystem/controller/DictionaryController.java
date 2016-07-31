package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.DictionaryService;
import com.sunshine.pojo.TbPropertiesDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kong on 16/7/26.
 */
@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/dictionary/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insertDictionary(String name,Integer value,Long parentid){
        return dictionaryService.insertDictionary(name,value,parentid);
    }

    @RequestMapping(value = "/dictionary/modify",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDictionary(TbPropertiesDictionary dictionary){
        return dictionaryService.updateDictionary(dictionary);
    }

    @RequestMapping("/dictionary/{parentid}")
    @ResponseBody
    public CommonResult getDictionarysByParentid(@PathVariable Long parentid){
        return dictionaryService.getDictionarysByParentid(parentid);
    }

    @RequestMapping("/ill")
    public String ill(Model model){
//        CommonResult ills = dictionaryService.getDictionarysByParentid(1L);
//        model.addAttribute("ill",ills);
        return "ill";
    }
}
