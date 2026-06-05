package com.urbandroid.smartlight.common.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/smartlight/common/model/BlinderState;", "", "position", "", "<init>", "(F)V", "getPosition", "()F", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class BlinderState {
    private final float position;

    public BlinderState(float f) {
        this.position = f;
    }

    public static /* synthetic */ BlinderState copy$default(BlinderState blinderState, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = blinderState.position;
        }
        return blinderState.copy(f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getPosition() {
        return this.position;
    }

    public final BlinderState copy(float position) {
        return new BlinderState(position);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BlinderState) && Float.compare(this.position, ((BlinderState) other).position) == 0;
    }

    public final float getPosition() {
        return this.position;
    }

    public int hashCode() {
        return Float.hashCode(this.position);
    }

    public String toString() {
        return "BlinderState(position=" + this.position + ')';
    }
}
