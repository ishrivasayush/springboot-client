package org.narainox.spring.security.client.event.listner;

import lombok.extern.slf4j.Slf4j;
import org.narainox.spring.security.client.entity.User;
import org.narainox.spring.security.client.event.RegistrationCompleteEvent;
import org.narainox.spring.security.client.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;



@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
      //Create the verification Token for the User with Link
        User user =event.getUser();
        String token=UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        // Send mail to User
        String url=
                event.getApplicationUrl()
                        +"verfyRegistration="
                +token;
        //SendVerificationEmail()
        log.info("Click the link to verify your account: {}",url);
    }

}
