package com.urbandroid.sleep.bluetoothle;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/BoundedBuffer;", "Lcom/urbandroid/sleep/bluetoothle/DataConsumer;", "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "<init>", "(I)V", "", "data", "", "consume", "([B)V", "", "getInfo", "()Ljava/lang/String;", "I", "getMaxSize", "()I", "Ljava/util/LinkedList;", "", "buffer", "Ljava/util/LinkedList;", "getBuffer", "()Ljava/util/LinkedList;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BoundedBuffer implements DataConsumer {
    private final LinkedList<Byte> buffer = new LinkedList<>();
    private final int maxSize;

    public BoundedBuffer(int i) {
        this.maxSize = i;
    }

    @Override // com.urbandroid.sleep.bluetoothle.DataConsumer
    public void consume(byte[] data2) {
        data2.getClass();
        for (byte b : data2) {
            this.buffer.add(Byte.valueOf(b));
        }
        while (this.buffer.size() > this.maxSize) {
            this.buffer.removeFirst();
        }
    }

    public final LinkedList<Byte> getBuffer() {
        return this.buffer;
    }

    @Override // com.urbandroid.sleep.bluetoothle.DataConsumer
    public String getInfo() {
        return BLEUtilKt.toString(this.buffer);
    }
}
