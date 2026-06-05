package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyFloat extends MonkeyType<Float> {
    private float mValue;

    public MonkeyFloat(byte[] bArr) {
        super(bArr[0]);
        this.mValue = ByteBuffer.wrap(bArr, 1, bArr.length - 1).getFloat();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 5;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getNumBytes());
        byteBufferAllocate.put((byte) 2);
        byteBufferAllocate.putFloat(this.mValue);
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Float toJava() {
        return Float.valueOf(this.mValue);
    }

    public MonkeyFloat(float f) {
        super((byte) 2);
        this.mValue = f;
    }
}
