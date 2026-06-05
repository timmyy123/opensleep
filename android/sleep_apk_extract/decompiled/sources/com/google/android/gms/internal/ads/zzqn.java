package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqn {
    private final Context zza;
    private final zzqm zzb;
    private final Handler zzc;
    private final zzqj zzd;
    private final BroadcastReceiver zze;
    private final zzqk zzf;
    private zzacm zzg;
    private zzqh zzh;
    private AudioDeviceInfo zzi;
    private zzd zzj;
    private boolean zzk;

    /* JADX WARN: Multi-variable type inference failed */
    public zzqn(Context context, zzqm zzqmVar, zzd zzdVar, AudioDeviceInfo audioDeviceInfo) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzb = zzqmVar;
        this.zzj = zzdVar;
        this.zzi = audioDeviceInfo;
        Handler handler = new Handler(zzfl.zzf(), null);
        this.zzc = handler;
        this.zzd = new zzqj(this, 0 == true ? 1 : 0);
        this.zze = new zzql(this, 0 == true ? 1 : 0);
        Uri uriZzc = zzqh.zzc();
        this.zzf = uriZzc != null ? new zzqk(this, handler, applicationContext.getContentResolver(), uriZzc) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final List zzg() {
        zzacm zzacmVar;
        return (Build.VERSION.SDK_INT < 32 || (zzacmVar = this.zzg) == null) ? zzgwm.zzi() : zzacmVar.zzf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final void zzh(zzqh zzqhVar) {
        if (!this.zzk || zzqhVar.equals(this.zzh)) {
            return;
        }
        this.zzh = zzqhVar;
        this.zzb.zza(zzqhVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzi() {
        zzh(zzqh.zza(this.zza, this.zzj, this.zzi, zzg()));
    }

    public final void zza(zzqh zzqhVar) {
        zzh(zzqhVar);
    }

    public final void zzb(zzd zzdVar) {
        if (Objects.equals(zzdVar, this.zzj)) {
            return;
        }
        this.zzj = zzdVar;
        zzh(zzqh.zza(this.zza, zzdVar, this.zzi, zzg()));
    }

    public final void zzc(AudioDeviceInfo audioDeviceInfo) {
        if (Objects.equals(audioDeviceInfo, this.zzi)) {
            return;
        }
        this.zzi = audioDeviceInfo;
        zzh(zzqh.zza(this.zza, this.zzj, audioDeviceInfo, zzg()));
    }

    public final zzqh zzd() {
        if (this.zzk) {
            zzqh zzqhVar = this.zzh;
            zzqhVar.getClass();
            return zzqhVar;
        }
        this.zzk = true;
        zzqk zzqkVar = this.zzf;
        if (zzqkVar != null) {
            zzqkVar.zza();
        }
        Context context = this.zza;
        zzqj zzqjVar = this.zzd;
        Handler handler = this.zzc;
        zzcj.zza(context).registerAudioDeviceCallback(zzqjVar, handler);
        if (Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzacm(context, new Runnable() { // from class: com.google.android.gms.internal.ads.zzqi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzf();
                }
            }, Boolean.valueOf(zzfl.zzP(context)));
        }
        zzqh zzqhVarZzb = zzqh.zzb(context, context.registerReceiver(this.zze, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler), this.zzj, this.zzi, zzg());
        this.zzh = zzqhVarZzb;
        return zzqhVarZzb;
    }

    public final void zze() {
        zzacm zzacmVar;
        if (this.zzk) {
            this.zzh = null;
            Context context = this.zza;
            zzcj.zza(context).unregisterAudioDeviceCallback(this.zzd);
            if (Build.VERSION.SDK_INT >= 32 && (zzacmVar = this.zzg) != null) {
                zzacmVar.zzg();
                this.zzg = null;
            }
            context.unregisterReceiver(this.zze);
            zzqk zzqkVar = this.zzf;
            if (zzqkVar != null) {
                zzqkVar.zzb();
            }
            this.zzk = false;
        }
    }

    public final /* synthetic */ AudioDeviceInfo zzj() {
        return this.zzi;
    }

    public final /* synthetic */ void zzk(AudioDeviceInfo audioDeviceInfo) {
        this.zzi = null;
    }

    public final /* synthetic */ zzd zzl() {
        return this.zzj;
    }
}
