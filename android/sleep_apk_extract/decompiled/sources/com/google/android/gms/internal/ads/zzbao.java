package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbao extends zzban {
    private zzbao(Context context, zzbam zzbamVar) {
        super(context, zzbamVar);
    }

    public static zzbao zzt(Context context, zzawo zzawoVar) {
        zzbam zzbamVar = new zzbam(zzawoVar);
        zzban.zzo(context, zzbamVar);
        return new zzbao(context, zzbamVar);
    }
}
