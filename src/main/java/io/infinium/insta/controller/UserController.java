package io.infinium.insta.controller;


import io.infinium.insta.codes.ErrorCodes;
import io.infinium.insta.codes.SuccessCodes;
import io.infinium.insta.domain.UserAccount;
import io.infinium.insta.domain.UserContext;
import io.infinium.insta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    @ResponseBody
    public List<UserAccount> registerAccount(){
        return userRepository.findAll();
    }

}
