package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjh> CREATOR = new zzji();
    public final String zza;

    @Nullable
    public final byte[] zzb;
    public final String zzc;
    public final zzjf[] zzd;
    public final Map zze = new TreeMap();
    public final boolean zzf;
    public final long zzg;

    public zzjh(String str, String str2, zzjf[] zzjfVarArr, boolean z, @Nullable byte[] bArr, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzd = zzjfVarArr;
        this.zzf = z;
        this.zzb = bArr;
        this.zzg = j;
        for (zzjf zzjfVar : zzjfVarArr) {
            this.zze.put(Integer.valueOf(zzjfVar.zza), zzjfVar);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzjh) {
            zzjh zzjhVar = (zzjh) obj;
            if (zzkl.zza(this.zza, zzjhVar.zza) && zzkl.zza(this.zzc, zzjhVar.zzc) && this.zze.equals(zzjhVar.zze) && this.zzf == zzjhVar.zzf && Arrays.equals(this.zzb, zzjhVar.zzb) && this.zzg == zzjhVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzc, this.zze, Boolean.valueOf(this.zzf), this.zzb, Long.valueOf(this.zzg)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Configurations('");
        sb.append(this.zza);
        sb.append("', '");
        sb.append(this.zzc);
        sb.append("', (");
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            sb.append((zzjf) it.next());
            sb.append(", ");
        }
        sb.append("), ");
        sb.append(this.zzf);
        sb.append(", ");
        byte[] bArr = this.zzb;
        sb.append(bArr == null ? "null" : Base64.encodeToString(bArr, 3));
        sb.append(", ");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.zzg, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzf);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
