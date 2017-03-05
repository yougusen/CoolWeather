package com.yougusen.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luohuijun on 05/03/2017.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
