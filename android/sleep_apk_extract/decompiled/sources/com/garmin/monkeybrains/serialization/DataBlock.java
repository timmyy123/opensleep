package com.garmin.monkeybrains.serialization;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DataBlock extends ArrayList<MonkeyType<?>> {
    private static final long serialVersionUID = -8058543222042601383L;
    private LinkedList<MonkeyType<?>> mComplexDeserialQueue;
    private LinkedList<MonkeyType<?>> mDeserialQueue;
    private LinkedList<MonkeyType<?>> mSerialQueue;
    private int mTotalBytes;

    public DataBlock(byte[] bArr, StringBlock stringBlock) throws UnsupportedEncodingException {
        this.mDeserialQueue = new LinkedList<>();
        this.mComplexDeserialQueue = new LinkedList<>();
        int numBytes = 0;
        while (numBytes < bArr.length) {
            MonkeyType<?> monkeyTypeDeserialize = MonkeyType.deserialize(Arrays.copyOfRange(bArr, numBytes, bArr.length));
            if (monkeyTypeDeserialize == null) {
                throw new UnsupportedEncodingException("Failed to deserialize MonkeyC objects");
            }
            this.mDeserialQueue.add(monkeyTypeDeserialize);
            if (stringBlock != null && (monkeyTypeDeserialize instanceof MonkeyString)) {
                attachStrings(monkeyTypeDeserialize, stringBlock);
            }
            numBytes += monkeyTypeDeserialize.getNumBytes();
        }
        processDeserializeQueue();
    }

    private void attachStrings(MonkeyType<?> monkeyType, StringBlock stringBlock) {
        if (monkeyType instanceof MonkeyString) {
            MonkeyString monkeyString = (MonkeyString) monkeyType;
            monkeyString.setValue(stringBlock.getDeserializedStrings().get(Integer.valueOf(monkeyString.getOffset())));
            return;
        }
        if (monkeyType instanceof MonkeyArray) {
            Iterator<MonkeyType<?>> it = ((MonkeyArray) monkeyType).getValues().iterator();
            while (it.hasNext()) {
                attachStrings(it.next(), stringBlock);
            }
        } else if (monkeyType instanceof MonkeyHash) {
            for (Map.Entry<MonkeyType<?>, MonkeyType<?>> entry : ((MonkeyHash) monkeyType).getHashMap().entrySet()) {
                attachStrings(entry.getKey(), stringBlock);
                attachStrings(entry.getValue(), stringBlock);
            }
        }
    }

    private void processArray(MonkeyArray monkeyArray) {
        for (int i = 0; i < monkeyArray.getChildCount(); i++) {
            MonkeyType<?> monkeyTypePoll = this.mDeserialQueue.poll();
            if (monkeyTypePoll instanceof MonkeyContainer) {
                queueComplex(monkeyTypePoll);
            }
            monkeyArray.getChildren().add(monkeyTypePoll);
        }
        processComplexDeserializeQueue();
    }

    private void processComplexDeserializeQueue() {
        MonkeyType<?> monkeyTypePoll;
        do {
            monkeyTypePoll = this.mComplexDeserialQueue.poll();
            if (monkeyTypePoll != null) {
                if (monkeyTypePoll instanceof MonkeyArray) {
                    processArray((MonkeyArray) monkeyTypePoll);
                } else if (monkeyTypePoll instanceof MonkeyHash) {
                    processHash((MonkeyHash) monkeyTypePoll);
                }
            }
        } while (monkeyTypePoll != null);
    }

    private void processDeserializeQueue() {
        MonkeyType<?> monkeyTypePoll;
        do {
            monkeyTypePoll = this.mDeserialQueue.poll();
            if (monkeyTypePoll != null) {
                if (monkeyTypePoll instanceof MonkeyArray) {
                    processArray((MonkeyArray) monkeyTypePoll);
                } else if (monkeyTypePoll instanceof MonkeyHash) {
                    processHash((MonkeyHash) monkeyTypePoll);
                }
                add(monkeyTypePoll);
            }
        } while (monkeyTypePoll != null);
    }

    private void processHash(MonkeyHash monkeyHash) {
        for (int i = 0; i < monkeyHash.getChildCount(); i++) {
            MonkeyType<?> monkeyTypePoll = this.mDeserialQueue.poll();
            if (monkeyTypePoll instanceof MonkeyContainer) {
                queueComplex(monkeyTypePoll);
            }
            MonkeyType<?> monkeyTypePoll2 = this.mDeserialQueue.poll();
            if (monkeyTypePoll2 instanceof MonkeyContainer) {
                queueComplex(monkeyTypePoll2);
            }
            monkeyHash.getHashMap().put(monkeyTypePoll, monkeyTypePoll2);
        }
        processComplexDeserializeQueue();
    }

    private void queueComplex(MonkeyType<?> monkeyType) {
        this.mComplexDeserialQueue.add(monkeyType);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(MonkeyType<?> monkeyType) {
        boolean zAdd = super.add(monkeyType);
        if (zAdd) {
            try {
                this.mTotalBytes += monkeyType.getNumBytes();
            } catch (Exception unused) {
            }
        }
        return zAdd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] serialize() {
        MonkeyType monkeyType;
        this.mSerialQueue.clear();
        this.mSerialQueue.addAll(this);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mTotalBytes);
        do {
            monkeyType = (MonkeyType) this.mSerialQueue.poll();
            if (monkeyType != 0) {
                byteBufferAllocate.put(monkeyType.serialize());
                if (monkeyType instanceof MonkeyContainer) {
                    this.mSerialQueue.addAll(((MonkeyContainer) monkeyType).getChildren());
                }
            }
        } while (monkeyType != 0);
        return byteBufferAllocate.array();
    }

    public DataBlock() {
        this.mSerialQueue = new LinkedList<>();
    }
}
