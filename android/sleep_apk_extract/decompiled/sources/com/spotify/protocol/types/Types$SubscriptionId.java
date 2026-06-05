package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Types$SubscriptionId {
    public static final Types$SubscriptionId NONE = new Types$SubscriptionId(-1);
    private final int mValue;

    private Types$SubscriptionId(int i) {
        this.mValue = i;
    }

    public static Types$SubscriptionId from(int i) {
        return new Types$SubscriptionId(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Types$SubscriptionId) && this.mValue == ((Types$SubscriptionId) obj).mValue;
    }

    public int getRaw() {
        return this.mValue;
    }

    public int hashCode() {
        return this.mValue;
    }

    public String toString() {
        Locale locale = Locale.US;
        return Fragment$$ExternalSyntheticOutline1.m(this.mValue, "SubscriptionId{", "}");
    }
}
