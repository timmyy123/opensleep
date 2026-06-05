package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyLong extends MonkeyType<Long> {
    private long mValue;

    public MonkeyLong(byte[] bArr) {
        super(bArr[0]);
        this.mValue = ByteBuffer.wrap(bArr, 1, bArr.length - 1).getLong();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        return 9;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getNumBytes());
        byteBufferAllocate.put(MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
        byteBufferAllocate.putLong(this.mValue);
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public Long toJava() {
        return Long.valueOf(this.mValue);
    }

    public MonkeyLong(long j) {
        super(MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
        this.mValue = j;
    }
}
