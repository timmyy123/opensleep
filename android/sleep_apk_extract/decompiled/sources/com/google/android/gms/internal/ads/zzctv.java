package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzctv implements zzdcr, zzdef, zzddl, com.google.android.gms.ads.internal.client.zza, zzddh, zzdkp, zzdfm {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzfkq zze;
    private final zzfkf zzf;
    private final zzfry zzg;
    private final zzfll zzh;
    private final zzbap zzi;
    private final zzbjx zzj;
    private final WeakReference zzk;
    private final WeakReference zzl;
    private final zzdbu zzm;
    private final zzdfg zzn;
    private final zzdbn zzo;
    private final Set zzp;
    private boolean zzq;
    private final AtomicBoolean zzr = new AtomicBoolean();
    private zzcfe zzs = null;

    public zzctv(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfkq zzfkqVar, zzfkf zzfkfVar, zzfry zzfryVar, zzfll zzfllVar, View view, zzcku zzckuVar, zzbap zzbapVar, zzbjx zzbjxVar, zzbjz zzbjzVar, zzfqg zzfqgVar, zzdbu zzdbuVar, zzdfg zzdfgVar, zzdbn zzdbnVar, Set set) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfkqVar;
        this.zzf = zzfkfVar;
        this.zzg = zzfryVar;
        this.zzh = zzfllVar;
        this.zzi = zzbapVar;
        this.zzk = new WeakReference(view);
        this.zzl = new WeakReference(zzckuVar);
        this.zzj = zzbjxVar;
        this.zzm = zzdbuVar;
        this.zzn = zzdfgVar;
        this.zzo = zzdbnVar;
        this.zzp = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public final List zzp() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmO)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            Context context = this.zza;
            if (com.google.android.gms.ads.internal.util.zzs.zzE(context)) {
                com.google.android.gms.ads.internal.zzt.zzc();
                Integer numZzu = com.google.android.gms.ads.internal.util.zzs.zzu(context);
                if (numZzu != null) {
                    int iMin = Math.min(numZzu.intValue(), 20);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.zzf.zzd.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Uri.parse((String) it.next()).buildUpon().appendQueryParameter("dspct", Integer.toString(iMin)).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    private final void zzy(final int i, final int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzo();
        } else {
            this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(i, i2);
                }
            }, i2, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public final void zzo() {
        String strZzj;
        int i;
        zzfkf zzfkfVar = this.zzf;
        List list = zzfkfVar.zzd;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpk)).booleanValue() && this.zzs == null) {
            this.zzs = com.google.android.gms.ads.internal.zzt.zzh().zzr().zzm(this.zzp, this.zze.zza.zza.zzg);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzet)).booleanValue()) {
            strZzj = this.zzi.zzb().zzj(this.zza, (View) this.zzk.get(), null);
        } else {
            strZzj = null;
        }
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbd)).booleanValue() && this.zze.zzb.zzb.zzh) || !((Boolean) zzbkp.zzh.zze()).booleanValue()) {
            this.zzh.zza(this.zzg.zzb(this.zze, zzfkfVar, false, strZzj, null, zzp(), this.zzo, this.zzs), this.zzn);
            return;
        }
        if (((Boolean) zzbkp.zzg.zze()).booleanValue() && ((i = zzfkfVar.zzb) == 1 || i == 2 || i == 5)) {
        }
        zzhbw.zzr((zzhbo) zzhbw.zzi(zzhbo.zzw(zzhbw.zza(null)), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbH)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzctp(this, strZzj), this.zzb);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (!(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbd)).booleanValue() && this.zze.zzb.zzb.zzh) && ((Boolean) zzbkp.zzd.zze()).booleanValue()) {
            zzhbw.zzr((zzhbo) zzhbw.zzg(zzhbo.zzw(this.zzj.zzb()), Throwable.class, zzctu.zza, zzcfr.zzh), new zzcto(this), this.zzb);
            return;
        }
        zzfll zzfllVar = this.zzh;
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zzb(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzc), true == com.google.android.gms.ads.internal.zzt.zzh().zzs(this.zza) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
        zzfry zzfryVar = this.zzg;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zzc(zzfkfVar, zzfkfVar.zzh, zzcbpVar), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        if (this.zzr.compareAndSet(false, true)) {
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeC)).intValue();
            if (iIntValue > 0) {
                zzy(iIntValue, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeD)).intValue());
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeB)).booleanValue()) {
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctq
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzl();
                    }
                });
            } else {
                zzo();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzg), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzi), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final synchronized void zzg() {
        zzdbu zzdbuVar;
        try {
            if (this.zzq) {
                ArrayList arrayList = new ArrayList(zzp());
                zzfkf zzfkfVar = this.zzf;
                arrayList.addAll(zzfkfVar.zzf);
                this.zzh.zza(this.zzg.zzb(this.zze, zzfkfVar, true, null, null, arrayList, null, null), null);
            } else {
                zzfll zzfllVar = this.zzh;
                zzfry zzfryVar = this.zzg;
                zzfkq zzfkqVar = this.zze;
                zzfkf zzfkfVar2 = this.zzf;
                zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar2, zzfkfVar2.zzm), null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzey)).booleanValue() && (zzdbuVar = this.zzm) != null) {
                    List list = zzdbuVar.zzb().zzm;
                    String strZzg = zzdbuVar.zzc().zzg();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(zzfry.zzd((String) it.next(), "@gw_adnetstatus@", strZzg));
                    }
                    long jZzh = zzdbuVar.zzc().zzh();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(zzfry.zzd((String) it2.next(), "@gw_ttr@", Long.toString(jZzh, 10)));
                    }
                    zzfllVar.zza(zzfryVar.zza(zzdbuVar.zza(), zzdbuVar.zzb(), arrayList3), null);
                }
                zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar2, zzfkfVar2.zzf), null);
            }
            this.zzq = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkp
    public final void zzi() {
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzau), null);
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcg)).booleanValue()) {
            int i = zzeVar.zza;
            zzfkf zzfkfVar = this.zzf;
            ArrayList arrayList = new ArrayList();
            for (String str : zzfkfVar.zzo) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 2);
                sb.append("2.");
                sb.append(i);
                arrayList.add(zzfry.zzd(str, "@gw_mpe@", sb.toString()));
            }
            this.zzh.zza(this.zzg.zza(this.zze, zzfkfVar, arrayList), null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzk() {
        zzfkf zzfkfVar = this.zzf;
        if (zzfkfVar.zze == 4) {
            this.zzh.zza(this.zzg.zza(this.zze, zzfkfVar, zzfkfVar.zzaA), null);
        }
    }

    public final /* synthetic */ void zzl() {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzo();
            }
        });
    }

    public final /* synthetic */ void zzm(final int i, final int i2) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcts
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzn(i, i2);
            }
        });
    }

    public final /* synthetic */ void zzn(int i, int i2) {
        zzy(i - 1, i2);
    }

    public final /* synthetic */ Context zzq() {
        return this.zza;
    }

    public final /* synthetic */ zzfkq zzr() {
        return this.zze;
    }

    public final /* synthetic */ zzfkf zzs() {
        return this.zzf;
    }

    public final /* synthetic */ zzfry zzt() {
        return this.zzg;
    }

    public final /* synthetic */ zzfll zzu() {
        return this.zzh;
    }

    public final /* synthetic */ zzdfg zzv() {
        return this.zzn;
    }

    public final /* synthetic */ zzdbn zzw() {
        return this.zzo;
    }

    public final /* synthetic */ zzcfe zzx() {
        return this.zzs;
    }
}
