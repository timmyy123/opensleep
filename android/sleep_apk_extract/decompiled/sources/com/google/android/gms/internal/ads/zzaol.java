package com.google.android.gms.internal.ads;

import android.text.Layout;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaol implements zzanl {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzaoj zzh = new zzaoj(30.0f, 1, 1);

    public zzaol() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Couldn't create XmlPullParserFactory instance", (Throwable) e);
            throw null;
        }
    }

    private static String[] zzc(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        String str2 = zzfl.zza;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e A[Catch: zzanh -> 0x0187, TryCatch #2 {zzanh -> 0x0187, blocks: (B:35:0x00a7, B:37:0x00c3, B:40:0x00d9, B:42:0x00df, B:44:0x00e5, B:53:0x00fd, B:62:0x0118, B:64:0x011e, B:65:0x0127, B:66:0x0128, B:67:0x0145, B:57:0x0109, B:61:0x0115, B:68:0x0146, B:69:0x0147, B:70:0x0164, B:39:0x00cc, B:71:0x0165, B:72:0x0186), top: B:175:0x00a7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzaoo zzd(XmlPullParser xmlPullParser, zzaoo zzaooVar) {
        Matcher matcher;
        String strGroup;
        int attributeCount = xmlPullParser.getAttributeCount();
        zzaoo zzaooVarZze = zzaooVar;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzg("italic".equalsIgnoreCase(attributeValue));
                        continue;
                    }
                    break;
                case -1289044182:
                    if (attributeName.equals("extent")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzM(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzi(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzz(zzf(attributeValue));
                    } else {
                        continue;
                    }
                    break;
                case -1008619738:
                    if (attributeName.equals("origin")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzK(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        String strZza = zzgss.zza(attributeValue);
                        switch (strZza.hashCode()) {
                            case -1461280213:
                                if (strZza.equals("nounderline")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zze(false);
                                }
                                break;
                            case -1026963764:
                                if (strZza.equals("underline")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zze(true);
                                }
                                break;
                            case 913457136:
                                if (strZza.equals("nolinethrough")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzc(false);
                                }
                                break;
                            case 1679736913:
                                if (strZza.equals("linethrough")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzc(true);
                                }
                                break;
                        }
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzf("bold".equalsIgnoreCase(attributeValue));
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id") && AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzs(attributeValue);
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        String strZza2 = zzgss.zza(attributeValue);
                        switch (strZza2.hashCode()) {
                            case -618561360:
                                if (strZza2.equals("baseContainer")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(2);
                                }
                                break;
                            case -410956671:
                                if (strZza2.equals("container")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(1);
                                }
                                break;
                            case -250518009:
                                if (strZza2.equals("delimiter")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(4);
                                }
                                break;
                            case -136074796:
                                if (strZza2.equals("textContainer")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(3);
                                }
                                break;
                            case 3016401:
                                if (strZza2.equals("base")) {
                                }
                                break;
                            case 3556653:
                                if (strZza2.equals("text")) {
                                }
                                break;
                        }
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        try {
                            zzaooVarZze.zzk(zzdr.zza(attributeValue));
                        } catch (IllegalArgumentException unused) {
                            zzba$$ExternalSyntheticOutline0.m(attributeValue, "Failed parsing color value: ", "TtmlParser");
                        }
                    }
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        zzaoo zzaooVarZze2 = zze(zzaooVarZze);
                        Matcher matcher2 = zza.matcher(attributeValue);
                        float fMin = Float.MAX_VALUE;
                        if (matcher2.matches()) {
                            try {
                                String strGroup2 = matcher2.group(1);
                                if (strGroup2 == null) {
                                    throw null;
                                }
                                fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup2)));
                            } catch (NumberFormatException e) {
                                zzeg.zzd("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e);
                            }
                        } else {
                            zzba$$ExternalSyntheticOutline0.m(attributeValue, "Invalid value for shear: ", "TtmlParser");
                        }
                        zzaooVarZze2.zzp(fMin);
                        zzaooVarZze = zzaooVarZze2;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        String strZza3 = zzgss.zza(attributeValue);
                        int iHashCode = strZza3.hashCode();
                        if (iHashCode == 96673) {
                            if (strZza3.equals("all")) {
                                zzaooVarZze = zze(zzaooVarZze);
                                zzaooVarZze.zzD(true);
                            }
                        } else if (iHashCode == 3387192 && strZza3.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                            zzaooVarZze = zze(zzaooVarZze);
                            zzaooVarZze.zzD(false);
                        }
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        try {
                            zzaooVarZze = zze(zzaooVarZze);
                            String str = zzfl.zza;
                            String[] strArrSplit = attributeValue.split("\\s+", -1);
                            int length = strArrSplit.length;
                            if (length == 1) {
                                matcher = zze.matcher(attributeValue);
                            } else {
                                if (length != 2) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 41);
                                    sb.append("Invalid number of entries for fontSize: ");
                                    sb.append(length);
                                    sb.append(".");
                                    throw new zzanh(sb.toString());
                                }
                                matcher = zze.matcher(strArrSplit[1]);
                                zzeg.zzc("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                            }
                            if (!matcher.matches()) {
                                StringBuilder sb2 = new StringBuilder(attributeValue.length() + 36);
                                sb2.append("Invalid expression for fontSize: '");
                                sb2.append(attributeValue);
                                sb2.append("'.");
                                throw new zzanh(sb2.toString());
                            }
                            String strGroup3 = matcher.group(3);
                            if (strGroup3 == null) {
                                throw null;
                            }
                            int iHashCode2 = strGroup3.hashCode();
                            if (iHashCode2 == 37) {
                                if (!strGroup3.equals("%")) {
                                    StringBuilder sb3 = new StringBuilder(strGroup3.length() + 30);
                                    sb3.append("Invalid unit for fontSize: '");
                                    sb3.append(strGroup3);
                                    sb3.append("'.");
                                    throw new zzanh(sb3.toString());
                                }
                                zzaooVarZze.zzH(3);
                                strGroup = matcher.group(1);
                                if (strGroup == null) {
                                }
                            } else if (iHashCode2 != 3240) {
                                if (iHashCode2 != 3592 || !strGroup3.equals("px")) {
                                    StringBuilder sb32 = new StringBuilder(strGroup3.length() + 30);
                                    sb32.append("Invalid unit for fontSize: '");
                                    sb32.append(strGroup3);
                                    sb32.append("'.");
                                    throw new zzanh(sb32.toString());
                                }
                                zzaooVarZze.zzH(1);
                                strGroup = matcher.group(1);
                                if (strGroup == null) {
                                    throw null;
                                }
                                zzaooVarZze.zzG(Float.parseFloat(strGroup));
                                break;
                            } else {
                                if (!strGroup3.equals(UserDataStore.EMAIL)) {
                                    StringBuilder sb322 = new StringBuilder(strGroup3.length() + 30);
                                    sb322.append("Invalid unit for fontSize: '");
                                    sb322.append(strGroup3);
                                    sb322.append("'.");
                                    throw new zzanh(sb322.toString());
                                }
                                zzaooVarZze.zzH(2);
                                strGroup = matcher.group(1);
                                if (strGroup == null) {
                                }
                            }
                        } catch (zzanh unused2) {
                            zzba$$ExternalSyntheticOutline0.m(attributeValue, "Failed parsing fontSize value: ", "TtmlParser");
                            break;
                        }
                    }
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzF(zzaoh.zza(attributeValue));
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        String strZza4 = zzgss.zza(attributeValue);
                        int iHashCode3 = strZza4.hashCode();
                        if (iHashCode3 != -1392885889) {
                            if (iHashCode3 == 92734940 && strZza4.equals("after")) {
                                zzaooVarZze = zze(zzaooVarZze);
                                zzaooVarZze.zzw(2);
                            }
                        } else if (strZza4.equals("before")) {
                            zzaooVarZze = zze(zzaooVarZze);
                            zzaooVarZze.zzw(1);
                        }
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        try {
                            zzaooVarZze.zzn(zzdr.zza(attributeValue));
                        } catch (IllegalArgumentException unused3) {
                            zzba$$ExternalSyntheticOutline0.m(attributeValue, "Failed parsing background value: ", "TtmlParser");
                        }
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzB(zzf(attributeValue));
                    }
                    break;
            }
        }
        return zzaooVarZze;
    }

    private static zzaoo zze(zzaoo zzaooVar) {
        return zzaooVar == null ? new zzaoo() : zzaooVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Layout.Alignment zzf(String str) {
        String strZza = zzgss.zza(str);
        switch (strZza.hashCode()) {
            case -1364013995:
                if (strZza.equals("center")) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                return null;
            case 100571:
                if (!strZza.equals("end")) {
                    return null;
                }
                break;
            case 3317767:
                if (!strZza.equals(ViewHierarchyConstants.DIMENSION_LEFT_KEY)) {
                    return null;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            case 108511772:
                if (!strZza.equals("right")) {
                    return null;
                }
                break;
            case 109757538:
                if (!strZza.equals("start")) {
                    return null;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
        return Layout.Alignment.ALIGN_OPPOSITE;
    }

    private static long zzg(String str, zzaoj zzaojVar) throws zzanh {
        double d;
        double d2;
        Matcher matcher = zzc.matcher(str);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            long j = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            long j2 = Long.parseLong(strGroup2) * 60;
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d3 = j + j2;
            double d4 = Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d5 = strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d;
            double d6 = d3 + d4;
            return (long) ((d6 + d5 + (matcher.group(5) != null ? Long.parseLong(r12) / zzaojVar.zza : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r12) / ((double) zzaojVar.zzb)) / ((double) zzaojVar.zza) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            throw new zzanh("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String strGroup5 = matcher2.group(1);
        strGroup5.getClass();
        double d7 = Double.parseDouble(strGroup5);
        String strGroup6 = matcher2.group(2);
        strGroup6.getClass();
        int iHashCode = strGroup6.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 3494) {
                        if (iHashCode == 115) {
                            strGroup6.equals("s");
                        } else if (iHashCode == 116 && strGroup6.equals("t")) {
                            d = zzaojVar.zzc;
                            d7 /= d;
                        }
                    } else if (strGroup6.equals("ms")) {
                        d = 1000.0d;
                        d7 /= d;
                    }
                } else if (strGroup6.equals("m")) {
                    d2 = 60.0d;
                    d7 *= d2;
                }
            } else if (strGroup6.equals("h")) {
                d2 = 3600.0d;
                d7 *= d2;
            }
        } else if (strGroup6.equals("f")) {
            d = zzaojVar.zza;
            d7 /= d;
        }
        return (long) (d7 * 1000000.0d);
    }

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzanf.zza(zzb(bArr, i, i2), zzankVar, zzdtVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:277:0x0580. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x030d A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TRY_LEAVE, TryCatch #3 {IOException -> 0x0091, blocks: (B:3:0x0009, B:4:0x000b, B:7:0x005b, B:9:0x006a, B:12:0x0076, B:15:0x0084, B:17:0x008c, B:23:0x0099, B:25:0x00a1, B:29:0x00b7, B:31:0x00d2, B:33:0x00dc, B:34:0x00e0, B:36:0x00ec, B:37:0x00f0, B:66:0x0168, B:86:0x01c1, B:89:0x01d5, B:91:0x01db, B:93:0x01e3, B:95:0x01eb, B:97:0x01f3, B:99:0x01fb, B:101:0x0203, B:103:0x0209, B:105:0x0211, B:107:0x0219, B:109:0x021f, B:111:0x0225, B:113:0x022b, B:115:0x0233, B:118:0x023c, B:391:0x071b, B:120:0x026c, B:122:0x0272, B:124:0x027b, B:126:0x028a, B:128:0x0297, B:130:0x02ad, B:132:0x02b3, B:268:0x0537, B:134:0x02be, B:137:0x02ca, B:252:0x04e7, B:141:0x02e8, B:143:0x02f0, B:145:0x02f8, B:147:0x0300, B:152:0x030d, B:155:0x0326, B:157:0x032c, B:159:0x0339, B:179:0x03a0, B:181:0x03a6, B:183:0x03ac, B:185:0x03b4, B:187:0x03ba, B:190:0x03cd, B:192:0x03d3, B:194:0x03e0, B:214:0x0455, B:216:0x045d, B:230:0x0498, B:232:0x04a2, B:250:0x04da, B:195:0x03eb, B:196:0x03ec, B:197:0x03ed, B:198:0x03fa, B:201:0x0402, B:204:0x0410, B:206:0x0416, B:208:0x0421, B:209:0x0435, B:210:0x0436, B:211:0x0437, B:212:0x0444, B:160:0x0342, B:161:0x0343, B:162:0x0344, B:163:0x034c, B:166:0x0356, B:169:0x035f, B:171:0x0365, B:173:0x0370, B:174:0x0382, B:175:0x0383, B:176:0x0384, B:177:0x038d, B:255:0x04fa, B:257:0x0507, B:259:0x0512, B:261:0x0518, B:263:0x0524, B:273:0x0551, B:276:0x0574, B:321:0x062b, B:281:0x0597, B:284:0x05a0, B:366:0x06ab, B:298:0x05ca, B:304:0x05df, B:310:0x05f7, B:314:0x060e, B:318:0x0623, B:326:0x0642, B:355:0x0689, B:357:0x0695, B:359:0x069a, B:347:0x0674, B:69:0x0175, B:71:0x0181, B:74:0x018a, B:76:0x0190, B:78:0x019b, B:79:0x01a7, B:80:0x01a8, B:81:0x01a9, B:41:0x0109, B:43:0x0115, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:52:0x0132, B:58:0x014a, B:65:0x0160, B:61:0x0157, B:64:0x015f, B:370:0x06cc, B:372:0x06da, B:375:0x06de, B:377:0x06e8, B:379:0x06f2, B:383:0x06fb, B:381:0x06f8, B:386:0x0710, B:390:0x0718, B:396:0x0736), top: B:409:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ba A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TRY_LEAVE, TryCatch #3 {IOException -> 0x0091, blocks: (B:3:0x0009, B:4:0x000b, B:7:0x005b, B:9:0x006a, B:12:0x0076, B:15:0x0084, B:17:0x008c, B:23:0x0099, B:25:0x00a1, B:29:0x00b7, B:31:0x00d2, B:33:0x00dc, B:34:0x00e0, B:36:0x00ec, B:37:0x00f0, B:66:0x0168, B:86:0x01c1, B:89:0x01d5, B:91:0x01db, B:93:0x01e3, B:95:0x01eb, B:97:0x01f3, B:99:0x01fb, B:101:0x0203, B:103:0x0209, B:105:0x0211, B:107:0x0219, B:109:0x021f, B:111:0x0225, B:113:0x022b, B:115:0x0233, B:118:0x023c, B:391:0x071b, B:120:0x026c, B:122:0x0272, B:124:0x027b, B:126:0x028a, B:128:0x0297, B:130:0x02ad, B:132:0x02b3, B:268:0x0537, B:134:0x02be, B:137:0x02ca, B:252:0x04e7, B:141:0x02e8, B:143:0x02f0, B:145:0x02f8, B:147:0x0300, B:152:0x030d, B:155:0x0326, B:157:0x032c, B:159:0x0339, B:179:0x03a0, B:181:0x03a6, B:183:0x03ac, B:185:0x03b4, B:187:0x03ba, B:190:0x03cd, B:192:0x03d3, B:194:0x03e0, B:214:0x0455, B:216:0x045d, B:230:0x0498, B:232:0x04a2, B:250:0x04da, B:195:0x03eb, B:196:0x03ec, B:197:0x03ed, B:198:0x03fa, B:201:0x0402, B:204:0x0410, B:206:0x0416, B:208:0x0421, B:209:0x0435, B:210:0x0436, B:211:0x0437, B:212:0x0444, B:160:0x0342, B:161:0x0343, B:162:0x0344, B:163:0x034c, B:166:0x0356, B:169:0x035f, B:171:0x0365, B:173:0x0370, B:174:0x0382, B:175:0x0383, B:176:0x0384, B:177:0x038d, B:255:0x04fa, B:257:0x0507, B:259:0x0512, B:261:0x0518, B:263:0x0524, B:273:0x0551, B:276:0x0574, B:321:0x062b, B:281:0x0597, B:284:0x05a0, B:366:0x06ab, B:298:0x05ca, B:304:0x05df, B:310:0x05f7, B:314:0x060e, B:318:0x0623, B:326:0x0642, B:355:0x0689, B:357:0x0695, B:359:0x069a, B:347:0x0674, B:69:0x0175, B:71:0x0181, B:74:0x018a, B:76:0x0190, B:78:0x019b, B:79:0x01a7, B:80:0x01a8, B:81:0x01a9, B:41:0x0109, B:43:0x0115, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:52:0x0132, B:58:0x014a, B:65:0x0160, B:61:0x0157, B:64:0x015f, B:370:0x06cc, B:372:0x06da, B:375:0x06de, B:377:0x06e8, B:379:0x06f2, B:383:0x06fb, B:381:0x06f8, B:386:0x0710, B:390:0x0718, B:396:0x0736), top: B:409:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x045d A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TRY_LEAVE, TryCatch #3 {IOException -> 0x0091, blocks: (B:3:0x0009, B:4:0x000b, B:7:0x005b, B:9:0x006a, B:12:0x0076, B:15:0x0084, B:17:0x008c, B:23:0x0099, B:25:0x00a1, B:29:0x00b7, B:31:0x00d2, B:33:0x00dc, B:34:0x00e0, B:36:0x00ec, B:37:0x00f0, B:66:0x0168, B:86:0x01c1, B:89:0x01d5, B:91:0x01db, B:93:0x01e3, B:95:0x01eb, B:97:0x01f3, B:99:0x01fb, B:101:0x0203, B:103:0x0209, B:105:0x0211, B:107:0x0219, B:109:0x021f, B:111:0x0225, B:113:0x022b, B:115:0x0233, B:118:0x023c, B:391:0x071b, B:120:0x026c, B:122:0x0272, B:124:0x027b, B:126:0x028a, B:128:0x0297, B:130:0x02ad, B:132:0x02b3, B:268:0x0537, B:134:0x02be, B:137:0x02ca, B:252:0x04e7, B:141:0x02e8, B:143:0x02f0, B:145:0x02f8, B:147:0x0300, B:152:0x030d, B:155:0x0326, B:157:0x032c, B:159:0x0339, B:179:0x03a0, B:181:0x03a6, B:183:0x03ac, B:185:0x03b4, B:187:0x03ba, B:190:0x03cd, B:192:0x03d3, B:194:0x03e0, B:214:0x0455, B:216:0x045d, B:230:0x0498, B:232:0x04a2, B:250:0x04da, B:195:0x03eb, B:196:0x03ec, B:197:0x03ed, B:198:0x03fa, B:201:0x0402, B:204:0x0410, B:206:0x0416, B:208:0x0421, B:209:0x0435, B:210:0x0436, B:211:0x0437, B:212:0x0444, B:160:0x0342, B:161:0x0343, B:162:0x0344, B:163:0x034c, B:166:0x0356, B:169:0x035f, B:171:0x0365, B:173:0x0370, B:174:0x0382, B:175:0x0383, B:176:0x0384, B:177:0x038d, B:255:0x04fa, B:257:0x0507, B:259:0x0512, B:261:0x0518, B:263:0x0524, B:273:0x0551, B:276:0x0574, B:321:0x062b, B:281:0x0597, B:284:0x05a0, B:366:0x06ab, B:298:0x05ca, B:304:0x05df, B:310:0x05f7, B:314:0x060e, B:318:0x0623, B:326:0x0642, B:355:0x0689, B:357:0x0695, B:359:0x069a, B:347:0x0674, B:69:0x0175, B:71:0x0181, B:74:0x018a, B:76:0x0190, B:78:0x019b, B:79:0x01a7, B:80:0x01a8, B:81:0x01a9, B:41:0x0109, B:43:0x0115, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:52:0x0132, B:58:0x014a, B:65:0x0160, B:61:0x0157, B:64:0x015f, B:370:0x06cc, B:372:0x06da, B:375:0x06de, B:377:0x06e8, B:379:0x06f2, B:383:0x06fb, B:381:0x06f8, B:386:0x0710, B:390:0x0718, B:396:0x0736), top: B:409:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04a2 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TRY_LEAVE, TryCatch #3 {IOException -> 0x0091, blocks: (B:3:0x0009, B:4:0x000b, B:7:0x005b, B:9:0x006a, B:12:0x0076, B:15:0x0084, B:17:0x008c, B:23:0x0099, B:25:0x00a1, B:29:0x00b7, B:31:0x00d2, B:33:0x00dc, B:34:0x00e0, B:36:0x00ec, B:37:0x00f0, B:66:0x0168, B:86:0x01c1, B:89:0x01d5, B:91:0x01db, B:93:0x01e3, B:95:0x01eb, B:97:0x01f3, B:99:0x01fb, B:101:0x0203, B:103:0x0209, B:105:0x0211, B:107:0x0219, B:109:0x021f, B:111:0x0225, B:113:0x022b, B:115:0x0233, B:118:0x023c, B:391:0x071b, B:120:0x026c, B:122:0x0272, B:124:0x027b, B:126:0x028a, B:128:0x0297, B:130:0x02ad, B:132:0x02b3, B:268:0x0537, B:134:0x02be, B:137:0x02ca, B:252:0x04e7, B:141:0x02e8, B:143:0x02f0, B:145:0x02f8, B:147:0x0300, B:152:0x030d, B:155:0x0326, B:157:0x032c, B:159:0x0339, B:179:0x03a0, B:181:0x03a6, B:183:0x03ac, B:185:0x03b4, B:187:0x03ba, B:190:0x03cd, B:192:0x03d3, B:194:0x03e0, B:214:0x0455, B:216:0x045d, B:230:0x0498, B:232:0x04a2, B:250:0x04da, B:195:0x03eb, B:196:0x03ec, B:197:0x03ed, B:198:0x03fa, B:201:0x0402, B:204:0x0410, B:206:0x0416, B:208:0x0421, B:209:0x0435, B:210:0x0436, B:211:0x0437, B:212:0x0444, B:160:0x0342, B:161:0x0343, B:162:0x0344, B:163:0x034c, B:166:0x0356, B:169:0x035f, B:171:0x0365, B:173:0x0370, B:174:0x0382, B:175:0x0383, B:176:0x0384, B:177:0x038d, B:255:0x04fa, B:257:0x0507, B:259:0x0512, B:261:0x0518, B:263:0x0524, B:273:0x0551, B:276:0x0574, B:321:0x062b, B:281:0x0597, B:284:0x05a0, B:366:0x06ab, B:298:0x05ca, B:304:0x05df, B:310:0x05f7, B:314:0x060e, B:318:0x0623, B:326:0x0642, B:355:0x0689, B:357:0x0695, B:359:0x069a, B:347:0x0674, B:69:0x0175, B:71:0x0181, B:74:0x018a, B:76:0x0190, B:78:0x019b, B:79:0x01a7, B:80:0x01a8, B:81:0x01a9, B:41:0x0109, B:43:0x0115, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:52:0x0132, B:58:0x014a, B:65:0x0160, B:61:0x0157, B:64:0x015f, B:370:0x06cc, B:372:0x06da, B:375:0x06de, B:377:0x06e8, B:379:0x06f2, B:383:0x06fb, B:381:0x06f8, B:386:0x0710, B:390:0x0718, B:396:0x0736), top: B:409:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04e7 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #3 {IOException -> 0x0091, blocks: (B:3:0x0009, B:4:0x000b, B:7:0x005b, B:9:0x006a, B:12:0x0076, B:15:0x0084, B:17:0x008c, B:23:0x0099, B:25:0x00a1, B:29:0x00b7, B:31:0x00d2, B:33:0x00dc, B:34:0x00e0, B:36:0x00ec, B:37:0x00f0, B:66:0x0168, B:86:0x01c1, B:89:0x01d5, B:91:0x01db, B:93:0x01e3, B:95:0x01eb, B:97:0x01f3, B:99:0x01fb, B:101:0x0203, B:103:0x0209, B:105:0x0211, B:107:0x0219, B:109:0x021f, B:111:0x0225, B:113:0x022b, B:115:0x0233, B:118:0x023c, B:391:0x071b, B:120:0x026c, B:122:0x0272, B:124:0x027b, B:126:0x028a, B:128:0x0297, B:130:0x02ad, B:132:0x02b3, B:268:0x0537, B:134:0x02be, B:137:0x02ca, B:252:0x04e7, B:141:0x02e8, B:143:0x02f0, B:145:0x02f8, B:147:0x0300, B:152:0x030d, B:155:0x0326, B:157:0x032c, B:159:0x0339, B:179:0x03a0, B:181:0x03a6, B:183:0x03ac, B:185:0x03b4, B:187:0x03ba, B:190:0x03cd, B:192:0x03d3, B:194:0x03e0, B:214:0x0455, B:216:0x045d, B:230:0x0498, B:232:0x04a2, B:250:0x04da, B:195:0x03eb, B:196:0x03ec, B:197:0x03ed, B:198:0x03fa, B:201:0x0402, B:204:0x0410, B:206:0x0416, B:208:0x0421, B:209:0x0435, B:210:0x0436, B:211:0x0437, B:212:0x0444, B:160:0x0342, B:161:0x0343, B:162:0x0344, B:163:0x034c, B:166:0x0356, B:169:0x035f, B:171:0x0365, B:173:0x0370, B:174:0x0382, B:175:0x0383, B:176:0x0384, B:177:0x038d, B:255:0x04fa, B:257:0x0507, B:259:0x0512, B:261:0x0518, B:263:0x0524, B:273:0x0551, B:276:0x0574, B:321:0x062b, B:281:0x0597, B:284:0x05a0, B:366:0x06ab, B:298:0x05ca, B:304:0x05df, B:310:0x05f7, B:314:0x060e, B:318:0x0623, B:326:0x0642, B:355:0x0689, B:357:0x0695, B:359:0x069a, B:347:0x0674, B:69:0x0175, B:71:0x0181, B:74:0x018a, B:76:0x0190, B:78:0x019b, B:79:0x01a7, B:80:0x01a8, B:81:0x01a9, B:41:0x0109, B:43:0x0115, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:52:0x0132, B:58:0x014a, B:65:0x0160, B:61:0x0157, B:64:0x015f, B:370:0x06cc, B:372:0x06da, B:375:0x06de, B:377:0x06e8, B:379:0x06f2, B:383:0x06fb, B:381:0x06f8, B:386:0x0710, B:390:0x0718, B:396:0x0736), top: B:409:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0175 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #3 {IOException -> 0x0091, blocks: (B:3:0x0009, B:4:0x000b, B:7:0x005b, B:9:0x006a, B:12:0x0076, B:15:0x0084, B:17:0x008c, B:23:0x0099, B:25:0x00a1, B:29:0x00b7, B:31:0x00d2, B:33:0x00dc, B:34:0x00e0, B:36:0x00ec, B:37:0x00f0, B:66:0x0168, B:86:0x01c1, B:89:0x01d5, B:91:0x01db, B:93:0x01e3, B:95:0x01eb, B:97:0x01f3, B:99:0x01fb, B:101:0x0203, B:103:0x0209, B:105:0x0211, B:107:0x0219, B:109:0x021f, B:111:0x0225, B:113:0x022b, B:115:0x0233, B:118:0x023c, B:391:0x071b, B:120:0x026c, B:122:0x0272, B:124:0x027b, B:126:0x028a, B:128:0x0297, B:130:0x02ad, B:132:0x02b3, B:268:0x0537, B:134:0x02be, B:137:0x02ca, B:252:0x04e7, B:141:0x02e8, B:143:0x02f0, B:145:0x02f8, B:147:0x0300, B:152:0x030d, B:155:0x0326, B:157:0x032c, B:159:0x0339, B:179:0x03a0, B:181:0x03a6, B:183:0x03ac, B:185:0x03b4, B:187:0x03ba, B:190:0x03cd, B:192:0x03d3, B:194:0x03e0, B:214:0x0455, B:216:0x045d, B:230:0x0498, B:232:0x04a2, B:250:0x04da, B:195:0x03eb, B:196:0x03ec, B:197:0x03ed, B:198:0x03fa, B:201:0x0402, B:204:0x0410, B:206:0x0416, B:208:0x0421, B:209:0x0435, B:210:0x0436, B:211:0x0437, B:212:0x0444, B:160:0x0342, B:161:0x0343, B:162:0x0344, B:163:0x034c, B:166:0x0356, B:169:0x035f, B:171:0x0365, B:173:0x0370, B:174:0x0382, B:175:0x0383, B:176:0x0384, B:177:0x038d, B:255:0x04fa, B:257:0x0507, B:259:0x0512, B:261:0x0518, B:263:0x0524, B:273:0x0551, B:276:0x0574, B:321:0x062b, B:281:0x0597, B:284:0x05a0, B:366:0x06ab, B:298:0x05ca, B:304:0x05df, B:310:0x05f7, B:314:0x060e, B:318:0x0623, B:326:0x0642, B:355:0x0689, B:357:0x0695, B:359:0x069a, B:347:0x0674, B:69:0x0175, B:71:0x0181, B:74:0x018a, B:76:0x0190, B:78:0x019b, B:79:0x01a7, B:80:0x01a8, B:81:0x01a9, B:41:0x0109, B:43:0x0115, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:52:0x0132, B:58:0x014a, B:65:0x0160, B:61:0x0157, B:64:0x015f, B:370:0x06cc, B:372:0x06da, B:375:0x06de, B:377:0x06e8, B:379:0x06f2, B:383:0x06fb, B:381:0x06f8, B:386:0x0710, B:390:0x0718, B:396:0x0736), top: B:409:0x0009 }] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v83, types: [com.google.android.gms.internal.ads.zzaom, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v2, types: [com.google.android.gms.internal.ads.zzang] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v7, types: [com.google.android.gms.internal.ads.zzaoo, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.google.android.gms.internal.ads.zzaok] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzang zzb(byte[] bArr, int i, int i2) {
        ?? r18;
        String str;
        String str2;
        String str3;
        HashMap map;
        ArrayDeque arrayDeque;
        zzaoj zzaojVar;
        zzaop zzaopVar;
        int i3;
        ?? r16;
        ArrayDeque arrayDeque2;
        float f;
        zzaoj zzaojVar2;
        String strGroup;
        String strGroup2;
        int i4;
        boolean z;
        String strZzc;
        String strGroup3;
        ?? zzaokVar;
        ?? r162;
        String str4;
        zzaoj zzaojVar3;
        zzaoo zzaooVarZzd;
        String str5;
        long jZzg;
        String[] strArr;
        String strSubstring;
        zzaoi zzaoiVar;
        zzaoi zzaoiVar2;
        long j;
        zzaoi zzaoiVarZzb;
        Object obj;
        String str6;
        String str7;
        String str8;
        String strZzc2;
        String str9;
        String strZzL;
        String str10;
        HashMap map2;
        String str11;
        float f2;
        float f3;
        String strZzc3;
        float f4;
        float f5;
        String strZzc4;
        int i5;
        float f6;
        String strZzc5;
        int i6;
        ?? zzaomVar;
        String strZzc6;
        zzaoo zzaooVar;
        zzaoo zzaooVar2;
        String str12;
        String str13 = "";
        String str14 = "http://www.w3.org/ns/ttml#parameter";
        String str15 = "Ignoring unsupported tag: ";
        Object obj2 = null;
        try {
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = this.zzi.newPullParser();
                    HashMap map3 = new HashMap();
                    HashMap map4 = new HashMap();
                    HashMap map5 = new HashMap();
                    map4.put("", new zzaom("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
                    xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
                    ArrayDeque arrayDeque3 = new ArrayDeque();
                    int eventType = xmlPullParserNewPullParser.getEventType();
                    zzaoj zzaojVar4 = zzh;
                    zzaop zzaopVar2 = null;
                    ?? r163 = 0;
                    zzaoj zzaojVar5 = zzaojVar4;
                    int i7 = 0;
                    int i8 = 15;
                    while (eventType != 1) {
                        zzaoi zzaoiVar3 = (zzaoi) arrayDeque3.peek();
                        ?? r182 = obj2;
                        if (i7 == 0) {
                            String name = xmlPullParserNewPullParser.getName();
                            str = str13;
                            if (eventType == 2) {
                                zzaopVar = zzaopVar2;
                                if ("tt".equals(name)) {
                                    try {
                                        String attributeValue = xmlPullParserNewPullParser.getAttributeValue(str14, "frameRate");
                                        int i9 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
                                        String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(str14, "frameRateMultiplier");
                                        if (attributeValue2 != null) {
                                            i3 = i7;
                                            String str16 = zzfl.zza;
                                            arrayDeque2 = arrayDeque3;
                                            zzgtj.zzb(attributeValue2.split(" ", -1).length == 2, "frameRateMultiplier doesn't have 2 parts");
                                            f = Integer.parseInt(r9[0]) / Integer.parseInt(r9[1]);
                                        } else {
                                            arrayDeque2 = arrayDeque3;
                                            i3 = i7;
                                            f = 1.0f;
                                        }
                                        int i10 = zzaojVar4.zzb;
                                        String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(str14, "subFrameRate");
                                        if (attributeValue3 != null) {
                                            i10 = Integer.parseInt(attributeValue3);
                                        }
                                        int i11 = zzaojVar4.zzc;
                                        zzaojVar = zzaojVar4;
                                        String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(str14, "tickRate");
                                        if (attributeValue4 != null) {
                                            i11 = Integer.parseInt(attributeValue4);
                                        }
                                        zzaoj zzaojVar6 = new zzaoj(i9 * f, i10, i11);
                                        String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(str14, "cellResolution");
                                        if (attributeValue5 == null) {
                                            str2 = str14;
                                            zzaojVar2 = zzaojVar6;
                                            i8 = 15;
                                            strZzc = zzft.zzc(xmlPullParserNewPullParser, "extent");
                                            if (strZzc != null) {
                                                zzaokVar = r182;
                                                zzaojVar5 = zzaojVar2;
                                                r162 = zzaokVar;
                                            } else {
                                                Matcher matcher = zzf.matcher(strZzc);
                                                if (matcher.matches()) {
                                                    try {
                                                        strGroup3 = matcher.group(1);
                                                    } catch (NumberFormatException unused) {
                                                        zzeg.zzc("TtmlParser", "Ignoring malformed tts extent: ".concat(strZzc));
                                                        zzaokVar = r182;
                                                    }
                                                    if (strGroup3 == null) {
                                                        throw r182;
                                                    }
                                                    int i12 = Integer.parseInt(strGroup3);
                                                    String strGroup4 = matcher.group(2);
                                                    if (strGroup4 == null) {
                                                        throw r182;
                                                    }
                                                    zzaokVar = new zzaok(i12, Integer.parseInt(strGroup4));
                                                    zzaojVar5 = zzaojVar2;
                                                    r162 = zzaokVar;
                                                } else {
                                                    zzeg.zzc("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZzc));
                                                }
                                                zzaokVar = r182;
                                                zzaojVar5 = zzaojVar2;
                                                r162 = zzaokVar;
                                            }
                                        } else {
                                            Matcher matcher2 = zzg.matcher(attributeValue5);
                                            if (matcher2.matches()) {
                                                try {
                                                    strGroup = matcher2.group(1);
                                                } catch (NumberFormatException unused2) {
                                                    str2 = str14;
                                                }
                                                if (strGroup == null) {
                                                    throw r182;
                                                }
                                                int i13 = Integer.parseInt(strGroup);
                                                str2 = str14;
                                                try {
                                                    strGroup2 = matcher2.group(2);
                                                } catch (NumberFormatException unused3) {
                                                    zzaojVar2 = zzaojVar6;
                                                    zzeg.zzc("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                                    i8 = 15;
                                                    strZzc = zzft.zzc(xmlPullParserNewPullParser, "extent");
                                                    if (strZzc != null) {
                                                    }
                                                    xmlPullParserNewPullParser.next();
                                                    eventType = xmlPullParserNewPullParser.getEventType();
                                                    arrayDeque3 = arrayDeque;
                                                    map5 = map;
                                                    str13 = str;
                                                    zzaojVar4 = zzaojVar;
                                                    str14 = str2;
                                                    str15 = str3;
                                                    obj2 = null;
                                                    r163 = r163;
                                                }
                                                if (strGroup2 == null) {
                                                    throw r182;
                                                }
                                                int i14 = Integer.parseInt(strGroup2);
                                                if (i13 == 0) {
                                                    i4 = i14;
                                                    zzaojVar2 = zzaojVar6;
                                                    z = false;
                                                } else if (i14 != 0) {
                                                    i4 = i14;
                                                    zzaojVar2 = zzaojVar6;
                                                    z = true;
                                                } else {
                                                    z = false;
                                                    i4 = 0;
                                                    zzaojVar2 = zzaojVar6;
                                                }
                                                try {
                                                    zzgtj.zzg(z, "Invalid cell resolution %s %s", i13, i4);
                                                    i8 = i4;
                                                } catch (NumberFormatException unused4) {
                                                    zzeg.zzc("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                                    i8 = 15;
                                                }
                                                strZzc = zzft.zzc(xmlPullParserNewPullParser, "extent");
                                                if (strZzc != null) {
                                                }
                                            } else {
                                                zzeg.zzc("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                                str2 = str14;
                                                zzaojVar2 = zzaojVar6;
                                                i8 = 15;
                                                strZzc = zzft.zzc(xmlPullParserNewPullParser, "extent");
                                                if (strZzc != null) {
                                                }
                                            }
                                        }
                                        xmlPullParserNewPullParser.next();
                                        eventType = xmlPullParserNewPullParser.getEventType();
                                        arrayDeque3 = arrayDeque;
                                        map5 = map;
                                        str13 = str;
                                        zzaojVar4 = zzaojVar;
                                        str14 = str2;
                                        str15 = str3;
                                        obj2 = null;
                                        r163 = r163;
                                    } catch (XmlPullParserException e) {
                                        e = e;
                                        r18 = r182;
                                        Types$$ExternalSyntheticBUOutline0.m("Unable to decode source", e);
                                        return r18;
                                    }
                                } else {
                                    str2 = str14;
                                    arrayDeque2 = arrayDeque3;
                                    zzaojVar = zzaojVar4;
                                    i3 = i7;
                                    r162 = r163;
                                }
                                ?? r2 = r162;
                                int i15 = i8;
                                String str17 = "image";
                                String str18 = "metadata";
                                String str19 = "region";
                                String str20 = "head";
                                zzaoj zzaojVar7 = zzaojVar5;
                                if (name.equals("tt") || name.equals("head") || name.equals(SDKConstants.PARAM_A2U_BODY) || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("image") || name.equals("data") || name.equals("information")) {
                                    if ("head".equals(name)) {
                                        while (true) {
                                            xmlPullParserNewPullParser.next();
                                            if (zzft.zzb(xmlPullParserNewPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                                                String strZzc7 = zzft.zzc(xmlPullParserNewPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                                                zzaoo zzaooVarZzd2 = zzd(xmlPullParserNewPullParser, new zzaoo());
                                                if (strZzc7 != null) {
                                                    String[] strArrZzc = zzc(strZzc7);
                                                    str3 = str15;
                                                    str12 = str20;
                                                    int i16 = 0;
                                                    for (int length = strArrZzc.length; i16 < length; length = length) {
                                                        zzaooVarZzd2.zzr((zzaoo) map3.get(strArrZzc[i16]));
                                                        i16++;
                                                    }
                                                } else {
                                                    str3 = str15;
                                                    str12 = str20;
                                                }
                                                String strZzt = zzaooVarZzd2.zzt();
                                                if (strZzt != null) {
                                                    map3.put(strZzt, zzaooVarZzd2);
                                                }
                                                str8 = str12;
                                                map = map5;
                                                str6 = str18;
                                                str7 = str19;
                                            } else {
                                                str3 = str15;
                                                String str21 = str20;
                                                if (zzft.zzb(xmlPullParserNewPullParser, str19)) {
                                                    str7 = str19;
                                                    HashMap map6 = map5;
                                                    String strZzc8 = zzft.zzc(xmlPullParserNewPullParser, "id");
                                                    if (strZzc8 == null) {
                                                        str10 = str17;
                                                        map2 = map4;
                                                        str11 = str18;
                                                    } else {
                                                        String strZzc9 = zzft.zzc(xmlPullParserNewPullParser, "origin");
                                                        if (strZzc9 == null) {
                                                            str9 = strZzc9;
                                                            String strZzc10 = zzft.zzc(xmlPullParserNewPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                                                            if (strZzc10 != null && (zzaooVar2 = (zzaoo) map3.get(strZzc10)) != null) {
                                                                strZzL = zzaooVar2.zzL();
                                                            }
                                                            if (strZzL == null) {
                                                                str10 = str17;
                                                                Matcher matcher3 = zzb.matcher(strZzL);
                                                                str11 = str18;
                                                                Matcher matcher4 = zzf.matcher(strZzL);
                                                                if (matcher3.matches()) {
                                                                    map2 = map4;
                                                                    try {
                                                                        String strGroup5 = matcher3.group(1);
                                                                        if (strGroup5 == null) {
                                                                            throw r182;
                                                                        }
                                                                        float f7 = Float.parseFloat(strGroup5) / 100.0f;
                                                                        String strGroup6 = matcher3.group(2);
                                                                        if (strGroup6 == null) {
                                                                            throw r182;
                                                                        }
                                                                        f2 = Float.parseFloat(strGroup6) / 100.0f;
                                                                        f3 = f7;
                                                                    } catch (NumberFormatException unused5) {
                                                                        zzeg.zzc("TtmlParser", "Ignoring region with malformed origin: ".concat(strZzL));
                                                                    }
                                                                } else {
                                                                    map2 = map4;
                                                                    if (!matcher4.matches()) {
                                                                        zzeg.zzc("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZzL));
                                                                    } else if (r2 == 0) {
                                                                        zzeg.zzc("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZzL));
                                                                    } else {
                                                                        try {
                                                                            String strGroup7 = matcher4.group(1);
                                                                            if (strGroup7 == null) {
                                                                                throw r182;
                                                                            }
                                                                            int i17 = Integer.parseInt(strGroup7);
                                                                            String strGroup8 = matcher4.group(2);
                                                                            if (strGroup8 == null) {
                                                                                throw r182;
                                                                            }
                                                                            f2 = Integer.parseInt(strGroup8) / r2.zzb;
                                                                            f3 = i17 / r2.zza;
                                                                        } catch (NumberFormatException unused6) {
                                                                            zzeg.zzc("TtmlParser", "Ignoring region with malformed origin: ".concat(strZzL));
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                str10 = str17;
                                                                map2 = map4;
                                                                str11 = str18;
                                                                f2 = 0.0f;
                                                                f3 = 0.0f;
                                                            }
                                                            strZzc3 = zzft.zzc(xmlPullParserNewPullParser, "extent");
                                                            if (strZzc3 == null && (strZzc6 = zzft.zzc(xmlPullParserNewPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) != null && (zzaooVar = (zzaoo) map3.get(strZzc6)) != null) {
                                                                strZzc3 = zzaooVar.zzN();
                                                            }
                                                            if (strZzc3 == null) {
                                                                Matcher matcher5 = zzb.matcher(strZzc3);
                                                                Matcher matcher6 = zzf.matcher(strZzc3);
                                                                if (matcher5.matches()) {
                                                                    try {
                                                                        String strGroup9 = matcher5.group(1);
                                                                        if (strGroup9 == null) {
                                                                            throw r182;
                                                                        }
                                                                        float f8 = Float.parseFloat(strGroup9) / 100.0f;
                                                                        String strGroup10 = matcher5.group(2);
                                                                        if (strGroup10 == null) {
                                                                            throw r182;
                                                                        }
                                                                        f4 = f8;
                                                                        f5 = Float.parseFloat(strGroup10) / 100.0f;
                                                                    } catch (NumberFormatException unused7) {
                                                                        zzeg.zzc("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(strZzL)));
                                                                        zzaomVar = r182;
                                                                    }
                                                                } else if (!matcher6.matches()) {
                                                                    zzeg.zzc("TtmlParser", "Ignoring region with unsupported extent: ".concat(String.valueOf(strZzL)));
                                                                } else if (r2 == 0) {
                                                                    zzeg.zzc("TtmlParser", "Ignoring region with missing tts:extent: ".concat(String.valueOf(strZzL)));
                                                                } else {
                                                                    try {
                                                                        String strGroup11 = matcher6.group(1);
                                                                        if (strGroup11 == null) {
                                                                            throw r182;
                                                                        }
                                                                        int i18 = Integer.parseInt(strGroup11);
                                                                        String strGroup12 = matcher6.group(2);
                                                                        if (strGroup12 == null) {
                                                                            throw r182;
                                                                        }
                                                                        f5 = Integer.parseInt(strGroup12) / r2.zzb;
                                                                        f4 = i18 / r2.zza;
                                                                    } catch (NumberFormatException unused8) {
                                                                        zzeg.zzc("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(strZzL)));
                                                                        zzaomVar = r182;
                                                                    }
                                                                }
                                                                if (zzaomVar != 0) {
                                                                    map4 = map2;
                                                                    map4.put(zzaomVar.zza, zzaomVar);
                                                                } else {
                                                                    map4 = map2;
                                                                }
                                                                str8 = str21;
                                                                map = map6;
                                                                str17 = str10;
                                                                str6 = str11;
                                                            } else {
                                                                f4 = 1.0f;
                                                                f5 = 1.0f;
                                                            }
                                                            strZzc4 = zzft.zzc(xmlPullParserNewPullParser, "displayAlign");
                                                            if (strZzc4 == null) {
                                                                String strZza = zzgss.zza(strZzc4);
                                                                int iHashCode = strZza.hashCode();
                                                                if (iHashCode != -1364013995) {
                                                                    if (iHashCode == 92734940 && strZza.equals("after")) {
                                                                        f6 = f2 + f5;
                                                                        i5 = 2;
                                                                    } else {
                                                                        i5 = 0;
                                                                        f6 = f2;
                                                                    }
                                                                    float f9 = 1.0f / i15;
                                                                    strZzc5 = zzft.zzc(xmlPullParserNewPullParser, "writingMode");
                                                                    if (strZzc5 == null) {
                                                                        String strZza2 = zzgss.zza(strZzc5);
                                                                        int iHashCode2 = strZza2.hashCode();
                                                                        if (iHashCode2 != 3694) {
                                                                            if (iHashCode2 != 3553396) {
                                                                                if (iHashCode2 == 3553576 && strZza2.equals("tbrl")) {
                                                                                    i6 = 1;
                                                                                }
                                                                            } else if (strZza2.equals("tblr")) {
                                                                                i6 = 2;
                                                                            }
                                                                            i6 = Integer.MIN_VALUE;
                                                                        } else if (!strZza2.equals("tb")) {
                                                                            i6 = Integer.MIN_VALUE;
                                                                        }
                                                                        zzaomVar = new zzaom(strZzc8, f3, f6, 0, i5, f4, f5, 1, f9, i6);
                                                                        if (zzaomVar != 0) {
                                                                        }
                                                                        str8 = str21;
                                                                        map = map6;
                                                                        str17 = str10;
                                                                        str6 = str11;
                                                                    }
                                                                } else {
                                                                    if (strZza.equals("center")) {
                                                                        f6 = f2 + (f5 / 2.0f);
                                                                        i5 = 1;
                                                                    }
                                                                    float f92 = 1.0f / i15;
                                                                    strZzc5 = zzft.zzc(xmlPullParserNewPullParser, "writingMode");
                                                                    if (strZzc5 == null) {
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            str9 = strZzc9;
                                                        }
                                                        strZzL = str9;
                                                        if (strZzL == null) {
                                                        }
                                                        strZzc3 = zzft.zzc(xmlPullParserNewPullParser, "extent");
                                                        if (strZzc3 == null) {
                                                            strZzc3 = zzaooVar.zzN();
                                                        }
                                                        if (strZzc3 == null) {
                                                        }
                                                        strZzc4 = zzft.zzc(xmlPullParserNewPullParser, "displayAlign");
                                                        if (strZzc4 == null) {
                                                        }
                                                    }
                                                    zzaomVar = r182;
                                                    if (zzaomVar != 0) {
                                                    }
                                                    str8 = str21;
                                                    map = map6;
                                                    str17 = str10;
                                                    str6 = str11;
                                                } else {
                                                    String str22 = str17;
                                                    HashMap map7 = map5;
                                                    str6 = str18;
                                                    str7 = str19;
                                                    if (zzft.zzb(xmlPullParserNewPullParser, str6)) {
                                                        while (true) {
                                                            xmlPullParserNewPullParser.next();
                                                            str17 = str22;
                                                            if (!zzft.zzb(xmlPullParserNewPullParser, str17) || (strZzc2 = zzft.zzc(xmlPullParserNewPullParser, "id")) == null) {
                                                                map = map7;
                                                            } else {
                                                                map = map7;
                                                                map.put(strZzc2, xmlPullParserNewPullParser.nextText());
                                                            }
                                                            if (!zzft.zza(xmlPullParserNewPullParser, str6)) {
                                                                str22 = str17;
                                                                map7 = map;
                                                            }
                                                        }
                                                    } else {
                                                        map = map7;
                                                        str17 = str22;
                                                    }
                                                    str8 = str21;
                                                }
                                            }
                                            if (zzft.zza(xmlPullParserNewPullParser, str8)) {
                                                zzaojVar3 = zzaojVar7;
                                                arrayDeque = arrayDeque2;
                                            } else {
                                                str18 = str6;
                                                str20 = str8;
                                                map5 = map;
                                                str19 = str7;
                                                str15 = str3;
                                            }
                                        }
                                    } else {
                                        str3 = str15;
                                        map = map5;
                                        Object obj3 = "region";
                                        try {
                                            int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                            zzaooVarZzd = zzd(xmlPullParserNewPullParser, r182);
                                            int i19 = 0;
                                            str5 = str;
                                            long jZzg2 = -9223372036854775807L;
                                            jZzg = -9223372036854775807L;
                                            long jZzg3 = -9223372036854775807L;
                                            strArr = null;
                                            strSubstring = null;
                                            while (i19 < attributeCount) {
                                                try {
                                                    String attributeName = xmlPullParserNewPullParser.getAttributeName(i19);
                                                    String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(i19);
                                                    switch (attributeName.hashCode()) {
                                                        case -934795532:
                                                            zzaojVar3 = zzaojVar7;
                                                            obj = obj3;
                                                            if (attributeName.equals(obj) && map4.containsKey(attributeValue6)) {
                                                                str5 = attributeValue6;
                                                            }
                                                            try {
                                                                i19++;
                                                                obj3 = obj;
                                                                zzaojVar7 = zzaojVar3;
                                                            } catch (zzanh e2) {
                                                                e = e2;
                                                                str4 = "TtmlParser";
                                                                arrayDeque = arrayDeque2;
                                                                zzeg.zzd(str4, "Suppressing parser error", e);
                                                                r163 = r2;
                                                                i8 = i15;
                                                                zzaojVar5 = zzaojVar3;
                                                                zzaopVar2 = zzaopVar;
                                                                i7 = 1;
                                                                xmlPullParserNewPullParser.next();
                                                                eventType = xmlPullParserNewPullParser.getEventType();
                                                                arrayDeque3 = arrayDeque;
                                                                map5 = map;
                                                                str13 = str;
                                                                zzaojVar4 = zzaojVar;
                                                                str14 = str2;
                                                                str15 = str3;
                                                                obj2 = null;
                                                                r163 = r163;
                                                            }
                                                            break;
                                                        case 99841:
                                                            zzaojVar3 = zzaojVar7;
                                                            if (attributeName.equals("dur")) {
                                                                jZzg3 = zzg(attributeValue6, zzaojVar3);
                                                            }
                                                            obj = obj3;
                                                            i19++;
                                                            obj3 = obj;
                                                            zzaojVar7 = zzaojVar3;
                                                            break;
                                                        case 100571:
                                                            zzaojVar3 = zzaojVar7;
                                                            if (attributeName.equals("end")) {
                                                                jZzg2 = zzg(attributeValue6, zzaojVar3);
                                                            }
                                                            obj = obj3;
                                                            i19++;
                                                            obj3 = obj;
                                                            zzaojVar7 = zzaojVar3;
                                                            break;
                                                        case 93616297:
                                                            if (attributeName.equals("begin")) {
                                                                zzaojVar3 = zzaojVar7;
                                                                jZzg = zzg(attributeValue6, zzaojVar3);
                                                            } else {
                                                                zzaojVar3 = zzaojVar7;
                                                            }
                                                            obj = obj3;
                                                            i19++;
                                                            obj3 = obj;
                                                            zzaojVar7 = zzaojVar3;
                                                            break;
                                                        case 109780401:
                                                            if (attributeName.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                                                                String[] strArrZzc2 = zzc(attributeValue6);
                                                                if (strArrZzc2.length > 0) {
                                                                    strArr = strArrZzc2;
                                                                }
                                                            }
                                                            zzaojVar3 = zzaojVar7;
                                                            obj = obj3;
                                                            i19++;
                                                            obj3 = obj;
                                                            zzaojVar7 = zzaojVar3;
                                                            break;
                                                        case 1292595405:
                                                            if (attributeName.equals("backgroundImage")) {
                                                                try {
                                                                    if (attributeValue6.startsWith("#")) {
                                                                        strSubstring = attributeValue6.substring(1);
                                                                    }
                                                                    zzaojVar3 = zzaojVar7;
                                                                    obj = obj3;
                                                                    i19++;
                                                                    obj3 = obj;
                                                                    zzaojVar7 = zzaojVar3;
                                                                } catch (zzanh e3) {
                                                                    e = e3;
                                                                    str4 = "TtmlParser";
                                                                    zzaojVar3 = zzaojVar7;
                                                                    arrayDeque = arrayDeque2;
                                                                    zzeg.zzd(str4, "Suppressing parser error", e);
                                                                    r163 = r2;
                                                                    i8 = i15;
                                                                    zzaojVar5 = zzaojVar3;
                                                                    zzaopVar2 = zzaopVar;
                                                                    i7 = 1;
                                                                    xmlPullParserNewPullParser.next();
                                                                    eventType = xmlPullParserNewPullParser.getEventType();
                                                                    arrayDeque3 = arrayDeque;
                                                                    map5 = map;
                                                                    str13 = str;
                                                                    zzaojVar4 = zzaojVar;
                                                                    str14 = str2;
                                                                    str15 = str3;
                                                                    obj2 = null;
                                                                    r163 = r163;
                                                                }
                                                                break;
                                                            }
                                                            break;
                                                        default:
                                                            zzaojVar3 = zzaojVar7;
                                                            obj = obj3;
                                                            i19++;
                                                            obj3 = obj;
                                                            zzaojVar7 = zzaojVar3;
                                                            break;
                                                    }
                                                } catch (zzanh e4) {
                                                    e = e4;
                                                    zzaojVar3 = zzaojVar7;
                                                }
                                            }
                                            zzaojVar3 = zzaojVar7;
                                            if (zzaoiVar3 != null) {
                                                zzaoiVar = zzaoiVar3;
                                                long j2 = zzaoiVar.zzd;
                                                if (j2 != -9223372036854775807L) {
                                                    jZzg = jZzg != -9223372036854775807L ? jZzg + j2 : -9223372036854775807L;
                                                    jZzg2 = jZzg2 != -9223372036854775807L ? jZzg2 + j2 : -9223372036854775807L;
                                                }
                                                zzaoiVar2 = zzaoiVar;
                                            } else {
                                                zzaoiVar = zzaoiVar3;
                                                zzaoiVar2 = null;
                                            }
                                            if (jZzg2 != -9223372036854775807L) {
                                                str4 = "TtmlParser";
                                                j = jZzg2;
                                            } else if (jZzg3 != -9223372036854775807L) {
                                                str4 = "TtmlParser";
                                                j = jZzg + jZzg3;
                                            } else {
                                                if (zzaoiVar2 != null) {
                                                    str4 = "TtmlParser";
                                                    long j3 = zzaoiVar2.zze;
                                                    if (j3 != -9223372036854775807L) {
                                                        j = j3;
                                                    }
                                                } else {
                                                    str4 = "TtmlParser";
                                                }
                                                j = -9223372036854775807L;
                                            }
                                        } catch (zzanh e5) {
                                            e = e5;
                                        }
                                        try {
                                            zzaoiVarZzb = zzaoi.zzb(xmlPullParserNewPullParser.getName(), jZzg, j, zzaooVarZzd, strArr, str5, strSubstring, zzaoiVar2);
                                            arrayDeque = arrayDeque2;
                                        } catch (zzanh e6) {
                                            e = e6;
                                            arrayDeque = arrayDeque2;
                                            zzeg.zzd(str4, "Suppressing parser error", e);
                                            r163 = r2;
                                            i8 = i15;
                                            zzaojVar5 = zzaojVar3;
                                            zzaopVar2 = zzaopVar;
                                            i7 = 1;
                                            xmlPullParserNewPullParser.next();
                                            eventType = xmlPullParserNewPullParser.getEventType();
                                            arrayDeque3 = arrayDeque;
                                            map5 = map;
                                            str13 = str;
                                            zzaojVar4 = zzaojVar;
                                            str14 = str2;
                                            str15 = str3;
                                            obj2 = null;
                                            r163 = r163;
                                        }
                                        try {
                                            arrayDeque.push(zzaoiVarZzb);
                                            if (zzaoiVar != null) {
                                                zzaoiVar.zzd(zzaoiVarZzb);
                                            }
                                        } catch (zzanh e7) {
                                            e = e7;
                                            zzeg.zzd(str4, "Suppressing parser error", e);
                                            r163 = r2;
                                            i8 = i15;
                                            zzaojVar5 = zzaojVar3;
                                            zzaopVar2 = zzaopVar;
                                            i7 = 1;
                                        }
                                    }
                                    r16 = r2;
                                    i8 = i15;
                                    zzaojVar5 = zzaojVar3;
                                } else {
                                    String name2 = xmlPullParserNewPullParser.getName();
                                    StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 26);
                                    sb.append(str15);
                                    sb.append(name2);
                                    zzeg.zzb("TtmlParser", sb.toString());
                                    str3 = str15;
                                    map = map5;
                                    i8 = i15;
                                    zzaojVar5 = zzaojVar7;
                                    zzaopVar2 = zzaopVar;
                                    arrayDeque = arrayDeque2;
                                    i7 = 1;
                                    r163 = r2;
                                }
                                xmlPullParserNewPullParser.next();
                                eventType = xmlPullParserNewPullParser.getEventType();
                                arrayDeque3 = arrayDeque;
                                map5 = map;
                                str13 = str;
                                zzaojVar4 = zzaojVar;
                                str14 = str2;
                                str15 = str3;
                                obj2 = null;
                                r163 = r163;
                            } else {
                                str2 = str14;
                                str3 = str15;
                                map = map5;
                                arrayDeque = arrayDeque3;
                                zzaojVar = zzaojVar4;
                                zzaopVar = zzaopVar2;
                                i3 = i7;
                                if (eventType != 4) {
                                    r16 = r163;
                                    if (eventType == 3) {
                                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                                            zzaoi zzaoiVar4 = (zzaoi) arrayDeque.peek();
                                            if (zzaoiVar4 == null) {
                                                throw null;
                                            }
                                            zzaopVar2 = new zzaop(zzaoiVar4, map3, map4, map);
                                        } else {
                                            zzaopVar2 = zzaopVar;
                                        }
                                        arrayDeque.pop();
                                        r163 = r163;
                                    }
                                } else {
                                    if (zzaoiVar3 == null) {
                                        throw null;
                                    }
                                    zzaoiVar3.zzd(zzaoi.zza(xmlPullParserNewPullParser.getText()));
                                    r16 = r163;
                                }
                            }
                            zzaopVar2 = zzaopVar;
                            r163 = r16;
                        } else {
                            str = str13;
                            str2 = str14;
                            str3 = str15;
                            map = map5;
                            arrayDeque = arrayDeque3;
                            zzaojVar = zzaojVar4;
                            zzaopVar = zzaopVar2;
                            i3 = i7;
                            if (eventType == 2) {
                                i7 = i3 + 1;
                            } else {
                                r16 = r163;
                                if (eventType == 3) {
                                    i7 = i3 - 1;
                                }
                                zzaopVar2 = zzaopVar;
                                r163 = r16;
                            }
                            zzaopVar2 = zzaopVar;
                            xmlPullParserNewPullParser.next();
                            eventType = xmlPullParserNewPullParser.getEventType();
                            arrayDeque3 = arrayDeque;
                            map5 = map;
                            str13 = str;
                            zzaojVar4 = zzaojVar;
                            str14 = str2;
                            str15 = str3;
                            obj2 = null;
                            r163 = r163;
                        }
                        i7 = i3;
                        xmlPullParserNewPullParser.next();
                        eventType = xmlPullParserNewPullParser.getEventType();
                        arrayDeque3 = arrayDeque;
                        map5 = map;
                        str13 = str;
                        zzaojVar4 = zzaojVar;
                        str14 = str2;
                        str15 = str3;
                        obj2 = null;
                        r163 = r163;
                    }
                    zzaop zzaopVar3 = zzaopVar2;
                    if (zzaopVar3 != null) {
                        return zzaopVar3;
                    }
                    throw null;
                } catch (XmlPullParserException e8) {
                    e = e8;
                    r18 = 0;
                }
            } catch (IOException e9) {
                Types$$ExternalSyntheticBUOutline0.m("Unexpected error when reading input.", e9);
                return null;
            }
        } catch (XmlPullParserException e10) {
            e = e10;
            r18 = 0;
        }
    }
}
