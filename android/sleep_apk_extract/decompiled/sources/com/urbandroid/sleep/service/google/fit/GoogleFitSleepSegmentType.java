package com.urbandroid.sleep.service.google.fit;

import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/GoogleFitSleepSegmentType;", "", "<init>", "()V", "", "fitSleepSegment", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "findByName", "(Ljava/lang/String;)Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleFitSleepSegmentType {
    public static final GoogleFitSleepSegmentType INSTANCE = new GoogleFitSleepSegmentType();

    private GoogleFitSleepSegmentType() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final SleepSegmentType findByName(String fitSleepSegment) {
        fitSleepSegment.getClass();
        switch (fitSleepSegment.hashCode()) {
            case -447359058:
                if (fitSleepSegment.equals("sleep.awake")) {
                    return SleepSegmentType.AWAKE_PAUSED;
                }
                return null;
            case -437611713:
                if (fitSleepSegment.equals("sleep.light")) {
                    return SleepSegmentType.LIGHT;
                }
                return null;
            case -430000733:
                if (fitSleepSegment.equals("sleep.deep")) {
                    return SleepSegmentType.DEEP;
                }
                return null;
            case -13857533:
                if (fitSleepSegment.equals("sleep.rem")) {
                    return SleepSegmentType.REM;
                }
                return null;
            default:
                return null;
        }
    }
}
