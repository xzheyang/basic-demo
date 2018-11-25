package com.hy.basic.java.grammar;

/**
 * Description:     简单Enum用法
 *
 * @author hy
 * Create in 2018/3/13 13:35
 */
public enum EasyEnum {

    STATUS_404(404,"网页未找到"),
    STATUS_500(505,"服务器错误");

    int code;
    String message;


    EasyEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


    public static void main(String[] args) {

        System.out.println(STATUS_500.getMessage());

    }

}
