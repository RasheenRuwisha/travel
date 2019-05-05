package io.infinium.insta.controller;

import io.infinium.insta.codes.ErrorCodes;
import io.infinium.insta.codes.SuccessCodes;
import io.infinium.insta.domain.UserFollow;
import io.infinium.insta.domain.UserIdList;
import io.infinium.insta.repository.FollowRepository;
import io.infinium.insta.util.FollowerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FollowController {

    @Autowired
    FollowRepository followRepository;

    @Autowired
    FollowerUtil followerUtil;

    @PostMapping(value = "/follow")
    @ResponseBody
    public int followUser(@RequestBody UserIdList userIdList){
        UserFollow following = followRepository.findByUserid(userIdList.getUser1());
        UserFollow follower =  followRepository.findByUserid(userIdList.getUser2());

        try {
            following.setFollowers(followerUtil.addFollower(following,follower.getUserid()));
            followRepository.save(following);

            follower.setFollowing(followerUtil.addFollowing(follower,following.getUserid()));
            followRepository.save(follower);
            return SuccessCodes.FOLLOWING_SUCCESS;
        }catch (Exception e){
            return ErrorCodes.FOLLOWING_FALIURE;
        }
    }

}
