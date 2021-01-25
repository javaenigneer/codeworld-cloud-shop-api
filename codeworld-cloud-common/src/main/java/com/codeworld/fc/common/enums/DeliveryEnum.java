package com.codeworld.fc.common.enums;

public enum DeliveryEnum {

    YT_DELIVERY(1,"圆通快递"),
    ZT_DELIVERY(2,"中通快递"),
    YD_DELIVERY(3,"韵达快递"),
    ST_DELIVERY(4,"申通快递"),
    YZ_DELIVERY(5,"邮政快递")
    ;


    private Integer key;

    private String name;

    DeliveryEnum(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * 根据key获取物流名称
     * @param key
     * @return
     */
    public static String getDeliveryNameByKey(Integer key){
        for (DeliveryEnum deliveryEnum: DeliveryEnum.values()
             ) {
            if (deliveryEnum.key.equals(key)){
                return deliveryEnum.name;
            }
        }
        return null;
    }
}
