package com.google.android.gms.internal.serialization;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcz {
    public abstract Object zza(Object obj);

    @CheckForNull
    public final Object zzb(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        return zza(obj);
    }
}
