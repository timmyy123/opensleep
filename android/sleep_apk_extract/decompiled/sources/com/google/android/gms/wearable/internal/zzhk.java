package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.MessageEvent;

/* JADX INFO: loaded from: classes4.dex */
public final class zzhk extends AbstractSafeParcelable implements MessageEvent {
    public static final Parcelable.Creator<zzhk> CREATOR = new zzhl();
    private final int zza;
    private final String zzb;
    private final byte[] zzc;
    private final String zzd;

    public zzhk(int i, String str, byte[] bArr, String str2) {
        this.zza = i;
        this.zzb = str;
        this.zzc = bArr;
        this.zzd = str2;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final byte[] getData() {
        return this.zzc;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final String getPath() {
        return this.zzb;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final int getRequestId() {
        return this.zza;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final String getSourceNodeId() {
        return this.zzd;
    }

    public final String toString() {
        byte[] bArr = this.zzc;
        Object objValueOf = bArr == null ? "null" : Integer.valueOf(bArr.length);
        String str = this.zzb;
        int i = this.zza;
        String string = objValueOf.toString();
        StringBuilder sb = new StringBuilder(string.length() + zzba$$ExternalSyntheticOutline0.m(String.valueOf(i).length() + 24, 7, String.valueOf(str)) + 1);
        zzba$$ExternalSyntheticOutline0.m(sb, "MessageEventParcelable[", i, ",", str);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", size=", string, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
