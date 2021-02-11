package com.example.so66104427;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {

        String username = principal.getName();
        System.out.println("User name " + username);

        User user = userRepo.getUserByUserName(username);
        System.out.println("User " + user);

        model.addAttribute("user", user);

        return "normal/user_dashboard";

    }

    
    
    @GetMapping("/add-blog")
    public String AddBlog(Model model) {
        model.addAttribute("title", "Add Blog");
        model.addAttribute("blog", new Blog());
        
        return "normal/add_blog";
        
    }
    
    
    @PostMapping("/process-blog")
    public String BlogProcess(@ModelAttribute Blog blog,Principal principal) {
        
        
        String name=principal.getName();
        User user = this.userRepo.getUserByUserName(name);
        
        user.getBlogs().add(blog);
        this.userRepo.save(user);
        
        
        System.out.println("data "+ blog);
        
        System.out.println("Added to the data base ");
        
            
        return "normal/add_blog";
        
        
    }
}
