package com.google.android.gms.fitness.data;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class DataSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR;
    private static final String zza;
    private static final String zzb;
    private final DataType zzc;
    private final int zzd;
    private final Device zze;
    private final zzb zzf;
    private final String zzg;
    private final String zzh;

    static {
        Locale locale = Locale.ROOT;
        zza = "RAW".toLowerCase(locale);
        zzb = "DERIVED".toLowerCase(locale);
        CREATOR = new zzh();
    }

    public DataSource(DataType dataType, int i, Device device, zzb zzbVar, String str) {
        this.zzc = dataType;
        this.zzd = i;
        this.zze = device;
        this.zzf = zzbVar;
        this.zzg = str;
        StringBuilder sb = new StringBuilder();
        sb.append(zzc(i));
        sb.append(":");
        sb.append(dataType.getName());
        if (zzbVar != null) {
            sb.append(":");
            sb.append(zzbVar.zza());
        }
        if (device != null) {
            sb.append(":");
            sb.append(device.zza());
        }
        if (str != null) {
            sb.append(":");
            sb.append(str);
        }
        this.zzh = sb.toString();
    }

    private static String zzc(int i) {
        return i != 0 ? i != 1 ? zzb : zzb : zza;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DataSource) {
            return this.zzh.equals(((DataSource) obj).zzh);
        }
        return false;
    }

    public DataType getDataType() {
        return this.zzc;
    }

    public Device getDevice() {
        return this.zze;
    }

    public String getStreamIdentifier() {
        return this.zzh;
    }

    public String getStreamName() {
        return this.zzg;
    }

    public int getType() {
        return this.zzd;
    }

    public int hashCode() {
        return this.zzh.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(zzc(this.zzd));
        zzb zzbVar = this.zzf;
        if (zzbVar != null) {
            sb.append(":");
            sb.append(zzbVar);
        }
        Device device = this.zze;
        if (device != null) {
            sb.append(":");
            sb.append(device);
        }
        String str = this.zzg;
        if (str != null) {
            sb.append(":");
            sb.append(str);
        }
        sb.append(":");
        sb.append(this.zzc);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataType(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDevice(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzf, i, false);
        SafeParcelWriter.writeString(parcel, 6, getStreamName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzb zza() {
        return this.zzf;
    }

    public final String zzb() {
        String strM;
        int i = this.zzd;
        String str = i != 0 ? i != 1 ? "?" : "d" : "r";
        DataType dataType = this.zzc;
        zzb zzbVar = this.zzf;
        String strZzc = dataType.zzc();
        String strConcat = zzbVar == null ? "" : zzbVar.equals(zzb.zza) ? ":gms" : ":".concat(String.valueOf(zzbVar.zza()));
        Device device = this.zze;
        if (device != null) {
            String model = device.getModel();
            String uid = device.getUid();
            strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(model).length() + 2 + String.valueOf(uid).length()), ":", model, ":", uid);
        } else {
            strM = "";
        }
        String str2 = this.zzg;
        String strConcat2 = str2 != null ? ":".concat(str2) : "";
        StringBuilder sb = new StringBuilder(strConcat2.length() + FileInsert$$ExternalSyntheticOutline0.m(str.length() + 1, String.valueOf(strZzc).length(), strConcat.length(), strM.length()));
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, ":", strZzc, strConcat);
        return FileInsert$$ExternalSyntheticOutline0.m(sb, strM, strConcat2);
    }

    public static final class Builder {
        private DataType zza;
        private Device zzc;
        private zzb zzd;
        private int zzb = -1;
        private String zze = "";

        public DataSource build() {
            Preconditions.checkState(this.zza != null, "Must set data type");
            Preconditions.checkState(this.zzb >= 0, "Must set data source type");
            String str = this.zze;
            zzb zzbVar = this.zzd;
            return new DataSource(this.zza, this.zzb, this.zzc, zzbVar, str);
        }

        public Builder setAppPackageName(String str) {
            zzb zzbVar = zzb.zza;
            this.zzd = "com.google.android.gms".equals(str) ? zzb.zza : new zzb(str);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zza = dataType;
            return this;
        }

        public Builder setStreamName(String str) {
            Preconditions.checkArgument(str != null, "Must specify a valid stream name");
            this.zze = str;
            return this;
        }

        public Builder setType(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setAppPackageName(Context context) {
            setAppPackageName(context.getPackageName());
            return this;
        }
    }
}
