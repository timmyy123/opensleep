package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzidy;
import com.google.android.gms.internal.ads.zziee;
import java.io.IOException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzidy<MessageType extends zziee<MessageType, BuilderType>, BuilderType extends zzidy<MessageType, BuilderType>> extends zzici<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    public zzidy(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaX()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.zza = (MessageType) zza();
    }

    private MessageType zza() {
        return (MessageType) this.zzb.zzbg();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzifz.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.ads.zzici
    public /* bridge */ /* synthetic */ zzici zzaK(byte[] bArr, int i, int i2, zzido zzidoVar) throws zziet {
        zzbp(bArr, i, i2, zzidoVar);
        return this;
    }

    public final void zzbg() {
        if (this.zza.zzaX()) {
            return;
        }
        zzbh();
    }

    public void zzbh() {
        MessageType messagetype = (MessageType) zza();
        zzb(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    public final boolean zzbi() {
        return zziee.zzg(this.zza, false);
    }

    /* JADX INFO: renamed from: zzbk, reason: merged with bridge method [inline-methods] */
    public BuilderType clone() {
        BuilderType buildertype = (BuilderType) zzbs().zzcY();
        buildertype.zza = (MessageType) zzbt();
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzifo
    /* JADX INFO: renamed from: zzbl, reason: merged with bridge method [inline-methods] */
    public MessageType zzbt() {
        boolean zZzaX = this.zza.zzaX();
        MessageType messagetype = this.zza;
        if (!zZzaX) {
            return messagetype;
        }
        messagetype.zzbm();
        return this.zza;
    }

    public final MessageType zzbm() {
        MessageType messagetype = (MessageType) zzbt();
        if (messagetype.zzbi()) {
            return messagetype;
        }
        throw zzici.zzaR(messagetype);
    }

    public BuilderType zzbo(MessageType messagetype) {
        if (zzbs().equals(messagetype)) {
            return this;
        }
        zzbg();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbp(byte[] bArr, int i, int i2, zzido zzidoVar) throws zziet {
        zzbg();
        try {
            zzifz.zza().zzb(this.zza.getClass()).zzj(this.zza, bArr, i, i + i2, new zzico(zzidoVar));
            return this;
        } catch (zziet e) {
            throw e;
        } catch (IOException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m("Reading from byte array should not throw IOException.", (Throwable) e2);
            return null;
        } catch (IndexOutOfBoundsException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
    }

    public MessageType zzbs() {
        return this.zzb;
    }
}
