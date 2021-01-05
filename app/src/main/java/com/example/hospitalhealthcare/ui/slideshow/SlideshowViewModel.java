package com.example.hospitalhealthcare.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("you can call or Give a missed call to this number for any issue");
    }

    public LiveData<String> getText() {
        return mText;
    }
}