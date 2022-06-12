package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance) {

    fun getCurrentWeatherStatus(liveData: MutableLiveData<CityWeatherAttributes>)
    {
        val call : Call<CityWeatherAttributes> = retrofitServiceInstance.getCurrentWeatherStatus()

        call.enqueue(object: Callback<CityWeatherAttributes>{

            override fun onResponse(
                call: Call<CityWeatherAttributes>,
                response: Response<CityWeatherAttributes>
            ) {
                if(response.isSuccessful)
                    liveData.postValue(response.body())
                else
                    liveData.postValue(null)
            }

            override fun onFailure(call: Call<CityWeatherAttributes>, t: Throwable) {
                liveData.postValue(null)
            }

        })


    }

}