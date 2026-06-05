package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyByteArray extends MonkeyType<List<Byte>> {
    private List<Byte> mList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonkeyByteArray(byte[] bArr) {
        super(bArr[0]);
        int i = 0;
        this.mList = new ArrayList();
        int i2 = ByteBuffer.wrap(bArr, 1, 4).getInt();
        for (int i3 = 5; i3 < bArr.length && i < i2; i3++) {
            this.mList.add(Byte.valueOf(bArr[i3]));
            i++;
        }
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return this.mList.size() + 5;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mList.size() + 5);
        byteBufferAllocate.put((byte) 20);
        byteBufferAllocate.putInt(this.mList.size());
        Iterator<Byte> it = this.mList.iterator();
        while (it.hasNext()) {
            byteBufferAllocate.put(it.next().byteValue());
        }
        return byteBufferAllocate.array();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public List<Byte> toJava() {
        return this.mList;
    }

    public MonkeyByteArray(List<Byte> list) {
        super((byte) 20);
        this.mList = new ArrayList();
        Iterator<Byte> it = list.iterator();
        while (it.hasNext()) {
            this.mList.add(it.next());
        }
    }
}
