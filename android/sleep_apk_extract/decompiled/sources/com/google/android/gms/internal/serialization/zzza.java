package com.google.android.gms.internal.serialization;

import com.google.android.gms.internal.serialization.zzza;
import com.google.android.gms.internal.serialization.zzzc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzza<MessageType extends zzzc<MessageType, BuilderType>, BuilderType extends zzza<MessageType, BuilderType>> extends zzyy<MessageType, BuilderType> implements zzaar {
    public zzza(MessageType messagetype) {
        super(messagetype);
    }

    @Override // com.google.android.gms.internal.serialization.zzyy, com.google.android.gms.internal.serialization.zzaap
    public final MessageType buildPartial() {
        boolean zIsMutable = ((zzzc) this.instance).isMutable();
        MessageType messagetype = this.instance;
        if (!zIsMutable) {
            return (MessageType) messagetype;
        }
        ((zzzc) messagetype).extensions.zzb();
        return (MessageType) super.buildPartial();
    }

    @Override // com.google.android.gms.internal.serialization.zzyy
    public void copyOnWriteInternal() {
        super.copyOnWriteInternal();
        if (((zzzc) this.instance).extensions != zzyu.zza()) {
            zzzc zzzcVar = (zzzc) this.instance;
            zzzcVar.extensions = zzzcVar.extensions.clone();
        }
    }
}
