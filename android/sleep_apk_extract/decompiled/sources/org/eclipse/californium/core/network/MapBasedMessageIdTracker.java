package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.util.ClockUtil;

/* JADX INFO: loaded from: classes5.dex */
public class MapBasedMessageIdTracker implements MessageIdTracker {
    private int counter;
    private final long exchangeLifetimeNanos;
    private final Map<Integer, Long> messageIds;
    private final int min;
    private final int range;

    public MapBasedMessageIdTracker(int i, int i2, int i3, NetworkConfig networkConfig) {
        if (i2 >= i3) {
            Events$$ExternalSyntheticBUOutline0.m("max. MID ", i3, " must be larger than min. MID ", i2, "!");
            throw null;
        }
        if (i < i2 || i3 <= i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i3, ")!", Fragment$$ExternalSyntheticOutline1.m(i, i2, "initial MID ", " must be in range [", "-")));
            throw null;
        }
        this.exchangeLifetimeNanos = TimeUnit.MILLISECONDS.toNanos(networkConfig.getLong("EXCHANGE_LIFETIME"));
        this.counter = i - i2;
        this.min = i2;
        int i4 = i3 - i2;
        this.range = i4;
        this.messageIds = new HashMap(i4);
    }

    @Override // org.eclipse.californium.core.network.MessageIdTracker
    public int getNextMessageId() {
        int i;
        boolean z;
        long jNanoRealtime = ClockUtil.nanoRealtime();
        synchronized (this.messageIds) {
            try {
                int i2 = (this.counter & 65535) % this.range;
                this.counter = i2;
                i = -1;
                loop0: while (true) {
                    for (false; i < 0 && !z; true) {
                        int i3 = this.counter;
                        this.counter = i3 + 1;
                        int i4 = i3 % this.range;
                        Long l = this.messageIds.get(Integer.valueOf(i4));
                        if (l == null || l.longValue() - jNanoRealtime <= 0) {
                            i = this.min + i4;
                            this.messageIds.put(Integer.valueOf(i4), Long.valueOf(this.exchangeLifetimeNanos + jNanoRealtime));
                        }
                        z = this.counter % this.range == i2;
                    }
                }
            } finally {
            }
        }
        return i;
    }
}
