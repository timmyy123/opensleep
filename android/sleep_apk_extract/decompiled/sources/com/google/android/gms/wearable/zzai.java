package com.google.android.gms.wearable;

import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.internal.zzao;
import com.google.android.gms.wearable.internal.zzbq;
import com.google.android.gms.wearable.internal.zzft;
import com.google.android.gms.wearable.internal.zzgj;
import com.google.android.gms.wearable.internal.zzgk;
import com.google.android.gms.wearable.internal.zzgo;
import com.google.android.gms.wearable.internal.zzhk;
import com.google.android.gms.wearable.internal.zzia;
import com.google.android.gms.wearable.internal.zzib;
import com.google.android.gms.wearable.internal.zzkg;
import com.google.android.gms.wearable.internal.zzkp;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzai extends zzgo {
    private final WeakReference zza;
    private volatile int zzb = -1;

    public zzai(WearableListenerService wearableListenerService) {
        this.zza = new WeakReference(wearableListenerService);
    }

    public static final /* synthetic */ void zzq(zzgj zzgjVar, Task task) {
        if (task.isSuccessful()) {
            zzv(zzgjVar, true, (byte[]) task.getResult());
        } else {
            Log.e("WearableLS", "Failed to resolve future, sending null response", task.getException());
            zzv(zzgjVar, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public final WearableListenerService zzm(String str) {
        WearableListenerService wearableListenerService = (WearableListenerService) this.zza.get();
        if (wearableListenerService != null || !Log.isLoggable("WearableLS", 3)) {
            return wearableListenerService;
        }
        Log.d("WearableLS", str.concat(": service reference no longer valid"));
        return null;
    }

    private final boolean zzt(Runnable runnable, String str, Object obj) {
        WearableListenerService wearableListenerServiceZzm = zzm(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + 12), "postEvent (", str, ")"));
        if (wearableListenerServiceZzm == null) {
            return false;
        }
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", String.format("%s: %s %s", str, wearableListenerServiceZzm.zza(), obj));
        }
        if (!zzu(wearableListenerServiceZzm)) {
            return false;
        }
        synchronized (wearableListenerServiceZzm.zzg()) {
            try {
                if (wearableListenerServiceZzm.zzh()) {
                    return false;
                }
                wearableListenerServiceZzm.zzb().post(runnable);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean zzu(WearableListenerService wearableListenerService) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzb) {
            return true;
        }
        if ((zzkp.zza(wearableListenerService).zzb() && UidVerifier.uidHasPackageName(wearableListenerService, callingUid, "com.google.android.wearable.app.cn")) || UidVerifier.isGooglePlayServicesUid(wearableListenerService, callingUid)) {
            this.zzb = callingUid;
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(callingUid).length() + 46);
        sb.append("Caller is not GooglePlayServices; caller UID: ");
        sb.append(callingUid);
        Log.e("WearableLS", sb.toString());
        return false;
    }

    private static final void zzv(zzgj zzgjVar, boolean z, byte[] bArr) {
        try {
            zzgjVar.zzd(z, bArr);
        } catch (RemoteException e) {
            Log.e("WearableLS", "Failed to send a response back", e);
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzb(DataHolder dataHolder) {
        zzw zzwVar = new zzw(this, dataHolder);
        try {
            String strValueOf = String.valueOf(dataHolder);
            int count = dataHolder.getCount();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 7 + String.valueOf(count).length());
            sb.append(strValueOf);
            sb.append(", rows=");
            sb.append(count);
            if (zzt(zzwVar, "onDataItemChanged", sb.toString())) {
            }
        } finally {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzc(zzhk zzhkVar) {
        zzt(new zzx(this, zzhkVar), "onMessageReceived", zzhkVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzd(zzib zzibVar) {
        zzt(new zzy(this, zzibVar), "onPeerConnected", zzibVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zze(zzib zzibVar) {
        zzt(new zzz(this, zzibVar), "onPeerDisconnected", zzibVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzf(List list) {
        zzt(new zzaa(this, list), "onConnectedNodes", list);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzg(zzao zzaoVar) {
        zzt(new zzab(this, zzaoVar), "onConnectedCapabilityChanged", zzaoVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzh(com.google.android.gms.wearable.internal.zzl zzlVar) {
        zzt(new zzac(this, zzlVar), "onNotificationReceived", zzlVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzi(com.google.android.gms.wearable.internal.zzj zzjVar) {
        zzt(new zzad(this, zzjVar), "onEntityUpdate", zzjVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzj(zzbq zzbqVar) {
        zzt(new zzae(this, zzbqVar), "onChannelEvent", zzbqVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzk(final zzia zziaVar) {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.wearable.zzaf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzl(zziaVar);
            }
        };
        DataHolder dataHolder = zziaVar.zzb;
        int count = dataHolder.getCount();
        if (zzt(runnable, "onNodeMigrated", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(count).length() + 17), "DataHolder[rows=", count, "]"))) {
            return;
        }
        dataHolder.close();
    }

    public final /* synthetic */ void zzl(zzia zziaVar) {
        DataItemBuffer dataItemBuffer = new DataItemBuffer(zziaVar.zzb);
        try {
            WearableListenerService wearableListenerServiceZzm = zzm("onNodeMigrated");
            if (wearableListenerServiceZzm != null) {
                wearableListenerServiceZzm.onNodeMigrated(zziaVar.zza, dataItemBuffer);
            }
            dataItemBuffer.close();
        } catch (Throwable th) {
            try {
                dataItemBuffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzn(final zzhk zzhkVar, final zzgj zzgjVar) {
        if (zzt(new Runnable() { // from class: com.google.android.gms.wearable.zzah
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzp(zzgjVar, zzhkVar);
            }
        }, "onRequestReceived", zzhkVar)) {
            return;
        }
        zzv(zzgjVar, false, null);
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final boolean zzo(zzft zzftVar, zzgk zzgkVar) {
        WearableListenerService wearableListenerServiceZzm = zzm("onGetService");
        if (wearableListenerServiceZzm == null) {
            return false;
        }
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onGetService: " + wearableListenerServiceZzm.zza());
        }
        if (!zzu(wearableListenerServiceZzm)) {
            return false;
        }
        try {
            zzgkVar.zzd(new zzkg(wearableListenerServiceZzm.getPackageName()), zzgo.zzr(wearableListenerServiceZzm.zzc()));
            return true;
        } catch (RemoteException e) {
            Log.e("WearableLS", "Failed to respond to onGetService", e);
            return false;
        }
    }

    public final /* synthetic */ void zzp(final zzgj zzgjVar, zzhk zzhkVar) {
        WearableListenerService wearableListenerServiceZzm = zzm("onRequestReceived");
        if (wearableListenerServiceZzm == null) {
            zzv(zzgjVar, false, null);
            return;
        }
        Task<byte[]> taskOnRequest = wearableListenerServiceZzm.onRequest(zzhkVar.getSourceNodeId(), zzhkVar.getPath(), zzhkVar.getData());
        if (taskOnRequest == null) {
            zzv(zzgjVar, false, null);
        } else {
            taskOnRequest.addOnCompleteListener(new OnCompleteListener(this) { // from class: com.google.android.gms.wearable.zzag
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final /* synthetic */ void onComplete(Task task) {
                    zzai.zzq(zzgjVar, task);
                }
            });
        }
    }
}
