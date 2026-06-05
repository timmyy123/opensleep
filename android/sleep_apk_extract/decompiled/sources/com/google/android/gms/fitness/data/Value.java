package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.HexDumpUtils;
import com.google.android.gms.internal.fitness.zzfh;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class Value extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new zzai();
    private final int zza;
    private boolean zzb;
    private float zzc;
    private String zzd;
    private Map zze;
    private int[] zzf;
    private float[] zzg;
    private byte[] zzh;

    public Value(int i, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        ArrayMap arrayMap;
        this.zza = i;
        this.zzb = z;
        this.zzc = f;
        this.zzd = str;
        if (bundle == null) {
            arrayMap = null;
        } else {
            bundle.setClassLoader((ClassLoader) Preconditions.checkNotNull(MapValue.class.getClassLoader()));
            arrayMap = new ArrayMap(bundle.size());
            for (String str2 : bundle.keySet()) {
                arrayMap.put(str2, (MapValue) Preconditions.checkNotNull((MapValue) bundle.getParcelable(str2)));
            }
        }
        this.zze = arrayMap;
        this.zzf = iArr;
        this.zzg = fArr;
        this.zzh = bArr;
    }

    public String asActivity() {
        return zzfh.zzb(asInt());
    }

    public float asFloat() {
        Preconditions.checkState(this.zza == 2, "Value is not in float format");
        return this.zzc;
    }

    public int asInt() {
        Preconditions.checkState(this.zza == 1, "Value is not in int format");
        return Float.floatToRawIntBits(this.zzc);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        int i = this.zza;
        if (i != value.zza || this.zzb != value.zzb) {
            return false;
        }
        if (i != 1) {
            if (i == 3) {
                return Objects.equal(this.zzd, value.zzd);
            }
            if (i == 4) {
                return Objects.equal(this.zze, value.zze);
            }
            if (i == 5) {
                return Arrays.equals(this.zzf, value.zzf);
            }
            if (i == 6) {
                return Arrays.equals(this.zzg, value.zzg);
            }
            if (i == 7) {
                return Arrays.equals(this.zzh, value.zzh);
            }
            if (this.zzc != value.zzc) {
                return false;
            }
        } else if (asInt() != value.asInt()) {
            return false;
        }
        return true;
    }

    public int getFormat() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }

    public boolean isSet() {
        return this.zzb;
    }

    @Deprecated
    public void setFloat(float f) {
        Preconditions.checkState(this.zza == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        this.zzc = f;
    }

    @Deprecated
    public void setInt(int i) {
        Preconditions.checkState(this.zza == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        this.zzc = Float.intBitsToFloat(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0041 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String strDump;
        if (!this.zzb) {
            return "unset";
        }
        switch (this.zza) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(this.zzc);
            case 3:
                String str = this.zzd;
                return str == null ? "" : str;
            case 4:
                Map map = this.zze;
                return map == null ? "" : new TreeMap(map).toString();
            case 5:
                return Arrays.toString(this.zzf);
            case 6:
                return Arrays.toString(this.zzg);
            case 7:
                byte[] bArr = this.zzh;
                if (bArr != null && (strDump = HexDumpUtils.dump(bArr, 0, bArr.length, false)) != null) {
                    return strDump;
                }
                break;
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getFormat());
        SafeParcelWriter.writeBoolean(parcel, 2, isSet());
        SafeParcelWriter.writeFloat(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        Map map = this.zze;
        if (map == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle(map.size());
            for (Map.Entry entry : this.zze.entrySet()) {
                bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
            bundle = bundle2;
        }
        SafeParcelWriter.writeBundle(parcel, 5, bundle, false);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeFloatArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
