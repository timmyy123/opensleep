package com.google.android.gms.internal.serialization;

import com.google.android.gms.internal.serialization.zzyt;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzyu<T extends zzyt<T>> {
    private static final zzyu zze = new zzyu(true);
    final zzabl zza = new zzabh();
    private boolean zzc;
    private boolean zzd;

    private zzyu(boolean z) {
        zzb();
        zzb();
    }

    public static zzyu zza() {
        return zze;
    }

    public static void zzm(zzxb zzxbVar, zzace zzaceVar, int i, Object obj) {
        if (zzaceVar == zzace.zzj) {
            zzaaq zzaaqVar = (zzaaq) obj;
            zzzt.zzd(zzaaqVar);
            zzxbVar.zzO(i, 3);
            zzaaqVar.writeTo(zzxbVar);
            zzxbVar.zzO(i, 4);
            return;
        }
        zzxbVar.zzO(i, zzaceVar.zzb());
        zzacf zzacfVar = zzacf.INT;
        switch (zzaceVar.ordinal()) {
            case 0:
                zzxbVar.zzx(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzxbVar.zzv(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzxbVar.zzw(((Long) obj).longValue());
                break;
            case 3:
                zzxbVar.zzw(((Long) obj).longValue());
                break;
            case 4:
                zzxbVar.zzt(((Integer) obj).intValue());
                break;
            case 5:
                zzxbVar.zzx(((Long) obj).longValue());
                break;
            case 6:
                zzxbVar.zzv(((Integer) obj).intValue());
                break;
            case 7:
                zzxbVar.zzs(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzwr)) {
                    zzxbVar.zzz((String) obj);
                } else {
                    zzxbVar.zzm((zzwr) obj);
                }
                break;
            case 9:
                ((zzaaq) obj).writeTo(zzxbVar);
                break;
            case 10:
                zzxbVar.zzr((zzaaq) obj);
                break;
            case 11:
                if (!(obj instanceof zzwr)) {
                    byte[] bArr = (byte[]) obj;
                    zzxbVar.zzn(bArr, 0, bArr.length);
                } else {
                    zzxbVar.zzm((zzwr) obj);
                }
                break;
            case 12:
                zzxbVar.zzu(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zzzk)) {
                    zzxbVar.zzt(((Integer) obj).intValue());
                } else {
                    zzxbVar.zzt(((zzzk) obj).getNumber());
                }
                break;
            case 14:
                zzxbVar.zzv(((Integer) obj).intValue());
                break;
            case 15:
                zzxbVar.zzx(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzxbVar.zzu((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzxbVar.zzw((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public static int zzp(zzace zzaceVar, int i, Object obj) {
        int iZzD = zzxb.zzD(i << 3);
        if (zzaceVar == zzace.zzj) {
            zzzt.zzd((zzaaq) obj);
            iZzD += iZzD;
        }
        return iZzD + zzq(zzaceVar, obj);
    }

    public static int zzq(zzace zzaceVar, Object obj) {
        int iZzc;
        int iZzD;
        zzace zzaceVar2 = zzace.zza;
        zzacf zzacfVar = zzacf.INT;
        switch (zzaceVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzxb.$r8$clinit;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzxb.$r8$clinit;
                return 4;
            case 2:
                return zzxb.zzE(((Long) obj).longValue());
            case 3:
                return zzxb.zzE(((Long) obj).longValue());
            case 4:
                return zzxb.zzE(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i3 = zzxb.$r8$clinit;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i4 = zzxb.$r8$clinit;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i5 = zzxb.$r8$clinit;
                return 1;
            case 8:
                if (!(obj instanceof zzwr)) {
                    return zzxb.zzF((String) obj);
                }
                int i6 = zzxb.$r8$clinit;
                iZzc = ((zzwr) obj).zzc();
                iZzD = zzxb.zzD(iZzc);
                break;
                break;
            case 9:
                int i7 = zzxb.$r8$clinit;
                return ((zzaaq) obj).getSerializedSize();
            case 10:
                return zzxb.zzG((zzaaq) obj);
            case 11:
                if (!(obj instanceof zzwr)) {
                    int i8 = zzxb.$r8$clinit;
                    iZzc = ((byte[]) obj).length;
                    iZzD = zzxb.zzD(iZzc);
                } else {
                    int i9 = zzxb.$r8$clinit;
                    iZzc = ((zzwr) obj).zzc();
                    iZzD = zzxb.zzD(iZzc);
                }
                break;
            case 12:
                return zzxb.zzD(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzzk ? zzxb.zzE(((zzzk) obj).getNumber()) : zzxb.zzE(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i10 = zzxb.$r8$clinit;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i11 = zzxb.$r8$clinit;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzxb.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzxb.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                Types$$ExternalSyntheticBUOutline0.m$2("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
        return iZzD + iZzc;
    }

    public static int zzr(zzyt zzytVar, Object obj) {
        zzace zzaceVarZzb = zzytVar.zzb();
        int iZza = zzytVar.zza();
        if (!zzytVar.zzd()) {
            return zzp(zzaceVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzytVar.zze()) {
            int iZzp = 0;
            while (i < size) {
                iZzp += zzp(zzaceVarZzb, iZza, list.get(i));
                i++;
            }
            return iZzp;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzq = 0;
        while (i < size) {
            iZzq += zzq(zzaceVarZzb, list.get(i));
            i++;
        }
        return zzxb.zzD(iZzq) + zzxb.zzD(iZza << 3) + iZzq;
    }

    private static boolean zzs(Map.Entry entry) {
        zzyt zzytVar = (zzyt) entry.getKey();
        if (zzytVar.zzc() != zzacf.MESSAGE) {
            return true;
        }
        if (!zzytVar.zzd()) {
            return zzt(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzt(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzt(Object obj) {
        if (obj instanceof zzaar) {
            return ((zzaar) obj).isInitialized();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong object type used with protocol message reflection.");
        return false;
    }

    private static Object zzu(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzv(Map.Entry entry) {
        zzyt zzytVar = (zzyt) entry.getKey();
        Object value = entry.getValue();
        if (!zzytVar.zzd()) {
            if (zzytVar.zzc() != zzacf.MESSAGE) {
                this.zza.put(zzytVar, zzu(value));
                return;
            }
            Object objZzf = zzf(zzytVar);
            if (objZzf == null) {
                this.zza.put(zzytVar, zzu(value));
                return;
            } else {
                this.zza.put(zzytVar, zzytVar.zzf(((zzaaq) objZzf).toBuilder(), (zzaaq) value).build());
                return;
            }
        }
        Object objZzf2 = zzf(zzytVar);
        List list = (List) value;
        int size = list.size();
        if (objZzf2 == null) {
            objZzf2 = new ArrayList(size);
        }
        List list2 = (List) objZzf2;
        for (int i = 0; i < size; i++) {
            list2.add(zzu(list.get(i)));
        }
        this.zza.put(zzytVar, objZzf2);
    }

    private static final int zzw(Map.Entry entry) {
        zzyt zzytVar = (zzyt) entry.getKey();
        Object value = entry.getValue();
        if (zzytVar.zzc() != zzacf.MESSAGE || zzytVar.zzd() || zzytVar.zze()) {
            return zzr(zzytVar, value);
        }
        int iZza = ((zzyt) entry.getKey()).zza();
        int iZzD = zzxb.zzD(8);
        int iZzD2 = zzxb.zzD(iZza) + zzxb.zzD(16);
        return iZzD + iZzD + iZzD2 + zzxb.zzG((zzaaq) value) + zzxb.zzD(24);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static final void zzx(zzyt zzytVar, Object obj) {
        boolean z;
        zzytVar.zzb();
        byte[] bArr = zzzt.zzb;
        obj.getClass();
        zzace zzaceVar = zzace.zza;
        zzacf zzacfVar = zzacf.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case BYTE_STRING:
                if ((obj instanceof zzwr) || (obj instanceof byte[])) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzzk)) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            case MESSAGE:
                if (obj instanceof zzaaq) {
                }
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzytVar.zza()), zzytVar.zzb().zza(), obj.getClass().getName()});
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzyu) {
            return this.zza.equals(((zzyu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        zzabl zzablVar;
        if (this.zzc) {
            return;
        }
        int iZzc = this.zza.zzc();
        int i = 0;
        while (true) {
            zzablVar = this.zza;
            if (i >= iZzc) {
                break;
            }
            Object value = zzablVar.zzd(i).getValue();
            if (value instanceof zzzg) {
                ((zzzg) value).makeImmutable();
            }
            i++;
        }
        Iterator it = zzablVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzzg) {
                ((zzzg) value2).makeImmutable();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzyu clone() {
        zzabl zzablVar;
        zzyu zzyuVar = new zzyu();
        int iZzc = this.zza.zzc();
        int i = 0;
        while (true) {
            zzablVar = this.zza;
            if (i >= iZzc) {
                break;
            }
            Map.Entry entryZzd = zzablVar.zzd(i);
            zzyuVar.zzg((zzyt) ((zzabi) entryZzd).zza(), entryZzd.getValue());
            i++;
        }
        for (Map.Entry entry : zzablVar.zze()) {
            zzyuVar.zzg((zzyt) entry.getKey(), entry.getValue());
        }
        zzyuVar.zzd = this.zzd;
        return zzyuVar;
    }

    public final Iterator zze() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z = this.zzd;
        zzabl zzablVar = this.zza;
        return z ? new zzzy(zzablVar.entrySet().iterator()) : zzablVar.entrySet().iterator();
    }

    public final Object zzf(zzyt zzytVar) {
        return this.zza.get(zzytVar);
    }

    public final void zzg(zzyt zzytVar, Object obj) {
        if (!zzytVar.zzd()) {
            zzx(zzytVar, obj);
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
                zzx(zzytVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        this.zza.put(zzytVar, obj);
    }

    public final void zzj(zzyt zzytVar, Object obj) {
        List arrayList;
        if (!((zzzd) zzytVar).zzd) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("addRepeatedField() can only be called on repeated fields.");
            return;
        }
        zzx(zzytVar, obj);
        Object objZzf = zzf(zzytVar);
        if (objZzf == null) {
            arrayList = new ArrayList();
            this.zza.put(zzytVar, arrayList);
        } else {
            arrayList = (List) objZzf;
        }
        arrayList.add(obj);
    }

    public final boolean zzk() {
        int iZzc = this.zza.zzc();
        int i = 0;
        while (true) {
            zzabl zzablVar = this.zza;
            if (i >= iZzc) {
                Iterator it = zzablVar.zze().iterator();
                while (it.hasNext()) {
                    if (!zzs((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!zzs(zzablVar.zzd(i))) {
                return false;
            }
            i++;
        }
    }

    public final void zzl(zzyu zzyuVar) {
        zzabl zzablVar;
        int iZzc = zzyuVar.zza.zzc();
        int i = 0;
        while (true) {
            zzablVar = zzyuVar.zza;
            if (i >= iZzc) {
                break;
            }
            zzv(zzablVar.zzd(i));
            i++;
        }
        Iterator it = zzablVar.zze().iterator();
        while (it.hasNext()) {
            zzv((Map.Entry) it.next());
        }
    }

    public final int zzn() {
        zzabl zzablVar;
        int iZzc = this.zza.zzc();
        int i = 0;
        int iZzr = 0;
        while (true) {
            zzablVar = this.zza;
            if (i >= iZzc) {
                break;
            }
            Map.Entry entryZzd = zzablVar.zzd(i);
            iZzr += zzr((zzyt) ((zzabi) entryZzd).zza(), entryZzd.getValue());
            i++;
        }
        for (Map.Entry entry : zzablVar.zze()) {
            iZzr += zzr((zzyt) entry.getKey(), entry.getValue());
        }
        return iZzr;
    }

    public final int zzo() {
        zzabl zzablVar;
        int iZzc = this.zza.zzc();
        int i = 0;
        int iZzw = 0;
        while (true) {
            zzablVar = this.zza;
            if (i >= iZzc) {
                break;
            }
            iZzw += zzw(zzablVar.zzd(i));
            i++;
        }
        Iterator it = zzablVar.zze().iterator();
        while (it.hasNext()) {
            iZzw += zzw((Map.Entry) it.next());
        }
        return iZzw;
    }

    private zzyu() {
    }
}
