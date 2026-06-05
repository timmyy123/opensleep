package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjo extends AbstractSafeParcelable implements Comparable<zzjo> {
    public static final Parcelable.Creator<zzjo> CREATOR = new zzjp();
    public final String zza;
    final long zzb;
    final boolean zzc;
    final double zzd;

    @Nullable
    final String zze;

    @Nullable
    final byte[] zzf;
    public final int zzg;
    public final int zzh;
    private final int zzi;

    public zzjo(String str, long j, boolean z, double d, @Nullable String str2, @Nullable byte[] bArr, int i, int i2, int i3) {
        this.zza = str;
        this.zzb = j;
        this.zzc = z;
        this.zzd = d;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = i3;
    }

    private static int zzg(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i != i2 ? 1 : 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(zzjo zzjoVar) {
        zzjo zzjoVar2 = zzjoVar;
        int iCompareTo = this.zza.compareTo(zzjoVar2.zza);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.zzg;
        int iZzg = zzg(i, zzjoVar2.zzg);
        if (iZzg != 0) {
            return iZzg;
        }
        int i2 = 0;
        if (i == 1) {
            long j = this.zzb;
            long j2 = zzjoVar2.zzb;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
        if (i == 2) {
            boolean z = this.zzc;
            if (z == zzjoVar2.zzc) {
                return 0;
            }
            return z ? 1 : -1;
        }
        if (i == 3) {
            return Double.compare(this.zzd, zzjoVar2.zzd);
        }
        if (i == 4) {
            String str = this.zze;
            String str2 = zzjoVar2.zze;
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
        if (i != 5) {
            Utf8$$ExternalSyntheticBUOutline0.m$1((Object) zzba$$ExternalSyntheticOutline0.m(i, "Invalid enum value: ", new StringBuilder(String.valueOf(i).length() + 20)));
            return 0;
        }
        byte[] bArr = this.zzf;
        byte[] bArr2 = zzjoVar2.zzf;
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        while (true) {
            int length = bArr2.length;
            int length2 = bArr.length;
            if (i2 >= Math.min(length2, length)) {
                return zzg(length2, length);
            }
            int i3 = bArr[i2] - bArr2[i2];
            if (i3 != 0) {
                return i3;
            }
            i2++;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        int i;
        if (obj instanceof zzjo) {
            zzjo zzjoVar = (zzjo) obj;
            if (zzkl.zza(this.zza, zzjoVar.zza) && (i = this.zzg) == zzjoVar.zzg && this.zzh == zzjoVar.zzh && this.zzi == zzjoVar.zzi) {
                if (i == 1) {
                    return this.zzb == zzjoVar.zzb;
                }
                if (i == 2) {
                    return this.zzc == zzjoVar.zzc;
                }
                if (i == 3) {
                    return this.zzd == zzjoVar.zzd;
                }
                if (i == 4) {
                    return zzkl.zza(this.zze, zzjoVar.zze);
                }
                if (i == 5) {
                    return Arrays.equals(this.zzf, zzjoVar.zzf);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$1((Object) zzba$$ExternalSyntheticOutline0.m(i, "Invalid enum value: ", new StringBuilder(String.valueOf(i).length() + 20)));
                return false;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        zzf(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        boolean zZzb = zzjp.zzb(str);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zZzb) {
            SafeParcelWriter.writeString(parcel, 2, str, false);
        }
        long j = this.zzb;
        if (j != 0) {
            SafeParcelWriter.writeLong(parcel, 3, j);
        }
        if (this.zzc) {
            SafeParcelWriter.writeBoolean(parcel, 4, true);
        }
        double d = this.zzd;
        if (d != 0.0d) {
            SafeParcelWriter.writeDouble(parcel, 5, d);
        }
        String str2 = this.zze;
        if (!zzjp.zzb(str2)) {
            SafeParcelWriter.writeString(parcel, 6, str2, false);
        }
        byte[] bArr = this.zzf;
        if (!zzjp.zzb(bArr)) {
            SafeParcelWriter.writeByteArray(parcel, 7, bArr, false);
        }
        int i2 = this.zzg;
        if (!zzjp.zza(i2)) {
            SafeParcelWriter.writeInt(parcel, 8, i2);
        }
        int i3 = this.zzh;
        if (!zzjp.zza(i3)) {
            SafeParcelWriter.writeInt(parcel, 9, i3);
        }
        int i4 = this.zzi;
        if (!zzjp.zza(i4)) {
            SafeParcelWriter.writeInt(parcel, 10, i4);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        if (this.zzg == 1) {
            return this.zzb;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Not a long type");
        return 0L;
    }

    public final boolean zzb() {
        if (this.zzg == 2) {
            return this.zzc;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Not a boolean type");
        return false;
    }

    public final double zzc() {
        if (this.zzg == 3) {
            return this.zzd;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Not a double type");
        return 0.0d;
    }

    public final String zzd() {
        if (this.zzg == 4) {
            return (String) Preconditions.checkNotNull(this.zze);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Not a String type");
        return null;
    }

    public final byte[] zze() {
        if (this.zzg == 5) {
            return (byte[]) Preconditions.checkNotNull(this.zzf);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Not a bytes type");
        return null;
    }

    public final void zzf(StringBuilder sb) {
        sb.append("Flag(");
        String str = this.zza;
        sb.append(str);
        sb.append(", ");
        int i = this.zzg;
        if (i == 1) {
            sb.append(this.zzb);
        } else if (i == 2) {
            sb.append(this.zzc);
        } else if (i == 3) {
            sb.append(this.zzd);
        } else if (i == 4) {
            sb.append("'");
            sb.append((String) Preconditions.checkNotNull(this.zze));
            sb.append("'");
        } else {
            if (i != 5) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(i).length());
                sb2.append("Invalid type: ");
                sb2.append(str);
                sb2.append(", ");
                sb2.append(i);
                throw new AssertionError(sb2.toString());
            }
            sb.append("'");
            sb.append(Base64.encodeToString((byte[]) Preconditions.checkNotNull(this.zzf), 3));
            sb.append("'");
        }
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(this.zzh);
        sb.append(", ");
        sb.append(this.zzi);
        sb.append(")");
    }
}
