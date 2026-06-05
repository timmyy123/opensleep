package com.facebook.appevents.internal;

import android.content.Context;
import com.urbandroid.sleep.audio.consumer.TensorflowAudioConsumerV3;
import com.urbandroid.sleep.audio.consumer.TensorflowAudioConsumerV4;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.snoring.SoundClass;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ActivityLifecycleTracker$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Serializable f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ActivityLifecycleTracker$$ExternalSyntheticLambda1(long j, String str, Context context) {
        this.$r8$classId = 0;
        this.f$0 = j;
        this.f$1 = str;
        this.f$2 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        long j = this.f$0;
        Object obj = this.f$2;
        Serializable serializable = this.f$1;
        switch (i) {
            case 0:
                ActivityLifecycleTracker.onActivityResumed$lambda$3(j, (String) serializable, (Context) obj);
                break;
            case 1:
                TensorflowAudioConsumerV3.processChunk$lambda$0((SleepRecord) serializable, (SoundClass) obj, 30.0d, j);
                break;
            default:
                TensorflowAudioConsumerV4.processChunk$lambda$0((SleepRecord) serializable, (SoundClass) obj, 30.0d, j);
                break;
        }
    }

    public /* synthetic */ ActivityLifecycleTracker$$ExternalSyntheticLambda1(SleepRecord sleepRecord, SoundClass soundClass, long j, int i) {
        this.$r8$classId = i;
        this.f$1 = sleepRecord;
        this.f$2 = soundClass;
        this.f$0 = j;
    }
}
