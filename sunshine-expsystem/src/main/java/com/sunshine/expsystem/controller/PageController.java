package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.TreeNode;
import com.sunshine.expsystem.service.EssayCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by kong on 16/6/7.
 */
@Controller
public class PageController {

    @Autowired
    private EssayCatService essayCatService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/chat")
    public String chat(){
        return "chat";
    }

    @RequestMapping("/ill")
    public String ill(){
        return "ill";
    }

    @RequestMapping("/chart")
    public String chart(){
        return "chart";
    }


    @RequestMapping("/additem")
    public String additem(Model model){
        List<TreeNode> nodes = essayCatService.getItemCatList(Long.valueOf(0L));
        model.addAttribute("parent", nodes);
        return "additem";
    }
}
