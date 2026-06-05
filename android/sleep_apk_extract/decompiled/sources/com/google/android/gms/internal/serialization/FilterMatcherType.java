package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.google.android.gms.internal.home.zztx, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/FilterMatcherType;", "", "", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilterMatcherType {
    public static final FilterMatcherType zza;
    public static final FilterMatcherType zzb;
    public static final FilterMatcherType zzc;
    public static final FilterMatcherType zzd;
    public static final FilterMatcherType zze;
    private static final /* synthetic */ FilterMatcherType[] zzg;
    private final int zzf;

    static {
        FilterMatcherType filterMatcherType = new FilterMatcherType("TYPE_UNSPECIFIED", 0, 0);
        zza = filterMatcherType;
        FilterMatcherType filterMatcherType2 = new FilterMatcherType("TRAIT_SUPPORTED", 1, 1);
        zzb = filterMatcherType2;
        FilterMatcherType filterMatcherType3 = new FilterMatcherType("TRAIT_NOT_SUPPORTED", 2, 2);
        zzc = filterMatcherType3;
        FilterMatcherType filterMatcherType4 = new FilterMatcherType("OBJECT_TYPE_SUPPORTED", 3, 3);
        zzd = filterMatcherType4;
        FilterMatcherType filterMatcherType5 = new FilterMatcherType("OBJECT_TYPE_NOT_SUPPORTED", 4, 4);
        zze = filterMatcherType5;
        FilterMatcherType[] filterMatcherTypeArr = {filterMatcherType, filterMatcherType2, filterMatcherType3, filterMatcherType4, filterMatcherType5};
        zzg = filterMatcherTypeArr;
        EnumEntriesKt.enumEntries(filterMatcherTypeArr);
    }

    private FilterMatcherType(String str, int i, int i2) {
        this.zzf = i2;
    }

    public static FilterMatcherType[] values() {
        return (FilterMatcherType[]) zzg.clone();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final int getZzf() {
        return this.zzf;
    }
}
