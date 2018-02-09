package com.jrbrayjr.poc.stream.rabbitcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    @Autowired
    BasicHelperComponent helper;

    public String send() {
        String result = "**** SEND MESSAGE SERVICE ****";
        System.out.println(result);
        Message<String> message = new GenericMessage<String>("Hello, World!");
        this.helper.send(message);
        return result;
    }
}
