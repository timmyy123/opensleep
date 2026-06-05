package com.urbandroid.sleep.domain;

import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SleepRecords$$ExternalSyntheticLambda0 implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((SleepRecord) obj).getSleepLengthMinutes();
    }
}
