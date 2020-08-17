package com.hyxs.mapper;

import com.hyxs.entitydo.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Insert("INSERT INTO `meite_user` VALUES (null, #{mobile}, #{email}, #{passWord}, null, '0', '0', null," +
            " '1', now(), null, null)")
    int register(UserDo userDo);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password " +
            ",user_name as username ,user_name as username,sex as sex " +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE " +
            "," +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid " +
            " " +
            "from meite_user  where MOBILE=#{mobile}")
    UserDo login(String mobile, String passWord);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password " +
            ",user_name as username ,user_name as username,sex as sex " +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE " +
            ", " +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid" +
            " " +
            "from meite_user  where MOBILE=#{mobile}")
    UserDo existMobile(String mobile);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password " +
            ",user_name as username ,user_name as username,sex as sex  " +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE " +
            ", " +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid " +
            " " +
            "from meite_user  where USER_ID=#{userId}")
    UserDo findByUser(Integer userId);

    @Update("update meite_user set WX_OPENID=#{wxOpenId} where user_id=#{userId}")
    int updateUseOpenId(@Param("userId") Integer userId, @Param("wxOpenId") String wxOpenId);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password " +
            ",user_name as username ,user_name as username,sex as sex  " +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE " +
            ", " +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid " +
            " " +
            "from meite_user  where wx_OpenId=#{wxOpenId}")
    UserDo selectByOpenId(@Param("wxOpenId") String wxOpenId);


    @Update("update meite_user set WX_OPENID=null  where WX_OPENID=#{wxOpenId}")
    int cancelFollowOpenId(@Param("wxOpenId") String wxOpenId);
}