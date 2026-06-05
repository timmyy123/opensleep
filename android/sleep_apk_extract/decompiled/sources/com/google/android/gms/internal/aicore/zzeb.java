package com.google.android.gms.internal.aicore;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzeb implements Iterable, Serializable {
    public static final zzeb zzb = new zzea(zzfh.zzb);
    private int zza = 0;

    static {
        int i = zzdq.$r8$clinit;
    }

    public static zzeb zzg(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzea(bArr2);
    }

    public static int zzi(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            Events$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 21), "Beginning index: ", i, " < 0"));
            return 0;
        }
        if (i2 < i) {
            Events$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length()), i, "Beginning index larger than ending index: ", i2, ", "));
            return 0;
        }
        Events$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length()), i2, "End index: ", i3, " >= "));
        return 0;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzf = this.zza;
        if (iZzf == 0) {
            int iZzc = zzc();
            iZzf = zzf(iZzc, 0, iZzc);
            if (iZzf == 0) {
                iZzf = 1;
            }
            this.zza = iZzf;
        }
        return iZzf;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdv(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return FileInsert$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m(zzc(), "<ByteString@", hexString, " size=", " contents=\""), zzc() <= 50 ? zzgt.zza(this) : zzgt.zza(zze(0, 47)).concat("..."), "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzc();

    public abstract zzeb zze(int i, int i2);

    public abstract int zzf(int i, int i2, int i3);

    public final int zzh() {
        return this.zza;
    }
}
