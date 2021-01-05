package com.example.hospitalhealthcare.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Here user can log in and Sign up in the hospital healthcare a application");
    }

    public LiveData<String> getText() {
        return mText;
    }
}