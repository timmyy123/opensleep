package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzko extends zzgo {
    private ListenerHolder zza;
    private ListenerHolder zzb;
    private ListenerHolder zzc;
    private ListenerHolder zzd;
    private ListenerHolder zze;
    private final IntentFilter[] zzf;
    private final String zzg;

    private zzko(IntentFilter[] intentFilterArr, String str) {
        this.zzf = intentFilterArr;
        this.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzA(zzgj zzgjVar, boolean z, byte[] bArr) {
        try {
            zzgjVar.zzd(z, bArr);
        } catch (RemoteException e) {
            Log.e("WearableListenerStub", "Failed to send a response back", e);
        }
    }

    public static zzko zzm(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzko zzkoVar = new zzko(intentFilterArr, null);
        listenerHolder.getClass();
        zzkoVar.zzb = listenerHolder;
        return zzkoVar;
    }

    private static void zzz(ListenerHolder listenerHolder) {
        if (listenerHolder != null) {
            listenerHolder.clear();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzb(DataHolder dataHolder) {
        ListenerHolder listenerHolder = this.zza;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzkj(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzc(zzhk zzhkVar) {
        ListenerHolder listenerHolder = this.zzb;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzkk(zzhkVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzd(zzib zzibVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zze(zzib zzibVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzf(List list) {
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzg(zzao zzaoVar) {
        ListenerHolder listenerHolder = this.zze;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzki(zzaoVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzh(zzl zzlVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzi(zzj zzjVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzj(zzbq zzbqVar) {
        ListenerHolder listenerHolder = this.zzd;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzkn(zzbqVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzk(zzia zziaVar) {
        zziaVar.zzb.close();
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final void zzn(zzhk zzhkVar, zzgj zzgjVar) {
        ListenerHolder listenerHolder = this.zzc;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzkm(zzhkVar, zzgjVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzgp
    public final boolean zzo(zzft zzftVar, zzgk zzgkVar) {
        return false;
    }

    public final void zzu() {
        zzz(this.zza);
        this.zza = null;
        zzz(this.zzb);
        this.zzb = null;
        zzz(this.zzc);
        this.zzc = null;
        zzz(this.zzd);
        this.zzd = null;
        zzz(this.zze);
        this.zze = null;
    }

    public final IntentFilter[] zzv() {
        return this.zzf;
    }

    public final String zzw() {
        return this.zzg;
    }
}
