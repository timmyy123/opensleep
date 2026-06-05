package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzwr implements Iterable<Byte>, Serializable {
    public static final zzwr zzb = new zzwq(zzzt.zzb);
    private int zza = 0;

    static {
        int i = zzwc.$r8$clinit;
    }

    public static zzwr zzl(byte[] bArr, int i, int i2) {
        zzq(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzwq(bArr2);
    }

    public static zzwr zzm(String str) {
        return new zzwq(str.getBytes(zzzt.zza));
    }

    public static int zzq(int i, int i2, int i3) {
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
        int iZzj = this.zza;
        if (iZzj == 0) {
            int iZzc = zzc();
            iZzj = zzj(iZzc, 0, iZzc);
            if (iZzj == 0) {
                iZzj = 1;
            }
            this.zza = iZzj;
        }
        return iZzj;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzwk(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return FileInsert$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m(zzc(), "<ByteString@", hexString, " size=", " contents=\""), zzc() <= 50 ? zzabn.zza(this) : zzabn.zza(zzf(0, 47)).concat("..."), "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzc();

    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    public abstract zzwr zzf(int i, int i2);

    public abstract void zzg(zzwj zzwjVar);

    public abstract String zzh(Charset charset);

    public abstract int zzj(int i, int i2, int i3);

    public abstract zzwv zzk();

    public final byte[] zzn() {
        int iZzc = zzc();
        if (iZzc == 0) {
            return zzzt.zzb;
        }
        byte[] bArr = new byte[iZzc];
        zze(bArr, 0, 0, iZzc);
        return bArr;
    }

    public final String zzo() {
        return zzc() == 0 ? "" : zzh(zzzt.zza);
    }

    public final int zzp() {
        return this.zza;
    }
}
