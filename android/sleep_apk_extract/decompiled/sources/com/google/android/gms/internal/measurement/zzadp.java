package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzadp;
import com.google.android.gms.internal.measurement.zzadu;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzadp<MessageType extends zzadu<MessageType, BuilderType>, BuilderType extends zzadp<MessageType, BuilderType>> extends zzaca<MessageType, BuilderType> {
    protected zzadu zza;
    private final zzadu zzb;

    public zzadp(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzch()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.zza = messagetype.zzck();
    }

    private static void zza(Object obj, Object obj2) {
        zzafl.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzaca
    public final /* bridge */ /* synthetic */ zzaca zzaT(byte[] bArr, int i, int i2) throws zzaeh {
        zzadf zzadfVar = zzadf.zza;
        int i3 = zzacf.$r8$clinit;
        zzbf(bArr, 0, i2, zzadf.zza);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzaca
    public final /* bridge */ /* synthetic */ zzaca zzaU(byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        zzbf(bArr, 0, i2, zzadfVar);
        return this;
    }

    public final void zzaY() {
        if (this.zza.zzch()) {
            return;
        }
        zzaZ();
    }

    public void zzaZ() {
        zzadu zzaduVarZzck = this.zzb.zzck();
        zza(zzaduVarZzck, this.zza);
        this.zza = zzaduVarZzck;
    }

    /* JADX INFO: renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public final zzadp clone() {
        zzadp zzadpVar = (zzadp) this.zzb.zzg(5, null, null);
        zzadpVar.zza = zzbg();
        return zzadpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzafb
    /* JADX INFO: renamed from: zzbc, reason: merged with bridge method [inline-methods] */
    public MessageType zzbg() {
        boolean zZzch = this.zza.zzch();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzch) {
            return messagetype;
        }
        messagetype.zzcm();
        return (MessageType) this.zza;
    }

    public final MessageType zzbd() {
        MessageType messagetype = (MessageType) zzbg();
        if (messagetype.zzcJ()) {
            return messagetype;
        }
        throw new zzafy(messagetype);
    }

    public final zzadp zzbe(zzadu zzaduVar) {
        if (!this.zzb.equals(zzaduVar)) {
            if (!this.zza.zzch()) {
                zzaZ();
            }
            zza(this.zza, zzaduVar);
        }
        return this;
    }

    public final zzadp zzbf(byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        if (!this.zza.zzch()) {
            zzaZ();
        }
        try {
            zzafl.zza().zzb(this.zza.getClass()).zzj(this.zza, bArr, 0, i2, new zzacg(zzadfVar));
            return this;
        } catch (zzaeh e) {
            throw e;
        } catch (IOException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m("Reading from byte array should not throw IOException.", (Throwable) e2);
            return null;
        } catch (IndexOutOfBoundsException unused) {
            Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final boolean zzcJ() {
        return zzadu.zzd(this.zza, false);
    }
}
