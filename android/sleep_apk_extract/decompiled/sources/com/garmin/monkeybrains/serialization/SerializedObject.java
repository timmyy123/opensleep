package com.garmin.monkeybrains.serialization;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedObject {
    private DataBlock mDataBlock;
    private StringBlock mStringBlock;

    public SerializedObject(byte[] bArr) {
        int i;
        int stringBlock = getStringBlock(bArr);
        if (stringBlock > 0) {
            i = stringBlock + 8;
            if (i > bArr.length) {
                throw new BufferUnderflowException();
            }
            this.mStringBlock = new StringBlock(Arrays.copyOfRange(bArr, 8, i));
        } else {
            i = 0;
        }
        int i2 = i + 8;
        if (i2 > bArr.length) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 8);
        byteBufferWrap.getInt();
        int i3 = byteBufferWrap.getInt() + i2;
        if (i3 > bArr.length) {
            throw new BufferUnderflowException();
        }
        this.mDataBlock = new DataBlock(Arrays.copyOfRange(bArr, i2, i3), this.mStringBlock);
    }

    private void addToStrings(MonkeyType<?> monkeyType) {
        if (monkeyType instanceof MonkeyString) {
            MonkeyString monkeyString = (MonkeyString) monkeyType;
            monkeyString.setOffset(this.mStringBlock.addString(monkeyString));
            return;
        }
        if (monkeyType instanceof MonkeyArray) {
            Iterator<MonkeyType<?>> it = ((MonkeyArray) monkeyType).getValues().iterator();
            while (it.hasNext()) {
                addToStrings(it.next());
            }
        } else if (monkeyType instanceof MonkeyHash) {
            for (Map.Entry<MonkeyType<?>, MonkeyType<?>> entry : ((MonkeyHash) monkeyType).getHashMap().entrySet()) {
                addToStrings(entry.getKey());
                addToStrings(entry.getValue());
            }
        }
    }

    private int getStringBlock(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.getInt() == -1412584499) {
            return byteBufferWrap.getInt();
        }
        return 0;
    }

    public void addObject(MonkeyType<?> monkeyType) {
        this.mDataBlock.add(monkeyType);
        addToStrings(monkeyType);
    }

    public List<MonkeyType<?>> getValues() {
        return this.mDataBlock;
    }

    public byte[] serialize() {
        byte[] bArrSerialize = this.mStringBlock.serialize();
        byte[] bArrSerialize2 = this.mDataBlock.serialize();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrSerialize.length > 0 ? bArrSerialize.length + 16 + bArrSerialize2.length : bArrSerialize2.length + 8);
        if (bArrSerialize.length > 0) {
            byteBufferAllocate.putInt(-1412584499);
            byteBufferAllocate.putInt(bArrSerialize.length);
            byteBufferAllocate.put(bArrSerialize);
        }
        byteBufferAllocate.putInt(-629482886);
        byteBufferAllocate.putInt(bArrSerialize2.length);
        byteBufferAllocate.put(bArrSerialize2);
        return byteBufferAllocate.array();
    }

    public SerializedObject() {
        this.mStringBlock = new StringBlock();
        this.mDataBlock = new DataBlock();
    }
}
