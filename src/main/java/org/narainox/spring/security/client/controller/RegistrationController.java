package org.narainox.spring.security.client.controller;
import org.narainox.spring.security.client.entity.User;
import org.narainox.spring.security.client.event.RegistrationCompleteEvent;
import org.narainox.spring.security.client.model.UserModel;
import org.narainox.spring.security.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel)
    {
        User user=userService.registerUser(userModel);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user,"url"));
        return "Success";
    }
}
