package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcec implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcef zza;
    private final String zzb;

    public zzcec(zzcef zzcefVar, String str) {
        Objects.requireNonNull(zzcefVar);
        this.zza = zzcefVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzcef zzcefVar = this.zza;
        synchronized (zzcefVar) {
            try {
                Iterator it = zzcefVar.zzd().iterator();
                while (it.hasNext()) {
                    ((zzced) it.next()).zza(sharedPreferences, this.zzb, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
