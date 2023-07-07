package rayglass.springblog.controllers;

import org.springframework.stereotype.Controller;
import rayglass.springblog.repositories.UserRepository;

@Controller
public class UserController {
    private final UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }





}