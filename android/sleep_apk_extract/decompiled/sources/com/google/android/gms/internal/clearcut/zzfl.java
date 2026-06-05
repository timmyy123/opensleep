package com.google.android.gms.internal.clearcut;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzqe' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public class zzfl {
    public static final zzfl zzqc;
    public static final zzfl zzqd;
    public static final zzfl zzqe;
    public static final zzfl zzqf;
    public static final zzfl zzqg;
    public static final zzfl zzqh;
    public static final zzfl zzqi;
    public static final zzfl zzqj;
    public static final zzfl zzqk;
    public static final zzfl zzql;
    public static final zzfl zzqm;
    public static final zzfl zzqn;
    public static final zzfl zzqo;
    public static final zzfl zzqp;
    public static final zzfl zzqq;
    public static final zzfl zzqr;
    public static final zzfl zzqs;
    public static final zzfl zzqt;
    private static final /* synthetic */ zzfl[] zzqw;
    private final zzfq zzqu;
    private final int zzqv;

    static {
        zzfl zzflVar = new zzfl("DOUBLE", 0, zzfq.DOUBLE, 1);
        zzqc = zzflVar;
        zzfl zzflVar2 = new zzfl("FLOAT", 1, zzfq.FLOAT, 5);
        zzqd = zzflVar2;
        zzfq zzfqVar = zzfq.LONG;
        final int i = 2;
        zzfl zzflVar3 = new zzfl("INT64", 2, zzfqVar, 0);
        zzqe = zzflVar3;
        final int i2 = 3;
        zzfl zzflVar4 = new zzfl("UINT64", 3, zzfqVar, 0);
        zzqf = zzflVar4;
        zzfq zzfqVar2 = zzfq.INT;
        zzfl zzflVar5 = new zzfl("INT32", 4, zzfqVar2, 0);
        zzqg = zzflVar5;
        zzfl zzflVar6 = new zzfl("FIXED64", 5, zzfqVar, 1);
        zzqh = zzflVar6;
        zzfl zzflVar7 = new zzfl("FIXED32", 6, zzfqVar2, 5);
        zzqi = zzflVar7;
        zzfl zzflVar8 = new zzfl("BOOL", 7, zzfq.BOOLEAN, 0);
        zzqj = zzflVar8;
        final zzfq zzfqVar3 = zzfq.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzfl zzflVar9 = new zzfl(str, i3, zzfqVar3, i) { // from class: com.google.android.gms.internal.clearcut.zzfm
            {
                int i4 = 2;
                int i5 = 8;
            }
        };
        zzqk = zzflVar9;
        final zzfq zzfqVar4 = zzfq.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzfl zzflVar10 = new zzfl(str2, i4, zzfqVar4, i2) { // from class: com.google.android.gms.internal.clearcut.zzfn
            {
                int i5 = 3;
                int i6 = 9;
            }
        };
        zzql = zzflVar10;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        final int i6 = 2;
        zzfl zzflVar11 = new zzfl(str3, i5, zzfqVar4, i6) { // from class: com.google.android.gms.internal.clearcut.zzfo
            {
                int i7 = 2;
                int i8 = 10;
            }
        };
        zzqm = zzflVar11;
        final zzfq zzfqVar5 = zzfq.BYTE_STRING;
        final String str4 = "BYTES";
        final int i7 = 11;
        zzfl zzflVar12 = new zzfl(str4, i7, zzfqVar5, i6) { // from class: com.google.android.gms.internal.clearcut.zzfp
            {
                int i8 = 2;
                int i9 = 11;
            }
        };
        zzqn = zzflVar12;
        zzfl zzflVar13 = new zzfl("UINT32", 12, zzfqVar2, 0);
        zzqo = zzflVar13;
        zzfl zzflVar14 = new zzfl("ENUM", 13, zzfq.ENUM, 0);
        zzqp = zzflVar14;
        zzfl zzflVar15 = new zzfl("SFIXED32", 14, zzfqVar2, 5);
        zzqq = zzflVar15;
        zzfl zzflVar16 = new zzfl("SFIXED64", 15, zzfqVar, 1);
        zzqr = zzflVar16;
        zzfl zzflVar17 = new zzfl("SINT32", 16, zzfqVar2, 0);
        zzqs = zzflVar17;
        zzfl zzflVar18 = new zzfl("SINT64", 17, zzfqVar, 0);
        zzqt = zzflVar18;
        zzqw = new zzfl[]{zzflVar, zzflVar2, zzflVar3, zzflVar4, zzflVar5, zzflVar6, zzflVar7, zzflVar8, zzflVar9, zzflVar10, zzflVar11, zzflVar12, zzflVar13, zzflVar14, zzflVar15, zzflVar16, zzflVar17, zzflVar18};
    }

    private zzfl(String str, int i, zzfq zzfqVar, int i2) {
        this.zzqu = zzfqVar;
        this.zzqv = i2;
    }

    public static zzfl[] values() {
        return (zzfl[]) zzqw.clone();
    }
}
