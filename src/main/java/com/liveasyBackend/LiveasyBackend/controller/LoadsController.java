package com.liveasyBackend.LiveasyBackend.controller;

import com.liveasyBackend.LiveasyBackend.model.Loads;
import com.liveasyBackend.LiveasyBackend.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loads")
public class LoadsController {
    @Autowired
    LoadService loadService;
    @PostMapping("/load/{userId}")
    public ResponseEntity<String> payload( @RequestBody Loads loads,
    @PathVariable String userId){
        try{
          loadService.addLoad(loads,userId);
          return new ResponseEntity<>("loads details added successfully ", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("unable to load",HttpStatus.EXPECTATION_FAILED);
    }
    @GetMapping("/allLoad")
    public ResponseEntity<List<Loads>> getAllLoads(){
        return new ResponseEntity<>(loadService.getAllLoads(),HttpStatus.OK);
    }
    @GetMapping("load/{id}")
    public ResponseEntity<Optional<Loads>> getLoadDetails (@PathVariable String id){
        System.out.println(id);
        return new ResponseEntity<>(loadService.getLoadDetails(id),HttpStatus.OK);
    }
    @PutMapping("updateLoad")
    public ResponseEntity<String> updateLoad(@RequestBody Loads load){
        if(load.getShipperId()==null){
            return  new ResponseEntity<>("Shipping Id is missing",HttpStatus.BAD_REQUEST);
        }
        else if(!loadService.isExists(load.getShipperId())) {
            return new ResponseEntity<>("Shipment doesn't exists",HttpStatus.BAD_REQUEST);
        }
        try{
            loadService.addLoad(load,null);
            return new ResponseEntity<>("Shipment Updated Successfully",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed to update",HttpStatus.EXPECTATION_FAILED);
    }

    @DeleteMapping("deleteLoad/{id}")
    public ResponseEntity<String> deleteLoad(@PathVariable String id){
        if(loadService.deleteLoad(id)){
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to delete Load",HttpStatus.BAD_REQUEST);
    }

}
