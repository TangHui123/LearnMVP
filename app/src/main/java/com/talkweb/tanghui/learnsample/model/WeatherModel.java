package com.talkweb.tanghui.learnsample.model;

public interface WeatherModel {
    void getWeather(String city, OnWeatherLisenter lisenter);
}
