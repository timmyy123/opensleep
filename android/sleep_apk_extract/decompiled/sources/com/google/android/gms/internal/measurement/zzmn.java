package com.google.android.gms.internal.measurement;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmn implements zzmj {
    private final zzkk zza;

    public zzmn(zzkk zzkkVar) {
        Preconditions.checkNotNull(zzkkVar);
        this.zza = zzkkVar;
    }

    private static ListenableFuture zzf(Task task) {
        return Futures.catchingAsync(zzlb.zza(task, null), ApiException.class, zzml.zza, MoreExecutors.directExecutor());
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zza(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull("");
        return zzf(this.zza.zzb(str, "", null).continueWith(MoreExecutors.directExecutor(), new Continuation(this) { // from class: com.google.android.gms.internal.measurement.zzmm
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                zzadu zzaduVarZzbd;
                zzjh zzjhVar = (zzjh) task.getResult();
                zzmf zzmfVarZzh = zzmg.zzh();
                zzmfVarZzh.zza(zzjhVar.zza);
                zzmfVarZzh.zzc(zzjhVar.zzc);
                zzmfVarZzh.zzf(zzjhVar.zzf);
                zzmfVarZzh.zzg(zzjhVar.zzg);
                byte[] bArr = zzjhVar.zzb;
                if (bArr != null) {
                    zzmfVarZzh.zzb(zzacr.zzj(bArr, 0, bArr.length));
                }
                for (zzjf zzjfVar : zzjhVar.zzd) {
                    for (zzjo zzjoVar : zzjfVar.zzb) {
                        int i = zzjoVar.zzg;
                        if (i == 1) {
                            zzmh zzmhVarZzh = zzmi.zzh();
                            zzmhVarZzh.zza(zzjoVar.zza);
                            zzmhVarZzh.zzb(zzjoVar.zza());
                            zzaduVarZzbd = zzmhVarZzh.zzbd();
                        } else if (i == 2) {
                            zzmh zzmhVarZzh2 = zzmi.zzh();
                            zzmhVarZzh2.zza(zzjoVar.zza);
                            zzmhVarZzh2.zzc(zzjoVar.zzb());
                            zzaduVarZzbd = zzmhVarZzh2.zzbd();
                        } else if (i == 3) {
                            zzmh zzmhVarZzh3 = zzmi.zzh();
                            zzmhVarZzh3.zza(zzjoVar.zza);
                            zzmhVarZzh3.zzd(zzjoVar.zzc());
                            zzaduVarZzbd = zzmhVarZzh3.zzbd();
                        } else if (i == 4) {
                            zzmh zzmhVarZzh4 = zzmi.zzh();
                            zzmhVarZzh4.zza(zzjoVar.zza);
                            zzmhVarZzh4.zze(zzjoVar.zzd());
                            zzaduVarZzbd = zzmhVarZzh4.zzbd();
                        } else {
                            if (i != 5) {
                                Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(i, "Unrecognized flag type: ", new StringBuilder(String.valueOf(i).length() + 24)));
                                return null;
                            }
                            zzmh zzmhVarZzh5 = zzmi.zzh();
                            zzmhVarZzh5.zza(zzjoVar.zza);
                            byte[] bArrZze = zzjoVar.zze();
                            zzacr zzacrVar = zzacr.zza;
                            zzmhVarZzh5.zzf(zzacr.zzj(bArrZze, 0, bArrZze.length));
                            zzaduVarZzbd = zzmhVarZzh5.zzbd();
                        }
                        zzmfVarZzh.zzd((zzmi) zzaduVarZzbd);
                    }
                    String[] strArr = zzjfVar.zzc;
                    if (strArr != null) {
                        for (String str3 : strArr) {
                            zzmfVarZzh.zze(str3);
                        }
                    }
                }
                return (zzmg) zzmfVarZzh.zzbd();
            }
        }));
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zzb(String str) {
        Preconditions.checkNotNull(str);
        return zzf(this.zza.zzc(str));
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zzc(zzme zzmeVar) {
        return zzf(this.zza.zzd(zzmeVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zzd() {
        return zzf(this.zza.zze());
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zze(zzpm zzpmVar) {
        return zzf(this.zza.zzf(zzpmVar));
    }
}
