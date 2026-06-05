package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaay extends zzabe implements zznb {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzgyg zzc = zzgyg.zzc(zzaah.zza);
    public final Context zza;
    private final Object zzd;
    private zzaam zze;
    private Thread zzf;
    private zzacm zzg;
    private zzd zzh;
    private Boolean zzi;
    private final zzzt zzj;

    public zzaay(Context context) {
        zzzt zzztVar = new zzzt();
        zzaam zzaamVar = zzaam.zzJ;
        this.zzd = new Object();
        byte[] bArr = null;
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzztVar;
        if (zzaamVar != null) {
            this.zze = zzaamVar;
        } else {
            zzaal zzaalVar = new zzaal(zzaamVar, bArr);
            zzaalVar.zzx((zzbl) zzaamVar);
            this.zze = new zzaam(zzaalVar, bArr);
        }
        this.zzh = zzd.zza;
        if (this.zze.zzU && context == null) {
            zzeg.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    private static Pair zzA(zzaaz[] zzaazVarArr, int i) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzaaz zzaazVar = zzaazVarArr[i2];
            if (zzaazVar != null && zzaazVar.zza.zzc == i) {
                return Pair.create(zzaazVar, Integer.valueOf(i2));
            }
        }
        return null;
    }

    private static final Pair zzB(int i, zzabd zzabdVar, int[][][] iArr, zzaap zzaapVar, Comparator comparator) {
        RandomAccess randomAccessZzj;
        zzabd zzabdVar2 = zzabdVar;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzabdVar2.zza(i2)) {
                zzzn zzznVarZzb = zzabdVar2.zzb(i2);
                for (int i3 = 0; i3 < zzznVarZzb.zzb; i3++) {
                    zzbg zzbgVarZza = zzznVarZzb.zza(i3);
                    List listZza = zzaapVar.zza(i2, zzbgVarZza, iArr[i2][i3]);
                    int i4 = zzbgVarZza.zza;
                    boolean[] zArr = new boolean[i4];
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i5 + 1;
                        zzaaq zzaaqVar = (zzaaq) listZza.get(i5);
                        int iZza = zzaaqVar.zza();
                        if (!zArr[i5] && iZza != 0) {
                            if (iZza == 1) {
                                randomAccessZzj = zzgwm.zzj(zzaaqVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzaaqVar);
                                for (int i7 = i6; i7 < i4; i7++) {
                                    zzaaq zzaaqVar2 = (zzaaq) listZza.get(i7);
                                    if (zzaaqVar2.zza() == 2 && zzaaqVar.zzc(zzaaqVar2)) {
                                        arrayList2.add(zzaaqVar2);
                                        zArr[i7] = true;
                                    }
                                }
                                randomAccessZzj = arrayList2;
                            }
                            arrayList.add(randomAccessZzj);
                        }
                        i5 = i6;
                    }
                }
            }
            i2++;
            zzabdVar2 = zzabdVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((zzaaq) list.get(i8)).zzc;
        }
        zzaaq zzaaqVar3 = (zzaaq) list.get(0);
        return Pair.create(new zzaaz(zzaaqVar3.zzb, iArr2, 0), Integer.valueOf(zzaaqVar3.zza));
    }

    public static String zzi(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static int zzj(zzv zzvVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzvVar.zzd)) {
            return 4;
        }
        String strZzi = zzi(str);
        String strZzi2 = zzi(zzvVar.zzd);
        if (strZzi2 == null || strZzi == null) {
            return (z && strZzi2 == null) ? 1 : 0;
        }
        if (strZzi2.startsWith(strZzi) || strZzi.startsWith(strZzi2)) {
            return 3;
        }
        String str2 = zzfl.zza;
        return strZzi2.split("-", 2)[0].equals(strZzi.split("-", 2)[0]) ? 2 : 0;
    }

    public static /* synthetic */ int zzm(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ int zzn(zzv zzvVar, zzgwm zzgwmVar) {
        int i = 0;
        while (i < zzgwmVar.size()) {
            int i2 = 0;
            while (true) {
                List list = zzvVar.zzc;
                if (i2 < list.size()) {
                    if (((zzx) list.get(i2)).zzb.equals(zzgwmVar.get(i))) {
                        return i;
                    }
                    i2++;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static final zzaaz zzp(int i, zzzn zzznVar, int[][] iArr, zzaam zzaamVar) {
        int i2 = zzaamVar.zzw.zzb;
        int i3 = 0;
        zzbg zzbgVar = null;
        zzaak zzaakVar = null;
        for (int i4 = 0; i4 < zzznVar.zzb; i4++) {
            zzbg zzbgVarZza = zzznVar.zza(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < zzbgVarZza.zza; i5++) {
                if (zznc.zzac(iArr2[i5], zzaamVar.zzV)) {
                    zzaak zzaakVar2 = new zzaak(zzbgVarZza.zza(i5), iArr2[i5]);
                    if (zzaakVar == null || zzaakVar2.compareTo(zzaakVar) > 0) {
                        zzbgVar = zzbgVarZza;
                        i3 = i5;
                        zzaakVar = zzaakVar2;
                    }
                }
            }
        }
        if (zzbgVar == null) {
            return null;
        }
        return new zzaaz(zzbgVar, new int[]{i3}, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public final void zzk() {
        boolean z;
        zzacm zzacmVar;
        synchronized (this.zzd) {
            try {
                z = false;
                if (this.zze.zzU && Build.VERSION.SDK_INT >= 32 && (zzacmVar = this.zzg) != null && zzacmVar.zzb()) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            zzt();
        }
    }

    private static void zzw(zzabd zzabdVar, zzbl zzblVar, zzaaz[] zzaazVarArr) {
        HashMap map = new HashMap();
        for (int i = 0; i < 2; i++) {
            zzx(zzabdVar.zzb(i), zzblVar, map);
        }
        zzx(zzabdVar.zze(), zzblVar, map);
        for (int i2 = 0; i2 < 2; i2++) {
            if (map.get(Integer.valueOf(zzabdVar.zza(i2))) != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            }
        }
    }

    private static void zzx(zzzn zzznVar, zzbl zzblVar, Map map) {
        for (int i = 0; i < zzznVar.zzb; i++) {
            if (zzblVar.zzH.get(zzznVar.zza(i)) != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            }
        }
    }

    private static void zzy(zzabd zzabdVar, zzaam zzaamVar, zzaaz[] zzaazVarArr) {
        for (int i = 0; i < 2; i++) {
            zzzn zzznVarZzb = zzabdVar.zzb(i);
            if (zzaamVar.zzb(i, zzznVarZzb)) {
                zzaamVar.zzc(i, zzznVarZzb);
                zzaazVarArr[i] = null;
            }
        }
    }

    private static void zzz(zzabd zzabdVar, zzaam zzaamVar, zzaaz[] zzaazVarArr) {
        for (int i = 0; i < 2; i++) {
            int iZza = zzabdVar.zza(i);
            if (zzaamVar.zza(i) || zzaamVar.zzI.contains(Integer.valueOf(iZza))) {
                zzaazVarArr[i] = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zzna zznaVar) {
        synchronized (this.zzd) {
            boolean z = this.zze.zzY;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final void zzb() {
        zzacm zzacmVar;
        synchronized (this.zzd) {
            try {
                Thread thread = this.zzf;
                if (thread != null) {
                    zzgtj.zzj(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzacmVar = this.zzg) != null) {
            zzacmVar.zzg();
            this.zzg = null;
        }
        super.zzb();
    }

    public final zzaam zzc() {
        zzaam zzaamVar;
        synchronized (this.zzd) {
            zzaamVar = this.zze;
        }
        return zzaamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final boolean zzd() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final void zze(zzd zzdVar) {
        if (this.zzh.equals(zzdVar)) {
            return;
        }
        this.zzh = zzdVar;
        zzk();
    }

    public final void zzf(zzaal zzaalVar) {
        boolean zEquals;
        zzaam zzaamVar = new zzaam(zzaalVar, null);
        synchronized (this.zzd) {
            zEquals = this.zze.equals(zzaamVar);
            this.zze = zzaamVar;
        }
        if (zEquals) {
            return;
        }
        if (zzaamVar.zzU && this.zza == null) {
            zzeg.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final zznb zzg() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzabe
    public final Pair zzh(zzabd zzabdVar, int[][][] iArr, final int[] iArr2, zzxk zzxkVar, zzbf zzbfVar) {
        final zzaam zzaamVar;
        final String str;
        zzzt zzztVar;
        int[] iArr3;
        int length;
        zzaba zzabaVarZza;
        int i;
        int i2;
        final String languageTag;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        final boolean z;
        Context context3;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzaamVar = this.zze;
        }
        if (this.zzi == null && (context3 = this.zza) != null) {
            this.zzi = Boolean.valueOf(zzfl.zzP(context3));
        }
        if (zzaamVar.zzU && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzacm(this.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzaai
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzk();
                }
            }, this.zzi);
        }
        zzaaz[] zzaazVarArr = new zzaaz[2];
        zzw(zzabdVar, zzaamVar, zzaazVarArr);
        zzy(zzabdVar, zzaamVar, zzaazVarArr);
        zzz(zzabdVar, zzaamVar, zzaazVarArr);
        Pair pairZzA = zzA(zzaazVarArr, 1);
        int i3 = 0;
        if (pairZzA == null) {
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    z = false;
                    break;
                }
                if (zzabdVar.zza(i4) == 2 && zzabdVar.zzb(i4).zzb > 0) {
                    z = true;
                    break;
                }
                i4++;
            }
            pairZzA = zzB(1, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaad
                @Override // com.google.android.gms.internal.ads.zzaap
                public final /* synthetic */ List zza(int i5, zzbg zzbgVar, int[] iArr4) {
                    final zzaay zzaayVar = this.zza;
                    final zzaam zzaamVar2 = zzaamVar;
                    zzgtk zzgtkVar = new zzgtk() { // from class: com.google.android.gms.internal.ads.zzaag
                        @Override // com.google.android.gms.internal.ads.zzgtk
                        public final /* synthetic */ boolean zza(Object obj) {
                            return zzaayVar.zzl(zzaamVar2, (zzv) obj);
                        }
                    };
                    int i6 = iArr2[i5];
                    int i7 = zzgwm.$r8$clinit;
                    zzgwj zzgwjVar = new zzgwj();
                    for (int i8 = 0; i8 < zzbgVar.zza; i8++) {
                        zzgwjVar.zzf(new zzzx(i5, zzbgVar, i8, zzaamVar2, iArr4[i8], z, zzgtkVar, i6));
                    }
                    return zzgwjVar.zzi();
                }
            }, zzzy.zza);
            if (pairZzA != null) {
                zzaazVarArr[((Integer) pairZzA.second).intValue()] = (zzaaz) pairZzA.first;
            }
        }
        if (pairZzA == null) {
            str = null;
        } else {
            Object obj = pairZzA.first;
            str = ((zzaaz) obj).zza.zza(((zzaaz) obj).zzb[0]).zzd;
        }
        Pair pairZzA2 = zzA(zzaazVarArr, 2);
        Pair pairZzA3 = zzA(zzaazVarArr, 4);
        if (pairZzA2 == null && pairZzA3 == null) {
            int i5 = zzaamVar.zzw.zzb;
            final Point pointZzR = (!zzaamVar.zzk || (context2 = this.zza) == null) ? null : zzfl.zzR(context2);
            Pair pairZzB = zzB(2, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaac
                /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
                @Override // com.google.android.gms.internal.ads.zzaap
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final /* synthetic */ List zza(int i6, zzbg zzbgVar, int[] iArr4) {
                    int i7;
                    int i8;
                    int i9;
                    int i10;
                    int i11;
                    int i12;
                    Point point;
                    zzbg zzbgVar2 = zzbgVar;
                    int i13 = zzaay.$r8$clinit;
                    Point point2 = pointZzR;
                    int i14 = iArr2[i6];
                    zzaam zzaamVar2 = zzaamVar;
                    int i15 = point2 != null ? point2.x : zzaamVar2.zzi;
                    int i16 = point2 != null ? point2.y : zzaamVar2.zzj;
                    boolean z2 = zzaamVar2.zzl;
                    if (i15 == Integer.MAX_VALUE) {
                        i7 = -1;
                        i8 = Integer.MAX_VALUE;
                    } else if (i16 == Integer.MAX_VALUE) {
                        i8 = Integer.MAX_VALUE;
                        i7 = -1;
                    } else {
                        int i17 = Integer.MAX_VALUE;
                        for (int i18 = 0; i18 < zzbgVar2.zza; i18++) {
                            zzv zzvVarZza = zzbgVar2.zza(i18);
                            int i19 = zzvVarZza.zzw;
                            if (i19 > 0 && (i10 = zzvVarZza.zzx) > 0) {
                                if (z2) {
                                    if ((i19 > i10) != (i15 > i16)) {
                                        i12 = i16;
                                        i11 = i15;
                                    }
                                    if (i19 * i11 < i10 * i12) {
                                    }
                                    int i20 = i19 * i10;
                                    if (i19 < ((int) (point.x * 0.98f))) {
                                    }
                                } else {
                                    i11 = i16;
                                    i12 = i15;
                                    if (i19 * i11 < i10 * i12) {
                                        String str2 = zzfl.zza;
                                        point = new Point(i12, ((r10 + i19) - 1) / i19);
                                    } else {
                                        String str3 = zzfl.zza;
                                        point = new Point(((r12 + i10) - 1) / i10, i11);
                                    }
                                    int i202 = i19 * i10;
                                    if (i19 < ((int) (point.x * 0.98f)) && i10 >= ((int) (point.y * 0.98f)) && i202 < i17) {
                                        i17 = i202;
                                    }
                                }
                            }
                        }
                        i7 = -1;
                        i8 = i17;
                    }
                    int i21 = zzgwm.$r8$clinit;
                    zzgwj zzgwjVar = new zzgwj();
                    int i22 = 0;
                    while (i22 < zzbgVar2.zza) {
                        int iZzc = zzbgVar2.zza(i22).zzc();
                        if (i8 != Integer.MAX_VALUE) {
                            i9 = i7;
                            boolean z3 = iZzc != i9 && iZzc <= i8;
                            zzgwjVar.zzf(new zzaax(i6, zzbgVar2, i22, zzaamVar2, iArr4[i22], str, i14, z3));
                            i22++;
                            zzbgVar2 = zzbgVar;
                            i7 = i9;
                        } else {
                            i9 = i7;
                        }
                        zzgwjVar.zzf(new zzaax(i6, zzbgVar2, i22, zzaamVar2, iArr4[i22], str, i14, z3));
                        i22++;
                        zzbgVar2 = zzbgVar;
                        i7 = i9;
                    }
                    return zzgwjVar.zzi();
                }
            }, zzaab.zza);
            Pair pairZzB2 = pairZzB == null ? zzB(4, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaaf
                @Override // com.google.android.gms.internal.ads.zzaap
                public final /* synthetic */ List zza(int i6, zzbg zzbgVar, int[] iArr4) {
                    int i7 = zzaay.$r8$clinit;
                    int i8 = zzgwm.$r8$clinit;
                    zzgwj zzgwjVar = new zzgwj();
                    for (int i9 = 0; i9 < zzbgVar.zza; i9++) {
                        zzgwjVar.zzf(new zzaaj(i6, zzbgVar, i9, zzaamVar, iArr4[i9]));
                    }
                    return zzgwjVar.zzi();
                }
            }, zzzz.zza) : null;
            if (pairZzB2 != null) {
                zzaazVarArr[((Integer) pairZzB2.second).intValue()] = (zzaaz) pairZzB2.first;
            } else if (pairZzB != null) {
                zzaazVarArr[((Integer) pairZzB.second).intValue()] = (zzaaz) pairZzB.first;
            }
        }
        if (zzA(zzaazVarArr, 3) == null) {
            int i6 = zzaamVar.zzw.zzb;
            if (!zzaamVar.zzB || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
                languageTag = null;
            } else {
                String str2 = zzfl.zza;
                languageTag = locale.toLanguageTag();
            }
            Pair pairZzB3 = zzB(3, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaae
                @Override // com.google.android.gms.internal.ads.zzaap
                public final /* synthetic */ List zza(int i7, zzbg zzbgVar, int[] iArr4) {
                    int i8 = zzaay.$r8$clinit;
                    int i9 = zzgwm.$r8$clinit;
                    zzgwj zzgwjVar = new zzgwj();
                    for (int i10 = 0; i10 < zzbgVar.zza; i10++) {
                        zzgwjVar.zzf(new zzaao(i7, zzbgVar, i10, zzaamVar, iArr4[i10], str, languageTag));
                    }
                    return zzgwjVar.zzi();
                }
            }, zzaaa.zza);
            if (pairZzB3 != null) {
                zzaazVarArr[((Integer) pairZzB3.second).intValue()] = (zzaaz) pairZzB3.first;
            }
        }
        int i7 = zzaamVar.zzw.zzb;
        zzgwv zzgwvVar = new zzgwv();
        int i8 = 0;
        while (i8 < 2) {
            zzaaz zzaazVar = zzaazVarArr[i8];
            if (zzaazVar == null || zzaamVar.zza(i8)) {
                i2 = i3;
            } else {
                zzgww zzgwwVar = zzaamVar.zzI;
                zzbg zzbgVar = zzaazVar.zza;
                i2 = i3;
                if (!zzgwwVar.contains(Integer.valueOf(zzbgVar.zzc))) {
                    zzgwvVar.zzf(zzbgVar.zzb);
                    int i9 = i2;
                    while (true) {
                        int[] iArr4 = zzaazVar.zzb;
                        if (i9 < iArr4.length) {
                            String str3 = zzbgVar.zza(iArr4[i9]).zzn;
                            if (str3 != null) {
                                zzgwvVar.zzf(str3);
                            }
                            i9++;
                        }
                    }
                }
            }
            i8++;
            i3 = i2;
        }
        int i10 = i3;
        zzgww zzgwwVarZzh = zzgwvVar.zzh();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = i10; i11 < 2; i11++) {
            if (zzabdVar.zza(i11) == 5) {
                zzzn zzznVarZzb = zzabdVar.zzb(i11);
                for (int i12 = i10; i12 < zzznVarZzb.zzb; i12++) {
                    zzbg zzbgVarZza = zzznVarZzb.zza(i12);
                    arrayList.add(zzbgVarZza);
                    int[] iArr5 = (int[]) iArr[i11][i12].clone();
                    for (int i13 = i10; i13 < iArr5.length; i13++) {
                        String str4 = zzbgVarZza.zza(i13).zzn;
                        if (str4 != null && !zzgwwVarZzh.contains(str4)) {
                            iArr5[i13] = 128;
                        }
                    }
                    arrayList2.add(iArr5);
                }
            }
        }
        int i14 = 128;
        zzbg[] zzbgVarArr = new zzbg[arrayList.size()];
        zzfl.zzc(arrayList, zzbgVarArr);
        zzzn zzznVar = new zzzn(zzbgVarArr);
        int[][] iArr6 = new int[arrayList2.size()][];
        zzfl.zzc(arrayList2, iArr6);
        int i15 = i10;
        while (i15 < 2) {
            if (zzabdVar.zza(i15) == 5) {
                zzaaz zzaazVarZzp = zzp(5, zzznVar, iArr6, zzaamVar);
                zzaazVarArr[i15] = zzaazVarZzp;
                if (zzaazVarZzp == null) {
                    break;
                }
                i = i14;
                Arrays.fill(iArr6[zzznVar.zzb(zzaazVarZzp.zza)], i);
            } else {
                i = i14;
            }
            i15++;
            i14 = i;
        }
        for (int i16 = i10; i16 < 2; i16++) {
            int iZza = zzabdVar.zza(i16);
            if (iZza != 2 && iZza != 1) {
                if (iZza != 3 && iZza != 4 && iZza != 5 && zzaazVarArr[i16] == null) {
                    zzaazVarArr[i16] = zzp(iZza, zzabdVar.zzb(i16), iArr[i16], zzaamVar);
                }
            }
        }
        zzw(zzabdVar, zzaamVar, zzaazVarArr);
        zzy(zzabdVar, zzaamVar, zzaazVarArr);
        zzz(zzabdVar, zzaamVar, zzaazVarArr);
        zzzt zzztVar2 = this.zzj;
        zzabq zzabqVarZzu = zzu();
        zzgwm zzgwmVarZzd = zzzu.zzd(zzaazVarArr);
        zzaba[] zzabaVarArr = new zzaba[2];
        int i17 = i10;
        while (i17 < 2) {
            zzaaz zzaazVar2 = zzaazVarArr[i17];
            if (zzaazVar2 == null || (length = (iArr3 = zzaazVar2.zzb).length) == 0) {
                zzztVar = zzztVar2;
            } else {
                zzbg zzbgVar2 = zzaazVar2.zza;
                if (length == 1) {
                    zzabaVarZza = new zzabb(zzbgVar2, iArr3[i10], 0, 0, null);
                    zzztVar = zzztVar2;
                } else {
                    zzztVar = zzztVar2;
                    zzabaVarZza = zzztVar.zza(zzbgVar2, iArr3, 0, zzabqVarZzu, (zzgwm) zzgwmVarZzd.get(i17));
                }
                zzabaVarArr[i17] = zzabaVarZza;
            }
            i17++;
            zzztVar2 = zzztVar;
        }
        zznd[] zzndVarArr = new zznd[2];
        for (int i18 = i10; i18 < 2; i18++) {
            zzndVarArr[i18] = (zzaamVar.zza(i18) || zzaamVar.zzI.contains(Integer.valueOf(zzabdVar.zza(i18))) || (zzabdVar.zza(i18) != -2 && zzabaVarArr[i18] == null)) ? null : zznd.zza;
        }
        return Pair.create(zzndVarArr, zzabaVarArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ boolean zzl(zzaam zzaamVar, zzv zzvVar) {
        Boolean bool;
        int i;
        zzacm zzacmVar;
        zzacm zzacmVar2;
        if (!zzaamVar.zzU || (((bool = this.zzi) != null && bool.booleanValue()) || (i = zzvVar.zzH) == -1 || i <= 2)) {
            return true;
        }
        String str = zzvVar.zzp;
        if (str != null) {
            switch (str.hashCode()) {
                case -2123537834:
                    if (str.equals("audio/eac3-joc")) {
                        if (Build.VERSION.SDK_INT < 32 || (zzacmVar2 = this.zzg) == null || !zzacmVar2.zzb()) {
                        }
                    }
                    break;
                case 187078296:
                    if (str.equals("audio/ac3")) {
                    }
                    break;
                case 187078297:
                    if (str.equals("audio/ac4")) {
                    }
                    break;
                case 1504578661:
                    if (str.equals("audio/eac3")) {
                    }
                    break;
            }
            return true;
        }
        return Build.VERSION.SDK_INT >= 32 && (zzacmVar = this.zzg) != null && zzacmVar.zzb() && zzacmVar.zzc() && this.zzg.zzd() && this.zzg.zze(this.zzh, zzvVar);
    }
}
