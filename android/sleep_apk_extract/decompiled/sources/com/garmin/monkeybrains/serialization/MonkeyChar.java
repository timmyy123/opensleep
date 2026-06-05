package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyChar extends MonkeyType<Integer> {
    private Integer mValue;

    public MonkeyChar(byte[] bArr) {
        super(bArr[0]);
        this.mValue = Integer.valueOf(ByteBuffer.wrap(bArr, 1, bArr.length - 1).getInt());
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 5;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getNumBytes());
        byteBufferAllocate.put((byte) 19);
        byteBufferAllocate.putInt(this.mValue.intValue());
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Integer toJava() {
        Integer num = this.mValue;
        num.intValue();
        return num;
    }

    public MonkeyChar(Integer num) {
        super((byte) 19);
        this.mValue = num;
    }
}
