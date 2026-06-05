package com.garmin.monkeybrains.serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyHash extends MonkeyType<HashMap<MonkeyType<?>, MonkeyType<?>>> implements MonkeyContainer {
    private HashMap<MonkeyType<?>, MonkeyType<?>> mHash;
    private int mHashSize;

    public MonkeyHash(Map<Object, Object> map, boolean z) {
        super(MqttWireMessage.MESSAGE_TYPE_UNSUBACK);
        this.mHash = new HashMap<>();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            this.mHash.put(MonkeyType.fromJava(key, z), MonkeyType.fromJava(value, z));
        }
    }

    public int getChildCount() {
        return this.mHashSize;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyContainer
    public List<MonkeyType<?>> getChildren() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<MonkeyType<?>, MonkeyType<?>> entry : this.mHash.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    public HashMap<MonkeyType<?>, MonkeyType<?>> getHashMap() {
        return this.mHash;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public int getNumBytes() {
        int numBytes = 5;
        for (Map.Entry<MonkeyType<?>, MonkeyType<?>> entry : this.mHash.entrySet()) {
            numBytes += entry.getValue().getNumBytes() + entry.getKey().getNumBytes();
        }
        return numBytes;
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public byte[] serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.put(MqttWireMessage.MESSAGE_TYPE_UNSUBACK);
        byteBufferAllocate.putInt(this.mHash.size());
        return byteBufferAllocate.array();
    }

    @Override // com.garmin.monkeybrains.serialization.MonkeyType
    public HashMap<MonkeyType<?>, MonkeyType<?>> toJava() {
        return this.mHash;
    }

    public MonkeyHash(byte[] bArr) {
        super(bArr[0]);
        this.mHash = new HashMap<>();
        this.mHashSize = ByteBuffer.wrap(bArr, 1, 4).getInt();
    }
}
