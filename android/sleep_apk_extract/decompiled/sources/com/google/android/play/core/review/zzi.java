package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.internal.zzt;
import com.google.android.play.core.review.internal.zzw;

/* JADX INFO: loaded from: classes4.dex */
public final class zzi {
    private static final com.google.android.play.core.review.internal.zzi zzb = new com.google.android.play.core.review.internal.zzi("ReviewService");
    zzt zza;
    private final String zzc;

    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.play.core.review.zze] */
    public zzi(Context context) {
        this.zzc = context.getPackageName();
        if (zzw.zza(context)) {
            this.zza = new zzt(context, zzb, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), new Object() { // from class: com.google.android.play.core.review.zze
            }, null);
        }
    }

    public final Task zza() {
        String str = this.zzc;
        com.google.android.play.core.review.internal.zzi zziVar = zzb;
        zziVar.zzc("requestInAppReview (%s)", str);
        if (this.zza == null) {
            zziVar.zza("Play Store app is either not installed or not the official version", new Object[0]);
            return Tasks.forException(new ReviewException(-1));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzf(this, taskCompletionSource, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
