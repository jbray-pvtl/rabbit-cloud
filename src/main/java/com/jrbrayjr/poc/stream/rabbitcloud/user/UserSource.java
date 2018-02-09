package com.jrbrayjr.poc.stream.rabbitcloud.user;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserSource {

    String USER_QUEUE = "useroutputchannel";

    @Output(UserSource.USER_QUEUE)
    MessageChannel userOutputChannel();
}
