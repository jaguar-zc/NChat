package org.flyants.book.store;

import android.content.Context;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.utils.RespList;
import org.flyants.book.view.conversation.ConversationResp;

import java.util.List;

public class ConversationStore {

    public static ConversationStore me = new ConversationStore();
    List<ConversationResp> conversationRespList;

    private void clean(){
        conversationRespList = null;
    }


    public void getConversationList(Context context, OnConversationList conversationList){
        if(conversationRespList == null){
            ConversationApis conversationApis = RequestUtils.build(ConversationApis.class);;
            conversationApis.getConversationList().enqueue(new RespCall<RespList<ConversationResp>>() {
                @Override
                public void onResp(RespList<ConversationResp> resp) {
                    conversationRespList = resp;
                    conversationList.onConversationList(resp);
                }
            });
        }else{
            conversationList.onConversationList(conversationRespList);
        }
    }





    public interface OnConversationList{
        void onConversationList(List<ConversationResp> list);
    }


}
