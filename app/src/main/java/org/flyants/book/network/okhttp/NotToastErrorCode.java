package org.flyants.book.network.okhttp;

import java.util.Arrays;
import java.util.List;

/**
 * 不用提示返回的信息的业务状态码
 */
public class NotToastErrorCode {
    static List<Integer> notToastErrorCode = Arrays.asList(500);


    public static boolean contains(int code){
        return notToastErrorCode.contains(code);
    }
}
