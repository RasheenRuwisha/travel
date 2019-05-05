package io.infinium.insta.domain;


import javax.persistence.*;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @Column(name = "userid")
    private String userid;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;


    public UserCredentials() {
    }


    public UserCredentials(String userid, String email, String password, String username) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
