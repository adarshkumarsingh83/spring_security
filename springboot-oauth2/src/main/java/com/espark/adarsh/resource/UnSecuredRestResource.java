package com.espark.adarsh.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnSecuredRestResource {


    @GetMapping("/service/message")
    public String getWishMessage(){
        return "welcome to the espark ";
    }


}
