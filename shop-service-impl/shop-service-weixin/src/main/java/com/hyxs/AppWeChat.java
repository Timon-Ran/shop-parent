package com.hyxs;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:com.hyxs.AppWeChat
 * Package:com.hyxs.wechat.com.hyxs
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/8 20:59
 * @author:407897323@qq.com
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableFeignClients
public class AppWeChat {

    public static void main(String[] args) {
        SpringApplication.run(AppWeChat.class);
    }
}
