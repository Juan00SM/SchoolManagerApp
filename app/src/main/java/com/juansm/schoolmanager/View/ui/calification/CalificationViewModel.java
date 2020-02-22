package com.juansm.schoolmanager.View.ui.calification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalificationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CalificationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}