package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/GroupUpdater;", "", "on", "", "<init>", "(I)V", "getOn", "()I", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroupUpdater {

    @SerializedName("5850")
    private final int on;

    public GroupUpdater(int i) {
        this.on = i;
    }

    public final int getOn() {
        return this.on;
    }
}
