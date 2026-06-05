package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfwu extends AsyncTask {
    private zzfwv zza;
    protected final zzfwm zzd;

    public zzfwu(zzfwm zzfwmVar) {
        this.zzd = zzfwmVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfwv zzfwvVar = this.zza;
        if (zzfwvVar != null) {
            zzfwvVar.zzb(this);
        }
    }

    public final void zzb(zzfwv zzfwvVar) {
        this.zza = zzfwvVar;
    }
}
