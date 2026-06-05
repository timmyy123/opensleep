package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyy extends zzabm implements zzabi {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    public zzyy(zzaaf zzaafVar, Object[] objArr, StringBuilder sb) {
        super(zzaafVar);
        this.zzc = 0;
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zza(zzzd zzzdVar, StringBuilder sb) {
        if (zzzdVar.zzh() == null) {
            sb.append(zzzh.zza(zzzdVar.zzj()));
            return sb;
        }
        zzyy zzyyVar = new zzyy(zzzdVar.zzh(), zzzdVar.zzi(), sb);
        StringBuilder sb2 = (StringBuilder) zzyyVar.zzl();
        if (zzzdVar.zzi().length > zzyyVar.zzj()) {
            sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
        }
        return sb2;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzzh.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final void zzb(int i, int i2, zzabh zzabhVar) {
        zzh().zzd(this.zzb, zzi(), this.zzc, i);
        zzabhVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    @Override // com.google.android.gms.internal.measurement.zzabi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(Object obj, zzyz zzyzVar, zzza zzzaVar) {
        boolean zIsValidCodePoint;
        int iOrdinal = zzyzVar.zzc().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                zIsValidCodePoint = obj instanceof Boolean;
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        throw null;
                    }
                    zIsValidCodePoint = (obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal);
                } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof BigInteger)) {
                }
            } else if (!(obj instanceof Character)) {
                if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                    zIsValidCodePoint = Character.isValidCodePoint(((Number) obj).intValue());
                }
            }
            if (!zIsValidCodePoint) {
                zzm(this.zzb, obj, zzyzVar.zze());
                return;
            }
        }
        StringBuilder sb = this.zzb;
        int iOrdinal2 = zzyzVar.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                if (zzzaVar.zze()) {
                    sb.append(obj);
                    return;
                }
            } else if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3) {
                    if (iOrdinal2 == 5 && zzzaVar.zzd(128, false, false).equals(zzzaVar)) {
                        zzzh.zzc(sb, (Number) obj, zzzaVar);
                        return;
                    }
                }
            } else if (zzzaVar.zze()) {
                if (obj instanceof Character) {
                    sb.append(obj);
                    return;
                }
                int iIntValue = ((Number) obj).intValue();
                if ((iIntValue >>> 16) == 0) {
                    sb.append((char) iIntValue);
                    return;
                } else {
                    sb.append(Character.toChars(iIntValue));
                    return;
                }
            }
        } else if (obj instanceof Formattable) {
            zzzh.zzb((Formattable) obj, sb, zzzaVar);
            return;
        } else if (zzzaVar.zze()) {
            sb.append(zzzh.zza(obj));
            return;
        }
        String strZze = zzyzVar.zze();
        if (!zzzaVar.zze()) {
            int iZzb = zzyzVar.zzb();
            if (zzzaVar.zzk()) {
                iZzb &= 65503;
            }
            StringBuilder sb2 = new StringBuilder("%");
            zzzaVar.zzl(sb2);
            sb2.append((char) iZzb);
            strZze = sb2.toString();
        }
        sb.append(String.format(zzzh.zza, strZze, obj));
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzd(Object obj, zzabf zzabfVar, zzza zzzaVar) {
        if (!(obj instanceof Date) && !(obj instanceof Calendar) && !(obj instanceof Long)) {
            StringBuilder sb = this.zzb;
            char cZzb = zzabfVar.zzb();
            zzm(sb, obj, FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(cZzb).length() + 2), "%t", cZzb));
        } else {
            StringBuilder sb2 = new StringBuilder("%");
            zzzaVar.zzl(sb2);
            sb2.append(true != zzzaVar.zzk() ? 't' : 'T');
            sb2.append(zzabfVar.zzb());
            this.zzb.append(String.format(zzzh.zza, sb2.toString(), obj));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zze() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzf() {
        this.zzb.append("null");
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final /* bridge */ /* synthetic */ Object zzg() {
        zzabn zzabnVarZzh = zzh();
        String strZzi = zzi();
        int i = this.zzc;
        int length = zzi().length();
        StringBuilder sb = this.zzb;
        zzabnVarZzh.zzd(sb, strZzi, i, length);
        return sb;
    }
}
