package org.narainox.spring.security.client.service;

import org.narainox.spring.security.client.entity.User;
import org.narainox.spring.security.client.model.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
