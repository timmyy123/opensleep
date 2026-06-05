package com.urbandroid.sleep.bluetoothle;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/FixedSizeData;", "Lcom/urbandroid/sleep/bluetoothle/DataConsumer;", "", "size", "<init>", "(I)V", "", "data", "", "consume", "([B)V", "", "isDataComplete", "()Z", "", "getInfo", "()Ljava/lang/String;", "I", "getSize", "()I", "receivedBytes", "result", "[B", "getResult", "()[B", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FixedSizeData implements DataConsumer {
    private int receivedBytes;
    private final byte[] result;
    private final int size;

    public FixedSizeData(int i) {
        this.size = i;
        this.result = new byte[i];
    }

    @Override // com.urbandroid.sleep.bluetoothle.DataConsumer
    public void consume(byte[] data2) {
        data2.getClass();
        for (byte b : data2) {
            int i = this.receivedBytes;
            byte[] bArr = this.result;
            if (i < bArr.length) {
                bArr[i] = b;
            }
            this.receivedBytes = i + 1;
            if (isDataComplete()) {
                return;
            }
        }
    }

    @Override // com.urbandroid.sleep.bluetoothle.DataConsumer
    public String getInfo() {
        return "Expected size: " + this.size + ", received result: " + BLEUtilKt.toString(this.result);
    }

    public final byte[] getResult() {
        return this.result;
    }

    @Override // com.urbandroid.sleep.bluetoothle.DataConsumer
    public boolean isDataComplete() {
        return this.receivedBytes >= this.result.length;
    }
}
