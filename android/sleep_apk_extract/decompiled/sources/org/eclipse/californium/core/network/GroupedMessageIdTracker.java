package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.util.ClockUtil;

/* JADX INFO: loaded from: classes5.dex */
public class GroupedMessageIdTracker implements MessageIdTracker {
    private int currentMID;
    private final long exchangeLifetimeNanos;
    private final long[] midLease;
    private final int min;
    private final int numberOfGroups;
    private final int range;
    private final int sizeOfGroups;

    public GroupedMessageIdTracker(int i, int i2, int i3, NetworkConfig networkConfig) {
        if (i2 >= i3) {
            Events$$ExternalSyntheticBUOutline0.m("max. MID ", i3, " must be larger than min. MID ", i2, "!");
            throw null;
        }
        if (i < i2 || i3 <= i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i3, ")!", Fragment$$ExternalSyntheticOutline1.m(i, i2, "initial MID ", " must be in range [", "-")));
            throw null;
        }
        this.exchangeLifetimeNanos = TimeUnit.MILLISECONDS.toNanos(networkConfig.getLong("EXCHANGE_LIFETIME"));
        this.currentMID = i - i2;
        this.min = i2;
        this.range = i3 - i2;
        int i4 = networkConfig.getInt("MID_TRACKER_GROUPS");
        this.numberOfGroups = i4;
        this.sizeOfGroups = ((r6 + i4) - 1) / i4;
        this.midLease = new long[i4];
    }

    @Override // org.eclipse.californium.core.network.MessageIdTracker
    public int getNextMessageId() {
        long jNanoRealtime = ClockUtil.nanoRealtime();
        synchronized (this) {
            try {
                int i = (this.currentMID & 65535) % this.range;
                int i2 = i / this.sizeOfGroups;
                int i3 = (i2 + 1) % this.numberOfGroups;
                long[] jArr = this.midLease;
                if (jArr[i3] - jNanoRealtime >= 0) {
                    return -1;
                }
                jArr[i2] = jNanoRealtime + this.exchangeLifetimeNanos;
                this.currentMID = i + 1;
                return i + this.min;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
