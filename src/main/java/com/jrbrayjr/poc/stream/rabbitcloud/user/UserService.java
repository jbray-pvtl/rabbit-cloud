package com.jrbrayjr.poc.stream.rabbitcloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserHelperComponent helper;

    Message<String> message;

    public UserService() {
        buildMessage("Default User");
    }

    public String send() {
        String result = this.message.getPayload();
        helper.send(this.message);
        return result;
    }

    Message<String> buildMessage(String str) {
        this.message = new UserMessage(str);
        return this.message;
    }
}
