package com.example.lenovo.thescient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("/sendProjectIdea")
    Call<ResponseBody> name(
            @Field("name") String name,
            @Field("phNumber") String phNumber,
            @Field("email") String email,
            @Field("projectTitle") String projectTitle,
            @Field("projectIdea") String projectIdea
    );
}
