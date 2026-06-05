package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class NullMessageIdTracker implements MessageIdTracker {
    private final AtomicInteger currentMID;
    private final int min;
    private final int range;

    public NullMessageIdTracker(int i, int i2, int i3) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.currentMID = atomicInteger;
        if (i2 >= i3) {
            Events$$ExternalSyntheticBUOutline0.m("max. MID ", i3, " must be larger than min. MID ", i2, "!");
            throw null;
        }
        if (i < i2 || i3 <= i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i3, ")!", Fragment$$ExternalSyntheticOutline1.m(i, i2, "initial MID ", " must be in range [", "-")));
            throw null;
        }
        atomicInteger.set(i - i2);
        this.min = i2;
        this.range = i3 - i2;
    }

    @Override // org.eclipse.californium.core.network.MessageIdTracker
    public int getNextMessageId() {
        int andIncrement = this.currentMID.getAndIncrement();
        int i = this.range;
        if (andIncrement % i == i - 1) {
            this.currentMID.addAndGet(-i);
        }
        return this.min + andIncrement;
    }
}
