package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.net.Uri;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzag {
    public final Uri zza;
    public final String zzb;
    public final List zze;
    public final String zzf;
    public final zzgwm zzg;
    public final Object zzh;
    public final long zzi;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    public /* synthetic */ zzag(Uri uri, String str, zzad zzadVar, zzy zzyVar, List list, String str2, zzgwm zzgwmVar, Object obj, long j, byte[] bArr) {
        this.zza = uri;
        int i = zzas.$r8$clinit;
        this.zzb = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzgwmVar;
        int i2 = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        if (zzgwmVar.size() > 0) {
            zzgwmVar.get(0).getClass();
            Events$$ExternalSyntheticBUOutline0.m();
            throw null;
        }
        zzgwjVar.zzi();
        this.zzh = null;
        this.zzi = -9223372036854775807L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        return this.zza.equals(zzagVar.zza) && this.zze.equals(zzagVar.zze) && this.zzg.equals(zzagVar.zzg);
    }

    public final int hashCode() {
        return (int) ((((long) ((this.zzg.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.zze, this.zza.hashCode() * 923521, 961)) * 31)) * 31) - Long.MAX_VALUE);
    }
}
