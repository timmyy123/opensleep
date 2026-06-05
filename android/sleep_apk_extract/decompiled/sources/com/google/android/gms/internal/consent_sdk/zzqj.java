package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzqj;
import com.google.android.gms.internal.consent_sdk.zzqm;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzqj<MessageType extends zzqm<MessageType, BuilderType>, BuilderType extends zzqj<MessageType, BuilderType>> extends zzoz<MessageType, BuilderType> {
    protected zzqm zza;
    private final zzqm zzb;

    public zzqj(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzD()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.zza = messagetype.zzr();
    }

    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzqj clone() {
        zzqj zzqjVar = (zzqj) this.zzb.zzb(5, null, null);
        zzqjVar.zza = zzk();
        return zzqjVar;
    }

    public final MessageType zzi() {
        MessageType messagetype = (MessageType) zzk();
        if (messagetype.zzo()) {
            return messagetype;
        }
        throw new zzso(messagetype);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzrp
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        boolean zZzD = this.zza.zzD();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzD) {
            return messagetype;
        }
        messagetype.zzx();
        return (MessageType) this.zza;
    }

    public final void zzm() {
        if (this.zza.zzD()) {
            return;
        }
        zzn();
    }

    public void zzn() {
        zzqm zzqmVarZzr = this.zzb.zzr();
        zzrx.zza().zzb(zzqmVarZzr.getClass()).zze(zzqmVarZzr, this.zza);
        this.zza = zzqmVarZzr;
    }
}
