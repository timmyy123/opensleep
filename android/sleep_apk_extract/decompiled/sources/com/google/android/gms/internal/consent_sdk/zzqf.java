package com.google.android.gms.internal.consent_sdk;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzqf {
    private static final zzqf zzd = new zzqf(true);
    final zzsi zza = new zzsd();
    boolean zzb;
    boolean zzc;

    private zzqf(boolean z) {
        zzg();
        zzg();
    }

    public static int zza(zzsz zzszVar, int i, Object obj) {
        int iZzC = zzpv.zzC(i << 3);
        if (zzszVar == zzsz.zzj) {
            iZzC += iZzC;
        }
        return iZzC + zzb(zzszVar, obj);
    }

    public static int zzb(zzsz zzszVar, Object obj) {
        int iZzd;
        int iZzC;
        zzsz zzszVar2 = zzsz.zza;
        zzta zztaVar = zzta.INT;
        switch (zzszVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzpv.$r8$clinit;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzpv.$r8$clinit;
                return 4;
            case 2:
                return zzpv.zzD(((Long) obj).longValue());
            case 3:
                return zzpv.zzD(((Long) obj).longValue());
            case 4:
                return zzpv.zzD(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i3 = zzpv.$r8$clinit;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i4 = zzpv.$r8$clinit;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i5 = zzpv.$r8$clinit;
                return 1;
            case 8:
                if (!(obj instanceof zzpm)) {
                    return zzpv.zzB((String) obj);
                }
                int i6 = zzpv.$r8$clinit;
                iZzd = ((zzpm) obj).zzd();
                iZzC = zzpv.zzC(iZzd);
                break;
                break;
            case 9:
                return ((zzrq) obj).zzn();
            case 10:
                return zzpv.zzA((zzrq) obj);
            case 11:
                if (!(obj instanceof zzpm)) {
                    int i7 = zzpv.$r8$clinit;
                    iZzd = ((byte[]) obj).length;
                    iZzC = zzpv.zzC(iZzd);
                } else {
                    int i8 = zzpv.$r8$clinit;
                    iZzd = ((zzpm) obj).zzd();
                    iZzC = zzpv.zzC(iZzd);
                }
                break;
            case 12:
                return zzpv.zzC(((Integer) obj).intValue());
            case 13:
                return zzpv.zzD(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i9 = zzpv.$r8$clinit;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i10 = zzpv.$r8$clinit;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzpv.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzpv.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                Types$$ExternalSyntheticBUOutline0.m$2("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
        return iZzC + iZzd;
    }

    public static void zzi(zzpv zzpvVar, zzsz zzszVar, int i, Object obj) {
        if (zzszVar == zzsz.zzj) {
            zzpvVar.zzu(i, 3);
            ((zzrq) obj).zzB(zzpvVar);
            zzpvVar.zzu(i, 4);
            return;
        }
        zzpvVar.zzu(i, zzszVar.zza());
        zzta zztaVar = zzta.INT;
        switch (zzszVar.ordinal()) {
            case 0:
                zzpvVar.zzm(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzpvVar.zzk(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzpvVar.zzy(((Long) obj).longValue());
                break;
            case 3:
                zzpvVar.zzy(((Long) obj).longValue());
                break;
            case 4:
                zzpvVar.zzo(((Integer) obj).intValue());
                break;
            case 5:
                zzpvVar.zzm(((Long) obj).longValue());
                break;
            case 6:
                zzpvVar.zzk(((Integer) obj).intValue());
                break;
            case 7:
                zzpvVar.zzJ(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzpm)) {
                    zzpvVar.zzt((String) obj);
                } else {
                    zzpvVar.zzi((zzpm) obj);
                }
                break;
            case 9:
                ((zzrq) obj).zzB(zzpvVar);
                break;
            case 10:
                zzpvVar.zzp((zzrq) obj);
                break;
            case 11:
                if (!(obj instanceof zzpm)) {
                    byte[] bArr = (byte[]) obj;
                    zzpvVar.zzL(bArr, 0, bArr.length);
                } else {
                    zzpvVar.zzi((zzpm) obj);
                }
                break;
            case 12:
                zzpvVar.zzw(((Integer) obj).intValue());
                break;
            case 13:
                zzpvVar.zzo(((Integer) obj).intValue());
                break;
            case 14:
                zzpvVar.zzk(((Integer) obj).intValue());
                break;
            case 15:
                zzpvVar.zzm(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzpvVar.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzpvVar.zzy((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static final void zzn(zzqe zzqeVar, Object obj) {
        boolean z;
        zzqeVar.zzb();
        byte[] bArr = zzqs.zzb;
        obj.getClass();
        zzsz zzszVar = zzsz.zza;
        zzta zztaVar = zzta.INT;
        switch (r0.zzb()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case BYTE_STRING:
                if ((obj instanceof zzpm) || (obj instanceof byte[])) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case ENUM:
                if (obj instanceof Integer) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            case MESSAGE:
                if (obj instanceof zzrq) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzqeVar.zza()), zzqeVar.zzb().zzb(), obj.getClass().getName()});
                break;
        }
    }

    public final /* synthetic */ Object clone() {
        zzqf zzqfVar = new zzqf();
        zzsi zzsiVar = this.zza;
        int iZzc = zzsiVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zzsiVar.zzg(i);
            if (((zzse) entryZzg).zza() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            zzqfVar.zzh(null, entryZzg.getValue());
        }
        for (Map.Entry entry : zzsiVar.zzd()) {
            if (entry.getKey() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            zzqfVar.zzh(null, entry.getValue());
        }
        zzqfVar.zzc = this.zzc;
        return zzqfVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqf) {
            return this.zza.equals(((zzqf) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzg() {
        if (this.zzb) {
            return;
        }
        zzsi zzsiVar = this.zza;
        int iZzc = zzsiVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzsiVar.zzg(i).getValue();
            if (value instanceof zzqm) {
                ((zzqm) value).zzx();
            }
        }
        Iterator it = zzsiVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzqm) {
                ((zzqm) value2).zzx();
            }
        }
        zzsiVar.zza();
        this.zzb = true;
    }

    public final void zzh(zzqe zzqeVar, Object obj) {
        if (!zzqeVar.zze()) {
            zzn(zzqeVar, obj);
        } else {
            if (!(obj instanceof List)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong object type used with protocol message reflection.");
                return;
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzqeVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        this.zza.put(zzqeVar, obj);
    }

    private zzqf() {
    }
}
