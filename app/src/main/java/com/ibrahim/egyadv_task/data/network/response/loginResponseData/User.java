package com.ibrahim.egyadv_task.data.network.response.loginResponseData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author: ib
 * Created by: ModelGenerator on 8/24/2019
 */
public class User {
    public City city;
    @SerializedName("city_id")
    public String cityId;
    @SerializedName("confirm_code")
    public Object confirmCode;
    @SerializedName("created_at")
    public String createdAt;
    @SerializedName("email_verified_at")
    public Object emailVerifiedAt;
    @SerializedName("extra_mobile")
    public Object extraMobile;
    @Expose
    public String following;
    @SerializedName("is_accepted")
    public String isAccepted;
    @SerializedName("is_active")
    public String isActive;
    @SerializedName("is_confirmed")
    public String isConfirmed;
    @SerializedName("is_verified")
    public String isVerified;
    @Expose
    public String lang;
    @SerializedName("my_followers")
    public String myFollowers;
    @SerializedName("price_id")
    public Object priceId;
    @Expose
    public Object proff;
    @Expose
    public Object recover;
    @Expose
    public Object role;
    @SerializedName("role_id")
    public String roleId;
    @SerializedName("sub_proff")
    public Object subProff;
    @SerializedName("updated_at")
    public String updatedAt;
    @SerializedName("upload_id")
    public Object uploadId;
    @SerializedName("user_bio")
    public Object userBio;
    @SerializedName("user_credit")
    public String userCredit;
    @SerializedName("user_email")
    public String userEmail;
    @SerializedName("user_firstname")
    public String userFirstname;
    @SerializedName("user_header")
    public Object userHeader;
    @SerializedName("user_id")
    public Long userId;
    @SerializedName("user_img")
    public String userImg;
    @SerializedName("user_lastname")
    public String userLastname;
    @SerializedName("user_lat")
    public String userLat;
    @SerializedName("user_lng")
    public String userLng;
    @SerializedName("user_mobile")
    public String userMobile;
    @SerializedName("user_rate")
    public String userRate;
}