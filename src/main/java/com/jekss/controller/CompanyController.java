package com.jekss.controller;

import com.jekss.entityes.Company;
import com.jekss.service.serv.CompanyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jekss on 05.11.15.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServ companyServ;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String companyPage(@PathVariable int id, Model model){
        Company company = companyServ.getById(id);
        //System.out.println(company.toString());
        model.addAttribute("company", company);

        return "companypage";
    }
}
