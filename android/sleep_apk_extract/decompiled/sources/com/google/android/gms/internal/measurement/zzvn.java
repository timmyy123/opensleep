package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzvn implements zzws {
    private final zzws zza;
    private final UUID zzb;
    private final String zzc;
    private final String zzd;
    private Thread zze;

    public zzvn(String str, zzws zzwsVar, zzwq zzwqVar) {
        this.zzd = (String) Preconditions.checkNotNull(str);
        this.zza = zzwsVar;
        this.zzb = zzwsVar.zzc();
        this.zzc = zzwsVar.zzd();
        zzwqVar.getClass();
        this.zze = Thread.currentThread();
    }

    public static String zzcL(UUID uuid) {
        return "tk-trace-id: ".concat(String.valueOf(Long.toString(uuid.getLeastSignificantBits() >>> 1, 36)));
    }

    @Override // com.google.android.gms.internal.measurement.zzwt, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzrg zzrgVar = zzvy.zza;
        Preconditions.checkNotNull(this);
        zzwq zzwqVarZzd = zzvy.zzd();
        zzws zzwsVar = zzwqVarZzd.zzb;
        if (zzwsVar == null) {
            String strZze = zze();
            throw new zzvv(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strZze).length() + 101), "Tried to end [", strZze, "], but no trace was active. This is caused by mismatched or missing calls to beginSpan."));
        }
        if (this == zzwsVar) {
            zzvy.zzc(zzwqVarZzd, zzwsVar.zzb());
            this.zze = null;
            return;
        }
        String strZze2 = zze();
        String strZze3 = zzwsVar.zze();
        StringBuilder sb = new StringBuilder(String.valueOf(strZze2).length() + 79 + String.valueOf(strZze3).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Tried to end span ", strZze2, ", but that span is not the current span. The current span is ", strZze3);
        sb.append(".");
        throw new zzvw(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.internal.measurement.zzvn] */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r1v20, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r6v11 */
    public final String toString() {
        String strConcat;
        zzrg zzrgVar = zzvy.zza;
        ?? Zzb = this;
        int i = 0;
        int length = 0;
        while (Zzb != 0) {
            i++;
            length += Zzb.zze().length();
            Zzb = Zzb.zzb();
            if (Zzb != 0) {
                length += 4;
            }
        }
        if (i > 250) {
            int i2 = i - 1;
            String[] strArr = new String[i];
            ?? Zzb2 = this;
            while (i2 >= 0) {
                strArr[i2] = Zzb2.zze();
                i2--;
                Zzb2 = Zzb2.zzb();
            }
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ImmutableSet.copyOf(strArr).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                builder.put(it.next(), Integer.valueOf(i3));
                i3++;
            }
            ImmutableMap immutableMapBuildOrThrow = builder.buildOrThrow();
            int i4 = i >> 2;
            zzwo zzwoVar = null;
            if (immutableMapBuildOrThrow.size() <= i4) {
                int[] iArr = new int[i + 1];
                for (int i5 = 0; i5 < i; i5++) {
                    iArr[i5] = ((Integer) immutableMapBuildOrThrow.get(strArr[i5])).intValue();
                }
                iArr[i] = immutableMapBuildOrThrow.size();
                zzwo zzwoVarZzd = zzwp.zza(iArr).zzd();
                if ((zzwoVarZzd.zzb - zzwoVarZzd.zza) * zzwoVarZzd.zzc >= i4) {
                    zzwoVar = zzwoVarZzd;
                }
            }
            strConcat = "";
            if (zzwoVar != null) {
                int i6 = zzwoVar.zza;
                String strConcat2 = i6 > 0 ? String.valueOf(TextUtils.join(" -> ", Arrays.copyOf(strArr, i6))).concat(" -> ") : "";
                int i7 = zzwoVar.zzb;
                int i8 = zzwoVar.zzc;
                int i9 = ((i7 - i6) * i8) + i6;
                strConcat = i9 < i ? " -> ".concat(String.valueOf(TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i9, i)))) : "";
                String strJoin = TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i6, i7));
                Locale locale = Locale.US;
                strConcat = strConcat2 + "{" + strJoin + "}x" + i8 + strConcat;
            }
            if (!strConcat.isEmpty()) {
                return strConcat;
            }
        }
        char[] cArr = new char[length];
        while (this != 0) {
            String strZze = this.zze();
            length -= strZze.length();
            strZze.getChars(0, strZze.length(), cArr, length);
            this = this.zzb();
            if (this != 0) {
                length -= 4;
                " -> ".getChars(0, 4, cArr, length);
            }
        }
        return new String(cArr);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final Thread zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzws zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final UUID zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final String zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final String zze() {
        return this.zzd;
    }

    public zzvn(String str, UUID uuid, String str2, zzwq zzwqVar) {
        this.zzd = (String) Preconditions.checkNotNull(str);
        this.zza = null;
        this.zzb = uuid;
        this.zzc = str2;
        zzwqVar.getClass();
        this.zze = Thread.currentThread();
    }
}
