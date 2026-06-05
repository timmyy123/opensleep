package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyDouble extends MonkeyType<Double> {
    private double mValue;

    public MonkeyDouble(byte[] bArr) {
        super(bArr[0]);
        this.mValue = ByteBuffer.wrap(bArr, 1, bArr.length - 1).getDouble();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 9;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getNumBytes());
        byteBufferAllocate.put((byte) 15);
        byteBufferAllocate.putDouble(this.mValue);
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Double toJava() {
        return Double.valueOf(this.mValue);
    }

    public MonkeyDouble(double d) {
        super((byte) 15);
        this.mValue = d;
    }
}
