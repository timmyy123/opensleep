package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
public class StringBlock extends ArrayList<MonkeyString> {
    private static final long serialVersionUID = 7158590947509522494L;
    private HashMap<Integer, String> mDeserializedStrings;
    private int mTotalBytes;

    public StringBlock(byte[] bArr) {
        this.mDeserializedStrings = new HashMap<>();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            int i3 = ByteBuffer.wrap(bArr, i, 2).getShort() + i2;
            this.mDeserializedStrings.put(Integer.valueOf(i), new String(Arrays.copyOfRange(bArr, i2, i3 - 1), OAuth.ENCODING));
            i = i3;
        }
    }

    private int getOffsetFor(MonkeyString monkeyString) {
        int length = 0;
        for (int i = 0; i < size() && !get(i).equals(monkeyString); i++) {
            length += get(i).getValue().getBytes(OAuth.ENCODING).length + 3;
        }
        return length;
    }

    public int addString(MonkeyString monkeyString) {
        int offsetFor = getOffsetFor(monkeyString);
        monkeyString.setOffset(offsetFor);
        if (!contains(monkeyString)) {
            add(monkeyString);
            this.mTotalBytes = monkeyString.getValue().getBytes(OAuth.ENCODING).length + 3 + this.mTotalBytes;
        }
        return offsetFor;
    }

    public HashMap<Integer, String> getDeserializedStrings() {
        return this.mDeserializedStrings;
    }

    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mTotalBytes);
        for (int i = 0; i < size(); i++) {
            byteBufferAllocate.put(get(i).serializeString());
        }
        return byteBufferAllocate.array();
    }

    public StringBlock() {
    }
}
