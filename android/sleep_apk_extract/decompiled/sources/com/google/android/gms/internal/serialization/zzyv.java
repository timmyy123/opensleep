package com.google.android.gms.internal.serialization;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zza' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class zzyv {
    public static final zzyv zzA;
    public static final zzyv zzB;
    public static final zzyv zzC;
    public static final zzyv zzD;
    public static final zzyv zzE;
    public static final zzyv zzF;
    public static final zzyv zzG;
    public static final zzyv zzH;
    public static final zzyv zzI;
    public static final zzyv zzJ;
    public static final zzyv zzK;
    public static final zzyv zzL;
    public static final zzyv zzM;
    public static final zzyv zzN;
    public static final zzyv zzO;
    public static final zzyv zzP;
    public static final zzyv zzQ;
    public static final zzyv zzR;
    public static final zzyv zzS;
    public static final zzyv zzT;
    public static final zzyv zzU;
    public static final zzyv zzV;
    public static final zzyv zzW;
    public static final zzyv zzX;
    public static final zzyv zzY;
    public static final zzyv zza;
    private static final zzyv[] zzaa;
    private static final /* synthetic */ zzyv[] zzab;
    public static final zzyv zzb;
    public static final zzyv zzc;
    public static final zzyv zzd;
    public static final zzyv zze;
    public static final zzyv zzf;
    public static final zzyv zzg;
    public static final zzyv zzh;
    public static final zzyv zzi;
    public static final zzyv zzj;
    public static final zzyv zzk;
    public static final zzyv zzl;
    public static final zzyv zzm;
    public static final zzyv zzn;
    public static final zzyv zzo;
    public static final zzyv zzp;
    public static final zzyv zzq;
    public static final zzyv zzr;
    public static final zzyv zzs;
    public static final zzyv zzt;
    public static final zzyv zzu;
    public static final zzyv zzv;
    public static final zzyv zzw;
    public static final zzyv zzx;
    public static final zzyv zzy;
    public static final zzyv zzz;
    private final int zzZ;

    static {
        zzzw zzzwVar = zzzw.zze;
        zzyv zzyvVar = new zzyv("DOUBLE", 0, 0, 1, zzzwVar);
        zza = zzyvVar;
        zzzw zzzwVar2 = zzzw.zzd;
        zzyv zzyvVar2 = new zzyv("FLOAT", 1, 1, 1, zzzwVar2);
        zzb = zzyvVar2;
        zzzw zzzwVar3 = zzzw.zzc;
        zzyv zzyvVar3 = new zzyv("INT64", 2, 2, 1, zzzwVar3);
        zzc = zzyvVar3;
        zzyv zzyvVar4 = new zzyv("UINT64", 3, 3, 1, zzzwVar3);
        zzd = zzyvVar4;
        zzzw zzzwVar4 = zzzw.zzb;
        zzyv zzyvVar5 = new zzyv("INT32", 4, 4, 1, zzzwVar4);
        zze = zzyvVar5;
        zzyv zzyvVar6 = new zzyv("FIXED64", 5, 5, 1, zzzwVar3);
        zzf = zzyvVar6;
        zzyv zzyvVar7 = new zzyv("FIXED32", 6, 6, 1, zzzwVar4);
        zzg = zzyvVar7;
        zzzw zzzwVar5 = zzzw.zzf;
        zzyv zzyvVar8 = new zzyv("BOOL", 7, 7, 1, zzzwVar5);
        zzh = zzyvVar8;
        zzzw zzzwVar6 = zzzw.zzg;
        zzyv zzyvVar9 = new zzyv("STRING", 8, 8, 1, zzzwVar6);
        zzi = zzyvVar9;
        zzzw zzzwVar7 = zzzw.zzj;
        zzyv zzyvVar10 = new zzyv("MESSAGE", 9, 9, 1, zzzwVar7);
        zzj = zzyvVar10;
        zzzw zzzwVar8 = zzzw.zzh;
        zzyv zzyvVar11 = new zzyv("BYTES", 10, 10, 1, zzzwVar8);
        zzk = zzyvVar11;
        zzyv zzyvVar12 = new zzyv("UINT32", 11, 11, 1, zzzwVar4);
        zzl = zzyvVar12;
        zzzw zzzwVar9 = zzzw.zzi;
        zzyv zzyvVar13 = new zzyv("ENUM", 12, 12, 1, zzzwVar9);
        zzm = zzyvVar13;
        zzyv zzyvVar14 = new zzyv("SFIXED32", 13, 13, 1, zzzwVar4);
        zzn = zzyvVar14;
        zzyv zzyvVar15 = new zzyv("SFIXED64", 14, 14, 1, zzzwVar3);
        zzo = zzyvVar15;
        zzyv zzyvVar16 = new zzyv("SINT32", 15, 15, 1, zzzwVar4);
        zzp = zzyvVar16;
        zzyv zzyvVar17 = new zzyv("SINT64", 16, 16, 1, zzzwVar3);
        zzq = zzyvVar17;
        zzyv zzyvVar18 = new zzyv("GROUP", 17, 17, 1, zzzwVar7);
        zzr = zzyvVar18;
        zzyv zzyvVar19 = new zzyv("DOUBLE_LIST", 18, 18, 2, zzzwVar);
        zzs = zzyvVar19;
        zzyv zzyvVar20 = new zzyv("FLOAT_LIST", 19, 19, 2, zzzwVar2);
        zzt = zzyvVar20;
        zzyv zzyvVar21 = new zzyv("INT64_LIST", 20, 20, 2, zzzwVar3);
        zzu = zzyvVar21;
        zzyv zzyvVar22 = new zzyv("UINT64_LIST", 21, 21, 2, zzzwVar3);
        zzv = zzyvVar22;
        zzyv zzyvVar23 = new zzyv("INT32_LIST", 22, 22, 2, zzzwVar4);
        zzw = zzyvVar23;
        zzyv zzyvVar24 = new zzyv("FIXED64_LIST", 23, 23, 2, zzzwVar3);
        zzx = zzyvVar24;
        zzyv zzyvVar25 = new zzyv("FIXED32_LIST", 24, 24, 2, zzzwVar4);
        zzy = zzyvVar25;
        zzyv zzyvVar26 = new zzyv("BOOL_LIST", 25, 25, 2, zzzwVar5);
        zzz = zzyvVar26;
        zzyv zzyvVar27 = new zzyv("STRING_LIST", 26, 26, 2, zzzwVar6);
        zzA = zzyvVar27;
        zzyv zzyvVar28 = new zzyv("MESSAGE_LIST", 27, 27, 2, zzzwVar7);
        zzB = zzyvVar28;
        zzyv zzyvVar29 = new zzyv("BYTES_LIST", 28, 28, 2, zzzwVar8);
        zzC = zzyvVar29;
        zzyv zzyvVar30 = new zzyv("UINT32_LIST", 29, 29, 2, zzzwVar4);
        zzD = zzyvVar30;
        zzyv zzyvVar31 = new zzyv("ENUM_LIST", 30, 30, 2, zzzwVar9);
        zzE = zzyvVar31;
        zzyv zzyvVar32 = new zzyv("SFIXED32_LIST", 31, 31, 2, zzzwVar4);
        zzF = zzyvVar32;
        zzyv zzyvVar33 = new zzyv("SFIXED64_LIST", 32, 32, 2, zzzwVar3);
        zzG = zzyvVar33;
        zzyv zzyvVar34 = new zzyv("SINT32_LIST", 33, 33, 2, zzzwVar4);
        zzH = zzyvVar34;
        zzyv zzyvVar35 = new zzyv("SINT64_LIST", 34, 34, 2, zzzwVar3);
        zzI = zzyvVar35;
        zzyv zzyvVar36 = new zzyv("DOUBLE_LIST_PACKED", 35, 35, 3, zzzwVar);
        zzJ = zzyvVar36;
        zzyv zzyvVar37 = new zzyv("FLOAT_LIST_PACKED", 36, 36, 3, zzzwVar2);
        zzK = zzyvVar37;
        zzyv zzyvVar38 = new zzyv("INT64_LIST_PACKED", 37, 37, 3, zzzwVar3);
        zzL = zzyvVar38;
        zzyv zzyvVar39 = new zzyv("UINT64_LIST_PACKED", 38, 38, 3, zzzwVar3);
        zzM = zzyvVar39;
        zzyv zzyvVar40 = new zzyv("INT32_LIST_PACKED", 39, 39, 3, zzzwVar4);
        zzN = zzyvVar40;
        zzyv zzyvVar41 = new zzyv("FIXED64_LIST_PACKED", 40, 40, 3, zzzwVar3);
        zzO = zzyvVar41;
        zzyv zzyvVar42 = new zzyv("FIXED32_LIST_PACKED", 41, 41, 3, zzzwVar4);
        zzP = zzyvVar42;
        zzyv zzyvVar43 = new zzyv("BOOL_LIST_PACKED", 42, 42, 3, zzzwVar5);
        zzQ = zzyvVar43;
        zzyv zzyvVar44 = new zzyv("UINT32_LIST_PACKED", 43, 43, 3, zzzwVar4);
        zzR = zzyvVar44;
        zzyv zzyvVar45 = new zzyv("ENUM_LIST_PACKED", 44, 44, 3, zzzwVar9);
        zzS = zzyvVar45;
        zzyv zzyvVar46 = new zzyv("SFIXED32_LIST_PACKED", 45, 45, 3, zzzwVar4);
        zzT = zzyvVar46;
        zzyv zzyvVar47 = new zzyv("SFIXED64_LIST_PACKED", 46, 46, 3, zzzwVar3);
        zzU = zzyvVar47;
        zzyv zzyvVar48 = new zzyv("SINT32_LIST_PACKED", 47, 47, 3, zzzwVar4);
        zzV = zzyvVar48;
        zzyv zzyvVar49 = new zzyv("SINT64_LIST_PACKED", 48, 48, 3, zzzwVar3);
        zzW = zzyvVar49;
        zzyv zzyvVar50 = new zzyv("GROUP_LIST", 49, 49, 2, zzzwVar7);
        zzX = zzyvVar50;
        zzyv zzyvVar51 = new zzyv("MAP", 50, 50, 4, zzzw.zza);
        zzY = zzyvVar51;
        zzab = new zzyv[]{zzyvVar, zzyvVar2, zzyvVar3, zzyvVar4, zzyvVar5, zzyvVar6, zzyvVar7, zzyvVar8, zzyvVar9, zzyvVar10, zzyvVar11, zzyvVar12, zzyvVar13, zzyvVar14, zzyvVar15, zzyvVar16, zzyvVar17, zzyvVar18, zzyvVar19, zzyvVar20, zzyvVar21, zzyvVar22, zzyvVar23, zzyvVar24, zzyvVar25, zzyvVar26, zzyvVar27, zzyvVar28, zzyvVar29, zzyvVar30, zzyvVar31, zzyvVar32, zzyvVar33, zzyvVar34, zzyvVar35, zzyvVar36, zzyvVar37, zzyvVar38, zzyvVar39, zzyvVar40, zzyvVar41, zzyvVar42, zzyvVar43, zzyvVar44, zzyvVar45, zzyvVar46, zzyvVar47, zzyvVar48, zzyvVar49, zzyvVar50, zzyvVar51};
        zzyv[] zzyvVarArrValues = values();
        zzaa = new zzyv[zzyvVarArrValues.length];
        for (zzyv zzyvVar52 : zzyvVarArrValues) {
            zzaa[zzyvVar52.zzZ] = zzyvVar52;
        }
    }

    private zzyv(String str, int i, int i2, int i3, zzzw zzzwVar) {
        this.zzZ = i2;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            zzzwVar.zza();
        }
        if (i3 == 1) {
            zzzw zzzwVar2 = zzzw.zza;
            zzzwVar.ordinal();
        }
    }

    public static zzyv[] values() {
        return (zzyv[]) zzab.clone();
    }

    public final int zza() {
        return this.zzZ;
    }
}
