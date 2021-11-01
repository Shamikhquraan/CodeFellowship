package com.example.codeFellowship.Controllers;

import com.example.codeFellowship.Models.AppUser;
import com.example.codeFellowship.Models.Post;
import com.example.codeFellowship.Repositories.ApplicationUserRepo;
import com.example.codeFellowship.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class AppUserController {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepo appUserRepository;

    @Autowired
    PostRepository postRepository;
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpUser(@RequestParam String username, @RequestParam String password,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String dateOfBirth,@RequestParam String bio){
        AppUser appUser = new AppUser(username, encoder.encode(password),firstName,lastName,dateOfBirth,bio);
        appUserRepository.save(appUser);
        return "login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/")
    public String home(Principal principal,Model model){
        if (principal!=null) {
            AppUser user = appUserRepository.findByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        model.addAttribute("posts",postRepository.findAll());
        return "index";
    }
    @GetMapping("/user/{user}")
    public String userPage(@PathVariable AppUser user,Model model){
        model.addAttribute("user",user);
        return "user";
    }
    @PostMapping("/user")
    public RedirectView addPost(String post,String userName) {
        AppUser user = appUserRepository.findByUsername(userName);
        Post post1=new Post(post,user);
        postRepository.save(post1);
        return new RedirectView("/user/"+user.getId());
    }
}