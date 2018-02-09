package com.jrbrayjr.poc.stream.rabbitcloud.user;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;

public class UserMessage implements Message<String> {

    private String userMsg;

    public UserMessage(String userMsg) {
        this.userMsg = userMsg;
    }

    @Override
    public String getPayload() {
        return userMsg;
    }

    @Override
    public MessageHeaders getHeaders() {
        Map<String,Object> myMap = new HashMap<>();
        myMap.put("Content-Type","plain/text");
        return new MessageHeaders(myMap);
    }
}
