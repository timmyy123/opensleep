package com.philips.lighting.model;

import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueParsingError extends PHHueError {
    private JSONObject jsonContext;

    public PHHueParsingError(int i, String str, String str2, JSONObject jSONObject) {
        this(i, str, str2);
        this.jsonContext = jSONObject;
    }

    public JSONObject getJSONContext() {
        return this.jsonContext;
    }

    public String getResourceId() {
        return getAddress();
    }

    public void setJSONContext(JSONObject jSONObject) {
        this.jsonContext = jSONObject;
    }

    public void setResourceId(String str) {
        setAddress(str);
    }

    public PHHueParsingError(int i, String str, String str2) {
        super(i, str2, str);
    }
}
