package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzhg;
import com.google.android.gms.internal.play_billing.zzhk;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhg<MessageType extends zzhk<MessageType, BuilderType>, BuilderType extends zzhg<MessageType, BuilderType>> extends zzfu<MessageType, BuilderType> {
    protected zzhk zza;
    private final zzhk zzb;

    public zzhg(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzA()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.zza = messagetype.zzp();
    }

    private static void zza(Object obj, Object obj2) {
        zziu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzhg clone() {
        zzhg zzhgVar = (zzhg) this.zzb.zzd(5, null, null);
        zzhgVar.zza = zzh();
        return zzhgVar;
    }

    public final zzhg zze(zzhk zzhkVar) {
        if (!this.zzb.equals(zzhkVar)) {
            if (!this.zza.zzA()) {
                zzk();
            }
            zza(this.zza, zzhkVar);
        }
        return this;
    }

    public final MessageType zzf() {
        MessageType messagetype = (MessageType) zzh();
        if (zzhk.zzz(messagetype, true)) {
            return messagetype;
        }
        throw new zzji(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzil
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public MessageType zzh() {
        boolean zZzA = this.zza.zzA();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzA) {
            return messagetype;
        }
        messagetype.zzv();
        return (MessageType) this.zza;
    }

    public final void zzj() {
        if (this.zza.zzA()) {
            return;
        }
        zzk();
    }

    public void zzk() {
        zzhk zzhkVarZzp = this.zzb.zzp();
        zza(zzhkVarZzp, this.zza);
        this.zza = zzhkVarZzp;
    }
}
