package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzalt {
    public static void zza(int i, zzap zzapVar, zzt zztVar, zzap zzapVar2, zzap... zzapVarArr) {
        if (zzapVar2 == null) {
            zzapVar2 = new zzap(-9223372036854775807L, new zzao[0]);
        }
        if (zzapVar != null) {
            zzgwm zzgwmVarZzd = zzapVar.zzd(zzfv.class);
            int size = zzgwmVarZzd.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzfv zzfvVar = (zzfv) zzgwmVarZzd.get(i2);
                if (!zzfvVar.zza.equals("com.android.capture.fps") || i == 2) {
                    zzapVar2 = zzapVar2.zzg(zzfvVar);
                }
            }
        }
        for (zzap zzapVar3 : zzapVarArr) {
            zzapVar2 = zzapVar2.zzf(zzapVar3);
        }
        if (zzapVar2.zza() > 0) {
            zztVar.zzl(zzapVar2);
        }
    }

    public static void zzb(int i, zzagr zzagrVar, zzt zztVar) {
        if (i == 1 && zzagrVar.zzb()) {
            zztVar.zzJ(zzagrVar.zza);
            zztVar.zzK(zzagrVar.zzb);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0281 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:9:0x0030, B:11:0x003b, B:15:0x004a, B:18:0x0056, B:21:0x0063, B:24:0x0070, B:27:0x007d, B:30:0x008b, B:32:0x0097, B:40:0x00b2, B:41:0x00d0, B:42:0x00e2, B:45:0x00ee, B:48:0x00fb, B:51:0x0108, B:54:0x0115, B:57:0x0122, B:60:0x012f, B:63:0x013c, B:66:0x0149, B:69:0x0156, B:72:0x0163, B:76:0x0174, B:78:0x017a, B:80:0x018e, B:81:0x0195, B:83:0x019c, B:88:0x01a7, B:93:0x01b3, B:137:0x0281, B:94:0x01c8, B:96:0x01cf, B:98:0x01db, B:99:0x01ef, B:112:0x0219, B:115:0x0226, B:118:0x0233, B:121:0x0240, B:124:0x024c, B:127:0x0258, B:130:0x0262, B:133:0x026e, B:136:0x027a, B:138:0x029e, B:139:0x02a5), top: B:144:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzao zzc(zzet zzetVar) {
        String str;
        zzao zzajeVar;
        int iZzB = zzetVar.zzB() + zzetVar.zzg();
        int iZzB2 = zzetVar.zzB();
        int i = (iZzB2 >> 24) & PHIpAddressSearchManager.END_IP_SCAN;
        zzao zzaoVarZzd = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = iZzB2 & 16777215;
                if (i2 == 6516084) {
                    int iZzB3 = zzetVar.zzB();
                    if (zzetVar.zzB() == 1684108385) {
                        zzetVar.zzk(8);
                        String strZzL = zzetVar.zzL(iZzB3 - 16);
                        zzaoVarZzd = new zzaji("und", strZzL, strZzL);
                    } else {
                        zzeg.zzc("MetadataUtil", "Failed to parse comment attribute: ".concat(zzfz.zze(iZzB2)));
                    }
                } else if (i2 == 7233901 || i2 == 7631467) {
                    zzaoVarZzd = zzd(iZzB2, "TIT2", zzetVar);
                } else if (i2 == 6516589 || i2 == 7828084) {
                    zzaoVarZzd = zzd(iZzB2, "TCOM", zzetVar);
                } else if (i2 == 6578553) {
                    zzaoVarZzd = zzd(iZzB2, "TDRC", zzetVar);
                } else if (i2 == 4280916) {
                    zzaoVarZzd = zzd(iZzB2, "TPE1", zzetVar);
                } else if (i2 == 7630703) {
                    zzaoVarZzd = zzd(iZzB2, "TSSE", zzetVar);
                } else if (i2 == 6384738) {
                    zzaoVarZzd = zzd(iZzB2, "TALB", zzetVar);
                } else if (i2 == 7108978) {
                    zzaoVarZzd = zzd(iZzB2, "USLT", zzetVar);
                } else if (i2 == 6776174) {
                    zzaoVarZzd = zzd(iZzB2, "TCON", zzetVar);
                } else if (i2 == 6779504) {
                    zzaoVarZzd = zzd(iZzB2, "TIT1", zzetVar);
                } else if (i2 == 7173742) {
                    zzaoVarZzd = zzd(iZzB2, "MVNM", zzetVar);
                } else if (i2 == 7173737) {
                    zzaoVarZzd = zze(iZzB2, "MVIN", zzetVar, true, false);
                } else {
                    String strZze = zzfz.zze(iZzB2);
                    StringBuilder sb = new StringBuilder(strZze.length() + 32);
                    sb.append("Skipped unknown metadata entry: ");
                    sb.append(strZze);
                    zzeg.zza("MetadataUtil", sb.toString());
                }
            } else if (iZzB2 == 1735291493) {
                String strZza = zzajp.zza(zzf(zzetVar) - 1);
                if (strZza != null) {
                    zzajeVar = new zzajt("TCON", null, zzgwm.zzj(strZza));
                    zzaoVarZzd = zzajeVar;
                } else {
                    zzeg.zzc("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (iZzB2 == 1684632427) {
                zzaoVarZzd = zzg(1684632427, "TPOS", zzetVar);
            } else if (iZzB2 == 1953655662) {
                zzaoVarZzd = zzg(1953655662, "TRCK", zzetVar);
            } else if (iZzB2 == 1953329263) {
                zzaoVarZzd = zze(1953329263, "TBPM", zzetVar, true, false);
            } else if (iZzB2 == 1668311404) {
                zzaoVarZzd = zze(1668311404, "TCMP", zzetVar, true, true);
            } else if (iZzB2 == 1668249202) {
                int iZzB4 = zzetVar.zzB();
                if (zzetVar.zzB() == 1684108385) {
                    int iZzB5 = zzetVar.zzB();
                    int i3 = zzalj.$r8$clinit;
                    int i4 = iZzB5 & 16777215;
                    if (i4 == 13) {
                        str = "image/jpeg";
                    } else if (i4 == 14) {
                        str = "image/png";
                        i4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 30);
                        sb2.append("Unrecognized cover art flags: ");
                        sb2.append(i4);
                        zzeg.zzc("MetadataUtil", sb2.toString());
                    } else {
                        zzetVar.zzk(4);
                        int i5 = iZzB4 - 16;
                        byte[] bArr = new byte[i5];
                        zzetVar.zzm(bArr, 0, i5);
                        zzajeVar = new zzaje(str, null, 3, bArr);
                        zzaoVarZzd = zzajeVar;
                    }
                } else {
                    zzeg.zzc("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (iZzB2 == 1631670868) {
                zzaoVarZzd = zzd(1631670868, "TPE2", zzetVar);
            } else if (iZzB2 == 1936682605) {
                zzaoVarZzd = zzd(1936682605, "TSOT", zzetVar);
            } else if (iZzB2 == 1936679276) {
                zzaoVarZzd = zzd(1936679276, "TSOA", zzetVar);
            } else if (iZzB2 == 1936679282) {
                zzaoVarZzd = zzd(1936679282, "TSOP", zzetVar);
            } else if (iZzB2 == 1936679265) {
                zzaoVarZzd = zzd(1936679265, "TSO2", zzetVar);
            } else if (iZzB2 == 1936679791) {
                zzaoVarZzd = zzd(1936679791, "TSOC", zzetVar);
            } else if (iZzB2 == 1920233063) {
                zzaoVarZzd = zze(1920233063, "ITUNESADVISORY", zzetVar, false, false);
            } else if (iZzB2 == 1885823344) {
                zzaoVarZzd = zze(1885823344, "ITUNESGAPLESS", zzetVar, false, true);
            } else if (iZzB2 == 1936683886) {
                zzaoVarZzd = zzd(1936683886, "TVSHOWSORT", zzetVar);
            } else if (iZzB2 == 1953919848) {
                zzaoVarZzd = zzd(1953919848, "TVSHOW", zzetVar);
            } else if (iZzB2 == 757935405) {
                int i6 = -1;
                int i7 = -1;
                String strZzL2 = null;
                String strZzL3 = null;
                while (zzetVar.zzg() < iZzB) {
                    int iZzg = zzetVar.zzg();
                    int iZzB6 = zzetVar.zzB();
                    int iZzB7 = zzetVar.zzB();
                    zzetVar.zzk(4);
                    if (iZzB7 == 1835360622) {
                        strZzL2 = zzetVar.zzL(iZzB6 - 12);
                    } else {
                        int i8 = iZzB6 - 12;
                        if (iZzB7 == 1851878757) {
                            strZzL3 = zzetVar.zzL(i8);
                        } else {
                            if (iZzB7 == 1684108385) {
                                i7 = iZzB6;
                            }
                            if (iZzB7 == 1684108385) {
                                i6 = iZzg;
                            }
                            zzetVar.zzk(i8);
                        }
                    }
                }
                if (strZzL2 != null && strZzL3 != null && i6 != -1) {
                    zzetVar.zzh(i6);
                    zzetVar.zzk(16);
                    zzaoVarZzd = new zzajq(strZzL2, strZzL3, zzetVar.zzL(i7 - 16));
                }
            }
            return zzaoVarZzd;
        } finally {
            zzetVar.zzh(iZzB);
        }
    }

    private static zzajt zzd(int i, String str, zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385) {
            zzetVar.zzk(8);
            return new zzajt(str, null, zzgwm.zzj(zzetVar.zzL(iZzB - 16)));
        }
        zzeg.zzc("MetadataUtil", "Failed to parse text attribute: ".concat(zzfz.zze(i)));
        return null;
    }

    private static zzajo zze(int i, String str, zzet zzetVar, boolean z, boolean z2) {
        int iZzf = zzf(zzetVar);
        if (z2) {
            iZzf = Math.min(1, iZzf);
        }
        if (iZzf >= 0) {
            return z ? new zzajt(str, null, zzgwm.zzj(Integer.toString(iZzf))) : new zzaji("und", str, Integer.toString(iZzf));
        }
        zzeg.zzc("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzfz.zze(i)));
        return null;
    }

    private static int zzf(zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385) {
            zzetVar.zzk(8);
            int i = iZzB - 16;
            if (i == 1) {
                return zzetVar.zzs();
            }
            if (i == 2) {
                return zzetVar.zzt();
            }
            if (i == 3) {
                return zzetVar.zzx();
            }
            if (i == 4 && (zzetVar.zzn() & 128) == 0) {
                return zzetVar.zzH();
            }
        }
        zzeg.zzc("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzajt zzg(int i, String str, zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385 && iZzB >= 22) {
            zzetVar.zzk(10);
            int iZzt = zzetVar.zzt();
            if (iZzt > 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzt).length());
                sb.append(iZzt);
                String string = sb.toString();
                int iZzt2 = zzetVar.zzt();
                if (iZzt2 > 0) {
                    StringBuilder sb2 = new StringBuilder(string.length() + 1 + String.valueOf(iZzt2).length());
                    sb2.append(string);
                    sb2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                    sb2.append(iZzt2);
                    string = sb2.toString();
                }
                return new zzajt(str, null, zzgwm.zzj(string));
            }
        }
        zzeg.zzc("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzfz.zze(i)));
        return null;
    }
}
