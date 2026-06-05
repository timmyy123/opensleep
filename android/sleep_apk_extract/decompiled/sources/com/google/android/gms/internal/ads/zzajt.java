package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajt extends zzajo {
    public final String zza;
    public final zzgwm zzb;

    public zzajt(String str, String str2, List list) {
        super(str);
        zzgtj.zza(!list.isEmpty());
        this.zza = str2;
        zzgwm zzgwmVarZzq = zzgwm.zzq(list);
        this.zzb = zzgwmVarZzq;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajt.class == obj.getClass()) {
            zzajt zzajtVar = (zzajt) obj;
            if (Objects.equals(this.zzf, zzajtVar.zzf) && Objects.equals(this.zza, zzajtVar.zza) && this.zzb.equals(zzajtVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return this.zzb.hashCode() + (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 14 + String.valueOf(str2).length() + 9 + strValueOf.length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, ": description=", str2, ": values=");
        sb.append(strValueOf);
        return sb.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0181 A[Catch: NumberFormatException | StringIndexOutOfBoundsException -> 0x0203, TryCatch #0 {NumberFormatException | StringIndexOutOfBoundsException -> 0x0203, blocks: (B:69:0x0123, B:82:0x0178, B:84:0x0181, B:86:0x018d, B:102:0x01dc), top: B:113:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018c  */
    @Override // com.google.android.gms.internal.ads.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzam zzamVar) {
        String str = this.zzf;
        try {
            switch (str.hashCode()) {
                case 82815:
                    if (!str.equals("TAL")) {
                    }
                    zzamVar.zzc((CharSequence) this.zzb.get(0));
                    break;
                case 82878:
                    if (!str.equals("TCM")) {
                    }
                    zzamVar.zzp((CharSequence) this.zzb.get(0));
                    break;
                case 82897:
                    if (!str.equals("TDA")) {
                    }
                    String str2 = (String) this.zzb.get(0);
                    int i = Integer.parseInt(str2.substring(2, 4));
                    int i2 = Integer.parseInt(str2.substring(0, 2));
                    zzamVar.zzj(Integer.valueOf(i));
                    zzamVar.zzk(Integer.valueOf(i2));
                    break;
                case 83253:
                    if (!str.equals("TP1")) {
                    }
                    zzamVar.zzb((CharSequence) this.zzb.get(0));
                    break;
                case 83254:
                    if (!str.equals("TP2")) {
                    }
                    zzamVar.zzd((CharSequence) this.zzb.get(0));
                    break;
                case 83255:
                    if (!str.equals("TP3")) {
                    }
                    zzamVar.zzq((CharSequence) this.zzb.get(0));
                    break;
                case 83341:
                    if (!str.equals("TRK")) {
                    }
                    String str3 = (String) this.zzb.get(0);
                    String str4 = zzfl.zza;
                    String[] strArrSplit = str3.split(MqttTopic.TOPIC_LEVEL_SEPARATOR, -1);
                    int i3 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length <= 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzamVar.zzg(Integer.valueOf(i3));
                    zzamVar.zzh(numValueOf);
                    break;
                case 83378:
                    if (!str.equals("TT2")) {
                    }
                    zzamVar.zza((CharSequence) this.zzb.get(0));
                    break;
                case 83536:
                    if (!str.equals("TXT")) {
                    }
                    zzamVar.zzo((CharSequence) this.zzb.get(0));
                    break;
                case 83552:
                    if (!str.equals("TYE")) {
                    }
                    zzamVar.zzi(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                    break;
                case 2567331:
                    if (!str.equals("TALB")) {
                    }
                    zzamVar.zzc((CharSequence) this.zzb.get(0));
                    break;
                case 2569357:
                    if (!str.equals("TCOM")) {
                    }
                    zzamVar.zzp((CharSequence) this.zzb.get(0));
                    break;
                case 2569358:
                    if (str.equals("TCON")) {
                        zzgwm zzgwmVar = this.zzb;
                        Integer numZzh = zzhah.zzh((String) zzgwmVar.get(0), 10);
                        if (numZzh != null) {
                            String strZza = zzajp.zza(numZzh.intValue());
                            if (strZza != null) {
                                zzamVar.zzt(strZza);
                            }
                        } else {
                            zzamVar.zzt((CharSequence) zzgwmVar.get(0));
                        }
                    }
                    break;
                case 2569891:
                    if (!str.equals("TDAT")) {
                    }
                    String str22 = (String) this.zzb.get(0);
                    int i4 = Integer.parseInt(str22.substring(2, 4));
                    int i22 = Integer.parseInt(str22.substring(0, 2));
                    zzamVar.zzj(Integer.valueOf(i4));
                    zzamVar.zzk(Integer.valueOf(i22));
                    break;
                case 2570401:
                    if (str.equals("TDRC")) {
                        List listZzb = zzb((String) this.zzb.get(0));
                        int size = listZzb.size();
                        if (size != 1) {
                            if (size != 2) {
                                if (size == 3) {
                                    zzamVar.zzk((Integer) listZzb.get(2));
                                }
                            }
                            zzamVar.zzj((Integer) listZzb.get(1));
                        }
                        zzamVar.zzi((Integer) listZzb.get(0));
                    }
                    break;
                case 2570410:
                    if (str.equals("TDRL")) {
                        List listZzb2 = zzb((String) this.zzb.get(0));
                        int size2 = listZzb2.size();
                        if (size2 != 1) {
                            if (size2 != 2) {
                                if (size2 == 3) {
                                    zzamVar.zzn((Integer) listZzb2.get(2));
                                }
                            }
                            zzamVar.zzm((Integer) listZzb2.get(1));
                        }
                        zzamVar.zzl((Integer) listZzb2.get(0));
                    }
                    break;
                case 2571565:
                    if (!str.equals("TEXT")) {
                    }
                    zzamVar.zzo((CharSequence) this.zzb.get(0));
                    break;
                case 2575251:
                    if (!str.equals("TIT2")) {
                    }
                    zzamVar.zza((CharSequence) this.zzb.get(0));
                    break;
                case 2581512:
                    if (!str.equals("TPE1")) {
                    }
                    zzamVar.zzb((CharSequence) this.zzb.get(0));
                    break;
                case 2581513:
                    if (!str.equals("TPE2")) {
                    }
                    zzamVar.zzd((CharSequence) this.zzb.get(0));
                    break;
                case 2581514:
                    if (!str.equals("TPE3")) {
                    }
                    zzamVar.zzq((CharSequence) this.zzb.get(0));
                    break;
                case 2583398:
                    if (!str.equals("TRCK")) {
                    }
                    String str32 = (String) this.zzb.get(0);
                    String str42 = zzfl.zza;
                    String[] strArrSplit2 = str32.split(MqttTopic.TOPIC_LEVEL_SEPARATOR, -1);
                    int i32 = Integer.parseInt(strArrSplit2[0]);
                    if (strArrSplit2.length <= 1) {
                    }
                    zzamVar.zzg(Integer.valueOf(i32));
                    zzamVar.zzh(numValueOf);
                    break;
                case 2590194:
                    if (!str.equals("TYER")) {
                    }
                    zzamVar.zzi(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }
}
