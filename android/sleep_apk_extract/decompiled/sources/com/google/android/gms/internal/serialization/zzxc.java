package com.google.android.gms.internal.serialization;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzxc implements zzach {
    private final zzxb zza;

    private zzxc(zzxb zzxbVar) {
        zzzt.zza(zzxbVar, "output");
        this.zza = zzxbVar;
        zzxbVar.zze = this;
    }

    public static zzxc zza(zzxb zzxbVar) {
        zzxc zzxcVar = zzxbVar.zze;
        return zzxcVar != null ? zzxcVar : new zzxc(zzxbVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzA(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaae)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzx(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaae zzaaeVar = (zzaae) list;
        if (!z) {
            while (i2 < zzaaeVar.size()) {
                this.zza.zzh(i, zzaaeVar.zzc(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaaeVar.size(); i6++) {
            zzaaeVar.zzc(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzaaeVar.size()) {
            this.zza.zzx(zzaaeVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzB(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzyw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzR(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).getClass();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzv(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzyw zzywVar = (zzyw) list;
        if (!z) {
            while (i2 < zzywVar.size()) {
                this.zza.zzR(i, Float.floatToRawIntBits(zzywVar.zzf(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzywVar.size(); i6++) {
            zzywVar.zzf(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzywVar.size()) {
            this.zza.zzv(Float.floatToRawIntBits(zzywVar.zzf(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzC(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzyj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).getClass();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzx(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzyj zzyjVar = (zzyj) list;
        if (!z) {
            while (i2 < zzyjVar.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzyjVar.zzf(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzyjVar.size(); i6++) {
            zzyjVar.zzf(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzyjVar.size()) {
            this.zza.zzx(Double.doubleToRawLongBits(zzyjVar.zzf(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzD(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzzh)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzP(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzxb.zzE(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzzh zzzhVar = (zzzh) list;
        if (!z) {
            while (i2 < zzzhVar.size()) {
                this.zza.zzP(i, zzzhVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzzhVar.size(); i4++) {
            iZzE2 += zzxb.zzE(zzzhVar.zzf(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzzhVar.size()) {
            this.zza.zzt(zzzhVar.zzf(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzE(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzwi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzi(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).getClass();
                i3++;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzs(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzwi zzwiVar = (zzwi) list;
        if (!z) {
            while (i2 < zzwiVar.size()) {
                this.zza.zzi(i, zzwiVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzwiVar.size(); i6++) {
            zzwiVar.zzf(i6);
            i5++;
        }
        this.zza.zzu(i5);
        while (i2 < zzwiVar.size()) {
            this.zza.zzs(zzwiVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzF(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzaab)) {
            while (i2 < list.size()) {
                this.zza.zzj(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzaab zzaabVar = (zzaab) list;
        while (i2 < list.size()) {
            Object objZzc = zzaabVar.zzc();
            boolean z = objZzc instanceof String;
            zzxb zzxbVar = this.zza;
            if (z) {
                zzxbVar.zzj(i, (String) objZzc);
            } else {
                zzxbVar.zzk(i, (zzwr) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzG(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzk(i, (zzwr) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzH(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzzh)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzQ(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzxb.zzD(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                this.zza.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzzh zzzhVar = (zzzh) list;
        if (!z) {
            while (i2 < zzzhVar.size()) {
                this.zza.zzQ(i, zzzhVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzzhVar.size(); i4++) {
            iZzD2 += zzxb.zzD(zzzhVar.zzf(i4));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzzhVar.size()) {
            this.zza.zzu(zzzhVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzI(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzzh)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzR(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzzh zzzhVar = (zzzh) list;
        if (!z) {
            while (i2 < zzzhVar.size()) {
                this.zza.zzR(i, zzzhVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzzhVar.size(); i6++) {
            zzzhVar.zzf(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzzhVar.size()) {
            this.zza.zzv(zzzhVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzJ(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaae)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzx(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaae zzaaeVar = (zzaae) list;
        if (!z) {
            while (i2 < zzaaeVar.size()) {
                this.zza.zzh(i, zzaaeVar.zzc(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaaeVar.size(); i6++) {
            zzaaeVar.zzc(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzaaeVar.size()) {
            this.zza.zzx(zzaaeVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzK(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzzh)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzxb zzxbVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzxbVar.zzQ(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzD += zzxb.zzD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                zzxb zzxbVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzxbVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzzh zzzhVar = (zzzh) list;
        if (!z) {
            while (i2 < zzzhVar.size()) {
                zzxb zzxbVar3 = this.zza;
                int iZzf = zzzhVar.zzf(i2);
                zzxbVar3.zzQ(i, (iZzf >> 31) ^ (iZzf + iZzf));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzzhVar.size(); i4++) {
            int iZzf2 = zzzhVar.zzf(i4);
            iZzD2 += zzxb.zzD((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzzhVar.size()) {
            zzxb zzxbVar4 = this.zza;
            int iZzf3 = zzzhVar.zzf(i2);
            zzxbVar4.zzu((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzL(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaae)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzxb zzxbVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzxbVar.zzS(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzE += zzxb.zzE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                zzxb zzxbVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzxbVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzaae zzaaeVar = (zzaae) list;
        if (!z) {
            while (i2 < zzaaeVar.size()) {
                zzxb zzxbVar3 = this.zza;
                long jZzc = zzaaeVar.zzc(i2);
                zzxbVar3.zzS(i, (jZzc >> 63) ^ (jZzc + jZzc));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzaaeVar.size(); i4++) {
            long jZzc2 = zzaaeVar.zzc(i4);
            iZzE2 += zzxb.zzE((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzaaeVar.size()) {
            zzxb zzxbVar4 = this.zza;
            long jZzc3 = zzaaeVar.zzc(i2);
            zzxbVar4.zzw((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzM(int i, zzaai zzaaiVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.zza.zzO(i, 2);
            this.zza.zzu(zzaaj.zzc(zzaaiVar, entry.getKey(), entry.getValue()));
            zzaaj.zzb(this.zza, zzaaiVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzb(int i, int i2) {
        this.zza.zzR(i, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzc(int i, long j) {
        this.zza.zzS(i, j);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzd(int i, long j) {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zze(int i, float f) {
        this.zza.zzR(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzf(int i, double d) {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzg(int i, int i2) {
        this.zza.zzP(i, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzh(int i, long j) {
        this.zza.zzS(i, j);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzi(int i, int i2) {
        this.zza.zzP(i, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzj(int i, long j) {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzk(int i, int i2) {
        this.zza.zzR(i, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzl(int i, boolean z) {
        this.zza.zzi(i, z);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzm(int i, String str) {
        this.zza.zzj(i, str);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzn(int i, zzwr zzwrVar) {
        this.zza.zzk(i, zzwrVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzo(int i, int i2) {
        this.zza.zzQ(i, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzp(int i, int i2) {
        zzxb zzxbVar = this.zza;
        zzxbVar.zzQ(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzq(int i, long j) {
        zzxb zzxbVar = this.zza;
        zzxbVar.zzS(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzr(int i, Object obj, zzabe zzabeVar) {
        this.zza.zzo(i, (zzaaq) obj, zzabeVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzs(int i, Object obj, zzabe zzabeVar) {
        zzxb zzxbVar = this.zza;
        zzxbVar.zzO(i, 3);
        zzabeVar.zzf((zzaaq) obj, zzxbVar.zze);
        zzxbVar.zzO(i, 4);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    @Deprecated
    public final void zzt(int i) {
        this.zza.zzO(i, 3);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    @Deprecated
    public final void zzu(int i) {
        this.zza.zzO(i, 4);
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzv(int i, Object obj) {
        boolean z = obj instanceof zzwr;
        zzxb zzxbVar = this.zza;
        if (z) {
            zzxbVar.zzq(i, (zzwr) obj);
        } else {
            zzxbVar.zzp(i, (zzaaq) obj);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzw(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzzh)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzP(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzxb.zzE(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzzh zzzhVar = (zzzh) list;
        if (!z) {
            while (i2 < zzzhVar.size()) {
                this.zza.zzP(i, zzzhVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzzhVar.size(); i4++) {
            iZzE2 += zzxb.zzE(zzzhVar.zzf(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzzhVar.size()) {
            this.zza.zzt(zzzhVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzx(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzzh)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzR(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzzh zzzhVar = (zzzh) list;
        if (!z) {
            while (i2 < zzzhVar.size()) {
                this.zza.zzR(i, zzzhVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzzhVar.size(); i6++) {
            zzzhVar.zzf(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzzhVar.size()) {
            this.zza.zzv(zzzhVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzy(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaae)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzS(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzxb.zzE(((Long) list.get(i3)).longValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaae zzaaeVar = (zzaae) list;
        if (!z) {
            while (i2 < zzaaeVar.size()) {
                this.zza.zzS(i, zzaaeVar.zzc(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzaaeVar.size(); i4++) {
            iZzE2 += zzxb.zzE(zzaaeVar.zzc(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzaaeVar.size()) {
            this.zza.zzw(zzaaeVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzach
    public final void zzz(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaae)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzS(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzO(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzxb.zzE(((Long) list.get(i3)).longValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaae zzaaeVar = (zzaae) list;
        if (!z) {
            while (i2 < zzaaeVar.size()) {
                this.zza.zzS(i, zzaaeVar.zzc(i2));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzaaeVar.size(); i4++) {
            iZzE2 += zzxb.zzE(zzaaeVar.zzc(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzaaeVar.size()) {
            this.zza.zzw(zzaaeVar.zzc(i2));
            i2++;
        }
    }
}
