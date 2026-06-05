package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Types$RequestId {
    public static final Types$RequestId NONE = new Types$RequestId(-1);
    private final int mValue;

    private Types$RequestId(int i) {
        this.mValue = i;
    }

    public static Types$RequestId from(int i) {
        return new Types$RequestId(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Types$RequestId) && this.mValue == ((Types$RequestId) obj).mValue;
    }

    public int getRaw() {
        return this.mValue;
    }

    public int hashCode() {
        return this.mValue;
    }

    public String toString() {
        Locale locale = Locale.US;
        return Fragment$$ExternalSyntheticOutline1.m(this.mValue, "RequestId{", "}");
    }
}
