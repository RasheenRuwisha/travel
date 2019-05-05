package io.infinium.insta.domain;

import java.util.Date;

public class UserContext {

    String email;
    String username;
    Date dob;
    int phone;
    Date signupDate;
    String accountStatus;
    String password;

    public UserContext() {
    }

    public UserContext(String email, String username, Date dob, int phone, Date signupDate, String accountStatus, String password) {
        this.email = email;
        this.username = username;
        this.dob = dob;
        this.phone = phone;
        this.signupDate = signupDate;
        this.accountStatus = accountStatus;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
