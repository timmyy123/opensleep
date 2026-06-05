package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzjx {
    private final Map zza;
    private zziz zzb;

    public /* synthetic */ zzjx(zzlh zzlhVar, int i, byte[] bArr) {
        Objects.requireNonNull(zzlhVar);
        this.zza = new HashMap();
        this.zzb = zziz.zza;
    }

    private static final zziz zzb(zziz zzizVar, List list) {
        zziy zziyVar = new zziy(zzizVar, null);
        HashSet hashSet = new HashSet(list);
        for (String str : zzizVar.zza()) {
            if (!hashSet.contains(str)) {
                zziyVar.zzf(str);
            }
        }
        return zziyVar.zzg();
    }

    public final /* synthetic */ void zza(zziz zzizVar) {
        for (Map.Entry entry : new HashMap(this.zza).entrySet()) {
            if (entry.getKey() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            } else {
                List list = (List) entry.getValue();
                if (!zzb(zzizVar, list).equals(zzb(this.zzb, list))) {
                    throw null;
                }
            }
        }
        this.zzb = zzizVar;
    }
}
