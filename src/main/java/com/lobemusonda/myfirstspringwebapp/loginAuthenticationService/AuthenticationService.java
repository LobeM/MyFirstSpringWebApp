package com.lobemusonda.myfirstspringwebapp.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password) {
        boolean isValidUserName= name.equalsIgnoreCase("admin01");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidUserName && isValidPassword;
    }
}
