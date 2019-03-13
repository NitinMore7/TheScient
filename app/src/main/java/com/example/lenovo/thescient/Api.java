package com.example.lenovo.thescient;

import android.text.Editable;
import android.text.format.Time;

import java.util.Date;

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

    @FormUrlEncoded
    @POST("/applyForHallBooking")
    Call<ResponseBody> hall(
            @Field("name") String name,
            @Field("roll") String roll,
            @Field("department") String department,
            @Field("contactNumber") String contactNumber,
            @Field("emailID") String emailID,
            @Field("attendeesNumber") Integer attendeesNumber,
            @Field("purpose") String purpose,
            @Field("date")Date date,
            @Field("startTime")Time startTime,
            @Field("endTime")Time endTime
            );

    @FormUrlEncoded
    @POST("/applyForFacilities")
    Call<ResponseBody> fac(
            @Field("name") String name,
            @Field("roll") String roll,
            @Field("department") String department,
            @Field("contactNumber") String contactNumber,
            @Field("emailID") String emailID,
            @Field("purpose") String purpose,
            @Field("duration") Integer duration,
            @Field("heavyMachinery") String heavyMachinery
    );
    @FormUrlEncoded
    @POST("/applyForProjects")
    Call<ResponseBody> rpro(
            @Field("name") String name,
            @Field("roll") String roll,
            @Field("department") String department,
            @Field("contactNumber") String contactNumber,
            @Field("emailID") String emailID,
            @Field("visibility") Enum visibility,
            @Field("abstract") Editable abstrac,
            @Field("budget") Integer budget,
            @Field("timeline") Editable timeline
    );
    @FormUrlEncoded
    @POST("/sendMessage")
    Call<ResponseBody> mesa(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("email") String email,
            @Field("msg") String msg
    );
}
