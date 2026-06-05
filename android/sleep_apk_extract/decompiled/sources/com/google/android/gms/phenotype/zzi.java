package com.google.android.gms.phenotype;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Comparator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new zzk();
    private static final Comparator<zzi> zzai = new zzj();
    public final String name;
    private final long zzab;
    private final boolean zzac;
    private final double zzad;
    private final String zzae;
    private final byte[] zzaf;
    private final int zzag;
    public final int zzah;

    public zzi(String str, long j, boolean z, double d, String str2, byte[] bArr, int i, int i2) {
        this.name = str;
        this.zzab = j;
        this.zzac = z;
        this.zzad = d;
        this.zzae = str2;
        this.zzaf = bArr;
        this.zzag = i;
        this.zzah = i2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzi zziVar) {
        zzi zziVar2 = zziVar;
        int iCompareTo = this.name.compareTo(zziVar2.name);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompare = compare(this.zzag, zziVar2.zzag);
        if (iCompare != 0) {
            return iCompare;
        }
        int i = this.zzag;
        int i2 = 0;
        if (i == 1) {
            long j = this.zzab;
            long j2 = zziVar2.zzab;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
        if (i == 2) {
            boolean z = this.zzac;
            if (z == zziVar2.zzac) {
                return 0;
            }
            return z ? 1 : -1;
        }
        if (i == 3) {
            return Double.compare(this.zzad, zziVar2.zzad);
        }
        if (i == 4) {
            String str = this.zzae;
            String str2 = zziVar2.zzae;
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
            Utf8$$ExternalSyntheticBUOutline0.m$1((Object) zzba$$ExternalSyntheticOutline0.m256m(31, i, "Invalid enum value: "));
            return 0;
        }
        byte[] bArr = this.zzaf;
        byte[] bArr2 = zziVar2.zzaf;
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
            int iMin = Math.min(this.zzaf.length, zziVar2.zzaf.length);
            byte[] bArr3 = this.zzaf;
            if (i2 >= iMin) {
                return compare(bArr3.length, zziVar2.zzaf.length);
            }
            int i3 = bArr3[i2] - zziVar2.zzaf[i2];
            if (i3 != 0) {
                return i3;
            }
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        int i;
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (zzn.equals(this.name, zziVar.name) && (i = this.zzag) == zziVar.zzag && this.zzah == zziVar.zzah) {
                if (i != 1) {
                    if (i == 2) {
                        return this.zzac == zziVar.zzac;
                    }
                    if (i == 3) {
                        return this.zzad == zziVar.zzad;
                    }
                    if (i == 4) {
                        return zzn.equals(this.zzae, zziVar.zzae);
                    }
                    if (i == 5) {
                        return Arrays.equals(this.zzaf, zziVar.zzaf);
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$1((Object) zzba$$ExternalSyntheticOutline0.m256m(31, i, "Invalid enum value: "));
                    return false;
                }
                if (this.zzab == zziVar.zzab) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Flag(");
        sb.append(this.name);
        sb.append(", ");
        int i = this.zzag;
        if (i == 1) {
            sb.append(this.zzab);
        } else if (i == 2) {
            sb.append(this.zzac);
        } else if (i == 3) {
            sb.append(this.zzad);
        } else if (i == 4) {
            sb.append("'");
            sb.append(this.zzae);
            sb.append("'");
        } else {
            if (i != 5) {
                String str = this.name;
                StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(27, str));
                sb2.append("Invalid type: ");
                sb2.append(str);
                sb2.append(", ");
                sb2.append(i);
                throw new AssertionError(sb2.toString());
            }
            if (this.zzaf == null) {
                sb.append("null");
            } else {
                sb.append("'");
                sb.append(Base64.encodeToString(this.zzaf, 3));
                sb.append("'");
            }
        }
        sb.append(", ");
        sb.append(this.zzag);
        sb.append(", ");
        return FileInsert$$ExternalSyntheticOutline0.m(this.zzah, ")", sb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzab);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzac);
        SafeParcelWriter.writeDouble(parcel, 5, this.zzad);
        SafeParcelWriter.writeString(parcel, 6, this.zzae, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzaf, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzag);
        SafeParcelWriter.writeInt(parcel, 9, this.zzah);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
