package com.google.android.gms.internal.serialization;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class zzzw {
    public static final zzzw zza;
    public static final zzzw zzb;
    public static final zzzw zzc;
    public static final zzzw zzd;
    public static final zzzw zze;
    public static final zzzw zzf;
    public static final zzzw zzg;
    public static final zzzw zzh;
    public static final zzzw zzi;
    public static final zzzw zzj;
    private static final /* synthetic */ zzzw[] zzl;
    private final Class zzk;

    static {
        zzzw zzzwVar = new zzzw("VOID", 0, Void.class, Void.class, null);
        zza = zzzwVar;
        Class cls = Integer.TYPE;
        zzzw zzzwVar2 = new zzzw("INT", 1, cls, Integer.class, 0);
        zzb = zzzwVar2;
        zzzw zzzwVar3 = new zzzw("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzzwVar3;
        zzzw zzzwVar4 = new zzzw("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzzwVar4;
        zzzw zzzwVar5 = new zzzw("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzzwVar5;
        zzzw zzzwVar6 = new zzzw("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzzwVar6;
        zzzw zzzwVar7 = new zzzw("STRING", 6, String.class, String.class, "");
        zzg = zzzwVar7;
        zzzw zzzwVar8 = new zzzw("BYTE_STRING", 7, zzwr.class, zzwr.class, zzwr.zzb);
        zzh = zzzwVar8;
        zzzw zzzwVar9 = new zzzw("ENUM", 8, cls, Integer.class, null);
        zzi = zzzwVar9;
        zzzw zzzwVar10 = new zzzw("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzzwVar10;
        zzl = new zzzw[]{zzzwVar, zzzwVar2, zzzwVar3, zzzwVar4, zzzwVar5, zzzwVar6, zzzwVar7, zzzwVar8, zzzwVar9, zzzwVar10};
    }

    private zzzw(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzk = cls2;
    }

    public static zzzw[] values() {
        return (zzzw[]) zzl.clone();
    }

    public final Class zza() {
        return this.zzk;
    }
}
