package com.jekss.service.serv;

import com.jekss.entityes.Services;
import com.jekss.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jekss on 12.10.15.
 */
@Service
public class ServicesServ {

    @Autowired
    private ServicesRepository servicesRepository;

    public Services addServices(Services services){
        return servicesRepository.saveAndFlush(services);
    }

    public void deleteServices(int id){
        servicesRepository.delete(id);
    }

    public Services editeServices(Services services){
        return servicesRepository.saveAndFlush(services);
    }

    public List<Services> allServices(){
        return servicesRepository.findAll();
    }
}
