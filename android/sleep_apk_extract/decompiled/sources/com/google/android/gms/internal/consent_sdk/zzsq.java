package com.google.android.gms.internal.consent_sdk;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsq {
    private static final zzsq zza = new zzsq(0, new int[0], new Object[0], false);
    private int[] zzc;
    private Object[] zzd;
    private boolean zzf;
    private int zze = -1;
    private int zzb = 0;

    private zzsq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzsq zzc() {
        return zza;
    }

    public static zzsq zze(zzsq zzsqVar, zzsq zzsqVar2) {
        int i = zzsqVar.zzb;
        int i2 = zzsqVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzsqVar.zzc, 0);
        System.arraycopy(zzsqVar2.zzc, 0, iArrCopyOf, 0, 0);
        Object[] objArrCopyOf = Arrays.copyOf(zzsqVar.zzd, 0);
        System.arraycopy(zzsqVar2.zzd, 0, objArrCopyOf, 0, 0);
        return new zzsq(0, iArrCopyOf, objArrCopyOf, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzsq)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        this.zze = 0;
        return 0;
    }

    public final zzsq zzd(zzsq zzsqVar) {
        if (zzsqVar.equals(zza)) {
            return this;
        }
        if (!this.zzf) {
            Home$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        int[] iArr = this.zzc;
        int length = iArr.length;
        System.arraycopy(zzsqVar.zzc, 0, iArr, 0, 0);
        System.arraycopy(zzsqVar.zzd, 0, this.zzd, 0, 0);
        this.zzb = 0;
        return this;
    }

    public final void zzf() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzg(StringBuilder sb, int i) {
    }
}
