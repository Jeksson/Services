package com.jekss.service.serv;

import com.jekss.entityes.AdressCompany;
import com.jekss.repository.AdressCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jekss on 12.10.15.
 */
@Service
public class AdressCompanyServ {

    @Autowired
    private AdressCompanyRepository adressCompanyRepository;

    public AdressCompany addAdressCompany(AdressCompany adressCompany){

        return adressCompanyRepository.saveAndFlush(adressCompany);
    }

    public void deleteAdressComp(int id){
        adressCompanyRepository.delete(id);
    }

    public AdressCompany editeAdressComp(AdressCompany adressCompany){
        return adressCompanyRepository.saveAndFlush(adressCompany);
    }

    public List<AdressCompany> allAdressCompany(){
        return adressCompanyRepository.findAll();
    }
}
