package com.urbandroid.sleep.service.google.fit;

import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "hr", "Lcom/google/android/gms/fitness/FitnessOptions;", "fitnessOptions", "(Z)Lcom/google/android/gms/fitness/FitnessOptions;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class GoogleFitConstantsKt {
    public static final FitnessOptions fitnessOptions(boolean z) {
        FitnessOptions.Builder builder = FitnessOptions.builder();
        DataType dataType = DataType.TYPE_SLEEP_SEGMENT;
        builder.addDataType(dataType, 1);
        builder.addDataType(dataType, 0);
        if (z) {
            DataType dataType2 = DataType.TYPE_HEART_RATE_BPM;
            builder.addDataType(dataType2, 0);
            builder.addDataType(dataType2, 1);
        }
        FitnessOptions fitnessOptionsBuild = builder.build();
        fitnessOptionsBuild.getClass();
        return fitnessOptionsBuild;
    }
}
