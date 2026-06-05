package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class DataTypeCreateRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzn();
    private final String zza;
    private final List zzb;
    private final com.google.android.gms.internal.fitness.zzbc zzc;

    public DataTypeCreateRequest(String str, List list, IBinder iBinder) {
        this.zza = str;
        this.zzb = Collections.unmodifiableList(list);
        this.zzc = iBinder == null ? null : com.google.android.gms.internal.fitness.zzbb.zzb(iBinder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataTypeCreateRequest)) {
            return false;
        }
        DataTypeCreateRequest dataTypeCreateRequest = (DataTypeCreateRequest) obj;
        return Objects.equal(this.zza, dataTypeCreateRequest.zza) && Objects.equal(this.zzb, dataTypeCreateRequest.zzb);
    }

    public List<Field> getFields() {
        return this.zzb;
    }

    public String getName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.zza).add("fields", this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getFields(), false);
        com.google.android.gms.internal.fitness.zzbc zzbcVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzbcVar == null ? null : zzbcVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
