package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
public interface ActivityRecognitionClient {
    Task<Void> removeActivityTransitionUpdates(PendingIntent pendingIntent);

    Task<Void> removeActivityUpdates(PendingIntent pendingIntent);

    Task<Void> removeSleepSegmentUpdates(PendingIntent pendingIntent);

    Task<Void> requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent);

    Task<Void> requestActivityUpdates(long j, PendingIntent pendingIntent);

    Task<Void> requestSleepSegmentUpdates(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest);
}
