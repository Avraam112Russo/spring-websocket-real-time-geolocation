package com.n1nt3nd0.geowebsocketspringapp.controller;

import com.n1nt3nd0.geowebsocketspringapp.model.Location;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class LocationController {
    private final SimpMessagingTemplate wsTemplate;

    @MessageMapping("/location")
    public void sendLocation(@Payload Location location) {
        log.info("Received location : {}", location);
        wsTemplate.convertAndSendToUser(location.getRecipient(), "/user-locations", location);
    }
}
