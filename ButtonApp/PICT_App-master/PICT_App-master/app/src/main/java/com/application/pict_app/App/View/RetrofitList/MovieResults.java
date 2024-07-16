package com.application.pict_app.App.View.RetrofitList;

import com.google.gson.annotations.SerializedName;

public class MovieResults {

    public String getSuperName() {
        return superName;
    }

    @SerializedName("realname")
    private String superName;

    public MovieResults(String name){
        this.superName = name;
    }
}
