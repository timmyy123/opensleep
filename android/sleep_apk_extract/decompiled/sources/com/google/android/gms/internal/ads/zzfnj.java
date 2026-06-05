package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfnj {
    private final zzfmn zza;
    private final zzfng zzb;
    private final zzfmj zzc;
    private zzfnp zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfnj(zzfmn zzfmnVar, zzfmj zzfmjVar, zzfng zzfngVar) {
        this.zza = zzfmnVar;
        this.zzc = zzfmjVar;
        this.zzb = zzfngVar;
        zzfmjVar.zza(new zzfmi() { // from class: com.google.android.gms.internal.ads.zzfni
            @Override // com.google.android.gms.internal.ads.zzfmi
            public final /* synthetic */ void zza() {
                this.zza.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        r3 = new com.google.android.gms.internal.ads.zzfnp(r4.zza, r4.zzb, r0);
        r4.zze = r3;
        r3.zza(new com.google.android.gms.internal.ads.zzfne(r4, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzd() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhk)).booleanValue() && !com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzi()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (true) {
                ArrayDeque arrayDeque = this.zzd;
                if (arrayDeque.isEmpty()) {
                    break;
                }
                zzfnh zzfnhVar = (zzfnh) arrayDeque.pollFirst();
                if (zzfnhVar == null || (zzfnhVar.zzb() != null && this.zza.zzc(zzfnhVar.zzb()))) {
                    break;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized void zza(zzfnh zzfnhVar) {
        this.zzd.add(zzfnhVar);
    }

    public final synchronized ListenableFuture zzb(zzfnh zzfnhVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzb(zzfnhVar);
    }

    public final /* synthetic */ void zzc() {
        synchronized (this) {
            this.zzf = 1;
            zzd();
        }
    }

    public final /* synthetic */ ArrayDeque zze() {
        return this.zzd;
    }

    public final /* synthetic */ void zzf(zzfnp zzfnpVar) {
        this.zze = null;
    }

    public final /* synthetic */ int zzg() {
        return this.zzf;
    }
}
