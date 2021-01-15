package com.codeworld.fc.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 字符串操作工具类
 *
 * @author Lenovo
 */
public class StringUtil {


    /**
     * 将字符串转成List<Long>型
     *
     * @param string
     * @return
     */
    public static List<Long> stingConvertLong(String string) {

        List<Long> longs = new ArrayList<>();

        String[] split = string.split(",");

        List<String> strings = Arrays.asList(split);

        for (String str : strings
        ) {
            longs.add(Long.valueOf(str));
        }
        return longs;
    }


    /**
     * List<Long>转换成String
     *
     * @param longList
     * @return
     */
    public static String listToString(List<Long> longList) {

        if (CollectionUtils.isEmpty(longList)) {

            return null;

        }

        StringBuilder result = new StringBuilder();

        boolean flag = false;

        for (Long longValue : longList) {

            if (flag) {

                result.append(",");

            } else {

                flag = true;

            }

            result.append(String.valueOf(longValue));
        }
        return result.toString();
    }

    /**
     * 截取第一个空格后的字符串
     * @param string
     * @return
     */
    public static List<String> getFirstBlankString(String string){
        // 首先将其用逗号分割开
        List<String> stringList = Arrays.asList(string.split(","));
        return stringList.stream().map(s->{
            int index = s.indexOf(" ");
            return s.substring(index + 1);
        }).collect(Collectors.toList());
    }

    /**
     * 判断手机号
     * @param phone
     * @return
     */
    public static Boolean checkPhone(String phone){
        String regex = "^(1[3-9]\\d{9}$)";
        if (StringUtils.length(phone) != 11){
            return false;
        }
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String string = "小米MIX2 绿色 20G,小米MIX2 绿色 10G,小米MIX2 红色 10G,小米MIX2 红色 20G";
        List<String> firstBlankString = StringUtil.getFirstBlankString(string);
        System.out.println(firstBlankString);
    }
}
