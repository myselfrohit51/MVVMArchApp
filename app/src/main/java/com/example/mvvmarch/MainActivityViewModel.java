package com.example.mvvmarch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//If we put anything inside viewmodel then the orientation changes will not affect affect our app.
//If we are not using viewmodel and orientation is changed then data will be lost.
public class MainActivityViewModel extends ViewModel {
    int counter=0;

    //Live Data
    private MutableLiveData<Integer> countLiveData=new MutableLiveData<>();

    //When the app first launched
    public MutableLiveData<Integer> getInitialCounter(){
        countLiveData.setValue(counter);
        return countLiveData;
    }

    //When users clicks the button
    public void getCounter(){
        counter++;
        countLiveData.setValue(counter);
    }
}
