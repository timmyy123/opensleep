package com.google.android.gms.internal.ads;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaof implements zzanl {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzet zze = new zzet();

    public static float zzb(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
        return 0.0f;
    }

    private static long zzc(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j2 = (Long.parseLong(strGroup2) * 60000) + j;
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j3 = (Long.parseLong(strGroup3) * 1000) + j2;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    @Override // com.google.android.gms.internal.ads.zzanl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzet zzetVar;
        String str;
        zzcx zzcxVarZzr;
        zzaof zzaofVar = this;
        zzet zzetVar2 = zzaofVar.zze;
        zzetVar2.zzb(bArr, i + i2);
        zzetVar2.zzh(i);
        Charset charsetZzR = zzetVar2.zzR();
        if (charsetZzR == null) {
            charsetZzR = StandardCharsets.UTF_8;
        }
        while (true) {
            String strZzN = zzetVar2.zzN(charsetZzR);
            if (strZzN == null) {
                return;
            }
            if (strZzN.isEmpty()) {
                zzetVar = zzetVar2;
            } else {
                try {
                    Integer.parseInt(strZzN);
                    zzet zzetVar3 = zzaofVar.zze;
                    String strZzN2 = zzetVar3.zzN(charsetZzR);
                    if (strZzN2 == null) {
                        zzeg.zzc("SubripParser", "Unexpected end");
                        return;
                    }
                    Matcher matcher = zza.matcher(strZzN2);
                    if (matcher.matches()) {
                        long jZzc = zzc(matcher, 1);
                        long jZzc2 = zzc(matcher, 6);
                        StringBuilder sb = zzaofVar.zzc;
                        int i3 = 0;
                        sb.setLength(0);
                        ArrayList arrayList = zzaofVar.zzd;
                        arrayList.clear();
                        String strZzN3 = zzetVar3.zzN(charsetZzR);
                        while (!TextUtils.isEmpty(strZzN3)) {
                            if (sb.length() > 0) {
                                sb.append("<br>");
                            }
                            String strTrim = strZzN3.trim();
                            StringBuilder sb2 = new StringBuilder(strTrim);
                            Matcher matcher2 = zzb.matcher(strTrim);
                            int i4 = i3;
                            while (matcher2.find()) {
                                String strGroup = matcher2.group();
                                arrayList.add(strGroup);
                                int iStart = matcher2.start() - i4;
                                int length = strGroup.length();
                                sb2.replace(iStart, iStart + length, "");
                                i4 += length;
                                zzetVar2 = zzetVar2;
                            }
                            sb.append(sb2.toString());
                            strZzN3 = zzetVar3.zzN(charsetZzR);
                            i3 = 0;
                        }
                        zzetVar = zzetVar2;
                        Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                        int i5 = 0;
                        while (true) {
                            if (i5 < arrayList.size()) {
                                str = (String) arrayList.get(i5);
                                if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                    i5++;
                                }
                            } else {
                                str = null;
                            }
                        }
                        zzcw zzcwVar = new zzcw();
                        zzcwVar.zza(spannedFromHtml);
                        if (str == null) {
                            zzcxVarZzr = zzcwVar.zzr();
                        } else {
                            switch (str.hashCode()) {
                                case -685620710:
                                    if (!str.equals("{\\an1}")) {
                                        zzcwVar.zzj(1);
                                    } else {
                                        zzcwVar.zzj(0);
                                    }
                                    break;
                                case -685620648:
                                    if (str.equals("{\\an3}")) {
                                        zzcwVar.zzj(2);
                                        break;
                                    }
                                    break;
                                case -685620617:
                                    if (str.equals("{\\an4}")) {
                                    }
                                    break;
                                case -685620555:
                                    if (str.equals("{\\an6}")) {
                                    }
                                    break;
                                case -685620524:
                                    if (str.equals("{\\an7}")) {
                                    }
                                    break;
                                case -685620462:
                                    if (str.equals("{\\an9}")) {
                                    }
                                    break;
                            }
                            switch (str.hashCode()) {
                                case -685620710:
                                    if (!str.equals("{\\an1}")) {
                                        zzcwVar.zzg(1);
                                    } else {
                                        zzcwVar.zzg(2);
                                    }
                                    break;
                                case -685620679:
                                    if (str.equals("{\\an2}")) {
                                    }
                                    break;
                                case -685620648:
                                    if (str.equals("{\\an3}")) {
                                    }
                                    break;
                                case -685620524:
                                    if (str.equals("{\\an7}")) {
                                        zzcwVar.zzg(0);
                                        break;
                                    }
                                    break;
                                case -685620493:
                                    if (str.equals("{\\an8}")) {
                                    }
                                    break;
                                case -685620462:
                                    if (str.equals("{\\an9}")) {
                                    }
                                    break;
                            }
                            zzcwVar.zzi(zzb(zzcwVar.zzk()));
                            zzcwVar.zzf(zzb(zzcwVar.zzh()), 0);
                            zzcxVarZzr = zzcwVar.zzr();
                        }
                        zzdtVar.zza(new zzand(zzgwm.zzj(zzcxVarZzr), jZzc, jZzc2 - jZzc));
                    } else {
                        zzetVar = zzetVar2;
                        zzeg.zzc("SubripParser", "Skipping invalid timing: ".concat(strZzN2));
                    }
                } catch (NumberFormatException unused) {
                    zzetVar = zzetVar2;
                    zzeg.zzc("SubripParser", "Skipping invalid index: ".concat(strZzN));
                }
            }
            zzaofVar = this;
            zzetVar2 = zzetVar;
        }
    }
}
