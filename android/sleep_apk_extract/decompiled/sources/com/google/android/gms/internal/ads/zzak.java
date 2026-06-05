package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzak {
    public final String zza;
    public final zzag zzb;
    public final zzaf zzc;
    public final zzan zzd;
    public final zzab zze;
    public final zzai zzf;

    static {
        new zzz().zzc();
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzak(String str, zzac zzacVar, zzag zzagVar, zzaf zzafVar, zzan zzanVar, zzai zzaiVar, byte[] bArr) {
        this.zza = str;
        this.zzb = zzagVar;
        this.zzc = zzafVar;
        this.zzd = zzanVar;
        this.zze = zzacVar;
        this.zzf = zzaiVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzakVar = (zzak) obj;
        return Objects.equals(this.zza, zzakVar.zza) && this.zze.equals(zzakVar.zze) && Objects.equals(this.zzb, zzakVar.zzb) && Objects.equals(this.zzc, zzakVar.zzc) && Objects.equals(this.zzd, zzakVar.zzd) && Objects.equals(this.zzf, zzakVar.zzf);
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() * 31;
        zzag zzagVar = this.zzb;
        return (this.zzd.hashCode() + ((this.zze.hashCode() + ((this.zzc.hashCode() + ((iHashCode + (zzagVar != null ? zzagVar.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
    }
}
