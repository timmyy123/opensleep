package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzano implements zzahk {
    private final zzahk zza;
    private final zzanj zzb;
    private zzanl zzg;
    private zzv zzh;
    private boolean zzi;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzfl.zzb;
    private final zzet zzc = new zzet();

    public zzano(zzahk zzahkVar, zzanj zzanjVar) {
        this.zza = zzahkVar;
        this.zzb = zzanjVar;
    }

    private final void zzi(int i) {
        int length = this.zzf.length;
        int i2 = this.zze;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.zzd;
        int iMax = Math.max(i3 + i3, i + i3);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i3);
        this.zzd = 0;
        this.zze = i3;
        this.zzf = bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzA(zzv zzvVar) {
        String str = zzvVar.zzp;
        str.getClass();
        zzgtj.zza(zzas.zzf(str) == 3);
        if (!zzvVar.equals(this.zzh)) {
            this.zzh = zzvVar;
            zzanj zzanjVar = this.zzb;
            this.zzg = zzanjVar.zza(zzvVar) ? zzanjVar.zzc(zzvVar) : null;
        }
        zzanl zzanlVar = this.zzg;
        zzahk zzahkVar = this.zza;
        if (zzanlVar == null) {
            zzahkVar.zzA(zzvVar);
            return;
        }
        zzt zztVarZza = zzvVar.zza();
        zztVarZza.zzo("application/x-media3-cues");
        zztVarZza.zzk(str);
        zztVarZza.zzt(Long.MAX_VALUE);
        zztVarZza.zzM(this.zzb.zzb(zzvVar));
        zzahkVar.zzA(zztVarZza.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i, boolean z, int i2) throws EOFException {
        if (this.zzg == null) {
            return this.zza.zzb(zzjVar, i, z, 0);
        }
        zzi(i);
        int iZza = zzjVar.zza(this.zzf, this.zze, i);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z) {
            return -1;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i, int i2) {
        if (this.zzg == null) {
            this.zza.zzd(zzetVar, i, i2);
            return;
        }
        zzi(i);
        zzetVar.zzm(this.zzf, this.zze, i);
        this.zze += i;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zze(final long j, final int i, int i2, int i3, zzahj zzahjVar) {
        int i4;
        if (this.zzg == null) {
            this.zza.zze(j, i, i2, i3, zzahjVar);
            return;
        }
        zzgtj.zzb(zzahjVar == null, "DRM on subtitles is not supported");
        int i5 = (this.zze - i3) - i2;
        try {
            i4 = i5;
            try {
                this.zzg.zza(this.zzf, i4, i2, zzank.zza(), new zzdt() { // from class: com.google.android.gms.internal.ads.zzann
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final /* synthetic */ void zza(Object obj) {
                        this.zza.zzh(j, i, (zzand) obj);
                    }
                });
            } catch (RuntimeException e) {
                e = e;
                RuntimeException runtimeException = e;
                if (!this.zzi) {
                    throw runtimeException;
                }
                zzeg.zzd("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", runtimeException);
            }
        } catch (RuntimeException e2) {
            e = e2;
            i4 = i5;
        }
        int i6 = i4 + i2;
        this.zzd = i6;
        if (i6 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }

    public final void zzf(boolean z) {
        this.zzi = true;
    }

    public final /* synthetic */ void zzh(long j, int i, zzand zzandVar) {
        this.zzh.getClass();
        zzgwm zzgwmVar = zzandVar.zza;
        long j2 = zzandVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzgwmVar.size());
        Iterator<E> it = zzgwmVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzcx) it.next()).zzb());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j2);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzet zzetVar = this.zzc;
        int length = bArrMarshall.length;
        zzetVar.zzb(bArrMarshall, length);
        zzahk zzahkVar = this.zza;
        zzahkVar.zzc(zzetVar, length);
        long j3 = zzandVar.zzb;
        zzv zzvVar = this.zzh;
        if (j3 == -9223372036854775807L) {
            zzgtj.zzi(zzvVar.zzu == Long.MAX_VALUE);
        } else {
            long j4 = zzvVar.zzu;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        zzahkVar.zze(j, i | 1, length, 0, null);
    }
}
