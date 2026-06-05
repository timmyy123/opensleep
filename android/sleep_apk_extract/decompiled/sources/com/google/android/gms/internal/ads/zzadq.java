package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadq implements zzbt {
    private final Context zza;
    private final zzbs zzb;
    private final SparseArray zzc;
    private final boolean zzd;
    private final zzaeu zze;
    private final zzdo zzf;
    private final CopyOnWriteArraySet zzg;
    private final long zzh;
    private final zzadv zzi;
    private zzfh zzj = new zzfh(10);
    private zzv zzk;
    private zzdz zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private long zzq;
    private int zzr;

    public /* synthetic */ zzadq(zzadi zzadiVar, byte[] bArr) {
        this.zza = zzadiVar.zze();
        zzbs zzbsVarZzg = zzadiVar.zzg();
        zzbsVarZzg.getClass();
        this.zzb = zzbsVarZzg;
        this.zzc = new SparseArray();
        zzgwm.zzi();
        this.zzd = zzadiVar.zzh();
        zzdo zzdoVarZzi = zzadiVar.zzi();
        this.zzf = zzdoVarZzi;
        this.zzh = -zzadiVar.zzj();
        zzadv zzadvVarZzk = zzadiVar.zzk();
        this.zzi = zzadvVarZzk;
        this.zze = new zzacv(zzadiVar.zzf(), zzadvVarZzk, zzdoVarZzi);
        new zzadh(this);
        this.zzg = new CopyOnWriteArraySet();
        this.zzk = new zzt().zzO();
        this.zzp = -9223372036854775807L;
        this.zzq = -9223372036854775807L;
        this.zzr = -1;
        this.zzo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zzi zzC(zzi zziVar) {
        return (zziVar == null || !zziVar.zzf()) ? zzi.zza : zziVar;
    }

    public final /* synthetic */ void zzA(long j) {
        this.zzq = j;
    }

    public final void zza(int i) {
        this.zzr = 1;
    }

    public final zzaeu zzb(int i) {
        SparseArray sparseArray = this.zzc;
        if (zzfl.zza(sparseArray, 0)) {
            return (zzaeu) sparseArray.get(0);
        }
        zzadk zzadkVar = new zzadk(this, this.zza, 0);
        this.zzg.add(zzadkVar);
        sparseArray.put(0, zzadkVar);
        return zzadkVar;
    }

    public final void zzc(Surface surface, zzeu zzeuVar) {
        Pair pair = this.zzm;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzeu) this.zzm.second).equals(zzeuVar)) {
            return;
        }
        this.zzm = Pair.create(surface, zzeuVar);
        zzeuVar.zza();
        zzeuVar.zzb();
    }

    public final void zzd() {
        zzeu zzeuVar = zzeu.zza;
        zzeuVar.zza();
        zzeuVar.zzb();
        this.zzm = null;
    }

    public final void zze() {
        this.zze.zza();
    }

    public final void zzf() {
        this.zze.zzb();
    }

    public final void zzg() {
        if (this.zzo == 2) {
            return;
        }
        zzdz zzdzVar = this.zzl;
        if (zzdzVar != null) {
            zzdzVar.zzl(null);
        }
        this.zzm = null;
        this.zzo = 2;
    }

    public final /* synthetic */ void zzh() {
        this.zzn--;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[Catch: zzdw -> 0x0033, TRY_LEAVE, TryCatch #0 {zzdw -> 0x0033, blocks: (B:7:0x0012, B:9:0x0017, B:11:0x001d, B:14:0x0025, B:18:0x0036, B:20:0x003c, B:23:0x0043, B:28:0x0067), top: B:34:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ boolean zzi(zzv zzvVar, int i) throws zzaet {
        zzgtj.zzi(this.zzo == 0);
        zzi zziVarZzC = zzC(zzvVar.zzF);
        try {
            int i2 = zziVarZzC.zzd;
            if (i2 != 7) {
                if (zzdx.zzc(i2) && Build.VERSION.SDK_INT >= 29) {
                    String str = zzfl.zza;
                    Locale locale = Locale.US;
                    zzeg.zzc("PlaybackVidGraphWrapper", "Color transfer " + i2 + " is not supported. Falling back to OpenGl tone mapping.");
                    zziVarZzC = zzi.zza;
                } else if (i2 != 2 || i2 == 10) {
                    zziVarZzC = zzi.zza;
                }
            } else if (Build.VERSION.SDK_INT >= 34 || !zzdx.zzd()) {
                i2 = 7;
                if (zzdx.zzc(i2)) {
                    if (i2 != 2) {
                        zziVarZzC = zzi.zza;
                    }
                }
            } else {
                zzh zzhVarZzd = zziVarZzC.zzd();
                zzhVarZzd.zzc(6);
                zziVarZzC = zzhVarZzd.zzg();
            }
            zzi zziVar = zziVarZzC;
            zzdo zzdoVar = this.zzf;
            Looper looperMyLooper = Looper.myLooper();
            looperMyLooper.getClass();
            final zzdz zzdzVarZzd = zzdoVar.zzd(looperMyLooper, null);
            this.zzl = zzdzVarZzd;
            zzbs zzbsVar = this.zzb;
            Context context = this.zza;
            zzl zzlVar = zzl.zzb;
            Objects.requireNonNull(zzdzVarZzd);
            zzbsVar.zza(context, zziVar, zzlVar, this, new Executor() { // from class: com.google.android.gms.internal.ads.zzadj
                @Override // java.util.concurrent.Executor
                public final /* synthetic */ void execute(Runnable runnable) {
                    zzdzVarZzd.zzm(runnable);
                }
            }, 0L, false);
            throw null;
        } catch (zzdw e) {
            throw new zzaet(e, zzvVar);
        }
    }

    public final /* synthetic */ boolean zzj(boolean z) {
        return this.zze.zzh(false);
    }

    public final /* synthetic */ void zzk() {
        this.zze.zzi();
    }

    public final /* synthetic */ void zzl(long j, long j2) {
        this.zze.zzv(j, j2);
    }

    public final /* synthetic */ void zzm(boolean z) {
        zzfh zzfhVar;
        if (this.zzo == 1) {
            this.zzn++;
            zzaeu zzaeuVar = this.zze;
            zzaeuVar.zzg(z);
            while (true) {
                int iZzc = this.zzj.zzc();
                zzfhVar = this.zzj;
                if (iZzc <= 1) {
                    break;
                } else {
                    zzfhVar.zzd();
                }
            }
            if (zzfhVar.zzc() == 1) {
                zzadp zzadpVar = (zzadp) this.zzj.zzd();
                zzadpVar.getClass();
                zzaeuVar.zzs(1, this.zzk, zzadpVar.zza, zzadpVar.zzb, zzgwm.zzi());
            }
            this.zzp = -9223372036854775807L;
            if (z) {
                this.zzq = -9223372036854775807L;
            }
            zzdz zzdzVar = this.zzl;
            zzdzVar.getClass();
            zzdzVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzadl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzh();
                }
            });
        }
    }

    public final /* synthetic */ void zzn(boolean z) {
        this.zze.zzw(z);
    }

    public final /* synthetic */ void zzo() {
        this.zze.zzt();
    }

    public final /* synthetic */ void zzp(zzadr zzadrVar) {
        this.zze.zzl(zzadrVar);
    }

    public final /* synthetic */ void zzq(float f) {
        this.zzi.zzc(f);
        this.zze.zzm(f);
    }

    public final /* synthetic */ void zzr(int i) {
        this.zze.zzr(i);
    }

    public final /* synthetic */ boolean zzs() {
        int i = this.zzr;
        return i != -1 && i == 0;
    }

    public final /* synthetic */ boolean zzt() {
        return this.zzd;
    }

    public final /* synthetic */ long zzu() {
        return this.zzh;
    }

    public final /* synthetic */ zzadv zzv() {
        return this.zzi;
    }

    public final /* synthetic */ zzfh zzw() {
        return this.zzj;
    }

    public final /* synthetic */ void zzx(zzfh zzfhVar) {
        this.zzj = zzfhVar;
    }

    public final /* synthetic */ long zzy() {
        return this.zzp;
    }

    public final /* synthetic */ long zzz() {
        return this.zzq;
    }
}
