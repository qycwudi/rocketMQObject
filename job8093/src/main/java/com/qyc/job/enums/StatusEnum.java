package com.qyc.job.enums;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 11:31 下午
 */
public enum StatusEnum {
    /**
     * 运行状态
    */
    RUN("1","运行中"),
    STOP("0","停止");
    private final String code;
    private final String info;

    StatusEnum(String code,String info){
        this.code = code;
        this.info = info;
    }
    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }

    public static String getEnumContent(String code){
        for (StatusEnum statusEnum :
                StatusEnum.values()) {
            if(statusEnum.getCode().equals(code)){
                return statusEnum.getInfo();
            }
        }
        return "未找到";
    }
}
