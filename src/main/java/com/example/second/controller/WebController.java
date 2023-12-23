package com.example.second.controller;

import com.example.second.dto.Message;
import com.example.second.service.KafkaSenderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    KafkaSenderExample kafkaSenderExample;

    @GetMapping("/hello")
    private Message hello() {

        var msg = new Message();
        msg.setMyMessage("hello, omega!");

        kafkaSenderExample.sendMessage(msg, "demo_topic");
        return msg;
        // Mono.just(msg);
    }

}
