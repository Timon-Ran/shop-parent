package com.hyxs.member.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:MemberService
 * Package:com.hyxs.member
 * @author：冉茂旭 Description:
 * @date:2020/8/8 23:07
 * @author:407897323@qq.com
 */
public interface MemberService {

    @GetMapping("/menberToWeiXin")
    String menberToWeiXin(Integer userId);
}
