package com.garmin.monkeybrains.serialization;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyNull extends MonkeyType<Object> {
    public MonkeyNull() {
        super((byte) 0);
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 1;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        return new byte[]{0};
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Object toJava() {
        return null;
    }

    public MonkeyNull(byte[] bArr) {
        super((byte) 0);
    }
}
