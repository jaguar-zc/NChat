package org.flyants.book.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ConversationTimeUtils {

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public static String toDateStr(Long time){
        if(threadLocal.get() == null){
            threadLocal.set(new SimpleDateFormat("MM-dd HH:mm"));
        }

        return threadLocal.get().format(new Date(time));

    }

}
