package com.google.home.matter.serialization.codec.proto;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.matter.serialization.SerializedPayload;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoPayload;", "Lcom/google/home/matter/serialization/SerializedPayload;", "", "payload", "<init>", "([B)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getPayload", "()[B", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ProtoPayload implements SerializedPayload {
    private final byte[] payload;

    public ProtoPayload(byte[] bArr) {
        bArr.getClass();
        this.payload = bArr;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProtoPayload) && Intrinsics.areEqual(this.payload, ((ProtoPayload) other).payload);
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public int hashCode() {
        return Arrays.hashCode(this.payload);
    }

    public String toString() {
        String string = Arrays.toString(this.payload);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(string).length() + 22), "ProtoPayload(payload=", string, ")");
    }
}
