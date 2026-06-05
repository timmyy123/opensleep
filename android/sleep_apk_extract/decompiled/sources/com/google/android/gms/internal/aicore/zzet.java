package com.google.android.gms.internal.aicore;

import com.google.android.gms.internal.aicore.zzet;
import com.google.android.gms.internal.aicore.zzex;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzet<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
    protected zzex zza;
    private final zzex zzb;

    public zzet(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzi()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.zza = messagetype.zzk();
    }

    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzet clone() {
        zzet zzetVar = (zzet) this.zzb.zzd(5, null, null);
        zzetVar.zza = zze();
        return zzetVar;
    }

    @Override // com.google.android.gms.internal.aicore.zzfz
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public MessageType zze() {
        boolean zZzi = this.zza.zzi();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzi) {
            return messagetype;
        }
        messagetype.zzm();
        return (MessageType) this.zza;
    }
}
