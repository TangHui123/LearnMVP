package com.talkweb.tanghui.learnsample.model;

public class WeathModelVolley implements WeatherModel {
    @Override
    public void getWeather(String city, OnWeatherLisenter lisenter) {
        if(city.equals("shenzhen")) {
            lisenter.onSuccess("shenzhen");
        } else {
            lisenter.onError();
        }
    }
}
