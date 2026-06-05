package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class zzgml implements zzgme {
    private final Context zza;
    private final zzimo zzb;
    private final zzgmv zzc;
    private final zzgqh zzd;
    private final ExecutorService zze;
    private final zzgla zzf;
    private final zzfxg zzg;

    public zzgml(Context context, zzimo zzimoVar, zzgmv zzgmvVar, zzgqh zzgqhVar, ExecutorService executorService, zzgla zzglaVar, zzfxg zzfxgVar) {
        this.zza = context;
        this.zzb = zzimoVar;
        this.zzc = zzgmvVar;
        this.zzd = zzgqhVar;
        this.zze = executorService;
        this.zzf = zzglaVar;
        this.zzg = zzfxgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgfo zzf(int i) {
        zzgfn zzgfnVarZzd = zzgfo.zzd();
        zzgfnVarZzd.zzd(i);
        return (zzgfo) zzgfnVarZzd.zzbm();
    }

    @Override // com.google.android.gms.internal.ads.zzgme
    public final ListenableFuture zza() {
        final zzimo zzimoVar = this.zzb;
        Objects.requireNonNull(zzimoVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzgmg
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzimoVar.zzb();
            }
        };
        ExecutorService executorService = this.zze;
        zzhbo zzhboVar = (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzk(zzhbo.zzw(zzhbw.zzd(callable, executorService)), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgmk
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zzb((zzbds) obj);
                return new Integer(0);
            }
        }, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgmh
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Integer) obj);
            }
        }, zzhcn.zza()), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgmi
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzd((zzgfq) obj);
            }
        }, executorService), zzgmf.class, zzgmj.zza, zzhcn.zza());
        this.zzd.zze(15202, zzhboVar);
        return zzhboVar;
    }

    public final /* synthetic */ int zzb(zzbds zzbdsVar) {
        if (zzfyd.zza(zzbdsVar)) {
            return 0;
        }
        this.zzd.zzc(15204, zzbdsVar.name());
        throw new zzgmf(null);
    }

    public final /* synthetic */ ListenableFuture zzc(Integer num) {
        return this.zzc.zzb();
    }

    public final /* synthetic */ zzgfo zzd(zzgfq zzgfqVar) {
        String strZza = zzgfqVar.zza().zza();
        String strZzb = zzgfqVar.zza().zzb();
        zzgqf zzgqfVarZza = this.zzd.zza(15203);
        try {
            zzgqfVarZza.zza();
            zzfyu zzfyuVarZza = zzfxp.zza(this.zza, 1, (zzbds) this.zzb.zzb(), strZza, strZzb, AppEventsConstants.EVENT_PARAM_VALUE_YES, this.zzg);
            zzgqfVarZza.zzc();
            int i = 2;
            if (zzfyuVarZza.zzc == 2) {
                this.zzd.zzb(15208);
                return zzf(4);
            }
            byte[] bArr = zzfyuVarZza.zzb;
            if (bArr == null || bArr.length == 0) {
                this.zzd.zzb(5010);
                return zzf(8);
            }
            try {
                zzbdu zzbduVarZze = zzbdu.zze(bArr, zzido.zzb());
                if (zzbduVarZze.zza().zza().isEmpty() || zzbduVarZze.zza().zzb().isEmpty() || zzbduVarZze.zzc().zzA().length == 0) {
                    this.zzd.zzb(15207);
                } else {
                    if (zzgfqVar.equals(zzgfq.zzh()) || !TextUtils.equals(zzgfqVar.zza().zza(), zzbduVarZze.zza().zza()) || !TextUtils.equals(zzgfqVar.zza().zzb(), zzbduVarZze.zza().zzb())) {
                        int i2 = zzfyuVarZza.zzc;
                        if (i2 == 4) {
                            if (!this.zzf.zza(zzbduVarZze.zzb().zzA())) {
                                this.zzd.zzb(15206);
                                return zzf(12);
                            }
                            i2 = 4;
                        }
                        zzgfn zzgfnVarZzd = zzgfo.zzd();
                        if (i2 == 2) {
                            i = 4;
                        } else if (i2 != 3) {
                            i = i2 != 4 ? i2 != 6 ? 1 : 5 : 3;
                        }
                        zzgfnVarZzd.zzd(i);
                        zzgfp zzgfpVarZzg = zzgfq.zzg();
                        zzgfpVarZzg.zza(zzbduVarZze.zza());
                        zzgfpVarZzg.zzc((zzbds) this.zzb.zzb());
                        zzgfnVarZzd.zza((zzgfq) zzgfpVarZzg.zzbm());
                        zzgfnVarZzd.zzc(zzbduVarZze.zzb());
                        zzgfnVarZzd.zzb(zzbduVarZze.zzc());
                        return (zzgfo) zzgfnVarZzd.zzbm();
                    }
                    this.zzd.zzb(15209);
                }
                return zzf(11);
            } catch (zziet e) {
                this.zzd.zzd(15205, e);
                return zzf(9);
            } catch (NullPointerException unused) {
                this.zzd.zzb(15210);
                return zzf(10);
            }
        } catch (Throwable th) {
            try {
                zzgqfVarZza.zzb(th);
                throw th;
            } catch (Throwable th2) {
                zzgqfVarZza.zzc();
                throw th2;
            }
        }
    }
}
