package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
final class zzgu {
    private final Map zza = new HashMap();

    public final void zza(IBinder iBinder) {
        zzgq zzgqVar;
        Map map = this.zza;
        synchronized (map) {
            if (iBinder == null) {
                zzgqVar = null;
            } else {
                try {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzgqVar = iInterfaceQueryLocalInterface instanceof zzgq ? (zzgq) iInterfaceQueryLocalInterface : new zzgq(iBinder);
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzjt zzjtVar = new zzjt();
            for (Map.Entry entry : map.entrySet()) {
                zzko zzkoVar = (zzko) entry.getValue();
                try {
                    zzgqVar.zzt(zzjtVar, new zzf(zzkoVar));
                    if (Log.isLoggable("WearableClient", 3)) {
                        String strValueOf = String.valueOf(entry.getKey());
                        String strValueOf2 = String.valueOf(zzkoVar);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 27 + strValueOf2.length());
                        sb.append("onPostInitHandler: added: ");
                        sb.append(strValueOf);
                        sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                        sb.append(strValueOf2);
                        Log.d("WearableClient", sb.toString());
                    }
                } catch (RemoteException unused) {
                    String strValueOf3 = String.valueOf(entry.getKey());
                    String strValueOf4 = String.valueOf(zzkoVar);
                    StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 32 + strValueOf4.length());
                    sb2.append("onPostInitHandler: Didn't add: ");
                    sb2.append(strValueOf3);
                    sb2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                    sb2.append(strValueOf4);
                    Log.w("WearableClient", sb2.toString());
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzb(zzkf zzkfVar, BaseImplementation$ResultHolder baseImplementation$ResultHolder, Object obj, zzko zzkoVar) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.get(obj) != null) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        String strValueOf = String.valueOf(obj);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
                        sb.append("duplicate listener: ");
                        sb.append(strValueOf);
                        Log.v("WearableClient", sb.toString());
                    }
                    baseImplementation$ResultHolder.setResult(new Status(4001));
                    return;
                }
                if (Log.isLoggable("WearableClient", 2)) {
                    String strValueOf2 = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 14);
                    sb2.append("new listener: ");
                    sb2.append(strValueOf2);
                    Log.v("WearableClient", sb2.toString());
                }
                map.put(obj, zzkoVar);
                try {
                    ((zzgq) zzkfVar.getService()).zzt(new zzgs(map, obj, baseImplementation$ResultHolder), new zzf(zzkoVar));
                } catch (RemoteException e) {
                    if (Log.isLoggable("WearableClient", 3)) {
                        String strValueOf3 = String.valueOf(obj);
                        StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 39);
                        sb3.append("addListener failed, removing listener: ");
                        sb3.append(strValueOf3);
                        Log.d("WearableClient", sb3.toString());
                    }
                    this.zza.remove(obj);
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(zzkf zzkfVar, BaseImplementation$ResultHolder baseImplementation$ResultHolder, Object obj) {
        Map map = this.zza;
        synchronized (map) {
            try {
                zzko zzkoVar = (zzko) map.remove(obj);
                if (zzkoVar == null) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        String strValueOf = String.valueOf(obj);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                        sb.append("remove Listener unknown: ");
                        sb.append(strValueOf);
                        Log.v("WearableClient", sb.toString());
                    }
                    baseImplementation$ResultHolder.setResult(new Status(4002));
                    return;
                }
                zzkoVar.zzu();
                if (Log.isLoggable("WearableClient", 2)) {
                    String strValueOf2 = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 24);
                    sb2.append("service.removeListener: ");
                    sb2.append(strValueOf2);
                    Log.v("WearableClient", sb2.toString());
                }
                ((zzgq) zzkfVar.getService()).zzu(new zzgt(map, obj, baseImplementation$ResultHolder), new zzin(zzkoVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
