package com.google.home.matter.serialization.codec.proto;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "", "<init>", "()V", "impl", "Ljava/io/ByteArrayOutputStream;", "getImpl", "()Ljava/io/ByteArrayOutputStream;", "reset", "", "write", "byteArray", "", "toByteArray", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteArrayOutputStream {
    private final java.io.ByteArrayOutputStream impl = new java.io.ByteArrayOutputStream();

    public final java.io.ByteArrayOutputStream getImpl() {
        return this.impl;
    }

    public final void reset() {
        this.impl.reset();
    }

    public final byte[] toByteArray() {
        byte[] byteArray = this.impl.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public String toString() {
        String string = this.impl.toString();
        string.getClass();
        return string;
    }

    public final void write(byte[] byteArray) throws IOException {
        byteArray.getClass();
        this.impl.write(byteArray);
    }
}
