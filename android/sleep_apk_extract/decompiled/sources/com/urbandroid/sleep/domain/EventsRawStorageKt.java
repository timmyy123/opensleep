package com.urbandroid.sleep.domain;

import com.urbandroid.sleep.service.Settings$$ExternalSyntheticLambda0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u001a-\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a-\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u0007\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001a\u0010\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0015\u0010\"\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/domain/Events;", "events", "", "startTime", "Lcom/urbandroid/sleep/domain/EventLabel;", "label", "Ljava/util/BitSet;", "data", "", "writeBitSet", "(Lcom/urbandroid/sleep/domain/Events;JLcom/urbandroid/sleep/domain/EventLabel;Ljava/util/BitSet;)V", "readBitSet", "(Lcom/urbandroid/sleep/domain/Events;Lcom/urbandroid/sleep/domain/EventLabel;)Ljava/util/BitSet;", "", "write", "(Lcom/urbandroid/sleep/domain/Events;JLcom/urbandroid/sleep/domain/EventLabel;[B)V", "read", "(Lcom/urbandroid/sleep/domain/Events;Lcom/urbandroid/sleep/domain/EventLabel;)[B", "", "split", "([B)[[B", "bytes", "", "toFloat", "([B)F", "f", "toBytes", "(F)[B", "bs", "(Ljava/util/BitSet;)[B", "toBitSet", "([B)Ljava/util/BitSet;", "", "i", "intToFloatViaBytes", "(I)F", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class EventsRawStorageKt {
    public static final float intToFloatViaBytes(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        return byteBufferAllocate.getFloat(0);
    }

    public static final byte[] read(Events events, EventLabel eventLabel) {
        events.getClass();
        eventLabel.getClass();
        if (!events.hasLabel(eventLabel)) {
            return new byte[0];
        }
        List<IEvent> events2 = EventsUtil.getEvents(events.getCopiedEvents(), eventLabel);
        events2.getClass();
        CollectionsKt.sortWith(events2, new Settings$$ExternalSyntheticLambda0(8));
        ArrayList arrayList = new ArrayList();
        Iterator<IEvent> it = events2.iterator();
        while (it.hasNext()) {
            arrayList.addAll(ArraysKt.asList(toBytes(it.next().getValue())));
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int read$lambda$0(IEvent iEvent, IEvent iEvent2) {
        return Intrinsics.compare(iEvent.getTimestamp(), iEvent2.getTimestamp());
    }

    public static final BitSet readBitSet(Events events, EventLabel eventLabel) {
        events.getClass();
        eventLabel.getClass();
        return toBitSet(read(events, eventLabel));
    }

    public static final byte[][] split(byte[] bArr) {
        bArr.getClass();
        ArrayList arrayList = new ArrayList();
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, bArr.length), 4);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                byte[] bArrSliceArray = ArraysKt.sliceArray(bArr, RangesKt.until(first, Math.min(first + 4, bArr.length)));
                if (bArrSliceArray.length < 4) {
                    bArrSliceArray = ArraysKt___ArraysJvmKt.copyInto$default(bArrSliceArray, new byte[4], 0, 0, 0, 14, (Object) null);
                }
                arrayList.add(bArrSliceArray);
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static final BitSet toBitSet(byte[] bArr) {
        bArr.getClass();
        BitSet bitSet = new BitSet();
        int length = bArr.length * 8;
        for (int i = 0; i < length; i++) {
            if (((byte) (bArr[i / 8] & ((byte) (1 << (i % 8))))) != 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static final byte[] toBytes(BitSet bitSet) {
        bitSet.getClass();
        byte[] bArr = new byte[(bitSet.length() + 7) / 8];
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            if (bitSet.get(i)) {
                int i2 = i / 8;
                bArr[i2] = (byte) (bArr[i2] | ((byte) (1 << (i % 8))));
            }
        }
        return bArr;
    }

    public static final float toFloat(byte[] bArr) {
        bArr.getClass();
        if (bArr.length == 4) {
            return ByteBuffer.wrap(bArr).getFloat();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Arrays.toString(bArr));
        return 0.0f;
    }

    public static final void write(Events events, long j, EventLabel eventLabel, byte[] bArr) {
        events.getClass();
        eventLabel.getClass();
        bArr.getClass();
        events.clearLabels(eventLabel);
        byte[][] bArrSplit = split(bArr);
        int length = bArrSplit.length;
        int i = 0;
        while (i < length) {
            events.addEvent(j, eventLabel, toFloat(bArrSplit[i]));
            i++;
            j = 1 + j;
        }
    }

    public static final void writeBitSet(Events events, long j, EventLabel eventLabel, BitSet bitSet) {
        events.getClass();
        eventLabel.getClass();
        bitSet.getClass();
        write(events, j, eventLabel, toBytes(bitSet));
    }

    public static final byte[] toBytes(float f) {
        byte[] bArrArray = ByteBuffer.allocate(4).putFloat(f).array();
        bArrArray.getClass();
        return bArrArray;
    }
}
