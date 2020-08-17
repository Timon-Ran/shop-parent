package com.hyxs.entitydo;

import lombok.Data;

import java.util.Date;

/**
 * @title: userLoginLog
 */
@Data
public class UserLoginLogDo {
    Long id;
    int userId;
    String loginIp;
    Date loginTime;
    String loginToken;
    String channel;
    String equipment;

    public UserLoginLogDo() {
    }

    public UserLoginLogDo(int userId, String loginIp, Date loginTime, String loginToken, String channel, String equipment) {
        this.userId = userId;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.loginToken = loginToken;
        this.channel = channel;
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "UserLoginLogDo{" +
                "userId=" + userId +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", loginToken='" + loginToken + '\'' +
                ", channel='" + channel + '\'' +
                ", equipment='" + equipment + '\'' +
                '}';
    }
}
