package com.antin.action;

import com.antin.entity.AcctUser;
import com.antin.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    private static final Logger LOGGER = Logger.getLogger(UserAction.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/showInfo/{userId}")
    @ResponseBody
    public AcctUser showUserInfo(ModelMap modelMap, @PathVariable String userId) {
        LOGGER.info("查询用户：" + userId);
        AcctUser userInfo = userService.load(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return userInfo;
    }

    @RequestMapping("/showInfos")
    public
    @ResponseBody
    List<AcctUser> showUserInfos() {
        LOGGER.info("查询用户全部用户");
        List<AcctUser> userInfos = userService.findAll();
        return userInfos;
    }
}