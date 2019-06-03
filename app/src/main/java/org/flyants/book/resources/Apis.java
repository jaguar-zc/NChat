package org.flyants.book.resources;

import org.flyants.book.dto.LoginReq;
import org.flyants.book.dto.LoginResp;
import org.flyants.book.utils.Page;
import org.flyants.book.view.dynamic.CommentsPublishReq;
import org.flyants.book.view.dynamic.CommentsSimpleResp;
import org.flyants.book.view.dynamic.DynamicResp;
import org.flyants.book.view.experience.ConversationDto;
import org.flyants.book.view.experience.FoundDto;
import org.flyants.book.view.my.UserInfo;
import org.flyants.book.view.my.WorksModel;
import org.flyants.book.view.setting.VersionResp;
import org.flyants.book.view.setting.accountsecurity.SetPasswordReq;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Apis {

    @POST("/api/v1/app/login")
    Call<LoginResp> loginByPassword(@Body LoginReq loginReq);

    @POST("/api/v1/app/logout")
    Call<ResponseBody> logout();

    @GET("/api/v1/app/people/info")
    Call<UserInfo> userInfo();

    @GET("/api/v1/app/people/assistPeople")
    Call<ResponseBody> assistPeople(@Query("assistPeopleId") String assistPeopleId);


    @PUT("/api/v1/app/people/editPeopleIntroduction")
    Call<ResponseBody> editPeopleIntroduction(@Query("introduction") String introduction);

    @PUT("/api/v1/app/people/setPassword")
    Call<LoginResp> setPassword(@Body SetPasswordReq passwordReq);

    @PUT("/api/v1/app/people/updatePeopleInfo")
    Call<ResponseBody> updatePeopleInfo(@Body UserInfo userInfo);


    @GET("/api/v1/app/comments/list")
    Call<Page<CommentsSimpleResp>> getCommentsList(@Query("page") int page, @Query("commentsType") String commentsType, @Query("resourceId") String resourceId);


    @PUT("/api/v1/app/comments/publish")
    Call<ResponseBody> commentPublish(@Body CommentsPublishReq publishReq);


    @GET("/flyants-resource/my-page-works.json")
    Call<List<WorksModel>> getWorksModelList();

    @GET("/flyants-resource/version.json")
    Call<VersionResp> getVersion();


    @GET("/flyants-resource/found_list.json")
    Call<Page<FoundDto>> getFoundPageList(@Query("page")  int page);


    @GET("/flyants-resource/works_page_list.json")
    Call<Page<WorksModel>> getWorksPageList(@Query("page")  int page);


    @GET("/flyants-resource/conversation.json")
    Call<Page<ConversationDto>> getConversationList();
}
