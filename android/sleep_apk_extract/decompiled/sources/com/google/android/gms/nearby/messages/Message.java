package com.google.android.gms.nearby.messages;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zziq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private static final zziq[] zzc = {zziq.zza};
    final int zza;

    @Deprecated
    final zziq[] zzb;
    private final byte[] zzd;
    private final String zze;
    private final String zzf;
    private final long zzg;

    public Message(int i, byte[] bArr, String str, String str2, zziq[] zziqVarArr, long j) {
        this.zza = i;
        this.zze = (String) Preconditions.checkNotNull(str2);
        this.zzf = str == null ? "" : str;
        this.zzg = j;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        Preconditions.checkArgument(length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(length), 102400);
        this.zzd = bArr;
        this.zzb = (zziqVarArr == null || zziqVarArr.length == 0) ? zzc : zziqVarArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zzf, message.zzf) && TextUtils.equals(this.zze, message.zze) && Arrays.equals(this.zzd, message.zzd) && this.zzg == message.zzg;
    }

    public byte[] getContent() {
        return this.zzd;
    }

    public String getNamespace() {
        return this.zzf;
    }

    public String getType() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzf, this.zze, Integer.valueOf(Arrays.hashCode(this.zzd)), Long.valueOf(this.zzg));
    }

    public String toString() {
        byte[] bArr = this.zzd;
        return FileInsert$$ExternalSyntheticOutline0.m(bArr == null ? 0 : bArr.length, " bytes]}", FileInsert$$ExternalSyntheticOutline0.m6m("Message{namespace='", this.zzf, "', type='", this.zze, "', content=["));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzb, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
