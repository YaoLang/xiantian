package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kong on 16/6/25.
 */
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("leavemessage/{cid}")
    public String leavemessage(@PathVariable Long cid,Model model){
        //已解决
        CommonResult noteed = noteService.findNoteByCid(cid,new Byte("1"));
        //未解决
        CommonResult noteing = noteService.findNoteByCid(cid,new Byte("2"));
        //疑难杂症
        CommonResult notefail = noteService.findNoteByCid(cid,new Byte("3"));

        model.addAttribute("noteed",noteed);
        model.addAttribute("noteing",noteing);
        model.addAttribute("notefail",notefail);
        return "leavemessage";
    }
}
