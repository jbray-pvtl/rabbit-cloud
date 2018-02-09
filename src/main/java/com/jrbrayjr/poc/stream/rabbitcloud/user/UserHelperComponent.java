package com.jrbrayjr.poc.stream.rabbitcloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserHelperComponent {

    @Autowired
    UserSource source;

    /**
     *
     * @param message
     */
    public void send(Message message) {
        source.userOutputChannel().send(MessageBuilder.withPayload(message.getPayload()).build());
    }
}
