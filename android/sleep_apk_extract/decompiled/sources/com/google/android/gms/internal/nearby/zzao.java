package com.google.android.gms.internal.nearby;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzao {
    private static final Map zza = new ArrayMap();
    private final Map zzb = new ArrayMap();
    private final Set zzc = new ArraySet();
    private final Map zzd = new ArrayMap();

    private zzao() {
    }

    public static synchronized zzao zzd(GoogleApi googleApi, Api.ApiOptions apiOptions) {
        zzan zzanVar;
        Map map;
        try {
            zzanVar = new zzan(googleApi, null);
            map = zza;
            if (!map.containsKey(zzanVar)) {
                map.put(zzanVar, new zzao());
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzao) map.get(zzanVar);
    }

    private final Object zzi(String str) {
        if (!this.zzd.containsKey(str)) {
            this.zzd.put(str, new Object());
        }
        return this.zzd.get(str);
    }

    public final synchronized ListenerHolder.ListenerKey zza(String str, String str2) {
        return ListenerHolders.createListenerKey(zzi(str), "connection");
    }

    public final synchronized ListenerHolder zzb(GoogleApi googleApi, Object obj, String str) {
        ListenerHolder listenerHolderRegisterListener;
        try {
            Preconditions.checkNotNull(obj);
            listenerHolderRegisterListener = googleApi.registerListener(obj, str);
            ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(listenerHolderRegisterListener.getListenerKey(), "Key must not be null");
            Set arraySet = (Set) this.zzb.get(str);
            if (arraySet == null) {
                arraySet = new ArraySet();
                this.zzb.put(str, arraySet);
            }
            arraySet.add(listenerKey);
        } catch (Throwable th) {
            throw th;
        }
        return listenerHolderRegisterListener;
    }

    public final synchronized ListenerHolder zzc(GoogleApi googleApi, String str, String str2) {
        return zzb(googleApi, zzi(str), "connection");
    }

    public final synchronized Task zze(GoogleApi googleApi, RegistrationMethods registrationMethods) {
        ListenerHolder.ListenerKey listenerKey;
        listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Key must not be null");
        return googleApi.doRegisterEventListener(registrationMethods).addOnFailureListener(new zzam(this, googleApi, listenerKey, this.zzc.add(listenerKey)));
    }

    public final synchronized Task zzf(GoogleApi googleApi, String str) {
        ArraySet arraySet = new ArraySet();
        Set set = (Set) this.zzb.get(str);
        if (set == null) {
            return Tasks.whenAll(arraySet);
        }
        for (ListenerHolder.ListenerKey listenerKey : new ArraySet(set)) {
            if (this.zzc.contains(listenerKey)) {
                arraySet.add(zzg(googleApi, listenerKey));
            }
        }
        this.zzb.remove(str);
        return Tasks.whenAll(arraySet);
    }

    public final synchronized Task zzg(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey) {
        String str;
        try {
            this.zzc.remove(listenerKey);
            Iterator it = this.zzb.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                str = (String) it.next();
                Set set = (Set) this.zzb.get(str);
                if (set.contains(listenerKey)) {
                    set.remove(listenerKey);
                    break;
                }
            }
            if (str != null) {
                Iterator it2 = this.zzd.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (ListenerHolders.createListenerKey(entry.getValue(), str).equals(listenerKey)) {
                        this.zzd.remove(entry.getKey());
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return googleApi.doUnregisterEventListener(listenerKey);
    }
}
