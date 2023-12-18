package com.liveasyBackend.LiveasyBackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liveasyBackend.LiveasyBackend.model.UserDetails;
import com.liveasyBackend.LiveasyBackend.service.CloudinaryService;
import com.liveasyBackend.LiveasyBackend.service.UserDetailsService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserDetailController {


    @Autowired
    UserDetailsService userService;

    @Autowired
    CloudinaryService cloudinaryService;
    public record  UserCreation(String user_Id, String profileUrl,String message){};
    @PostMapping(path = "/createUser", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UserCreation> createUser(@RequestParam("user") String User,
                                             @RequestPart("image") MultipartFile file) {

        Map data = new HashMap();
        UserDetails userDetails;
        ObjectMapper mapper = new ObjectMapper();
        try {
            userDetails = mapper.readValue(User, UserDetails.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (file != null) {
            data = cloudinaryService.upload(file);
            System.out.println(data);
        }

        try {
            userDetails.setProfileUrl(data.get("url").toString());
            UserDetails newUser=userService.createUser(userDetails);
            return new ResponseEntity<>(new UserCreation(newUser.getUserDetails_Id(),data.get("url").toString(),"User Created Successfully "), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new UserCreation(null,data.get("url").toString(),"Unable to Create User"),HttpStatus.EXPECTATION_FAILED);
    }
    @GetMapping("/getUser/{user_Id}")
    public ResponseEntity<UserDetails> getUser(@PathVariable String user_Id){
        try{
            return new ResponseEntity<>(userService.getUserDetails(user_Id),HttpStatus.OK);
        }
         catch (Exception e){
            e.printStackTrace();
         }
        return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        if(userService.deleteUser(userId)){
            return new ResponseEntity<>("user deleted successfully "+userId,HttpStatus.OK);
        }
        return new ResponseEntity<>("unable delete User "+userId,HttpStatus.EXPECTATION_FAILED);
    }

    //get list of all user having weight equal or greater

    @GetMapping("/weight/{weight}")
    public ResponseEntity<List<UserDetails>> userWeight(@PathVariable int weight){
        List<UserDetails> allUser=userService.getAllUserByWeight(weight);
        if(allUser!=null){
            return new ResponseEntity<>(allUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
    }

}
