package com.example.coursedescriptions;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO to hold a message to be displayed as a Toast when an Activity is loaded as an intent
 */
public class ToastMessageExtra implements Serializable {

    private final String toastMessage;

    public ToastMessageExtra(String toastMessage){
        this.toastMessage = Objects.requireNonNull(toastMessage, "toastMessage may not be null");
    }

    public String getToastMessage(){
        return this.toastMessage;
    }
}
