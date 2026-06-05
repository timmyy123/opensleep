package com.spotify.protocol;

import com.spotify.protocol.mappers.JsonArray;
import com.spotify.protocol.mappers.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
public class WampMessage {
    private final JsonArray mJsonArray;

    public WampMessage(JsonArray jsonArray) {
        this.mJsonArray = jsonArray;
    }

    public int getAction() {
        return this.mJsonArray.getIntAt(0);
    }

    public int getIntAt(int i) {
        return this.mJsonArray.getIntAt(i);
    }

    public JsonObject getObjectAt(int i) {
        return this.mJsonArray.getObjectAt(i);
    }

    public String getStringAt(int i) {
        return this.mJsonArray.getStringAt(i);
    }
}
