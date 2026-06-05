package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdiq {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzfht zzo;

    public final /* synthetic */ Set zzA() {
        return this.zzm;
    }

    public final /* synthetic */ Set zzB() {
        return this.zzn;
    }

    public final /* synthetic */ zzfht zzC() {
        return this.zzo;
    }

    public final zzdiq zza(zzdcr zzdcrVar, Executor executor) {
        this.zze.add(new zzdkq(zzdcrVar, executor));
        return this;
    }

    public final zzdiq zzb(zzdef zzdefVar, Executor executor) {
        this.zzh.add(new zzdkq(zzdefVar, executor));
        return this;
    }

    public final zzdiq zzc(zzdcu zzdcuVar, Executor executor) {
        this.zzi.add(new zzdkq(zzdcuVar, executor));
        return this;
    }

    public final zzdiq zzd(zzddh zzddhVar, Executor executor) {
        this.zzl.add(new zzdkq(zzddhVar, executor));
        return this;
    }

    public final zzdiq zze(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdkq(appEventListener, executor));
        return this;
    }

    public final zzdiq zzf(com.google.android.gms.ads.internal.client.zza zzaVar, Executor executor) {
        this.zzc.add(new zzdkq(zzaVar, executor));
        return this;
    }

    public final zzdiq zzg(zzdky zzdkyVar, Executor executor) {
        this.zzd.add(new zzdkq(zzdkyVar, executor));
        return this;
    }

    public final zzdiq zzh(zzddl zzddlVar, Executor executor) {
        this.zzf.add(new zzdkq(zzddlVar, executor));
        return this;
    }

    public final zzdiq zzi(zzdeq zzdeqVar, Executor executor) {
        this.zzg.add(new zzdkq(zzdeqVar, executor));
        return this;
    }

    public final zzdiq zzj(com.google.android.gms.ads.internal.overlay.zzr zzrVar, Executor executor) {
        this.zzn.add(new zzdkq(zzrVar, executor));
        return this;
    }

    public final zzdiq zzk(zzdfi zzdfiVar, Executor executor) {
        this.zzm.add(new zzdkq(zzdfiVar, executor));
        return this;
    }

    public final zzdiq zzl(zzfht zzfhtVar) {
        this.zzo = zzfhtVar;
        return this;
    }

    public final zzdiq zzm(zzdfx zzdfxVar, Executor executor) {
        this.zzb.add(new zzdkq(zzdfxVar, executor));
        return this;
    }

    public final zzdir zzn() {
        return new zzdir(this, null);
    }

    public final /* synthetic */ Set zzo() {
        return this.zza;
    }

    public final /* synthetic */ Set zzp() {
        return this.zzb;
    }

    public final /* synthetic */ Set zzq() {
        return this.zzc;
    }

    public final /* synthetic */ Set zzr() {
        return this.zzd;
    }

    public final /* synthetic */ Set zzs() {
        return this.zze;
    }

    public final /* synthetic */ Set zzt() {
        return this.zzf;
    }

    public final /* synthetic */ Set zzu() {
        return this.zzg;
    }

    public final /* synthetic */ Set zzv() {
        return this.zzh;
    }

    public final /* synthetic */ Set zzw() {
        return this.zzi;
    }

    public final /* synthetic */ Set zzx() {
        return this.zzj;
    }

    public final /* synthetic */ Set zzy() {
        return this.zzk;
    }

    public final /* synthetic */ Set zzz() {
        return this.zzl;
    }
}
