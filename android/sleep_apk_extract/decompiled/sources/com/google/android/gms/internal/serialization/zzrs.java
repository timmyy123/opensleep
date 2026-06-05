package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/nest/platform/mesh/api/logger/LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "java.com.google.nest.platform.mesh.api.logger_logger-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzrs {
    public static final zzrs zza;
    public static final zzrs zzb;
    public static final zzrs zzc;
    public static final zzrs zzd;
    private static final /* synthetic */ zzrs[] zze;

    static {
        zzrs zzrsVar = new zzrs("INFO", 0);
        zza = zzrsVar;
        zzrs zzrsVar2 = new zzrs("DEBUG", 1);
        zzb = zzrsVar2;
        zzrs zzrsVar3 = new zzrs("WARNING", 2);
        zzc = zzrsVar3;
        zzrs zzrsVar4 = new zzrs("SEVERE", 3);
        zzd = zzrsVar4;
        zzrs[] zzrsVarArr = {zzrsVar, zzrsVar2, zzrsVar3, zzrsVar4};
        zze = zzrsVarArr;
        EnumEntriesKt.enumEntries(zzrsVarArr);
    }

    private zzrs(String str, int i) {
    }

    public static zzrs[] values() {
        return (zzrs[]) zze.clone();
    }
}
