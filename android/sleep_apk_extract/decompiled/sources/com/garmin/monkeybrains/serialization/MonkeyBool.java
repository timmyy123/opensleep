package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyBool extends MonkeyType<Boolean> {
    private boolean mValue;

    public MonkeyBool(byte[] bArr) {
        super(bArr[0]);
        this.mValue = ByteBuffer.wrap(bArr, 1, bArr.length - 1).get() > 0;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 2;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        return new byte[]{9, this.mValue ? (byte) 1 : (byte) 0};
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Boolean toJava() {
        return Boolean.valueOf(this.mValue);
    }

    public MonkeyBool(boolean z) {
        super((byte) 9);
        this.mValue = z;
    }
}
