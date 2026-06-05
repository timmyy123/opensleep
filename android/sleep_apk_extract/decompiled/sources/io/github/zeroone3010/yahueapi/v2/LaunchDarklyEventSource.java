package io.github.zeroone3010.yahueapi.v2;

import com.launchdarkly.eventsource.ReadyState;
import com.launchdarkly.eventsource.background.BackgroundEventSource;

/* JADX INFO: loaded from: classes5.dex */
class LaunchDarklyEventSource implements HueEventSource {
    private BackgroundEventSource eventSource;

    /* JADX INFO: renamed from: io.github.zeroone3010.yahueapi.v2.LaunchDarklyEventSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$eventsource$ReadyState;

        static {
            int[] iArr = new int[ReadyState.values().length];
            $SwitchMap$com$launchdarkly$eventsource$ReadyState = iArr;
            try {
                iArr[ReadyState.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$launchdarkly$eventsource$ReadyState[ReadyState.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$launchdarkly$eventsource$ReadyState[ReadyState.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$launchdarkly$eventsource$ReadyState[ReadyState.SHUTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$launchdarkly$eventsource$ReadyState[ReadyState.RAW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LaunchDarklyEventSource(BackgroundEventSource backgroundEventSource) {
        this.eventSource = backgroundEventSource;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.HueEventSource, java.lang.AutoCloseable
    public void close() {
        this.eventSource.close();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.HueEventSource
    public HueEventStreamState getState() {
        int i = AnonymousClass1.$SwitchMap$com$launchdarkly$eventsource$ReadyState[this.eventSource.getEventSource().getState().ordinal()];
        return i != 1 ? (i == 2 || i == 3) ? HueEventStreamState.CONNECTING : i != 4 ? HueEventStreamState.UNDEFINED : HueEventStreamState.CLOSED : HueEventStreamState.ACTIVE;
    }
}
