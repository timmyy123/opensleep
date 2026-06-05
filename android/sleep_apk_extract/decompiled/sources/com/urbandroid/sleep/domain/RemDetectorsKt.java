package com.urbandroid.sleep.domain;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"fireLucidCue", "", "now", "", "minutes", "", "seconds", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class RemDetectorsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void fireLucidCue(long j) {
        Context context = SharedApplicationContext.getInstance().getContext();
        int lucidAfterHours = Settings.from(context).getLucidAfterHours();
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null) {
            long fromTime = (j - record.getFromTime()) / 3600000;
            if (fromTime >= lucidAfterHours) {
                context.getClass();
                ContextExtKt.sendExplicitBroadcast$default(context, new Intent("com.urbandroid.sleep.LUCID_CUE_ACTION"), null, 2, null);
                return;
            }
            Logger.logInfo("RemDetectorV1: Lucid cue not fired, it's too early. " + fromTime + " < " + lucidAfterHours);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long minutes(int i) {
        return ((long) i) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long seconds(int i) {
        return ((long) i) * 1000;
    }
}
