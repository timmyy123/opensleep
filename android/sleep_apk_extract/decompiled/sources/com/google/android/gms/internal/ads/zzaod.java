package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class zzaod {
    private static final Pattern zzc = Pattern.compile("\\{([^}]*)\\}");
    private static final Pattern zzd;
    private static final Pattern zze;
    private static final Pattern zzf;
    public final int zza;
    public final PointF zzb;

    static {
        String str = zzfl.zza;
        Locale locale = Locale.US;
        zzd = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        zze = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        zzf = Pattern.compile("\\\\an(\\d+)");
    }

    private zzaod(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091 A[Catch: RuntimeException -> 0x000a, TryCatch #1 {RuntimeException -> 0x000a, blocks: (B:23:0x0085, B:25:0x0091, B:27:0x0097, B:28:0x009c), top: B:37:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzaod zza(String str) {
        Matcher matcher;
        int iZzd;
        Matcher matcher2;
        Matcher matcher3;
        boolean zFind;
        boolean zFind2;
        PointF pointF;
        String strGroup;
        String strGroup2;
        Matcher matcher4 = zzc.matcher(str);
        PointF pointF2 = null;
        int i = -1;
        while (matcher4.find()) {
            String strGroup3 = matcher4.group(1);
            strGroup3.getClass();
            try {
                matcher2 = zzd.matcher(strGroup3);
                matcher3 = zze.matcher(strGroup3);
                zFind = matcher2.find();
                zFind2 = matcher3.find();
            } catch (RuntimeException unused) {
            }
            if (zFind) {
                if (zFind2) {
                    StringBuilder sb = new StringBuilder(strGroup3.length() + 82);
                    sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb.append(strGroup3);
                    sb.append("'");
                    zzeg.zzb("SsaStyle.Overrides", sb.toString());
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            } else if (zFind2) {
                strGroup = matcher3.group(1);
                strGroup2 = matcher3.group(2);
            } else {
                pointF = null;
                if (pointF != null) {
                    pointF2 = pointF;
                }
                try {
                    matcher = zzf.matcher(strGroup3);
                } catch (RuntimeException unused2) {
                }
                if (matcher.find()) {
                    iZzd = -1;
                } else {
                    String strGroup4 = matcher.group(1);
                    if (strGroup4 == null) {
                        throw null;
                    }
                    iZzd = zzaoe.zzd(strGroup4);
                }
                if (iZzd == -1) {
                    i = iZzd;
                }
            }
            if (strGroup == null) {
                throw null;
            }
            float f = Float.parseFloat(strGroup.trim());
            if (strGroup2 == null) {
                throw null;
            }
            pointF = new PointF(f, Float.parseFloat(strGroup2.trim()));
            if (pointF != null) {
            }
            matcher = zzf.matcher(strGroup3);
            if (matcher.find()) {
            }
            if (iZzd == -1) {
            }
        }
        return new zzaod(i, pointF2);
    }

    public static String zzb(String str) {
        return zzc.matcher(str).replaceAll("");
    }
}
