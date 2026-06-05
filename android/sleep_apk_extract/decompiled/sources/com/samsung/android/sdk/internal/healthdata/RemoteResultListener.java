package com.samsung.android.sdk.internal.healthdata;

import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult;

/* JADX INFO: loaded from: classes4.dex */
public interface RemoteResultListener<T extends HealthResultHolder.BaseResult> {
    void onReceiveHealthResult(int i, T t);
}
