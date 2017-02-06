package com.ironyard.controller;

import com.ironyard.data.MovieUser;
import com.ironyard.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jasonskipper on 2/6/17.
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(path = "/authenticate", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model data, @RequestParam(name = "username") String usr, @RequestParam String password){
        MovieUser found = userRepo.findByUsernameAndPassword(usr, password);
        String destinationView = "home";
        if(found == null){
            // no user found, login must fail
            destinationView = "login";
            data.addAttribute("message", "User/Pass combination not found.");
        }else{
            request.getSession().setAttribute ("message", "Welcome to my movie store.");
            destinationView = "redirect:/movies";
        }
        return destinationView;
    }
}
