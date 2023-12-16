package com.liveasyBackend.LiveasyBackend.service;

import com.liveasyBackend.LiveasyBackend.dao.LaodDAO;
import com.liveasyBackend.LiveasyBackend.dao.UserDetailsDAO;
import com.liveasyBackend.LiveasyBackend.model.Loads;
import com.liveasyBackend.LiveasyBackend.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    @Autowired
    LaodDAO loadDAO;
    @Autowired
    UserDetailsDAO userDAO;

    public void addLoad(Loads loads,String userId) {


        if(userDAO.existsById(userId)){
            loads.setUserDetails(userDAO.getReferenceById(userId));
            UserDetails user=userDAO.getReferenceById(userId);
            user.setTotalWeight(user.getTotalWeight()+loads.getWeight());
            user.getPreviousLoads().add(loads);
            userDAO.save(user);
        }

    }
    public List<Loads> getAllLoads(){

        try{
            return loadDAO.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Loads> getLoadDetails(String id) {
        try{
            return loadDAO.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean isExists(String id){
        Optional<Loads> loads=loadDAO.findById(id);
        if(loads.isEmpty()){
            return false;
        }
        else {
            return loadDAO.existsById(loads.get().getShipperId());
        }
    }

    public boolean deleteLoad(String id) {
        try {
            loadDAO.delete(loadDAO.getReferenceById(id));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }
}
