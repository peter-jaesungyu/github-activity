package com.devturtle.helper;

import com.devturtle.model.Activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonMapper {
    private final Gson gson;

    public JsonMapper() {
        this.gson = new Gson();
    }

    public String toJson(Activity activity) {
        return gson.toJson(activity);
    }

    public List<Activity> fromJson(String json) {
        Type listType = new TypeToken<List<Activity>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
