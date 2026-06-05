package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzidk implements zzihi {
    private final zzidj zza;

    private zzidk(zzidj zzidjVar) {
        zzidjVar.getClass();
        this.zza = zzidjVar;
        zzidjVar.zza = this;
    }

    public static zzidk zza(zzidj zzidjVar) {
        Object obj = zzidjVar.zza;
        return obj != null ? (zzidk) obj : new zzidk(zzidjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzA(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzifd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            zzidjVar.zzr(i3);
            while (i2 < list.size()) {
                zzidjVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z) {
            while (i2 < zzifdVar.size()) {
                this.zza.zzg(i, zzifdVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzifdVar.size(); i6++) {
            zzifdVar.zzc(i6);
            i5 += 8;
        }
        zzidjVar2.zzr(i5);
        while (i2 < zzifdVar.size()) {
            zzidjVar2.zzu(zzifdVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzB(int i, List list, boolean z) {
        if (list instanceof zzidv) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zze(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzidj zzidjVar = this.zza;
        zzidjVar.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        zzidjVar.zzr(i3);
        while (i2 < list.size()) {
            zzidjVar.zzs(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzC(int i, List list, boolean z) {
        if (list instanceof zzidl) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzg(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzidj zzidjVar = this.zza;
        zzidjVar.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        zzidjVar.zzr(i3);
        while (i2 < list.size()) {
            zzidjVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzD(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzief)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzidj.zzG(((Integer) list.get(i3)).intValue());
            }
            zzidjVar.zzr(iZzG);
            while (i2 < list.size()) {
                zzidjVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z) {
            while (i2 < zziefVar.size()) {
                this.zza.zzc(i, zziefVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zziefVar.size(); i4++) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i4));
        }
        zzidjVar2.zzr(iZzG2);
        while (i2 < zziefVar.size()) {
            zzidjVar2.zzq(zziefVar.zzf(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzE(int i, List list, boolean z) {
        if (list instanceof zzicq) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        zzidj zzidjVar = this.zza;
        zzidjVar.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        zzidjVar.zzr(i3);
        while (i2 < list.size()) {
            zzidjVar.zzp(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzF(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzifa)) {
            while (i2 < list.size()) {
                this.zza.zzi(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzifa zzifaVar = (zzifa) list;
        while (i2 < list.size()) {
            Object objZzc = zzifaVar.zzc();
            boolean z = objZzc instanceof String;
            zzidj zzidjVar = this.zza;
            if (z) {
                zzidjVar.zzi(i, (String) objZzc);
            } else {
                zzidjVar.zzj(i, (zzida) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzG(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzj(i, (zzida) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzH(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzief)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzF += zzidj.zzF(((Integer) list.get(i3)).intValue());
            }
            zzidjVar.zzr(iZzF);
            while (i2 < list.size()) {
                zzidjVar.zzr(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z) {
            while (i2 < zziefVar.size()) {
                this.zza.zzd(i, zziefVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zziefVar.size(); i4++) {
            iZzF2 += zzidj.zzF(zziefVar.zzf(i4));
        }
        zzidjVar2.zzr(iZzF2);
        while (i2 < zziefVar.size()) {
            zzidjVar2.zzr(zziefVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzI(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzief)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzidjVar.zzr(i3);
            while (i2 < list.size()) {
                zzidjVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z) {
            while (i2 < zziefVar.size()) {
                this.zza.zze(i, zziefVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zziefVar.size(); i6++) {
            zziefVar.zzf(i6);
            i5 += 4;
        }
        zzidjVar2.zzr(i5);
        while (i2 < zziefVar.size()) {
            zzidjVar2.zzs(zziefVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzJ(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzifd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            zzidjVar.zzr(i3);
            while (i2 < list.size()) {
                zzidjVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z) {
            while (i2 < zzifdVar.size()) {
                this.zza.zzg(i, zzifdVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzifdVar.size(); i6++) {
            zzifdVar.zzc(i6);
            i5 += 8;
        }
        zzidjVar2.zzr(i5);
        while (i2 < zzifdVar.size()) {
            zzidjVar2.zzu(zzifdVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzK(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzief)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzidj zzidjVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzidjVar.zzd(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzidj zzidjVar2 = this.zza;
            zzidjVar2.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzF += zzidj.zzF((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzidjVar2.zzr(iZzF);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzidjVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z) {
            while (i2 < zziefVar.size()) {
                zzidj zzidjVar3 = this.zza;
                int iZzf = zziefVar.zzf(i2);
                zzidjVar3.zzd(i, (iZzf >> 31) ^ (iZzf + iZzf));
                i2++;
            }
            return;
        }
        zzidj zzidjVar4 = this.zza;
        zzidjVar4.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zziefVar.size(); i4++) {
            int iZzf2 = zziefVar.zzf(i4);
            iZzF2 += zzidj.zzF((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzidjVar4.zzr(iZzF2);
        while (i2 < zziefVar.size()) {
            int iZzf3 = zziefVar.zzf(i2);
            zzidjVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzL(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzifd)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzidj zzidjVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzidjVar.zzf(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzidj zzidjVar2 = this.zza;
            zzidjVar2.zzb(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzG += zzidj.zzG((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzidjVar2.zzr(iZzG);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzidjVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z) {
            while (i2 < zzifdVar.size()) {
                zzidj zzidjVar3 = this.zza;
                long jZzc = zzifdVar.zzc(i2);
                zzidjVar3.zzf(i, (jZzc >> 63) ^ (jZzc + jZzc));
                i2++;
            }
            return;
        }
        zzidj zzidjVar4 = this.zza;
        zzidjVar4.zzb(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzifdVar.size(); i4++) {
            long jZzc2 = zzifdVar.zzc(i4);
            iZzG2 += zzidj.zzG((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzidjVar4.zzr(iZzG2);
        while (i2 < zzifdVar.size()) {
            long jZzc3 = zzifdVar.zzc(i2);
            zzidjVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzM(int i, zzifh zzifhVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            zzidjVar.zzr(zzifi.zzc(zzifhVar, entry.getKey(), entry.getValue()));
            zzifi.zzb(zzidjVar, zzifhVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzb(int i, int i2) {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzc(int i, long j) {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzd(int i, long j) {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zze(int i, float f) {
        this.zza.zze(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzf(int i, double d) {
        this.zza.zzg(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzg(int i, int i2) {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzh(int i, long j) {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzi(int i, int i2) {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzj(int i, long j) {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzk(int i, int i2) {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzl(int i, boolean z) {
        this.zza.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzm(int i, String str) {
        this.zza.zzi(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzn(int i, zzida zzidaVar) {
        this.zza.zzj(i, zzidaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzo(int i, int i2) {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzp(int i, int i2) {
        zzidj zzidjVar = this.zza;
        zzidjVar.zzd(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzq(int i, long j) {
        zzidj zzidjVar = this.zza;
        zzidjVar.zzf(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzr(int i, Object obj, zzigh zzighVar) {
        zzidj zzidjVar = this.zza;
        zzicj zzicjVar = (zzicj) obj;
        zzidjVar.zzb(i, 2);
        zzidjVar.zzr(zzicjVar.zzaT(zzighVar));
        zzighVar.zzf(zzicjVar, this);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzs(int i, Object obj, zzigh zzighVar) {
        zzidj zzidjVar = this.zza;
        zzidjVar.zzb(i, 3);
        zzighVar.zzf((zzicj) obj, this);
        zzidjVar.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    @Deprecated
    public final void zzt(int i) {
        this.zza.zzb(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    @Deprecated
    public final void zzu(int i) {
        this.zza.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzw(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzief)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzidj.zzG(((Integer) list.get(i3)).intValue());
            }
            zzidjVar.zzr(iZzG);
            while (i2 < list.size()) {
                zzidjVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z) {
            while (i2 < zziefVar.size()) {
                this.zza.zzc(i, zziefVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zziefVar.size(); i4++) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i4));
        }
        zzidjVar2.zzr(iZzG2);
        while (i2 < zziefVar.size()) {
            zzidjVar2.zzq(zziefVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzx(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzief)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzidjVar.zzr(i3);
            while (i2 < list.size()) {
                zzidjVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z) {
            while (i2 < zziefVar.size()) {
                this.zza.zze(i, zziefVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zziefVar.size(); i6++) {
            zziefVar.zzf(i6);
            i5 += 4;
        }
        zzidjVar2.zzr(i5);
        while (i2 < zziefVar.size()) {
            zzidjVar2.zzs(zziefVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzy(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzifd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzidj.zzG(((Long) list.get(i3)).longValue());
            }
            zzidjVar.zzr(iZzG);
            while (i2 < list.size()) {
                zzidjVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z) {
            while (i2 < zzifdVar.size()) {
                this.zza.zzf(i, zzifdVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzifdVar.size(); i4++) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i4));
        }
        zzidjVar2.zzr(iZzG2);
        while (i2 < zzifdVar.size()) {
            zzidjVar2.zzt(zzifdVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzz(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzifd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzidj.zzG(((Long) list.get(i3)).longValue());
            }
            zzidjVar.zzr(iZzG);
            while (i2 < list.size()) {
                zzidjVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z) {
            while (i2 < zzifdVar.size()) {
                this.zza.zzf(i, zzifdVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzifdVar.size(); i4++) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i4));
        }
        zzidjVar2.zzr(iZzG2);
        while (i2 < zzifdVar.size()) {
            zzidjVar2.zzt(zzifdVar.zzc(i2));
            i2++;
        }
    }
}
