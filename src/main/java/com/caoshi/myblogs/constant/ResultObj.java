package com.caoshi.myblogs.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 *  处理结果信息常量类
 * @author CaoShi
 * @time 2019/12/3 16:46
 */
public class ResultObj {

    private String resultCode;      // 结果码

    private String resultMsg;       // 结果信息

    public static final ResultObj LOGIN_SUCCESS = new ResultObj("200", "登录成功");

    public static final ResultObj LOGIN_ERROR = new ResultObj("500", "登录失败");




}
