package io.infinium.insta.controller;

import io.infinium.insta.codes.ErrorCodes;
import io.infinium.insta.codes.SuccessCodes;
import io.infinium.insta.convertor.UserDetailConvertor;
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

@Controller
public class LoginController {


    UserRepository userRepository;

    @Autowired
    UserCredentialRepository userCredentialRepository;

    @Autowired
    FollowRepository followRepository;

    @Autowired
    UserDetailConvertor userconvertor;

    @Autowired
    PasswordEncrypter passwordUtil;


    @RequestMapping(value = "/login")
    @ResponseBody
    public int loginUser(@RequestBody UserCredentials user){
        if(userCredentialRepository.findByEmail(user.getEmail()) !=  null){
            UserCredentials accountByEmail = userCredentialRepository.findByEmail(user.getEmail());
            if( passwordUtil.validatePass(user.getPassword(),accountByEmail.getPassword())){
                return SuccessCodes.LOGIN_SUCCESS;
            }else{
                return ErrorCodes.LOGIN_FALIURE_PASSWORD;
            }
        }else if(userCredentialRepository.findByUsername(user.getUsername()) !=  null){
            UserCredentials accountByUserName = userCredentialRepository.findByUsername(user.getUsername());
            if(passwordUtil.validatePass(user.getPassword(),accountByUserName.getPassword())){
                return SuccessCodes.LOGIN_SUCCESS;
            }else {
                return ErrorCodes.LOGIN_FALIURE_PASSWORD;
            }
        } else{
            return ErrorCodes.LOGIN_FALIURE;
        }
    }

}
