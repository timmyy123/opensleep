package com.google.android.gms.home.matter.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class Discriminator extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Discriminator> CREATOR = new zzb();
    private final int zza;
    private final int zzb;

    public Discriminator(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Discriminator)) {
            return false;
        }
        Discriminator discriminator = (Discriminator) obj;
        return this.zza == discriminator.zza && this.zzb == discriminator.zzb;
    }

    public int getValue() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public String toString() {
        return String.format(Locale.ROOT, "%s[0x%03X]", this.zzb == 4095 ? "L" : "S", Integer.valueOf(this.zza));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getValue());
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
