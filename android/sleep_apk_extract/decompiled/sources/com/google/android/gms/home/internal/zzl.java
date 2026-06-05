package com.google.android.gms.home.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/android/gms/home/internal/InternalInteractionClient$TokenRefreshStatus;", "", "<init>", "(Ljava/lang/String;I)V", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class zzl {
    public static final zzl zza;
    public static final zzl zzb;
    public static final zzl zzc;
    private static final /* synthetic */ zzl[] zzd;

    static {
        zzl zzlVar = new zzl("UNKNOWN", 0);
        zza = zzlVar;
        zzl zzlVar2 = new zzl("REFRESHED", 1);
        zzb = zzlVar2;
        zzl zzlVar3 = new zzl("VALID", 2);
        zzc = zzlVar3;
        zzl[] zzlVarArr = {zzlVar, zzlVar2, zzlVar3};
        zzd = zzlVarArr;
        EnumEntriesKt.enumEntries(zzlVarArr);
    }

    private zzl(String str, int i) {
    }

    public static zzl[] values() {
        return (zzl[]) zzd.clone();
    }
}
