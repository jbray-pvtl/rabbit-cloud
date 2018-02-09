package com.jrbrayjr.poc.stream.rabbitcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class BasicHelperComponent {

    @Autowired
    BasicSource source;

    public void send(Message message) {
        System.out.println("**** SEND MESSAGE SERVICE **** " + message.getPayload().toString());
        source.basicOutputChannel().send(MessageBuilder.withPayload(message.getPayload()).build());
    }

}
