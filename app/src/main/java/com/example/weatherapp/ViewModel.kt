package com.example.weatherapp

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel  @Inject constructor(private val repository: RetrofitRepository): ViewModel() {
    var liveData: MutableLiveData<CityWeatherAttributes>

    init {
        liveData = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<CityWeatherAttributes>{
        return liveData
    }
    fun loadData(){
        repository.getCurrentWeatherStatus(liveData)
    }
}