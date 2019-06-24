package org.flyants.book.store;

import android.content.Context;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;
import org.flyants.common.store.IStore;
import org.flyants.common.store.OnCallback;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageUserSimpleStore implements IStore<String,MessageUserSimpleInfo> {

    private static MessageUserSimpleStore me = new MessageUserSimpleStore();


    private  Map<String, MessageUserSimpleInfo> messageUserSimpleInfoHashMap = new ConcurrentHashMap<String, MessageUserSimpleInfo>();

    public static MessageUserSimpleStore getInstence(){
        return me;
    }

    {
        StoreManager.getInstance().register(this);
    }

    @Override
    public void loadObject(Context context, OnCallback<MessageUserSimpleInfo> callback) {
        loadObject(context,null,callback);
    }

    @Override
    public void loadObject(Context context,String messageUserId, OnCallback<MessageUserSimpleInfo> callback) {
        if(StringUtils.isEmpty(messageUserId)){
            callback.call(null);
            return;
        }
        if(messageUserSimpleInfoHashMap.containsKey(messageUserId)){
            callback.call(messageUserSimpleInfoHashMap.get(messageUserId));
        }else{
            ConversationApis conversationApis = RequestUtils.build(ConversationApis.class);
            conversationApis.getMessageUserSimpleInfo(messageUserId).enqueue(new RespCall<MessageUserSimpleInfo>() {
                @Override
                public void onResp(MessageUserSimpleInfo resp) {
                    messageUserSimpleInfoHashMap.put(messageUserId,resp);
                    callback.call(resp);
                }
            });
        }
    }

    @Override
    public void clean() {
        messageUserSimpleInfoHashMap.clear();
    }
}
