package com.hyxs.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:AppMeberJob
 * Package:com.hyxs.job
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/17 12:16
 * @author:407897323@qq.com
 */
@SpringBootApplication
@MapperScan("com.hyxs.job.mapper")
public class AppMeberJob {
    public static void main(String[] args) {
        SpringApplication.run(AppMeberJob.class);
    }
}
