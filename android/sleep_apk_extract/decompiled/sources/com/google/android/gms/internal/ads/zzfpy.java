package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfpy implements zzfpw {
    private final Context zza;
    private final int zzp;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzq = 2;
    private int zzr = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzfql zzj = zzfql.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;

    public zzfpy(Context context, int i) {
        this.zza = context;
        this.zzp = i;
    }

    public final /* synthetic */ long zzA() {
        return this.zzb;
    }

    public final /* synthetic */ long zzB() {
        return this.zzc;
    }

    public final /* synthetic */ boolean zzC() {
        return this.zzd;
    }

    public final /* synthetic */ int zzD() {
        return this.zze;
    }

    public final /* synthetic */ String zzE() {
        return this.zzf;
    }

    public final /* synthetic */ String zzF() {
        return this.zzg;
    }

    public final /* synthetic */ String zzG() {
        return this.zzh;
    }

    public final /* synthetic */ String zzH() {
        return this.zzi;
    }

    public final /* synthetic */ zzfql zzI() {
        return this.zzj;
    }

    public final /* synthetic */ String zzJ() {
        return this.zzk;
    }

    public final /* synthetic */ String zzK() {
        return this.zzl;
    }

    public final /* synthetic */ String zzL() {
        return this.zzm;
    }

    public final synchronized zzfpy zzM(int i) {
        this.zzq = i;
        return this;
    }

    public final /* synthetic */ int zzN() {
        return this.zzp;
    }

    public final /* synthetic */ int zzO() {
        return this.zzq;
    }

    public final /* synthetic */ int zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zza() {
        zzq();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final synchronized boolean zzb() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzc() {
        zzr();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzd(boolean z) {
        zzs(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zze(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzf(zzfql zzfqlVar) {
        zzu(zzfqlVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzg(zzfkp zzfkpVar) {
        zzv(zzfkpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzw(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzi(String str) {
        zzx(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzj(Throwable th) {
        zzy(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzk(String str) {
        zzz(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final synchronized zzfpz zzm() {
        try {
            if (this.zzn) {
                return null;
            }
            this.zzn = true;
            if (!this.zzo) {
                zzq();
            }
            if (this.zzc < 0) {
                zzr();
            }
            return new zzfpz(this, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpw
    public final /* bridge */ /* synthetic */ zzfpw zzp(int i) {
        zzM(i);
        return this;
    }

    public final synchronized zzfpy zzq() {
        Configuration configuration;
        com.google.android.gms.ads.internal.util.zzz zzzVarZzf = com.google.android.gms.ads.internal.zzt.zzf();
        Context context = this.zza;
        this.zze = zzzVarZzf.zzm(context);
        Resources resources = context.getResources();
        int i = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzr = i;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        this.zzo = true;
        return this;
    }

    public final synchronized zzfpy zzr() {
        this.zzc = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        return this;
    }

    public final synchronized zzfpy zzs(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfpy zzt(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfpy zzu(zzfql zzfqlVar) {
        this.zzj = zzfqlVar;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r2.zzg = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized zzfpy zzv(zzfkp zzfkpVar) {
        try {
            String str = zzfkpVar.zzb.zzb;
            if (!TextUtils.isEmpty(str)) {
                this.zzf = str;
            }
            Iterator it = zzfkpVar.zza.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str2 = ((zzfkf) it.next()).zzab;
                if (!TextUtils.isEmpty(str2)) {
                    break;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfpy zzw(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            IBinder iBinder = zzeVar.zze;
            if (iBinder != null) {
                zzdck zzdckVar = (zzdck) iBinder;
                String strZzk = zzdckVar.zzk();
                if (!TextUtils.isEmpty(strZzk)) {
                    this.zzf = strZzk;
                }
                String strZzf = zzdckVar.zzf();
                if (!TextUtils.isEmpty(strZzf)) {
                    this.zzg = strZzf;
                }
            }
        } finally {
        }
        return this;
    }

    public final synchronized zzfpy zzx(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfpy zzy(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkd)).booleanValue()) {
            this.zzl = zzbzy.zzf(th);
            this.zzk = (String) zzgty.zza(zzgsx.zzc('\n')).zzd(zzbzy.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfpy zzz(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkd)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }
}
