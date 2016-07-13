package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.PoultryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kong on 16/7/6.
 */
@Controller
public class IllController {

    @Autowired
    private PoultryService poultryService;

    @RequestMapping("/ill")
    public String ill(Model model){
        CommonResult ills = poultryService.getTopics();
        model.addAttribute("ill",ills);
        return "ill";
    }
}
