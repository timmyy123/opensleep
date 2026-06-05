package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfyl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfyl> CREATOR = new zzfym();
    public final int zza;
    private zzaym zzb = null;
    private byte[] zzc;

    public zzfyl(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzaym zzaymVar = this.zzb;
        if (zzaymVar != null || this.zzc == null) {
            if (zzaymVar == null || this.zzc != null) {
                if (zzaymVar != null && this.zzc != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Invalid internal representation - full");
                } else if (zzaymVar == null && this.zzc == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Invalid internal representation - empty");
                } else {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Impossible");
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        byte[] bArrZzaN = this.zzc;
        if (bArrZzaN == null) {
            bArrZzaN = this.zzb.zzaN();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArrZzaN, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzaym zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzaym.zzi(this.zzc, zzido.zza());
                this.zzc = null;
            } catch (zziet | NullPointerException e) {
                Events$$ExternalSyntheticBUOutline0.m(e);
                return null;
            }
        }
        zzb();
        return this.zzb;
    }
}
