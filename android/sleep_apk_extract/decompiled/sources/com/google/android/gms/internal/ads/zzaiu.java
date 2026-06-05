package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzaiu {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        r7 = -9223372036854775807L;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzait zza(String str) {
        long j;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            xmlPullParserNewPullParser.next();
            if (!zzft.zzb(xmlPullParserNewPullParser, "x:xmpmeta")) {
                throw zzat.zzb("Couldn't find xmp metadata", null);
            }
            zzgwm zzgwmVarZzi = zzgwm.zzi();
            long j2 = -9223372036854775807L;
            do {
                xmlPullParserNewPullParser.next();
                if (zzft.zzb(xmlPullParserNewPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        String strZzc = zzft.zzc(xmlPullParserNewPullParser, strArr[i2]);
                        if (strZzc != null) {
                            if (Integer.parseInt(strZzc) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= 4) {
                                    break;
                                }
                                String strZzc2 = zzft.zzc(xmlPullParserNewPullParser, strArr2[i3]);
                                if (strZzc2 != null) {
                                    j = Long.parseLong(strZzc2);
                                    if (j == -1) {
                                        break;
                                    }
                                } else {
                                    i3++;
                                }
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i >= 2) {
                                    zzgwmVarZzi = zzgwm.zzi();
                                    break;
                                }
                                String strZzc3 = zzft.zzc(xmlPullParserNewPullParser, strArr3[i]);
                                if (strZzc3 != null) {
                                    zzgwmVarZzi = zzgwm.zzk(new zzais("image/jpeg", "Primary", 0L, 0L), new zzais("video/mp4", "MotionPhoto", Long.parseLong(strZzc3), 0L));
                                    break;
                                }
                                i++;
                            }
                            j2 = j;
                        }
                    }
                    return null;
                }
                if (zzft.zzb(xmlPullParserNewPullParser, "Container:Directory")) {
                    zzgwmVarZzi = zzc(xmlPullParserNewPullParser, "Container", "Item");
                } else if (zzft.zzb(xmlPullParserNewPullParser, "GContainer:Directory")) {
                    zzgwmVarZzi = zzc(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzft.zza(xmlPullParserNewPullParser, "x:xmpmeta"));
            if (zzgwmVarZzi.isEmpty()) {
                return null;
            }
            return new zzait(j2, zzgwmVarZzi);
        } catch (zzat | NumberFormatException | XmlPullParserException unused) {
            zzeg.zzc("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    public static boolean zzb(String str) {
        if (str == null) {
            return false;
        }
        String[] strArr = zza;
        for (int i = 0; i < 4; i++) {
            if (str.contains(String.valueOf(strArr[i]).concat("=\"1\""))) {
                return true;
            }
        }
        return false;
    }

    private static zzgwm zzc(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzft.zzb(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZzc = zzft.zzc(xmlPullParser, strConcat2);
                String strZzc2 = zzft.zzc(xmlPullParser, strConcat3);
                String strZzc3 = zzft.zzc(xmlPullParser, strConcat4);
                String strZzc4 = zzft.zzc(xmlPullParser, strConcat5);
                if (strZzc == null || strZzc2 == null) {
                    return zzgwm.zzi();
                }
                zzgwjVar.zzf(new zzais(strZzc, strZzc2, strZzc3 != null ? Long.parseLong(strZzc3) : 0L, strZzc4 != null ? Long.parseLong(strZzc4) : 0L));
            }
        } while (!zzft.zza(xmlPullParser, str.concat(":Directory")));
        return zzgwjVar.zzi();
    }
}
