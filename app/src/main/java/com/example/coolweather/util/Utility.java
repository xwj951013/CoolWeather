package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    public static boolean handleProvinceResponse(String response) {
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for(int i = 0; i < allProvinces.length();i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    public static boolean handleCityResponse(String response, int provinceID) {
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for(int i = 0; i < allCities.length();i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceID(provinceID);
                    city.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    public static boolean handleCountryResponse(String response, int cityID) {
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCountries = new JSONArray(response);
                for(int i = 0; i < allCountries.length(); i++) {
                    JSONObject countryObject = allCountries.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(countryObject.getString("name"));
                    country.setWeatherID(countryObject.getString("weather_id"));
                    country.setCityID(cityID);
                    country.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

}
