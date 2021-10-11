package mrs;

import lombok.RequiredArgsConstructor;
import mrs.domain.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    private final UserService userService;
    
    @GetMapping("/")
    public String index() {
        userService.save();
        return "ok";
    }
}
