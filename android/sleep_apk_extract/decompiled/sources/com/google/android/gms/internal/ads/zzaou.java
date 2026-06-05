package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class zzaou {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzet zzc = new zzet();
    private final StringBuilder zzd = new StringBuilder();

    public static void zzb(zzet zzetVar) {
        while (true) {
            for (boolean z = true; zzetVar.zzd() > 0 && z; z = false) {
                char c = (char) zzetVar.zzi()[zzetVar.zzg()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzetVar.zzk(1);
                } else {
                    int iZzg = zzetVar.zzg();
                    int iZze = zzetVar.zze();
                    byte[] bArrZzi = zzetVar.zzi();
                    if (iZzg + 2 <= iZze) {
                        int i = iZzg + 1;
                        if (bArrZzi[iZzg] == 47) {
                            int i2 = iZzg + 2;
                            if (bArrZzi[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzi[i2]) == '*' && ((char) bArrZzi[i3]) == '/') {
                                        iZze = i2 + 2;
                                        i2 = iZze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzetVar.zzk(iZze - zzetVar.zzg());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    public static String zzc(zzet zzetVar, StringBuilder sb) {
        zzb(zzetVar);
        if (zzetVar.zzd() == 0) {
            return null;
        }
        String strZzd = zzd(zzetVar, sb);
        if (!strZzd.isEmpty()) {
            return strZzd;
        }
        char cZzs = (char) zzetVar.zzs();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cZzs).length());
        sb2.append(cZzs);
        return sb2.toString();
    }

    private static String zzd(zzet zzetVar, StringBuilder sb) {
        boolean z;
        char c;
        sb.setLength(0);
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        loop0: while (true) {
            for (false; iZzg < iZze && !z; true) {
                c = (char) zzetVar.zzi()[iZzg];
                z = (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_');
            }
            sb.append(c);
            iZzg++;
        }
        zzetVar.zzk(iZzg - zzetVar.zzg());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x02f8, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza(zzet zzetVar) {
        String strTrim;
        String string;
        StringBuilder sb = this.zzd;
        sb.setLength(0);
        int iZzg = zzetVar.zzg();
        while (!TextUtils.isEmpty(zzetVar.zzN(StandardCharsets.UTF_8))) {
        }
        zzet zzetVar2 = this.zzc;
        zzetVar2.zzb(zzetVar.zzi(), zzetVar.zzg());
        zzetVar2.zzh(iZzg);
        ArrayList arrayList = new ArrayList();
        loop1: while (true) {
            zzb(zzetVar2);
            if (zzetVar2.zzd() >= 5 && "::cue".equals(zzetVar2.zzK(5, StandardCharsets.UTF_8))) {
                int iZzg2 = zzetVar2.zzg();
                String strZzc = zzc(zzetVar2, sb);
                if (strZzc != null) {
                    if ("{".equals(strZzc)) {
                        zzetVar2.zzh(iZzg2);
                        strTrim = "";
                    } else {
                        if ("(".equals(strZzc)) {
                            int iZzg3 = zzetVar2.zzg();
                            int iZze = zzetVar2.zze();
                            boolean z = false;
                            while (iZzg3 < iZze && !z) {
                                int i = iZzg3 + 1;
                                z = ((char) zzetVar2.zzi()[iZzg3]) == ')';
                                iZzg3 = i;
                            }
                            strTrim = zzetVar2.zzK((iZzg3 - 1) - zzetVar2.zzg(), StandardCharsets.UTF_8).trim();
                        } else {
                            strTrim = null;
                        }
                        if (!")".equals(zzc(zzetVar2, sb))) {
                            strTrim = null;
                        }
                    }
                }
            }
            if (strTrim == null || !"{".equals(zzc(zzetVar2, sb))) {
                break;
            }
            zzaov zzaovVar = new zzaov();
            if (!strTrim.isEmpty()) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher.matches()) {
                        String strGroup = matcher.group(1);
                        strGroup.getClass();
                        zzaovVar.zzd(strGroup);
                    }
                    strTrim = strTrim.substring(0, iIndexOf);
                }
                String str = zzfl.zza;
                String[] strArrSplit = strTrim.split("\\.", -1);
                String str2 = strArrSplit[0];
                int iIndexOf2 = str2.indexOf(35);
                if (iIndexOf2 != -1) {
                    zzaovVar.zzb(str2.substring(0, iIndexOf2));
                    zzaovVar.zza(str2.substring(iIndexOf2 + 1));
                } else {
                    zzaovVar.zzb(str2);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzaovVar.zzc((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            boolean z2 = false;
            String strZzc2 = null;
            while (!z2) {
                int iZzg4 = zzetVar2.zzg();
                strZzc2 = zzc(zzetVar2, sb);
                boolean z3 = strZzc2 == null || "}".equals(strZzc2);
                if (!z3) {
                    zzetVar2.zzh(iZzg4);
                    zzb(zzetVar2);
                    String strZzd = zzd(zzetVar2, sb);
                    if (!strZzd.isEmpty() && ":".equals(zzc(zzetVar2, sb))) {
                        zzb(zzetVar2);
                        StringBuilder sb2 = new StringBuilder();
                        boolean z4 = false;
                        while (true) {
                            if (z4) {
                                string = sb2.toString();
                                break;
                            }
                            int iZzg5 = zzetVar2.zzg();
                            String strZzc3 = zzc(zzetVar2, sb);
                            if (strZzc3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZzc3) || ";".equals(strZzc3)) {
                                zzetVar2.zzh(iZzg5);
                                z4 = true;
                            } else {
                                sb2.append(strZzc3);
                            }
                        }
                        if (string != null && !string.isEmpty()) {
                            int iZzg6 = zzetVar2.zzg();
                            String strZzc4 = zzc(zzetVar2, sb);
                            if (";".equals(strZzc4)) {
                                if (!"color".equals(strZzd)) {
                                }
                            } else if ("}".equals(strZzc4)) {
                                zzetVar2.zzh(iZzg6);
                                if (!"color".equals(strZzd)) {
                                    zzaovVar.zzn(zzdr.zzb(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzaovVar.zzq(zzdr.zzb(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzaovVar.zzw(1);
                                    } else if ("under".equals(string)) {
                                        zzaovVar.zzw(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    zzaovVar.zzy("all".equals(string) || string.startsWith("digits"));
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzaovVar.zzh(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzaovVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzaovVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzaovVar.zzj(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    Matcher matcher2 = zzb.matcher(zzgss.zza(string));
                                    if (matcher2.matches()) {
                                        String strGroup2 = matcher2.group(2);
                                        strGroup2.getClass();
                                        int iHashCode = strGroup2.hashCode();
                                        if (iHashCode == 37) {
                                            if (!strGroup2.equals("%")) {
                                                break loop1;
                                            }
                                            zzaovVar.zzt(3);
                                            String strGroup3 = matcher2.group(1);
                                            strGroup3.getClass();
                                            zzaovVar.zzs(Float.parseFloat(strGroup3));
                                        } else if (iHashCode == 3240) {
                                            if (!strGroup2.equals(UserDataStore.EMAIL)) {
                                                break loop1;
                                            }
                                            zzaovVar.zzt(2);
                                            String strGroup32 = matcher2.group(1);
                                            strGroup32.getClass();
                                            zzaovVar.zzs(Float.parseFloat(strGroup32));
                                        } else {
                                            if (iHashCode != 3592 || !strGroup2.equals("px")) {
                                                break loop1;
                                            }
                                            zzaovVar.zzt(1);
                                            String strGroup322 = matcher2.group(1);
                                            strGroup322.getClass();
                                            zzaovVar.zzs(Float.parseFloat(strGroup322));
                                        }
                                    } else {
                                        StringBuilder sb3 = new StringBuilder(string.length() + 22);
                                        sb3.append("Invalid font-size: '");
                                        sb3.append(string);
                                        sb3.append("'.");
                                        zzeg.zzc("WebvttCssParser", sb3.toString());
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                z2 = z3;
            }
            if ("}".equals(strZzc2)) {
                arrayList.add(zzaovVar);
            }
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }
}
