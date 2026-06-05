package com.google.android.gms.home.matter.commissioning;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.home.matter.common.Discriminator;

/* JADX INFO: loaded from: classes3.dex */
public final class CommissioningWindow extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommissioningWindow> CREATOR = new zzg();
    private final Discriminator zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;

    public CommissioningWindow(Discriminator discriminator, long j, long j2, long j3) {
        this.zza = (Discriminator) Preconditions.checkNotNull(discriminator);
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommissioningWindow)) {
            return false;
        }
        CommissioningWindow commissioningWindow = (CommissioningWindow) obj;
        return Objects.equal(this.zza, commissioningWindow.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(commissioningWindow.zzb)) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(commissioningWindow.zzc)) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(commissioningWindow.zzd));
    }

    public Discriminator getDiscriminator() {
        return this.zza;
    }

    public long getDurationSeconds() {
        return this.zzd;
    }

    public long getPasscode() {
        return this.zzb;
    }

    public long getWindowOpenMillis() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDiscriminator(), i, false);
        SafeParcelWriter.writeLong(parcel, 2, getPasscode());
        SafeParcelWriter.writeLong(parcel, 3, getWindowOpenMillis());
        SafeParcelWriter.writeLong(parcel, 4, getDurationSeconds());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
