package org.flyants.book.store;

import android.content.Context;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.utils.RespList;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.common.store.IStore;
import org.flyants.common.store.OnCallback;

import java.util.List;

public class ConversationStore implements IStore<String,List<ConversationResp> > {

    private static ConversationStore me = new ConversationStore();
    private List<ConversationResp> conversationRespList;

    public static ConversationStore getInstence(){
        return me;
    }

    public void clean(){
        conversationRespList = null;
    }

    @Override
    public void loadObject(Context context, OnCallback<List<ConversationResp>> callback) {
        loadObject(context,null,callback);
    }

    @Override
    public void loadObject(Context context,String params, OnCallback<List<ConversationResp> > callback) {
        if(conversationRespList == null){
            ConversationApis conversationApis = RequestUtils.build(ConversationApis.class);;
            conversationApis.getConversationList().enqueue(new RespCall<RespList<ConversationResp>>() {
                @Override
                public void onResp(RespList<ConversationResp> resp) {
                    conversationRespList = resp;
                    callback.call(resp);
                }
            });
        }else{
            callback.call(conversationRespList);
        }
    }
}
