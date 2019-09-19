package com.sm.crm.controller;

import com.sm.crm.utils.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.UUID;

@RestController
@CrossOrigin(methods = {RequestMethod.GET})
@RequestMapping("/code")
public class EmailController {


    //工具的抽取

    @Autowired
    private SimpleMailMessage simpleMailMessage;


    @Autowired
    private MailSender mailSender;




    @GetMapping("codeSend")
    public String sendMailCode(String email) {

//        正则校验

        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("短信验证码");
        //发6位随机数


        // 保存随机数
        String substring = UUID.randomUUID().toString().substring(0, 6);

        simpleMailMessage.setText("你的验证码是"+substring);
        Jedis jedis = JedisUtil.getJedis();
        jedis.set(email,substring);
        mailSender.send(simpleMailMessage);

        //存哪
//        单例
        return "success";
    }



    public static void main(String[] args) {
        // int number = (int) (Math.floor(Math.random() * (999999 - 100000 + 1) + 100000));


        //字母加数字 咋办？

        System.out.println(UUID.randomUUID().toString().substring(0, 6));


//        6 一个数字 接一个字母  一个数字再接一个字母

//
//            2个数字+一个字符 一个数字加3个字母

        //都要有大小写
//
//        for (int i = 0; i <100 ; i++) {
//            System.out.println(Math.random() * 1000000);
//        }


        /**
         *
         *  发送邮件验证码的工具抽取
         *
         *  第二个 不使用redis 进行存储 多使用几个邮箱获取验证码  然后Controller使用非单例
         *
         *  第三个 使用redis进行存储
         *      如何设置过期时间     秒
         *
         *
         *
         *
         *   很多平台都可以
         *
         *   sharesdk  分享  友盟   七牛 文件服务器  直播流平台     华为云  阿里云  极光推送  个推
         *
         *
         *
         * 我们发短信 使用的是阿里
         *
         *
         *
         *
         */

    }
}
