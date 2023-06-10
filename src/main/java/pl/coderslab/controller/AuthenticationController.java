package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AuthenticationController {

    @GetMapping(path = "/login")
    String login() {
        return "login";
    }
}
