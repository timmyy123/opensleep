package com.urbandroid.sleep.smartwatch.garmin;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class MessageToWatch {
    public String command;
    public Long param;

    public MessageToWatch(String str, Long l) {
        this.command = str;
        this.param = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.command, this.param);
    }

    public String toString() {
        Long l = this.param;
        String str = this.command;
        if (l == null) {
            return str;
        }
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, ";");
        sbM.append(this.param);
        return sbM.toString();
    }

    public MessageToWatch(String str) {
        this.command = str;
    }
}
