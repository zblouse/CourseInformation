package com.example.coursedescriptions;

import java.io.Serializable;
import java.util.Objects;

public class ToastMessageExtra implements Serializable {

    private final String toastMessage;

    public ToastMessageExtra(String toastMessage){
        this.toastMessage = Objects.requireNonNull(toastMessage, "toastMessage may not be null");
    }

    public String getToastMessage(){
        return this.toastMessage;
    }
}
