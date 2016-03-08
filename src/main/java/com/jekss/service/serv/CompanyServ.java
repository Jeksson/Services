package com.jekss.service.serv;

import com.jekss.entityes.Company;
import com.jekss.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jekss on 12.10.15.
 */
@Service
public class CompanyServ {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company){
        return companyRepository.saveAndFlush(company);
    }

    public void deleteCompany(int id){
        companyRepository.delete(id);
    }
    public Company getById(int id){
        return companyRepository.findOne(id);
    }

    public Company editeCompany(Company company){
        return companyRepository.saveAndFlush(company);
    }

    public List<Company> allCompany(){
        return companyRepository.findAll();
    }
}
