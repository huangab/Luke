package com.hyp.luke.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证工具类
 * Created by  HuangYP on 2017/5/18 0018.
 *
 */

public class ValidateUtil {
    private static Pattern pattern = null;
    private static Matcher macher = null;

    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (null == str || str.trim().equals("")) {
            return true;
        }
        return false;
    }
    // 邮箱规则：用户名@服务器名.后缀 ---已验证
    // 匹配Email地址的正则表达式：^([a-z0-9A-Z]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}
    public static boolean isEmail(String inputString) {
        pattern = Pattern
                .compile("^([a-z0-9A-Z]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}");
        macher = pattern.matcher(inputString);
        return macher.find();
    }
    // 验证密码“.*[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]”
    // 正确格式为：以字母与数字穿插，长度在6-18 --已验证
    public static boolean isPassword(String inputString) {
        pattern = Pattern.compile(".*[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]");
        macher = pattern.matcher(inputString);
        return macher.find();
    }

    // 验证移动电话号码 ^[1][3-8]+\\d{9} ---已验证  验证全号段的手机号
    public static boolean isMobilePhone(String inputString) {
        //pattern = Pattern.compile("^[1][3-8]+\\d{9}");// ^(1(([35][0-9])|(47)|[8][01236789]))\\d{8}$
        pattern = Pattern.compile("^[1][3-8]+\\d{9}$");
        macher = pattern.matcher(inputString);
        return macher.find();
    }
}
