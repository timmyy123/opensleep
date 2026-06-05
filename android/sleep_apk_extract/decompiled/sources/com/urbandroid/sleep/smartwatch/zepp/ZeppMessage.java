package com.urbandroid.sleep.smartwatch.zepp;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/zepp/ZeppMessage;", "", "", "name", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toJson", "()Ljava/lang/String;", "Ljava/lang/String;", "getName", "getData", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ZeppMessage {
    private final String data;
    private final String name;

    public ZeppMessage(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.name = str;
        this.data = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String toJson() {
        return FileInsert$$ExternalSyntheticOutline0.m("{\"name\":\"", this.name, "\", \"data\":\"", this.data, "\"}");
    }
}
