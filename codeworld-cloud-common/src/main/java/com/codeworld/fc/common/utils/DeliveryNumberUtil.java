package com.codeworld.fc.common.utils;

import com.codeworld.fc.common.enums.DeliveryEnum;
import lombok.Data;

import java.util.UUID;

/**
 * ClassName DeliverySnUtil
 * Description 物流单号生成工具类
 * Author Lenovo
 * Date 2021/1/25
 * Version 1.0
 **/
@Data
public class DeliveryNumberUtil {


    /**
     * 物流单号的生成
     *
     * @param key
     * @return
     */
    public static String getDeliveryNumber(Integer key) {
        switch (key) {
            case 1:
                return "YT" + System.currentTimeMillis();
            case 2:
                return "ZT" + System.currentTimeMillis();
            case 3:
                return "YD" + System.currentTimeMillis();
            case 4:
                return "ST" + System.currentTimeMillis();
            case 5:
                return "YZ" + System.currentTimeMillis();
        }
        return null;
    }
}
