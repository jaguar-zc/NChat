package org.flyants.book.resources;

import org.flyants.book.utils.Page;
import org.flyants.book.utils.RespList;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.conversation.CreateGroupConversationReq;
import org.flyants.book.view.conversation.CreateSingleConversationReq;
import org.flyants.book.view.conversation.EditConversationReq;
import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;
import org.flyants.book.view.conversation.window.MessageResp;
import org.flyants.book.view.conversation.window.PublishMessageReq;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ConversationApis {

    @POST("/api/v1/app/conversation/list")
    Call<RespList<ConversationResp>> getConversationList();

    @POST("/api/v1/app/conversation/getConversation")
    Call<Map<String,Object>> getConversation(@Query("conversationId") String conversationId);

    @POST("/api/v1/app/conversation/createGroupConversation")
    Call<ResponseBody> createGroupConversation(@Body CreateGroupConversationReq conversationReq);

    @POST("/api/v1/app/conversation/createSingleConversation")
    Call<ResponseBody> createSingleConversation(@Body CreateSingleConversationReq conversationReq);

    @POST("/api/v1/app/conversation/editConversation/{conversationId}")
    Call<ResponseBody> createSingleConversation(@Path("conversationId") String conversationId, @Body EditConversationReq editConversationReq);

    @GET("/api/v1/app/message/getMessageUserSimpleInfo")
    Call<MessageUserSimpleInfo> getMessageUserSimpleInfo(@Query("messageUserId") String messageUserId);

    @POST("/api/v1/app/message/publish")
    Call<ResponseBody> publishMessage(@Body PublishMessageReq publishMessageReq);

    @GET("/api/v1/app/message/{conversationId}/list")
    Call<Page<MessageResp>> getMessageList(@Path("conversationId") String conversationId,@Query("page") int page, @Query("size") int size );

}
