package mad290.spring.tutorial.controllers;

import mad290.spring.tutorial.entities.AspNetUser;
import mad290.spring.tutorial.repositories.CustomerRepository;
import mad290.spring.tutorial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("customers")
    public String customers() {
        return customerRepository.findAll().toString();
    }


}
