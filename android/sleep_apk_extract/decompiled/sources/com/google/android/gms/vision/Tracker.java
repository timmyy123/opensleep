package com.google.android.gms.vision;

import com.google.android.gms.vision.Detector;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Tracker<T> {
    public abstract void onDone();

    public abstract void onMissing(Detector.Detections<T> detections);

    public abstract void onNewItem(int i, T t);

    public abstract void onUpdate(Detector.Detections<T> detections, T t);
}
