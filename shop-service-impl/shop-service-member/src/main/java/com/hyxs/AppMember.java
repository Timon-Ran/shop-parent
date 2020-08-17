package com.hyxs;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName:com.hyxs.AppMember
 * Package:com.hyxs.member.impl.com.hyxs
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/9 2:28
 * @author:407897323@qq.com
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableFeignClients
@MapperScan("com.hyxs.mapper")
public class AppMember {

    public static void main(String[] args) {
        SpringApplication.run(AppMember.class);
    }
}
