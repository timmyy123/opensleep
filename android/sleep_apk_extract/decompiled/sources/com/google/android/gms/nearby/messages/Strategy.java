package com.google.android.gms.nearby.messages;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Strategy extends AbstractSafeParcelable {

    @Deprecated
    public static final Strategy BLE_ONLY;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzf();
    public static final Strategy DEFAULT = new Builder().build();

    @Deprecated
    public static final Strategy zza;
    final int zzb;

    @Deprecated
    final int zzc;
    final int zzd;
    final int zze;

    @Deprecated
    final boolean zzf;
    final int zzg;
    final int zzh;
    private final int zzi;

    public static class Builder {
        private int zza = 3;
        private int zzb = 300;
        private int zzc = 0;
        private int zzd = -1;

        public Strategy build() {
            if (this.zzd != 2 || this.zzc != 1) {
                return new Strategy(2, 0, this.zzb, this.zzc, false, this.zzd, this.zza, 0);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Cannot set EARSHOT with BLE only mode.");
            return null;
        }

        public Builder setTtlSeconds(int i) {
            boolean z = true;
            if (i != Integer.MAX_VALUE && (i <= 0 || i > 86400)) {
                z = false;
            }
            Preconditions.checkArgument(z, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), 86400);
            this.zzb = i;
            return this;
        }

        public final Builder zza(int i) {
            this.zzd = 2;
            return this;
        }
    }

    static {
        Builder builder = new Builder();
        builder.zza(2);
        builder.setTtlSeconds(Integer.MAX_VALUE);
        Strategy strategyBuild = builder.build();
        BLE_ONLY = strategyBuild;
        zza = strategyBuild;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000b A[PHI: r8
      0x000b: PHI (r8v2 int) = (r8v0 int), (r8v1 int) binds: [B:3:0x0009, B:7:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.zzb = i;
        this.zzc = i2;
        if (i2 != 0) {
            if (i2 != 2) {
                i6 = 3;
                if (i2 != 3) {
                    this.zzh = i6;
                } else {
                    this.zzh = 2;
                }
            } else {
                this.zzh = 1;
            }
        }
        this.zze = i4;
        this.zzf = z;
        if (z) {
            this.zzg = 2;
            this.zzd = Integer.MAX_VALUE;
        } else {
            this.zzd = i3;
            if (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 6) {
                this.zzg = -1;
            } else {
                this.zzg = i5;
            }
        }
        this.zzi = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.zzb == strategy.zzb && this.zzh == strategy.zzh && this.zzd == strategy.zzd && this.zze == strategy.zze && this.zzg == strategy.zzg && this.zzi == strategy.zzi;
    }

    public int hashCode() {
        return (((((((((this.zzb * 31) + this.zzh) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzg) * 31) + this.zzi;
    }

    public String toString() {
        String strM;
        String strM2;
        int i = this.zze;
        String strM3 = i != 0 ? i != 1 ? FileInsert$$ExternalSyntheticOutline0.m(i, "UNKNOWN:") : "EARSHOT" : "DEFAULT";
        int i2 = this.zzg;
        if (i2 == -1) {
            strM = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i2 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i2 & 2) > 0) {
                arrayList.add("BLE");
            }
            strM = arrayList.isEmpty() ? FileInsert$$ExternalSyntheticOutline0.m(i2, "UNKNOWN:") : arrayList.toString();
        }
        int i3 = this.zzh;
        if (i3 == 3) {
            strM2 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i3 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i3 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            strM2 = arrayList2.isEmpty() ? FileInsert$$ExternalSyntheticOutline0.m(i3, "UNKNOWN:") : arrayList2.toString();
        }
        int i4 = this.zzi;
        String strM4 = i4 != 0 ? i4 != 1 ? FileInsert$$ExternalSyntheticOutline0.m(i4, "UNKNOWN: ") : "ALWAYS_ON" : "DEFAULT";
        int i5 = this.zzd;
        StringBuilder sb = new StringBuilder("Strategy{ttlSeconds=");
        sb.append(i5);
        sb.append(", distanceType=");
        sb.append(strM3);
        sb.append(", discoveryMedium=");
        FileInsert$$ExternalSyntheticOutline0.m(sb, strM, ", discoveryMode=", strM2, ", backgroundScanMode=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, strM4, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzc;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzd);
        SafeParcelWriter.writeInt(parcel, 3, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 6, this.zzh);
        SafeParcelWriter.writeInt(parcel, 7, this.zzi);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
