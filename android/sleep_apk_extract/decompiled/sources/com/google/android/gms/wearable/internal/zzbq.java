package com.google.android.gms.wearable.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.ChannelApi;

/* JADX INFO: loaded from: classes4.dex */
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbr();
    final zzcb zza;
    final int zzb;
    final int zzc;
    final int zzd;

    public zzbq(zzcb zzcbVar, int i, int i2, int i3) {
        this.zza = zzcbVar;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final String toString() {
        int i = this.zzb;
        String strValueOf = String.valueOf(this.zza);
        String string = i != 1 ? i != 2 ? i != 3 ? i != 4 ? Integer.toString(i) : "OUTPUT_CLOSED" : "INPUT_CLOSED" : "CHANNEL_CLOSED" : "CHANNEL_OPENED";
        int i2 = this.zzc;
        String string2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? Integer.toString(i2) : "CLOSE_REASON_LOCAL_CLOSE" : "CLOSE_REASON_REMOTE_CLOSE" : "CLOSE_REASON_DISCONNECTED" : "CLOSE_REASON_NORMAL";
        int i3 = this.zzd;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + String.valueOf(string2).length() + String.valueOf(string).length() + strValueOf.length() + 40 + 14 + 15 + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "ChannelEventParcelable[, channel=", strValueOf, ", type=", string);
        zzba$$ExternalSyntheticOutline0.m(sb, ", closeReason=", string2, ", appErrorCode=", i3);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzcb zzcbVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzcbVar, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeInt(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final void zza(ChannelApi.ChannelListener channelListener) {
        int i = this.zzb;
        if (i == 1) {
            channelListener.onChannelOpened(this.zza);
            return;
        }
        if (i == 2) {
            channelListener.onChannelClosed(this.zza, this.zzc, this.zzd);
            return;
        }
        if (i == 3) {
            channelListener.onInputClosed(this.zza, this.zzc, this.zzd);
            return;
        }
        if (i == 4) {
            channelListener.onOutputClosed(this.zza, this.zzc, this.zzd);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 14);
        sb.append("Unknown type: ");
        sb.append(i);
        Log.w("ChannelEventParcelable", sb.toString());
    }
}
