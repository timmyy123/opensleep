package com.google.android.gms.internal.measurement;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzadb implements zzago {
    private final zzada zza;

    private zzadb(zzada zzadaVar) {
        this.zza = zzadaVar;
        zzadaVar.zza = this;
    }

    public static zzadb zza(zzada zzadaVar) {
        Object obj = zzadaVar.zza;
        return obj != null ? (zzadb) obj : new zzadb(zzadaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzA(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaeq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            zzadaVar.zzr(i3);
            while (i2 < list.size()) {
                zzadaVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        if (!z) {
            while (i2 < zzaeqVar.size()) {
                this.zza.zzg(i, zzaeqVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaeqVar.size(); i6++) {
            zzaeqVar.zzc(i6);
            i5 += 8;
        }
        zzadaVar2.zzr(i5);
        while (i2 < zzaeqVar.size()) {
            zzadaVar2.zzu(zzaeqVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzB(int i, List list, boolean z) {
        if (list instanceof zzadm) {
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
        zzada zzadaVar = this.zza;
        zzadaVar.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        zzadaVar.zzr(i3);
        while (i2 < list.size()) {
            zzadaVar.zzs(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzC(int i, List list, boolean z) {
        if (list instanceof zzadc) {
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
        zzada zzadaVar = this.zza;
        zzadaVar.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        zzadaVar.zzr(i3);
        while (i2 < list.size()) {
            zzadaVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzD(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzadv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzF += zzada.zzF(((Integer) list.get(i3)).intValue());
            }
            zzadaVar.zzr(iZzF);
            while (i2 < list.size()) {
                zzadaVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzadv zzadvVar = (zzadv) list;
        if (!z) {
            while (i2 < zzadvVar.size()) {
                this.zza.zzc(i, zzadvVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzadvVar.size(); i4++) {
            iZzF2 += zzada.zzF(zzadvVar.zzf(i4));
        }
        zzadaVar2.zzr(iZzF2);
        while (i2 < zzadvVar.size()) {
            zzadaVar2.zzq(zzadvVar.zzf(i2));
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
    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzE(int i, List list, boolean z) {
        if (list instanceof zzaci) {
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
        zzada zzadaVar = this.zza;
        zzadaVar.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        zzadaVar.zzr(i3);
        while (i2 < list.size()) {
            zzadaVar.zzp(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzF(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzaen)) {
            while (i2 < list.size()) {
                this.zza.zzi(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzaen zzaenVar = (zzaen) list;
        while (i2 < list.size()) {
            Object objZzc = zzaenVar.zzc();
            boolean z = objZzc instanceof String;
            zzada zzadaVar = this.zza;
            if (z) {
                zzadaVar.zzi(i, (String) objZzc);
            } else {
                zzadaVar.zzj(i, (zzacr) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzG(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzj(i, (zzacr) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzH(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzadv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzada.zzE(((Integer) list.get(i3)).intValue());
            }
            zzadaVar.zzr(iZzE);
            while (i2 < list.size()) {
                zzadaVar.zzr(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzadv zzadvVar = (zzadv) list;
        if (!z) {
            while (i2 < zzadvVar.size()) {
                this.zza.zzd(i, zzadvVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzadvVar.size(); i4++) {
            iZzE2 += zzada.zzE(zzadvVar.zzf(i4));
        }
        zzadaVar2.zzr(iZzE2);
        while (i2 < zzadvVar.size()) {
            zzadaVar2.zzr(zzadvVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzI(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzadv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzadaVar.zzr(i3);
            while (i2 < list.size()) {
                zzadaVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzadv zzadvVar = (zzadv) list;
        if (!z) {
            while (i2 < zzadvVar.size()) {
                this.zza.zze(i, zzadvVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzadvVar.size(); i6++) {
            zzadvVar.zzf(i6);
            i5 += 4;
        }
        zzadaVar2.zzr(i5);
        while (i2 < zzadvVar.size()) {
            zzadaVar2.zzs(zzadvVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzJ(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaeq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            zzadaVar.zzr(i3);
            while (i2 < list.size()) {
                zzadaVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        if (!z) {
            while (i2 < zzaeqVar.size()) {
                this.zza.zzg(i, zzaeqVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaeqVar.size(); i6++) {
            zzaeqVar.zzc(i6);
            i5 += 8;
        }
        zzadaVar2.zzr(i5);
        while (i2 < zzaeqVar.size()) {
            zzadaVar2.zzu(zzaeqVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzK(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzadv)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzada zzadaVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzadaVar.zzd(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzada zzadaVar2 = this.zza;
            zzadaVar2.zzb(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzE += zzada.zzE((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzadaVar2.zzr(iZzE);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzadaVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzadv zzadvVar = (zzadv) list;
        if (!z) {
            while (i2 < zzadvVar.size()) {
                zzada zzadaVar3 = this.zza;
                int iZzf = zzadvVar.zzf(i2);
                zzadaVar3.zzd(i, (iZzf >> 31) ^ (iZzf + iZzf));
                i2++;
            }
            return;
        }
        zzada zzadaVar4 = this.zza;
        zzadaVar4.zzb(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzadvVar.size(); i4++) {
            int iZzf2 = zzadvVar.zzf(i4);
            iZzE2 += zzada.zzE((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzadaVar4.zzr(iZzE2);
        while (i2 < zzadvVar.size()) {
            int iZzf3 = zzadvVar.zzf(i2);
            zzadaVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzL(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaeq)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzada zzadaVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzadaVar.zzf(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzada zzadaVar2 = this.zza;
            zzadaVar2.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzF += zzada.zzF((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzadaVar2.zzr(iZzF);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzadaVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        if (!z) {
            while (i2 < zzaeqVar.size()) {
                zzada zzadaVar3 = this.zza;
                long jZzc = zzaeqVar.zzc(i2);
                zzadaVar3.zzf(i, (jZzc >> 63) ^ (jZzc + jZzc));
                i2++;
            }
            return;
        }
        zzada zzadaVar4 = this.zza;
        zzadaVar4.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzaeqVar.size(); i4++) {
            long jZzc2 = zzaeqVar.zzc(i4);
            iZzF2 += zzada.zzF((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzadaVar4.zzr(iZzF2);
        while (i2 < zzaeqVar.size()) {
            long jZzc3 = zzaeqVar.zzc(i2);
            zzadaVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzM(int i, zzaeu zzaeuVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            zzadaVar.zzr(zzaev.zzc(zzaeuVar, entry.getKey(), entry.getValue()));
            zzaev.zzb(zzadaVar, zzaeuVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzb(int i, int i2) {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzc(int i, long j) {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzd(int i, long j) {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zze(int i, float f) {
        this.zza.zze(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzf(int i, double d) {
        this.zza.zzg(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzg(int i, int i2) {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzh(int i, long j) {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzi(int i, int i2) {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzj(int i, long j) {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzk(int i, int i2) {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzl(int i, boolean z) {
        this.zza.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzm(int i, String str) {
        this.zza.zzi(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzn(int i, zzacr zzacrVar) {
        this.zza.zzj(i, zzacrVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzo(int i, int i2) {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzp(int i, int i2) {
        zzada zzadaVar = this.zza;
        zzadaVar.zzd(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzq(int i, long j) {
        zzada zzadaVar = this.zza;
        zzadaVar.zzf(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzr(int i, Object obj, zzafp zzafpVar) {
        zzada zzadaVar = this.zza;
        zzacb zzacbVar = (zzacb) obj;
        zzadaVar.zzb(i, 2);
        zzadaVar.zzr(zzacbVar.zzcf(zzafpVar));
        zzafpVar.zzf(zzacbVar, this);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzs(int i, Object obj, zzafp zzafpVar) {
        zzada zzadaVar = this.zza;
        zzadaVar.zzb(i, 3);
        zzafpVar.zzf((zzacb) obj, this);
        zzadaVar.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    @Deprecated
    public final void zzt(int i) {
        this.zza.zzb(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    @Deprecated
    public final void zzu(int i) {
        this.zza.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzw(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzadv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzF += zzada.zzF(((Integer) list.get(i3)).intValue());
            }
            zzadaVar.zzr(iZzF);
            while (i2 < list.size()) {
                zzadaVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzadv zzadvVar = (zzadv) list;
        if (!z) {
            while (i2 < zzadvVar.size()) {
                this.zza.zzc(i, zzadvVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzadvVar.size(); i4++) {
            iZzF2 += zzada.zzF(zzadvVar.zzf(i4));
        }
        zzadaVar2.zzr(iZzF2);
        while (i2 < zzadvVar.size()) {
            zzadaVar2.zzq(zzadvVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzx(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzadv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzadaVar.zzr(i3);
            while (i2 < list.size()) {
                zzadaVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzadv zzadvVar = (zzadv) list;
        if (!z) {
            while (i2 < zzadvVar.size()) {
                this.zza.zze(i, zzadvVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzadvVar.size(); i6++) {
            zzadvVar.zzf(i6);
            i5 += 4;
        }
        zzadaVar2.zzr(i5);
        while (i2 < zzadvVar.size()) {
            zzadaVar2.zzs(zzadvVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzy(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaeq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzF += zzada.zzF(((Long) list.get(i3)).longValue());
            }
            zzadaVar.zzr(iZzF);
            while (i2 < list.size()) {
                zzadaVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        if (!z) {
            while (i2 < zzaeqVar.size()) {
                this.zza.zzf(i, zzaeqVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzaeqVar.size(); i4++) {
            iZzF2 += zzada.zzF(zzaeqVar.zzc(i4));
        }
        zzadaVar2.zzr(iZzF2);
        while (i2 < zzaeqVar.size()) {
            zzadaVar2.zzt(zzaeqVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzago
    public final void zzz(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzaeq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzada zzadaVar = this.zza;
            zzadaVar.zzb(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzF += zzada.zzF(((Long) list.get(i3)).longValue());
            }
            zzadaVar.zzr(iZzF);
            while (i2 < list.size()) {
                zzadaVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        if (!z) {
            while (i2 < zzaeqVar.size()) {
                this.zza.zzf(i, zzaeqVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzada zzadaVar2 = this.zza;
        zzadaVar2.zzb(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzaeqVar.size(); i4++) {
            iZzF2 += zzada.zzF(zzaeqVar.zzc(i4));
        }
        zzadaVar2.zzr(iZzF2);
        while (i2 < zzaeqVar.size()) {
            zzadaVar2.zzt(zzaeqVar.zzc(i2));
            i2++;
        }
    }
}
