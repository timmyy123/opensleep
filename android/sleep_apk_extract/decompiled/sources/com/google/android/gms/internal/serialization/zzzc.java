package com.google.android.gms.internal.serialization;

import com.google.android.gms.internal.serialization.zzza;
import com.google.android.gms.internal.serialization.zzzc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzzc<MessageType extends zzzc<MessageType, BuilderType>, BuilderType extends zzza<MessageType, BuilderType>> extends zzzg<MessageType, BuilderType> implements zzaar {
    protected zzyu<zzzd> extensions = zzyu.zza();

    public zzyu<zzzd> ensureExtensionsAreMutable() {
        if (this.extensions.zzc()) {
            this.extensions = this.extensions.clone();
        }
        return this.extensions;
    }
}
