package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjt {
    public static final /* synthetic */ int $r8$clinit = 0;
    final Context zza;
    zzdo zzb;
    zzgub zzc;
    zzgub zzd;
    zzgub zze;
    zzgub zzf;
    zzgub zzg;
    zzgta zzh;
    Looper zzi;
    int zzj;
    zzd zzk;
    int zzl;
    boolean zzm;
    zzni zzn;
    zznh zzo;
    long zzp;
    long zzq;
    int zzr;
    int zzs;
    int zzt;
    int zzu;
    boolean zzv;
    boolean zzw;
    String zzx;
    boolean zzy;
    zzjd zzz;

    static {
        String str = zzfl.zza;
        String strZza = zzgss.zza(Build.DEVICE);
        if (strZza.contains("emulator") || strZza.contains("emu64a") || strZza.contains("emu64x")) {
            return;
        }
        strZza.contains("generic");
    }

    public zzjt(final Context context, final zznf zznfVar) {
        zzgub zzgubVar = new zzgub() { // from class: com.google.android.gms.internal.ads.zzjs
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                int i = zzjt.$r8$clinit;
                return zznfVar;
            }
        };
        zzgub zzgubVar2 = new zzgub() { // from class: com.google.android.gms.internal.ads.zzjn
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                int i = zzjt.$r8$clinit;
                return new zzwx(context, new zzafu());
            }
        };
        zzgub zzgubVar3 = new zzgub() { // from class: com.google.android.gms.internal.ads.zzjo
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                int i = zzjt.$r8$clinit;
                return new zzaay(context);
            }
        };
        zzjm zzjmVar = zzjm.zza;
        zzgub zzgubVar4 = new zzgub() { // from class: com.google.android.gms.internal.ads.zzjp
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                int i = zzjt.$r8$clinit;
                return zzabt.zzh(context);
            }
        };
        zzjl zzjlVar = zzjl.zza;
        context.getClass();
        this.zza = context;
        this.zzc = zzgubVar;
        this.zzd = zzgubVar2;
        this.zze = zzgubVar3;
        this.zzf = zzjmVar;
        this.zzg = zzgubVar4;
        this.zzh = zzjlVar;
        this.zzi = zzfl.zzf();
        this.zzk = zzd.zza;
        this.zzl = 1;
        this.zzm = true;
        this.zzn = zzni.zzc;
        this.zzo = zznh.zza;
        this.zzz = new zzjd(0.97f, 1.03f, 1000L, 1.0E-7f, zzfl.zzs(20L), zzfl.zzs(500L), 0.999f, null);
        this.zzb = zzdo.zza;
        this.zzp = 500L;
        this.zzq = 2000L;
        this.zzr = 600000;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = Integer.MAX_VALUE;
        this.zzu = 600000;
        this.zzv = true;
        this.zzx = "";
        this.zzj = -1000;
        if (Build.VERSION.SDK_INT >= 35) {
            int i = zzjj.$r8$clinit;
        }
        this.zzy = true;
    }
}
