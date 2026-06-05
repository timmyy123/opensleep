package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzet;
import com.google.android.gms.internal.auth.zzev;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzet<MessageType extends zzev<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {
    protected zzev zza;
    private final zzev zzb;

    public zzet(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzm()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.zza = messagetype.zzc();
    }

    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzet clone() {
        zzet zzetVar = (zzet) this.zzb.zzn(5, null, null);
        zzetVar.zza = zzd();
        return zzetVar;
    }

    @Override // com.google.android.gms.internal.auth.zzfw
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public MessageType zzd() {
        boolean zZzm = this.zza.zzm();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzm) {
            return messagetype;
        }
        messagetype.zzi();
        return (MessageType) this.zza;
    }
}
