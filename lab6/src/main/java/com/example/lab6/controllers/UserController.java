package com.example.lab6.controllers;

import com.example.lab6.entity.User;
import com.example.lab6.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller

public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model m) {
        m.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPagePOST(@Valid User user, BindingResult binding) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            binding.rejectValue("login", "", "Login jest już zajęty");
        }
        if (binding.hasErrors()) {
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profilePage(Model m, Principal principal) {
        m.addAttribute("user", userRepository.findByLogin(principal.getName()));
        return "profile";
    }

    @GetMapping("/users")
    public String usersPage(Model m) {
        m.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/delete")
    public String deletePage(Model m, Principal principal) {
        var user = userRepository.findByLogin(principal.getName());
        userRepository.delete(user);
        return "redirect:/logout";
    }

    @GetMapping("/edit")
    public String editPage(Model m, Principal principal) {
        m.addAttribute("user", userRepository.findByLogin(principal.getName()));
        return "edit";
    }

    @PostMapping("/edit")
    public String editProfilePOST(@Valid User form, BindingResult binding, Principal principal) {
        if (!form.getLogin().equals(principal.getName()) && userRepository.findByLogin(form.getLogin()) != null) {
            binding.rejectValue("login", "", "Login jest już zajęty");
        }
        if (binding.hasErrors()) {
            return "edit";
        }
        User user = userRepository.findByLogin(principal.getName());
        var logout = !user.getLogin().equals(form.getLogin());
        user.setLogin(form.getLogin());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        userRepository.save(user);
        return logout ? "redirect:/logout" : "profile";
    }
}