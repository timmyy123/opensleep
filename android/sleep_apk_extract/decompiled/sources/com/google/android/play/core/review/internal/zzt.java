package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class zzt {
    private static final Map zza = new HashMap();
    private final Context zzb;
    private final zzi zzc;
    private boolean zzh;
    private final Intent zzi;
    private ServiceConnection zzm;
    private IInterface zzn;
    private final List zze = new ArrayList();
    private final Set zzf = new HashSet();
    private final Object zzg = new Object();
    private final IBinder.DeathRecipient zzk = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.review.internal.zzk
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzt.zzj(this.zza);
        }
    };
    private final AtomicInteger zzl = new AtomicInteger(0);
    private final String zzd = "com.google.android.finsky.inappreviewservice.InAppReviewService";
    private final WeakReference zzj = new WeakReference(null);

    public zzt(Context context, zzi zziVar, String str, Intent intent, com.google.android.play.core.review.zze zzeVar, zzo zzoVar) {
        this.zzb = context;
        this.zzc = zziVar;
        this.zzi = intent;
    }

    public static /* synthetic */ void zzj(zzt zztVar) {
        zztVar.zzc.zzc("reportBinderDeath", new Object[0]);
        zzo zzoVar = (zzo) zztVar.zzj.get();
        zzi zziVar = zztVar.zzc;
        if (zzoVar != null) {
            zziVar.zzc("calling onBinderDied", new Object[0]);
            zzoVar.zza();
        } else {
            zziVar.zzc("%s : Binder has died.", zztVar.zzd);
            Iterator it = zztVar.zze.iterator();
            while (it.hasNext()) {
                ((zzj) it.next()).zzc(zztVar.zzv());
            }
            zztVar.zze.clear();
        }
        synchronized (zztVar.zzg) {
            zztVar.zzw();
        }
    }

    public static /* bridge */ /* synthetic */ void zzn(final zzt zztVar, final TaskCompletionSource taskCompletionSource) {
        zztVar.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.review.internal.zzl
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzt(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void zzp(zzt zztVar, zzj zzjVar) {
        if (zztVar.zzn != null || zztVar.zzh) {
            if (!zztVar.zzh) {
                zzjVar.run();
                return;
            } else {
                zztVar.zzc.zzc("Waiting to bind to the service.", new Object[0]);
                zztVar.zze.add(zzjVar);
                return;
            }
        }
        zztVar.zzc.zzc("Initiate binding to the service.", new Object[0]);
        zztVar.zze.add(zzjVar);
        zzr zzrVar = new zzr(zztVar, null);
        zztVar.zzm = zzrVar;
        zztVar.zzh = true;
        if (zztVar.zzb.bindService(zztVar.zzi, zzrVar, 1)) {
            return;
        }
        zztVar.zzc.zzc("Failed to bind to the service.", new Object[0]);
        zztVar.zzh = false;
        Iterator it = zztVar.zze.iterator();
        while (it.hasNext()) {
            ((zzj) it.next()).zzc(new zzu());
        }
        zztVar.zze.clear();
    }

    public static /* bridge */ /* synthetic */ void zzq(zzt zztVar) {
        zztVar.zzc.zzc("linkToDeath", new Object[0]);
        try {
            zztVar.zzn.asBinder().linkToDeath(zztVar.zzk, 0);
        } catch (RemoteException e) {
            zztVar.zzc.zzb(e, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void zzr(zzt zztVar) {
        zztVar.zzc.zzc("unlinkToDeath", new Object[0]);
        zztVar.zzn.asBinder().unlinkToDeath(zztVar.zzk, 0);
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzw() {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(zzv());
        }
        this.zzf.clear();
    }

    public final Handler zzc() {
        Handler handler;
        Map map = zza;
        synchronized (map) {
            try {
                if (!map.containsKey(this.zzd)) {
                    HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                    handlerThread.start();
                    map.put(this.zzd, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.zzd);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzs(zzj zzjVar, TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzm(this, zzjVar.zzb(), taskCompletionSource, zzjVar));
    }

    public final /* synthetic */ void zzt(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    public final void zzu(TaskCompletionSource taskCompletionSource) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
        zzc().post(new zzn(this));
    }
}
