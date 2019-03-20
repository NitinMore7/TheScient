package com.example.lenovo.thescient;

import android.text.Editable;
import android.text.format.Time;

import java.util.ArrayList;
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
            @Field("purposeOfBooking") String purpose,
            @Field("date")Date date,
            @Field("startTime")String startTime,
            @Field("endTime")String endTime,
            @Field("approvedStartTime")String approvedStartTime,
            @Field("approvedEndTime")String approvedEndTime,
            @Field("approved")String approved,
            @Field("mailSent")String mailSent
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
            @Field("abstract") String abstrac,
            @Field("budget") Integer budget,
            @Field("timeline") String timeline,
            @Field("teamMembersNames") ArrayList<String> teamMembersNames,
            @Field("teamMembersRoll")ArrayList<String> teamMembersRoll,
            @Field("materialNames")ArrayList<String> materialNames,
            @Field("materialSpecs")ArrayList<String> materialSpecs,
            @Field("materialQuantity")ArrayList<String> materialQuantity,
            @Field("materialPrice")ArrayList<String> materialPrice,
            @Field("purpose")ArrayList<String> purpose,
            @Field("vendors")ArrayList<String> vendors,
            @Field("serviceNames")ArrayList<String> serviceNames,
            @Field("serviceSpecs")ArrayList<String> serviceSpecs,
            @Field("servicePrice")ArrayList<String> servicePrice
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
