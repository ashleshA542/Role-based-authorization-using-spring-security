package combootusingsecurity.boot.using.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

   /* @GetMapping("/index")*/

    @GetMapping("/index")
    public String index()
    {

        return "index";
    }


    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }


    @GetMapping("/userdashboard")
    public String userdashboard() {
        return "userdashboard";
    }

}