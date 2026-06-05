package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzamg {
    private static final zzgty zza = zzgty.zza(zzgsx.zzc(':'));
    private static final zzgty zzb = zzgty.zza(zzgsx.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final void zza() {
        this.zzc.clear();
        this.zzd = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0133, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzb("Invalid SEF name", null);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzafz zzafzVar, zzagy zzagyVar, List list) {
        char c;
        int i = this.zzd;
        if (i == 0) {
            long jZzo = zzafzVar.zzo();
            zzagyVar.zza = (jZzo == -1 || jZzo < 8) ? 0L : jZzo - 8;
            this.zzd = 1;
            return 1;
        }
        int i2 = 8;
        if (i != 1) {
            short s = 2820;
            short s2 = 2819;
            short s3 = 2817;
            short s4 = 2816;
            short s5 = 2192;
            if (i != 2) {
                long jZzn = zzafzVar.zzn();
                int iZzo = (int) ((zzafzVar.zzo() - zzafzVar.zzn()) - ((long) this.zze));
                zzet zzetVar = new zzet(iZzo);
                zzafzVar.zzc(zzetVar.zzi(), 0, iZzo);
                int i3 = 0;
                while (true) {
                    List list2 = this.zzc;
                    if (i3 < list2.size()) {
                        zzamf zzamfVar = (zzamf) list2.get(i3);
                        zzetVar.zzh((int) (zzamfVar.zza - jZzn));
                        zzetVar.zzk(4);
                        int iZzC = zzetVar.zzC();
                        Charset charset = StandardCharsets.UTF_8;
                        String strZzK = zzetVar.zzK(iZzC, charset);
                        switch (strZzK.hashCode()) {
                            case -1711564334:
                                if (strZzK.equals("SlowMotion_Data")) {
                                    c = 2192;
                                    int i4 = zzamfVar.zzb - (iZzC + 8);
                                    if (c == 2192) {
                                        ArrayList arrayList = new ArrayList();
                                        List listZze = zzb.zze(zzetVar.zzK(i4, charset));
                                        for (int i5 = 0; i5 < listZze.size(); i5++) {
                                            List listZze2 = zza.zze((CharSequence) listZze.get(i5));
                                            if (listZze2.size() != 3) {
                                                throw zzat.zzb(null, null);
                                            }
                                            try {
                                                arrayList.add(new zzajv(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                                            } catch (NumberFormatException e) {
                                                throw zzat.zzb(null, e);
                                            }
                                        }
                                        list.add(new zzajw(arrayList));
                                    } else if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                                        Home$$ExternalSyntheticBUOutline0.m$2();
                                        return 0;
                                    }
                                    i3++;
                                }
                                break;
                            case -1332107749:
                                if (strZzK.equals("Super_SlowMotion_Edit_Data")) {
                                    c = 2819;
                                    int i42 = zzamfVar.zzb - (iZzC + 8);
                                    if (c == 2192) {
                                    }
                                    i3++;
                                }
                                break;
                            case -1251387154:
                                if (strZzK.equals("Super_SlowMotion_Data")) {
                                    c = 2816;
                                    int i422 = zzamfVar.zzb - (iZzC + 8);
                                    if (c == 2192) {
                                    }
                                    i3++;
                                }
                                break;
                            case -830665521:
                                if (strZzK.equals("Super_SlowMotion_Deflickering_On")) {
                                    c = 2820;
                                    int i4222 = zzamfVar.zzb - (iZzC + 8);
                                    if (c == 2192) {
                                    }
                                    i3++;
                                }
                                break;
                            case 1760745220:
                                if (strZzK.equals("Super_SlowMotion_BGM")) {
                                    c = 2817;
                                    int i42222 = zzamfVar.zzb - (iZzC + 8);
                                    if (c == 2192) {
                                    }
                                    i3++;
                                }
                                break;
                        }
                    } else {
                        zzagyVar.zza = 0L;
                    }
                }
            } else {
                long jZzo2 = zzafzVar.zzo();
                int i6 = this.zze - 20;
                zzet zzetVar2 = new zzet(i6);
                zzafzVar.zzc(zzetVar2.zzi(), 0, i6);
                int i7 = 0;
                while (i7 < i6 / 12) {
                    zzetVar2.zzk(2);
                    short sZzw = zzetVar2.zzw();
                    if (sZzw == s5 || sZzw == s4 || sZzw == s3 || sZzw == s2 || sZzw == s) {
                        this.zzc.add(new zzamf(sZzw, (jZzo2 - ((long) this.zze)) - ((long) zzetVar2.zzC()), zzetVar2.zzC()));
                    } else {
                        zzetVar2.zzk(i2);
                    }
                    i7++;
                    i2 = 8;
                    s = 2820;
                    s2 = 2819;
                    s3 = 2817;
                    s4 = 2816;
                    s5 = 2192;
                }
                List list3 = this.zzc;
                if (list3.isEmpty()) {
                    zzagyVar.zza = 0L;
                } else {
                    this.zzd = 3;
                    zzagyVar.zza = ((zzamf) list3.get(0)).zza;
                }
            }
        } else {
            zzet zzetVar3 = new zzet(8);
            zzafzVar.zzc(zzetVar3.zzi(), 0, 8);
            this.zze = zzetVar3.zzC() + 8;
            if (zzetVar3.zzB() != 1397048916) {
                zzagyVar.zza = 0L;
            } else {
                zzagyVar.zza = zzafzVar.zzn() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }
}
