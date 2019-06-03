package org.flyants.book.resources;

import org.flyants.book.utils.RespList;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.conversation.CreateGroupConversationReq;
import org.flyants.book.view.conversation.CreateSingleConversationReq;
import org.flyants.book.view.conversation.EditConversationReq;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ConversationApis {

    @GET("/api/v1/app/conversation/list")
    Call<RespList<ConversationResp>> getConversationList();

    @POST("/api/v1/app/conversation/createGroupConversation")
    Call<ResponseBody> createGroupConversation(@Body CreateGroupConversationReq conversationReq);

    @POST("/api/v1/app/conversation/createSingleConversation")
    Call<ResponseBody> createSingleConversation(@Body CreateSingleConversationReq conversationReq);

    @POST("/api/v1/app/conversation/editConversation/{conversationId}")
    Call<ResponseBody> createSingleConversation(@Path("conversationId") String conversationId, @Body EditConversationReq editConversationReq);


}
