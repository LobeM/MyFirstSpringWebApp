package com.lobemusonda.myfirstspringwebapp.login;

import com.lobemusonda.myfirstspringwebapp.loginAuthenticationService.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if(authenticationService.authenticate(name, password)) {
            model.put("name", name);
            // Authenticate the user
            // name - "admin01"
            // password - "dummy"

            return "welcome";
        }

        model.put("errorMessage", "Invalid username or password");
        return "login";
    }
}
