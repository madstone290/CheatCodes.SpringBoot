package mad290.spring.tutorial.controllers;

import mad290.spring.tutorial.entities.AspNetUser;
import mad290.spring.tutorial.services.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
/*
    Controllers are created for each request by default.
 */
@Scope("request")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public List<AspNetUser> getUsers() {
        return userService.findAll();
    }

    @GetMapping("add")
    public void addUser() {
        var user = new AspNetUser("Test", "burce@ifjie.com");
        userService.save(user);
    }

    @GetMapping("admin")
    public AspNetUser getAdmin() {
        var user = userService.getAdminUser();
        return user.orElse(null);
    }

}
