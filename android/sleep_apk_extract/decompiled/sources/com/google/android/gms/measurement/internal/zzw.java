package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzaif;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class zzw extends BroadcastReceiver {
    private final zzic zza;

    public zzw(zzic zzicVar) {
        this.zza = zzicVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzaW().zze().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzaW().zze().zza("App receiver called with null action");
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode != -1928239649) {
            if (iHashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                zzic zzicVar = this.zza;
                zzicVar.zzaW().zzk().zza("[sgtm] App Receiver notified batches are available");
                zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zza();
                    }
                });
                return;
            }
        } else if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzic zzicVar2 = this.zza;
            zzaif.zza();
            if (zzicVar2.zzc().zzp(null, zzfy.zzaP)) {
                zzicVar2.zzaW().zzk().zza("App receiver notified triggers are available");
                zzicVar2.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzic zzicVar3 = zzicVar2;
                        if (!zzicVar3.zzk().zzU()) {
                            zzicVar3.zzaW().zze().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        zzicVar3.zzj().zzv();
                        final zzlj zzljVarZzj = zzicVar3.zzj();
                        Objects.requireNonNull(zzljVarZzj);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzljVarZzj.zzw();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        this.zza.zzaW().zze().zza("App receiver called with unknown action");
    }

    public final /* synthetic */ void zza() {
        this.zza.zzx().zzh(((Long) zzfy.zzC.zzb(null)).longValue());
    }
}
