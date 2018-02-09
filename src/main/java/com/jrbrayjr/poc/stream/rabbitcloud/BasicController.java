package com.jrbrayjr.poc.stream.rabbitcloud;

import com.jrbrayjr.poc.stream.rabbitcloud.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BasicController {

    @Autowired
    BasicService service;

    @Autowired
    UserService userService;

    @RequestMapping( value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
    public Map<String,String> home() {
        Map<String,String> result = new HashMap<>();
        result.put("data","Default endpoint");
        return result;
    }


    @RequestMapping( value = "/send", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT )
    public Map<String,String> send() {
        Map<String,String> result = new HashMap<>();
        String message = service.send();
        result.put("data",message);
        return result;
    }


    @RequestMapping( value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    public Map<String,String> sendUser() {
        Map<String,String> result = new HashMap<>();
        String message = userService.send();
        result.put("data",message);
        return result;
    }
}
