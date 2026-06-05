package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.ads.AdError;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzlu implements Handler.Callback, zzxh, zzabg, zzmq, zzjh, zzmu, zzcc, zzadr {
    private static final long zza = zzfl.zzr(10000);
    private final boolean zzA;
    private zzni zzB;
    private boolean zzD;
    private boolean zzE;
    private zzlt zzF;
    private int zzG;
    private zzms zzH;
    private zzlr zzI;
    private boolean zzJ;
    private boolean zzL;
    private boolean zzM;
    private boolean zzO;
    private boolean zzR;
    private int zzS;
    private zzlt zzT;
    private long zzU;
    private long zzV;
    private int zzW;
    private boolean zzX;
    private zzjk zzY;
    private zzju zzaa;
    private boolean zzac;
    private final zzjd zzae;
    private final zzne[] zzb;
    private final zznc[] zzc;
    private final boolean[] zzd;
    private final zzabh zze;
    private final zzabi zzf;
    private final zzly zzg;
    private final zzabq zzh;
    private final zzdz zzi;
    private final zzmt zzj;
    private final Looper zzk;
    private final zzbe zzl;
    private final zzbd zzm;
    private final long zzn;
    private final zzji zzo;
    private final ArrayList zzp;
    private final zzdo zzq;
    private final zzls zzr;
    private final zzmf zzs;
    private final zzmr zzt;
    private final long zzu;
    private final zzqf zzv;
    private final zznm zzw;
    private final zzdz zzx;
    private final boolean zzy;
    private final zzcd zzz;
    private long zzab = -9223372036854775807L;
    private int zzP = 0;
    private boolean zzQ = false;
    private boolean zzK = false;
    private float zzad = 1.0f;
    private zznh zzC = zznh.zza;
    private long zzZ = -9223372036854775807L;
    private long zzN = -9223372036854775807L;

    public zzlu(Context context, zzna[] zznaVarArr, zzna[] zznaVarArr2, zzabh zzabhVar, zzabi zzabiVar, zzly zzlyVar, zzabq zzabqVar, int i, boolean z, zznm zznmVar, zzni zzniVar, zzjd zzjdVar, long j, boolean z2, boolean z3, Looper looper, zzdo zzdoVar, zzls zzlsVar, zzqf zzqfVar, zzmt zzmtVar, zzju zzjuVar, final zzadr zzadrVar, boolean z4) {
        this.zzr = zzlsVar;
        this.zze = zzabhVar;
        this.zzf = zzabiVar;
        this.zzg = zzlyVar;
        this.zzh = zzabqVar;
        this.zzB = zzniVar;
        this.zzae = zzjdVar;
        this.zzu = j;
        this.zzq = zzdoVar;
        this.zzv = zzqfVar;
        this.zzaa = zzjuVar;
        this.zzw = zznmVar;
        this.zzA = z4;
        this.zzn = zzlyVar.zzf(zzqfVar);
        zzlyVar.zzg(zzqfVar);
        zzbf zzbfVar = zzbf.zza;
        zzms zzmsVarZza = zzms.zza(zzabiVar);
        this.zzH = zzmsVarZza;
        this.zzI = new zzlr(zzmsVarZza);
        int length = zznaVarArr.length;
        this.zzc = new zznc[2];
        this.zzd = new boolean[2];
        zznb zznbVarZzg = zzabhVar.zzg();
        this.zzb = new zzne[2];
        boolean z5 = false;
        for (int i2 = 0; i2 < 2; i2++) {
            zznaVarArr[i2].zzc(i2, zzqfVar, zzdoVar);
            this.zzc[i2] = zznaVarArr[i2].zzb();
            this.zzc[i2].zzv(zznbVarZzg);
            zzna zznaVar = zznaVarArr2[i2];
            if (zznaVar != null) {
                zznaVar.zzc(i2, zzqfVar, zzdoVar);
                z5 = true;
            }
            this.zzb[i2] = new zzne(zznaVarArr[i2], zznaVarArr2[i2], i2);
        }
        this.zzy = z5;
        this.zzo = new zzji(this, zzdoVar);
        this.zzp = new ArrayList();
        this.zzl = new zzbe();
        this.zzm = new zzbd();
        zzabhVar.zzs(this, zzabqVar);
        this.zzX = true;
        zzdz zzdzVarZzd = zzdoVar.zzd(looper, null);
        this.zzx = zzdzVarZzd;
        this.zzs = new zzmf(zznmVar, zzdzVarZzd, new zzln(this), zzjuVar);
        this.zzt = new zzmr(this, zznmVar, zzdzVarZzd, zzqfVar);
        zzmt zzmtVar2 = new zzmt(null);
        this.zzj = zzmtVar2;
        Looper looperZza = zzmtVar2.zza();
        this.zzk = looperZza;
        zzdz zzdzVarZzd2 = zzdoVar.zzd(looperZza, this);
        this.zzi = zzdzVarZzd2;
        this.zzz = new zzcd(context, looperZza, this);
        zzdzVarZzd2.zzd(35, new zzadr() { // from class: com.google.android.gms.internal.ads.zzlj
            @Override // com.google.android.gms.internal.ads.zzadr
            public final /* synthetic */ void zzcS(long j2, long j3, zzv zzvVar, MediaFormat mediaFormat) {
                this.zza.zzcS(j2, j3, zzvVar, mediaFormat);
            }
        }).zza();
    }

    private final void zzA(IOException iOException, int i) {
        zzmf zzmfVar = this.zzs;
        zzjk zzjkVarZza = zzjk.zza(iOException, i);
        zzmc zzmcVarZzm = zzmfVar.zzm();
        if (zzmcVarZzm != null) {
            zzjkVarZza = zzjkVarZza.zzd(zzmcVarZzm.zzg.zza);
        }
        zzeg.zzf("ExoPlayerImplInternal", "Playback error", zzjkVarZza);
        zzW(false, false);
        this.zzH = this.zzH.zzf(zzjkVarZza);
    }

    private final void zzB(int i) {
        zzms zzmsVar = this.zzH;
        if (zzmsVar.zze != i) {
            if (i != 2) {
                this.zzZ = -9223372036854775807L;
            }
            this.zzH = zzmsVar.zze(i);
        }
    }

    private final void zzC() {
        this.zzI.zzb(this.zzH);
        if (this.zzI.zzd()) {
            this.zzr.zza(this.zzI);
            this.zzI = new zzlr(this.zzH);
        }
    }

    private final void zzD(float f) {
        this.zzad = f;
        float fZza = this.zzz.zza() * f;
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzneVarArr[i].zzL(fZza);
            i++;
        }
    }

    private final void zzE(boolean z, int i, boolean z2, int i2) {
        this.zzI.zza(z2 ? 1 : 0);
        zzG(z, i, i2);
    }

    private final void zzF() {
        zzms zzmsVar = this.zzH;
        zzG(zzmsVar.zzl, zzmsVar.zzn, zzmsVar.zzm);
    }

    private final void zzG(boolean z, int i, int i2) {
        zzH(z, this.zzz.zzc(z, this.zzH.zze), i, i2);
    }

    private final void zzH(boolean z, int i, int i2, int i3) {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            i = -1;
            z2 = false;
        }
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        boolean z3 = this.zzD;
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = z3 ? 4 : 0;
        }
        zzms zzmsVar = this.zzH;
        if (zzmsVar.zzl == z2 && zzmsVar.zzn == i2 && zzmsVar.zzm == i3) {
            return;
        }
        this.zzH = zzmsVar.zzi(z2, i3, i2);
        zzaD(false, false);
        zzmf zzmfVar = this.zzs;
        for (zzmc zzmcVarZzm = zzmfVar.zzm(); zzmcVarZzm != null; zzmcVarZzm = zzmcVarZzm.zzp()) {
            for (zzaba zzabaVar : zzmcVarZzm.zzr().zzc) {
            }
        }
        if (!zzay()) {
            zzK();
            zzL();
            boolean z4 = this.zzH.zzp;
            zzmfVar.zzf(this.zzU);
            return;
        }
        int i4 = this.zzH.zze;
        if (i4 == 3) {
            this.zzo.zza();
            zzJ();
            this.zzi.zzh(2);
        } else if (i4 == 2) {
            this.zzi.zzh(2);
        }
    }

    private final void zzI(boolean z) throws zzjk {
        zzxk zzxkVar = this.zzs.zzm().zzg.zza;
        long jZzT = zzT(zzxkVar, this.zzH.zzs, true, false);
        if (jZzT != this.zzH.zzs) {
            zzms zzmsVar = this.zzH;
            this.zzH = zzap(zzxkVar, jZzT, zzmsVar.zzc, zzmsVar.zzd, z, 5);
        }
    }

    private final void zzJ() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        if (zzmcVarZzm == null) {
            return;
        }
        zzabi zzabiVarZzr = zzmcVarZzm.zzr();
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzabiVarZzr.zza(i)) {
                zzneVarArr[i].zzv();
            }
            i++;
        }
    }

    private final void zzK() {
        this.zzo.zzb();
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzneVarArr[i].zzw();
            i++;
        }
    }

    private final void zzL() {
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzm = zzmfVar.zzm();
        if (zzmcVarZzm == null) {
            return;
        }
        long jZzh = zzmcVarZzm.zze ? zzmcVarZzm.zza.zzh() : -9223372036854775807L;
        if (jZzh != -9223372036854775807L) {
            if (!zzmcVarZzm.zzd()) {
                zzmfVar.zzs(zzmcVarZzm);
                zzat(false);
                zzan();
            }
            zzU(jZzh, true);
            if (jZzh != this.zzH.zzs) {
                zzms zzmsVar = this.zzH;
                long j = jZzh;
                this.zzH = zzap(zzmsVar.zzb, j, zzmsVar.zzc, j, true, 5);
            }
        } else {
            zzji zzjiVar = this.zzo;
            long jZzf = zzjiVar.zzf(zzmcVarZzm != zzmfVar.zzn());
            this.zzU = jZzf;
            long jZza = jZzf - zzmcVarZzm.zza();
            long j2 = this.zzH.zzs;
            ArrayList arrayList = this.zzp;
            if (!arrayList.isEmpty() && !this.zzH.zzb.zzb()) {
                if (this.zzX) {
                    this.zzX = false;
                }
                zzms zzmsVar2 = this.zzH;
                zzmsVar2.zza.zze(zzmsVar2.zzb.zza);
                int iMin = Math.min(this.zzW, arrayList.size());
                if (iMin > 0 && arrayList.get(iMin - 1) != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return;
                } else {
                    if (iMin < arrayList.size() && arrayList.get(iMin) != null) {
                        Events$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                    this.zzW = iMin;
                }
            }
            if (zzjiVar.zzh()) {
                boolean z = !this.zzI.zzc;
                zzms zzmsVar3 = this.zzH;
                this.zzH = zzap(zzmsVar3.zzb, jZza, zzmsVar3.zzc, jZza, z, 6);
            } else {
                zzms zzmsVar4 = this.zzH;
                zzmsVar4.zzs = jZza;
                zzmsVar4.zzt = SystemClock.elapsedRealtime();
            }
        }
        this.zzH.zzq = zzmfVar.zzk().zzf();
        this.zzH.zzr = zzau();
        zzms zzmsVar5 = this.zzH;
        if (zzmsVar5.zzl && zzmsVar5.zze == 3 && zzP(zzmsVar5.zza, zzmsVar5.zzb)) {
            zzms zzmsVar6 = this.zzH;
            if (zzmsVar6.zzo.zzb == 1.0f) {
                float fZzd = this.zzae.zzd(zzO(zzmsVar6.zza, zzmsVar6.zzb.zza, zzmsVar6.zzs), this.zzH.zzr);
                zzji zzjiVar2 = this.zzo;
                if (zzjiVar2.zzj().zzb != fZzd) {
                    zzM(new zzav(fZzd, this.zzH.zzo.zzc));
                    zzam(this.zzH.zzo, zzjiVar2.zzj().zzb, false, false);
                }
            }
        }
    }

    private final void zzM(zzav zzavVar) {
        this.zzi.zzk(16);
        this.zzo.zzi(zzavVar);
    }

    private final void zzN(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(i, z);
                }
            });
        }
    }

    private final long zzO(zzbf zzbfVar, Object obj, long j) {
        int i = zzbfVar.zzo(obj, this.zzm).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        if (zzbeVar.zzf == -9223372036854775807L || !zzbeVar.zzb() || !zzbeVar.zzi) {
            return -9223372036854775807L;
        }
        long j2 = zzbeVar.zzg;
        String str = zzfl.zza;
        return zzfl.zzs((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbeVar.zzf) - j;
    }

    private final boolean zzP(zzbf zzbfVar, zzxk zzxkVar) {
        if (!zzxkVar.zzb() && !zzbfVar.zzg()) {
            int i = zzbfVar.zzo(zzxkVar.zza, this.zzm).zzc;
            zzbe zzbeVar = this.zzl;
            zzbfVar.zzb(i, zzbeVar, 0L);
            if (zzbeVar.zzb() && zzbeVar.zzi && zzbeVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private final void zzQ(long j) {
        boolean zZzw = zzw();
        zzms zzmsVar = this.zzH;
        if (zZzw) {
            jMin = zzmsVar.zze != 3 ? zza : 1000L;
            zzne[] zzneVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                jMin = Math.min(jMin, zzfl.zzr(zzneVarArr[i].zzk(this.zzU, this.zzV)));
            }
            if (this.zzH.zzj()) {
                zzmf zzmfVar = this.zzs;
                if ((zzmfVar.zzm() != null ? zzmfVar.zzm().zzp() : null) != null) {
                    if (this.zzU + (zzfl.zzs(jMin) * this.zzH.zzo.zzb) >= r0.zzc()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (zzmsVar.zze != 3 || zzay()) {
            jMin = zza;
        }
        this.zzi.zzj(2, j + jMin);
    }

    private final void zzR(zzlt zzltVar) throws Throwable {
        long jLongValue;
        long j;
        zzxk zzxkVarZzy;
        boolean z;
        boolean z2;
        long j2;
        long jZzk;
        boolean z3;
        zzms zzmsVar;
        zzxk zzxkVar;
        zzbf zzbfVar;
        long j3;
        long j4;
        long j5;
        zzms zzmsVar2;
        int i;
        if (this.zzE) {
            if (this.zzF != null) {
                this.zzG++;
                this.zzI.zza(1);
            }
            this.zzF = zzltVar;
            return;
        }
        this.zzI.zza(1);
        zzbf zzbfVar2 = this.zzH.zza;
        int i2 = this.zzP;
        boolean z4 = this.zzQ;
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzaE = zzaE(zzbfVar2, zzltVar, true, i2, z4, zzbeVar, zzbdVar);
        long jMax = -9223372036854775807L;
        if (pairZzaE == null) {
            Pair pairZzY = zzY(this.zzH.zza);
            zzxk zzxkVar2 = (zzxk) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            z = !this.zzH.zza.zzg();
            zzxkVarZzy = zzxkVar2;
            j = -9223372036854775807L;
        } else {
            Object obj = pairZzaE.first;
            jLongValue = ((Long) pairZzaE.second).longValue();
            long j6 = zzltVar.zzc;
            if (j6 == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                j = -9223372036854775807L;
                jMax = jLongValue;
            }
            zzxkVarZzy = this.zzs.zzy(this.zzH.zza, obj, jLongValue);
            if (zzxkVarZzy.zzb()) {
                this.zzH.zza.zzo(zzxkVarZzy.zza, zzbdVar);
                int i3 = zzxkVarZzy.zzb;
                if (zzbdVar.zzd(i3) == zzxkVarZzy.zzc) {
                    zzbdVar.zzj();
                }
                long j7 = zzbdVar.zzg.zza(i3).zza;
                jMax = Math.max(jMax, 0L);
                jLongValue = 0;
            } else if (j6 != -9223372036854775807L) {
                z = false;
            }
            z = true;
        }
        try {
            if (this.zzH.zza.zzg()) {
                this.zzT = zzltVar;
            } else {
                zzms zzmsVar3 = this.zzH;
                if (pairZzaE != null) {
                    if (zzxkVarZzy.equals(zzmsVar3.zzb)) {
                        zzmc zzmcVarZzm = this.zzs.zzm();
                        if (zzmcVarZzm == null || !zzmcVarZzm.zze || jLongValue == 0) {
                            jZzk = jLongValue;
                        } else {
                            zzxi zzxiVar = zzmcVarZzm.zza;
                            long j8 = zzbeVar.zzm;
                            if (this.zzD && j8 != j) {
                                Double d = this.zzC.zzc;
                            }
                            jZzk = zzxiVar.zzk(jLongValue, this.zzB);
                        }
                        if (zzfl.zzr(jZzk) == zzfl.zzr(this.zzH.zzs) && ((i = (zzmsVar2 = this.zzH).zze) == 2 || i == 3)) {
                            jLongValue = zzmsVar2.zzs;
                        }
                    } else {
                        jZzk = jLongValue;
                    }
                    if (this.zzD) {
                        zzne[] zzneVarArr = this.zzb;
                        for (int i4 = 0; i4 < 2; i4++) {
                            zzne zzneVar = zzneVarArr[i4];
                            if (zzneVar.zzM() && zzneVar.zze() == 2) {
                                z3 = true;
                                this.zzE = true;
                                break;
                            }
                        }
                    }
                    z3 = true;
                    long jZzS = zzS(zzxkVarZzy, jZzk, this.zzH.zze == 4 ? z3 : false);
                    z2 = (jLongValue != jZzS ? z3 : false) | z;
                    try {
                        zzmsVar = this.zzH;
                        zzxkVar = zzxkVarZzy;
                        try {
                            zzbfVar = zzmsVar.zza;
                            j3 = jMax;
                        } catch (Throwable th) {
                            th = th;
                            zzxkVarZzy = zzxkVar;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        zzag(zzbfVar, zzxkVar, zzbfVar, zzmsVar.zzb, j3, true);
                        zzxkVarZzy = zzxkVar;
                        j4 = j3;
                        j5 = jZzS;
                        this.zzH = zzap(zzxkVarZzy, j5, j4, j5, z2, 2);
                    } catch (Throwable th3) {
                        th = th3;
                        zzxkVarZzy = zzxkVar;
                        jMax = j3;
                        j2 = jZzS;
                        this.zzH = zzap(zzxkVarZzy, j2, jMax, j2, z2, 2);
                        throw th;
                    }
                }
                if (zzmsVar3.zze != 1) {
                    zzB(4);
                }
                zzX(false, true, false, true);
            }
            z2 = z;
            j4 = jMax;
            j5 = jLongValue;
            this.zzH = zzap(zzxkVarZzy, j5, j4, j5, z2, 2);
        } catch (Throwable th4) {
            th = th4;
            z2 = z;
            j2 = jLongValue;
        }
    }

    private final long zzS(zzxk zzxkVar, long j, boolean z) {
        zzmf zzmfVar = this.zzs;
        return zzT(zzxkVar, j, zzmfVar.zzm() != zzmfVar.zzn(), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long zzT(zzxk zzxkVar, long j, boolean z, boolean z2) throws zzjk {
        zzK();
        boolean z3 = true;
        zzaD(false, true);
        if (z2 || this.zzH.zze == 3) {
            zzB(2);
        }
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzm = zzmfVar.zzm();
        zzmc zzmcVarZzp = zzmcVarZzm;
        while (zzmcVarZzp != null && !zzxkVar.equals(zzmcVarZzp.zzg.zza)) {
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        if (z || zzmcVarZzm != zzmcVarZzp || (zzmcVarZzp != null && zzmcVarZzp.zza() + j < 0)) {
            zzaa();
            if (zzmcVarZzp != null) {
                while (zzmfVar.zzm() != zzmcVarZzp) {
                    zzmfVar.zzr();
                }
                zzmfVar.zzs(zzmcVarZzp);
                zzmcVarZzp.zzb(1000000000000L);
                zzaq();
                zzmcVarZzp.zzh = true;
            }
        }
        zzab();
        if (zzmcVarZzp != null) {
            zzmfVar.zzs(zzmcVarZzp);
            if (!zzmcVarZzp.zze) {
                zzmcVarZzp.zzg = zzmcVarZzp.zzg.zza(j, -9223372036854775807L);
            } else if (zzmcVarZzp.zzf) {
                if (this.zzD) {
                    boolean z4 = this.zzC.zzi;
                    if (this.zzH.zza.zzg() || !zzmcVarZzp.zzg.zza.equals(this.zzH.zzb)) {
                        zzxi zzxiVar = zzmcVarZzp.zza;
                        j = zzxiVar.zzj(j);
                        zzxiVar.zzf(j - this.zzn, false);
                    } else {
                        long jZza = zzmcVarZzp.zza() + j;
                        zzne[] zzneVarArr = this.zzb;
                        boolean zZzF = true;
                        for (int i = 0; i < 2; i++) {
                            zzne zzneVar = zzneVarArr[i];
                            if (zzneVar.zzM()) {
                                zZzF &= zzneVar.zzF(zzmcVarZzp, jZza);
                            }
                        }
                        if (zZzF) {
                            zzxi zzxiVar2 = zzmcVarZzp.zza;
                            long j2 = this.zzH.zzs;
                            zzni zzniVar = zzni.zzb;
                            if (zzxiVar2.zzk(j2, zzniVar) == zzxiVar2.zzk(j, zzniVar)) {
                                z3 = false;
                            }
                        }
                    }
                }
            }
            zzU(j, z3);
            zzan();
        } else {
            zzmfVar.zzv();
            zzU(j, true);
        }
        zzat(false);
        this.zzi.zzh(2);
        return j;
    }

    private final void zzU(long j, boolean z) {
        zzmc zzmcVarZzm = this.zzs.zzm();
        long jZza = j + (zzmcVarZzm == null ? 1000000000000L : zzmcVarZzm.zza());
        this.zzU = jZza;
        this.zzo.zzc(jZza);
        zzne[] zzneVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzneVarArr[i].zzE(zzmcVarZzm, this.zzU, z);
        }
        for (zzmc zzmcVarZzm2 = r0.zzm(); zzmcVarZzm2 != null; zzmcVarZzm2 = zzmcVarZzm2.zzp()) {
            for (zzaba zzabaVar : zzmcVarZzm2.zzr().zzc) {
            }
        }
    }

    private final void zzV() {
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzneVarArr[i].zzz(this.zzD ? this.zzC : null);
            i++;
        }
    }

    private final void zzW(boolean z, boolean z2) {
        zzX(z || !this.zzR, false, true, false);
        this.zzI.zza(z2 ? 1 : 0);
        this.zzg.zzc(this.zzv);
        this.zzz.zzc(this.zzH.zzl, 1);
        zzB(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[PHI: r2 r7 r9
      0x009d: PHI (r2v2 com.google.android.gms.internal.ads.zzxk) = (r2v1 com.google.android.gms.internal.ads.zzxk), (r2v11 com.google.android.gms.internal.ads.zzxk) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x009d: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x009d: PHI (r9v2 long) = (r9v1 long), (r9v7 long) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v3 com.google.android.gms.internal.ads.zzbf) = 
      (r3v2 com.google.android.gms.internal.ads.zzbf)
      (r3v2 com.google.android.gms.internal.ads.zzbf)
      (r3v12 com.google.android.gms.internal.ads.zzbf)
      (r3v12 com.google.android.gms.internal.ads.zzbf)
     binds: [B:34:0x00aa, B:36:0x00ae, B:38:0x00bf, B:40:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzX(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        zzxk zzxkVar;
        zzbf zzbfVar;
        this.zzi.zzk(2);
        this.zzE = false;
        if (this.zzF != null) {
            this.zzI.zza(1);
            this.zzF = null;
        }
        this.zzY = null;
        zzaD(false, true);
        this.zzo.zzb();
        this.zzU = 1000000000000L;
        try {
            zzaa();
        } catch (zzjk | RuntimeException e) {
            zzeg.zzf("ExoPlayerImplInternal", "Disable failed.", e);
        }
        if (z) {
            zzne[] zzneVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                try {
                    zzneVarArr[i].zzG();
                } catch (RuntimeException e2) {
                    zzeg.zzf("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.zzS = 0;
        zzms zzmsVar = this.zzH;
        zzxk zzxkVar2 = zzmsVar.zzb;
        long jLongValue = zzmsVar.zzs;
        long j = (this.zzH.zzb.zzb() || zzaC(this.zzH, this.zzm)) ? this.zzH.zzc : this.zzH.zzs;
        if (z2) {
            this.zzT = null;
            Pair pairZzY = zzY(this.zzH.zza);
            zzxkVar2 = (zzxk) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            j = -9223372036854775807L;
            z5 = zzxkVar2.equals(this.zzH.zzb) ? false : true;
        }
        long j2 = jLongValue;
        long j3 = j;
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzv();
        this.zzO = false;
        zzbf zzbfVarZzx = this.zzH.zza;
        if (z3 && (zzbfVarZzx instanceof zzmy)) {
            zzbfVarZzx = ((zzmy) zzbfVarZzx).zzx(this.zzt.zzq());
            if (zzxkVar2.zzb != -1) {
                Object obj = zzxkVar2.zza;
                zzbd zzbdVar = this.zzm;
                zzbfVarZzx.zzo(obj, zzbdVar);
                zzbe zzbeVar = this.zzl;
                zzbfVarZzx.zzb(zzbdVar.zzc, zzbeVar, 0L);
                if (zzbeVar.zzb()) {
                    zzbfVar = zzbfVarZzx;
                    zzxkVar = new zzxk(obj, zzxkVar2.zzd);
                }
            }
        } else {
            zzxkVar = zzxkVar2;
            zzbfVar = zzbfVarZzx;
        }
        zzms zzmsVar2 = this.zzH;
        int i2 = zzmsVar2.zze;
        zzjk zzjkVar = z4 ? null : zzmsVar2.zzf;
        zzzn zzznVar = z5 ? zzzn.zza : zzmsVar2.zzh;
        zzabi zzabiVar = z5 ? this.zzf : zzmsVar2.zzi;
        List listZzi = z5 ? zzgwm.zzi() : zzmsVar2.zzj;
        zzms zzmsVar3 = this.zzH;
        this.zzH = new zzms(zzbfVar, zzxkVar, j3, j2, i2, zzjkVar, false, zzznVar, zzabiVar, listZzi, zzxkVar, zzmsVar3.zzl, zzmsVar3.zzm, zzmsVar3.zzn, zzmsVar3.zzo, j2, 0L, j2, 0L, false);
        if (z3) {
            zzmfVar.zzj();
            this.zzt.zzg();
        }
    }

    private final Pair zzY(zzbf zzbfVar) {
        long j = 0;
        if (zzbfVar.zzg()) {
            return Pair.create(zzms.zzb(), 0L);
        }
        int iZzk = zzbfVar.zzk(this.zzQ);
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, iZzk, -9223372036854775807L);
        zzxk zzxkVarZzy = this.zzs.zzy(zzbfVar, pairZzm.first, 0L);
        long jLongValue = ((Long) pairZzm.second).longValue();
        if (zzxkVarZzy.zzb()) {
            zzbfVar.zzo(zzxkVarZzy.zza, zzbdVar);
            if (zzxkVarZzy.zzc == zzbdVar.zzd(zzxkVarZzy.zzb)) {
                zzbdVar.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzxkVarZzy, Long.valueOf(j));
    }

    private final void zzZ(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.zzg() && zzbfVar2.zzg()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            arrayList.get(size).getClass();
            Events$$ExternalSyntheticBUOutline0.m();
        }
    }

    private final boolean zzaA() {
        if (!this.zzy) {
            return false;
        }
        zzne[] zzneVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzneVarArr[i].zzc()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public final boolean zzw() {
        if (!this.zzD) {
            return false;
        }
        boolean z = this.zzC.zzg;
        return true;
    }

    private static boolean zzaC(zzms zzmsVar, zzbd zzbdVar) {
        zzxk zzxkVar = zzmsVar.zzb;
        zzbf zzbfVar = zzmsVar.zza;
        return zzbfVar.zzg() || zzbfVar.zzo(zzxkVar.zza, zzbdVar).zzf;
    }

    private final void zzaD(boolean z, boolean z2) {
        this.zzM = z;
        long jElapsedRealtime = -9223372036854775807L;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzN = jElapsedRealtime;
    }

    private static Pair zzaE(zzbf zzbfVar, zzlt zzltVar, boolean z, int i, boolean z2, zzbe zzbeVar, zzbd zzbdVar) {
        Pair pairZzm;
        zzbf zzbfVar2;
        zzbf zzbfVar3 = zzltVar.zza;
        if (zzbfVar.zzg()) {
            return null;
        }
        boolean zZzg = zzbfVar3.zzg();
        zzbf zzbfVar4 = zzbfVar3;
        if (true == zZzg) {
            zzbfVar4 = zzbfVar;
        }
        try {
            pairZzm = zzbfVar4.zzm(zzbeVar, zzbdVar, zzltVar.zzb, zzltVar.zzc);
            zzbfVar2 = zzbfVar4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzbfVar.equals(zzbfVar2)) {
            return pairZzm;
        }
        int iZze = zzbfVar.zze(pairZzm.first);
        Object obj = pairZzm.first;
        if (iZze != -1) {
            return (zzbfVar2.zzo(obj, zzbdVar).zzf && zzbfVar2.zzb(zzbdVar.zzc, zzbeVar, 0L).zzn == zzbfVar2.zze(pairZzm.first)) ? zzbfVar.zzm(zzbeVar, zzbdVar, zzbfVar.zzo(pairZzm.first, zzbdVar).zzc, zzltVar.zzc) : pairZzm;
        }
        int iZzr = zzr(zzbeVar, zzbdVar, i, z2, obj, zzbfVar2, zzbfVar);
        if (iZzr != -1) {
            return zzbfVar.zzm(zzbeVar, zzbdVar, iZzr, -9223372036854775807L);
        }
        return null;
    }

    private static final void zzaF(zzmw zzmwVar) {
        zzmwVar.zzh();
        try {
            zzmwVar.zza().zzx(zzmwVar.zzc(), zzmwVar.zze());
        } finally {
            zzmwVar.zzi(true);
        }
    }

    private static final boolean zzaG(zzmc zzmcVar) {
        if (zzmcVar != null) {
            try {
                if (zzmcVar.zze) {
                    zzzc[] zzzcVarArr = zzmcVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzzc zzzcVar = zzzcVarArr[i];
                        if (zzzcVar != null) {
                            zzzcVar.zzc();
                        }
                    }
                } else {
                    zzmcVar.zza.zzc();
                }
                if (zzmcVar.zzg() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private final void zzaa() {
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                this.zzab = -9223372036854775807L;
                return;
            }
            int iZzd = zzneVarArr[i].zzd();
            zzneVarArr[i].zzA(this.zzo);
            zzN(i, false);
            this.zzS -= iZzd;
            i++;
        }
    }

    private final void zzab() {
        if (this.zzy && zzaA()) {
            zzne[] zzneVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzne zzneVar = zzneVarArr[i];
                int iZzd = zzneVar.zzd();
                zzneVar.zzC(this.zzo);
                this.zzS -= iZzd - zzneVar.zzd();
            }
            this.zzab = -9223372036854775807L;
        }
    }

    private final void zzac() throws zzjk {
        zzad();
        zzI(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.android.gms.internal.ads.zzlu] */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.google.android.gms.internal.ads.zzlu] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [int] */
    private final void zzad() throws zzjk {
        int i;
        ?? r6;
        boolean z;
        zzji zzjiVar = this.zzo;
        float f = zzjiVar.zzj().zzb;
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzm = zzmfVar.zzm();
        zzmc zzmcVarZzn = zzmfVar.zzn();
        zzabi zzabiVar = null;
        boolean z2 = true;
        while (zzmcVarZzm != null && zzmcVarZzm.zze) {
            zzms zzmsVar = this.zzH;
            zzabi zzabiVarZzk = zzmcVarZzm.zzk(f, zzmsVar.zza, zzmsVar.zzl);
            zzabi zzabiVar2 = zzmcVarZzm == zzmfVar.zzm() ? zzabiVarZzk : zzabiVar;
            zzabi zzabiVarZzr = zzmcVarZzm.zzr();
            boolean z3 = false;
            if (zzabiVarZzr != null) {
                zzaba[] zzabaVarArr = zzabiVarZzk.zzc;
                if (zzabiVarZzr.zzc.length == zzabaVarArr.length) {
                    for (int i2 = 0; i2 < zzabaVarArr.length; i2++) {
                        if (zzabiVarZzk.zzb(zzabiVarZzr, i2)) {
                        }
                    }
                    if (zzmcVarZzm != zzmcVarZzn) {
                        z3 = true;
                    }
                    z2 &= z3;
                    zzmcVarZzm = zzmcVarZzm.zzp();
                    zzabiVar = zzabiVar2;
                }
            }
            if (z2) {
                zzmc zzmcVarZzm2 = zzmfVar.zzm();
                int iZzs = zzmfVar.zzs(zzmcVarZzm2) & 1;
                zzne[] zzneVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzabiVar2.getClass();
                long jZzm = zzmcVarZzm2.zzm(zzabiVar2, this.zzH.zzs, 1 == iZzs, zArr);
                zzms zzmsVar2 = this.zzH;
                if (zzmsVar2.zze == 4 || jZzm == zzmsVar2.zzs) {
                    z = false;
                } else {
                    z = false;
                    z3 = true;
                }
                zzms zzmsVar3 = this.zzH;
                boolean z4 = z;
                i = 2;
                ?? r62 = this;
                r62.zzH = zzap(zzmsVar3.zzb, jZzm, zzmsVar3.zzc, zzmsVar3.zzd, z3, 5);
                if (z3) {
                    r62.zzU(jZzm, true);
                }
                r62.zzab();
                boolean[] zArr2 = new boolean[2];
                for (?? r8 = z4; r8 < 2; r8++) {
                    int iZzd = zzneVarArr[r8].zzd();
                    zArr2[r8] = zzneVarArr[r8].zzM();
                    zzneVarArr[r8].zzD(zzmcVarZzm2.zzc[r8], zzjiVar, r62.zzU, zArr[r8]);
                    if (iZzd - zzneVarArr[r8].zzd() > 0) {
                        r62.zzN(r8, z4);
                    }
                    r62.zzS -= iZzd - zzneVarArr[r8].zzd();
                }
                r62.zzar(zArr2, r62.zzU);
                zzmcVarZzm2.zzh = true;
                r6 = r62;
            } else {
                zzlu zzluVar = this;
                i = 2;
                zzmfVar.zzs(zzmcVarZzm);
                r6 = zzluVar;
                if (zzmcVarZzm.zze) {
                    long jMax = Math.max(zzmcVarZzm.zzg.zzb, zzluVar.zzU - zzmcVarZzm.zza());
                    if (zzluVar.zzy && zzluVar.zzaA() && zzmfVar.zzo() == zzmcVarZzm) {
                        zzluVar.zzab();
                    }
                    zzmcVarZzm.zzl(zzabiVarZzk, jMax, false);
                    r6 = zzluVar;
                }
            }
            r6.zzat(true);
            if (r6.zzH.zze != 4) {
                r6.zzan();
                r6.zzL();
                r6.zzi.zzh(i);
                return;
            }
            return;
        }
    }

    private final boolean zzae() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        long j = zzmcVarZzm.zzg.zzf;
        if (zzmcVarZzm.zze) {
            return j == -9223372036854775807L || this.zzH.zzs < j || !zzay();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020e  */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.google.android.gms.internal.ads.zzlt] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [com.google.android.gms.internal.ads.zzlt] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r35v0, types: [com.google.android.gms.internal.ads.zzlu] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzaf(zzbf zzbfVar, boolean z) throws Throwable {
        Object obj;
        long j;
        zzxk zzxkVar;
        int i;
        Object obj2;
        long j2;
        zzbd zzbdVar;
        zzbf zzbfVar2;
        long j3;
        long j4;
        int i2;
        Object obj3;
        boolean z2;
        long jMax;
        boolean z3;
        boolean z4;
        int iZzk;
        boolean z5;
        long j5;
        zzbf zzbfVar3;
        zzbd zzbdVar2;
        long jMin;
        long j6;
        boolean z6;
        ?? r16;
        boolean z7;
        int i3;
        Object obj4;
        boolean z8;
        zzxk zzxkVar2;
        int i4;
        ?? r12;
        boolean z9;
        int i5;
        long jLongValue;
        Object obj5;
        int i6;
        boolean z10;
        int iZzk2;
        Object obj6;
        boolean z11;
        boolean z12;
        ?? r162;
        ?? r122;
        zzbf zzbfVar4;
        boolean z13;
        zzxk zzxkVar3;
        Throwable th;
        zzxk zzxkVar4;
        long j7;
        long j8;
        ?? r163;
        ?? r164;
        ?? r123;
        long j9;
        long j10;
        zzms zzmsVar = this.zzH;
        zzlt zzltVar = this.zzT;
        zzbd zzbdVar3 = this.zzm;
        int i7 = this.zzP;
        boolean z14 = this.zzQ;
        long jZzS = 0;
        if (zzbfVar.zzg()) {
            zzxk zzxkVarZzb = zzms.zzb();
            zzxk zzxkVar5 = zzmsVar.zzb;
            boolean z15 = (zzxkVarZzb.equals(zzxkVar5) && zzmsVar.zzs == 0) ? false : true;
            if (z15 && z) {
                zzbf zzbfVar5 = zzmsVar.zza;
                if (!zzbfVar5.zzg() && !zzbfVar5.zzo(zzxkVar5.zza, zzbdVar3).zzf) {
                    z8 = true;
                }
                zzxkVar2 = zzxkVarZzb;
                r12 = z15;
                i4 = 4;
                j6 = 0;
                z9 = false;
                z3 = true;
                z4 = false;
                j2 = -9223372036854775807L;
                j4 = -9223372036854775807L;
                zzbfVar3 = zzbfVar;
            } else {
                z8 = false;
                zzxkVar2 = zzxkVarZzb;
                r12 = z15;
                i4 = 4;
                j6 = 0;
                z9 = false;
                z3 = true;
                z4 = false;
                j2 = -9223372036854775807L;
                j4 = -9223372036854775807L;
                zzbfVar3 = zzbfVar;
            }
        } else {
            zzxk zzxkVar6 = zzmsVar.zzb;
            Object obj7 = zzxkVar6.zza;
            boolean zZzaC = zzaC(zzmsVar, zzbdVar3);
            if (zzxkVar6.zzb() || zZzaC) {
                obj = obj7;
                j = zzmsVar.zzc;
            } else {
                obj = obj7;
                j = zzmsVar.zzs;
            }
            long j11 = j;
            zzbe zzbeVar = this.zzl;
            if (zzltVar != null) {
                zzxkVar = zzxkVar6;
                obj2 = obj;
                i = -1;
                j2 = -9223372036854775807L;
                Pair pairZzaE = zzaE(zzbfVar, zzltVar, true, i7, z14, zzbeVar, zzbdVar3);
                if (pairZzaE == null) {
                    iZzk2 = zzbfVar.zzk(z14);
                    obj6 = obj2;
                    jLongValue = j11;
                    z12 = true;
                    z11 = false;
                    z2 = false;
                } else {
                    long j12 = zzltVar.zzc;
                    Object obj8 = pairZzaE.first;
                    if (j12 == -9223372036854775807L) {
                        i6 = zzbfVar.zzo(obj8, zzbdVar3).zzc;
                        obj5 = obj2;
                        jLongValue = j11;
                        z10 = false;
                    } else {
                        jLongValue = ((Long) pairZzaE.second).longValue();
                        obj5 = obj8;
                        i6 = -1;
                        z10 = true;
                    }
                    z2 = zzmsVar.zze == 4;
                    iZzk2 = i6;
                    obj6 = obj5;
                    z11 = z10;
                    z12 = false;
                }
                zzbfVar2 = zzbfVar;
                z3 = z12;
                i2 = iZzk2;
                j4 = jLongValue;
                zzbdVar = zzbdVar3;
                j3 = j11;
                z4 = z11;
                obj3 = obj6;
            } else {
                zzxkVar = zzxkVar6;
                i = -1;
                obj2 = obj;
                j2 = -9223372036854775807L;
                zzbf zzbfVar6 = zzmsVar.zza;
                if (zzbfVar6.zzg()) {
                    iZzk = zzbfVar.zzk(z14);
                } else if (zzbfVar.zze(obj2) == -1) {
                    int iZzr = zzr(zzbeVar, zzbdVar3, i7, z14, obj2, zzbfVar6, zzbfVar);
                    obj2 = obj2;
                    if (iZzr == -1) {
                        iZzr = zzbfVar.zzk(z14);
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    i2 = iZzr;
                    zzbdVar = zzbdVar3;
                    obj3 = obj2;
                    j4 = j11;
                    z2 = false;
                    zzbfVar2 = zzbfVar;
                    z3 = z5;
                    z4 = false;
                    zzbeVar = zzbeVar;
                    j3 = j4;
                } else if (j11 == -9223372036854775807L) {
                    iZzk = zzbfVar.zzo(obj2, zzbdVar3).zzc;
                } else if (zZzaC) {
                    zzbfVar6.zzo(obj2, zzbdVar3);
                    if (zzbfVar6.zzb(zzbdVar3.zzc, zzbeVar, 0L).zzn == zzbfVar6.zze(obj2)) {
                        int i8 = zzbfVar.zzo(obj2, zzbdVar3).zzc;
                        zzbdVar = zzbdVar3;
                        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, i8, j11);
                        zzbfVar2 = zzbfVar;
                        zzbeVar = zzbeVar;
                        j3 = j11;
                        obj3 = pairZzm.first;
                        jMax = ((Long) pairZzm.second).longValue();
                    } else {
                        zzbeVar = zzbeVar;
                        zzbdVar = zzbdVar3;
                        zzbfVar2 = zzbfVar;
                        j3 = j11;
                        if (zzbfVar2.zzo(obj2, zzbdVar).zzd != -9223372036854775807L) {
                            long j13 = zzbdVar.zzd - 1;
                            String str = zzfl.zza;
                            jMax = Math.max(0L, Math.min(j3, j13));
                        } else {
                            jMax = j3;
                        }
                        obj3 = obj2;
                    }
                    i2 = -1;
                    j4 = jMax;
                    z2 = false;
                    z3 = false;
                    z4 = true;
                } else {
                    zzbeVar = zzbeVar;
                    zzbdVar = zzbdVar3;
                    zzbfVar2 = zzbfVar;
                    j3 = j11;
                    j4 = j3;
                    i2 = -1;
                    obj3 = obj2;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
                zzbeVar = zzbeVar;
                i2 = iZzk;
                zzbdVar = zzbdVar3;
                obj3 = obj2;
                j4 = j11;
                z2 = false;
                zzbfVar2 = zzbfVar;
                j3 = j4;
                z3 = false;
                z4 = false;
            }
            if (i2 != i) {
                j5 = j3;
                zzbfVar3 = zzbfVar2;
                Pair pairZzm2 = zzbfVar3.zzm(zzbeVar, zzbdVar, i2, -9223372036854775807L);
                zzbdVar2 = zzbdVar;
                obj3 = pairZzm2.first;
                jMin = ((Long) pairZzm2.second).longValue();
                j4 = j2;
            } else {
                j5 = j3;
                zzbfVar3 = zzbfVar2;
                zzbdVar2 = zzbdVar;
                jMin = j4;
            }
            zzxk zzxkVarZzy = this.zzs.zzy(zzbfVar3, obj3, jMin);
            int i9 = zzxkVarZzy.zze;
            if (i9 != i) {
                j6 = 0;
                int i10 = zzxkVar.zze;
                boolean z16 = i10 != i && i9 >= i10;
                boolean zEquals = obj2.equals(obj3);
                z6 = (zEquals || zzxkVar.zzb() || zzxkVarZzy.zzb() || !z16) ? false : true;
                zzbd zzbdVarZzo = zzbfVar3.zzo(obj3, zzbdVar2);
                r16 = zZzaC;
                if (!zZzaC) {
                    int i11 = (j5 > j4 ? 1 : (j5 == j4 ? 0 : -1));
                    r16 = i11;
                    if (i11 == 0) {
                        r16 = i11;
                        if (obj2.equals(zzxkVarZzy.zza)) {
                            if (zzxkVar.zzb()) {
                                zzbdVarZzo.zzk(zzxkVar.zzb);
                            }
                            r16 = i11;
                            if (zzxkVarZzy.zzb()) {
                                zzbdVarZzo.zzk(zzxkVarZzy.zzb);
                                r16 = i11;
                            }
                        }
                    }
                }
                if (true == z6) {
                    zzxkVarZzy = zzxkVar;
                }
                if (zzxkVarZzy.zzb()) {
                    if (zEquals && zzxkVar.zzb()) {
                        zza zzaVarZza = zzbfVar3.zzo(obj3, zzbdVar2).zzg.zza(zzxkVar.zzb);
                        long j14 = zzaVarZza.zzi;
                        long j15 = zzmsVar.zzc;
                        if (j15 == j2 || j15 < j6) {
                            int i12 = zzaVarZza.zzb;
                            int i13 = zzxkVar.zzc;
                            if (i12 > i13 && zzaVarZza.zze[i13] == 2) {
                                long j16 = zzbfVar3.zzo(obj3, zzbdVar2).zzd;
                                if (j16 != j2) {
                                    jMin = Math.min(j16 - 1, jMin);
                                }
                                j4 = jMin;
                            }
                        }
                    }
                } else if (zzxkVarZzy.equals(zzxkVar)) {
                    jMin = zzmsVar.zzs;
                } else {
                    zzbfVar3.zzo(zzxkVarZzy.zza, zzbdVar2);
                    if (zzxkVarZzy.zzc == zzbdVar2.zzd(zzxkVarZzy.zzb)) {
                        zzbdVar2.zzj();
                    }
                    jMin = j6;
                }
                z7 = zzxkVarZzy.equals(zzxkVar) || jMin != zzmsVar.zzs;
                i3 = zzbfVar3.zze(obj2) != i ? 4 : 3;
                obj4 = zzxkVarZzy.zza;
                if (obj4.equals(obj2) && (i5 = zzxkVarZzy.zzb) != i && zzbfVar3.zzo(obj4, zzbdVar2).zzg.zza(i5).zze[zzxkVarZzy.zzc] != 2) {
                    i3 = 0;
                }
                if (z7 || !z) {
                    z8 = false;
                    jZzS = jMin;
                    zzxkVar2 = zzxkVarZzy;
                    i4 = i3;
                    r12 = z7;
                    z9 = z2;
                } else {
                    zzbf zzbfVar7 = zzmsVar.zza;
                    if (!zzbfVar7.zzg() && !zzbfVar7.zzo(obj2, zzbdVar2).zzf) {
                        z8 = true;
                    }
                    jZzS = jMin;
                    zzxkVar2 = zzxkVarZzy;
                    i4 = i3;
                    r12 = z7;
                    z9 = z2;
                }
            } else {
                j6 = 0;
            }
            boolean zEquals2 = obj2.equals(obj3);
            if (zEquals2) {
                zzbd zzbdVarZzo2 = zzbfVar3.zzo(obj3, zzbdVar2);
                r16 = zZzaC;
                if (!zZzaC) {
                }
                if (true == z6) {
                }
                if (zzxkVarZzy.zzb()) {
                }
                if (zzxkVarZzy.equals(zzxkVar)) {
                    if (zzbfVar3.zze(obj2) != i) {
                    }
                    obj4 = zzxkVarZzy.zza;
                    if (obj4.equals(obj2)) {
                        i3 = 0;
                    }
                    if (z7) {
                        z8 = false;
                        jZzS = jMin;
                        zzxkVar2 = zzxkVarZzy;
                        i4 = i3;
                        r12 = z7;
                        z9 = z2;
                    }
                }
            }
        }
        boolean z17 = z8;
        if (z3) {
            try {
                if (this.zzH.zze != 1) {
                    zzB(4);
                }
                zzX(false, false, false, true);
            } catch (Throwable th2) {
                th = th2;
                zzxk zzxkVar7 = zzxkVar2;
                zzbfVar4 = zzbfVar3;
                zzxkVar3 = zzxkVar7;
                z13 = z17;
                r163 = r12;
                z17 = z4;
                r122 = 0;
                r162 = r163;
                zzms zzmsVar2 = this.zzH;
                zzbf zzbfVar8 = zzmsVar2.zza;
                zzxk zzxkVar8 = zzmsVar2.zzb;
                zzxkVar4 = zzxkVar3;
                zzag(zzbfVar4, zzxkVar4, zzbfVar8, zzxkVar8, true == z17 ? j2 : jZzS, false);
                if (r162 == 0) {
                    if (z13) {
                    }
                    this.zzH = zzap(zzxkVar4, j8, j4, j7, z13, i4);
                }
                zzak();
                zzZ(zzbfVar4, this.zzH.zza);
                this.zzH = this.zzH.zzd(zzbfVar4);
                if (!zzbfVar4.zzg()) {
                }
                zzat(false);
                this.zzi.zzh(2);
                throw th;
            }
        }
        zzne[] zzneVarArr = this.zzb;
        for (int i14 = 0; i14 < 2; i14++) {
            zzneVarArr[i14].zzn(zzbfVar3);
        }
        try {
        } catch (Throwable th3) {
            th = th3;
        }
        if (r12 == 0) {
            try {
                zzmf zzmfVar = this.zzs;
                long jZzah = zzmfVar.zzn() == null ? j6 : zzah(zzmfVar.zzn());
                if (zzaA()) {
                    try {
                        long jZzah2 = zzmfVar.zzo() == null ? j6 : zzah(zzmfVar.zzo());
                        z = z17;
                        r16 = r12;
                        z17 = z4;
                        r12 = 0;
                        try {
                            int iZzw = zzmfVar.zzw(zzbfVar, this.zzU, jZzah, jZzah2);
                            zzbfVar3 = zzbfVar;
                            if ((iZzw & 1) != 0) {
                                zzI(false);
                                r123 = r12;
                                r164 = r16;
                            } else {
                                r123 = r12;
                                r164 = r16;
                                if ((iZzw & 2) != 0) {
                                    zzab();
                                    r123 = r12;
                                    r164 = r16;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            zzbfVar3 = zzbfVar;
                            zzxk zzxkVar9 = zzxkVar2;
                            zzbfVar4 = zzbfVar3;
                            zzxkVar3 = zzxkVar9;
                            z13 = z;
                            r122 = r12;
                            r162 = r16;
                            zzms zzmsVar22 = this.zzH;
                            zzbf zzbfVar82 = zzmsVar22.zza;
                            zzxk zzxkVar82 = zzmsVar22.zzb;
                            zzxkVar4 = zzxkVar3;
                            zzag(zzbfVar4, zzxkVar4, zzbfVar82, zzxkVar82, true == z17 ? j2 : jZzS, false);
                            if (r162 == 0) {
                            }
                            zzak();
                            zzZ(zzbfVar4, this.zzH.zza);
                            this.zzH = this.zzH.zzd(zzbfVar4);
                            if (!zzbfVar4.zzg()) {
                            }
                            zzat(false);
                            this.zzi.zzh(2);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z13 = z17;
                        zzxkVar3 = zzxkVar2;
                        r163 = r12;
                        z17 = z4;
                        zzbfVar4 = zzbfVar;
                        r122 = 0;
                        r162 = r163;
                        zzms zzmsVar222 = this.zzH;
                        zzbf zzbfVar822 = zzmsVar222.zza;
                        zzxk zzxkVar822 = zzmsVar222.zzb;
                        zzxkVar4 = zzxkVar3;
                        zzag(zzbfVar4, zzxkVar4, zzbfVar822, zzxkVar822, true == z17 ? j2 : jZzS, false);
                        if (r162 == 0) {
                        }
                        zzak();
                        zzZ(zzbfVar4, this.zzH.zza);
                        this.zzH = this.zzH.zzd(zzbfVar4);
                        if (!zzbfVar4.zzg()) {
                        }
                        zzat(false);
                        this.zzi.zzh(2);
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zzbfVar3 = zzbfVar;
                z = z17;
                r16 = r12;
                z17 = z4;
                r12 = 0;
            }
            zzms zzmsVar2222 = this.zzH;
            zzbf zzbfVar8222 = zzmsVar2222.zza;
            zzxk zzxkVar8222 = zzmsVar2222.zzb;
            zzxkVar4 = zzxkVar3;
            zzag(zzbfVar4, zzxkVar4, zzbfVar8222, zzxkVar8222, true == z17 ? j2 : jZzS, false);
            if (r162 == 0 || j4 != this.zzH.zzc) {
                if (z13) {
                    j7 = this.zzH.zzd;
                    j8 = jZzS;
                } else {
                    j8 = jZzS;
                    j7 = j8;
                }
                this.zzH = zzap(zzxkVar4, j8, j4, j7, z13, i4);
            }
            zzak();
            zzZ(zzbfVar4, this.zzH.zza);
            this.zzH = this.zzH.zzd(zzbfVar4);
            if (!zzbfVar4.zzg()) {
                this.zzT = r122;
            }
            zzat(false);
            this.zzi.zzh(2);
            throw th;
        }
        z = z17;
        ?? r165 = r12;
        z17 = z4;
        Object obj9 = null;
        r123 = obj9;
        r164 = r165;
        if (!zzbfVar3.zzg()) {
            zzmf zzmfVar2 = this.zzs;
            for (zzmc zzmcVarZzm = zzmfVar2.zzm(); zzmcVarZzm != null; zzmcVarZzm = zzmcVarZzm.zzp()) {
                if (zzmcVarZzm.zzg.zza.equals(zzxkVar2)) {
                    zzmcVarZzm.zzg = zzmfVar2.zzx(zzbfVar3, zzmcVarZzm.zzg);
                    zzmcVarZzm.zzs();
                }
            }
            jZzS = zzS(zzxkVar2, jZzS, z9);
            r123 = obj9;
            r164 = r165;
        }
        zzms zzmsVar3 = this.zzH;
        zzxk zzxkVar10 = zzxkVar2;
        zzag(zzbfVar3, zzxkVar10, zzmsVar3.zza, zzmsVar3.zzb, true != z17 ? j2 : jZzS, false);
        zzbf zzbfVar9 = zzbfVar3;
        if (r164 != 0 || j4 != this.zzH.zzc) {
            if (z) {
                j10 = jZzS;
                j9 = j10;
            } else {
                j9 = this.zzH.zzd;
                j10 = jZzS;
            }
            this.zzH = zzap(zzxkVar10, j10, j4, j9, z, i4);
        }
        zzak();
        zzZ(zzbfVar9, this.zzH.zza);
        this.zzH = this.zzH.zzd(zzbfVar9);
        if (!zzbfVar9.zzg()) {
            this.zzT = r123;
        }
        zzat(false);
        this.zzi.zzh(2);
    }

    private final void zzag(zzbf zzbfVar, zzxk zzxkVar, zzbf zzbfVar2, zzxk zzxkVar2, long j, boolean z) {
        if (!zzP(zzbfVar, zzxkVar)) {
            zzav zzavVar = zzxkVar.zzb() ? zzav.zza : this.zzH.zzo;
            if (this.zzo.zzj().equals(zzavVar)) {
                return;
            }
            zzM(zzavVar);
            zzam(this.zzH.zzo, zzavVar.zzb, false, false);
            return;
        }
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zzm;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        zzjd zzjdVar = this.zzae;
        zzaf zzafVar = zzbeVar.zzj;
        String str = zzfl.zza;
        zzjdVar.zza(zzafVar);
        if (j != -9223372036854775807L) {
            zzjdVar.zzb(zzO(zzbfVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzbfVar2.zzg() ? zzbfVar2.zzb(zzbfVar2.zzo(zzxkVar2.zza, zzbdVar).zzc, zzbeVar, 0L).zzb : null, zzbeVar.zzb) || z) {
            zzjdVar.zzb(-9223372036854775807L);
        }
    }

    private final long zzah(zzmc zzmcVar) {
        if (zzmcVar == null) {
            return 0L;
        }
        long jZza = zzmcVar.zza();
        if (zzmcVar.zze) {
            int i = 0;
            while (true) {
                zzne[] zzneVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzneVarArr[i].zzp(zzmcVar)) {
                    long jZzf = zzneVarArr[i].zzf(zzmcVar);
                    if (jZzf == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZza = Math.max(jZzf, jZza);
                }
                i++;
            }
        }
        return jZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0218 A[LOOP:9: B:118:0x0216->B:119:0x0218, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108 A[EDGE_INSN: B:227:0x0108->B:63:0x0108 BREAK  A[LOOP:6: B:72:0x0128->B:76:0x0134]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzai() throws zzjk {
        int i;
        int i2;
        boolean z;
        zzmc zzmcVarZzm;
        zzmc zzmcVarZzp;
        boolean z2;
        zzne[] zzneVarArr;
        zzmc zzmcVarZzo;
        zzmd zzmdVarZzh;
        if (this.zzH.zza.zzg() || !this.zzt.zzb()) {
            return;
        }
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzf(this.zzU);
        if (zzmfVar.zzg() && (zzmdVarZzh = zzmfVar.zzh(this.zzU, this.zzH)) != null) {
            zzmc zzmcVarZzi = zzmfVar.zzi(zzmdVarZzh);
            if (!zzmcVarZzi.zzd) {
                zzmcVarZzi.zzt(this, zzmdVarZzh.zzb);
            } else if (zzmcVarZzi.zze) {
                this.zzi.zzd(8, zzmcVarZzi.zza).zza();
            }
            if (zzmfVar.zzm() == zzmcVarZzi) {
                zzU(zzmdVarZzh.zzb, true);
            }
            zzat(false);
        }
        if (this.zzO) {
            this.zzO = zzaG(zzmfVar.zzk());
            zzao();
        } else {
            zzan();
        }
        if (!this.zzL && this.zzy && !this.zzac && !zzaA() && (zzmcVarZzo = zzmfVar.zzo()) != null && zzmcVarZzo == zzmfVar.zzn() && zzmcVarZzo.zzp() != null && zzmcVarZzo.zzp().zze && zzaw(zzmcVarZzo.zzp()) <= 10000000) {
            zzmfVar.zzq();
            zzmc zzmcVarZzo2 = zzmfVar.zzo();
            if (zzmcVarZzo2 != null) {
                zzabi zzabiVarZzr = zzmcVarZzo2.zzr();
                int i3 = 0;
                while (true) {
                    zzne[] zzneVarArr2 = this.zzb;
                    if (i3 >= 2) {
                        break;
                    }
                    if (zzabiVarZzr.zza(i3) && zzneVarArr2[i3].zza() && !zzneVarArr2[i3].zzc()) {
                        zzneVarArr2[i3].zzb();
                        zzas(zzmcVarZzo2, i3, false, zzmcVarZzo2.zzc());
                    }
                    i3++;
                }
                if (zzaA()) {
                    this.zzab = zzmcVarZzo2.zza.zzh();
                    if (!zzmcVarZzo2.zzd()) {
                        zzmfVar.zzs(zzmcVarZzo2);
                        zzat(false);
                        zzan();
                    }
                }
            }
        }
        zzmc zzmcVarZzn = zzmfVar.zzn();
        if (zzmcVarZzn != null) {
            if (zzmcVarZzn.zzp() == null || this.zzL) {
                i = 1;
                if (zzmcVarZzn.zzg.zzk || this.zzL) {
                    zzne[] zzneVarArr3 = this.zzb;
                    for (int i4 = 0; i4 < 2; i4++) {
                        zzne zzneVar = zzneVarArr3[i4];
                        if (zzneVar.zzp(zzmcVarZzn) && zzneVar.zzg(zzmcVarZzn)) {
                            long j = zzmcVarZzn.zzg.zzf;
                            zzneVar.zzh(zzmcVarZzn, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : zzmcVarZzn.zza() + j);
                        }
                    }
                }
            } else {
                zzmc zzmcVarZzn2 = zzmfVar.zzn();
                if (zzmcVarZzn2.zze) {
                    int i5 = 0;
                    while (true) {
                        zzne[] zzneVarArr4 = this.zzb;
                        if (i5 < 2) {
                            if (!zzneVarArr4[i5].zzr(zzmcVarZzn2)) {
                                break;
                            } else {
                                i5++;
                            }
                        } else if ((!zzaA() || zzmfVar.zzo() != zzmfVar.zzn()) && ((zzmcVarZzn.zzp().zze || this.zzU >= zzmcVarZzn.zzp().zzc()) && (!zzmcVarZzn.zzp().zze || zzaw(zzmcVarZzn.zzp()) <= 10000000))) {
                            zzabi zzabiVarZzr2 = zzmcVarZzn.zzr();
                            zzmc zzmcVarZzp2 = zzmfVar.zzp();
                            zzabi zzabiVarZzr3 = zzmcVarZzp2.zzr();
                            zzbf zzbfVar = this.zzH.zza;
                            i = 1;
                            zzag(zzbfVar, zzmcVarZzp2.zzg.zza, zzbfVar, zzmcVarZzn.zzg.zza, -9223372036854775807L, false);
                            if (!zzmcVarZzp2.zze || ((!(z = this.zzy) || this.zzab == -9223372036854775807L) && zzmcVarZzp2.zza.zzh() == -9223372036854775807L)) {
                                for (i2 = 0; i2 < 2; i2++) {
                                    zzneVarArr4[i2].zzi(zzabiVarZzr2, zzabiVarZzr3, zzmcVarZzp2.zzc());
                                }
                            } else {
                                this.zzab = -9223372036854775807L;
                                if (z && !this.zzac) {
                                    for (int i6 = 0; i6 < 2; i6++) {
                                        if (zzabiVarZzr3.zza(i6)) {
                                            zzneVarArr4[i6].zze();
                                            zzaba[] zzabaVarArr = zzabiVarZzr3.zzc;
                                            if (zzas.zzd(zzabaVarArr[i6].zzc().zzp, zzabaVarArr[i6].zzc().zzk) || zzneVarArr4[i6].zzc()) {
                                            }
                                        }
                                    }
                                    while (i2 < 2) {
                                    }
                                }
                                long jZzc = zzmcVarZzp2.zzc();
                                for (int i7 = 0; i7 < 2; i7++) {
                                    zzneVarArr4[i7].zzj(jZzc);
                                }
                                if (!zzmcVarZzp2.zzd()) {
                                    zzmfVar.zzs(zzmcVarZzp2);
                                    zzat(false);
                                    zzan();
                                }
                            }
                        }
                    }
                    i = 1;
                } else {
                    i = 1;
                }
            }
        }
        zzmc zzmcVarZzn3 = zzmfVar.zzn();
        if (zzmcVarZzn3 != null && zzmfVar.zzm() != zzmcVarZzn3 && !zzmcVarZzn3.zzh) {
            zzmc zzmcVarZzn4 = zzmfVar.zzn();
            zzabi zzabiVarZzr4 = zzmcVarZzn4.zzr();
            int i8 = i;
            int i9 = 0;
            while (true) {
                zzneVarArr = this.zzb;
                if (i9 >= 2) {
                    break;
                }
                int iZzd = zzneVarArr[i9].zzd();
                int iZzH = zzneVarArr[i9].zzH(zzmcVarZzn4, zzabiVarZzr4, this.zzo);
                this.zzS -= iZzd - zzneVarArr[i9].zzd();
                i8 &= iZzH & 1;
                i9++;
            }
            if (i8 != 0) {
                for (int i10 = 0; i10 < 2; i10++) {
                    if (zzabiVarZzr4.zza(i10) && !zzneVarArr[i10].zzp(zzmcVarZzn4)) {
                        zzas(zzmcVarZzn4, i10, false, zzmcVarZzn4.zzc());
                    }
                }
                zzmfVar.zzn().zzh = i;
            }
        }
        boolean z3 = false;
        while (zzay() && !this.zzL && (zzmcVarZzm = zzmfVar.zzm()) != null && (zzmcVarZzp = zzmcVarZzm.zzp()) != null && this.zzU >= zzmcVarZzp.zzc() && zzmcVarZzp.zzh) {
            if (z3) {
                zzC();
            }
            this.zzac = false;
            zzmc zzmcVarZzr = zzmfVar.zzr();
            zzmcVarZzr.getClass();
            if (this.zzH.zzb.zza.equals(zzmcVarZzr.zzg.zza.zza)) {
                zzxk zzxkVar = this.zzH.zzb;
                if (zzxkVar.zzb == -1) {
                    zzxk zzxkVar2 = zzmcVarZzr.zzg.zza;
                    z2 = zzxkVar2.zzb == -1 && zzxkVar.zze != zzxkVar2.zze;
                }
            }
            zzmd zzmdVar = zzmcVarZzr.zzg;
            boolean z4 = z2;
            zzxk zzxkVar3 = zzmdVar.zza;
            long j2 = zzmdVar.zzb;
            this.zzH = zzap(zzxkVar3, j2, zzmdVar.zzd, j2, !z4, 0);
            zzak();
            zzL();
            if (zzaA() && zzmcVarZzr == zzmfVar.zzo()) {
                zzne[] zzneVarArr5 = this.zzb;
                for (int i11 = 0; i11 < 2; i11++) {
                    zzneVarArr5[i11].zzB();
                }
            }
            if (this.zzH.zze == 3) {
                zzJ();
            }
            zzabi zzabiVarZzr5 = zzmfVar.zzm().zzr();
            int i12 = 0;
            while (true) {
                zzne[] zzneVarArr6 = this.zzb;
                if (i12 < 2) {
                    if (zzabiVarZzr5.zza(i12)) {
                        zzneVarArr6[i12].zzl();
                    }
                    i12++;
                }
            }
            z3 = true;
        }
        long j3 = this.zzaa.zzb;
    }

    private final void zzaj() {
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzt();
        zzmc zzmcVarZzl = zzmfVar.zzl();
        if (zzmcVarZzl != null) {
            if (!zzmcVarZzl.zzd || zzmcVarZzl.zze) {
                zzxi zzxiVar = zzmcVarZzl.zza;
                if (zzxiVar.zzn()) {
                    return;
                }
                if (this.zzg.zzj(this.zzv, this.zzH.zza, zzmcVarZzl.zzg.zza, zzmcVarZzl.zze ? zzxiVar.zzi() : 0L)) {
                    if (!zzmcVarZzl.zzd) {
                        zzmcVarZzl.zzt(this, zzmcVarZzl.zzg.zzb);
                        return;
                    }
                    zzlz zzlzVar = new zzlz();
                    zzlzVar.zza(this.zzU - zzmcVarZzl.zza());
                    zzlzVar.zzb(this.zzo.zzj().zzb);
                    zzlzVar.zzc(this.zzN);
                    zzmcVarZzl.zzj(new zzma(zzlzVar, null));
                }
            }
        }
    }

    private final void zzak() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        boolean z = false;
        if (zzmcVarZzm != null && zzmcVarZzm.zzg.zzj && this.zzK) {
            z = true;
        }
        this.zzL = z;
    }

    private final void zzal(zzav zzavVar, boolean z) {
        zzam(zzavVar, zzavVar.zzb, true, z);
    }

    private final void zzam(zzav zzavVar, float f, boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                this.zzI.zza(1);
            }
            zzms zzmsVar = this.zzH;
            this.zzH = new zzms(zzmsVar.zza, zzmsVar.zzb, zzmsVar.zzc, zzmsVar.zzd, zzmsVar.zze, zzmsVar.zzf, zzmsVar.zzg, zzmsVar.zzh, zzmsVar.zzi, zzmsVar.zzj, zzmsVar.zzk, zzmsVar.zzl, zzmsVar.zzm, zzmsVar.zzn, zzavVar, zzmsVar.zzq, zzmsVar.zzr, zzmsVar.zzs, zzmsVar.zzt, false);
        }
        float f2 = zzavVar.zzb;
        zzmc zzmcVarZzm = this.zzs.zzm();
        while (true) {
            i = 0;
            if (zzmcVarZzm == null) {
                break;
            }
            zzaba[] zzabaVarArr = zzmcVarZzm.zzr().zzc;
            int length = zzabaVarArr.length;
            while (i < length) {
                zzaba zzabaVar = zzabaVarArr[i];
                i++;
            }
            zzmcVarZzm = zzmcVarZzm.zzp();
        }
        zzne[] zzneVarArr = this.zzb;
        while (i < 2) {
            zzneVarArr[i].zzm(f, f2);
            i++;
        }
    }

    private final void zzan() {
        long jZza;
        zzmf zzmfVar = this.zzs;
        boolean zZzh = false;
        if (zzaG(zzmfVar.zzk())) {
            zzmc zzmcVarZzk = zzmfVar.zzk();
            long jZzav = zzav(zzmcVarZzk.zzg());
            zzmc zzmcVarZzm = zzmfVar.zzm();
            long jZza2 = this.zzU;
            if (zzmcVarZzk == zzmcVarZzm) {
                jZza = zzmcVarZzk.zza();
            } else {
                jZza2 -= zzmcVarZzk.zza();
                jZza = zzmcVarZzk.zzg.zzb;
            }
            zzlx zzlxVar = new zzlx(this.zzv, this.zzH.zza, zzmcVarZzk.zzg.zza, jZza2 - jZza, jZzav, this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, zzP(this.zzH.zza, zzmcVarZzk.zzg.zza) ? this.zzae.zze() : -9223372036854775807L, this.zzN);
            zzly zzlyVar = this.zzg;
            boolean zZzh2 = zzlyVar.zzh(zzlxVar);
            zzmc zzmcVarZzm2 = zzmfVar.zzm();
            if (zZzh2 || !zzmcVarZzm2.zze || jZzav >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzmcVarZzm2.zza.zzf(this.zzH.zzs, false);
                zZzh = zzlyVar.zzh(zzlxVar);
            }
        }
        this.zzO = zZzh;
        if (zZzh) {
            zzmc zzmcVarZzk2 = zzmfVar.zzk();
            zzmcVarZzk2.getClass();
            zzlz zzlzVar = new zzlz();
            zzlzVar.zza(this.zzU - zzmcVarZzk2.zza());
            zzlzVar.zzb(this.zzo.zzj().zzb);
            zzlzVar.zzc(this.zzN);
            zzmcVarZzk2.zzj(new zzma(zzlzVar, null));
        }
        zzao();
    }

    private final void zzao() {
        zzmc zzmcVarZzk = this.zzs.zzk();
        boolean z = true;
        if (!this.zzO && (zzmcVarZzk == null || !zzmcVarZzk.zza.zzn())) {
            z = false;
        }
        zzms zzmsVar = this.zzH;
        if (z != zzmsVar.zzg) {
            this.zzH = zzmsVar.zzg(z);
        }
    }

    private final zzms zzap(zzxk zzxkVar, long j, long j2, long j3, boolean z, int i) {
        List list;
        zzzn zzznVar;
        zzabi zzabiVar;
        zzmc zzmcVarZzm;
        zzmf zzmfVar;
        zzmc zzmcVar;
        int i2 = 0;
        this.zzX = (!this.zzX && j == this.zzH.zzs && zzxkVar.equals(this.zzH.zzb)) ? false : true;
        zzak();
        zzms zzmsVar = this.zzH;
        zzzn zzznVar2 = zzmsVar.zzh;
        zzabi zzabiVar2 = zzmsVar.zzi;
        List listZzi = zzmsVar.zzj;
        if (this.zzt.zzb()) {
            zzmf zzmfVar2 = this.zzs;
            zzmc zzmcVarZzm2 = zzmfVar2.zzm();
            zzzn zzznVarZzq = zzmcVarZzm2 == null ? zzzn.zza : zzmcVarZzm2.zzq();
            zzabi zzabiVarZzr = zzmcVarZzm2 == null ? this.zzf : zzmcVarZzm2.zzr();
            zzaba[] zzabaVarArr = zzabiVarZzr.zzc;
            zzgwj zzgwjVar = new zzgwj();
            int length = zzabaVarArr.length;
            int i3 = 0;
            boolean z2 = false;
            while (i3 < length) {
                zzaba zzabaVar = zzabaVarArr[i3];
                if (zzabaVar != null) {
                    zzap zzapVar = zzabaVar.zzb(0).zzl;
                    if (zzapVar == null) {
                        zzmcVar = zzmcVarZzm2;
                        zzmfVar = zzmfVar2;
                        zzgwjVar.zzf(new zzap(-9223372036854775807L, new zzao[0]));
                    } else {
                        zzmfVar = zzmfVar2;
                        zzmcVar = zzmcVarZzm2;
                        zzgwjVar.zzf(zzapVar);
                        z2 = true;
                    }
                } else {
                    zzmfVar = zzmfVar2;
                    zzmcVar = zzmcVarZzm2;
                }
                i3++;
                zzmcVarZzm2 = zzmcVar;
                zzmfVar2 = zzmfVar;
            }
            zzmf zzmfVar3 = zzmfVar2;
            zzmc zzmcVar2 = zzmcVarZzm2;
            zzgwm zzgwmVarZzi = z2 ? zzgwjVar.zzi() : zzgwm.zzi();
            if (zzmcVar2 != null) {
                zzmd zzmdVar = zzmcVar2.zzg;
                if (zzmdVar.zzd != j2) {
                    zzmcVar2.zzg = zzmdVar.zzb(j2);
                }
            }
            if (zzmfVar3.zzm() == zzmfVar3.zzn() && (zzmcVarZzm = zzmfVar3.zzm()) != null) {
                zzabi zzabiVarZzr2 = zzmcVarZzm.zzr();
                while (true) {
                    zzne[] zzneVarArr = this.zzb;
                    if (i2 >= 2) {
                        break;
                    }
                    if (zzabiVarZzr2.zza(i2)) {
                        if (zzneVarArr[i2].zze() != 1) {
                            break;
                        }
                        int i4 = zzabiVarZzr2.zzb[i2].zzb;
                    }
                    i2++;
                }
            }
            list = zzgwmVarZzi;
            zzznVar = zzznVarZzq;
            zzabiVar = zzabiVarZzr;
        } else {
            if (!zzxkVar.equals(this.zzH.zzb)) {
                zzabiVar2 = this.zzf;
                zzznVar2 = zzzn.zza;
                listZzi = zzgwm.zzi();
            }
            list = listZzi;
            zzznVar = zzznVar2;
            zzabiVar = zzabiVar2;
        }
        if (z) {
            this.zzI.zzc(i);
        }
        return this.zzH.zzc(zzxkVar, j, j2, j3, zzau(), zzznVar, zzabiVar, list);
    }

    private final void zzaq() throws zzjk {
        zzar(new boolean[2], this.zzs.zzn().zzc());
    }

    private final void zzar(boolean[] zArr, long j) throws zzjk {
        zzne[] zzneVarArr;
        zzlu zzluVar;
        long j2;
        zzmc zzmcVarZzn = this.zzs.zzn();
        zzabi zzabiVarZzr = zzmcVarZzn.zzr();
        int i = 0;
        while (true) {
            zzneVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzabiVarZzr.zza(i)) {
                zzneVarArr[i].zzG();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < 2) {
            if (!zzabiVarZzr.zza(i2) || zzneVarArr[i2].zzp(zzmcVarZzn)) {
                zzluVar = this;
                j2 = j;
            } else {
                zzluVar = this;
                j2 = j;
                zzluVar.zzas(zzmcVarZzn, i2, zArr[i2], j2);
            }
            i2++;
            this = zzluVar;
            j = j2;
        }
    }

    private final void zzas(zzmc zzmcVar, int i, boolean z, long j) throws zzjk {
        zzne zzneVar = this.zzb[i];
        if (zzneVar.zzM()) {
            return;
        }
        boolean z2 = zzmcVar == this.zzs.zzm();
        zzabi zzabiVarZzr = zzmcVar.zzr();
        zznd zzndVar = zzabiVarZzr.zzb[i];
        zzaba zzabaVar = zzabiVarZzr.zzc[i];
        boolean z3 = zzay() && this.zzH.zze == 3;
        boolean z4 = !z && z3;
        this.zzS++;
        zzneVar.zzx(zzndVar, zzabaVar, zzmcVar.zzc[i], this.zzU, z4, z2, j, zzmcVar.zza(), zzmcVar.zzg.zza, this.zzo);
        zzneVar.zzy(11, new zzli(this), zzmcVar);
        if (z3 && z2) {
            zzneVar.zzv();
        }
    }

    private final void zzat(boolean z) {
        zzmc zzmcVarZzk = this.zzs.zzk();
        zzxk zzxkVar = zzmcVarZzk == null ? this.zzH.zzb : zzmcVarZzk.zzg.zza;
        boolean zEquals = this.zzH.zzk.equals(zzxkVar);
        if (!zEquals) {
            this.zzH = this.zzH.zzh(zzxkVar);
        }
        zzms zzmsVar = this.zzH;
        zzmsVar.zzq = zzmcVarZzk == null ? zzmsVar.zzs : zzmcVarZzk.zzf();
        this.zzH.zzr = zzau();
        if ((!zEquals || z) && zzmcVarZzk != null && zzmcVarZzk.zze) {
            zzax(zzmcVarZzk.zzg.zza, zzmcVarZzk.zzq(), zzmcVarZzk.zzr());
        }
    }

    private final long zzau() {
        return zzav(this.zzH.zzq);
    }

    private final long zzav(long j) {
        zzmc zzmcVarZzk = this.zzs.zzk();
        if (zzmcVarZzk == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzU - zzmcVarZzk.zza()));
    }

    private final long zzaw(zzmc zzmcVar) {
        zzgtj.zzi(zzmcVar.zze);
        return (long) ((zzmcVar.zzc() - this.zzU) / this.zzo.zzj().zzb);
    }

    private final void zzax(zzxk zzxkVar, zzzn zzznVar, zzabi zzabiVar) {
        long jZza;
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzk = zzmfVar.zzk();
        zzmcVarZzk.getClass();
        zzmc zzmcVarZzm = zzmfVar.zzm();
        long jZza2 = this.zzU;
        if (zzmcVarZzk == zzmcVarZzm) {
            jZza = zzmcVarZzk.zza();
        } else {
            jZza2 -= zzmcVarZzk.zza();
            jZza = zzmcVarZzk.zzg.zzb;
        }
        this.zzg.zzb(new zzlx(this.zzv, this.zzH.zza, zzxkVar, jZza2 - jZza, zzav(zzmcVarZzk.zzf()), this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, zzP(this.zzH.zza, zzmcVarZzk.zzg.zza) ? this.zzae.zze() : -9223372036854775807L, this.zzN), zzznVar, zzabiVar.zzc);
    }

    private final boolean zzay() {
        zzms zzmsVar = this.zzH;
        return zzmsVar.zzl && zzmsVar.zzn == 0;
    }

    private final void zzaz(int i) throws Throwable {
        zzne zzneVar = this.zzb[i];
        try {
            zzmc zzmcVarZzm = this.zzs.zzm();
            if (zzmcVarZzm == null) {
                throw null;
            }
            zzneVar.zzu(zzmcVarZzm);
        } catch (IOException e) {
            e = e;
            zzneVar.zze();
            throw e;
        } catch (RuntimeException e2) {
            e = e2;
            zzneVar.zze();
            throw e;
        }
    }

    public static int zzr(zzbe zzbeVar, zzbd zzbdVar, int i, boolean z, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        zzbe zzbeVar2 = zzbeVar;
        zzbf zzbfVar3 = zzbfVar;
        Object obj2 = zzbfVar3.zzb(zzbfVar3.zzo(obj, zzbdVar).zzc, zzbeVar, 0L).zzb;
        for (int i2 = 0; i2 < zzbfVar2.zza(); i2++) {
            if (zzbfVar2.zzb(i2, zzbeVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZze = zzbfVar3.zze(obj);
        int iZzc = zzbfVar3.zzc();
        int iZze2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= iZzc || iZze2 != -1) {
                break;
            }
            zzbf zzbfVar4 = zzbfVar3;
            int iZzl = zzbfVar4.zzl(iZze, zzbdVar, zzbeVar2, i, z);
            if (iZzl == -1) {
                iZze2 = -1;
                break;
            }
            iZze2 = zzbfVar2.zze(zzbfVar4.zzf(iZzl));
            i3++;
            zzbfVar3 = zzbfVar4;
            iZze = iZzl;
            zzbeVar2 = zzbeVar;
        }
        if (iZze2 == -1) {
            return -1;
        }
        return zzbfVar2.zzd(iZze2, zzbdVar, false).zzc;
    }

    public static final /* synthetic */ void zzz(zzmw zzmwVar) {
        try {
            zzaF(zzmwVar);
        } catch (zzjk e) {
            zzeg.zzf("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:247:0x053d A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzhq -> 0x0028, zzat -> 0x002b, zzuf -> 0x002e, zzjk -> 0x0031, TryCatch #13 {RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:20:0x0034, B:22:0x003a, B:23:0x0040, B:25:0x004a, B:27:0x0050, B:29:0x0054, B:31:0x005c, B:32:0x0061, B:34:0x0065, B:35:0x006f, B:37:0x007c, B:38:0x0083, B:39:0x0089, B:41:0x0092, B:42:0x009a, B:43:0x00a1, B:44:0x00b0, B:45:0x00bd, B:49:0x00ce, B:50:0x00d6, B:52:0x00e5, B:53:0x00ed, B:58:0x00fc, B:56:0x00f5, B:59:0x0101, B:63:0x011d, B:64:0x0135, B:65:0x0146, B:66:0x015e, B:67:0x0163, B:68:0x0168, B:72:0x016f, B:74:0x0178, B:76:0x0184, B:77:0x018c, B:78:0x0197, B:79:0x01ab, B:80:0x01c3, B:81:0x01cd, B:82:0x01ce, B:84:0x01dd, B:85:0x01e1, B:86:0x01f2, B:88:0x0201, B:89:0x021d, B:90:0x0230, B:91:0x0239, B:93:0x024b, B:94:0x0257, B:95:0x0267, B:97:0x0273, B:100:0x027e, B:101:0x0285, B:102:0x0290, B:106:0x0297, B:108:0x029f, B:110:0x02a3, B:112:0x02a8, B:114:0x02b2, B:115:0x02b7, B:119:0x02be, B:121:0x02ce, B:125:0x02d8, B:122:0x02d2, B:124:0x02d5, B:126:0x02dd, B:128:0x02ef, B:132:0x02f9, B:129:0x02f3, B:131:0x02f6, B:133:0x02fe, B:134:0x0303, B:136:0x030f, B:137:0x0319, B:139:0x031f, B:147:0x033a, B:154:0x0389, B:172:0x03b6, B:174:0x03bd, B:175:0x03be, B:177:0x03c6, B:179:0x03e3, B:180:0x03e8, B:188:0x041c, B:190:0x042a, B:191:0x0437, B:192:0x0438, B:193:0x043f, B:194:0x0449, B:195:0x045d, B:196:0x0468, B:198:0x0477, B:199:0x047a, B:205:0x0487, B:206:0x048a, B:208:0x0492, B:209:0x0497, B:211:0x04a3, B:212:0x04bf, B:214:0x04c3, B:216:0x04cb, B:231:0x04f6, B:217:0x04cf, B:219:0x04d8, B:223:0x04e1, B:229:0x04f1, B:233:0x0503, B:235:0x050e, B:239:0x0516, B:241:0x051e, B:243:0x0522, B:244:0x052c, B:246:0x0532, B:299:0x064c, B:302:0x0654, B:304:0x0658, B:306:0x0660, B:307:0x0663, B:308:0x0667, B:310:0x066d, B:312:0x0676, B:314:0x0680, B:316:0x0686, B:318:0x068c, B:325:0x06ae, B:327:0x06b4, B:331:0x06be, B:342:0x06d7, B:339:0x06d0, B:341:0x06d4, B:319:0x0693, B:322:0x06a1, B:323:0x06a9, B:324:0x06aa, B:247:0x053d, B:249:0x0544, B:251:0x0548, B:278:0x05ed, B:280:0x05f9, B:281:0x0606, B:283:0x060d, B:285:0x0611, B:289:0x061a, B:291:0x062a, B:293:0x0630, B:295:0x063a, B:296:0x063f, B:297:0x0644, B:298:0x0649, B:254:0x0556, B:256:0x055a, B:258:0x056c, B:260:0x0577, B:262:0x0581, B:266:0x058a, B:268:0x0594, B:274:0x059f, B:232:0x04fc, B:344:0x06dd, B:348:0x06e4), top: B:424:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05f9 A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzhq -> 0x0028, zzat -> 0x002b, zzuf -> 0x002e, zzjk -> 0x0031, TryCatch #13 {RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:20:0x0034, B:22:0x003a, B:23:0x0040, B:25:0x004a, B:27:0x0050, B:29:0x0054, B:31:0x005c, B:32:0x0061, B:34:0x0065, B:35:0x006f, B:37:0x007c, B:38:0x0083, B:39:0x0089, B:41:0x0092, B:42:0x009a, B:43:0x00a1, B:44:0x00b0, B:45:0x00bd, B:49:0x00ce, B:50:0x00d6, B:52:0x00e5, B:53:0x00ed, B:58:0x00fc, B:56:0x00f5, B:59:0x0101, B:63:0x011d, B:64:0x0135, B:65:0x0146, B:66:0x015e, B:67:0x0163, B:68:0x0168, B:72:0x016f, B:74:0x0178, B:76:0x0184, B:77:0x018c, B:78:0x0197, B:79:0x01ab, B:80:0x01c3, B:81:0x01cd, B:82:0x01ce, B:84:0x01dd, B:85:0x01e1, B:86:0x01f2, B:88:0x0201, B:89:0x021d, B:90:0x0230, B:91:0x0239, B:93:0x024b, B:94:0x0257, B:95:0x0267, B:97:0x0273, B:100:0x027e, B:101:0x0285, B:102:0x0290, B:106:0x0297, B:108:0x029f, B:110:0x02a3, B:112:0x02a8, B:114:0x02b2, B:115:0x02b7, B:119:0x02be, B:121:0x02ce, B:125:0x02d8, B:122:0x02d2, B:124:0x02d5, B:126:0x02dd, B:128:0x02ef, B:132:0x02f9, B:129:0x02f3, B:131:0x02f6, B:133:0x02fe, B:134:0x0303, B:136:0x030f, B:137:0x0319, B:139:0x031f, B:147:0x033a, B:154:0x0389, B:172:0x03b6, B:174:0x03bd, B:175:0x03be, B:177:0x03c6, B:179:0x03e3, B:180:0x03e8, B:188:0x041c, B:190:0x042a, B:191:0x0437, B:192:0x0438, B:193:0x043f, B:194:0x0449, B:195:0x045d, B:196:0x0468, B:198:0x0477, B:199:0x047a, B:205:0x0487, B:206:0x048a, B:208:0x0492, B:209:0x0497, B:211:0x04a3, B:212:0x04bf, B:214:0x04c3, B:216:0x04cb, B:231:0x04f6, B:217:0x04cf, B:219:0x04d8, B:223:0x04e1, B:229:0x04f1, B:233:0x0503, B:235:0x050e, B:239:0x0516, B:241:0x051e, B:243:0x0522, B:244:0x052c, B:246:0x0532, B:299:0x064c, B:302:0x0654, B:304:0x0658, B:306:0x0660, B:307:0x0663, B:308:0x0667, B:310:0x066d, B:312:0x0676, B:314:0x0680, B:316:0x0686, B:318:0x068c, B:325:0x06ae, B:327:0x06b4, B:331:0x06be, B:342:0x06d7, B:339:0x06d0, B:341:0x06d4, B:319:0x0693, B:322:0x06a1, B:323:0x06a9, B:324:0x06aa, B:247:0x053d, B:249:0x0544, B:251:0x0548, B:278:0x05ed, B:280:0x05f9, B:281:0x0606, B:283:0x060d, B:285:0x0611, B:289:0x061a, B:291:0x062a, B:293:0x0630, B:295:0x063a, B:296:0x063f, B:297:0x0644, B:298:0x0649, B:254:0x0556, B:256:0x055a, B:258:0x056c, B:260:0x0577, B:262:0x0581, B:266:0x058a, B:268:0x0594, B:274:0x059f, B:232:0x04fc, B:344:0x06dd, B:348:0x06e4), top: B:424:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x060d A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzhq -> 0x0028, zzat -> 0x002b, zzuf -> 0x002e, zzjk -> 0x0031, TryCatch #13 {RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:20:0x0034, B:22:0x003a, B:23:0x0040, B:25:0x004a, B:27:0x0050, B:29:0x0054, B:31:0x005c, B:32:0x0061, B:34:0x0065, B:35:0x006f, B:37:0x007c, B:38:0x0083, B:39:0x0089, B:41:0x0092, B:42:0x009a, B:43:0x00a1, B:44:0x00b0, B:45:0x00bd, B:49:0x00ce, B:50:0x00d6, B:52:0x00e5, B:53:0x00ed, B:58:0x00fc, B:56:0x00f5, B:59:0x0101, B:63:0x011d, B:64:0x0135, B:65:0x0146, B:66:0x015e, B:67:0x0163, B:68:0x0168, B:72:0x016f, B:74:0x0178, B:76:0x0184, B:77:0x018c, B:78:0x0197, B:79:0x01ab, B:80:0x01c3, B:81:0x01cd, B:82:0x01ce, B:84:0x01dd, B:85:0x01e1, B:86:0x01f2, B:88:0x0201, B:89:0x021d, B:90:0x0230, B:91:0x0239, B:93:0x024b, B:94:0x0257, B:95:0x0267, B:97:0x0273, B:100:0x027e, B:101:0x0285, B:102:0x0290, B:106:0x0297, B:108:0x029f, B:110:0x02a3, B:112:0x02a8, B:114:0x02b2, B:115:0x02b7, B:119:0x02be, B:121:0x02ce, B:125:0x02d8, B:122:0x02d2, B:124:0x02d5, B:126:0x02dd, B:128:0x02ef, B:132:0x02f9, B:129:0x02f3, B:131:0x02f6, B:133:0x02fe, B:134:0x0303, B:136:0x030f, B:137:0x0319, B:139:0x031f, B:147:0x033a, B:154:0x0389, B:172:0x03b6, B:174:0x03bd, B:175:0x03be, B:177:0x03c6, B:179:0x03e3, B:180:0x03e8, B:188:0x041c, B:190:0x042a, B:191:0x0437, B:192:0x0438, B:193:0x043f, B:194:0x0449, B:195:0x045d, B:196:0x0468, B:198:0x0477, B:199:0x047a, B:205:0x0487, B:206:0x048a, B:208:0x0492, B:209:0x0497, B:211:0x04a3, B:212:0x04bf, B:214:0x04c3, B:216:0x04cb, B:231:0x04f6, B:217:0x04cf, B:219:0x04d8, B:223:0x04e1, B:229:0x04f1, B:233:0x0503, B:235:0x050e, B:239:0x0516, B:241:0x051e, B:243:0x0522, B:244:0x052c, B:246:0x0532, B:299:0x064c, B:302:0x0654, B:304:0x0658, B:306:0x0660, B:307:0x0663, B:308:0x0667, B:310:0x066d, B:312:0x0676, B:314:0x0680, B:316:0x0686, B:318:0x068c, B:325:0x06ae, B:327:0x06b4, B:331:0x06be, B:342:0x06d7, B:339:0x06d0, B:341:0x06d4, B:319:0x0693, B:322:0x06a1, B:323:0x06a9, B:324:0x06aa, B:247:0x053d, B:249:0x0544, B:251:0x0548, B:278:0x05ed, B:280:0x05f9, B:281:0x0606, B:283:0x060d, B:285:0x0611, B:289:0x061a, B:291:0x062a, B:293:0x0630, B:295:0x063a, B:296:0x063f, B:297:0x0644, B:298:0x0649, B:254:0x0556, B:256:0x055a, B:258:0x056c, B:260:0x0577, B:262:0x0581, B:266:0x058a, B:268:0x0594, B:274:0x059f, B:232:0x04fc, B:344:0x06dd, B:348:0x06e4), top: B:424:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x062a A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzhq -> 0x0028, zzat -> 0x002b, zzuf -> 0x002e, zzjk -> 0x0031, TryCatch #13 {RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:20:0x0034, B:22:0x003a, B:23:0x0040, B:25:0x004a, B:27:0x0050, B:29:0x0054, B:31:0x005c, B:32:0x0061, B:34:0x0065, B:35:0x006f, B:37:0x007c, B:38:0x0083, B:39:0x0089, B:41:0x0092, B:42:0x009a, B:43:0x00a1, B:44:0x00b0, B:45:0x00bd, B:49:0x00ce, B:50:0x00d6, B:52:0x00e5, B:53:0x00ed, B:58:0x00fc, B:56:0x00f5, B:59:0x0101, B:63:0x011d, B:64:0x0135, B:65:0x0146, B:66:0x015e, B:67:0x0163, B:68:0x0168, B:72:0x016f, B:74:0x0178, B:76:0x0184, B:77:0x018c, B:78:0x0197, B:79:0x01ab, B:80:0x01c3, B:81:0x01cd, B:82:0x01ce, B:84:0x01dd, B:85:0x01e1, B:86:0x01f2, B:88:0x0201, B:89:0x021d, B:90:0x0230, B:91:0x0239, B:93:0x024b, B:94:0x0257, B:95:0x0267, B:97:0x0273, B:100:0x027e, B:101:0x0285, B:102:0x0290, B:106:0x0297, B:108:0x029f, B:110:0x02a3, B:112:0x02a8, B:114:0x02b2, B:115:0x02b7, B:119:0x02be, B:121:0x02ce, B:125:0x02d8, B:122:0x02d2, B:124:0x02d5, B:126:0x02dd, B:128:0x02ef, B:132:0x02f9, B:129:0x02f3, B:131:0x02f6, B:133:0x02fe, B:134:0x0303, B:136:0x030f, B:137:0x0319, B:139:0x031f, B:147:0x033a, B:154:0x0389, B:172:0x03b6, B:174:0x03bd, B:175:0x03be, B:177:0x03c6, B:179:0x03e3, B:180:0x03e8, B:188:0x041c, B:190:0x042a, B:191:0x0437, B:192:0x0438, B:193:0x043f, B:194:0x0449, B:195:0x045d, B:196:0x0468, B:198:0x0477, B:199:0x047a, B:205:0x0487, B:206:0x048a, B:208:0x0492, B:209:0x0497, B:211:0x04a3, B:212:0x04bf, B:214:0x04c3, B:216:0x04cb, B:231:0x04f6, B:217:0x04cf, B:219:0x04d8, B:223:0x04e1, B:229:0x04f1, B:233:0x0503, B:235:0x050e, B:239:0x0516, B:241:0x051e, B:243:0x0522, B:244:0x052c, B:246:0x0532, B:299:0x064c, B:302:0x0654, B:304:0x0658, B:306:0x0660, B:307:0x0663, B:308:0x0667, B:310:0x066d, B:312:0x0676, B:314:0x0680, B:316:0x0686, B:318:0x068c, B:325:0x06ae, B:327:0x06b4, B:331:0x06be, B:342:0x06d7, B:339:0x06d0, B:341:0x06d4, B:319:0x0693, B:322:0x06a1, B:323:0x06a9, B:324:0x06aa, B:247:0x053d, B:249:0x0544, B:251:0x0548, B:278:0x05ed, B:280:0x05f9, B:281:0x0606, B:283:0x060d, B:285:0x0611, B:289:0x061a, B:291:0x062a, B:293:0x0630, B:295:0x063a, B:296:0x063f, B:297:0x0644, B:298:0x0649, B:254:0x0556, B:256:0x055a, B:258:0x056c, B:260:0x0577, B:262:0x0581, B:266:0x058a, B:268:0x0594, B:274:0x059f, B:232:0x04fc, B:344:0x06dd, B:348:0x06e4), top: B:424:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x06aa A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzhq -> 0x0028, zzat -> 0x002b, zzuf -> 0x002e, zzjk -> 0x0031, TryCatch #13 {RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:20:0x0034, B:22:0x003a, B:23:0x0040, B:25:0x004a, B:27:0x0050, B:29:0x0054, B:31:0x005c, B:32:0x0061, B:34:0x0065, B:35:0x006f, B:37:0x007c, B:38:0x0083, B:39:0x0089, B:41:0x0092, B:42:0x009a, B:43:0x00a1, B:44:0x00b0, B:45:0x00bd, B:49:0x00ce, B:50:0x00d6, B:52:0x00e5, B:53:0x00ed, B:58:0x00fc, B:56:0x00f5, B:59:0x0101, B:63:0x011d, B:64:0x0135, B:65:0x0146, B:66:0x015e, B:67:0x0163, B:68:0x0168, B:72:0x016f, B:74:0x0178, B:76:0x0184, B:77:0x018c, B:78:0x0197, B:79:0x01ab, B:80:0x01c3, B:81:0x01cd, B:82:0x01ce, B:84:0x01dd, B:85:0x01e1, B:86:0x01f2, B:88:0x0201, B:89:0x021d, B:90:0x0230, B:91:0x0239, B:93:0x024b, B:94:0x0257, B:95:0x0267, B:97:0x0273, B:100:0x027e, B:101:0x0285, B:102:0x0290, B:106:0x0297, B:108:0x029f, B:110:0x02a3, B:112:0x02a8, B:114:0x02b2, B:115:0x02b7, B:119:0x02be, B:121:0x02ce, B:125:0x02d8, B:122:0x02d2, B:124:0x02d5, B:126:0x02dd, B:128:0x02ef, B:132:0x02f9, B:129:0x02f3, B:131:0x02f6, B:133:0x02fe, B:134:0x0303, B:136:0x030f, B:137:0x0319, B:139:0x031f, B:147:0x033a, B:154:0x0389, B:172:0x03b6, B:174:0x03bd, B:175:0x03be, B:177:0x03c6, B:179:0x03e3, B:180:0x03e8, B:188:0x041c, B:190:0x042a, B:191:0x0437, B:192:0x0438, B:193:0x043f, B:194:0x0449, B:195:0x045d, B:196:0x0468, B:198:0x0477, B:199:0x047a, B:205:0x0487, B:206:0x048a, B:208:0x0492, B:209:0x0497, B:211:0x04a3, B:212:0x04bf, B:214:0x04c3, B:216:0x04cb, B:231:0x04f6, B:217:0x04cf, B:219:0x04d8, B:223:0x04e1, B:229:0x04f1, B:233:0x0503, B:235:0x050e, B:239:0x0516, B:241:0x051e, B:243:0x0522, B:244:0x052c, B:246:0x0532, B:299:0x064c, B:302:0x0654, B:304:0x0658, B:306:0x0660, B:307:0x0663, B:308:0x0667, B:310:0x066d, B:312:0x0676, B:314:0x0680, B:316:0x0686, B:318:0x068c, B:325:0x06ae, B:327:0x06b4, B:331:0x06be, B:342:0x06d7, B:339:0x06d0, B:341:0x06d4, B:319:0x0693, B:322:0x06a1, B:323:0x06a9, B:324:0x06aa, B:247:0x053d, B:249:0x0544, B:251:0x0548, B:278:0x05ed, B:280:0x05f9, B:281:0x0606, B:283:0x060d, B:285:0x0611, B:289:0x061a, B:291:0x062a, B:293:0x0630, B:295:0x063a, B:296:0x063f, B:297:0x0644, B:298:0x0649, B:254:0x0556, B:256:0x055a, B:258:0x056c, B:260:0x0577, B:262:0x0581, B:266:0x058a, B:268:0x0594, B:274:0x059f, B:232:0x04fc, B:344:0x06dd, B:348:0x06e4), top: B:424:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07c6  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) throws Throwable {
        zzjk zzjkVar;
        boolean z;
        int i;
        zzxk zzxkVar;
        zzmc zzmcVarZzn;
        zzd zzdVar;
        zzxi zzxiVar;
        zzmf zzmfVar;
        boolean z2;
        boolean z3;
        long j;
        boolean zZzi;
        int i2 = 2;
        try {
            try {
                zzdVar = null;
            } catch (RuntimeException e) {
                e = e;
            }
        } catch (zzat e2) {
            e = e2;
        } catch (zzhq e3) {
            e = e3;
        } catch (zzjk e4) {
            e = e4;
        } catch (zzuf e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        }
        switch (message.what) {
            case 1:
                boolean z4 = message.arg1 != 0;
                int i3 = message.arg2;
                zzE(z4, i3 >> 4, true, i3 & 15);
                z = true;
                zzC();
                return z;
            case 2:
                z = true;
                long jUptimeMillis = SystemClock.uptimeMillis();
                this.zzi.zzk(2);
                boolean z5 = this.zzA;
                if (!z5) {
                    zzai();
                }
                int i4 = this.zzH.zze;
                if (i4 != 1 && i4 != 4) {
                    if (z5) {
                        zzai();
                    }
                    zzmf zzmfVar2 = this.zzs;
                    zzmc zzmcVarZzm = zzmfVar2.zzm();
                    if (zzmcVarZzm == null) {
                        zzQ(jUptimeMillis);
                    } else {
                        Trace.beginSection("doSomeWork");
                        zzL();
                        if (zzmcVarZzm.zze) {
                            this.zzV = zzfl.zzs(SystemClock.elapsedRealtime());
                            zzmcVarZzm.zza.zzf(this.zzH.zzs - this.zzn, false);
                            int i5 = 0;
                            z2 = true;
                            z3 = true;
                            while (true) {
                                zzne[] zzneVarArr = this.zzb;
                                if (i5 < i2) {
                                    zzne zzneVar = zzneVarArr[i5];
                                    if (zzneVar.zzd() == 0) {
                                        zzN(i5, false);
                                    } else {
                                        zzneVar.zzs(this.zzU, this.zzV);
                                        boolean z6 = z2 && zzneVar.zzo();
                                        boolean zZzt = zzneVar.zzt(zzmcVarZzm);
                                        zzN(i5, zZzt);
                                        boolean z7 = z3 && zZzt;
                                        if (!zZzt) {
                                            zzaz(i5);
                                        }
                                        z3 = z7;
                                        z2 = z6;
                                    }
                                    i5++;
                                    i2 = 2;
                                }
                            }
                        } else {
                            zzmcVarZzm.zza.zzc();
                            z2 = true;
                            z3 = true;
                        }
                        long j2 = zzmcVarZzm.zzg.zzf;
                        if (z2 && zzmcVarZzm.zze && (j2 == -9223372036854775807L || j2 <= this.zzH.zzs)) {
                            if (this.zzL) {
                                this.zzL = false;
                                zzE(false, this.zzH.zzn, false, 5);
                            }
                            if (zzmcVarZzm.zzg.zzk) {
                                zzB(4);
                                zzK();
                                j = -9223372036854775807L;
                            }
                            int i6 = 2;
                            if (this.zzH.zze == 2) {
                            }
                        } else {
                            zzms zzmsVar = this.zzH;
                            if (zzmsVar.zze != 2) {
                                j = -9223372036854775807L;
                                if (this.zzH.zze == 3) {
                                    if (this.zzS == 0) {
                                        if (!zzae()) {
                                            zzaD(zzay(), false);
                                            zzB(2);
                                            if (this.zzM) {
                                                for (zzmc zzmcVarZzm2 = zzmfVar2.zzm(); zzmcVarZzm2 != null; zzmcVarZzm2 = zzmcVarZzm2.zzp()) {
                                                    for (zzaba zzabaVar : zzmcVarZzm2.zzr().zzc) {
                                                    }
                                                }
                                                this.zzae.zzc();
                                            }
                                            zzK();
                                        }
                                    } else if (!z3) {
                                        zzaD(zzay(), false);
                                        zzB(2);
                                        if (this.zzM) {
                                        }
                                        zzK();
                                    }
                                }
                                int i62 = 2;
                                if (this.zzH.zze == 2) {
                                    int i7 = 0;
                                    while (true) {
                                        zzne[] zzneVarArr2 = this.zzb;
                                        if (i7 < i62) {
                                            if (zzneVarArr2[i7].zzp(zzmcVarZzm)) {
                                                zzaz(i7);
                                            }
                                            i7++;
                                            i62 = 2;
                                        } else {
                                            zzms zzmsVar2 = this.zzH;
                                            if (zzmsVar2.zzg || zzmsVar2.zzr >= 500000 || !zzaG(zzmfVar2.zzk()) || !zzay()) {
                                                this.zzZ = j;
                                            } else if (this.zzZ == j) {
                                                this.zzZ = SystemClock.elapsedRealtime();
                                            } else if (SystemClock.elapsedRealtime() - this.zzZ >= 4000) {
                                                throw new zzfd(0, 4000);
                                            }
                                            boolean z8 = zzay() && this.zzH.zze == 3;
                                            zzms zzmsVar3 = this.zzH;
                                            boolean z9 = zzmsVar3.zzp;
                                            int i8 = zzmsVar3.zze;
                                            if (i8 != 4 && (z8 || i8 == 2 || (i8 == 3 && this.zzS != 0))) {
                                                zzQ(jUptimeMillis);
                                            }
                                            Trace.endSection();
                                            z = true;
                                        }
                                    }
                                }
                            } else {
                                if (this.zzS == 0) {
                                    zZzi = zzae();
                                    j = -9223372036854775807L;
                                } else {
                                    if (z3) {
                                        if (zzmsVar.zzg) {
                                            zzmc zzmcVarZzm3 = zzmfVar2.zzm();
                                            long jZze = zzP(this.zzH.zza, zzmcVarZzm3.zzg.zza) ? this.zzae.zze() : -9223372036854775807L;
                                            zzmc zzmcVarZzk = zzmfVar2.zzk();
                                            boolean z10 = zzmcVarZzk.zzd() && zzmcVarZzk.zzg.zzk;
                                            boolean z11 = zzmcVarZzk.zzg.zza.zzb() && !zzmcVarZzk.zze;
                                            if (!z10 && !z11) {
                                                j = -9223372036854775807L;
                                                zZzi = this.zzg.zzi(new zzlx(this.zzv, this.zzH.zza, zzmcVarZzm3.zzg.zza, this.zzU - zzmcVarZzm3.zza(), zzav(zzmcVarZzk.zzf()), this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, jZze, this.zzN));
                                            }
                                        }
                                        j = -9223372036854775807L;
                                        zzB(3);
                                        this.zzY = null;
                                        if (zzay()) {
                                            zzaD(false, false);
                                            this.zzo.zza();
                                            zzJ();
                                        }
                                        int i622 = 2;
                                        if (this.zzH.zze == 2) {
                                        }
                                    }
                                    j = -9223372036854775807L;
                                    if (this.zzH.zze == 3) {
                                    }
                                    int i6222 = 2;
                                    if (this.zzH.zze == 2) {
                                    }
                                }
                                if (zZzi) {
                                    zzB(3);
                                    this.zzY = null;
                                    if (zzay()) {
                                    }
                                } else if (this.zzH.zze == 3) {
                                }
                                int i62222 = 2;
                                if (this.zzH.zze == 2) {
                                }
                            }
                        }
                    }
                }
                zzC();
                return z;
            case 3:
                z = true;
                zzR((zzlt) message.obj);
                zzC();
                return z;
            case 4:
                z = true;
                zzM((zzav) message.obj);
                zzal(this.zzo.zzj(), true);
                zzC();
                return z;
            case 5:
                z = true;
                this.zzB = (zzni) message.obj;
                zzC();
                return z;
            case 6:
                z = true;
                zzW(false, true);
                zzC();
                return z;
            case 7:
                zzds zzdsVar = (zzds) message.obj;
                try {
                    zzX(true, false, true, false);
                    int i9 = 0;
                    while (true) {
                        zzne[] zzneVarArr3 = this.zzb;
                        if (i9 >= 2) {
                            this.zzg.zzd(this.zzv);
                            this.zzz.zzd();
                            this.zze.zzb();
                            zzB(1);
                            this.zzi.zzl(null);
                            this.zzj.zzb();
                            zzdsVar.zza();
                            return true;
                        }
                        this.zzc[i9].zzw();
                        zzneVarArr3[i9].zzI();
                        i9++;
                    }
                } finally {
                    this.zzi.zzl(null);
                    this.zzj.zzb();
                    zzdsVar.zza();
                }
                break;
            case 8:
                try {
                    try {
                        zzxiVar = (zzxi) message.obj;
                        zzmfVar = this.zzs;
                    } catch (zzjk e7) {
                        e = e7;
                    } catch (RuntimeException e8) {
                        e = e8;
                    }
                } catch (zzat e9) {
                    e = e9;
                    zzA(e, e.zzb == 1 ? true != e.zza ? 3003 : AdError.MEDIATION_ERROR_CODE : 1000);
                    z = true;
                } catch (zzhq e10) {
                    e = e10;
                    zzA(e, e.zza);
                    z = true;
                } catch (zzuf e11) {
                    e = e11;
                    zzA(e, e.zza);
                    z = true;
                } catch (IOException e12) {
                    e = e12;
                    zzA(e, 2000);
                    z = true;
                }
                if (zzmfVar.zzd(zzxiVar)) {
                    zzmc zzmcVarZzk2 = zzmfVar.zzk();
                    if (zzmcVarZzk2 == null) {
                        throw null;
                    }
                    if (!zzmcVarZzk2.zze) {
                        float f = this.zzo.zzj().zzb;
                        zzms zzmsVar4 = this.zzH;
                        zzmcVarZzk2.zzh(f, zzmsVar4.zza, zzmsVar4.zzl);
                    }
                    zzax(zzmcVarZzk2.zzg.zza, zzmcVarZzk2.zzq(), zzmcVarZzk2.zzr());
                    if (zzmcVarZzk2 == zzmfVar.zzm()) {
                        zzU(zzmcVarZzk2.zzg.zzb, true);
                        zzaq();
                        zzmcVarZzk2.zzh = true;
                        zzms zzmsVar5 = this.zzH;
                        try {
                            zzxk zzxkVar2 = zzmsVar5.zzb;
                            long j3 = zzmcVarZzk2.zzg.zzb;
                            z = true;
                            this.zzH = zzap(zzxkVar2, j3, zzmsVar5.zzc, j3, false, 5);
                        } catch (zzjk e13) {
                            e = e13;
                            if (e.zzc == 1) {
                                e = e.zzd(zzmcVarZzn.zzg.zza);
                            }
                            if (e.zzc == 1) {
                                zzjkVar = this.zzY;
                                if (zzjkVar != null) {
                                }
                                if (e.zzc == 1) {
                                }
                                if (e.zzi) {
                                }
                                zzeg.zzf("ExoPlayerImplInternal", "Playback error", e);
                                z = true;
                                zzW(true, false);
                                this.zzH = this.zzH.zzf(e);
                            }
                        } catch (RuntimeException e14) {
                            e = e14;
                            zzjk zzjkVarZzc = zzjk.zzc(e, ((e instanceof IllegalStateException) || (e instanceof IllegalArgumentException)) ? 1004 : 1000);
                            zzeg.zzf("ExoPlayerImplInternal", "Playback error", zzjkVarZzc);
                            zzW(true, false);
                            this.zzH = this.zzH.zzf(zzjkVarZzc);
                            z = true;
                        }
                    } else {
                        z = true;
                    }
                    zzan();
                    if (e.zzc == 1 && (zzmcVarZzn = this.zzs.zzn()) != null && e.zzh == null) {
                        e = e.zzd(zzmcVarZzn.zzg.zza);
                    }
                    if (e.zzc == 1 || (zzxkVar = e.zzh) == null) {
                        zzjkVar = this.zzY;
                        if (zzjkVar != null) {
                            zzjkVar.addSuppressed(e);
                            e = this.zzY;
                        }
                        if (e.zzc == 1) {
                            zzmf zzmfVar3 = this.zzs;
                            if (zzmfVar3.zzm() != zzmfVar3.zzn()) {
                                while (zzmfVar3.zzm() != zzmfVar3.zzn()) {
                                    zzmfVar3.zzr();
                                }
                                zzmc zzmcVarZzm4 = zzmfVar3.zzm();
                                zzmcVarZzm4.getClass();
                                zzC();
                                zzmd zzmdVar = zzmcVarZzm4.zzg;
                                zzxk zzxkVar3 = zzmdVar.zza;
                                long j4 = zzmdVar.zzb;
                                this.zzH = zzap(zzxkVar3, j4, zzmdVar.zzd, j4, true, 0);
                            }
                        }
                        if (e.zzi || !(this.zzY == null || (i = e.zza) == 5004 || i == 5003)) {
                            zzeg.zzf("ExoPlayerImplInternal", "Playback error", e);
                            z = true;
                            zzW(true, false);
                            this.zzH = this.zzH.zzf(e);
                        } else {
                            zzeg.zzd("ExoPlayerImplInternal", "Recoverable renderer error", e);
                            if (this.zzY == null) {
                                this.zzY = e;
                            }
                            zzdz zzdzVar = this.zzi;
                            zzdzVar.zzg(zzdzVar.zzd(25, e));
                            z = true;
                        }
                    } else {
                        int i10 = e.zze;
                        zzmf zzmfVar4 = this.zzs;
                        if (zzmfVar4.zzo() != null && zzmfVar4.zzo().zzg.zza.equals(zzxkVar) && this.zzb[i10].zzq(zzmfVar4.zzo())) {
                            this.zzac = true;
                            zzab();
                            zzmc zzmcVarZzo = zzmfVar4.zzo();
                            zzmc zzmcVarZzm5 = zzmfVar4.zzm();
                            if (zzmfVar4.zzm() != zzmcVarZzo) {
                                while (zzmcVarZzm5 != null && zzmcVarZzm5.zzp() != zzmcVarZzo) {
                                    zzmcVarZzm5 = zzmcVarZzm5.zzp();
                                }
                            }
                            zzmfVar4.zzs(zzmcVarZzm5);
                            if (this.zzH.zze != 4) {
                                zzan();
                                this.zzi.zzh(2);
                            }
                        }
                        z = true;
                    }
                } else {
                    z = true;
                    zzmc zzmcVarZzu = zzmfVar.zzu(zzxiVar);
                    if (zzmcVarZzu != null) {
                        zzgtj.zzi(!zzmcVarZzu.zze);
                        float f2 = this.zzo.zzj().zzb;
                        zzms zzmsVar6 = this.zzH;
                        zzmcVarZzu.zzh(f2, zzmsVar6.zza, zzmsVar6.zzl);
                        if (zzmfVar.zze(zzxiVar)) {
                            zzaj();
                        }
                    }
                }
                zzC();
                return z;
            case 9:
                zzxi zzxiVar2 = (zzxi) message.obj;
                zzmf zzmfVar5 = this.zzs;
                if (zzmfVar5.zzd(zzxiVar2)) {
                    zzmfVar5.zzf(this.zzU);
                    zzan();
                } else if (zzmfVar5.zze(zzxiVar2)) {
                    zzaj();
                }
                z = true;
                zzC();
                return z;
            case 10:
                zzad();
                z = true;
                zzC();
                return z;
            case 11:
                int i11 = message.arg1;
                this.zzP = i11;
                int iZza = this.zzs.zza(this.zzH.zza, i11);
                if ((iZza & 1) != 0) {
                    zzI(true);
                } else if ((iZza & 2) != 0) {
                    zzab();
                }
                zzat(false);
                z = true;
                zzC();
                return z;
            case 12:
                boolean z12 = message.arg1 != 0;
                this.zzQ = z12;
                int iZzb = this.zzs.zzb(this.zzH.zza, z12);
                if ((iZzb & 1) != 0) {
                    zzI(true);
                } else if ((iZzb & 2) != 0) {
                    zzab();
                }
                zzat(false);
                z = true;
                zzC();
                return z;
            case 13:
                boolean z13 = message.arg1 != 0;
                zzds zzdsVar2 = (zzds) message.obj;
                if (this.zzR != z13) {
                    this.zzR = z13;
                    if (!z13) {
                        zzne[] zzneVarArr4 = this.zzb;
                        for (int i12 = 0; i12 < 2; i12++) {
                            zzneVarArr4[i12].zzG();
                        }
                    }
                }
                if (zzdsVar2 != null) {
                    zzdsVar2.zza();
                }
                z = true;
                zzC();
                return z;
            case 14:
                zzmw zzmwVar = (zzmw) message.obj;
                if (zzmwVar.zzf() == this.zzk) {
                    zzaF(zzmwVar);
                    int i13 = this.zzH.zze;
                    if (i13 == 3 || i13 == 2) {
                        this.zzi.zzh(2);
                    }
                } else {
                    this.zzi.zzd(15, zzmwVar).zza();
                }
                z = true;
                zzC();
                return z;
            case 15:
                final zzmw zzmwVar2 = (zzmw) message.obj;
                Looper looperZzf = zzmwVar2.zzf();
                if (looperZzf.getThread().isAlive()) {
                    this.zzq.zzd(looperZzf, null).zzm(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzlm
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzlu.zzz(zzmwVar2);
                        }
                    });
                } else {
                    zzeg.zzc("TAG", "Trying to send message on a dead thread.");
                    zzmwVar2.zzi(false);
                }
                z = true;
                zzC();
                return z;
            case 16:
                zzal((zzav) message.obj, false);
                z = true;
                zzC();
                return z;
            case 17:
                zzlo zzloVar = (zzlo) message.obj;
                this.zzI.zza(1);
                if (zzloVar.zzb() != -1) {
                    this.zzT = new zzlt(new zzmy(zzloVar.zza(), zzloVar.zzd()), zzloVar.zzb(), zzloVar.zzc());
                }
                zzaf(this.zzt.zzl(zzloVar.zza(), zzloVar.zzd()), false);
                z = true;
                zzC();
                return z;
            case 18:
                zzlo zzloVar2 = (zzlo) message.obj;
                int iZzc = message.arg1;
                this.zzI.zza(1);
                zzmr zzmrVar = this.zzt;
                if (iZzc == -1) {
                    iZzc = zzmrVar.zzc();
                }
                zzaf(zzmrVar.zzm(iZzc, zzloVar2.zza(), zzloVar2.zzd()), false);
                z = true;
                zzC();
                return z;
            case 19:
                zzba$$ExternalSyntheticOutline0.m(message.obj);
                this.zzI.zza(1);
                throw null;
            case 20:
                int i14 = message.arg1;
                int i15 = message.arg2;
                zzzf zzzfVar = (zzzf) message.obj;
                this.zzI.zza(1);
                zzaf(this.zzt.zzn(i14, i15, zzzfVar), false);
                z = true;
                zzC();
                return z;
            case 21:
                zzzf zzzfVar2 = (zzzf) message.obj;
                this.zzI.zza(1);
                zzaf(this.zzt.zzp(zzzfVar2), false);
                z = true;
                zzC();
                return z;
            case 22:
                zzaf(this.zzt.zzh(), true);
                z = true;
                zzC();
                return z;
            case 23:
                this.zzK = message.arg1 != 0;
                zzak();
                if (this.zzL) {
                    zzmf zzmfVar6 = this.zzs;
                    if (zzmfVar6.zzn() != zzmfVar6.zzm()) {
                        zzI(true);
                        zzat(false);
                    }
                }
                z = true;
                zzC();
                return z;
            case 24:
            default:
                return false;
            case 25:
                zzac();
                z = true;
                zzC();
                return z;
            case 26:
                zzac();
                z = true;
                zzC();
                return z;
            case 27:
                int i16 = message.arg1;
                int i17 = message.arg2;
                List list = (List) message.obj;
                this.zzI.zza(1);
                zzaf(this.zzt.zza(i16, i17, list), false);
                z = true;
                zzC();
                return z;
            case 28:
                zzju zzjuVar = (zzju) message.obj;
                this.zzaa = zzjuVar;
                this.zzs.zzc(this.zzH.zza, zzjuVar);
                z = true;
                zzC();
                return z;
            case 29:
                this.zzI.zza(1);
                zzX(false, false, false, true);
                this.zzg.zza(this.zzv);
                zzB(true != this.zzH.zza.zzg() ? 2 : 4);
                zzF();
                this.zzt.zzd(this.zzh.zze());
                this.zzi.zzh(2);
                z = true;
                zzC();
                return z;
            case 30:
                Pair pair = (Pair) message.obj;
                Object obj = pair.first;
                zzds zzdsVar3 = (zzds) pair.second;
                zzne[] zzneVarArr5 = this.zzb;
                for (int i18 = 0; i18 < 2; i18++) {
                    zzneVarArr5[i18].zzJ(obj);
                }
                int i19 = this.zzH.zze;
                if (i19 == 3 || i19 == 2) {
                    this.zzi.zzh(2);
                }
                if (zzdsVar3 != null) {
                    zzdsVar3.zza();
                }
                z = true;
                zzC();
                return z;
            case 31:
                zzd zzdVar2 = (zzd) message.obj;
                int i20 = message.arg1;
                this.zze.zze(zzdVar2);
                zzcd zzcdVar = this.zzz;
                if (i20 != 0) {
                    zzdVar = zzdVar2;
                }
                zzcdVar.zzb(zzdVar);
                zzF();
                z = true;
                zzC();
                return z;
            case 32:
                zzD(((Float) message.obj).floatValue());
                z = true;
                zzC();
                return z;
            case 33:
                int i21 = message.arg1;
                zzms zzmsVar7 = this.zzH;
                zzH(zzmsVar7.zzl, i21, zzmsVar7.zzn, zzmsVar7.zzm);
                z = true;
                zzC();
                return z;
            case 34:
                zzD(this.zzad);
                z = true;
                zzC();
                return z;
            case 35:
                zzadr zzadrVar = (zzadr) message.obj;
                zzne[] zzneVarArr6 = this.zzb;
                for (int i22 = 0; i22 < 2; i22++) {
                    zzneVarArr6[i22].zzK(zzadrVar);
                }
                z = true;
                zzC();
                return z;
            case 36:
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                if (!zBooleanValue) {
                    if (this.zzF != null && this.zzE && !this.zzi.zzb(37)) {
                        this.zzG++;
                    }
                    final int i23 = this.zzG;
                    if (i23 > 0) {
                        this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzll
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzv(i23);
                            }
                        });
                    }
                    this.zzG = 0;
                    this.zzE = false;
                    this.zzi.zzk(37);
                    zzlt zzltVar = this.zzF;
                    if (zzltVar != null) {
                        zzR(zzltVar);
                        this.zzF = null;
                        this.zzE = false;
                    }
                }
                this.zzD = zBooleanValue;
                zzV();
                z = true;
                zzC();
                return z;
            case 37:
                this.zzE = false;
                zzlt zzltVar2 = this.zzF;
                if (zzltVar2 != null) {
                    zzR(zzltVar2);
                    this.zzF = null;
                }
                z = true;
                zzC();
                return z;
            case 38:
                this.zzC = (zznh) message.obj;
                zzV();
                z = true;
                zzC();
                return z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final void zza(float f) {
        this.zzi.zzh(34);
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final void zzb(int i) {
        this.zzi.zze(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzjh
    public final void zzc(zzav zzavVar) {
        this.zzi.zzd(16, zzavVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadr
    public final void zzcS(long j, long j2, zzv zzvVar, MediaFormat mediaFormat) {
        if (this.zzE) {
            this.zzi.zzc(37).zza();
        }
    }

    public final void zzd() {
        this.zzi.zzc(29).zza();
    }

    public final void zze(boolean z, int i, int i2) {
        this.zzi.zze(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzf(zzbf zzbfVar, int i, long j) {
        this.zzi.zzd(3, new zzlt(zzbfVar, i, j)).zza();
    }

    public final void zzg(zznh zznhVar) {
        this.zzi.zzd(38, zznhVar).zza();
    }

    public final void zzh() {
        this.zzi.zzc(6).zza();
    }

    public final void zzi(zzd zzdVar, boolean z) {
        this.zzi.zzf(31, 0, 0, zzdVar).zza();
    }

    public final void zzj(float f) {
        this.zzi.zzd(32, Float.valueOf(f)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzmu
    public final void zzk(zzmw zzmwVar) {
        if (!this.zzJ && this.zzk.getThread().isAlive()) {
            this.zzi.zzd(14, zzmwVar).zza();
        } else {
            zzeg.zzc("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzmwVar.zzi(false);
        }
    }

    public final boolean zzl(Object obj, long j) {
        if (this.zzJ || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzds zzdsVar = new zzds(this.zzq);
        this.zzi.zzd(30, new Pair(obj, zzdsVar)).zza();
        if (j != -9223372036854775807L) {
            return zzdsVar.zze(j);
        }
        return true;
    }

    public final boolean zzm() {
        if (this.zzJ || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzJ = true;
        zzds zzdsVar = new zzds(this.zzq);
        this.zzi.zzd(7, zzdsVar).zza();
        return zzdsVar.zze(this.zzu);
    }

    public final Looper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final void zzo() {
        zzdz zzdzVar = this.zzi;
        zzdzVar.zzk(2);
        zzdzVar.zzh(22);
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        this.zzi.zzd(8, zzxiVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabg
    public final void zzq() {
        this.zzi.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        this.zzi.zzd(9, (zzxi) zzzeVar).zza();
    }

    public final /* synthetic */ zzmc zzt(zzmd zzmdVar, long j) {
        zzabl zzablVarZze = this.zzg.zze(this.zzv);
        long j2 = this.zzaa.zzb;
        zzabi zzabiVar = this.zzf;
        zzmr zzmrVar = this.zzt;
        return new zzmc(this.zzc, j, this.zze, zzablVarZze, zzmrVar, zzmdVar, zzabiVar, -9223372036854775807L);
    }

    public final /* synthetic */ void zzu(int i, boolean z) {
        this.zzw.zzB(i, this.zzb[i].zze(), z);
    }

    public final /* synthetic */ void zzv(int i) {
        this.zzw.zzW(i);
    }

    public final /* synthetic */ zzdz zzx() {
        return this.zzi;
    }

    public final void zzy(List list, int i, long j, zzzf zzzfVar) {
        this.zzi.zzd(17, new zzlo(list, zzzfVar, i, j, null)).zza();
    }
}
