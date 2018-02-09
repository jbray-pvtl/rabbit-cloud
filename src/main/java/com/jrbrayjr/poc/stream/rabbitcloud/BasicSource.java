package com.jrbrayjr.poc.stream.rabbitcloud;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;

public interface BasicSource {

    String BASIC_QUEUE = "basicoutputchannel";

    @Output(BasicSource.BASIC_QUEUE)
    MessageChannel basicOutputChannel();
}
