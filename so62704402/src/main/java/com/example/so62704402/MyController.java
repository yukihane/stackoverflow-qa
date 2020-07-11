package com.example.so62704402;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MyController {

    private final ProfileService profileService;

    @RequestMapping(value = "/profile")
    public ModelAndView profile(final ModelAndView modelAndView, @ModelAttribute("user") final SiteUser user) {

        System.out.println("emaol: " + user.getEmail());
        final SiteUser userVal = getUser();
        Profile profile = profileService.getUserProfile(userVal);

        if (profile == null) {
            profile = new Profile();
            profile.setUser(userVal);
            profileService.save(profile);
        }

        final Profile webProfile = new Profile();
        webProfile.safeCopyFrom(profile);

        modelAndView.getModel().put("profile", webProfile);

        modelAndView.setViewName("profile");

        user.setEmail("my.email@example.com");

        return modelAndView;
    }

    private SiteUser getUser() {
        // TODO Auto-generated method stub
        return null;
    }
}
