package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgmq implements zzgme {
    private final Context zza;
    private final ExecutorService zzb;
    private final zzgee zzc;
    private final String zzd;
    private final String zze;
    private final zzgqh zzf;
    private final zzgms zzg;
    private final int zzh;

    public zzgmq(Context context, ExecutorService executorService, zzgdf zzgdfVar, zzgee zzgeeVar, zzgqh zzgqhVar, zzgms zzgmsVar) {
        this.zza = context;
        this.zzb = executorService;
        this.zzc = zzgeeVar;
        this.zzf = zzgqhVar;
        this.zzg = zzgmsVar;
        this.zzd = zzgdfVar.zzd();
        this.zzh = zzbdv.zzb(zzgde.zza(zzgdfVar.zzI()));
        this.zze = zzgdfVar.zzk().zzc();
    }

    private static zzgfo zze(int i) {
        zzgfn zzgfnVarZzd = zzgfo.zzd();
        zzgfnVarZzd.zzd(i);
        return (zzgfo) zzgfnVarZzd.zzbm();
    }

    @Override // com.google.android.gms.internal.ads.zzgme
    public final ListenableFuture zza() {
        int i;
        zzbdj zzbdjVarZza = zzbdk.zza();
        byte[] bArrZza = zzava.zza();
        zzida zzidaVar = zzida.zza;
        zzbdjVarZza.zza(zzida.zzt(bArrZza, 0, bArrZza.length));
        zzbdjVarZza.zzb(Build.VERSION.SDK_INT);
        zzbdjVarZza.zzc(Build.MODEL);
        Context context = this.zza;
        zzbdjVarZza.zzd(context.getPackageName());
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            i = -1;
        }
        zzgee zzgeeVar = this.zzc;
        zzgqh zzgqhVar = this.zzf;
        zzbdjVarZza.zze(i);
        zzbdjVarZza.zzf(this.zzd);
        zzbdjVarZza.zzg(3);
        zzbdjVarZza.zzh(this.zzh);
        zzhbo zzhboVar = (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk(zzhbo.zzw(zzgeeVar.zza(Uri.parse(this.zze).buildUpon().appendQueryParameter("aspq", zzgea.zza(((zzbdk) zzbdjVarZza.zzbm()).zzaN(), true)).build().toString())), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgmp
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzb((zzged) obj);
            }
        }, this.zzb), UnknownHostException.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzgmn
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((UnknownHostException) obj);
            }
        }, zzhcn.zza()), SocketException.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzgmo
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzd((SocketException) obj);
            }
        }, zzhcn.zza());
        zzgqhVar.zze(20002, zzhboVar);
        return zzhboVar;
    }

    public final /* synthetic */ zzgfo zzb(zzged zzgedVar) {
        if (zzgedVar.zza() != 200) {
            this.zzf.zzc(20003, new String(zzava.zza(), StandardCharsets.UTF_8));
            return zze(7);
        }
        try {
            String strZzb = zzgedVar.zzb();
            if (TextUtils.isEmpty(strZzb)) {
                this.zzf.zzb(20004);
                return zze(8);
            }
            zzbdm zzbdmVarZzc = zzbdm.zzc(zzgea.zzb(strZzb, true), zzido.zzb());
            if (zzbdmVarZzc.zza().zzc() && zzbdmVarZzc.zza().zza()) {
                if (!this.zzg.zza(zzbdmVarZzc)) {
                    this.zzf.zzb(20006);
                    return zze(12);
                }
                zzgfn zzgfnVarZzd = zzgfo.zzd();
                zzgfp zzgfpVarZzg = zzgfq.zzg();
                zzgfpVarZzg.zzb(zzbdmVarZzc.zza().zzb());
                zzgfpVarZzg.zzd(zzbdmVarZzc.zzb());
                zzgfnVarZzd.zza((zzgfq) zzgfpVarZzg.zzbm());
                zzgfnVarZzd.zzb(zzbdmVarZzc.zza().zzd());
                zzgfnVarZzd.zzd(2);
                return (zzgfo) zzgfnVarZzd.zzbm();
            }
            this.zzf.zzb(20004);
            return zze(8);
        } catch (Throwable th) {
            this.zzf.zzd(20005, th);
            return zze(6);
        }
    }

    public final /* synthetic */ zzgfo zzc(UnknownHostException unknownHostException) {
        this.zzf.zzb(20007);
        return zze(13);
    }

    public final /* synthetic */ zzgfo zzd(SocketException socketException) {
        this.zzf.zzb(20008);
        return zze(13);
    }
}
