package org.vvchebotar.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * first
 *
 * @author user
 *
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "forward:/welcome";
    }


    @RequestMapping("/home")
    public String welcome() {
        return "forward:/welcome";
    }

    @RequestMapping("/welcome")
    public String greeting(Model model) {
        /**
         * to save variables for jsp
         */
        model.addAttribute("greeting", "Welcome to Crud Test Task developed by Victor Chebotar!");
        model.addAttribute("tagline", "Click link below to access the books list");
        return "welcome";
    }

}

