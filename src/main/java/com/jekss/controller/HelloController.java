package com.jekss.controller;

import com.jekss.service.serv.CompanyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;


/**
 * Created by jekss on 12.10.15.
 */
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private CompanyServ companyServ;

    @RequestMapping(method = RequestMethod.GET)
    public String homePages(Model model, ServletRequest request){
        System.out.println(request.getRemoteAddr());


        model.addAttribute("allCompany", companyServ.allCompany());
        return "welcomepage";
    }

}
