package com.yougusen.coolweather.util;

import android.text.TextUtils;

import com.yougusen.coolweather.db.City;
import com.yougusen.coolweather.db.County;
import com.yougusen.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luohuijun on 04/03/2017.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray res = new JSONArray(response);
                for (int i = 0; i < res.length(); i++) {
                    JSONObject obj = res.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(obj.getString("name"));
                    province.setProvinceCode(obj.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray res = new JSONArray(response);
                for (int i = 0; i < res.length(); i++) {
                    JSONObject obj = res.getJSONObject(i);
                    City city = new City();
                    city.setCityName(obj.getString("name"));
                    city.setCityCode(obj.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray res = new JSONArray(response);
                for (int i = 0; i < res.length(); i++) {
                    JSONObject obj = res.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(obj.getString("name"));
                    county.setWeatherId(obj.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
