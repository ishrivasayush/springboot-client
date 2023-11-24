package org.narainox.spring.security.client.entity.listner;

import org.narainox.spring.security.client.entity.User;
import org.narainox.spring.security.client.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
      //Create the verification Token for the User with Link
        User user=event.getUser();
        String token= UUID.randomUUID().toString();
        // Send mail to User
    }
}
