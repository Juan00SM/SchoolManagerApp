package com.juansm.schoolmanager.View.ui.homework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Integer> countHomework;

    public HomeViewModel() {
        countHomework = new MutableLiveData<>();
        countHomework.setValue(0);
    }

    public LiveData<Integer> getCountHomeworks() {
        return countHomework;
    }
}