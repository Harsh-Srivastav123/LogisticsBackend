package com.liveasyBackend.LiveasyBackend.controller;


import com.liveasyBackend.LiveasyBackend.model.UserDetails;
import com.liveasyBackend.LiveasyBackend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserDetailController {


    @Autowired
    UserDetailsService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDetails user){
        try {
            UserDetails newUser=userService.createUser(user);
            return new ResponseEntity<>("User Created Successfully "+newUser.getUserDetails_Id(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Unable to Create User",HttpStatus.EXPECTATION_FAILED);
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
    @GetMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        if(userService.deleteUser(userId)){
            return new ResponseEntity<>("user deleted successfully "+userId,HttpStatus.OK);
        }
        return new ResponseEntity<>("unable delete User "+userId,HttpStatus.EXPECTATION_FAILED);
    }


}
