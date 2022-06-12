package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {
    //current.json?key=9924e192a78c4e598bc160905222905&q=İstanbul&aqi=no
    @GET("v1/current.json?key=9924e192a78c4e598bc160905222905&q=Ankara&aqi=no")
    fun  getCurrentWeatherStatus() : Call<CityWeatherAttributes>

}