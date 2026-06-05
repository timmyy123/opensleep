package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyString extends MonkeyType<String> {
    private int mOffset;
    private String mValue;

    public MonkeyString(byte[] bArr) {
        super(bArr[0]);
        this.mOffset = ByteBuffer.wrap(bArr, 1, bArr.length - 1).getInt();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public boolean equals(Object obj) {
        if (obj instanceof MonkeyString) {
            return ((MonkeyString) obj).getValue().equals(this.mValue);
        }
        return false;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 5;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getValue() {
        return this.mValue;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int hashCode() {
        String str = this.mValue;
        return 445 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getNumBytes());
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.putInt(this.mOffset);
        return byteBufferAllocate.array();
    }

    public byte[] serializeString() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mValue.getBytes(OAuth.ENCODING).length + 3);
        byteBufferAllocate.putShort((short) (this.mValue.getBytes(OAuth.ENCODING).length + 1));
        byteBufferAllocate.put(this.mValue.getBytes(OAuth.ENCODING));
        byteBufferAllocate.put((byte) 0);
        return byteBufferAllocate.array();
    }

    public void setOffset(int i) {
        this.mOffset = i;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public String toJava() {
        return this.mValue;
    }

    public MonkeyString(String str) {
        super((byte) 3);
        this.mValue = str;
    }
}
