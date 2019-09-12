package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.User;
import com.example.springbootwebsocket.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @MessageMapping("/user")
    @SendTo("/topic/user") // send the message to the broker "/topic/user"
    public UserResponse getUser(User user) {
        // get the message: User from UI
        // wrap the message with the message wrapper: UserResponse
        return new UserResponse("Hello, " + user.getName());
    }
}
