package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzapv implements zzapt {
    private static final double[] zzc = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zza;
    private zzahk zzb;
    private final zzarl zzd;
    private final String zze;
    private final zzet zzf;
    private final zzaqk zzg;
    private final boolean[] zzh = new boolean[4];
    private final zzapu zzi = new zzapu(128);
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;

    public zzapv(zzarl zzarlVar, String str) {
        zzet zzetVar;
        this.zzd = zzarlVar;
        this.zze = str;
        if (zzarlVar != null) {
            this.zzg = new zzaqk(178, 128);
            zzetVar = new zzet();
        } else {
            zzetVar = null;
            this.zzg = null;
        }
        this.zzf = zzetVar;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        zzgp.zzj(this.zzh);
        this.zzi.zza();
        zzaqk zzaqkVar = this.zzg;
        if (zzaqkVar != null) {
            zzaqkVar.zza();
        }
        this.zzj = 0L;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zza = zzarhVar.zzc();
        this.zzb = zzagbVar.zzu(zzarhVar.zzb(), 2);
        zzarl zzarlVar = this.zzd;
        if (zzarlVar != null) {
            zzarlVar.zza(zzagbVar, zzarhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzn = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0131  */
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
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(zzet zzetVar) {
        int i;
        long j;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        float f;
        int i5;
        long j2;
        int i6;
        int i7;
        this.zzb.getClass();
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        byte[] bArrZzi = zzetVar.zzi();
        this.zzj += (long) zzetVar.zzd();
        this.zzb.zzc(zzetVar, zzetVar.zzd());
        while (true) {
            int iZzi = zzgp.zzi(bArrZzi, iZzg, iZze, this.zzh);
            if (iZzi == iZze) {
                break;
            }
            int i8 = iZzi + 3;
            int i9 = zzetVar.zzi()[i8] & 255;
            int i10 = iZzi - iZzg;
            if (this.zzl) {
                i = iZze;
            } else {
                if (i10 > 0) {
                    this.zzi.zzc(bArrZzi, iZzg, iZzi);
                }
                int i11 = i10 < 0 ? -i10 : 0;
                zzapu zzapuVar = this.zzi;
                if (zzapuVar.zzb(i9, i11)) {
                    String str = this.zza;
                    str.getClass();
                    String str2 = this.zze;
                    byte[] bArrCopyOf = Arrays.copyOf(zzapuVar.zzc, zzapuVar.zza);
                    int i12 = bArrCopyOf[4] & 255;
                    byte b = bArrCopyOf[5];
                    i = iZze;
                    int i13 = bArrCopyOf[6] & 255;
                    int i14 = (i12 << 4) | ((b & 255) >> 4);
                    int i15 = (bArrCopyOf[7] & 240) >> 4;
                    int i16 = ((b & 15) << 8) | i13;
                    if (i15 == 2) {
                        i3 = i16 * 4;
                        i4 = i14 * 3;
                    } else if (i15 == 3) {
                        i3 = i16 * 16;
                        i4 = i14 * 9;
                    } else if (i15 != 4) {
                        f = 1.0f;
                        zzt zztVar = new zzt();
                        zztVar.zza(str);
                        zztVar.zzn(str2);
                        zztVar.zzo("video/mpeg2");
                        zztVar.zzv(i14);
                        zztVar.zzw(i16);
                        zztVar.zzB(f);
                        zztVar.zzr(Collections.singletonList(bArrCopyOf));
                        zzv zzvVarZzO = zztVar.zzO();
                        i5 = (bArrCopyOf[7] & 15) - 1;
                        j2 = 0;
                        if (i5 >= 0 && i5 < 8) {
                            double d = zzc[i5];
                            byte b2 = bArrCopyOf[zzapuVar.zzb + 9];
                            i6 = (b2 & 96) >> 5;
                            i7 = b2 & 31;
                            if (i6 != i7) {
                                d *= (((double) i6) + 1.0d) / ((double) (i7 + 1));
                            }
                            j2 = (long) (1000000.0d / d);
                        }
                        Pair pairCreate = Pair.create(zzvVarZzO, Long.valueOf(j2));
                        this.zzb.zzA((zzv) pairCreate.first);
                        this.zzm = ((Long) pairCreate.second).longValue();
                        this.zzl = true;
                    } else {
                        i3 = i16 * 121;
                        i4 = i14 * 100;
                    }
                    f = i3 / i4;
                    zzt zztVar2 = new zzt();
                    zztVar2.zza(str);
                    zztVar2.zzn(str2);
                    zztVar2.zzo("video/mpeg2");
                    zztVar2.zzv(i14);
                    zztVar2.zzw(i16);
                    zztVar2.zzB(f);
                    zztVar2.zzr(Collections.singletonList(bArrCopyOf));
                    zzv zzvVarZzO2 = zztVar2.zzO();
                    i5 = (bArrCopyOf[7] & 15) - 1;
                    j2 = 0;
                    if (i5 >= 0) {
                        double d2 = zzc[i5];
                        byte b22 = bArrCopyOf[zzapuVar.zzb + 9];
                        i6 = (b22 & 96) >> 5;
                        i7 = b22 & 31;
                        if (i6 != i7) {
                        }
                        j2 = (long) (1000000.0d / d2);
                    }
                    Pair pairCreate2 = Pair.create(zzvVarZzO2, Long.valueOf(j2));
                    this.zzb.zzA((zzv) pairCreate2.first);
                    this.zzm = ((Long) pairCreate2.second).longValue();
                    this.zzl = true;
                }
            }
            zzaqk zzaqkVar = this.zzg;
            if (zzaqkVar != null) {
                if (i10 > 0) {
                    zzaqkVar.zzd(bArrZzi, iZzg, iZzi);
                    i2 = 0;
                } else {
                    i2 = -i10;
                }
                if (zzaqkVar.zze(i2)) {
                    int iZza = zzgp.zza(zzaqkVar.zza, zzaqkVar.zzb);
                    zzet zzetVar2 = this.zzf;
                    String str3 = zzfl.zza;
                    zzetVar2.zzb(zzaqkVar.zza, iZza);
                    this.zzd.zzb(this.zzp, zzetVar2);
                }
                if (i9 == 178) {
                    if (zzetVar.zzi()[iZzi + 2] == 1) {
                        zzaqkVar.zzc(178);
                    }
                    i9 = 178;
                }
            }
            if (i9 == 0 || i9 == 179) {
                int i17 = i - iZzi;
                if (this.zzr && this.zzl) {
                    j = -9223372036854775807L;
                    long j3 = this.zzp;
                    if (j3 != -9223372036854775807L) {
                        j = -9223372036854775807L;
                        this.zzb.zze(j3, this.zzq ? 1 : 0, ((int) (this.zzj - this.zzo)) - i17, i17, null);
                    }
                } else {
                    j = -9223372036854775807L;
                }
                if (!this.zzk || this.zzr) {
                    this.zzo = this.zzj - ((long) i17);
                    long j4 = this.zzn;
                    if (j4 == j) {
                        long j5 = this.zzp;
                        j4 = j5 != j ? j5 + this.zzm : j;
                    }
                    this.zzp = j4;
                    z = false;
                    this.zzq = false;
                    this.zzn = j;
                    z2 = true;
                    this.zzk = true;
                } else {
                    z2 = true;
                    z = false;
                }
                this.zzr = i9 == 0 ? z2 : z;
            } else if (i9 == 184) {
                this.zzq = true;
            }
            iZzg = i8;
            iZze = i;
        }
        if (!this.zzl) {
            this.zzi.zzc(bArrZzi, iZzg, iZze);
        }
        zzaqk zzaqkVar2 = this.zzg;
        if (zzaqkVar2 != null) {
            zzaqkVar2.zzd(bArrZzi, iZzg, iZze);
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
    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
        zzahk zzahkVar = this.zzb;
        zzahkVar.getClass();
        if (z) {
            boolean z2 = this.zzq;
            long j = this.zzj - this.zzo;
            zzahkVar.zze(this.zzp, z2 ? 1 : 0, (int) j, 0, null);
        }
    }
}
