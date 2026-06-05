package com.google.android.gms.nearby.messages.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zzd();
    final int zza;
    public final String zzb;
    public final String zzc;
    public final boolean zzd;

    @Deprecated
    public final int zze;
    public final String zzf;

    public ClientAppContext(int i, String str, String str2, boolean z, int i2, String str3) {
        this.zza = i;
        this.zzb = (String) Preconditions.checkNotNull(str);
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Locale locale = Locale.US;
            Log.w("NearbyMessages", "ClientAppContext: 0P identifier(" + str2 + ") without 0P prefix(0p:)");
            str2 = "0p:".concat(str2);
        }
        this.zzc = str2;
        this.zzd = z;
        this.zze = i2;
        this.zzf = str3;
    }

    public static final ClientAppContext zza(ClientAppContext clientAppContext, String str, String str2, boolean z) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(1, str, str2, z, 0, null);
    }

    private static boolean zzb(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return zzb(this.zzb, clientAppContext.zzb) && zzb(this.zzc, clientAppContext.zzc) && this.zzd == clientAppContext.zzd && zzb(this.zzf, clientAppContext.zzf) && this.zze == clientAppContext.zze;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zzf, Integer.valueOf(this.zze));
    }

    public final String toString() {
        String str = this.zzb;
        Locale locale = Locale.US;
        String str2 = this.zzc;
        boolean z = this.zzd;
        String str3 = this.zzf;
        int i = this.zze;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("{realClientPackageName: ", str, ", zeroPartyIdentifier: ", str2, ", useRealClientApiKey: ");
        sbM6m.append(z);
        sbM6m.append(", apiKey: ");
        sbM6m.append(str3);
        sbM6m.append(", callingContext: ");
        return FileInsert$$ExternalSyntheticOutline0.m(i, "}", sbM6m);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
