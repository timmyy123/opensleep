package com.google.home.matter.serialization.codec.proto;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/WireFormat;", "", "<init>", "()V", "getTagFieldNumber", "", "tag", "getTagWireType", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WireFormat {
    public static final WireFormat INSTANCE = new WireFormat();

    private WireFormat() {
    }

    public final int getTagFieldNumber(int tag) {
        return tag >>> 3;
    }

    public final int getTagWireType(int tag) {
        return tag & 7;
    }
}
