package com.hyxs.base;

import com.hyxs.constants.Constants;

import lombok.Data;

/**
 * @description: 微服务接口实现该接口可以使用传递参数可以直接封装统一返回结果集
 */
@Data
public class BaseApiService<T> {

    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * 返回错误，可以传msg
     *
     * @param msg
     * @return
     */
    public BaseResponse<T> setResultError(String msg) {
        return setResult(Constants.HTTP_RES_CODE_500, msg, null);
    }

    /***
     * 返回成功，可以传data值
     * @param data
     * @return
     */
    public BaseResponse<T> setResultSuccess(T data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }

    /**
     * 返回成功，沒有data值
     *
     * @return
     * @param s
     * @param ticket
     */
    public BaseResponse<T> setResultSuccess(String s, String ticket) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
    }


    /**
     * 通用封装 通用封装
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */

    public BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }


    public BaseResponse<T> setResultDb(int dbCount, String successMsg, String errorMsg){
        return dbCount>0?setResultSuccess((T) successMsg):setResultError(errorMsg);
    }

}
