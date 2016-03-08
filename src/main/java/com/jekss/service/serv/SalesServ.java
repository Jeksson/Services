package com.jekss.service.serv;

import com.jekss.entityes.Sales;
import com.jekss.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jekss on 12.10.15.
 */
@Service
public class SalesServ {

    @Autowired
    private SalesRepository salesRepository;

    public Sales addSales(Sales sales){
        return salesRepository.saveAndFlush(sales);
    }
    public Sales getById(int id){
        return salesRepository.findOne(id);
    }

    public void deleteSales(int id){
        salesRepository.delete(id);
    }

    public Sales editeSales(Sales sales){
        return salesRepository.saveAndFlush(sales);
    }

    public List<Sales> allSales(){
        return salesRepository.findAll();
    }
}
