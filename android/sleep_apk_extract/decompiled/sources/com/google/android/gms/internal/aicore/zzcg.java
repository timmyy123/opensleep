package com.google.android.gms.internal.aicore;

import android.content.ComponentName;
import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcg implements zzar {
    private static final ComponentName zzd;
    private static final ComponentName zze;
    protected final Context zza;
    private final ListeningExecutorService zzf;
    private final Executor zzg;
    private final boolean zzh;
    private final Object zzi = new Object();

    static {
        ComponentName componentName = new ComponentName("com.google.android.aicore", "com.google.android.apps.aicore.service.multiuser.AiCoreMultiUserService");
        zzd = componentName;
        zze = new ComponentName(componentName.getPackageName(), "com.google.android.apps.aicore.service.AiCoreService");
    }

    public zzcg(zzau zzauVar) {
        this.zza = zzauVar.zza();
        this.zzf = MoreExecutors.listeningDecorator(zzauVar.zzb());
        this.zzg = zzauVar.zzc();
        this.zzh = zzauVar.zzd();
    }

    private final void zzr() {
        synchronized (this.zzi) {
        }
    }

    @Override // com.google.android.gms.internal.aicore.zzar, java.lang.AutoCloseable
    public final void close() {
        zzr();
    }
}
