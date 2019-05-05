package io.infinium.insta.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import io.infinium.insta.datatypes.User;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user_follow")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserFollow {

    @Id
    @Column(name = "userid")
    String userid;
    @Column(name = "email")
    String email;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    User followers;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    User following;


    public UserFollow() {
    }

    public UserFollow(String userid, String email, User followers, User following) {
        this.userid = userid;
        this.email = email;
        this.followers = followers;
        this.following = following;
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

    public User getFollowers() {
        return followers;
    }

    public void setFollowers(User followers) {
        this.followers = followers;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }
}
