package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class PutDataRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzq();
    private static final long zza = 1800000;
    private static final Random zzb = new SecureRandom();
    private final Uri zzc;
    private final Bundle zzd;
    private byte[] zze;
    private long zzf;

    public PutDataRequest(Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.zzc = uri;
        this.zzd = bundle;
        ClassLoader classLoader = DataItemAssetParcelable.class.getClassLoader();
        classLoader.getClass();
        bundle.setClassLoader(classLoader);
        this.zze = bArr;
        this.zzf = j;
    }

    public byte[] getData() {
        return this.zze;
    }

    public Uri getUri() {
        return this.zzc;
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        byte[] bArr = this.zze;
        sb.append("dataSz=".concat((bArr == null ? "null" : Integer.valueOf(bArr.length)).toString()));
        Bundle bundle = this.zzd;
        int size = bundle.size();
        StringBuilder sb2 = new StringBuilder(String.valueOf(size).length() + 12);
        sb2.append(", numAssets=");
        sb2.append(size);
        sb.append(sb2.toString());
        sb.append(", uri=".concat(String.valueOf(this.zzc)));
        long j = this.zzf;
        StringBuilder sb3 = new StringBuilder(String.valueOf(j).length() + 15);
        sb3.append(", syncDeadline=");
        sb3.append(j);
        sb.append(sb3.toString());
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : bundle.keySet()) {
            String strValueOf = String.valueOf(bundle.getParcelable(str));
            sb.append(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(zzba$$ExternalSyntheticOutline0.m(7, str) + strValueOf.length()), "\n    ", str, ": ", strValueOf));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.internal.wearable.zzai.zzd(parcel, "dest must not be null");
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public String toString() {
        return toString(Log.isLoggable("DataMap", 3));
    }
}
