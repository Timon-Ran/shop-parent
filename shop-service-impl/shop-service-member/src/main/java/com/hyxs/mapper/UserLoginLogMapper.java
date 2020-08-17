package com.hyxs.mapper;

import com.hyxs.entitydo.UserLoginLogDo;
import com.hyxs.member.dto.req.UserLoginDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName:UserLoginLogMapper
 * Package:com.hyxs.mapper
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/12 3:23
 * @author:407897323@qq.com
 */
public interface UserLoginLogMapper {


    @Insert("insert into  user_login_log values(null,#{userId},#{loginIp},now(),#{loginToken},#{channel},#{equipment})")
    int loginLog(UserLoginLogDo userLoginLogDo);

    @Select("SELECT COUNT(*) FROM user_login_log WHERE CHANNEL=#{channel} and user_id=#{userId}")
    int channelExist(String channel, Integer userId);
}
