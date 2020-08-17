package com.hyxs.job.handler;

import com.hyxs.job.entitydo.UserDo;
import com.hyxs.job.mapper.UserMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName:WeChatActivitieJob
 * Package:com.hyxs.job.handler
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/17 12:27
 * @author:407897323@qq.com
 */

@Component
@Slf4j
public class WeChatActivitieJob {

    @Autowired
    private UserMapper userMapper;

    @Value("${mayikt.member.job.WeChatActivitiePageSize}")
    private Integer pageSize;

    @XxlJob("weChatActivitieJobHandler")
    public ReturnT<String> weChatActivitieJobHandler(String param){
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        int index = shardingVO.getIndex();
        log.info(">>>定时任务开始出发<<<param:{},index:{},pageSize:{}", param, index, pageSize);
        List<UserDo> userDos = userMapper.selectByOpenIdNotIsNull(index, pageSize);
        System.out.println(userDos);
        return ReturnT.SUCCESS;
    }
}
