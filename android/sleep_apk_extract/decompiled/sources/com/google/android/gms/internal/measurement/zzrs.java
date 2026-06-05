package com.google.android.gms.internal.measurement;

import android.net.Uri;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzrs {
    private final zzsx zza;
    private final List zzb;
    private final List zzc;
    private final Uri zzd;
    private final Uri zze;

    public zzrs(zzrr zzrrVar) {
        this.zza = zzrrVar.zzf();
        this.zzb = zzrrVar.zzg();
        this.zzc = zzrrVar.zzh();
        this.zzd = zzrrVar.zzi();
        this.zze = zzrrVar.zzj();
    }

    public final zzsx zza() {
        return this.zza;
    }

    public final Uri zzb() {
        return this.zze;
    }

    public final List zzc(InputStream inputStream) {
        zzrp zzrpVarZza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(inputStream);
        List list = this.zzc;
        if (!list.isEmpty() && (zzrpVarZza = zzrp.zza(list, this.zzd, inputStream)) != null) {
            arrayList.add(zzrpVarZza);
        }
        Iterator it = this.zzb.iterator();
        if (!it.hasNext()) {
            Collections.reverse(arrayList);
            return arrayList;
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        throw null;
    }

    public final List zzd(OutputStream outputStream) {
        zzrq zzrqVarZza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(outputStream);
        List list = this.zzc;
        if (!list.isEmpty() && (zzrqVarZza = zzrq.zza(list, this.zzd, outputStream)) != null) {
            arrayList.add(zzrqVarZza);
        }
        Iterator it = this.zzb.iterator();
        if (!it.hasNext()) {
            Collections.reverse(arrayList);
            return arrayList;
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        throw null;
    }

    public final boolean zze() {
        return !this.zzb.isEmpty();
    }
}
