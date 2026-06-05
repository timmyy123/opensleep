package com.google.android.gms.internal.ads;

import android.R;
import android.util.Pair;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mp4parser.boxes.sampleentry.AudioSampleEntry;
import org.mp4parser.boxes.sampleentry.VisualSampleEntry;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzdq {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", "A", "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    public static zzgwm zza(byte b, byte b2, byte b3, byte b4) {
        return zzgwm.zzj(new byte[]{1, 1, b, 2, 1, b2, 3, 1, b3, 4, 1, b4});
    }

    public static String zzb(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String zzc(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        int i5;
        Object[] objArr = {zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)};
        String str = zzfl.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i6 = 6;
        while (true) {
            if (i6 <= 0) {
                break;
            }
            int i7 = i6 - 1;
            if (iArr[i7] != 0) {
                break;
            }
            i6 = i7;
        }
        for (i5 = 0; i5 < i6; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static String zzd(byte[] bArr) {
        int length = bArr.length;
        zzgtj.zzd(length >= 17, "Invalid APV CSD length: %s", length);
        byte b = bArr[0];
        zzgtj.zzd(b == 1, "Invalid APV CSD version: %s", b);
        byte b2 = bArr[5];
        byte b3 = bArr[6];
        byte b4 = bArr[7];
        String str = zzfl.zza;
        Locale locale = Locale.US;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(b2, b3, "apv1.apvf", ".apvl", ".apvb");
        sbM.append((int) b4);
        return sbM.toString();
    }

    public static Pair zze(zzv zzvVar) {
        zzdp zzdpVarZzf = zzf(zzvVar);
        if (zzdpVarZzf == null || !zzdpVarZzf.zzc()) {
            return null;
        }
        return new Pair(Integer.valueOf(zzdpVarZzf.zza()), Integer.valueOf(zzdpVarZzf.zzb()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x067b, code lost:
    
        if (r3.equals(org.mp4parser.boxes.sampleentry.VisualSampleEntry.TYPE6) != false) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0684, code lost:
    
        if (r3.equals(org.mp4parser.boxes.sampleentry.VisualSampleEntry.TYPE7) != false) goto L418;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:111:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x06a4 A[PHI: r2
      0x06a4: PHI (r2v14 int) = (r2v13 int), (r2v17 int) binds: [B:424:0x06a2, B:421:0x0697] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x0929  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzdp zzf(zzv zzvVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Integer numValueOf;
        Integer num;
        Integer num2;
        int i12 = 8;
        String str = zzvVar.zzk;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        int i13 = 3;
        if ("video/dolby-vision".equals(zzvVar.zzp)) {
            if (strArrSplit.length < 3) {
                zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
                return null;
            }
            Matcher matcher = zzd.matcher(strArrSplit[1]);
            if (!matcher.matches()) {
                zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
                return null;
            }
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int iHashCode = strGroup.hashCode();
            if (iHashCode != 1567) {
                switch (iHashCode) {
                    case 1536:
                        num = !strGroup.equals("00") ? null : 1;
                        break;
                    case 1537:
                        num = !strGroup.equals("01") ? null : 2;
                        break;
                    case 1538:
                        num = !strGroup.equals("02") ? null : 4;
                        break;
                    case 1539:
                        num = !strGroup.equals("03") ? null : 8;
                        break;
                    case 1540:
                        num = !strGroup.equals("04") ? null : 16;
                        break;
                    case 1541:
                        num = !strGroup.equals("05") ? null : 32;
                        break;
                    case 1542:
                        num = !strGroup.equals("06") ? null : 64;
                        break;
                    case 1543:
                        num = !strGroup.equals("07") ? null : 128;
                        break;
                    case 1544:
                        num = !strGroup.equals("08") ? null : 256;
                        break;
                    case 1545:
                        num = !strGroup.equals("09") ? null : 512;
                        break;
                    default:
                        num = null;
                        break;
                }
            } else {
                num = strGroup.equals("10") ? 1024 : null;
            }
            if (num == null) {
                zzeg.zzc("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: ".concat(strGroup));
                return zzdp.zza;
            }
            String str2 = strArrSplit[2];
            int iHashCode2 = str2.hashCode();
            switch (iHashCode2) {
                case 1537:
                    num2 = !str2.equals("01") ? null : 1;
                    break;
                case 1538:
                    num2 = !str2.equals("02") ? null : 2;
                    break;
                case 1539:
                    num2 = !str2.equals("03") ? null : 4;
                    break;
                case 1540:
                    num2 = !str2.equals("04") ? null : 8;
                    break;
                case 1541:
                    num2 = !str2.equals("05") ? null : 16;
                    break;
                case 1542:
                    num2 = !str2.equals("06") ? null : 32;
                    break;
                case 1543:
                    num2 = !str2.equals("07") ? null : 64;
                    break;
                case 1544:
                    num2 = !str2.equals("08") ? null : 128;
                    break;
                case 1545:
                    num2 = !str2.equals("09") ? null : 256;
                    break;
                default:
                    switch (iHashCode2) {
                        case 1567:
                            num2 = !str2.equals("10") ? null : 512;
                            break;
                        case 1568:
                            num2 = !str2.equals("11") ? null : 1024;
                            break;
                        case 1569:
                            num2 = !str2.equals("12") ? null : 2048;
                            break;
                        case 1570:
                            num2 = !str2.equals("13") ? null : 4096;
                            break;
                        default:
                            num2 = null;
                            break;
                    }
                    break;
            }
            if (num2 != null) {
                return new zzdp(num.intValue(), num2.intValue());
            }
            zzeg.zzc("CodecSpecificDataUtil", "Unknown Dolby Vision level string: ".concat(str2));
            return null;
        }
        String str3 = strArrSplit[0];
        switch (str3.hashCode()) {
            case 2986313:
                if (str3.equals("ac-4")) {
                    String str4 = zzvVar.zzk;
                    if (strArrSplit.length != 4) {
                        zzba$$ExternalSyntheticOutline0.m(str4, "Ignoring malformed AC-4 codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            int i14 = Integer.parseInt(strArrSplit[1]);
                            int i15 = Integer.parseInt(strArrSplit[2]);
                            int i16 = Integer.parseInt(strArrSplit[3]);
                            if (i14 != 0) {
                                if (i14 != 1) {
                                    if (i14 == 2) {
                                        i = i15 == 1 ? 1026 : i15 == 2 ? 1028 : -1;
                                    }
                                } else if (i15 == 0) {
                                    i = 513;
                                } else if (i15 == 1) {
                                    i = 514;
                                }
                            } else if (i15 == 0) {
                                i = 257;
                            }
                            if (i != -1) {
                                if (i16 != 0) {
                                    if (i16 == 1) {
                                        i2 = 2;
                                    } else if (i16 == 2) {
                                        i2 = 4;
                                    } else if (i16 != 3) {
                                        i12 = i16 != 4 ? -1 : 16;
                                    }
                                    i12 = i2;
                                } else {
                                    i12 = 1;
                                }
                                if (i12 == -1) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i16).length() + 20), "Unknown AC-4 level: ", i16, "CodecSpecificDataUtil");
                                }
                            } else {
                                zzeg.zzc("CodecSpecificDataUtil", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i14).length() + 23 + String.valueOf(i15).length()), i14, "Unknown AC-4 profile: ", i15, "."));
                            }
                        } catch (NumberFormatException unused) {
                            zzba$$ExternalSyntheticOutline0.m(str4, "Ignoring malformed AC-4 codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3001066:
                if (str3.equals("apv1")) {
                    String str5 = zzvVar.zzk;
                    if (strArrSplit.length < 4) {
                        zzba$$ExternalSyntheticOutline0.m(str5, "Ignoring malformed APV codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            int i17 = Integer.parseInt(strArrSplit[1].substring(4));
                            int i18 = Integer.parseInt(strArrSplit[2].substring(4));
                            int i19 = Integer.parseInt(strArrSplit[3].substring(4));
                            if (i17 != 33) {
                                if (i17 != 44) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i17).length() + 26), "Unrecognized APV profile: ", i17, "CodecSpecificDataUtil");
                                } else {
                                    i = 8192;
                                }
                            }
                            int iZzi = zzi(i18, i19);
                            if (iZzi != -1) {
                            }
                        } catch (NumberFormatException e) {
                            zzeg.zzd("CodecSpecificDataUtil", "Ignoring malformed APV codec string: ".concat(String.valueOf(str5)), e);
                            return null;
                        }
                    }
                }
                break;
            case 3004662:
                if (str3.equals("av01")) {
                    String str6 = zzvVar.zzk;
                    zzi zziVar = zzvVar.zzF;
                    if (strArrSplit.length < 4) {
                        zzba$$ExternalSyntheticOutline0.m(str6, "Ignoring malformed AV1 codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            int i20 = Integer.parseInt(strArrSplit[1]);
                            int i21 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                            int i22 = Integer.parseInt(strArrSplit[3]);
                            if (i20 == 0) {
                                if (i22 == 8) {
                                    i3 = 1;
                                } else if (i22 != 10) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i22).length() + 23), "Unknown AV1 bit depth: ", i22, "CodecSpecificDataUtil");
                                } else {
                                    i3 = (zziVar == null || !(zziVar.zze != null || (i4 = zziVar.zzd) == 7 || i4 == 6)) ? 2 : 4096;
                                }
                                switch (i21) {
                                    case 0:
                                        i12 = 1;
                                        break;
                                    case 1:
                                        i12 = 2;
                                        break;
                                    case 2:
                                        i12 = 4;
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        i12 = 16;
                                        break;
                                    case 5:
                                        i12 = 32;
                                        break;
                                    case 6:
                                        i12 = 64;
                                        break;
                                    case 7:
                                        i12 = 128;
                                        break;
                                    case 8:
                                        i12 = 256;
                                        break;
                                    case 9:
                                        i12 = 512;
                                        break;
                                    case 10:
                                        i12 = 1024;
                                        break;
                                    case 11:
                                        i12 = 2048;
                                        break;
                                    case 12:
                                        i12 = 4096;
                                        break;
                                    case 13:
                                        i12 = 8192;
                                        break;
                                    case 14:
                                        i12 = 16384;
                                        break;
                                    case 15:
                                        i12 = 32768;
                                        break;
                                    case 16:
                                        i12 = 65536;
                                        break;
                                    case 17:
                                        i12 = 131072;
                                        break;
                                    case 18:
                                        i12 = 262144;
                                        break;
                                    case 19:
                                        i12 = 524288;
                                        break;
                                    case 20:
                                        i12 = 1048576;
                                        break;
                                    case 21:
                                        i12 = 2097152;
                                        break;
                                    case 22:
                                        i12 = 4194304;
                                        break;
                                    case 23:
                                        i12 = 8388608;
                                        break;
                                    default:
                                        i12 = -1;
                                        break;
                                }
                                if (i12 == -1) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i21).length() + 19), "Unknown AV1 level: ", i21, "CodecSpecificDataUtil");
                                }
                            } else {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i20).length() + 21), "Unknown AV1 profile: ", i20, "CodecSpecificDataUtil");
                            }
                        } catch (NumberFormatException unused2) {
                            zzba$$ExternalSyntheticOutline0.m(str6, "Ignoring malformed AV1 codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3006243:
                i5 = 32;
                if (str3.equals(VisualSampleEntry.TYPE3)) {
                    String str7 = zzvVar.zzk;
                    int length = strArrSplit.length;
                    if (length < 2) {
                        zzba$$ExternalSyntheticOutline0.m(str7, "Ignoring malformed AVC codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            if (strArrSplit[1].length() != 6) {
                                i6 = 16;
                                if (length < 3) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(str7).length() + 37);
                                    sb.append("Ignoring malformed AVC codec string: ");
                                    sb.append(str7);
                                    zzeg.zzc("CodecSpecificDataUtil", sb.toString());
                                } else {
                                    i7 = Integer.parseInt(strArrSplit[1]);
                                    i8 = Integer.parseInt(strArrSplit[2]);
                                }
                            } else {
                                i6 = 16;
                                i7 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                                i8 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                            }
                            int i23 = i7 != 66 ? i7 != 77 ? i7 != 88 ? i7 != 100 ? i7 != 110 ? i7 != 122 ? i7 != 244 ? -1 : 64 : i5 : i6 : 8 : 4 : 2 : 1;
                            if (i23 != -1) {
                                switch (i8) {
                                    case 10:
                                        i12 = 1;
                                        break;
                                    case 11:
                                        i12 = 4;
                                        break;
                                    case 12:
                                        break;
                                    case 13:
                                        i12 = i6;
                                        break;
                                    default:
                                        switch (i8) {
                                            case 20:
                                                i12 = i5;
                                                break;
                                            case 21:
                                                i12 = 64;
                                                break;
                                            case 22:
                                                i12 = 128;
                                                break;
                                            default:
                                                switch (i8) {
                                                    case 30:
                                                        i12 = 256;
                                                        break;
                                                    case 31:
                                                        i12 = 512;
                                                        break;
                                                    case 32:
                                                        i12 = 1024;
                                                        break;
                                                    default:
                                                        switch (i8) {
                                                            case 40:
                                                                i12 = 2048;
                                                                break;
                                                            case 41:
                                                                i12 = 4096;
                                                                break;
                                                            case 42:
                                                                i12 = 8192;
                                                                break;
                                                            default:
                                                                switch (i8) {
                                                                    case 50:
                                                                        i12 = 16384;
                                                                        break;
                                                                    case 51:
                                                                        i12 = 32768;
                                                                        break;
                                                                    case 52:
                                                                        i12 = 65536;
                                                                        break;
                                                                    default:
                                                                        i12 = -1;
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                if (i12 == -1) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i8).length() + 19), "Unknown AVC level: ", i8, "CodecSpecificDataUtil");
                                }
                            } else {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i7).length() + 21), "Unknown AVC profile: ", i7, "CodecSpecificDataUtil");
                            }
                        } catch (NumberFormatException unused3) {
                            zzba$$ExternalSyntheticOutline0.m(str7, "Ignoring malformed AVC codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3006244:
                i5 = 32;
                if (str3.equals("avc2")) {
                }
                break;
            case 3199032:
                break;
            case 3214780:
                break;
            case 3224753:
                if (str3.equals("iamf")) {
                    if (strArrSplit.length < 4) {
                        zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed IAMF codec string: ".concat(str));
                    } else {
                        try {
                            int i24 = Integer.parseInt(strArrSplit[1]);
                            String str8 = strArrSplit[3];
                            switch (str8.hashCode()) {
                                case 2464863:
                                    if (!str8.equals("Opus")) {
                                        zzeg.zzc("CodecSpecificDataUtil", "Unrecognized codec identifier for IAMF auxiliary profile: ".concat(str8));
                                    } else if (i24 == 0) {
                                        i9 = R.attr.label;
                                    } else if (i24 == 1) {
                                        i9 = R.id.checkbox;
                                    } else if (i24 == 2) {
                                        i9 = R.string.copy;
                                    } else {
                                        zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i24, 32), i24, "Unrecognized IAMF Opus profile: ", "CodecSpecificDataUtil");
                                    }
                                    i9 = -1;
                                    break;
                                case 3114792:
                                    if (str8.equals("fLaC")) {
                                        if (i24 == 0) {
                                            i9 = R.attr.manageSpaceActivity;
                                        } else if (i24 == 1) {
                                            i9 = R.id.empty;
                                        } else if (i24 == 2) {
                                            i9 = R.string.defaultVoiceMailAlphaTag;
                                        } else {
                                            zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i24, 32), i24, "Unrecognized IAMF FLAC profile: ", "CodecSpecificDataUtil");
                                        }
                                        break;
                                    }
                                    i9 = -1;
                                    break;
                                case 3238865:
                                    if (str8.equals("ipcm")) {
                                        if (i24 == 0) {
                                            i9 = R.attr.writePermission;
                                        } else if (i24 == 1) {
                                            i9 = R.id.icon2;
                                        } else if (i24 == 2) {
                                            i9 = R.string.httpErrorUnsupportedScheme;
                                        } else {
                                            zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i24, 31), i24, "Unrecognized IAMF PCM profile: ", "CodecSpecificDataUtil");
                                        }
                                        break;
                                    }
                                    i9 = -1;
                                    break;
                                case 3356560:
                                    if (str8.equals(AudioSampleEntry.TYPE3)) {
                                        if (i24 == 0) {
                                            i9 = R.attr.icon;
                                        } else if (i24 == 1) {
                                            i9 = R.id.content;
                                        } else if (i24 == 2) {
                                            i9 = R.string.copyUrl;
                                        } else {
                                            zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i24, 31), i24, "Unrecognized IAMF AAC profile: ", "CodecSpecificDataUtil");
                                        }
                                        break;
                                    }
                                    i9 = -1;
                                    break;
                            }
                            if (i9 != -1) {
                            }
                        } catch (NumberFormatException e2) {
                            zzeg.zzd("CodecSpecificDataUtil", "Ignoring malformed primary profile in IAMF codec string: ".concat(String.valueOf(strArrSplit[1])), e2);
                            return null;
                        }
                    }
                }
                break;
            case 3356560:
                if (str3.equals(AudioSampleEntry.TYPE3)) {
                    String str9 = zzvVar.zzk;
                    if (strArrSplit.length != 3) {
                        zzba$$ExternalSyntheticOutline0.m(str9, "Ignoring malformed MP4A codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            if ("audio/mp4a-latm".equals(zzas.zze(Integer.parseInt(strArrSplit[1], 16)))) {
                                int i25 = Integer.parseInt(strArrSplit[2]);
                                if (i25 == 17) {
                                    i13 = 17;
                                } else if (i25 == 20) {
                                    i13 = 20;
                                } else if (i25 == 23) {
                                    i13 = 23;
                                } else if (i25 == 29) {
                                    i13 = 29;
                                } else if (i25 == 39) {
                                    i13 = 39;
                                } else if (i25 != 42) {
                                    switch (i25) {
                                        case 1:
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i13 = 2;
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            i13 = 4;
                                            break;
                                        case 5:
                                            i13 = 5;
                                            break;
                                        case 6:
                                            i13 = 6;
                                            break;
                                        default:
                                            i13 = -1;
                                            break;
                                    }
                                } else {
                                    i13 = 42;
                                }
                                if (i13 == -1) {
                                    StringBuilder sb2 = new StringBuilder(29);
                                    sb2.append("Unrecognized MP4A profile: -1");
                                    zzeg.zzc("CodecSpecificDataUtil", sb2.toString());
                                }
                            }
                        } catch (NumberFormatException unused4) {
                            zzba$$ExternalSyntheticOutline0.m(str9, "Ignoring malformed MP4A codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3475740:
                if (str3.equals(VisualSampleEntry.TYPE2)) {
                    String str10 = zzvVar.zzk;
                    if (strArrSplit.length < 3) {
                        zzba$$ExternalSyntheticOutline0.m(str10, "Ignoring malformed H263 codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            int i26 = Integer.parseInt(strArrSplit[1]);
                            int i27 = Integer.parseInt(strArrSplit[2]);
                            switch (i26) {
                                case 0:
                                    i10 = 1;
                                    break;
                                case 1:
                                    i10 = 2;
                                    break;
                                case 2:
                                    i10 = 4;
                                    break;
                                case 3:
                                    i10 = 8;
                                    break;
                                case 4:
                                    i10 = 16;
                                    break;
                                case 5:
                                    i10 = 32;
                                    break;
                                case 6:
                                    i10 = 64;
                                    break;
                                case 7:
                                    i10 = 128;
                                    break;
                                case 8:
                                    i10 = 256;
                                    break;
                                default:
                                    i10 = -1;
                                    break;
                            }
                            if (i10 != -1) {
                                i = i27 != 10 ? i27 != 20 ? i27 != 30 ? i27 != 40 ? i27 != 45 ? i27 != 50 ? i27 != 60 ? i27 != 70 ? -1 : 128 : 64 : 32 : 16 : 8 : 4 : 2 : 1;
                                if (i == -1) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i27).length() + 20), "Unknown H263 level: ", i27, "CodecSpecificDataUtil");
                                }
                            } else {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i26).length() + 22), "Unknown H263 profile: ", i26, "CodecSpecificDataUtil");
                            }
                        } catch (NumberFormatException unused5) {
                            zzba$$ExternalSyntheticOutline0.m(str10, "Ignoring malformed H263 codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3624515:
                if (str3.equals("vp09")) {
                    String str11 = zzvVar.zzk;
                    if (strArrSplit.length < 3) {
                        zzba$$ExternalSyntheticOutline0.m(str11, "Ignoring malformed VP9 codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            int i28 = Integer.parseInt(strArrSplit[1]);
                            int i29 = Integer.parseInt(strArrSplit[2]);
                            int i30 = i28 != 0 ? i28 != 1 ? i28 != 2 ? i28 != 3 ? -1 : 8 : 4 : 2 : 1;
                            if (i30 != -1) {
                                if (i29 == 10) {
                                    i12 = 1;
                                } else if (i29 == 11) {
                                    i12 = 2;
                                } else if (i29 == 20) {
                                    i12 = 4;
                                } else if (i29 != 21) {
                                    if (i29 == 30) {
                                        i12 = 16;
                                    } else if (i29 == 31) {
                                        i12 = 32;
                                    } else if (i29 == 40) {
                                        i12 = 64;
                                    } else if (i29 == 41) {
                                        i12 = 128;
                                    } else if (i29 == 50) {
                                        i12 = 256;
                                    } else if (i29 != 51) {
                                        switch (i29) {
                                            case 60:
                                                i12 = 2048;
                                                break;
                                            case 61:
                                                i12 = 4096;
                                                break;
                                            case 62:
                                                i12 = 8192;
                                                break;
                                            default:
                                                i12 = -1;
                                                break;
                                        }
                                    } else {
                                        i12 = 512;
                                    }
                                }
                                if (i12 == -1) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i29).length() + 19), "Unknown VP9 level: ", i29, "CodecSpecificDataUtil");
                                }
                            } else {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i28).length() + 21), "Unknown VP9 profile: ", i28, "CodecSpecificDataUtil");
                            }
                        } catch (NumberFormatException unused6) {
                            zzba$$ExternalSyntheticOutline0.m(str11, "Ignoring malformed VP9 codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3631854:
                if (str3.equals("vvc1")) {
                    String str12 = zzvVar.zzk;
                    zzi zziVar2 = zzvVar.zzF;
                    if (strArrSplit.length < 3) {
                        zzba$$ExternalSyntheticOutline0.m(str12, "Ignoring malformed VVC codec string: ", "CodecSpecificDataUtil");
                    } else {
                        try {
                            int i31 = Integer.parseInt(strArrSplit[1]);
                            if (i31 == 1) {
                                i11 = (zziVar2 == null || zziVar2.zzd != 6) ? (zziVar2 == null || zziVar2.zzf != 8) ? 2 : 1 : 4096;
                            } else if (i31 != 65) {
                                zzba$$ExternalSyntheticOutline0.m(strArrSplit[1], "Unknown VVC profile IDC: ", "CodecSpecificDataUtil");
                            } else {
                                i11 = 4;
                            }
                            String str13 = strArrSplit[2];
                            switch (str13.hashCode()) {
                                case 70918:
                                    numValueOf = !str13.equals("H64") ? null : 64;
                                    break;
                                case 70921:
                                    numValueOf = !str13.equals("H67") ? null : 256;
                                    break;
                                case 70976:
                                    numValueOf = !str13.equals("H80") ? null : 1024;
                                    break;
                                case 70979:
                                    numValueOf = !str13.equals("H83") ? null : 4096;
                                    break;
                                case 70982:
                                    numValueOf = !str13.equals("H86") ? null : 16384;
                                    break;
                                case 71013:
                                    numValueOf = !str13.equals("H96") ? null : Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                                    break;
                                case 74609:
                                    numValueOf = !str13.equals("L16") ? null : 1;
                                    break;
                                case 74667:
                                    numValueOf = !str13.equals("L32") ? null : 2;
                                    break;
                                case 74670:
                                    numValueOf = !str13.equals("L35") ? null : 4;
                                    break;
                                case 74704:
                                    numValueOf = !str13.equals("L48") ? null : 8;
                                    break;
                                case 74728:
                                    numValueOf = !str13.equals("L51") ? null : 16;
                                    break;
                                case 74762:
                                    numValueOf = !str13.equals("L64") ? null : 32;
                                    break;
                                case 74765:
                                    numValueOf = !str13.equals("L67") ? null : 128;
                                    break;
                                case 74820:
                                    numValueOf = !str13.equals("L80") ? null : 512;
                                    break;
                                case 74823:
                                    numValueOf = !str13.equals("L83") ? null : 2048;
                                    break;
                                case 74826:
                                    numValueOf = !str13.equals("L86") ? null : Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                                    break;
                                case 74857:
                                    numValueOf = !str13.equals("L96") ? null : 32768;
                                    break;
                                case 2193610:
                                    numValueOf = !str13.equals("H112") ? null : 262144;
                                    break;
                                case 2193647:
                                    numValueOf = !str13.equals("H128") ? null : 1048576;
                                    break;
                                case 2193705:
                                    numValueOf = !str13.equals("H144") ? null : 4194304;
                                    break;
                                case 2312774:
                                    numValueOf = !str13.equals("L112") ? null : 131072;
                                    break;
                                case 2312811:
                                    numValueOf = !str13.equals("L128") ? null : 524288;
                                    break;
                                case 2312869:
                                    numValueOf = !str13.equals("L144") ? null : 2097152;
                                    break;
                                default:
                                    numValueOf = null;
                                    break;
                            }
                            if (numValueOf == null) {
                                zzeg.zzc("CodecSpecificDataUtil", "Unknown VVC level string: ".concat(str13));
                            }
                        } catch (NumberFormatException unused7) {
                            zzba$$ExternalSyntheticOutline0.m(str12, "Ignoring malformed VVC codec string: ", "CodecSpecificDataUtil");
                            return null;
                        }
                    }
                }
                break;
            case 3632040:
                if (str3.equals("vvi1")) {
                }
                break;
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzdp zzg(String str, String[] strArr, zzi zziVar) {
        int i;
        Integer numValueOf = null;
        if (strArr.length < 4) {
            zzba$$ExternalSyntheticOutline0.m(str, "Ignoring malformed HEVC codec string: ", "CodecSpecificDataUtil");
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            zzba$$ExternalSyntheticOutline0.m(str, "Ignoring malformed HEVC codec string: ", "CodecSpecificDataUtil");
            return null;
        }
        String strGroup = matcher.group(1);
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strGroup)) {
            i = 1;
        } else {
            if (!"2".equals(strGroup)) {
                zzba$$ExternalSyntheticOutline0.m(strGroup, "Unknown HEVC profile string: ", "CodecSpecificDataUtil");
                return zzdp.zza;
            }
            i = (zziVar == null || zziVar.zzd != 6) ? 2 : 4096;
        }
        String str2 = strArr[3];
        switch (str2.hashCode()) {
            case 70821:
                if (str2.equals("H30")) {
                    numValueOf = 2;
                }
                break;
            case 70914:
                if (str2.equals("H60")) {
                    numValueOf = 8;
                }
                break;
            case 70917:
                if (str2.equals("H63")) {
                    numValueOf = 32;
                }
                break;
            case 71007:
                if (str2.equals("H90")) {
                    numValueOf = 128;
                }
                break;
            case 71010:
                if (str2.equals("H93")) {
                    numValueOf = 512;
                }
                break;
            case 74665:
                if (str2.equals("L30")) {
                    numValueOf = 1;
                }
                break;
            case 74758:
                if (str2.equals("L60")) {
                    numValueOf = 4;
                }
                break;
            case 74761:
                if (str2.equals("L63")) {
                    numValueOf = 16;
                }
                break;
            case 74851:
                if (str2.equals("L90")) {
                    numValueOf = 64;
                }
                break;
            case 74854:
                if (str2.equals("L93")) {
                    numValueOf = 256;
                }
                break;
            case 2193639:
                if (str2.equals("H120")) {
                    numValueOf = 2048;
                }
                break;
            case 2193642:
                if (str2.equals("H123")) {
                    numValueOf = Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
                break;
            case 2193732:
                if (str2.equals("H150")) {
                    numValueOf = 32768;
                }
                break;
            case 2193735:
                if (str2.equals("H153")) {
                    numValueOf = 131072;
                }
                break;
            case 2193738:
                if (str2.equals("H156")) {
                    numValueOf = 524288;
                }
                break;
            case 2193825:
                if (str2.equals("H180")) {
                    numValueOf = 2097152;
                }
                break;
            case 2193828:
                if (str2.equals("H183")) {
                    numValueOf = 8388608;
                }
                break;
            case 2193831:
                if (str2.equals("H186")) {
                    numValueOf = 33554432;
                }
                break;
            case 2312803:
                if (str2.equals("L120")) {
                    numValueOf = 1024;
                }
                break;
            case 2312806:
                if (str2.equals("L123")) {
                    numValueOf = 4096;
                }
                break;
            case 2312896:
                if (str2.equals("L150")) {
                    numValueOf = 16384;
                }
                break;
            case 2312899:
                if (str2.equals("L153")) {
                    numValueOf = Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                }
                break;
            case 2312902:
                if (str2.equals("L156")) {
                    numValueOf = 262144;
                }
                break;
            case 2312989:
                if (str2.equals("L180")) {
                    numValueOf = 1048576;
                }
                break;
            case 2312992:
                if (str2.equals("L183")) {
                    numValueOf = 4194304;
                }
                break;
            case 2312995:
                if (str2.equals("L186")) {
                    numValueOf = 16777216;
                }
                break;
        }
        if (numValueOf != null) {
            return new zzdp(i, numValueOf.intValue());
        }
        zzeg.zzc("CodecSpecificDataUtil", "Unknown HEVC level string: ".concat(str2));
        return zzdp.zza;
    }

    public static byte[] zzh(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    private static int zzi(int i, int i2) {
        switch (i) {
            case 30:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 33:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 60:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 63:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 90:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 93:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 120:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 123:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 150:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 153:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 180:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 183:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 210:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            case 213:
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(i2, 23), i2, "Unrecognized APV band: ", "CodecSpecificDataUtil");
                            }
                        }
                    }
                }
                break;
            default:
                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i).length() + 30), "Unrecognized APV level index: ", i, "CodecSpecificDataUtil");
                break;
        }
        return -1;
    }
}
