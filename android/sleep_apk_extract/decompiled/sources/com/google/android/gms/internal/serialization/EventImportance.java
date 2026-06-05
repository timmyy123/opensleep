package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.google.android.gms.internal.home.zztu, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/EventImportance;", "", "<init>", "(Ljava/lang/String;I)V", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EventImportance {
    public static final EventImportance zza;
    public static final EventImportance zzb;
    public static final EventImportance zzc;
    public static final EventImportance zzd;
    public static final EventImportance zze;
    private static final /* synthetic */ EventImportance[] zzf;

    static {
        EventImportance eventImportance = new EventImportance("PRODUCTION_CRITICAL", 0);
        zza = eventImportance;
        EventImportance eventImportance2 = new EventImportance("PRODUCTION_STANDARD", 1);
        zzb = eventImportance2;
        EventImportance eventImportance3 = new EventImportance("INFO", 2);
        zzc = eventImportance3;
        EventImportance eventImportance4 = new EventImportance("DEBUG", 3);
        zzd = eventImportance4;
        EventImportance eventImportance5 = new EventImportance("UNRECOGNIZED", 4);
        zze = eventImportance5;
        EventImportance[] eventImportanceArr = {eventImportance, eventImportance2, eventImportance3, eventImportance4, eventImportance5};
        zzf = eventImportanceArr;
        EnumEntriesKt.enumEntries(eventImportanceArr);
    }

    private EventImportance(String str, int i) {
    }

    public static EventImportance[] values() {
        return (EventImportance[]) zzf.clone();
    }
}
