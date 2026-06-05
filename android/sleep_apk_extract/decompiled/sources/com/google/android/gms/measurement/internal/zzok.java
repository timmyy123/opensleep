package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;

/* JADX INFO: loaded from: classes4.dex */
public final class zzok extends zzos {
    private final AlarmManager zza;
    private zzaz zzb;
    private Integer zzc;

    public zzok(zzpg zzpgVar) {
        super(zzpgVar);
        this.zza = (AlarmManager) this.zzu.zzaZ().getSystemService("alarm");
    }

    private final void zzh() {
        JobScheduler jobScheduler = (JobScheduler) this.zzu.zzaZ().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzi());
        }
    }

    private final int zzi() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzu.zzaZ().getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzj() {
        Context contextZzaZ = this.zzu.zzaZ();
        return com.google.android.gms.internal.measurement.zzce.zza(contextZzaZ, 0, new Intent().setClassName(contextZzaZ, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzce.zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    public final boolean zzbc() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzh();
        return false;
    }

    public final zzaz zzc() {
        if (this.zzb == null) {
            this.zzb = new zzoj(this, this.zzg.zzah());
        }
        return this.zzb;
    }

    public final void zzd(long j) {
        zzay();
        zzic zzicVar = this.zzu;
        zzicVar.zzaV();
        Context contextZzaZ = zzicVar.zzaZ();
        if (!zzpp.zzax(contextZzaZ)) {
            zzicVar.zzaW().zzj().zza("Receiver not registered/enabled");
        }
        if (!zzpp.zzS(contextZzaZ, false)) {
            zzicVar.zzaW().zzj().zza("Service not registered/enabled");
        }
        zzf();
        zzicVar.zzaW().zzk().zzb("Scheduling upload, millis", Long.valueOf(j));
        zzicVar.zzba().elapsedRealtime();
        zzicVar.zzc();
        if (j < Math.max(0L, ((Long) zzfy.zzL.zzb(null)).longValue()) && !zzc().zzc()) {
            zzc().zzb(j);
        }
        zzicVar.zzaV();
        Context contextZzaZ2 = zzicVar.zzaZ();
        ComponentName componentName = new ComponentName(contextZzaZ2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iZzi = zzi();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzcf.zza(contextZzaZ2, new JobInfo.Builder(iZzi, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void zzf() {
        zzay();
        this.zzu.zzaW().zzk().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzc().zzd();
        zzh();
    }
}
