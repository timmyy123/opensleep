package com.google.android.gms.internal.ads;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzibk extends zzibg {
    private final Object zza;

    public zzibk(Boolean bool) {
        Objects.requireNonNull(bool);
        this.zza = bool;
    }

    private static boolean zzl(zzibk zzibkVar) {
        Object obj = zzibkVar.zza;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzibk.class != obj.getClass()) {
            return false;
        }
        zzibk zzibkVar = (zzibk) obj;
        Object obj2 = this.zza;
        if (obj2 == null) {
            return zzibkVar.zza == null;
        }
        if (zzl(this) && zzl(zzibkVar)) {
            return ((obj2 instanceof BigInteger) || (zzibkVar.zza instanceof BigInteger)) ? zzk().equals(zzibkVar.zzk()) : zzh().longValue() == zzibkVar.zzh().longValue();
        }
        if (obj2 instanceof Number) {
            Object obj3 = zzibkVar.zza;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return zzj().compareTo(zzibkVar.zzj()) == 0;
                }
                double dZzi = zzi();
                double dZzi2 = zzibkVar.zzi();
                if (dZzi != dZzi2) {
                    return Double.isNaN(dZzi) && Double.isNaN(dZzi2);
                }
                return true;
            }
        }
        return obj2.equals(zzibkVar.zza);
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Object obj = this.zza;
        if (obj == null) {
            return 31;
        }
        if (zzl(this)) {
            jDoubleToLongBits = zzh().longValue();
        } else {
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(zzh().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final boolean zza() {
        return this.zza instanceof Boolean;
    }

    public final boolean zzb() {
        Object obj = this.zza;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(zzd());
    }

    public final boolean zzc() {
        return this.zza instanceof Number;
    }

    @Override // com.google.android.gms.internal.ads.zzibg
    public final String zzd() {
        Object obj = this.zza;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return zzh().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "Unexpected value type: ".concat(String.valueOf(obj.getClass())));
        return null;
    }

    public final Number zzh() {
        Object obj = this.zza;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new zzibo((String) obj);
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Primitive is neither a number nor a string");
        return null;
    }

    public final double zzi() {
        return this.zza instanceof Number ? zzh().doubleValue() : Double.parseDouble(zzd());
    }

    public final BigDecimal zzj() {
        Object obj = this.zza;
        return obj instanceof BigDecimal ? (BigDecimal) obj : zzibx.zza(zzd());
    }

    public final BigInteger zzk() {
        Object obj = this.zza;
        return obj instanceof BigInteger ? (BigInteger) obj : zzl(this) ? BigInteger.valueOf(zzh().longValue()) : zzibx.zzb(zzd());
    }

    public zzibk(Number number) {
        Objects.requireNonNull(number);
        this.zza = number;
    }

    public zzibk(String str) {
        Objects.requireNonNull(str);
        this.zza = str;
    }
}
