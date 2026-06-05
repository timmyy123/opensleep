package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzidt {
    private static final zzidt zzd = new zzidt(true);
    final zzign zza = new zzigj();
    boolean zzb;
    boolean zzc;

    private zzidt(boolean z) {
        zzb();
        zzb();
    }

    public static void zzf(zzidj zzidjVar, zzihg zzihgVar, int i, Object obj) {
        if (zzihgVar == zzihg.zzj) {
            zzidjVar.zzb(i, 3);
            ((zzifp) obj).zzcX(zzidjVar);
            zzidjVar.zzb(i, 4);
            return;
        }
        zzidjVar.zzb(i, zzihgVar.zzb());
        zzihh zzihhVar = zzihh.INT;
        switch (zzihgVar.ordinal()) {
            case 0:
                zzidjVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzidjVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzidjVar.zzt(((Long) obj).longValue());
                break;
            case 3:
                zzidjVar.zzt(((Long) obj).longValue());
                break;
            case 4:
                zzidjVar.zzq(((Integer) obj).intValue());
                break;
            case 5:
                zzidjVar.zzu(((Long) obj).longValue());
                break;
            case 6:
                zzidjVar.zzs(((Integer) obj).intValue());
                break;
            case 7:
                zzidjVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzida)) {
                    zzidjVar.zzw((String) obj);
                } else {
                    zzidjVar.zzk((zzida) obj);
                }
                break;
            case 9:
                ((zzifp) obj).zzcX(zzidjVar);
                break;
            case 10:
                zzidjVar.zzo((zzifp) obj);
                break;
            case 11:
                if (!(obj instanceof zzida)) {
                    byte[] bArr = (byte[]) obj;
                    zzidjVar.zzl(bArr, 0, bArr.length);
                } else {
                    zzidjVar.zzk((zzida) obj);
                }
                break;
            case 12:
                zzidjVar.zzr(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zziei)) {
                    zzidjVar.zzq(((Integer) obj).intValue());
                } else {
                    zzidjVar.zzq(((zziei) obj).zza());
                }
                break;
            case 14:
                zzidjVar.zzs(((Integer) obj).intValue());
                break;
            case 15:
                zzidjVar.zzu(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzidjVar.zzr((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzidjVar.zzt((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public static int zzh(zzihg zzihgVar, int i, Object obj) {
        int iZzF = zzidj.zzF(i << 3);
        if (zzihgVar == zzihg.zzj) {
            iZzF += iZzF;
        }
        return iZzF + zzi(zzihgVar, obj);
    }

    public static int zzi(zzihg zzihgVar, Object obj) {
        int iZzc;
        int iZzF;
        zzihg zzihgVar2 = zzihg.zza;
        zzihh zzihhVar = zzihh.INT;
        switch (zzihgVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzidj.$r8$clinit;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzidj.$r8$clinit;
                return 4;
            case 2:
                return zzidj.zzG(((Long) obj).longValue());
            case 3:
                return zzidj.zzG(((Long) obj).longValue());
            case 4:
                return zzidj.zzG(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i3 = zzidj.$r8$clinit;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i4 = zzidj.$r8$clinit;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i5 = zzidj.$r8$clinit;
                return 1;
            case 8:
                if (!(obj instanceof zzida)) {
                    int i6 = zzidj.$r8$clinit;
                    iZzc = zzihf.zzc((String) obj);
                    iZzF = zzidj.zzF(iZzc);
                } else {
                    int i7 = zzidj.$r8$clinit;
                    iZzc = ((zzida) obj).zzb();
                    iZzF = zzidj.zzF(iZzc);
                }
                break;
            case 9:
                return ((zzifp) obj).zzbr();
            case 10:
                return zzidj.zzH((zzifp) obj);
            case 11:
                if (!(obj instanceof zzida)) {
                    int i8 = zzidj.$r8$clinit;
                    iZzc = ((byte[]) obj).length;
                    iZzF = zzidj.zzF(iZzc);
                } else {
                    int i9 = zzidj.$r8$clinit;
                    iZzc = ((zzida) obj).zzb();
                    iZzF = zzidj.zzF(iZzc);
                }
                break;
            case 12:
                return zzidj.zzF(((Integer) obj).intValue());
            case 13:
                return obj instanceof zziei ? zzidj.zzG(((zziei) obj).zza()) : zzidj.zzG(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i10 = zzidj.$r8$clinit;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i11 = zzidj.$r8$clinit;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzidj.zzF((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzidj.zzG((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                Types$$ExternalSyntheticBUOutline0.m$2("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
        return iZzF + iZzc;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static final void zzn(zzids zzidsVar, Object obj) {
        boolean z;
        zzihg zzihgVarZzb = zzidsVar.zzb();
        obj.getClass();
        zzihg zzihgVar = zzihg.zza;
        zzihh zzihhVar = zzihh.INT;
        switch (zzihgVarZzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 1:
                z = obj instanceof Long;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 2:
                z = obj instanceof Float;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 3:
                z = obj instanceof Double;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 5:
                z = obj instanceof String;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 6:
                if ((obj instanceof zzida) || (obj instanceof byte[])) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zziei)) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            case 8:
                if (obj instanceof zzifp) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzidsVar.zza()), zzidsVar.zzb().zza(), obj.getClass().getName()});
                break;
        }
    }

    public final /* synthetic */ Object clone() {
        zzidt zzidtVar = new zzidt();
        zzign zzignVar = this.zza;
        int iZzc = zzignVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzd = zzignVar.zzd(i);
            if (((zzigk) entryZzd).zza() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            zzidtVar.zzd(null, entryZzd.getValue());
        }
        for (Map.Entry entry : zzignVar.zze()) {
            if (entry.getKey() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            zzidtVar.zzd(null, entry.getValue());
        }
        zzidtVar.zzc = this.zzc;
        return zzidtVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzidt) {
            return this.zza.equals(((zzidt) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzign zzignVar = this.zza;
        int iZzc = zzignVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzignVar.zzd(i).getValue();
            if (value instanceof zziee) {
                ((zziee) value).zzbm();
            }
        }
        Iterator it = zzignVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zziee) {
                ((zziee) value2).zzbm();
            }
        }
        zzignVar.zza();
        this.zzb = true;
    }

    public final void zzd(zzids zzidsVar, Object obj) {
        if (!zzidsVar.zzd()) {
            zzn(zzidsVar, obj);
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
                zzn(zzidsVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        this.zza.put(zzidsVar, obj);
    }

    private zzidt() {
    }
}
