package io.infinium.insta.convertor;

import io.infinium.insta.datatypes.User;
import io.infinium.insta.domain.UserFollow;
import io.infinium.insta.domain.UserAccount;
import io.infinium.insta.domain.UserContext;
import io.infinium.insta.domain.UserCredentials;
import io.infinium.insta.util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


@Component("userconvertor")
public class UserDetailConvertor {

    @Autowired
    PasswordEncrypter passwordUtil;

    public UserAccount getUserAccountDetails(UserContext userContext,String uuid){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserid(uuid);
        userAccount.setEmail(userContext.getEmail());
        userAccount.setDob(userContext.getDob());
        userAccount.setAccountStatus(userContext.getAccountStatus());
        userAccount.setPhone(userContext.getPhone());
        userAccount.setSignupDate(userContext.getSignupDate());
        userAccount.setUsername(userContext.getUsername());
        return userAccount;
    }

    public UserCredentials getUserCredentials(UserContext userContext,String uuid){
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUserid(uuid);
        userCredentials.setEmail(userContext.getEmail());
        try {
            userCredentials.setPassword(passwordUtil.encryptPassword(userContext.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userCredentials.setUsername(userContext.getUsername());
        return userCredentials;
    }

    public UserFollow getUserFollows(UserContext userContext, String uuid){
        UserFollow userFollow = new UserFollow();
        userFollow.setUserid(uuid);
        userFollow.setEmail(userContext.getEmail());
        return userFollow;
    }

}
