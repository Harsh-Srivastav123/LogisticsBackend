package com.liveasyBackend.LiveasyBackend.controller;

import com.liveasyBackend.LiveasyBackend.model.Loads;
import com.liveasyBackend.LiveasyBackend.model.UserLoads;
import com.liveasyBackend.LiveasyBackend.service.LoadService;
import com.liveasyBackend.LiveasyBackend.service.UserDetailsService;
import org.apache.http.protocol.HTTP;
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
    public record LoadMessage(String shipped_id,String message){};
    @Autowired
    LoadService loadService;
    @Autowired
    UserDetailsService userDetailsService;
    public  record  UserMessage(String userId, String shipped_Id,String message){};
    @PostMapping("/load")
    public ResponseEntity<LoadMessage> payload( @RequestBody Loads loads){

        Loads loads1=loadService.addLoad(loads);
        if(loads1!=null){
            return new ResponseEntity<>(new LoadMessage(loads1.getShipperId(),"Load details added successfully"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new LoadMessage(null,"unable to load"),HttpStatus.EXPECTATION_FAILED);
    }
    @PostMapping("/userLoad")
    public ResponseEntity<UserMessage> UserPayload(@RequestBody UserLoads userLoads){
//        System.out.println(userLoads.getUser_Id());
        Loads loads=loadService.addUserLoad(userLoads.getLoads(),userLoads.getUser_Id());
        if(!userDetailsService.existsById(userLoads.getUser_Id())){
            return new ResponseEntity<>(new UserMessage(userLoads.getUser_Id(),null,"User Doesn't Exist"), HttpStatus.EXPECTATION_FAILED);
        }
        if(loads!=null){
            return new ResponseEntity<>(new UserMessage(userLoads.getUser_Id(),loads.getShipperId(),"Loads successfully added in User Account"), HttpStatus.OK);

        }
        return new ResponseEntity<>(new UserMessage(userLoads.getUser_Id(), null,"Unable to add Load in user Account "),HttpStatus.EXPECTATION_FAILED);
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
    public ResponseEntity<LoadMessage> updateLoad(@RequestBody Loads load){
        if(load.getShipperId()==null){
            return  new ResponseEntity<>(new LoadMessage(null,"Shipping Id is missing"),HttpStatus.BAD_REQUEST);
        }
        if(!loadService.isExists(load.getShipperId())) {
            return new ResponseEntity<>(new LoadMessage(load.getShipperId(),"Shipment doesn't exists"),HttpStatus.BAD_REQUEST);
        }
        if(loadService.updateLoad(load)){
            return new ResponseEntity<>(new LoadMessage(load.getShipperId(),"Load updated successfully"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new LoadMessage(load.getShipperId(), "Failed to update"),HttpStatus.EXPECTATION_FAILED);
    }

    @DeleteMapping("deleteLoad/{id}")
    public ResponseEntity<LoadMessage> deleteLoad(@PathVariable String id){
        if(loadService.deleteLoad(id)){
            return new ResponseEntity<>(new LoadMessage(id,"Deleted Successfully"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new LoadMessage(id,"Unable to delete Load"),HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/loadingPoint/{loadingPoint}")
    public ResponseEntity<List<Loads>> getLoadsWithLoadingPoint(@PathVariable String loadingPoint){
        List<Loads> allLoads=loadService.getAllLoadsWithLoadingPoint(loadingPoint);
        if(allLoads!=null){
            return new ResponseEntity<>(allLoads,HttpStatus.OK);
        }
        return new ResponseEntity<>(allLoads,HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/unloadingPoint/{unloadingPoint}")
    public ResponseEntity<List<Loads>> getLoadsWithUnloadingPoint(@PathVariable String unloadingPoint){
        List<Loads> allLoads=loadService.getAllLoadsWithUnloadingPoint(unloadingPoint);
        if(allLoads!=null){
            return new ResponseEntity<>(allLoads,HttpStatus.OK);
        }
        return new ResponseEntity<>(allLoads,HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/productType/{productType}")
    public ResponseEntity<List<Loads>> getLoadsWithProductType(@PathVariable String productType){
        List<Loads> allLoads=loadService.getAllLoadsWithProductType(productType);
        if(allLoads!=null){
            return new ResponseEntity<>(allLoads,HttpStatus.OK);
        }
        return new ResponseEntity<>(allLoads,HttpStatus.EXPECTATION_FAILED);
    }

}
