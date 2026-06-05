package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class zznl extends zzg {
    private final zznf zza;
    private zzgb zzb;
    private volatile Boolean zzc;
    private final zzaz zzd;
    private ScheduledExecutorService zze;
    private final zzog zzf;
    private final List zzg;
    private final zzaz zzh;

    public zznl(zzic zzicVar) {
        super(zzicVar);
        this.zzg = new ArrayList();
        this.zzf = new zzog(zzicVar.zzba());
        this.zza = new zznf(this);
        this.zzd = new zzmm(this, zzicVar);
        this.zzh = new zzmq(this, zzicVar);
    }

    private final boolean zzad() {
        this.zzu.zzaV();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public final void zzV() {
        zzg();
        this.zzf.zza();
        this.zzu.zzc();
        this.zzd.zzb(((Long) zzfy.zzY.zzb(null)).longValue());
    }

    private final void zzaf(Runnable runnable) {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        List list = this.zzg;
        long size = list.size();
        zzic zzicVar = this.zzu;
        zzicVar.zzc();
        if (size >= 1000) {
            zza$$ExternalSyntheticOutline0.m(zzicVar, "Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.zzh.zzb(60000L);
        zzI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
    public final void zzX() {
        zzg();
        zzgs zzgsVarZzk = this.zzu.zzaW().zzk();
        List list = this.zzg;
        zzgsVarZzk.zzb("Processing queued up service tasks", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.zzu.zzaW().zzb().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzg.clear();
        this.zzh.zzd();
    }

    private final zzr zzah(boolean z) {
        Pair pairZzb;
        zzic zzicVar = this.zzu;
        zzicVar.zzaV();
        zzgi zzgiVarZzv = this.zzu.zzv();
        String strM = null;
        if (z) {
            zzic zzicVar2 = zzicVar.zzaW().zzu;
            if (zzicVar2.zzd().zzb != null && (pairZzb = zzicVar2.zzd().zzb.zzb()) != null && pairZzb != zzhh.zza) {
                String strValueOf = String.valueOf(pairZzb.second);
                String str = (String) pairZzb.first;
                strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf.length() + 1 + String.valueOf(str).length()), strValueOf, ":", str);
            }
        }
        return zzgiVarZzv.zzh(strM);
    }

    public final void zzA(zzpl zzplVar) {
        zzg();
        zzb();
        zzad();
        zzaf(new zzmg(this, zzah(true), this.zzu.zzm().zzj(zzplVar), zzplVar));
    }

    public final void zzB() {
        zzg();
        zzb();
        zzr zzrVarZzah = zzah(false);
        zzad();
        this.zzu.zzm().zzh();
        zzaf(new zzmh(this, zzrVarZzah));
    }

    public final void zzC(AtomicReference atomicReference) {
        zzg();
        zzb();
        zzaf(new zzmi(this, atomicReference, zzah(false)));
    }

    public final void zzD(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzg();
        zzb();
        zzaf(new zzmj(this, zzah(false), zzcsVar));
    }

    public final void zzE() {
        zzg();
        zzb();
        zzr zzrVarZzah = zzah(true);
        zzad();
        this.zzu.zzc().zzp(null, zzfy.zzaW);
        this.zzu.zzm().zzn();
        zzaf(new zzmk(this, zzrVarZzah, true));
    }

    public final void zzF() {
        zzg();
        zzb();
        zzaf(new zzml(this, zzah(true)));
    }

    public final void zzG(zzlu zzluVar) {
        zzg();
        zzb();
        zzaf(new zzmn(this, zzluVar));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zzb();
        zzbf zzbfVar = new zzbf(bundle);
        zzad();
        zzaf(new zzmo(this, true, zzah(false), this.zzu.zzc().zzp(null, zzfy.zzaW) && this.zzu.zzm().zzl(zzbfVar), zzbfVar, bundle));
    }

    public final void zzI() {
        zzg();
        zzb();
        if (zzh()) {
            return;
        }
        if (zzK()) {
            this.zza.zzc();
            return;
        }
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzE()) {
            return;
        }
        zzicVar.zzaV();
        List<ResolveInfo> listQueryIntentServices = zzicVar.zzaZ().getPackageManager().queryIntentServices(new Intent().setClassName(zzicVar.zzaZ(), "com.google.android.gms.measurement.AppMeasurementService"), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zza$$ExternalSyntheticOutline0.m(zzicVar, "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextZzaZ = zzicVar.zzaZ();
        zzicVar.zzaV();
        intent.setComponent(new ComponentName(contextZzaZ, "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zza(intent);
    }

    public final Boolean zzJ() {
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzK() {
        zzg();
        zzb();
        if (this.zzc == null) {
            zzg();
            zzb();
            zzic zzicVar = this.zzu;
            zzhh zzhhVarZzd = zzicVar.zzd();
            zzhhVarZzd.zzg();
            boolean z = false;
            Boolean boolValueOf = !zzhhVarZzd.zzd().contains("use_service") ? null : Boolean.valueOf(zzhhVarZzd.zzd().getBoolean("use_service", false));
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                zzicVar.zzaV();
                if (this.zzu.zzv().zzo() == 1) {
                    z = true;
                    if (!z && zzicVar.zzc().zzE()) {
                        zza$$ExternalSyntheticOutline0.m(zzicVar, "No way to upload. Consider using the full version of Analytics");
                    } else if (z) {
                        zzhh zzhhVarZzd2 = zzicVar.zzd();
                        zzhhVarZzd2.zzg();
                        SharedPreferences.Editor editorEdit = zzhhVarZzd2.zzd().edit();
                        editorEdit.putBoolean("use_service", z);
                        editorEdit.apply();
                    }
                    z = z;
                } else {
                    zzicVar.zzaW().zzk().zza("Checking service availability");
                    int iZzal = zzicVar.zzk().zzal(12451000);
                    if (iZzal != 0) {
                        if (iZzal == 1) {
                            zzicVar.zzaW().zzk().zza("Service missing");
                        } else if (iZzal != 2) {
                            if (iZzal == 3) {
                                zzicVar.zzaW().zze().zza("Service disabled");
                            } else if (iZzal == 9) {
                                zzicVar.zzaW().zze().zza("Service invalid");
                            } else if (iZzal != 18) {
                                zzicVar.zzaW().zze().zzb("Unexpected service status", Integer.valueOf(iZzal));
                            } else {
                                zzicVar.zzaW().zze().zza("Service updating");
                            }
                            z = false;
                        } else {
                            zzicVar.zzaW().zzj().zza("Service container out of date");
                            if (zzicVar.zzk().zzak() >= 17443) {
                                z = boolValueOf == null;
                                z = false;
                            }
                        }
                        if (!z) {
                            if (z) {
                            }
                            z = z;
                        }
                    } else {
                        zzicVar.zzaW().zzk().zza("Service available");
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            this.zzc = Boolean.valueOf(z);
        }
        return this.zzc.booleanValue();
    }

    public final void zzL(zzgb zzgbVar) {
        zzg();
        Preconditions.checkNotNull(zzgbVar);
        this.zzb = zzgbVar;
        zzV();
        zzX();
    }

    public final void zzM() {
        zzg();
        zzb();
        zznf zznfVar = this.zza;
        zznfVar.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaZ(), zznfVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzN(com.google.android.gms.internal.measurement.zzcs zzcsVar, zzbh zzbhVar, String str) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzk().zzal(12451000) == 0) {
            zzaf(new zzmp(this, zzbhVar, str, zzcsVar));
        } else {
            zzicVar.zzaW().zze().zza("Not bundling data. Service unavailable or out of date");
            zzicVar.zzk().zzar(zzcsVar, new byte[0]);
        }
    }

    public final boolean zzO() {
        zzg();
        zzb();
        return !zzK() || this.zzu.zzk().zzak() >= ((Integer) zzfy.zzaJ.zzb(null)).intValue();
    }

    public final boolean zzP() {
        zzg();
        zzb();
        return !zzK() || this.zzu.zzk().zzak() >= 241200;
    }

    public final /* synthetic */ void zzQ() {
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            zza$$ExternalSyntheticOutline0.m(this.zzu, "Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzrVarZzah = zzah(false);
            Preconditions.checkNotNull(zzrVarZzah);
            zzgbVar.zzy(zzrVarZzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to send storage consent settings to the service", e);
        }
    }

    public final /* synthetic */ void zzR() {
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            zza$$ExternalSyntheticOutline0.m(this.zzu, "Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzrVarZzah = zzah(false);
            Preconditions.checkNotNull(zzrVarZzah);
            zzgbVar.zzz(zzrVarZzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to send Dma consent settings to the service", e);
        }
    }

    public final /* synthetic */ void zzS(AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzgb zzgbVar;
        synchronized (atomicReference) {
            try {
                zzgbVar = this.zzb;
            } catch (RemoteException e) {
                this.zzu.zzaW().zzb().zzb("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzgbVar == null) {
                this.zzu.zzaW().zzb().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgbVar.zzD(zzrVar, bundle, new zzme(this, atomicReference));
            zzV();
        }
    }

    public final /* synthetic */ void zzT(AtomicReference atomicReference, zzr zzrVar, zzoo zzooVar) {
        zzgb zzgbVar;
        synchronized (atomicReference) {
            try {
                zzgbVar = this.zzb;
            } catch (RemoteException e) {
                this.zzu.zzaW().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzgbVar == null) {
                this.zzu.zzaW().zzb().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgbVar.zzB(zzrVar, zzooVar, new zzmf(this, atomicReference));
            zzV();
        }
    }

    public final /* synthetic */ void zzU(zzr zzrVar, zzaf zzafVar) {
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            zza$$ExternalSyntheticOutline0.m(this.zzu, "[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzgbVar.zzC(zzrVar, zzafVar);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzafVar.zza), e);
        }
    }

    public final /* synthetic */ void zzW(ComponentName componentName) {
        zzg();
        if (this.zzb != null) {
            this.zzb = null;
            this.zzu.zzaW().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzg();
            zzI();
        }
    }

    public final /* synthetic */ zznf zzY() {
        return this.zza;
    }

    public final /* synthetic */ zzgb zzZ() {
        return this.zzb;
    }

    public final /* synthetic */ void zzaa(zzgb zzgbVar) {
        this.zzb = null;
    }

    public final /* synthetic */ ScheduledExecutorService zzab() {
        return this.zze;
    }

    public final /* synthetic */ void zzac(ScheduledExecutorService scheduledExecutorService) {
        this.zze = scheduledExecutorService;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        zzg();
        zzb();
        return this.zzb != null;
    }

    public final void zzi() {
        zzg();
        zzb();
        zzaf(new zzmr(this, zzah(true)));
    }

    public final void zzj(boolean z) {
        zzg();
        zzb();
        if (zzO()) {
            zzaf(new zzms(this, zzah(false)));
        }
    }

    public final void zzk(boolean z) {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzQ();
            }
        });
    }

    public final void zzl() {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzng
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzR();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzm(zzgb zzgbVar, AbstractSafeParcelable abstractSafeParcelable, zzr zzrVar) {
        zzic zzicVar;
        int i;
        zzr zzrVar2;
        long jElapsedRealtime;
        long jCurrentTimeMillis;
        AbstractSafeParcelable abstractSafeParcelable2 = abstractSafeParcelable;
        zzg();
        zzb();
        zzad();
        zzic zzicVar2 = this.zzu;
        zzicVar2.zzc();
        zzr zzrVar3 = zzrVar;
        int size = 100;
        int i2 = 0;
        for (int i3 = 100; i2 < 1001 && size == i3; i3 = 100) {
            zzic zzicVar3 = this.zzu;
            ArrayList arrayList = new ArrayList();
            List listZzm = zzicVar3.zzm().zzm(i3);
            if (listZzm != null) {
                arrayList.addAll(listZzm);
                size = listZzm.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable2 != null && size < i3) {
                arrayList.add(new zzgk(abstractSafeParcelable2, zzrVar3.zzc, zzrVar3.zzj));
            }
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                zzgk zzgkVar = (zzgk) arrayList.get(i4);
                AbstractSafeParcelable abstractSafeParcelable3 = zzgkVar.zza;
                zzal zzalVarZzc = zzicVar2.zzc();
                zzfx zzfxVar = zzfy.zzaW;
                if (zzalVarZzc.zzp(null, zzfxVar)) {
                    String str = zzgkVar.zzb;
                    if (TextUtils.isEmpty(str)) {
                        zzicVar = zzicVar2;
                        i = i2;
                        zzrVar2 = zzrVar3;
                    } else {
                        i = i2;
                        zzicVar = zzicVar2;
                        zzrVar2 = new zzr(zzrVar3.zza, zzrVar3.zzb, str, zzgkVar.zzc, zzrVar3.zzd, zzrVar3.zze, zzrVar3.zzf, zzrVar3.zzg, zzrVar3.zzh, zzrVar3.zzi, zzrVar3.zzk, zzrVar3.zzl, zzrVar3.zzm, zzrVar3.zzn, zzrVar3.zzo, zzrVar3.zzp, zzrVar3.zzq, zzrVar3.zzr, zzrVar3.zzs, zzrVar3.zzt, zzrVar3.zzu, zzrVar3.zzv, zzrVar3.zzw, zzrVar3.zzx, zzrVar3.zzy, zzrVar3.zzz, zzrVar3.zzA, zzrVar3.zzB, zzrVar3.zzC, zzrVar3.zzD, zzrVar3.zzE, zzrVar3.zzF);
                    }
                }
                if (abstractSafeParcelable3 instanceof zzbh) {
                    try {
                        zzic zzicVar4 = this.zzu;
                        jCurrentTimeMillis = zzicVar4.zzba().currentTimeMillis();
                        try {
                            jElapsedRealtime = zzicVar4.zzba().elapsedRealtime();
                            try {
                                zzgbVar.zze((zzbh) abstractSafeParcelable3, zzrVar2);
                                zzicVar.zzaW().zzk().zza("Logging telemetry for logEvent from database");
                                zzgq.zza(zzicVar4).zzb(36301, 0, jCurrentTimeMillis, zzicVar4.zzba().currentTimeMillis(), (int) (zzicVar4.zzba().elapsedRealtime() - jElapsedRealtime));
                            } catch (RemoteException e) {
                                e = e;
                                this.zzu.zzaW().zzb().zzb("Failed to send event to the service", e);
                                if (jCurrentTimeMillis != 0) {
                                    zzic zzicVar5 = this.zzu;
                                    zzgq.zza(zzicVar5).zzb(36301, 13, jCurrentTimeMillis, zzicVar5.zzba().currentTimeMillis(), (int) (zzicVar5.zzba().elapsedRealtime() - jElapsedRealtime));
                                }
                            }
                        } catch (RemoteException e2) {
                            e = e2;
                            jElapsedRealtime = 0;
                        }
                    } catch (RemoteException e3) {
                        e = e3;
                        jElapsedRealtime = 0;
                        jCurrentTimeMillis = 0;
                    }
                } else if (abstractSafeParcelable3 instanceof zzpl) {
                    try {
                        zzgbVar.zzf((zzpl) abstractSafeParcelable3, zzrVar2);
                    } catch (RemoteException e4) {
                        this.zzu.zzaW().zzb().zzb("Failed to send user property to the service", e4);
                    }
                } else if (abstractSafeParcelable3 instanceof zzah) {
                    try {
                        zzgbVar.zzn((zzah) abstractSafeParcelable3, zzrVar2);
                    } catch (RemoteException e5) {
                        this.zzu.zzaW().zzb().zzb("Failed to send conditional user property to the service", e5);
                    }
                } else {
                    zzic zzicVar6 = this.zzu;
                    if (zzicVar6.zzc().zzp(null, zzfxVar) && (abstractSafeParcelable3 instanceof zzbf)) {
                        try {
                            zzgbVar.zzu(((zzbf) abstractSafeParcelable3).zzf(), zzrVar2);
                        } catch (RemoteException e6) {
                            this.zzu.zzaW().zzb().zzb("Failed to send default event parameters to the service", e6);
                        }
                    } else {
                        zza$$ExternalSyntheticOutline0.m(zzicVar6, "Discarding data. Unrecognized parcel type.");
                    }
                }
                i4++;
                i2 = i;
                zzrVar3 = zzrVar2;
                zzicVar2 = zzicVar;
            }
            i2++;
            abstractSafeParcelable2 = abstractSafeParcelable;
        }
    }

    public final void zzn(zzbh zzbhVar, String str) {
        Preconditions.checkNotNull(zzbhVar);
        zzg();
        zzb();
        zzad();
        zzaf(new zzmt(this, true, zzah(true), this.zzu.zzm().zzi(zzbhVar), zzbhVar, str));
    }

    public final void zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzb();
        this.zzu.zzaV();
        zzaf(new zzmu(this, true, zzah(true), this.zzu.zzm().zzk(zzahVar), new zzah(zzahVar), zzahVar));
    }

    public final void zzq(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzaf(new zzmv(this, atomicReference, null, str2, str3, zzah(false)));
    }

    public final void zzs(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str, String str2) {
        zzg();
        zzb();
        zzaf(new zzmw(this, str, str2, zzah(false), zzcsVar));
    }

    public final void zzt(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmx(this, atomicReference, null, str2, str3, zzah(false), z));
    }

    public final void zzu(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str, String str2, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmc(this, str, str2, zzah(false), z, zzcsVar));
    }

    public final void zzw(final AtomicReference atomicReference, final Bundle bundle) {
        zzg();
        zzb();
        final zzr zzrVarZzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzS(atomicReference, zzrVarZzah, bundle);
            }
        });
    }

    public final void zzx(final AtomicReference atomicReference, final zzoo zzooVar) {
        zzg();
        zzb();
        final zzr zzrVarZzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzni
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzT(atomicReference, zzrVarZzah, zzooVar);
            }
        });
    }

    public final void zzy(final zzaf zzafVar) {
        zzg();
        zzb();
        final zzr zzrVarZzah = zzah(true);
        Preconditions.checkNotNull(zzrVarZzah);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzU(zzrVarZzah, zzafVar);
            }
        });
    }

    public final zzao zzz() {
        zzg();
        zzb();
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            zzI();
            this.zzu.zzaW().zzj().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzrVarZzah = zzah(false);
        Preconditions.checkNotNull(zzrVarZzah);
        try {
            zzao zzaoVarZzw = zzgbVar.zzw(zzrVarZzah);
            zzV();
            return zzaoVarZzw;
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to get consents; remote exception", e);
            return null;
        }
    }
}
