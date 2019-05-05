package io.infinium.insta.controller;

import io.infinium.insta.codes.ErrorCodes;
import io.infinium.insta.codes.SuccessCodes;
import io.infinium.insta.convertor.UserDetailConvertor;
import io.infinium.insta.domain.UserContext;
import io.infinium.insta.domain.UserCredentials;
import io.infinium.insta.repository.FollowRepository;
import io.infinium.insta.repository.UserCredentialRepository;
import io.infinium.insta.repository.UserRepository;
import io.infinium.insta.util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class SingupController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCredentialRepository userCredentialRepository;

    @Autowired
    FollowRepository followRepository;

    @Autowired
    UserDetailConvertor userconvertor;

    @Autowired
    PasswordEncrypter passwordUtil;


    @RequestMapping(value = "/register")
    @ResponseBody
    public int registerAccount(@RequestBody UserContext user){
        String uuid = UUID.randomUUID().toString();
        if(userRepository.findByEmail(user.getEmail()).size() == 0){
            if(userRepository.findByUsername(user.getUsername()).size() == 0){
                userRepository.save(userconvertor.getUserAccountDetails(user,uuid));
                userCredentialRepository.save(userconvertor.getUserCredentials(user,uuid));
                followRepository.save(userconvertor.getUserFollows(user,uuid));
                return SuccessCodes.REGISTRATION_SUCCESS;
            }else {
                return ErrorCodes.REGISTRATION_ERROR_USERNAME_EXISTS;
            }
        }else{
            return ErrorCodes.REGISTRATION_ERROR_EMAIL_EXISTS;
        }
    }
}
