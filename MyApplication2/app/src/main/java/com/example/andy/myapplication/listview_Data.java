package com.example.andy.myapplication;

import java.io.Serializable;

public class listview_Data implements Serializable {
    private String item;
    private String calender ;


    public String getitem() {
        return item;
    }

    public void setitem(String item) {
        this.item = item;
    }
    public String getcalender() {
        return calender;
    }

    public void setcalender(String calender) {
        this.calender = calender;
    }
}
