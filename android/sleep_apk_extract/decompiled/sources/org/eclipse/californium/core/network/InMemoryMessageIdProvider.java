package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.internal.NativeProtocol;
import java.net.InetSocketAddress;
import java.util.Random;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.LeastRecentlyUsedCache;
import org.eclipse.californium.elements.util.NetworkInterfacesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class InMemoryMessageIdProvider implements MessageIdProvider {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) InMemoryMessageIdProvider.class);
    private final NetworkConfig config;
    private final TrackerMode mode;
    private final int multicastBaseMid;
    private final MessageIdTracker multicastTracker;
    private final Random random;
    private final LeastRecentlyUsedCache<InetSocketAddress, MessageIdTracker> trackers;

    /* JADX INFO: renamed from: org.eclipse.californium.core.network.InMemoryMessageIdProvider$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$core$network$InMemoryMessageIdProvider$TrackerMode;

        static {
            int[] iArr = new int[TrackerMode.values().length];
            $SwitchMap$org$eclipse$californium$core$network$InMemoryMessageIdProvider$TrackerMode = iArr;
            try {
                iArr[TrackerMode.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$network$InMemoryMessageIdProvider$TrackerMode[TrackerMode.MAPBASED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$network$InMemoryMessageIdProvider$TrackerMode[TrackerMode.GROUPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum TrackerMode {
        NULL,
        GROUPED,
        MAPBASED
    }

    public InMemoryMessageIdProvider(NetworkConfig networkConfig) {
        String string;
        if (networkConfig == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Config must not be null");
            throw null;
        }
        try {
            try {
                string = networkConfig.getString("MID_TACKER");
                try {
                    TrackerMode trackerModeValueOf = TrackerMode.valueOf(string);
                    this.mode = trackerModeValueOf;
                    this.config = networkConfig;
                    if (networkConfig.getBoolean("USE_RANDOM_MID_START")) {
                        this.random = new Random(ClockUtil.nanoRealtime());
                    } else {
                        this.random = null;
                    }
                    LeastRecentlyUsedCache<InetSocketAddress, MessageIdTracker> leastRecentlyUsedCache = new LeastRecentlyUsedCache<>(networkConfig.getInt("MAX_ACTIVE_PEERS", 150000), networkConfig.getLong("MAX_PEER_INACTIVITY_PERIOD", 600L));
                    this.trackers = leastRecentlyUsedCache;
                    leastRecentlyUsedCache.setEvictingOnReadAccess(false);
                    int i = networkConfig.getInt("MULTICAST_BASE_MID");
                    if (i <= 0) {
                        this.multicastBaseMid = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        this.multicastTracker = null;
                        return;
                    }
                    this.multicastBaseMid = i;
                    Random random = this.random;
                    int iNextInt = random == null ? i : random.nextInt(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST - i) + i;
                    int i2 = AnonymousClass1.$SwitchMap$org$eclipse$californium$core$network$InMemoryMessageIdProvider$TrackerMode[trackerModeValueOf.ordinal()];
                    if (i2 == 1) {
                        this.multicastTracker = new NullMessageIdTracker(iNextInt, i, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                    } else if (i2 != 2) {
                        this.multicastTracker = new GroupedMessageIdTracker(iNextInt, i, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, networkConfig);
                    } else {
                        this.multicastTracker = new MapBasedMessageIdTracker(iNextInt, i, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, networkConfig);
                    }
                } catch (IllegalArgumentException unused) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Tracker mode '", string, "' not supported!"));
                    throw null;
                }
            } catch (NullPointerException unused2) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Tracker mode not provided/configured!");
                throw null;
            }
        } catch (IllegalArgumentException unused3) {
            string = null;
        }
    }

    private synchronized MessageIdTracker getTracker(InetSocketAddress inetSocketAddress) {
        try {
            if (NetworkInterfacesUtil.isMultiAddress(inetSocketAddress.getAddress())) {
                if (this.multicastTracker == null) {
                    LOG.warn("Destination address {} is a multicast address, please configure NetworkConfig to support multicast messaging", inetSocketAddress);
                }
                return this.multicastTracker;
            }
            MessageIdTracker messageIdTracker = this.trackers.get(inetSocketAddress);
            if (messageIdTracker != null) {
                return messageIdTracker;
            }
            Random random = this.random;
            int iNextInt = random == null ? 0 : random.nextInt(this.multicastBaseMid);
            int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$core$network$InMemoryMessageIdProvider$TrackerMode[this.mode.ordinal()];
            MessageIdTracker groupedMessageIdTracker = i != 1 ? i != 2 ? new GroupedMessageIdTracker(iNextInt, 0, this.multicastBaseMid, this.config) : new MapBasedMessageIdTracker(iNextInt, 0, this.multicastBaseMid, this.config) : new NullMessageIdTracker(iNextInt, 0, this.multicastBaseMid);
            if (this.trackers.put(inetSocketAddress, groupedMessageIdTracker)) {
                return groupedMessageIdTracker;
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.eclipse.californium.core.network.MessageIdProvider
    public int getNextMessageId(InetSocketAddress inetSocketAddress) {
        MessageIdTracker tracker = getTracker(inetSocketAddress);
        if (tracker == null) {
            return -1;
        }
        return tracker.getNextMessageId();
    }
}
