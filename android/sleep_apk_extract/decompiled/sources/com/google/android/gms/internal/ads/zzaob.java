package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaob implements zzanl {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzaoa zzc;
    private Map zze;
    private float zzf = -3.4028235E38f;
    private float zzg = -3.4028235E38f;
    private final zzet zzd = new zzet();

    public zzaob(List list) {
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzj = zzfl.zzj((byte[]) list.get(0));
        zzgtj.zza(strZzj.startsWith("Format:"));
        zzaoa zzaoaVarZza = zzaoa.zza(strZzj);
        zzaoaVarZza.getClass();
        this.zzc = zzaoaVarZza;
        zzb(new zzet((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zzb(zzet zzetVar, Charset charset) {
        while (true) {
            String strZzN = zzetVar.zzN(charset);
            if (strZzN == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzN)) {
                while (true) {
                    String strZzN2 = zzetVar.zzN(charset);
                    if (strZzN2 == null || (zzetVar.zzd() != 0 && zzetVar.zzp(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzN2.split(":");
                    if (strArrSplit.length == 2) {
                        String strZza = zzgss.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (strZza.equals("playresx")) {
                                    this.zzf = Float.parseFloat(strArrSplit[1].trim());
                                }
                                break;
                            case 1879649549:
                                if (strZza.equals("playresy")) {
                                    try {
                                        this.zzg = Float.parseFloat(strArrSplit[1].trim());
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                break;
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzN)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzaoc zzaocVarZza = null;
                while (true) {
                    String strZzN3 = zzetVar.zzN(charset);
                    if (strZzN3 != null && (zzetVar.zzd() == 0 || zzetVar.zzp(charset) != 91)) {
                        if (strZzN3.startsWith("Format:")) {
                            zzaocVarZza = zzaoc.zza(strZzN3);
                        } else if (strZzN3.startsWith("Style:")) {
                            if (zzaocVarZza == null) {
                                zzeg.zzc("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzN3));
                            } else {
                                zzaoe zzaoeVarZza = zzaoe.zza(strZzN3, zzaocVarZza);
                                if (zzaoeVarZza != null) {
                                    linkedHashMap.put(zzaoeVarZza.zza, zzaoeVarZza);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzN)) {
                zzeg.zzb("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzN)) {
                return;
            }
        }
    }

    private static long zzc(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = zzfl.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    private static float zzd(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zze(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    @Override // com.google.android.gms.internal.ads.zzanl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzaoa zzaoaVarZza;
        Charset charset;
        zzaoa zzaoaVar;
        zzet zzetVar;
        int i3;
        long jZzc;
        float f;
        Layout.Alignment alignment;
        int i4;
        int i5;
        int i6;
        Integer num;
        int i7;
        zzaob zzaobVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzet zzetVar2 = zzaobVar.zzd;
        zzetVar2.zzb(bArr, i + i2);
        zzetVar2.zzh(i);
        Charset charsetZzR = zzetVar2.zzR();
        if (charsetZzR == null) {
            charsetZzR = StandardCharsets.UTF_8;
        }
        if (zzaobVar.zzb) {
            zzaoaVarZza = zzaobVar.zzc;
        } else {
            zzaobVar.zzb(zzetVar2, charsetZzR);
            zzaoaVarZza = null;
        }
        while (true) {
            String strZzN = zzetVar2.zzN(charsetZzR);
            if (strZzN == null) {
                int i8 = 0;
                while (i8 < arrayList.size()) {
                    List list = (List) arrayList.get(i8);
                    if (list.isEmpty()) {
                        if (i8 == 0) {
                            i8 = 0;
                            if (i8 != arrayList.size() - 1) {
                            }
                        }
                    } else if (i8 != arrayList.size() - 1) {
                        Home$$ExternalSyntheticBUOutline0.m$2();
                        return;
                    } else {
                        long jLongValue = ((Long) arrayList2.get(i8)).longValue();
                        zzdtVar.zza(new zzand(list, jLongValue, ((Long) arrayList2.get(i8 + 1)).longValue() - jLongValue));
                    }
                    i8++;
                }
                return;
            }
            if (strZzN.startsWith("Format:")) {
                zzaoaVarZza = zzaoa.zza(strZzN);
            } else if (strZzN.startsWith("Dialogue:")) {
                if (zzaoaVarZza == null) {
                    zzeg.zzc("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzN));
                } else {
                    zzgtj.zza(strZzN.startsWith("Dialogue:"));
                    String strSubstring = strZzN.substring(9);
                    int i9 = zzaoaVarZza.zzf;
                    String[] strArrSplit = strSubstring.split(",", i9);
                    if (strArrSplit.length != i9) {
                        zzeg.zzc("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzN));
                    } else {
                        int i10 = zzaoaVarZza.zza;
                        if (i10 != -1) {
                            try {
                                i3 = Integer.parseInt(strArrSplit[i10].trim());
                            } catch (RuntimeException unused) {
                                zzba$$ExternalSyntheticOutline0.m(strArrSplit[zzaoaVarZza.zza], "Fail to parse layer: ", "SsaParser");
                                i3 = 0;
                            }
                            jZzc = zzc(strArrSplit[zzaoaVarZza.zzb]);
                            if (jZzc != -9223372036854775807L) {
                                zzeg.zzc("SsaParser", "Skipping invalid timing: ".concat(strZzN));
                            } else {
                                long jZzc2 = zzc(strArrSplit[zzaoaVarZza.zzc]);
                                if (jZzc2 == -9223372036854775807L || jZzc2 <= jZzc) {
                                    charset = charsetZzR;
                                    zzaoaVar = zzaoaVarZza;
                                    zzetVar = zzetVar2;
                                    zzeg.zzc("SsaParser", "Skipping invalid timing: ".concat(strZzN));
                                } else {
                                    Map map = zzaobVar.zze;
                                    zzaoe zzaoeVar = (map == null || (i7 = zzaoaVarZza.zzd) == -1) ? null : (zzaoe) map.get(strArrSplit[i7].trim());
                                    String str = strArrSplit[zzaoaVarZza.zze];
                                    zzaod zzaodVarZza = zzaod.zza(str);
                                    charset = charsetZzR;
                                    String strReplace = zzaod.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f2 = zzaobVar.zzf;
                                    float f3 = zzaobVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzcw zzcwVar = new zzcw();
                                    zzcwVar.zza(spannableString);
                                    zzcwVar.zzq(i3);
                                    if (zzaoeVar != null) {
                                        Integer num2 = zzaoeVar.zzc;
                                        zzaoaVar = zzaoaVarZza;
                                        if (num2 != null) {
                                            zzetVar = zzetVar2;
                                            f = f2;
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        } else {
                                            zzetVar = zzetVar2;
                                            f = f2;
                                        }
                                        if (zzaoeVar.zzj == 3 && (num = zzaoeVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f4 = zzaoeVar.zze;
                                        if (f4 != -3.4028235E38f && f3 != -3.4028235E38f) {
                                            zzcwVar.zzl(f4 / f3, 1);
                                        }
                                        boolean z = zzaoeVar.zzf;
                                        if (z && zzaoeVar.zzg) {
                                            i5 = 0;
                                            i6 = 33;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i5 = 0;
                                            i6 = 33;
                                            if (z) {
                                                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                            } else if (zzaoeVar.zzg) {
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                        }
                                        if (zzaoeVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i5, spannableString.length(), i6);
                                        }
                                        if (zzaoeVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i5, spannableString.length(), i6);
                                        }
                                    } else {
                                        zzaoaVar = zzaoaVarZza;
                                        zzetVar = zzetVar2;
                                        f = f2;
                                    }
                                    int i11 = zzaodVarZza.zza;
                                    if (i11 == -1) {
                                        i11 = zzaoeVar != null ? zzaoeVar.zzb : -1;
                                    }
                                    switch (i11) {
                                        case 0:
                                        default:
                                            zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i11, 19), i11, "Unknown alignment: ", "SsaParser");
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzcwVar.zzd(alignment);
                                    int i12 = Integer.MIN_VALUE;
                                    switch (i11) {
                                        case 0:
                                        default:
                                            zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i11, 19), i11, "Unknown alignment: ", "SsaParser");
                                        case -1:
                                            i4 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i4 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i4 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i4 = 2;
                                            break;
                                    }
                                    zzcwVar.zzj(i4);
                                    switch (i11) {
                                        case -1:
                                            break;
                                        case 0:
                                        default:
                                            zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i11, 19), i11, "Unknown alignment: ", "SsaParser");
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i12 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i12 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i12 = 0;
                                            break;
                                    }
                                    zzcwVar.zzg(i12);
                                    PointF pointF = zzaodVarZza.zzb;
                                    if (pointF == null || f3 == -3.4028235E38f || f == -3.4028235E38f) {
                                        zzcwVar.zzi(zzd(zzcwVar.zzk()));
                                        zzcwVar.zzf(zzd(zzcwVar.zzh()), 0);
                                    } else {
                                        zzcwVar.zzi(pointF.x / f);
                                        zzcwVar.zzf(pointF.y / f3, 0);
                                    }
                                    zzcx zzcxVarZzr = zzcwVar.zzr();
                                    int iZze = zze(jZzc2, arrayList2, arrayList);
                                    for (int iZze2 = zze(jZzc, arrayList2, arrayList); iZze2 < iZze; iZze2++) {
                                        ((List) arrayList.get(iZze2)).add(zzcxVarZzr);
                                    }
                                }
                                zzaobVar = this;
                                charsetZzR = charset;
                                zzaoaVarZza = zzaoaVar;
                                zzetVar2 = zzetVar;
                            }
                        } else {
                            i3 = 0;
                            jZzc = zzc(strArrSplit[zzaoaVarZza.zzb]);
                            if (jZzc != -9223372036854775807L) {
                            }
                        }
                    }
                }
                charset = charsetZzR;
                zzaoaVar = zzaoaVarZza;
                zzetVar = zzetVar2;
                zzaobVar = this;
                charsetZzR = charset;
                zzaoaVarZza = zzaoaVar;
                zzetVar2 = zzetVar;
            } else {
                charset = charsetZzR;
                zzaoaVar = zzaoaVarZza;
                zzetVar = zzetVar2;
                zzaobVar = this;
                charsetZzR = charset;
                zzaoaVarZza = zzaoaVar;
                zzetVar2 = zzetVar;
            }
        }
    }
}
