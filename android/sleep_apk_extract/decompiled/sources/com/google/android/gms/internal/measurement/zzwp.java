package com.google.android.gms.internal.measurement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzwp {
    private final int[] zza;
    private final zzwn zzb;
    private zzwn zzc;
    private int zzd;
    private int zze;
    private int zzf;

    private zzwp(int[] iArr) {
        this.zza = iArr;
        zzwn zzwnVar = new zzwn(-1, -1, null);
        this.zzb = zzwnVar;
        this.zzc = zzwnVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r6 = r7.zzd;
        r7 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r6.containsKey(r7) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r0.zzc.zzd.put(r7, new com.google.android.gms.internal.measurement.zzwn(r1, 1073741824, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r5.zzc = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r5 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r5.zzc = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r0.zzd = r1;
        r0.zze++;
        r0.zzb();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzwp zza(int[] iArr) {
        zzwp zzwpVar = new zzwp(iArr);
        int i = 0;
        while (i < iArr.length) {
            zzwpVar.zzf++;
            int[] iArr2 = zzwpVar.zza;
            int i2 = iArr2[i];
            while (true) {
                zzwn zzwnVar = null;
                while (true) {
                    if (zzwpVar.zzf > 0) {
                        int i3 = zzwpVar.zze;
                        zzwn zzwnVar2 = zzwpVar.zzc;
                        if (i3 == 0) {
                            break;
                        }
                        int i4 = ((zzwn) zzwnVar2.zzd.get(Integer.valueOf(iArr2[zzwpVar.zzd]))).zza;
                        int i5 = zzwpVar.zze;
                        if (iArr2[i4 + i5] == i2) {
                            if (zzwnVar != null) {
                                zzwnVar.zzc = zzwpVar.zzc;
                            }
                            zzwpVar.zze = i5 + 1;
                            zzwpVar.zzb();
                        } else {
                            zzwn zzwnVar3 = (zzwn) zzwpVar.zzc.zzd.get(Integer.valueOf(iArr2[zzwpVar.zzd]));
                            zzwn zzwnVar4 = new zzwn(zzwnVar3.zza, (zzwpVar.zze + r9) - 1, null);
                            zzwpVar.zzc.zzd.put(Integer.valueOf(iArr2[zzwpVar.zzd]), zzwnVar4);
                            Map map = zzwnVar4.zzd;
                            int i6 = zzwnVar4.zzb + 1;
                            map.put(Integer.valueOf(iArr2[i6]), zzwnVar3);
                            zzwnVar3.zza = i6;
                            if (zzwnVar != null) {
                                zzwnVar.zzc = zzwnVar4;
                            }
                            map.put(Integer.valueOf(i2), new zzwn(i, 1073741824, null));
                            zzwpVar.zzf--;
                            zzwpVar.zzc();
                            zzwnVar = zzwnVar4;
                        }
                    }
                }
                zzwpVar.zzf--;
                zzwpVar.zzc();
            }
            i++;
        }
        return zzwpVar;
    }

    private final void zze(zzwn zzwnVar, StringBuilder sb) {
        for (zzwn zzwnVar2 : zzwnVar.zzd.values()) {
            sb.append("  ");
            sb.append(zzwnVar);
            sb.append(" -> ");
            sb.append(zzwnVar2);
            sb.append(" [label=\"");
            int[] iArr = this.zza;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, zzwnVar2.zza, Math.min(iArr.length, zzwnVar2.zzb + 1))));
            sb.append("\"]\n");
            zze(zzwnVar2, sb);
        }
    }

    private final boolean zzf(int i, int i2, int i3, int i4) {
        if (i >= 0 && i3 >= 0) {
            int[] iArr = this.zza;
            int length = iArr.length;
            int iMin = Math.min(length, i2);
            if (iMin - i == Math.min(length, i4) - i3) {
                for (int i5 = i; i5 <= iMin; i5++) {
                    if (iArr[i5] != iArr[(i3 + i5) - i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        zze(this.zzb, sb);
        sb.append("}");
        return sb.toString();
    }

    public final void zzb() {
        if (this.zze == 0) {
            return;
        }
        Map map = this.zzc.zzd;
        int[] iArr = this.zza;
        zzwn zzwnVar = (zzwn) map.get(Integer.valueOf(iArr[this.zzd]));
        while (true) {
            int i = (zzwnVar.zzb - zzwnVar.zza) + 1;
            int i2 = this.zze;
            if (i > i2) {
                return;
            }
            int i3 = this.zzd + i;
            this.zzd = i3;
            this.zzc = zzwnVar;
            int i4 = i2 - i;
            this.zze = i4;
            if (i4 > 0) {
                zzwnVar = (zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr[i3]));
            }
        }
    }

    public final void zzc() {
        zzwn zzwnVar = this.zzc.zzc;
        if (zzwnVar != null) {
            this.zzc = zzwnVar;
        } else {
            this.zzc = this.zzb;
            int i = this.zze;
            if (i > 0) {
                this.zze = i - 1;
            }
            if (this.zzf > 0) {
                this.zzd++;
            }
        }
        zzb();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzwo zzd() {
        int i;
        int i2;
        zzwm zzwmVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        zzwn zzwnVar = this.zzb;
        zzwm zzwmVar2 = new zzwm(zzwnVar, 0, -1, -1, null);
        arrayDeque.push(zzwmVar2);
        while (!arrayDeque.isEmpty()) {
            zzwm zzwmVar3 = (zzwm) arrayDeque.pop();
            for (zzwn zzwnVar2 : zzwmVar3.zzd.zzd.values()) {
                int i3 = zzwmVar3.zzb;
                int i4 = zzwmVar3.zzc;
                int i5 = zzwnVar2.zza;
                int i6 = zzwnVar2.zzb;
                if (zzf(i3, i4, i5, i6)) {
                    zzwmVar = new zzwm(zzwnVar2, zzwmVar3.zza + 1, i3, i4, null);
                } else {
                    if (zzwnVar2.zzd.isEmpty()) {
                        int i7 = zzwnVar2.zza;
                        if (zzf(i3, i4, i7, (i7 + i4) - i3)) {
                        }
                    }
                    zzwmVar = new zzwm(zzwnVar2, 1, zzwnVar2.zza, i6, null);
                }
                if (zzwmVar2.zza < zzwmVar.zza) {
                    zzwmVar2 = zzwmVar;
                }
                arrayDeque.push(zzwmVar);
            }
        }
        int[] iArr = this.zza;
        int iMin = Math.min(iArr.length, zzwmVar2.zzc + 1);
        int i8 = 0;
        loop2: while (true) {
            i = zzwmVar2.zzb;
            i2 = iMin - i;
            zzwnVar = (zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr[(i8 % i2) + i]));
            if (zzwnVar == null) {
                break;
            }
            for (int i9 = zzwnVar.zza; i9 < zzwnVar.zzb + 1 && i9 < iArr.length; i9++) {
                if (iArr[(i8 % i2) + i] != iArr[i9]) {
                    break loop2;
                }
                i8++;
            }
        }
        return new zzwo(i, iMin, i8 / i2);
    }
}
