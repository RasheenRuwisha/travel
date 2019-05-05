package io.infinium.insta.util;

import io.infinium.insta.datatypes.User;
import io.infinium.insta.domain.UserFollow;
import io.infinium.insta.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("followerUtil")
public class FollowerUtil {

    @Autowired
    FollowRepository followRepository;

    public User addFollower(UserFollow user1, String followerUUID){
       User followers = user1.getFollowers() == null ? new User() : user1.getFollowers();
       List<String> followerList = followers.getId() == null ? new ArrayList<>() : followers.getId();
       followerList.add(followerUUID);
       followers.setId(followerList);
       return followers;
    }

    public User addFollowing(UserFollow user2, String followingUUID){
        User following = user2.getFollowing() == null ? new User() : user2.getFollowing();
        List<String> followingList = following.getId() == null ? new ArrayList<>() : following.getId();
        followingList.add(followingUUID);
        following.setId(followingList);
        user2.setFollowing(following);
        return  following;
    }

}
