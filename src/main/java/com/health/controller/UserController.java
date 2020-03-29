package com.health.controller;

import com.health.model.ContextModel;
import com.health.model.Message;
import com.health.model.User;
import com.health.service.UserService;
import com.health.util.CommonUtil;
import com.health.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object register(HttpServletRequest request,
                           @RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "phone") Long phone,
                           @RequestParam(value = "code") String code) {

        Message message = new Message();
        String info = null;
        boolean success = true;
        Object messg = null;

        User user = new User();
        user.setName(username);
        List<User> result = userService.queryUser(user);


        if (!CollectionUtils.isEmpty(result)) {
            info = "该用户名已存在!";
            success = false;
            messg = new HashMap<String, String>();
            ((HashMap) messg).put("name", "username");
        }

        user = new User();
        user.setPhone(phone);
        result = userService.queryUser(user);
        if (success && !CollectionUtils.isEmpty(result)) {
            info = "该手机已被注册!";
            success = false;
            messg = new HashMap<String, String>();
            ((HashMap) messg).put("name", "phone");
        }

        if (success && !HttpClientUtil.checkCode(request, phone, code)) {
            info = "验证码错误!";
            success = false;
            messg = new HashMap<String, String>();
            ((HashMap) messg).put("name", "code");
        }


        if (!success) {
            message.setMessg(messg);
            message.setSuccess(success);
            message.setErrorInfo(info);

            return message;
        }

        user.setPassword(password);
        user.setName(username);
        userService.addUser(user);

        return message;
    }

    @PostMapping("/sendMsg")
    public void sendMsg(HttpServletRequest request,
                        HttpServletResponse response, @RequestParam(value = "phone") Long phone) {

        HttpClientUtil client = HttpClientUtil.getInstance();
        String code = client.sendMsgUtf8(phone);
        String remoteAddr = request.getRemoteAddr();

        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("date", String.valueOf(new Date().getTime()));
        map.put("phone", String.valueOf(phone));
        ContextModel.getContext(request).put("code", map);
    }

    @RequestMapping("/login")
    public Object login(HttpServletRequest request,
                        HttpServletResponse response, @RequestParam(value =
            "username") String username,
                        @RequestParam(value = "password") String password) {

        Message result = new Message();

        User user = new User();
        user.setName(username);
        user.setPassword(password);
        List<User> list = userService.queryUser(user);

        if (CollectionUtils.isEmpty(list)) {
            result.setSuccess(false);
            return result;
        }
        CommonUtil.login(request,list.get(0));

        return result;
    }

    @RequestMapping("/logout")
    public Object logout(HttpServletRequest request,HttpServletResponse response)
    {
        CommonUtil.logout(request);

        ModelAndView mv = new ModelAndView("/html/index");

        return mv;
    }
}
