package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzatx {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public zzatx(String str, zzasn zzasnVar) {
        String str2 = zzasnVar.zzb;
        long j = zzasnVar.zzc;
        long j2 = zzasnVar.zzd;
        long j3 = zzasnVar.zze;
        long j4 = zzasnVar.zzf;
        ?? arrayList = zzasnVar.zzh;
        if (arrayList == 0) {
            Map map = zzasnVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzasw((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    public static zzatx zza(zzaty zzatyVar) throws IOException {
        if (zzaua.zzi(zzatyVar) != 538247942) {
            throw new IOException();
        }
        String strZzm = zzaua.zzm(zzatyVar);
        String strZzm2 = zzaua.zzm(zzatyVar);
        long jZzk = zzaua.zzk(zzatyVar);
        long jZzk2 = zzaua.zzk(zzatyVar);
        long jZzk3 = zzaua.zzk(zzatyVar);
        long jZzk4 = zzaua.zzk(zzatyVar);
        int iZzi = zzaua.zzi(zzatyVar);
        if (iZzi < 0) {
            OggIO$$ExternalSyntheticBUOutline0.m(zzba$$ExternalSyntheticOutline0.m(iZzi, "readHeaderList size=", new StringBuilder(String.valueOf(iZzi).length() + 20)));
            return null;
        }
        List arrayList = iZzi == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i = 0; i < iZzi; i++) {
            arrayList.add(new zzasw(zzaua.zzm(zzatyVar).intern(), zzaua.zzm(zzatyVar).intern()));
        }
        return new zzatx(strZzm, strZzm2, jZzk, jZzk2, jZzk3, jZzk4, arrayList);
    }

    private zzatx(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
