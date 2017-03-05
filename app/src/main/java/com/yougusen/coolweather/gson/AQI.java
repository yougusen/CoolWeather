package com.yougusen.coolweather.gson;

/**
 * Created by luohuijun on 05/03/2017.
 */

public class AQI {

    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }

}
