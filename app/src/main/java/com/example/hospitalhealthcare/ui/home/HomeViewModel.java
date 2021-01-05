package com.example.hospitalhealthcare.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nirogya healthcare is a app which allows user to book there appointment with doctor,and users have access to use this app according to user's data accees,we have developed the user permission by the help of calculating the factor of the data access,i'm sure to tell you that it is very well encrypted and secure,in this app the doctor can also able to see the patient record as well as hospital data. this app is developed in 2020 and developed by venkatesh kumar with the help of Aryabhatt and Ashish vardhan ,this app is considered as under of minor project .the components which are uses to make this app are android development ,google cloud(firebase) etc.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}