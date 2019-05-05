package io.infinium.insta.util;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component("passwordUtil")
public class PasswordEncrypter {

    public String encryptPassword(String password) throws NoSuchAlgorithmException {
        String encryptedPass = Hashing.sha256().hashString(password,StandardCharsets.UTF_8).toString();
        return encryptedPass;
    }


    public boolean validatePass(String password,String encPass){
        String encryptedPass = Hashing.sha256().hashString(password,StandardCharsets.UTF_8).toString();
        if(encryptedPass.equals(encPass)){
            return true;
        }else {
            return false;
        }
    }

}
