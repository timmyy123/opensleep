package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdoVar, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw zzdwVar, zzcy zzcyVar, zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdj zzdjVar) {
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = zzdoVar instanceof zzcg;
        this.zzmq = z;
        this.zzmo = zzbuVar != null && zzbuVar.zze(zzdoVar);
        this.zzmr = false;
        this.zzms = iArr2;
        this.zzmt = iArr3;
        this.zzmu = iArr4;
        this.zzmv = zzdwVar;
        this.zzmw = zzcyVar;
        this.zzmx = zzexVar;
        this.zzmy = zzbuVar;
        this.zzmn = zzdoVar;
        this.zzmz = zzdjVar;
    }

    private final zzef zzad(int i) {
        int i2 = (i / 4) << 1;
        zzef zzefVar = (zzef) this.zzmj[i2];
        if (zzefVar != null) {
            return zzefVar;
        }
        zzef<T> zzefVarZze = zzea.zzcm().zze((Class) this.zzmj[i2 + 1]);
        this.zzmj[i2] = zzefVarZze;
        return zzefVarZze;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        int i2 = this.zzmk;
        if (i >= i2) {
            int i3 = this.zzmm;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.zzmi[i4] == i) {
                    return i4;
                }
                return -1;
            }
            if (i <= this.zzml) {
                int i5 = i3 - i2;
                int length = (this.zzmi.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.zzmi[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzfr zzfrVar) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        boolean z;
        int i;
        boolean z2;
        if (this.zzmo) {
            zzby<?> zzbyVarZza = this.zzmy.zza(t);
            if (zzbyVarZza.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzbyVarZza.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.zzmi.length;
        Unsafe unsafe = zzmh;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 4) {
            int iZzag = zzag(i4);
            int[] iArr = this.zzmi;
            int i5 = iArr[i4];
            int i6 = (267386880 & iZzag) >>> 20;
            if (this.zzmq || i6 > 17) {
                z = true;
                i = 0;
            } else {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & 1048575;
                z = true;
                if (i8 != i2) {
                    i3 = unsafe.getInt(t, i8);
                    i2 = i8;
                }
                i = 1 << (i7 >>> 20);
            }
            while (entry != null && this.zzmy.zza(entry) <= i5) {
                this.zzmy.zza(zzfrVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzag & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        zzfrVar.zza(i5, zzfd.zzn(t, j));
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        zzfrVar.zza(i5, zzfd.zzm(t, j));
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        zzfrVar.zzi(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        zzfrVar.zza(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        zzfrVar.zzc(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        zzfrVar.zzc(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        zzfrVar.zzf(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        zzfrVar.zzb(i5, zzfd.zzl(t, j));
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        zza(i5, unsafe.getObject(t, j), zzfrVar);
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        zzfrVar.zza(i5, unsafe.getObject(t, j), zzad(i4));
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        zzfrVar.zza(i5, (zzbb) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        zzfrVar.zzd(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        zzfrVar.zzn(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        zzfrVar.zzm(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        zzfrVar.zzj(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        zzfrVar.zze(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        zzfrVar.zzb(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        zzfrVar.zzb(i5, unsafe.getObject(t, j), zzad(i4));
                    }
                    break;
                case 18:
                    zzeh.zza(this.zzmi[i4], (List<Double>) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 19:
                    zzeh.zzb(this.zzmi[i4], (List<Float>) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 20:
                    zzeh.zzc(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 21:
                    zzeh.zzd(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 22:
                    zzeh.zzh(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 23:
                    zzeh.zzf(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 24:
                    zzeh.zzk(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 25:
                    zzeh.zzn(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 26:
                    zzeh.zza(this.zzmi[i4], (List<String>) unsafe.getObject(t, j), zzfrVar);
                    break;
                case 27:
                    zzeh.zza(this.zzmi[i4], (List<?>) unsafe.getObject(t, j), zzfrVar, zzad(i4));
                    break;
                case 28:
                    zzeh.zzb(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar);
                    break;
                case 29:
                    z2 = false;
                    zzeh.zzi(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 30:
                    z2 = false;
                    zzeh.zzm(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 31:
                    z2 = false;
                    zzeh.zzl(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 32:
                    z2 = false;
                    zzeh.zzg(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 33:
                    z2 = false;
                    zzeh.zzj(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 34:
                    z2 = false;
                    zzeh.zze(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 35:
                    zzeh.zza(this.zzmi[i4], (List<Double>) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 36:
                    zzeh.zzb(this.zzmi[i4], (List<Float>) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 37:
                    zzeh.zzc(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 38:
                    zzeh.zzd(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 39:
                    zzeh.zzh(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 40:
                    zzeh.zzf(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 41:
                    zzeh.zzk(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 42:
                    zzeh.zzn(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 43:
                    zzeh.zzi(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 44:
                    zzeh.zzm(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 45:
                    zzeh.zzl(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 46:
                    zzeh.zzg(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 47:
                    zzeh.zzj(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 48:
                    zzeh.zze(this.zzmi[i4], (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 49:
                    zzeh.zzb(this.zzmi[i4], (List<?>) unsafe.getObject(t, j), zzfrVar, zzad(i4));
                    break;
                case 50:
                    zza(zzfrVar, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zza(i5, zze(t, j));
                    }
                    break;
                case 52:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zza(i5, zzf(t, j));
                    }
                    break;
                case 53:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzi(i5, zzh(t, j));
                    }
                    break;
                case 54:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zza(i5, zzh(t, j));
                    }
                    break;
                case 55:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzc(i5, zzg(t, j));
                    }
                    break;
                case 56:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzc(i5, zzh(t, j));
                    }
                    break;
                case 57:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzf(i5, zzg(t, j));
                    }
                    break;
                case 58:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzb(i5, zzi(t, j));
                    }
                    break;
                case 59:
                    if (zza(t, i5, i4)) {
                        zza(i5, unsafe.getObject(t, j), zzfrVar);
                    }
                    break;
                case 60:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zza(i5, unsafe.getObject(t, j), zzad(i4));
                    }
                    break;
                case 61:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zza(i5, (zzbb) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzd(i5, zzg(t, j));
                    }
                    break;
                case 63:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzn(i5, zzg(t, j));
                    }
                    break;
                case 64:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzm(i5, zzg(t, j));
                    }
                    break;
                case 65:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzj(i5, zzh(t, j));
                    }
                    break;
                case 66:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zze(i5, zzg(t, j));
                    }
                    break;
                case 67:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzb(i5, zzh(t, j));
                    }
                    break;
                case 68:
                    if (zza(t, i5, i4)) {
                        zzfrVar.zzb(i5, unsafe.getObject(t, j), zzad(i4));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzmy.zza(zzfrVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzmx, t, zzfrVar);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg zzcgVar = (zzcg) obj;
        zzey zzeyVar = zzcgVar.zzjp;
        if (zzeyVar != zzey.zzea()) {
            return zzeyVar;
        }
        zzey zzeyVarZzeb = zzey.zzeb();
        zzcgVar.zzjp = zzeyVarZzeb;
        return zzeyVarZzeb;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(T t, T t2) {
        int length = this.zzmi.length;
        int i = 0;
        while (true) {
            boolean zZzd = true;
            if (i >= length) {
                if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
                    return false;
                }
                if (this.zzmo) {
                    return this.zzmy.zza(t).equals(this.zzmy.zza(t2));
                }
                return true;
            }
            int iZzag = zzag(i);
            long j = iZzag & 1048575;
            switch ((iZzag & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                        zZzd = false;
                    }
                    break;
                case 1:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 2:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 3:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 4:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 5:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 6:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 7:
                    if (!zzc(t, t2, i) || zzfd.zzl(t, j) != zzfd.zzl(t2, j)) {
                    }
                    break;
                case 8:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 9:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 10:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 11:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 12:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 13:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 14:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 15:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 16:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 17:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    zZzd = zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzah = zzah(i) & 1048575;
                    if (zzfd.zzj(t, jZzah) != zzfd.zzj(t2, jZzah) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
            }
            if (!zZzd) {
                return false;
            }
            i += 4;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f7 A[PHI: r3
      0x00f7: PHI (r3v9 java.lang.Object) = (r3v6 java.lang.Object), (r3v10 java.lang.Object) binds: [B:75:0x0113, B:69:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int hashCode(T t) {
        int i;
        double dZzn;
        float fZzm;
        boolean zZzl;
        Object objZzo;
        int i2;
        int iZzj;
        long jZzk;
        int iFloatToIntBits;
        Object objZzo2;
        int length = this.zzmi.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 4) {
            int iZzag = zzag(i4);
            int i5 = this.zzmi[i4];
            long j = 1048575 & iZzag;
            int iHashCode = 37;
            switch ((iZzag & 267386880) >>> 20) {
                case 0:
                    i = i3 * 53;
                    dZzn = zzfd.zzn(t, j);
                    jZzk = Double.doubleToLongBits(dZzn);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 1:
                    i = i3 * 53;
                    fZzm = zzfd.zzm(t, j);
                    iFloatToIntBits = Float.floatToIntBits(fZzm);
                    i3 = iFloatToIntBits + i;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i = i3 * 53;
                    jZzk = zzfd.zzk(t, j);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i2 = i3 * 53;
                    iZzj = zzfd.zzj(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 7:
                    i = i3 * 53;
                    zZzl = zzfd.zzl(t, j);
                    iFloatToIntBits = zzci.zzc(zZzl);
                    i3 = iFloatToIntBits + i;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzfd.zzo(t, j)).hashCode();
                    i3 = iFloatToIntBits + i;
                    break;
                case 9:
                    objZzo = zzfd.zzo(t, j);
                    if (objZzo != null) {
                        iHashCode = objZzo.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    i = i3 * 53;
                    objZzo2 = zzfd.zzo(t, j);
                    iFloatToIntBits = objZzo2.hashCode();
                    i3 = iFloatToIntBits + i;
                    break;
                case 17:
                    objZzo = zzfd.zzo(t, j);
                    if (objZzo != null) {
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i = i3 * 53;
                        dZzn = zze(t, j);
                        jZzk = Double.doubleToLongBits(dZzn);
                        iFloatToIntBits = zzci.zzl(jZzk);
                        i3 = iFloatToIntBits + i;
                    }
                    break;
                case 52:
                    if (zza(t, i5, i4)) {
                        i = i3 * 53;
                        fZzm = zzf(t, j);
                        iFloatToIntBits = Float.floatToIntBits(fZzm);
                        i3 = iFloatToIntBits + i;
                    }
                    break;
                case 53:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    jZzk = zzh(t, j);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 54:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    jZzk = zzh(t, j);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 55:
                    if (!zza(t, i5, i4)) {
                    }
                    i2 = i3 * 53;
                    iZzj = zzg(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 56:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    jZzk = zzh(t, j);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 57:
                    if (!zza(t, i5, i4)) {
                    }
                    i2 = i3 * 53;
                    iZzj = zzg(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 58:
                    if (zza(t, i5, i4)) {
                        i = i3 * 53;
                        zZzl = zzi(t, j);
                        iFloatToIntBits = zzci.zzc(zZzl);
                        i3 = iFloatToIntBits + i;
                    }
                    break;
                case 59:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzfd.zzo(t, j)).hashCode();
                    i3 = iFloatToIntBits + i;
                    break;
                case 60:
                    if (!zza(t, i5, i4)) {
                    }
                    objZzo2 = zzfd.zzo(t, j);
                    i = i3 * 53;
                    iFloatToIntBits = objZzo2.hashCode();
                    i3 = iFloatToIntBits + i;
                    break;
                case 61:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    objZzo2 = zzfd.zzo(t, j);
                    iFloatToIntBits = objZzo2.hashCode();
                    i3 = iFloatToIntBits + i;
                    break;
                case 62:
                    if (!zza(t, i5, i4)) {
                    }
                    i2 = i3 * 53;
                    iZzj = zzg(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 63:
                    if (!zza(t, i5, i4)) {
                    }
                    i2 = i3 * 53;
                    iZzj = zzg(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 64:
                    if (!zza(t, i5, i4)) {
                    }
                    i2 = i3 * 53;
                    iZzj = zzg(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 65:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    jZzk = zzh(t, j);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 66:
                    if (!zza(t, i5, i4)) {
                    }
                    i2 = i3 * 53;
                    iZzj = zzg(t, j);
                    i3 = i2 + iZzj;
                    break;
                case 67:
                    if (!zza(t, i5, i4)) {
                    }
                    i = i3 * 53;
                    jZzk = zzh(t, j);
                    iFloatToIntBits = zzci.zzl(jZzk);
                    i3 = iFloatToIntBits + i;
                    break;
                case 68:
                    if (!zza(t, i5, i4)) {
                    }
                    objZzo2 = zzfd.zzo(t, j);
                    i = i3 * 53;
                    iFloatToIntBits = objZzo2.hashCode();
                    i3 = iFloatToIntBits + i;
                    break;
            }
        }
        int iHashCode2 = this.zzmx.zzq(t).hashCode() + (i3 * 53);
        return this.zzmo ? (iHashCode2 * 53) + this.zzmy.zza(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final T newInstance() {
        return (T) this.zzmv.newInstance(this.zzmn);
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzfr zzfrVar) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        double dZzn;
        float fZzm;
        long jZzk;
        long jZzk2;
        int iZzj;
        long jZzk3;
        int iZzj2;
        boolean zZzl;
        int iZzj3;
        int iZzj4;
        int iZzj5;
        long jZzk4;
        int iZzj6;
        long jZzk5;
        Iterator<Map.Entry<?, Object>> itDescendingIterator;
        Map.Entry<?, ?> entry2;
        double dZzn2;
        float fZzm2;
        long jZzk6;
        long jZzk7;
        int iZzj7;
        long jZzk8;
        int iZzj8;
        boolean zZzl2;
        int iZzj9;
        int iZzj10;
        int iZzj11;
        long jZzk9;
        int iZzj12;
        long jZzk10;
        if (zzfrVar.zzaj() == zzcg.zzg.zzkp) {
            zza(this.zzmx, t, zzfrVar);
            if (this.zzmo) {
                zzby<?> zzbyVarZza = this.zzmy.zza(t);
                if (zzbyVarZza.isEmpty()) {
                    itDescendingIterator = null;
                    entry2 = null;
                } else {
                    itDescendingIterator = zzbyVarZza.descendingIterator();
                    entry2 = (Map.Entry) itDescendingIterator.next();
                }
            }
            for (int length = this.zzmi.length - 4; length >= 0; length -= 4) {
                int iZzag = zzag(length);
                int i = this.zzmi[length];
                while (entry2 != null && this.zzmy.zza(entry2) > i) {
                    this.zzmy.zza(zzfrVar, entry2);
                    entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((iZzag & 267386880) >>> 20) {
                    case 0:
                        if (zza(t, length)) {
                            dZzn2 = zzfd.zzn(t, iZzag & 1048575);
                            zzfrVar.zza(i, dZzn2);
                        }
                        break;
                    case 1:
                        if (zza(t, length)) {
                            fZzm2 = zzfd.zzm(t, iZzag & 1048575);
                            zzfrVar.zza(i, fZzm2);
                        }
                        break;
                    case 2:
                        if (zza(t, length)) {
                            jZzk6 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzi(i, jZzk6);
                        }
                        break;
                    case 3:
                        if (zza(t, length)) {
                            jZzk7 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zza(i, jZzk7);
                        }
                        break;
                    case 4:
                        if (zza(t, length)) {
                            iZzj7 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzc(i, iZzj7);
                        }
                        break;
                    case 5:
                        if (zza(t, length)) {
                            jZzk8 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzc(i, jZzk8);
                        }
                        break;
                    case 6:
                        if (zza(t, length)) {
                            iZzj8 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzf(i, iZzj8);
                        }
                        break;
                    case 7:
                        if (zza(t, length)) {
                            zZzl2 = zzfd.zzl(t, iZzag & 1048575);
                            zzfrVar.zzb(i, zZzl2);
                        }
                        break;
                    case 8:
                        if (zza(t, length)) {
                            zza(i, zzfd.zzo(t, iZzag & 1048575), zzfrVar);
                        }
                        break;
                    case 9:
                        if (zza(t, length)) {
                            zzfrVar.zza(i, zzfd.zzo(t, iZzag & 1048575), zzad(length));
                        }
                        break;
                    case 10:
                        if (zza(t, length)) {
                            zzfrVar.zza(i, (zzbb) zzfd.zzo(t, iZzag & 1048575));
                        }
                        break;
                    case 11:
                        if (zza(t, length)) {
                            iZzj9 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzd(i, iZzj9);
                        }
                        break;
                    case 12:
                        if (zza(t, length)) {
                            iZzj10 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzn(i, iZzj10);
                        }
                        break;
                    case 13:
                        if (zza(t, length)) {
                            iZzj11 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzm(i, iZzj11);
                        }
                        break;
                    case 14:
                        if (zza(t, length)) {
                            jZzk9 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzj(i, jZzk9);
                        }
                        break;
                    case 15:
                        if (zza(t, length)) {
                            iZzj12 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zze(i, iZzj12);
                        }
                        break;
                    case 16:
                        if (zza(t, length)) {
                            jZzk10 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzb(i, jZzk10);
                        }
                        break;
                    case 17:
                        if (zza(t, length)) {
                            zzfrVar.zzb(i, zzfd.zzo(t, iZzag & 1048575), zzad(length));
                        }
                        break;
                    case 18:
                        zzeh.zza(this.zzmi[length], (List<Double>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 19:
                        zzeh.zzb(this.zzmi[length], (List<Float>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 20:
                        zzeh.zzc(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 21:
                        zzeh.zzd(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 22:
                        zzeh.zzh(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 23:
                        zzeh.zzf(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 24:
                        zzeh.zzk(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 25:
                        zzeh.zzn(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 26:
                        zzeh.zza(this.zzmi[length], (List<String>) zzfd.zzo(t, iZzag & 1048575), zzfrVar);
                        break;
                    case 27:
                        zzeh.zza(this.zzmi[length], (List<?>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, zzad(length));
                        break;
                    case 28:
                        zzeh.zzb(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar);
                        break;
                    case 29:
                        zzeh.zzi(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 30:
                        zzeh.zzm(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 31:
                        zzeh.zzl(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 32:
                        zzeh.zzg(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 33:
                        zzeh.zzj(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 34:
                        zzeh.zze(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 35:
                        zzeh.zza(this.zzmi[length], (List<Double>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 36:
                        zzeh.zzb(this.zzmi[length], (List<Float>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 37:
                        zzeh.zzc(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 38:
                        zzeh.zzd(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 39:
                        zzeh.zzh(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 40:
                        zzeh.zzf(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 41:
                        zzeh.zzk(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 42:
                        zzeh.zzn(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 43:
                        zzeh.zzi(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 44:
                        zzeh.zzm(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 45:
                        zzeh.zzl(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 46:
                        zzeh.zzg(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 47:
                        zzeh.zzj(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 48:
                        zzeh.zze(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 49:
                        zzeh.zzb(this.zzmi[length], (List<?>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, zzad(length));
                        break;
                    case 50:
                        zza(zzfrVar, i, zzfd.zzo(t, iZzag & 1048575), length);
                        break;
                    case 51:
                        if (zza(t, i, length)) {
                            dZzn2 = zze(t, iZzag & 1048575);
                            zzfrVar.zza(i, dZzn2);
                        }
                        break;
                    case 52:
                        if (zza(t, i, length)) {
                            fZzm2 = zzf(t, iZzag & 1048575);
                            zzfrVar.zza(i, fZzm2);
                        }
                        break;
                    case 53:
                        if (zza(t, i, length)) {
                            jZzk6 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzi(i, jZzk6);
                        }
                        break;
                    case 54:
                        if (zza(t, i, length)) {
                            jZzk7 = zzh(t, iZzag & 1048575);
                            zzfrVar.zza(i, jZzk7);
                        }
                        break;
                    case 55:
                        if (zza(t, i, length)) {
                            iZzj7 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzc(i, iZzj7);
                        }
                        break;
                    case 56:
                        if (zza(t, i, length)) {
                            jZzk8 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzc(i, jZzk8);
                        }
                        break;
                    case 57:
                        if (zza(t, i, length)) {
                            iZzj8 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzf(i, iZzj8);
                        }
                        break;
                    case 58:
                        if (zza(t, i, length)) {
                            zZzl2 = zzi(t, iZzag & 1048575);
                            zzfrVar.zzb(i, zZzl2);
                        }
                        break;
                    case 59:
                        if (!zza(t, i, length)) {
                            break;
                        }
                        break;
                    case 60:
                        if (!zza(t, i, length)) {
                            break;
                        }
                        break;
                    case 61:
                        if (!zza(t, i, length)) {
                            break;
                        }
                        break;
                    case 62:
                        if (zza(t, i, length)) {
                            iZzj9 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzd(i, iZzj9);
                        }
                        break;
                    case 63:
                        if (zza(t, i, length)) {
                            iZzj10 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzn(i, iZzj10);
                        }
                        break;
                    case 64:
                        if (zza(t, i, length)) {
                            iZzj11 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzm(i, iZzj11);
                        }
                        break;
                    case 65:
                        if (zza(t, i, length)) {
                            jZzk9 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzj(i, jZzk9);
                        }
                        break;
                    case 66:
                        if (zza(t, i, length)) {
                            iZzj12 = zzg(t, iZzag & 1048575);
                            zzfrVar.zze(i, iZzj12);
                        }
                        break;
                    case 67:
                        if (zza(t, i, length)) {
                            jZzk10 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzb(i, jZzk10);
                        }
                        break;
                    case 68:
                        if (!zza(t, i, length)) {
                            break;
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzmy.zza(zzfrVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (!this.zzmq) {
            zzb(t, zzfrVar);
            return;
        }
        if (this.zzmo) {
            zzby<?> zzbyVarZza2 = this.zzmy.zza(t);
            if (zzbyVarZza2.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzbyVarZza2.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length2 = this.zzmi.length;
        for (int i2 = 0; i2 < length2; i2 += 4) {
            int iZzag2 = zzag(i2);
            int i3 = this.zzmi[i2];
            while (entry != null && this.zzmy.zza(entry) <= i3) {
                this.zzmy.zza(zzfrVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch ((iZzag2 & 267386880) >>> 20) {
                case 0:
                    if (zza(t, i2)) {
                        dZzn = zzfd.zzn(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, dZzn);
                    }
                    break;
                case 1:
                    if (zza(t, i2)) {
                        fZzm = zzfd.zzm(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, fZzm);
                    }
                    break;
                case 2:
                    if (zza(t, i2)) {
                        jZzk = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzi(i3, jZzk);
                    }
                    break;
                case 3:
                    if (zza(t, i2)) {
                        jZzk2 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, jZzk2);
                    }
                    break;
                case 4:
                    if (zza(t, i2)) {
                        iZzj = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, iZzj);
                    }
                    break;
                case 5:
                    if (zza(t, i2)) {
                        jZzk3 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, jZzk3);
                    }
                    break;
                case 6:
                    if (zza(t, i2)) {
                        iZzj2 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzf(i3, iZzj2);
                    }
                    break;
                case 7:
                    if (zza(t, i2)) {
                        zZzl = zzfd.zzl(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, zZzl);
                    }
                    break;
                case 8:
                    if (zza(t, i2)) {
                        zza(i3, zzfd.zzo(t, iZzag2 & 1048575), zzfrVar);
                    }
                    break;
                case 9:
                    if (zza(t, i2)) {
                        zzfrVar.zza(i3, zzfd.zzo(t, iZzag2 & 1048575), zzad(i2));
                    }
                    break;
                case 10:
                    if (zza(t, i2)) {
                        zzfrVar.zza(i3, (zzbb) zzfd.zzo(t, iZzag2 & 1048575));
                    }
                    break;
                case 11:
                    if (zza(t, i2)) {
                        iZzj3 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzd(i3, iZzj3);
                    }
                    break;
                case 12:
                    if (zza(t, i2)) {
                        iZzj4 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzn(i3, iZzj4);
                    }
                    break;
                case 13:
                    if (zza(t, i2)) {
                        iZzj5 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzm(i3, iZzj5);
                    }
                    break;
                case 14:
                    if (zza(t, i2)) {
                        jZzk4 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzj(i3, jZzk4);
                    }
                    break;
                case 15:
                    if (zza(t, i2)) {
                        iZzj6 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zze(i3, iZzj6);
                    }
                    break;
                case 16:
                    if (zza(t, i2)) {
                        jZzk5 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, jZzk5);
                    }
                    break;
                case 17:
                    if (zza(t, i2)) {
                        zzfrVar.zzb(i3, zzfd.zzo(t, iZzag2 & 1048575), zzad(i2));
                    }
                    break;
                case 18:
                    zzeh.zza(this.zzmi[i2], (List<Double>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 19:
                    zzeh.zzb(this.zzmi[i2], (List<Float>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 20:
                    zzeh.zzc(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 21:
                    zzeh.zzd(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 22:
                    zzeh.zzh(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 23:
                    zzeh.zzf(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 24:
                    zzeh.zzk(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 25:
                    zzeh.zzn(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 26:
                    zzeh.zza(this.zzmi[i2], (List<String>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar);
                    break;
                case 27:
                    zzeh.zza(this.zzmi[i2], (List<?>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, zzad(i2));
                    break;
                case 28:
                    zzeh.zzb(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar);
                    break;
                case 29:
                    zzeh.zzi(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 30:
                    zzeh.zzm(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 31:
                    zzeh.zzl(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 32:
                    zzeh.zzg(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 33:
                    zzeh.zzj(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 34:
                    zzeh.zze(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 35:
                    zzeh.zza(this.zzmi[i2], (List<Double>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 36:
                    zzeh.zzb(this.zzmi[i2], (List<Float>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 37:
                    zzeh.zzc(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 38:
                    zzeh.zzd(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 39:
                    zzeh.zzh(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 40:
                    zzeh.zzf(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 41:
                    zzeh.zzk(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 42:
                    zzeh.zzn(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 43:
                    zzeh.zzi(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 44:
                    zzeh.zzm(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 45:
                    zzeh.zzl(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 46:
                    zzeh.zzg(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 47:
                    zzeh.zzj(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 48:
                    zzeh.zze(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 49:
                    zzeh.zzb(this.zzmi[i2], (List<?>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, zzad(i2));
                    break;
                case 50:
                    zza(zzfrVar, i3, zzfd.zzo(t, iZzag2 & 1048575), i2);
                    break;
                case 51:
                    if (zza(t, i3, i2)) {
                        dZzn = zze(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, dZzn);
                    }
                    break;
                case 52:
                    if (zza(t, i3, i2)) {
                        fZzm = zzf(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, fZzm);
                    }
                    break;
                case 53:
                    if (zza(t, i3, i2)) {
                        jZzk = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzi(i3, jZzk);
                    }
                    break;
                case 54:
                    if (zza(t, i3, i2)) {
                        jZzk2 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, jZzk2);
                    }
                    break;
                case 55:
                    if (zza(t, i3, i2)) {
                        iZzj = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, iZzj);
                    }
                    break;
                case 56:
                    if (zza(t, i3, i2)) {
                        jZzk3 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, jZzk3);
                    }
                    break;
                case 57:
                    if (zza(t, i3, i2)) {
                        iZzj2 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzf(i3, iZzj2);
                    }
                    break;
                case 58:
                    if (zza(t, i3, i2)) {
                        zZzl = zzi(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, zZzl);
                    }
                    break;
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    }
                    break;
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    }
                    break;
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    }
                    break;
                case 62:
                    if (zza(t, i3, i2)) {
                        iZzj3 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzd(i3, iZzj3);
                    }
                    break;
                case 63:
                    if (zza(t, i3, i2)) {
                        iZzj4 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzn(i3, iZzj4);
                    }
                    break;
                case 64:
                    if (zza(t, i3, i2)) {
                        iZzj5 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzm(i3, iZzj5);
                    }
                    break;
                case 65:
                    if (zza(t, i3, i2)) {
                        jZzk4 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzj(i3, jZzk4);
                    }
                    break;
                case 66:
                    if (zza(t, i3, i2)) {
                        iZzj6 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zze(i3, iZzj6);
                    }
                    break;
                case 67:
                    if (zza(t, i3, i2)) {
                        jZzk5 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, jZzk5);
                    }
                    break;
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzmy.zza(zzfrVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzmx, t, zzfrVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzmi.length; i += 4) {
            int iZzag = zzag(i);
            long j = 1048575 & iZzag;
            int i2 = this.zzmi[i];
            switch ((iZzag & 267386880) >>> 20) {
                case 0:
                    if (zza(t2, i)) {
                        zzfd.zza(t, j, zzfd.zzn(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 1:
                    if (zza(t2, i)) {
                        zzfd.zza((Object) t, j, zzfd.zzm(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 2:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 3:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 4:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 5:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 6:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 7:
                    if (zza(t2, i)) {
                        zzfd.zza(t, j, zzfd.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 8:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb(t, i);
                    break;
                case 9:
                case 17:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb(t, i);
                    break;
                case 11:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 12:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 13:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 14:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 15:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 16:
                    if (!zza(t2, i)) {
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzmw.zza(t, t2, j);
                    break;
                case 50:
                    zzeh.zza(this.zzmz, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                case 68:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza(t2, i2, i)) {
                        break;
                    }
                    break;
            }
        }
        if (this.zzmq) {
            return;
        }
        zzeh.zza(this.zzmx, t, t2);
        if (this.zzmo) {
            zzeh.zza(this.zzmy, t, t2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0492, code lost:
    
        if (zza(r21, r15, r4) != false) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0494, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r21, r13), zzad(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x04cb, code lost:
    
        if (zza(r21, r15, r4) != false) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x04cd, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x04d6, code lost:
    
        if (zza(r21, r15, r4) != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x04d8, code lost:
    
        r8 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0501, code lost:
    
        if (zza(r21, r15, r4) != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0503, code lost:
    
        r6 = (com.google.android.gms.internal.clearcut.zzbb) r2.getObject(r21, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0509, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0512, code lost:
    
        if (zza(r21, r15, r4) != false) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0514, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r2.getObject(r21, r13), zzad(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x052e, code lost:
    
        if ((r6 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0530, code lost:
    
        r6 = (com.google.android.gms.internal.clearcut.zzbb) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0533, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, (java.lang.String) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x053f, code lost:
    
        if (zza(r21, r15, r4) != false) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0541, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0782, code lost:
    
        if ((r12 & r19) != 0) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x079c, code lost:
    
        if ((r12 & r19) != 0) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x07a2, code lost:
    
        if ((r12 & r19) != 0) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x07bc, code lost:
    
        if ((r12 & r19) != 0) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x07c2, code lost:
    
        if ((r12 & r19) != 0) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x07d0, code lost:
    
        if ((r6 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x07d6, code lost:
    
        if ((r12 & r19) != 0) goto L290;
     */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05da A[PHI: r8
      0x05da: PHI (r8v75 int) = 
      (r8v37 int)
      (r8v40 int)
      (r8v43 int)
      (r8v46 int)
      (r8v49 int)
      (r8v52 int)
      (r8v55 int)
      (r8v58 int)
      (r8v61 int)
      (r8v64 int)
      (r8v67 int)
      (r8v70 int)
      (r8v73 int)
      (r8v78 int)
     binds: [B:383:0x06c8, B:378:0x06b6, B:373:0x06a4, B:368:0x0692, B:363:0x0680, B:358:0x066e, B:353:0x065c, B:348:0x064b, B:343:0x063a, B:338:0x0629, B:333:0x0618, B:328:0x0607, B:323:0x05f6, B:317:0x05d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ab A[PHI: r4
      0x01ab: PHI (r4v78 int) = 
      (r4v43 int)
      (r4v46 int)
      (r4v49 int)
      (r4v52 int)
      (r4v55 int)
      (r4v58 int)
      (r4v61 int)
      (r4v64 int)
      (r4v67 int)
      (r4v70 int)
      (r4v73 int)
      (r4v76 int)
      (r4v81 int)
     binds: [B:148:0x0281, B:143:0x026f, B:138:0x025d, B:133:0x024b, B:128:0x0239, B:123:0x0228, B:118:0x0217, B:113:0x0206, B:108:0x01f5, B:103:0x01e4, B:98:0x01d3, B:93:0x01c2, B:87:0x01a9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzm(T t) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int iZzd;
        Object object;
        int iZzg;
        int iZzg2;
        int iZzg3;
        long jZzh;
        int iZzw;
        boolean z3;
        int iZzo;
        int iZzi;
        int iZzb;
        int iZzb2;
        int iZzb3;
        zzbb zzbbVar;
        int iZzc;
        int iZzi2;
        int iZzr;
        zzbb zzbbVar2;
        int i3 = 267386880;
        int i4 = 1048575;
        if (!this.zzmq) {
            Unsafe unsafe = zzmh;
            int i5 = -1;
            int i6 = 0;
            int iZzb4 = 0;
            int i7 = 0;
            while (i6 < this.zzmi.length) {
                int iZzag = zzag(i6);
                int[] iArr = this.zzmi;
                int i8 = iArr[i6];
                int i9 = i4;
                int i10 = (iZzag & 267386880) >>> 20;
                if (i10 <= 17) {
                    i = iArr[i6 + 2];
                    int i11 = i & i9;
                    i2 = 1 << (i >>> 20);
                    if (i11 != i5) {
                        i7 = unsafe.getInt(t, i11);
                        i5 = i11;
                    }
                } else {
                    i = (!this.zzmr || i10 < zzcb.zzih.id() || i10 > zzcb.zziu.id()) ? 0 : this.zzmi[i6 + 2] & i9;
                    i2 = 0;
                }
                long j = iZzag & i9;
                switch (i10) {
                    case 0:
                        z = false;
                        z2 = false;
                        if ((i7 & i2) != 0) {
                            iZzb4 += zzbn.zzb(i8, 0.0d);
                        }
                        break;
                    case 1:
                        z = false;
                        if ((i7 & i2) != 0) {
                            z2 = false;
                            iZzb4 += zzbn.zzb(i8, 0.0f);
                        } else {
                            z2 = false;
                        }
                        break;
                    case 2:
                        z = false;
                        if ((i7 & i2) != 0) {
                            iZzd = zzbn.zzd(i8, unsafe.getLong(t, j));
                            iZzb4 += iZzd;
                        }
                        z2 = false;
                        break;
                    case 3:
                        z = false;
                        if ((i7 & i2) != 0) {
                            iZzd = zzbn.zze(i8, unsafe.getLong(t, j));
                            iZzb4 += iZzd;
                        }
                        z2 = false;
                        break;
                    case 4:
                        z = false;
                        if ((i7 & i2) != 0) {
                            iZzd = zzbn.zzg(i8, unsafe.getInt(t, j));
                            iZzb4 += iZzd;
                        }
                        z2 = false;
                        break;
                    case 5:
                        z = false;
                        if ((i7 & i2) != 0) {
                            iZzd = zzbn.zzg(i8, 0L);
                            iZzb4 += iZzd;
                        }
                        z2 = false;
                        break;
                    case 6:
                        if ((i7 & i2) != 0) {
                            z = false;
                            iZzd = zzbn.zzj(i8, 0);
                            iZzb4 += iZzd;
                            z2 = false;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 7:
                        break;
                    case 8:
                        if ((i7 & i2) != 0) {
                            object = unsafe.getObject(t, j);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        if ((i7 & i2) != 0) {
                            iZzg = unsafe.getInt(t, j);
                            iZzb = zzbn.zzh(i8, iZzg);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 12:
                        if ((i7 & i2) != 0) {
                            iZzg2 = unsafe.getInt(t, j);
                            iZzb = zzbn.zzl(i8, iZzg2);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        if ((i7 & i2) != 0) {
                            iZzg3 = unsafe.getInt(t, j);
                            iZzb = zzbn.zzi(i8, iZzg3);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 16:
                        if ((i7 & i2) != 0) {
                            jZzh = unsafe.getLong(t, j);
                            iZzb = zzbn.zzf(i8, jZzh);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 17:
                        break;
                    case 18:
                        iZzw = zzeh.zzw(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 19:
                    case 24:
                    case 31:
                        z3 = false;
                        iZzo = zzeh.zzv(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 20:
                        z3 = false;
                        iZzo = zzeh.zzo(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 21:
                        z3 = false;
                        iZzo = zzeh.zzp(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 22:
                        z3 = false;
                        iZzo = zzeh.zzs(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 23:
                    case 32:
                        z3 = false;
                        iZzo = zzeh.zzw(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 25:
                        z3 = false;
                        iZzo = zzeh.zzx(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 26:
                        iZzw = zzeh.zzc(i8, (List) unsafe.getObject(t, j));
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 27:
                        iZzw = zzeh.zzc(i8, (List<?>) unsafe.getObject(t, j), zzad(i6));
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 28:
                        iZzw = zzeh.zzd(i8, (List<zzbb>) unsafe.getObject(t, j));
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 29:
                        iZzw = zzeh.zzt(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 30:
                        z3 = false;
                        iZzo = zzeh.zzr(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 33:
                        z3 = false;
                        iZzo = zzeh.zzu(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 34:
                        z3 = false;
                        iZzo = zzeh.zzq(i8, (List) unsafe.getObject(t, j), false);
                        iZzb4 += iZzo;
                        z = z3;
                        z2 = false;
                        break;
                    case 35:
                        iZzi = zzeh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                                unsafe.putInt(t, i, iZzi);
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 36:
                        iZzi = zzeh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 37:
                        iZzi = zzeh.zza((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 38:
                        iZzi = zzeh.zzb((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 39:
                        iZzi = zzeh.zze((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 40:
                        iZzi = zzeh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 41:
                        iZzi = zzeh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 42:
                        iZzi = zzeh.zzj((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 43:
                        iZzi = zzeh.zzf((List<Integer>) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 44:
                        iZzi = zzeh.zzd((List<Integer>) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 45:
                        iZzi = zzeh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 46:
                        iZzi = zzeh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 47:
                        iZzi = zzeh.zzg((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 48:
                        iZzi = zzeh.zzc((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzb4 = zza$$ExternalSyntheticOutline0.m$1(iZzi, zzbn.zzr(i8), iZzi, iZzb4);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 49:
                        iZzw = zzeh.zzd(i8, (List) unsafe.getObject(t, j), zzad(i6));
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 50:
                        iZzw = this.zzmz.zzb(i8, unsafe.getObject(t, j), zzae(i6));
                        iZzb4 += iZzw;
                        z = false;
                        z2 = false;
                        break;
                    case 51:
                        if (zza(t, i8, i6)) {
                            iZzb = zzbn.zzb(i8, 0.0d);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 52:
                        if (zza(t, i8, i6)) {
                            iZzb2 = zzbn.zzb(i8, 0.0f);
                            iZzb4 += iZzb2;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 53:
                        if (zza(t, i8, i6)) {
                            iZzb = zzbn.zzd(i8, zzh(t, j));
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 54:
                        if (zza(t, i8, i6)) {
                            iZzb = zzbn.zze(i8, zzh(t, j));
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 55:
                        if (zza(t, i8, i6)) {
                            iZzb = zzbn.zzg(i8, zzg(t, j));
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 56:
                        if (zza(t, i8, i6)) {
                            iZzb = zzbn.zzg(i8, 0L);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 57:
                        if (zza(t, i8, i6)) {
                            iZzb2 = zzbn.zzj(i8, 0);
                            iZzb4 += iZzb2;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 58:
                        break;
                    case 59:
                        if (zza(t, i8, i6)) {
                            object = unsafe.getObject(t, j);
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 60:
                        break;
                    case 61:
                        break;
                    case 62:
                        if (zza(t, i8, i6)) {
                            iZzg = zzg(t, j);
                            iZzb = zzbn.zzh(i8, iZzg);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 63:
                        if (zza(t, i8, i6)) {
                            iZzg2 = zzg(t, j);
                            iZzb = zzbn.zzl(i8, iZzg2);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 64:
                        break;
                    case 65:
                        break;
                    case 66:
                        if (zza(t, i8, i6)) {
                            iZzg3 = zzg(t, j);
                            iZzb = zzbn.zzi(i8, iZzg3);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 67:
                        if (zza(t, i8, i6)) {
                            jZzh = zzh(t, j);
                            iZzb = zzbn.zzf(i8, jZzh);
                            iZzb4 += iZzb;
                        }
                        z = false;
                        z2 = false;
                        break;
                    case 68:
                        break;
                    default:
                        z = false;
                        z2 = false;
                        break;
                }
                i6 += 4;
                i4 = i9;
            }
            int iZza = iZzb4 + zza(this.zzmx, t);
            return this.zzmo ? iZza + this.zzmy.zza(t).zzas() : iZza;
        }
        Unsafe unsafe2 = zzmh;
        int i12 = 0;
        int iM$1 = 0;
        while (i12 < this.zzmi.length) {
            int iZzag2 = zzag(i12);
            int i13 = (iZzag2 & i3) >>> 20;
            int i14 = i3;
            int i15 = this.zzmi[i12];
            long j2 = iZzag2 & 1048575;
            int i16 = (i13 < zzcb.zzih.id() || i13 > zzcb.zziu.id()) ? 0 : this.zzmi[i12 + 2] & 1048575;
            switch (i13) {
                case 0:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzb(i15, 0.0d);
                        iM$1 += iZzb3;
                    }
                    break;
                case 1:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzb(i15, 0.0f);
                        iM$1 += iZzb3;
                    }
                    break;
                case 2:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzd(i15, zzfd.zzk(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 3:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zze(i15, zzfd.zzk(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 4:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzg(i15, zzfd.zzj(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 5:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzg(i15, 0L);
                        iM$1 += iZzb3;
                    }
                    break;
                case 6:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzj(i15, 0);
                        iM$1 += iZzb3;
                    }
                    break;
                case 7:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzc(i15, true);
                        iM$1 += iZzb3;
                    }
                    break;
                case 8:
                    if (zza(t, i12)) {
                        Object objZzo = zzfd.zzo(t, j2);
                        if (!(objZzo instanceof zzbb)) {
                            iZzb3 = zzbn.zzb(i15, (String) objZzo);
                            iM$1 += iZzb3;
                        } else {
                            zzbbVar = (zzbb) objZzo;
                            iZzb3 = zzbn.zzc(i15, zzbbVar);
                            iM$1 += iZzb3;
                        }
                    }
                    break;
                case 9:
                    if (zza(t, i12)) {
                        iZzc = zzeh.zzc(i15, zzfd.zzo(t, j2), zzad(i12));
                        iM$1 += iZzc;
                    }
                    break;
                case 10:
                    if (zza(t, i12)) {
                        zzbbVar = (zzbb) zzfd.zzo(t, j2);
                        iZzb3 = zzbn.zzc(i15, zzbbVar);
                        iM$1 += iZzb3;
                    }
                    break;
                case 11:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzh(i15, zzfd.zzj(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 12:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzl(i15, zzfd.zzj(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 13:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzk(i15, 0);
                        iM$1 += iZzb3;
                    }
                    break;
                case 14:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzh(i15, 0L);
                        iM$1 += iZzb3;
                    }
                    break;
                case 15:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzi(i15, zzfd.zzj(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 16:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzf(i15, zzfd.zzk(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 17:
                    if (zza(t, i12)) {
                        iZzb3 = zzbn.zzc(i15, (zzdo) zzfd.zzo(t, j2), zzad(i12));
                        iM$1 += iZzb3;
                    }
                    break;
                case 18:
                case 23:
                case 32:
                    iZzc = zzeh.zzw(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 19:
                case 24:
                case 31:
                    iZzc = zzeh.zzv(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 20:
                    iZzc = zzeh.zzo(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 21:
                    iZzc = zzeh.zzp(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 22:
                    iZzc = zzeh.zzs(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 25:
                    iZzc = zzeh.zzx(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 26:
                    iZzc = zzeh.zzc(i15, zzd(t, j2));
                    iM$1 += iZzc;
                    break;
                case 27:
                    iZzc = zzeh.zzc(i15, (List<?>) zzd(t, j2), zzad(i12));
                    iM$1 += iZzc;
                    break;
                case 28:
                    iZzc = zzeh.zzd(i15, (List<zzbb>) zzd(t, j2));
                    iM$1 += iZzc;
                    break;
                case 29:
                    iZzc = zzeh.zzt(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 30:
                    iZzc = zzeh.zzr(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 33:
                    iZzc = zzeh.zzu(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 34:
                    iZzc = zzeh.zzq(i15, zzd(t, j2), false);
                    iM$1 += iZzc;
                    break;
                case 35:
                    iZzi2 = zzeh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                            unsafe2.putInt(t, i16, iZzi2);
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 36:
                    iZzi2 = zzeh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 37:
                    iZzi2 = zzeh.zza((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 38:
                    iZzi2 = zzeh.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 39:
                    iZzi2 = zzeh.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 40:
                    iZzi2 = zzeh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 41:
                    iZzi2 = zzeh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 42:
                    iZzi2 = zzeh.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 43:
                    iZzi2 = zzeh.zzf((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 44:
                    iZzi2 = zzeh.zzd((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 45:
                    iZzi2 = zzeh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 46:
                    iZzi2 = zzeh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 47:
                    iZzi2 = zzeh.zzg((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 48:
                    iZzi2 = zzeh.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                            unsafe2.putInt(t, i16, iZzi2);
                        }
                        iZzr = zzbn.zzr(i15);
                        iM$1 = zza$$ExternalSyntheticOutline0.m$1(iZzi2, iZzr, iZzi2, iM$1);
                    }
                    break;
                case 49:
                    iZzc = zzeh.zzd(i15, zzd(t, j2), zzad(i12));
                    iM$1 += iZzc;
                    break;
                case 50:
                    iZzc = this.zzmz.zzb(i15, zzfd.zzo(t, j2), zzae(i12));
                    iM$1 += iZzc;
                    break;
                case 51:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzb(i15, 0.0d);
                        iM$1 += iZzb3;
                    }
                    break;
                case 52:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzb(i15, 0.0f);
                        iM$1 += iZzb3;
                    }
                    break;
                case 53:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzd(i15, zzh(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 54:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zze(i15, zzh(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 55:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzg(i15, zzg(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 56:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzg(i15, 0L);
                        iM$1 += iZzb3;
                    }
                    break;
                case 57:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzj(i15, 0);
                        iM$1 += iZzb3;
                    }
                    break;
                case 58:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzc(i15, true);
                        iM$1 += iZzb3;
                    }
                    break;
                case 59:
                    if (zza(t, i15, i12)) {
                        Object objZzo2 = zzfd.zzo(t, j2);
                        if (!(objZzo2 instanceof zzbb)) {
                            iZzb3 = zzbn.zzb(i15, (String) objZzo2);
                            iM$1 += iZzb3;
                        } else {
                            zzbbVar2 = (zzbb) objZzo2;
                            iZzb3 = zzbn.zzc(i15, zzbbVar2);
                            iM$1 += iZzb3;
                        }
                    }
                    break;
                case 60:
                    if (zza(t, i15, i12)) {
                        iZzc = zzeh.zzc(i15, zzfd.zzo(t, j2), zzad(i12));
                        iM$1 += iZzc;
                    }
                    break;
                case 61:
                    if (zza(t, i15, i12)) {
                        zzbbVar2 = (zzbb) zzfd.zzo(t, j2);
                        iZzb3 = zzbn.zzc(i15, zzbbVar2);
                        iM$1 += iZzb3;
                    }
                    break;
                case 62:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzh(i15, zzg(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 63:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzl(i15, zzg(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 64:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzk(i15, 0);
                        iM$1 += iZzb3;
                    }
                    break;
                case 65:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzh(i15, 0L);
                        iM$1 += iZzb3;
                    }
                    break;
                case 66:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzi(i15, zzg(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 67:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzf(i15, zzh(t, j2));
                        iM$1 += iZzb3;
                    }
                    break;
                case 68:
                    if (zza(t, i15, i12)) {
                        iZzb3 = zzbn.zzc(i15, (zzdo) zzfd.zzo(t, j2), zzad(i12));
                        iM$1 += iZzb3;
                    }
                    break;
            }
            i12 += 4;
            i3 = i14;
        }
        return iM$1 + zza(this.zzmx, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzo(T t) {
        int i;
        int i2;
        int i3;
        int[] iArr = this.zzms;
        int i4 = 1;
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        for (int length = iArr.length; i6 < length; length = i2) {
            int i8 = iArr[i6];
            int iZzai = zzai(i8);
            int iZzag = zzag(iZzai);
            if (this.zzmq) {
                i = i4;
                i2 = length;
                i3 = 0;
            } else {
                int i9 = this.zzmi[iZzai + 2];
                int i10 = i9 & 1048575;
                i3 = i4 << (i9 >>> 20);
                if (i10 != i5) {
                    i = i4;
                    i2 = length;
                    i7 = zzmh.getInt(t, i10);
                    i5 = i10;
                } else {
                    i = i4;
                    i2 = length;
                }
            }
            if ((268435456 & iZzag) != 0 && !zza(t, iZzai, i7, i3)) {
                return false;
            }
            int i11 = (267386880 & iZzag) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zza(t, iZzai, i7, i3) && !zza(t, iZzag, zzad(iZzai))) {
                    return false;
                }
            } else if (i11 == 27) {
                List list = (List) zzfd.zzo(t, iZzag & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzef zzefVarZzad = zzad(iZzai);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzefVarZzad.zzo(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (i11 == 60 || i11 == 68) {
                if (zza(t, i8, iZzai) && !zza(t, iZzag, zzad(iZzai))) {
                    return false;
                }
            } else if (i11 != 49) {
                if (i11 == 50 && !this.zzmz.zzh(zzfd.zzo(t, iZzag & 1048575)).isEmpty()) {
                    this.zzmz.zzl(zzae(iZzai));
                    throw null;
                }
            }
            i6++;
            i4 = i;
        }
        boolean z = i4;
        if (!this.zzmo || this.zzmy.zza(t).isInitialized()) {
            return z;
        }
        return false;
    }

    private static int zza(zzef<?> zzefVar, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcnVar, zzay zzayVar) throws zzco {
        int iZza = zza((zzef) zzefVar, bArr, i2, i3, zzayVar);
        while (true) {
            zzcnVar.add(zzayVar.zzff);
            if (iZza >= i3) {
                break;
            }
            int iZza2 = zzax.zza(bArr, iZza, zzayVar);
            if (i != zzayVar.zzfd) {
                break;
            }
            iZza = zza((zzef) zzefVar, bArr, iZza2, i3, zzayVar);
        }
        return iZza;
    }

    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, zzah(i2) & 1048575, i);
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t) {
        int[] iArr = this.zzmt;
        if (iArr != null) {
            for (int i : iArr) {
                long jZzag = zzag(i) & 1048575;
                Object objZzo = zzfd.zzo(t, jZzag);
                if (objZzo != null) {
                    zzfd.zza(t, jZzag, this.zzmz.zzj(objZzo));
                }
            }
        }
        int[] iArr2 = this.zzmu;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.zzmw.zza(t, i2);
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzef zzefVar, byte[] bArr, int i, int i2, int i3, zzay zzayVar) throws zzco {
        zzds zzdsVar = (zzds) zzefVar;
        Object objNewInstance = zzdsVar.newInstance();
        int iZza = zzdsVar.zza(objNewInstance, bArr, i, i2, i3, zzayVar);
        zzdsVar.zzc(objNewInstance);
        zzayVar.zzff = objNewInstance;
        return iZza;
    }

    private final void zzb(T t, int i) {
        if (this.zzmq) {
            return;
        }
        int iZzah = zzah(i);
        long j = iZzah & 1048575;
        zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (iZzah >>> 20)));
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzef zzefVar, byte[] bArr, int i, int i2, zzay zzayVar) throws zzco {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zzax.zza(i3, bArr, iZza, zzayVar);
            i3 = zzayVar.zzfd;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzco.zzbl();
        }
        Object objNewInstance = zzefVar.newInstance();
        int i5 = i4 + i3;
        zzefVar.zza(objNewInstance, bArr, i4, i5, zzayVar);
        zzefVar.zzc(objNewInstance);
        zzayVar.zzff = objNewInstance;
        return i5;
    }

    private final void zzb(T t, T t2, int i) {
        int iZzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = iZzag & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzo = zzfd.zzo(t, j);
            Object objZzo2 = zzfd.zzo(t2, j);
            if (objZzo != null && objZzo2 != null) {
                objZzo2 = zzci.zza(objZzo, objZzo2);
            } else if (objZzo2 == null) {
                return;
            }
            zzfd.zza(t, j, objZzo2);
            zzb(t, i2, i);
        }
    }

    private static <UT, UB> int zza(zzex<UT, UB> zzexVar, T t) {
        return zzexVar.zzm(zzexVar.zzq(t));
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzay zzayVar) throws zzco {
        int i9;
        Object objValueOf;
        int i10;
        Object objValueOf2;
        int iZzb;
        long jZza;
        int iZzm;
        Object objValueOf3;
        Object object;
        Unsafe unsafe = zzmh;
        long j2 = this.zzmi[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                objValueOf = Double.valueOf(zzax.zze(bArr, i));
                unsafe.putObject(t, j, objValueOf);
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                objValueOf2 = Float.valueOf(zzax.zzf(bArr, i));
                unsafe.putObject(t, j, objValueOf2);
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zzb(bArr, i, zzayVar);
                jZza = zzayVar.zzfe;
                objValueOf3 = Long.valueOf(jZza);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zza(bArr, i, zzayVar);
                iZzm = zzayVar.zzfd;
                objValueOf3 = Integer.valueOf(iZzm);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                objValueOf = Long.valueOf(zzax.zzd(bArr, i));
                unsafe.putObject(t, j, objValueOf);
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                objValueOf2 = Integer.valueOf(zzax.zzc(bArr, i));
                unsafe.putObject(t, j, objValueOf2);
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zzb(bArr, i, zzayVar);
                objValueOf3 = Boolean.valueOf(zzayVar.zzfe != 0);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzax.zza(bArr, i, zzayVar);
                int i11 = zzayVar.zzfd;
                if (i11 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzff.zze(bArr, iZza, iZza + i11)) {
                        throw zzco.zzbp();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i11, zzci.UTF_8));
                    iZza += i11;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zza(zzad(i8), bArr, i, i2, zzayVar);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                Object objZza = zzayVar.zzff;
                if (object != null) {
                    objZza = zzci.zza(object, objZza);
                }
                unsafe.putObject(t, j, objZza);
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza3 = zzax.zza(bArr, i, zzayVar);
                int i12 = zzayVar.zzfd;
                if (i12 == 0) {
                    unsafe.putObject(t, j, zzbb.zzfi);
                } else {
                    unsafe.putObject(t, j, zzbb.zzb(bArr, iZza3, i12));
                    iZza3 += i12;
                }
                unsafe.putInt(t, j2, i4);
                return iZza3;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZza4 = zzax.zza(bArr, i, zzayVar);
                int i13 = zzayVar.zzfd;
                zzck<?> zzckVarZzaf = zzaf(i8);
                if (zzckVarZzaf != null && zzckVarZzaf.zzb(i13) == null) {
                    zzn(t).zzb(i3, Long.valueOf(i13));
                    return iZza4;
                }
                unsafe.putObject(t, j, Integer.valueOf(i13));
                iZzb = iZza4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zza(bArr, i, zzayVar);
                iZzm = zzbk.zzm(zzayVar.zzfd);
                objValueOf3 = Integer.valueOf(iZzm);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zzb(bArr, i, zzayVar);
                jZza = zzbk.zza(zzayVar.zzfe);
                objValueOf3 = Long.valueOf(jZza);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 == 3) {
                    iZzb = zza(zzad(i8), bArr, i, i2, (i3 & (-8)) | 4, zzayVar);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    objValueOf3 = zzayVar.zzff;
                    if (object != null) {
                        objValueOf3 = zzci.zza(object, objValueOf3);
                    }
                    unsafe.putObject(t, j, objValueOf3);
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
            default:
                return i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0131, code lost:
    
        r4.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r11, r9, r12));
        r9 = r9 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0121, code lost:
    
        if (r12 == 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0123, code lost:
    
        r4.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0129, code lost:
    
        r4.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r11, r9, r12));
        r9 = r9 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0131, code lost:
    
        if (r9 >= r13) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0133, code lost:
    
        r12 = com.google.android.gms.internal.clearcut.zzax.zza(r11, r9, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0139, code lost:
    
        if (r14 != r23.zzfd) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013b, code lost:
    
        r9 = com.google.android.gms.internal.clearcut.zzax.zza(r11, r12, r23);
        r12 = r23.zzfd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0141, code lost:
    
        if (r12 != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0144, code lost:
    
        return r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0197 -> B:96:0x0178). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x01ce -> B:109:0x01a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0141 -> B:77:0x0123). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzay zzayVar) throws zzco {
        int iZza;
        Unsafe unsafe = zzmh;
        zzcn zzcnVarZzi = (zzcn) unsafe.getObject(t, j2);
        if (!zzcnVarZzi.zzu()) {
            int size = zzcnVarZzi.size();
            zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzcnVarZzi);
        }
        zzcn zzcnVar = zzcnVarZzi;
        switch (i7) {
            case 18:
            case 35:
                if (i5 != 2) {
                    if (i5 == 1) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zze(bArr, i);
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza2 = zzax.zza(bArr, i, zzayVar);
                int i8 = zzayVar.zzfd + iZza2;
                if (iZza2 < i8) {
                    zzax.zze(bArr, iZza2);
                    throw null;
                }
                if (iZza2 == i8) {
                    return iZza2;
                }
                throw zzco.zzbl();
            case 19:
            case 36:
                if (i5 != 2) {
                    if (i5 == 5) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zzf(bArr, i);
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza3 = zzax.zza(bArr, i, zzayVar);
                int i9 = zzayVar.zzfd + iZza3;
                if (iZza3 < i9) {
                    zzax.zzf(bArr, iZza3);
                    throw null;
                }
                if (iZza3 == i9) {
                    return iZza3;
                }
                throw zzco.zzbl();
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 != 2) {
                    if (i5 == 0) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zzb(bArr, i, zzayVar);
                        long j3 = zzayVar.zzfe;
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza4 = zzax.zza(bArr, i, zzayVar);
                int i10 = zzayVar.zzfd + iZza4;
                if (iZza4 < i10) {
                    zzax.zzb(bArr, iZza4, zzayVar);
                    throw null;
                }
                if (iZza4 == i10) {
                    return iZza4;
                }
                throw zzco.zzbl();
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzax.zza(bArr, i, (zzcn<?>) zzcnVar, zzayVar);
                }
                if (i5 == 0) {
                    return zzax.zza(i3, bArr, i, i2, (zzcn<?>) zzcnVar, zzayVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 != 2) {
                    if (i5 == 1) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zzd(bArr, i);
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza5 = zzax.zza(bArr, i, zzayVar);
                int i11 = zzayVar.zzfd + iZza5;
                if (iZza5 < i11) {
                    zzax.zzd(bArr, iZza5);
                    throw null;
                }
                if (iZza5 == i11) {
                    return iZza5;
                }
                throw zzco.zzbl();
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 != 2) {
                    if (i5 == 5) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zzc(bArr, i);
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza6 = zzax.zza(bArr, i, zzayVar);
                int i12 = zzayVar.zzfd + iZza6;
                if (iZza6 < i12) {
                    zzax.zzc(bArr, iZza6);
                    throw null;
                }
                if (iZza6 == i12) {
                    return iZza6;
                }
                throw zzco.zzbl();
            case 25:
            case 42:
                if (i5 != 2) {
                    if (i5 == 0) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zzb(bArr, i, zzayVar);
                        long j4 = zzayVar.zzfe;
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza7 = zzax.zza(bArr, i, zzayVar);
                int i13 = zzayVar.zzfd + iZza7;
                if (iZza7 < i13) {
                    zzax.zzb(bArr, iZza7, zzayVar);
                    throw null;
                }
                if (iZza7 == i13) {
                    return iZza7;
                }
                throw zzco.zzbl();
            case 26:
                if (i5 == 2) {
                    long j5 = j & 536870912;
                    int iZza8 = zzax.zza(bArr, i, zzayVar);
                    if (j5 == 0) {
                        int i14 = zzayVar.zzfd;
                        if (i14 == 0) {
                            zzcnVar.add("");
                        } else {
                            zzcnVar.add(new String(bArr, iZza8, i14, zzci.UTF_8));
                            iZza8 += i14;
                        }
                        while (iZza8 < i2) {
                            int iZza9 = zzax.zza(bArr, iZza8, zzayVar);
                            if (i3 != zzayVar.zzfd) {
                                return iZza8;
                            }
                            iZza8 = zzax.zza(bArr, iZza9, zzayVar);
                            int i15 = zzayVar.zzfd;
                            if (i15 == 0) {
                                zzcnVar.add("");
                                while (iZza8 < i2) {
                                }
                            } else {
                                zzcnVar.add(new String(bArr, iZza8, i15, zzci.UTF_8));
                                iZza8 += i15;
                            }
                        }
                        return iZza8;
                    }
                    int i16 = zzayVar.zzfd;
                    if (i16 == 0) {
                        zzcnVar.add("");
                    } else {
                        int i17 = iZza8 + i16;
                        if (!zzff.zze(bArr, iZza8, i17)) {
                            throw zzco.zzbp();
                        }
                        zzcnVar.add(new String(bArr, iZza8, i16, zzci.UTF_8));
                        iZza8 = i17;
                    }
                    while (iZza8 < i2) {
                        int iZza10 = zzax.zza(bArr, iZza8, zzayVar);
                        if (i3 != zzayVar.zzfd) {
                            return iZza8;
                        }
                        iZza8 = zzax.zza(bArr, iZza10, zzayVar);
                        int i18 = zzayVar.zzfd;
                        if (i18 == 0) {
                            zzcnVar.add("");
                            while (iZza8 < i2) {
                            }
                        } else {
                            int i19 = iZza8 + i18;
                            if (!zzff.zze(bArr, iZza8, i19)) {
                                throw zzco.zzbp();
                            }
                            zzcnVar.add(new String(bArr, iZza8, i18, zzci.UTF_8));
                            iZza8 = i19;
                        }
                    }
                    return iZza8;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return zza((zzef<?>) zzad(i6), i3, bArr, i, i2, (zzcn<?>) zzcnVar, zzayVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    int iZza11 = zzax.zza(bArr, i, zzayVar);
                    int i20 = zzayVar.zzfd;
                    break;
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzax.zza(i3, bArr, i, i2, (zzcn<?>) zzcnVar, zzayVar);
                    }
                    return i;
                }
                iZza = zzax.zza(bArr, i, (zzcn<?>) zzcnVar, zzayVar);
                zzcg zzcgVar = (zzcg) t;
                zzey zzeyVar = zzcgVar.zzjp;
                zzey zzeyVar2 = (zzey) zzeh.zza(i4, zzcnVar, zzaf(i6), zzeyVar != zzey.zzea() ? zzeyVar : null, this.zzmx);
                if (zzeyVar2 != null) {
                    zzcgVar.zzjp = zzeyVar2;
                }
                return iZza;
            case 33:
            case 47:
                if (i5 != 2) {
                    if (i5 == 0) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zza(bArr, i, zzayVar);
                        zzbk.zzm(zzayVar.zzfd);
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza12 = zzax.zza(bArr, i, zzayVar);
                int i21 = zzayVar.zzfd + iZza12;
                if (iZza12 >= i21) {
                    if (iZza12 == i21) {
                        return iZza12;
                    }
                    throw zzco.zzbl();
                }
                zzax.zza(bArr, iZza12, zzayVar);
                zzbk.zzm(zzayVar.zzfd);
                throw null;
            case 34:
            case 48:
                if (i5 != 2) {
                    if (i5 == 0) {
                        if (zzcnVar != null) {
                            Events$$ExternalSyntheticBUOutline0.m();
                            return 0;
                        }
                        zzax.zzb(bArr, i, zzayVar);
                        zzbk.zza(zzayVar.zzfe);
                        throw null;
                    }
                    return i;
                }
                if (zzcnVar != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return 0;
                }
                int iZza13 = zzax.zza(bArr, i, zzayVar);
                int i22 = zzayVar.zzfd + iZza13;
                if (iZza13 >= i22) {
                    if (iZza13 == i22) {
                        return iZza13;
                    }
                    throw zzco.zzbl();
                }
                zzax.zzb(bArr, iZza13, zzayVar);
                zzbk.zza(zzayVar.zzfe);
                throw null;
            case 49:
                if (i5 == 3) {
                    zzef zzefVarZzad = zzad(i6);
                    int i23 = (i3 & (-8)) | 4;
                    int iZza14 = zza(zzefVarZzad, bArr, i, i2, i23, zzayVar);
                    zzay zzayVar2 = zzayVar;
                    zzcnVar.add(zzayVar2.zzff);
                    while (iZza14 < i2) {
                        int iZza15 = zzax.zza(bArr, iZza14, zzayVar2);
                        if (i3 != zzayVar2.zzfd) {
                            return iZza14;
                        }
                        zzay zzayVar3 = zzayVar2;
                        iZza14 = zza(zzefVarZzad, bArr, iZza15, i2, i23, zzayVar3);
                        zzcnVar.add(zzayVar3.zzff);
                        zzayVar2 = zzayVar3;
                    }
                    return iZza14;
                }
                return i;
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, zzay zzayVar) throws zzco {
        Unsafe unsafe = zzmh;
        Object objZzae = zzae(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzmz.zzi(object)) {
            Object objZzk = this.zzmz.zzk(objZzae);
            this.zzmz.zzb(objZzk, object);
            unsafe.putObject(t, j, objZzk);
            object = objZzk;
        }
        this.zzmz.zzl(objZzae);
        this.zzmz.zzg(object);
        int iZza = zzax.zza(bArr, i, zzayVar);
        int i5 = zzayVar.zzfd;
        if (i5 < 0 || i5 > i2 - iZza) {
            throw zzco.zzbl();
        }
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0067. Please report as an issue. */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, zzay zzayVar) throws zzco {
        zzds<T> zzdsVar;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        T t2;
        int i7;
        int i8;
        int i9;
        zzds<T> zzdsVar2;
        zzck<?> zzckVarZzaf;
        int i10;
        int i11;
        int i12;
        byte[] bArr2;
        Unsafe unsafe2;
        int i13;
        int i14;
        int i15;
        int i16;
        int iZza;
        int i17;
        zzay zzayVar2;
        int i18;
        long j;
        Object objZza;
        zzay zzayVar3;
        int iZzb;
        Unsafe unsafe3;
        int i19;
        zzds<T> zzdsVar3 = this;
        T t3 = t;
        byte[] bArr3 = bArr;
        int i20 = i2;
        zzay zzayVar4 = zzayVar;
        Unsafe unsafe4 = zzmh;
        int i21 = -1;
        int iZza2 = i;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            if (iZza2 < i20) {
                int iZza3 = iZza2 + 1;
                int i25 = bArr3[iZza2];
                if (i25 < 0) {
                    iZza3 = zzax.zza(i25, bArr3, iZza3, zzayVar4);
                    i25 = zzayVar4.zzfd;
                }
                int i26 = i25;
                iZza2 = iZza3;
                int i27 = (i26 == true ? 1 : 0) >>> 3;
                int i28 = (i26 == true ? 1 : 0) & 7;
                int iZzai = zzdsVar3.zzai(i27);
                if (iZzai != i21) {
                    int[] iArr = zzdsVar3.zzmi;
                    int i29 = iArr[iZzai + 1];
                    int i30 = (i29 & 267386880) >>> 20;
                    long j2 = i29 & 1048575;
                    if (i30 <= 17) {
                        int i31 = iArr[iZzai + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = i31 & 1048575;
                        i5 = -1;
                        if (i33 != i22) {
                            if (i22 != -1) {
                                unsafe4.putInt(t3, i22, i24);
                            }
                            i22 = i33;
                            i24 = unsafe4.getInt(t3, i33);
                        }
                        switch (i30) {
                            case 0:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i13 = i26 == true ? 1 : 0;
                                i14 = i2;
                                i15 = i22;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 1) {
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    zzfd.zza(t3, j2, zzax.zze(bArr2, i16));
                                    iZza = i16 + 8;
                                    i24 = i11 | i32;
                                    zzayVar4 = zzayVar;
                                    i23 = i13;
                                    i20 = i14;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 1:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i13 = i26 == true ? 1 : 0;
                                i14 = i2;
                                i15 = i22;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 5) {
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    zzfd.zza((Object) t3, j2, zzax.zzf(bArr2, i16));
                                    iZza = i16 + 4;
                                    i24 = i11 | i32;
                                    zzayVar4 = zzayVar;
                                    i23 = i13;
                                    i20 = i14;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 2:
                            case 3:
                                unsafe2 = unsafe4;
                                zzayVar3 = zzayVar;
                                i15 = i22;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 0) {
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZzb = zzax.zzb(bArr, i16, zzayVar3);
                                    T t4 = t3;
                                    unsafe2.putLong(t4, j2, zzayVar3.zzfe);
                                    unsafe3 = unsafe2;
                                    t3 = t4;
                                    i24 = i11 | i32;
                                    i20 = i2;
                                    bArr3 = bArr;
                                    i23 = i26 == true ? 1 : 0;
                                    i22 = i15;
                                    i21 = -1;
                                    unsafe4 = unsafe3;
                                    iZza2 = iZzb;
                                    zzayVar4 = zzayVar3;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i17 = i2;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 0) {
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zzax.zza(bArr2, i16, zzayVar2);
                                    unsafe2.putInt(t3, j2, zzayVar2.zzfd);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                if (i28 != 1) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    T t5 = t3;
                                    unsafe2.putLong(t5, j2, zzax.zzd(bArr2, i18));
                                    unsafe2 = unsafe2;
                                    t3 = t5;
                                    iZza = i18 + 8;
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                if (i28 != 5) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    unsafe2.putInt(t3, j2, zzax.zzc(bArr2, i18));
                                    iZza = i18 + 4;
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                if (i28 != 0) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zzax.zzb(bArr2, i18, zzayVar2);
                                    zzfd.zza(t3, j2, zzayVar2.zzfe != 0);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                j = j2;
                                if (i28 != 2) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = (i29 & 536870912) == 0 ? zzax.zzc(bArr2, i18, zzayVar2) : zzax.zzd(bArr2, i18, zzayVar2);
                                    objZza = zzayVar2.zzff;
                                    unsafe2.putObject(t3, j, objZza);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                j = j2;
                                if (i28 != 2) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zza(zzdsVar3.zzad(iZzai), bArr2, i18, i17, zzayVar2);
                                    objZza = (i11 & i32) == 0 ? zzayVar2.zzff : zzci.zza(unsafe2.getObject(t3, j), zzayVar2.zzff);
                                    unsafe2.putObject(t3, j, objZza);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                j = j2;
                                if (i28 != 2) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zzax.zze(bArr2, i18, zzayVar2);
                                    objZza = zzayVar2.zzff;
                                    unsafe2.putObject(t3, j, objZza);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar2;
                                    i22 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i22;
                                if (i28 != 0) {
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zzax.zza(bArr2, i18, zzayVar2);
                                    int i34 = zzayVar2.zzfd;
                                    zzck<?> zzckVarZzaf2 = zzdsVar3.zzaf(iZzai);
                                    if (zzckVarZzaf2 != null && zzckVarZzaf2.zzb(i34) == null) {
                                        zzn(t3).zzb(i26 == true ? 1 : 0, Long.valueOf(i34));
                                        i20 = i17;
                                        i23 = i26 == true ? 1 : 0;
                                        zzayVar4 = zzayVar2;
                                        i22 = i15;
                                        i24 = i11;
                                        unsafe4 = unsafe2;
                                        iZza2 = iZza;
                                        bArr3 = bArr2;
                                        i21 = -1;
                                    } else {
                                        unsafe2.putInt(t3, j2, i34);
                                        i24 = i11 | i32;
                                        i20 = i17;
                                        i23 = i26 == true ? 1 : 0;
                                        zzayVar4 = zzayVar2;
                                        i22 = i15;
                                        unsafe4 = unsafe2;
                                        iZza2 = iZza;
                                        bArr3 = bArr2;
                                        i21 = -1;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                if (i28 != 0) {
                                    i15 = i22;
                                    i11 = i24;
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zzax.zza(bArr2, i18, zzayVar);
                                    unsafe2.putInt(t3, j2, zzbk.zzm(zzayVar.zzfd));
                                    i24 |= i32;
                                    i20 = i2;
                                    i23 = i26 == true ? 1 : 0;
                                    zzayVar4 = zzayVar;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            case 16:
                                i18 = iZza2;
                                if (i28 != 0) {
                                    unsafe2 = unsafe4;
                                    i15 = i22;
                                    i11 = i24;
                                    i16 = i18;
                                    i13 = i26 == true ? 1 : 0;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZzb = zzax.zzb(bArr, i18, zzayVar);
                                    zzayVar3 = zzayVar;
                                    T t6 = t3;
                                    Unsafe unsafe5 = unsafe4;
                                    unsafe5.putLong(t6, j2, zzbk.zza(zzayVar.zzfe));
                                    unsafe3 = unsafe5;
                                    t3 = t6;
                                    i24 |= i32;
                                    i20 = i2;
                                    bArr3 = bArr;
                                    i23 = i26 == true ? 1 : 0;
                                    i21 = -1;
                                    unsafe4 = unsafe3;
                                    iZza2 = iZzb;
                                    zzayVar4 = zzayVar3;
                                }
                                break;
                            case 17:
                                if (i28 != 3) {
                                    unsafe2 = unsafe4;
                                    i15 = i22;
                                    i13 = i26 == true ? 1 : 0;
                                    i16 = iZza2;
                                    i11 = i24;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i22 = i15;
                                    i24 = i11;
                                } else {
                                    iZza = zza(zzdsVar3.zzad(iZzai), bArr, iZza2, i2, (i27 << 3) | 4, zzayVar);
                                    bArr2 = bArr;
                                    unsafe4.putObject(t3, j2, (i24 & i32) == 0 ? zzayVar.zzff : zzci.zza(unsafe4.getObject(t3, j2), zzayVar.zzff));
                                    i24 |= i32;
                                    i20 = i2;
                                    zzayVar4 = zzayVar;
                                    i23 = i26 == true ? 1 : 0;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                                break;
                            default:
                                unsafe2 = unsafe4;
                                i15 = i22;
                                i13 = i26 == true ? 1 : 0;
                                i16 = iZza2;
                                i11 = i24;
                                i6 = i3;
                                zzdsVar = zzdsVar3;
                                unsafe = unsafe2;
                                i12 = i13;
                                iZza2 = i16;
                                i22 = i15;
                                i24 = i11;
                                break;
                        }
                    } else {
                        Unsafe unsafe6 = unsafe4;
                        i5 = -1;
                        int i35 = i20;
                        if (i30 != 27) {
                            iZza2 = iZza2;
                            if (i30 <= 49) {
                                i11 = i24;
                                unsafe = unsafe6;
                                i10 = i22;
                                int iZza4 = zzdsVar3.zza(t, bArr, iZza2, i2, i26 == true ? 1 : 0, i27, i28, iZzai, i29, i30, j2, zzayVar);
                                i19 = i26 == true ? 1 : 0;
                                if (iZza4 == iZza2) {
                                    zzdsVar = this;
                                    i6 = i3;
                                    iZza2 = iZza4;
                                    i12 = i19;
                                    i24 = i11;
                                    i22 = i10;
                                } else {
                                    zzdsVar3 = this;
                                    t3 = t;
                                    bArr3 = bArr;
                                    i20 = i2;
                                    zzayVar4 = zzayVar;
                                    iZza2 = iZza4;
                                    i23 = i19;
                                    i21 = -1;
                                    unsafe4 = unsafe;
                                    i24 = i11;
                                    i22 = i10;
                                }
                            } else {
                                unsafe = unsafe6;
                                i10 = i22;
                                i11 = i24;
                                i19 = i26 == true ? 1 : 0;
                                if (i30 != 50) {
                                    int iZza5 = zza(t, bArr, iZza2, i2, i19 == true ? 1 : 0, i27, i28, i29, i30, j2, iZzai, zzayVar);
                                    zzdsVar = this;
                                    i12 = i19 == true ? 1 : 0;
                                    if (iZza5 == iZza2) {
                                        i22 = i10;
                                        i6 = i3;
                                        iZza2 = iZza5;
                                        i24 = i11;
                                    } else {
                                        t3 = t;
                                        i22 = i10;
                                        i20 = i2;
                                        i23 = i12 == true ? 1 : 0;
                                        iZza2 = iZza5;
                                        zzdsVar3 = zzdsVar;
                                        i21 = -1;
                                        unsafe4 = unsafe;
                                        i24 = i11;
                                        bArr3 = bArr;
                                        zzayVar4 = zzayVar;
                                    }
                                } else if (i28 == 2) {
                                    int iZza6 = zza(t, bArr, iZza2, i2, iZzai, i27, j2, zzayVar);
                                    if (iZza6 == iZza2) {
                                        zzdsVar = this;
                                        i6 = i3;
                                        iZza2 = iZza6;
                                        i12 = i19;
                                        i24 = i11;
                                        i22 = i10;
                                    } else {
                                        zzdsVar3 = this;
                                        t3 = t;
                                        bArr3 = bArr;
                                        i20 = i2;
                                        zzayVar4 = zzayVar;
                                        iZza2 = iZza6;
                                        i23 = i19;
                                        i21 = -1;
                                        unsafe4 = unsafe;
                                        i24 = i11;
                                        i22 = i10;
                                    }
                                } else {
                                    zzdsVar = this;
                                    i12 = i19 == true ? 1 : 0;
                                }
                            }
                        } else if (i28 == 2) {
                            zzcn zzcnVarZzi = (zzcn) unsafe6.getObject(t3, j2);
                            if (!zzcnVarZzi.zzu()) {
                                int size = zzcnVarZzi.size();
                                zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
                                unsafe6.putObject(t3, j2, zzcnVarZzi);
                            }
                            zzayVar4 = zzayVar;
                            unsafe4 = unsafe6;
                            i20 = i2;
                            iZza2 = zza((zzef<?>) zzdsVar3.zzad(iZzai), i26 == true ? 1 : 0, bArr, iZza2, i35, (zzcn<?>) zzcnVarZzi, zzayVar4);
                            i23 = i26 == true ? 1 : 0;
                            i21 = -1;
                            t3 = t;
                            bArr3 = bArr;
                        } else {
                            zzdsVar = zzdsVar3;
                            i12 = i26 == true ? 1 : 0;
                            unsafe = unsafe6;
                            i10 = i22;
                            iZza2 = iZza2;
                            i11 = i24;
                        }
                    }
                    if (i12 == i6 || i6 == 0) {
                        int i36 = i12;
                        int iZza7 = zza(i36 == true ? 1 : 0, bArr, iZza2, i2, t, zzayVar);
                        i23 = i36 == true ? 1 : 0;
                        t3 = t;
                        zzdsVar3 = zzdsVar;
                        i21 = i5;
                        unsafe4 = unsafe;
                        zzayVar4 = zzayVar;
                        i20 = i2;
                        iZza2 = iZza7;
                        bArr3 = bArr;
                    } else {
                        t2 = t;
                        i4 = i2;
                        i7 = i22;
                        i9 = i24;
                        i8 = i12;
                    }
                } else {
                    zzdsVar = zzdsVar3;
                    unsafe = unsafe4;
                    i5 = i21;
                    i10 = i22;
                    i11 = i24;
                    i12 = i26 == true ? 1 : 0;
                }
                i22 = i10;
                i6 = i3;
                i24 = i11;
                if (i12 == i6) {
                }
                int i362 = i12;
                int iZza72 = zza(i362 == true ? 1 : 0, bArr, iZza2, i2, t, zzayVar);
                i23 = i362 == true ? 1 : 0;
                t3 = t;
                zzdsVar3 = zzdsVar;
                i21 = i5;
                unsafe4 = unsafe;
                zzayVar4 = zzayVar;
                i20 = i2;
                iZza2 = iZza72;
                bArr3 = bArr;
            } else {
                zzdsVar = zzdsVar3;
                i4 = i20;
                unsafe = unsafe4;
                i5 = i21;
                int i37 = i24;
                i6 = i3;
                t2 = t3;
                i7 = i22;
                i8 = i23;
                i9 = i37;
            }
        }
        int i38 = iZza2;
        if (i7 != i5) {
            unsafe.putInt(t2, i7, i9);
        }
        int[] iArr2 = zzdsVar.zzmt;
        if (iArr2 != null) {
            int length = iArr2.length;
            Object objZza2 = null;
            int i39 = 0;
            while (i39 < length) {
                int i40 = iArr2[i39];
                zzex zzexVar = zzdsVar.zzmx;
                int i41 = zzdsVar.zzmi[i40];
                Object objZzo = zzfd.zzo(t2, zzdsVar.zzag(i40) & 1048575);
                if (objZzo == null || (zzckVarZzaf = zzdsVar.zzaf(i40)) == null) {
                    zzdsVar2 = zzdsVar;
                } else {
                    Map mapZzg = zzdsVar.zzmz.zzg(objZzo);
                    zzdsVar2 = zzdsVar;
                    objZza2 = zzdsVar2.zza(i40, i41, mapZzg, zzckVarZzaf, objZza2, (zzex<UT, Object>) zzexVar);
                }
                objZza2 = (zzey) objZza2;
                i39++;
                zzdsVar = zzdsVar2;
            }
            zzds<T> zzdsVar4 = zzdsVar;
            if (objZza2 != null) {
                zzdsVar4.zzmx.zzf(t2, objZza2);
            }
        }
        if (i6 == 0) {
            if (i38 != i4) {
                throw zzco.zzbo();
            }
        } else if (i38 > i4 || i8 != i6) {
            throw zzco.zzbo();
        }
        return i38;
    }

    public static <T> zzds<T> zza(Class<T> cls, zzdm zzdmVar, zzdw zzdwVar, zzcy zzcyVar, zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdj zzdjVar) {
        int iZzcu;
        int i;
        int i2;
        int iZza;
        int iZza2;
        int iZzdg;
        if (zzdmVar instanceof zzec) {
            zzec zzecVar = (zzec) zzdmVar;
            boolean z = zzecVar.zzcf() == zzcg.zzg.zzkm;
            if (zzecVar.getFieldCount() == 0) {
                iZzcu = 0;
                i = 0;
                i2 = 0;
            } else {
                int iZzcp = zzecVar.zzcp();
                int iZzcq = zzecVar.zzcq();
                iZzcu = zzecVar.zzcu();
                i = iZzcp;
                i2 = iZzcq;
            }
            int[] iArr = new int[iZzcu << 2];
            Object[] objArr = new Object[iZzcu << 1];
            int[] iArr2 = zzecVar.zzcr() > 0 ? new int[zzecVar.zzcr()] : null;
            int[] iArr3 = zzecVar.zzcs() > 0 ? new int[zzecVar.zzcs()] : null;
            zzed zzedVarZzco = zzecVar.zzco();
            if (zzedVarZzco.next()) {
                int iZzcx = zzedVarZzco.zzcx();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (iZzcx >= zzecVar.zzcv() || i3 >= ((iZzcx - i) << 2)) {
                        if (zzedVarZzco.zzda()) {
                            iZza = (int) zzfd.zza(zzedVarZzco.zzdb());
                            iZza2 = (int) zzfd.zza(zzedVarZzco.zzdc());
                            iZzdg = 0;
                        } else {
                            iZza = (int) zzfd.zza(zzedVarZzco.zzdd());
                            if (zzedVarZzco.zzde()) {
                                iZza2 = (int) zzfd.zza(zzedVarZzco.zzdf());
                                iZzdg = zzedVarZzco.zzdg();
                            } else {
                                iZza2 = 0;
                                iZzdg = 0;
                            }
                        }
                        iArr[i3] = zzedVarZzco.zzcx();
                        int i6 = i3 + 1;
                        iArr[i6] = (zzedVarZzco.zzdi() ? 536870912 : 0) | (zzedVarZzco.zzdh() ? ClientDefaults.MAX_MSG_SIZE : 0) | (zzedVarZzco.zzcy() << 20) | iZza;
                        iArr[i3 + 2] = iZza2 | (iZzdg << 20);
                        if (zzedVarZzco.zzdl() != null) {
                            int i7 = (i3 / 4) << 1;
                            objArr[i7] = zzedVarZzco.zzdl();
                            if (zzedVarZzco.zzdj() != null) {
                                objArr[i7 + 1] = zzedVarZzco.zzdj();
                            } else if (zzedVarZzco.zzdk() != null) {
                                objArr[i7 + 1] = zzedVarZzco.zzdk();
                            }
                        } else if (zzedVarZzco.zzdj() != null) {
                            objArr[((i3 / 4) << 1) + 1] = zzedVarZzco.zzdj();
                        } else if (zzedVarZzco.zzdk() != null) {
                            objArr[((i3 / 4) << 1) + 1] = zzedVarZzco.zzdk();
                        }
                        int iZzcy = zzedVarZzco.zzcy();
                        if (iZzcy == zzcb.zziw.ordinal()) {
                            iArr2[i4] = i3;
                            i4++;
                        } else if (iZzcy >= 18 && iZzcy <= 49) {
                            iArr3[i5] = iArr[i6] & 1048575;
                            i5++;
                        }
                        if (!zzedVarZzco.next()) {
                            break;
                        }
                        iZzcx = zzedVarZzco.zzcx();
                    } else {
                        for (int i8 = 0; i8 < 4; i8++) {
                            iArr[i3 + i8] = -1;
                        }
                    }
                    i3 += 4;
                }
            }
            return new zzds<>(iArr, objArr, i, i2, zzecVar.zzcv(), zzecVar.zzch(), z, false, zzecVar.zzct(), iArr2, iArr3, zzdwVar, zzcyVar, zzexVar, zzbuVar, zzdjVar);
        }
        zzdmVar.getClass();
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> zzckVar, UB ub, zzex<UT, UB> zzexVar) {
        this.zzmz.zzl(zzae(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (zzckVar.zzb(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzexVar.zzdz();
                }
                zzbg zzbgVarZzk = zzbb.zzk(zzdg.zza(null, next.getKey(), next.getValue()));
                try {
                    zzdg.zza(zzbgVarZzk.zzae(), null, next.getKey(), next.getValue());
                    zzexVar.zza(ub, i2, zzbgVarZzk.zzad());
                    it.remove();
                } catch (IOException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                    return null;
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr zzfrVar) {
        if (obj instanceof String) {
            zzfrVar.zza(i, (String) obj);
        } else {
            zzfrVar.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> zzexVar, T t, zzfr zzfrVar) {
        zzexVar.zza(zzexVar.zzq(t), zzfrVar);
    }

    private final <K, V> void zza(zzfr zzfrVar, int i, Object obj, int i2) {
        if (obj != null) {
            this.zzmz.zzl(zzae(i2));
            zzfrVar.zza(i, (zzdh) null, this.zzmz.zzh(obj));
        }
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay zzayVar) {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), zzayVar);
    }

    private final void zza(T t, T t2, int i) {
        long jZzag = zzag(i) & 1048575;
        if (zza(t2, i)) {
            Object objZzo = zzfd.zzo(t, jZzag);
            Object objZzo2 = zzfd.zzo(t2, jZzag);
            if (objZzo != null && objZzo2 != null) {
                objZzo2 = zzci.zza(objZzo, objZzo2);
            } else if (objZzo2 == null) {
                return;
            }
            zzfd.zza(t, jZzag, objZzo2);
            zzb(t, i);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzayVar) throws zzco {
        Unsafe unsafe;
        zzay zzayVar2;
        T t2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        int i6;
        int iZza;
        Unsafe unsafe2;
        T t3;
        Object objZza;
        T t4;
        int iZzm;
        zzds<T> zzdsVar = this;
        byte[] bArr3 = bArr;
        int i7 = i2;
        zzay zzayVar3 = zzayVar;
        if (!zzdsVar.zzmq) {
            zza(t, bArr, i, i7, 0, zzayVar);
            return;
        }
        Unsafe unsafe3 = zzmh;
        int iZza2 = i;
        while (iZza2 < i7) {
            int iZza3 = iZza2 + 1;
            int i8 = bArr3[iZza2];
            if (i8 < 0) {
                iZza3 = zzax.zza(i8, bArr3, iZza3, zzayVar3);
                i8 = zzayVar3.zzfd;
            }
            int i9 = i8;
            int i10 = iZza3;
            int i11 = (i9 == true ? 1 : 0) >>> 3;
            int i12 = (i9 == true ? 1 : 0) & 7;
            int iZzai = zzdsVar.zzai(i11);
            if (iZzai >= 0) {
                int i13 = zzdsVar.zzmi[iZzai + 1];
                int i14 = (267386880 & i13) >>> 20;
                long j = 1048575 & i13;
                if (i14 <= 17) {
                    switch (i14) {
                        case 0:
                            unsafe = unsafe3;
                            if (i12 == 1) {
                                zzfd.zza(t, j, zzax.zze(bArr3, i10));
                                iZza2 = i10 + 8;
                                unsafe3 = unsafe;
                            }
                            i6 = i10;
                            t2 = t;
                            bArr2 = bArr;
                            i4 = i6;
                            i5 = i9;
                            i3 = i2;
                            zzayVar2 = zzayVar;
                            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                            zzdsVar = this;
                            bArr3 = bArr;
                            zzayVar3 = zzayVar;
                            i7 = i3;
                            unsafe3 = unsafe;
                            break;
                        case 1:
                            unsafe = unsafe3;
                            if (i12 == 5) {
                                zzfd.zza((Object) t, j, zzax.zzf(bArr3, i10));
                                iZza2 = i10 + 4;
                                unsafe3 = unsafe;
                            }
                            i6 = i10;
                            t2 = t;
                            bArr2 = bArr;
                            i4 = i6;
                            i5 = i9;
                            i3 = i2;
                            zzayVar2 = zzayVar;
                            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                            zzdsVar = this;
                            bArr3 = bArr;
                            zzayVar3 = zzayVar;
                            i7 = i3;
                            unsafe3 = unsafe;
                            break;
                        case 2:
                        case 3:
                            Unsafe unsafe4 = unsafe3;
                            if (i12 != 0) {
                                unsafe = unsafe4;
                                i6 = i10;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                int iZzb = zzax.zzb(bArr3, i10, zzayVar3);
                                unsafe3 = unsafe4;
                                unsafe3.putLong(t, j, zzayVar3.zzfe);
                                iZza2 = iZzb;
                            }
                            break;
                        case 4:
                        case 11:
                            unsafe2 = unsafe3;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = zzax.zza(bArr3, i10, zzayVar3);
                                unsafe2.putInt(t, j, zzayVar3.zzfd);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 5:
                        case 14:
                            unsafe2 = unsafe3;
                            if (i12 != 1) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                unsafe2.putLong(t, j, zzax.zzd(bArr3, i10));
                                iZza2 = i10 + 8;
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 6:
                        case 13:
                            unsafe2 = unsafe3;
                            if (i12 != 5) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                unsafe2.putInt(t, j, zzax.zzc(bArr3, i10));
                                iZza2 = i10 + 4;
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 7:
                            unsafe2 = unsafe3;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = zzax.zzb(bArr3, i10, zzayVar3);
                                zzfd.zza(t, j, zzayVar3.zzfe != 0);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 8:
                            unsafe2 = unsafe3;
                            t3 = t;
                            if (i12 != 2) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = (536870912 & i13) == 0 ? zzax.zzc(bArr3, i10, zzayVar3) : zzax.zzd(bArr3, i10, zzayVar3);
                                objZza = zzayVar3.zzff;
                                unsafe2.putObject(t3, j, objZza);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 9:
                            unsafe2 = unsafe3;
                            t3 = t;
                            if (i12 != 2) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = zza(zzdsVar.zzad(iZzai), bArr3, i10, i7, zzayVar3);
                                Object object = unsafe2.getObject(t3, j);
                                objZza = object == null ? zzayVar3.zzff : zzci.zza(object, zzayVar3.zzff);
                                unsafe2.putObject(t3, j, objZza);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 10:
                            unsafe2 = unsafe3;
                            t3 = t;
                            if (i12 != 2) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = zzax.zze(bArr3, i10, zzayVar3);
                                objZza = zzayVar3.zzff;
                                unsafe2.putObject(t3, j, objZza);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 12:
                            unsafe2 = unsafe3;
                            t4 = t;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = zzax.zza(bArr3, i10, zzayVar3);
                                iZzm = zzayVar3.zzfd;
                                unsafe2.putInt(t4, j, iZzm);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 15:
                            unsafe2 = unsafe3;
                            t4 = t;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                iZza2 = zzax.zza(bArr3, i10, zzayVar3);
                                iZzm = zzbk.zzm(zzayVar3.zzfd);
                                unsafe2.putInt(t4, j, iZzm);
                                unsafe3 = unsafe2;
                            }
                            break;
                        case 16:
                            if (i12 != 0) {
                                unsafe2 = unsafe3;
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                            } else {
                                int iZzb2 = zzax.zzb(bArr3, i10, zzayVar3);
                                unsafe3.putLong(t, j, zzbk.zza(zzayVar3.zzfe));
                                unsafe2 = unsafe3;
                                iZza2 = iZzb2;
                                unsafe3 = unsafe2;
                            }
                            break;
                    }
                } else {
                    unsafe = unsafe3;
                    if (i14 != 27) {
                        if (i14 <= 49) {
                            iZza = zzdsVar.zza(t, bArr, i10, i2, i9 == true ? 1 : 0, i11, i12, iZzai, i13, i14, j, zzayVar);
                            if (iZza == i10) {
                                t2 = t;
                                bArr2 = bArr;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                i4 = iZza;
                                i5 = i9 == true ? 1 : 0;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                            }
                        } else {
                            if (i14 != 50) {
                                iZza = zza(t, bArr, i10, i2, i9 == true ? 1 : 0, i11, i12, i13, i14, j, iZzai, zzayVar);
                                if (iZza == i10) {
                                    t2 = t;
                                    bArr2 = bArr;
                                    i3 = i2;
                                    i5 = i9 == true ? 1 : 0;
                                    i4 = iZza;
                                }
                            } else if (i12 == 2) {
                                int iZza4 = zza(t, bArr, i10, i2, iZzai, i11, j, zzayVar);
                                if (iZza4 == i10) {
                                    t2 = t;
                                    bArr2 = bArr;
                                    i3 = i2;
                                    i4 = iZza4;
                                    i5 = i9 == true ? 1 : 0;
                                } else {
                                    zzdsVar = this;
                                    bArr3 = bArr;
                                    i7 = i2;
                                    zzayVar3 = zzayVar;
                                    iZza2 = iZza4;
                                }
                            } else {
                                i6 = i10;
                                i9 = i9 == true ? 1 : 0;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                            }
                            zzayVar2 = zzayVar;
                            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                            zzdsVar = this;
                            bArr3 = bArr;
                            zzayVar3 = zzayVar;
                            i7 = i3;
                        }
                        zzdsVar = this;
                        bArr3 = bArr;
                        i7 = i2;
                        zzayVar3 = zzayVar;
                        iZza2 = iZza;
                    } else if (i12 == 2) {
                        zzcn zzcnVarZzi = (zzcn) unsafe.getObject(t, j);
                        if (!zzcnVarZzi.zzu()) {
                            int size = zzcnVarZzi.size();
                            zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
                            unsafe.putObject(t, j, zzcnVarZzi);
                        }
                        iZza2 = zza((zzef<?>) zzdsVar.zzad(iZzai), i9 == true ? 1 : 0, bArr3, i10, i7, (zzcn<?>) zzcnVarZzi, zzayVar3);
                        bArr3 = bArr;
                        i7 = i2;
                        zzayVar3 = zzayVar;
                    } else {
                        i9 = i9 == true ? 1 : 0;
                        i6 = i10;
                        t2 = t;
                        bArr2 = bArr;
                        i4 = i6;
                        i5 = i9;
                        i3 = i2;
                        zzayVar2 = zzayVar;
                        iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                        zzdsVar = this;
                        bArr3 = bArr;
                        zzayVar3 = zzayVar;
                        i7 = i3;
                    }
                    unsafe3 = unsafe;
                }
            }
            unsafe = unsafe3;
            i6 = i10;
            t2 = t;
            bArr2 = bArr;
            i4 = i6;
            i5 = i9;
            i3 = i2;
            zzayVar2 = zzayVar;
            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
            zzdsVar = this;
            bArr3 = bArr;
            zzayVar3 = zzayVar;
            i7 = i3;
            unsafe3 = unsafe;
        }
        if (iZza2 != i7) {
            throw zzco.zzbo();
        }
    }

    private final boolean zza(T t, int i) {
        if (!this.zzmq) {
            int iZzah = zzah(i);
            return (zzfd.zzj(t, (long) (iZzah & 1048575)) & (1 << (iZzah >>> 20))) != 0;
        }
        int iZzag = zzag(i);
        long j = iZzag & 1048575;
        switch ((iZzag & 267386880) >>> 20) {
            case 0:
                return zzfd.zzn(t, j) != 0.0d;
            case 1:
                return zzfd.zzm(t, j) != 0.0f;
            case 2:
                return zzfd.zzk(t, j) != 0;
            case 3:
                return zzfd.zzk(t, j) != 0;
            case 4:
                return zzfd.zzj(t, j) != 0;
            case 5:
                return zzfd.zzk(t, j) != 0;
            case 6:
                return zzfd.zzj(t, j) != 0;
            case 7:
                return zzfd.zzl(t, j);
            case 8:
                Object objZzo = zzfd.zzo(t, j);
                if (objZzo instanceof String) {
                    return !((String) objZzo).isEmpty();
                }
                if (objZzo instanceof zzbb) {
                    return !zzbb.zzfi.equals(objZzo);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return false;
            case 9:
                return zzfd.zzo(t, j) != null;
            case 10:
                return !zzbb.zzfi.equals(zzfd.zzo(t, j));
            case 11:
                return zzfd.zzj(t, j) != 0;
            case 12:
                return zzfd.zzj(t, j) != 0;
            case 13:
                return zzfd.zzj(t, j) != 0;
            case 14:
                return zzfd.zzk(t, j) != 0;
            case 15:
                return zzfd.zzj(t, j) != 0;
            case 16:
                return zzfd.zzk(t, j) != 0;
            case 17:
                return zzfd.zzo(t, j) != null;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return false;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzmq ? zza(t, i) : (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzef zzefVar) {
        return zzefVar.zzo(zzfd.zzo(obj, i & 1048575));
    }
}
