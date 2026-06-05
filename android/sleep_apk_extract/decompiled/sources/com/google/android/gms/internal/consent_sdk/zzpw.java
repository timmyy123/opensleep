package com.google.android.gms.internal.consent_sdk;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzpw implements zztb {
    private final zzpv zza;

    private zzpw(zzpv zzpvVar) {
        byte[] bArr = zzqs.zzb;
        this.zza = zzpvVar;
        zzpvVar.zze = this;
    }

    public static zzpw zza(zzpv zzpvVar) {
        Object obj = zzpvVar.zze;
        return obj != null ? (zzpw) obj : new zzpw(zzpvVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzA(int i, List list, boolean z) {
        if (list instanceof zzre) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zzpvVar.zzw(i3);
        while (i2 < list.size()) {
            zzpvVar.zzm(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzB(int i, int i2) {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzv(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzC(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzqn)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzpv zzpvVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzpvVar.zzv(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzpv zzpvVar2 = this.zza;
            zzpvVar2.zzu(i, 2);
            int iZzC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzC += zzpv.zzC((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzpvVar2.zzw(iZzC);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzpvVar2.zzw((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z) {
            while (i2 < zzqnVar.size()) {
                zzpv zzpvVar3 = this.zza;
                int iZze = zzqnVar.zze(i2);
                zzpvVar3.zzv(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        zzpv zzpvVar4 = this.zza;
        zzpvVar4.zzu(i, 2);
        int iZzC2 = 0;
        for (int i4 = 0; i4 < zzqnVar.size(); i4++) {
            int iZze2 = zzqnVar.zze(i4);
            iZzC2 += zzpv.zzC((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzpvVar4.zzw(iZzC2);
        while (i2 < zzqnVar.size()) {
            int iZze3 = zzqnVar.zze(i2);
            zzpvVar4.zzw((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzD(int i, long j) {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzx(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzE(int i, List list, boolean z) {
        if (list instanceof zzre) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzpv zzpvVar = this.zza;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzpvVar.zzx(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i, 2);
        int iZzD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzD += zzpv.zzD((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zzpvVar2.zzw(iZzD);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzpvVar2.zzy((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzF(int i, String str) {
        this.zza.zzs(i, str);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzG(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzrb)) {
            while (i2 < list.size()) {
                this.zza.zzs(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzrb zzrbVar = (zzrb) list;
        while (i2 < list.size()) {
            Object objZza = zzrbVar.zza();
            boolean z = objZza instanceof String;
            zzpv zzpvVar = this.zza;
            if (z) {
                zzpvVar.zzs(i, (String) objZza);
            } else {
                zzpvVar.zzh(i, (zzpm) objZza);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzH(int i, int i2) {
        this.zza.zzv(i, i2);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzI(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzqn)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i, 2);
            int iZzC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzC += zzpv.zzC(((Integer) list.get(i3)).intValue());
            }
            zzpvVar.zzw(iZzC);
            while (i2 < list.size()) {
                zzpvVar.zzw(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z) {
            while (i2 < zzqnVar.size()) {
                this.zza.zzv(i, zzqnVar.zze(i2));
                i2++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i, 2);
        int iZzC2 = 0;
        for (int i4 = 0; i4 < zzqnVar.size(); i4++) {
            iZzC2 += zzpv.zzC(zzqnVar.zze(i4));
        }
        zzpvVar2.zzw(iZzC2);
        while (i2 < zzqnVar.size()) {
            zzpvVar2.zzw(zzqnVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzJ(int i, long j) {
        this.zza.zzx(i, j);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzK(int i, List list, boolean z) {
        if (list instanceof zzre) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzx(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int iZzD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzD += zzpv.zzD(((Long) list.get(i3)).longValue());
        }
        zzpvVar.zzw(iZzD);
        while (i2 < list.size()) {
            zzpvVar.zzy(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzb(int i, boolean z) {
        this.zza.zzK(i, z);
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
    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzc(int i, List list, boolean z) {
        if (list instanceof zzpd) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzK(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        zzpvVar.zzw(i3);
        while (i2 < list.size()) {
            zzpvVar.zzJ(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzd(int i, zzpm zzpmVar) {
        this.zza.zzh(i, zzpmVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zze(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzh(i, (zzpm) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzf(int i, double d) {
        this.zza.zzl(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzg(int i, List list, boolean z) {
        if (list instanceof zzpx) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        zzpvVar.zzw(i3);
        while (i2 < list.size()) {
            zzpvVar.zzm(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzh(int i, int i2) {
        this.zza.zzn(i, i2);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzi(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzqn)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzn(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzpv.zzD(((Integer) list.get(i3)).intValue());
            }
            zzpvVar.zzw(iZzD);
            while (i2 < list.size()) {
                zzpvVar.zzo(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z) {
            while (i2 < zzqnVar.size()) {
                this.zza.zzn(i, zzqnVar.zze(i2));
                i2++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzqnVar.size(); i4++) {
            iZzD2 += zzpv.zzD(zzqnVar.zze(i4));
        }
        zzpvVar2.zzw(iZzD2);
        while (i2 < zzqnVar.size()) {
            zzpvVar2.zzo(zzqnVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzj(int i, int i2) {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzk(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzqn)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzpvVar.zzw(i3);
            while (i2 < list.size()) {
                zzpvVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z) {
            while (i2 < zzqnVar.size()) {
                this.zza.zzj(i, zzqnVar.zze(i2));
                i2++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzqnVar.size(); i6++) {
            zzqnVar.zze(i6);
            i5 += 4;
        }
        zzpvVar2.zzw(i5);
        while (i2 < zzqnVar.size()) {
            zzpvVar2.zzk(zzqnVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzl(int i, long j) {
        this.zza.zzl(i, j);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzm(int i, List list, boolean z) {
        if (list instanceof zzre) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zzpvVar.zzw(i3);
        while (i2 < list.size()) {
            zzpvVar.zzm(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzn(int i, float f) {
        this.zza.zzj(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzo(int i, List list, boolean z) {
        if (list instanceof zzqh) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        zzpvVar.zzw(i3);
        while (i2 < list.size()) {
            zzpvVar.zzk(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzp(int i, Object obj, zzsa zzsaVar) {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 3);
        zzsaVar.zzf((zzpa) obj, this);
        zzpvVar.zzu(i, 4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzq(int i, int i2) {
        this.zza.zzn(i, i2);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzr(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzqn)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzn(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzpv.zzD(((Integer) list.get(i3)).intValue());
            }
            zzpvVar.zzw(iZzD);
            while (i2 < list.size()) {
                zzpvVar.zzo(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z) {
            while (i2 < zzqnVar.size()) {
                this.zza.zzn(i, zzqnVar.zze(i2));
                i2++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzqnVar.size(); i4++) {
            iZzD2 += zzpv.zzD(zzqnVar.zze(i4));
        }
        zzpvVar2.zzw(iZzD2);
        while (i2 < zzqnVar.size()) {
            zzpvVar2.zzo(zzqnVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzs(int i, long j) {
        this.zza.zzx(i, j);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzt(int i, List list, boolean z) {
        if (list instanceof zzre) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzx(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i, 2);
        int iZzD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzD += zzpv.zzD(((Long) list.get(i3)).longValue());
        }
        zzpvVar.zzw(iZzD);
        while (i2 < list.size()) {
            zzpvVar.zzy(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzu(int i, zzri zzriVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i, 2);
            zzpvVar.zzw(zzrj.zzb(zzriVar, entry.getKey(), entry.getValue()));
            Object key = entry.getKey();
            Object value = entry.getValue();
            zzqf.zzi(zzpvVar, zzriVar.zza, 1, key);
            zzqf.zzi(zzpvVar, zzriVar.zzb, 2, value);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzv(int i, Object obj, zzsa zzsaVar) {
        zzpv zzpvVar = this.zza;
        zzpa zzpaVar = (zzpa) obj;
        zzpvVar.zzu(i, 2);
        zzpvVar.zzw(zzpaVar.zzj(zzsaVar));
        zzsaVar.zzf(zzpaVar, this);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzx(int i, int i2) {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzy(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzqn)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzpvVar.zzw(i3);
            while (i2 < list.size()) {
                zzpvVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z) {
            while (i2 < zzqnVar.size()) {
                this.zza.zzj(i, zzqnVar.zze(i2));
                i2++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzqnVar.size(); i6++) {
            zzqnVar.zze(i6);
            i5 += 4;
        }
        zzpvVar2.zzw(i5);
        while (i2 < zzqnVar.size()) {
            zzpvVar2.zzk(zzqnVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzz(int i, long j) {
        this.zza.zzl(i, j);
    }
}
