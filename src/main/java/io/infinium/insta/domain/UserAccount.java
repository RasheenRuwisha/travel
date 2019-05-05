package io.infinium.insta.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable {

    @Id
    @Column(name = "userid")
    String userid;
    @Column(name = "email")
    String email;
    @Column(name = "username")
    String username;
    @Column(name = "dob")
    Date dob;
    @Column(name = "phone")
    int phone;
    @Column(name = "signupDate")
    Date signupDate;
    @Column(name = "accountStatus")
    String accountStatus;



    public UserAccount() {
    }

    public UserAccount(String userid, String email, String username, Date dob, int phone, Date signupDate, String accountStatus) {
        this.userid = userid;
        this.email = email;
        this.username = username;
        this.dob = dob;
        this.phone = phone;
        this.signupDate = signupDate;
        this.accountStatus = accountStatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public void setSignupDate(Date createdDate) {
        this.signupDate = createdDate;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
