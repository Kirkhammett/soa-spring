package org.estore.finki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dragan on 17.4.17.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false)String error,
                                  @RequestParam(value = "logout", required = false)String logout) {
        ModelAndView modelAndView = new ModelAndView();

        if (error != null) {
            modelAndView.addObject("error", error);
        }

        if (logout != null) {
            modelAndView.addObject("logout", logout);
        }

        modelAndView.setViewName("login");
        return modelAndView;
    }
}
