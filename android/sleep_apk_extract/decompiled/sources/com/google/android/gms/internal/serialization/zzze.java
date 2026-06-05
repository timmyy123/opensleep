package com.google.android.gms.internal.serialization;

import com.google.android.gms.internal.serialization.zzaaq;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzze<ContainingType extends zzaaq, Type> extends zzyn<ContainingType, Type> {
    final zzaaq zza;
    final Object zzb;
    final zzaaq zzc;
    final zzzd zzd;

    public zzze(zzaaq zzaaqVar, Object obj, zzaaq zzaaqVar2, zzzd zzzdVar, Class cls) {
        if (zzaaqVar == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Null containingTypeDefaultInstance");
            throw null;
        }
        if (zzzdVar.zzc == zzace.zzk && zzaaqVar2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Null messageDefaultInstance");
            throw null;
        }
        this.zza = zzaaqVar;
        this.zzb = obj;
        this.zzc = zzaaqVar2;
        this.zzd = zzzdVar;
    }
}
