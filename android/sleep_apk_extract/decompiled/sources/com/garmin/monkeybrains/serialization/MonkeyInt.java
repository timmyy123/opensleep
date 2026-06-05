package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyInt extends MonkeyType<Integer> {
    private int mValue;

    public MonkeyInt(byte[] bArr) {
        super(bArr[0]);
        this.mValue = ByteBuffer.wrap(bArr, 1, bArr.length - 1).getInt();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 5;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getNumBytes());
        byteBufferAllocate.put(this.mType);
        byteBufferAllocate.putInt(this.mValue);
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Integer toJava() {
        return Integer.valueOf(this.mValue);
    }

    public MonkeyInt(int i) {
        super((byte) 1);
        this.mValue = i;
    }
}
