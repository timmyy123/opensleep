package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyArray extends MonkeyType<List<MonkeyType<?>>> implements MonkeyContainer {
    private int mChildCount;
    private List<MonkeyType<?>> mList;

    public <T> MonkeyArray(List<T> list, boolean z) {
        super((byte) 5);
        this.mList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.mList.add(MonkeyType.fromJava(it.next(), z));
        }
    }

    public int getChildCount() {
        return this.mChildCount;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyContainer
    public List<MonkeyType<?>> getChildren() {
        return this.mList;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        Iterator<MonkeyType<?>> it = this.mList.iterator();
        int numBytes = 5;
        while (it.hasNext()) {
            numBytes += it.next().getNumBytes();
        }
        return numBytes;
    }

    public List<MonkeyType<?>> getValues() {
        return this.mList;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.put((byte) 5);
        byteBufferAllocate.putInt(this.mList.size());
        return byteBufferAllocate.array();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public List<MonkeyType<?>> toJava() {
        return this.mList;
    }

    public MonkeyArray(byte[] bArr) {
        super(bArr[0]);
        this.mList = new ArrayList();
        this.mChildCount = ByteBuffer.wrap(bArr, 1, 4).getInt();
    }
}
