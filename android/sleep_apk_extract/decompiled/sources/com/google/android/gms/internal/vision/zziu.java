package com.google.android.gms.internal.vision;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.internal.vision.zziw;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
final class zziu<T extends zziw<T>> {
    private static final zziu zzd = new zziu(true);
    final zzlh<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zziu() {
        this.zza = zzlh.zza(16);
    }

    private static int zza(zzml zzmlVar, Object obj) {
        switch (zzit.zzb[zzmlVar.ordinal()]) {
            case 1:
                return zzii.zzb(((Double) obj).doubleValue());
            case 2:
                return zzii.zzb(((Float) obj).floatValue());
            case 3:
                return zzii.zzd(((Long) obj).longValue());
            case 4:
                return zzii.zze(((Long) obj).longValue());
            case 5:
                return zzii.zzf(((Integer) obj).intValue());
            case 6:
                return zzii.zzg(((Long) obj).longValue());
            case 7:
                return zzii.zzi(((Integer) obj).intValue());
            case 8:
                return zzii.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzii.zzc((zzkk) obj);
            case 10:
                return zzii.zzb((zzkk) obj);
            case 11:
                return obj instanceof zzht ? zzii.zzb((zzht) obj) : zzii.zzb((String) obj);
            case 12:
                return obj instanceof zzht ? zzii.zzb((zzht) obj) : zzii.zzb((byte[]) obj);
            case 13:
                return zzii.zzg(((Integer) obj).intValue());
            case 14:
                return zzii.zzj(((Integer) obj).intValue());
            case 15:
                return zzii.zzh(((Long) obj).longValue());
            case 16:
                return zzii.zzh(((Integer) obj).intValue());
            case 17:
                return zzii.zzf(((Long) obj).longValue());
            case 18:
                return obj instanceof zzje ? zzii.zzk(((zzje) obj).zza()) : zzii.zzk(((Integer) obj).intValue());
            default:
                Types$$ExternalSyntheticBUOutline0.m$2("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        entry.getValue();
        throw null;
    }

    public static int zzc(zziw<?> zziwVar, Object obj) {
        zzml zzmlVarZzb = zziwVar.zzb();
        int iZza = zziwVar.zza();
        if (!zziwVar.zzd()) {
            return zza(zzmlVarZzb, iZza, obj);
        }
        int iZza2 = 0;
        if (!zziwVar.zze()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iZza2 += zza(zzmlVarZzb, iZza, it.next());
            }
            return iZza2;
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iZza2 += zza(zzmlVarZzb, it2.next());
        }
        return zzii.zzl(iZza2) + zzii.zze(iZza) + iZza2;
    }

    private static void zzd(T t, Object obj) {
        zzml zzmlVarZzb = t.zzb();
        zzjf.zza(obj);
        boolean z = true;
        switch (zzit.zza[zzmlVarZzb.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzht) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzje)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzkk)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.zza()), t.zzb().zza(), obj.getClass().getName()});
    }

    public final /* synthetic */ Object clone() {
        zziu zziuVar = new zziu();
        int i = 0;
        while (true) {
            int iZzc = this.zza.zzc();
            zzlh<T, Object> zzlhVar = this.zza;
            if (i >= iZzc) {
                Iterator it = zzlhVar.zzd().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getKey() != null) {
                        Events$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                    zziuVar.zza((zziw) null, entry.getValue());
                }
                zziuVar.zzc = this.zzc;
                return zziuVar;
            }
            Map.Entry<K, Object> entryZzb = zzlhVar.zzb(i);
            if (entryZzb.getKey() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            zziuVar.zza((zziw) null, entryZzb.getValue());
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zziu) {
            return this.zza.equals(((zziu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zze() {
        boolean z = this.zzc;
        zzlh<T, Object> zzlhVar = this.zza;
        return z ? new zzjq(zzlhVar.zze().iterator()) : zzlhVar.zze().iterator();
    }

    public final boolean zzf() {
        int i = 0;
        while (true) {
            int iZzc = this.zza.zzc();
            zzlh<T, Object> zzlhVar = this.zza;
            if (i >= iZzc) {
                Iterator it = zzlhVar.zzd().iterator();
                while (it.hasNext()) {
                    if (!zza((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!zza(zzlhVar.zzb(i))) {
                return false;
            }
            i++;
        }
    }

    public final int zzg() {
        zzlh<T, Object> zzlhVar;
        int i = 0;
        int iZzc = 0;
        while (true) {
            int iZzc2 = this.zza.zzc();
            zzlhVar = this.zza;
            if (i >= iZzc2) {
                break;
            }
            iZzc += zzc(zzlhVar.zzb(i));
            i++;
        }
        Iterator it = zzlhVar.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private zziu(boolean z) {
        this(zzlh.zza(0));
        zzb();
    }

    private zziu(zzlh<T, Object> zzlhVar) {
        this.zza = zzlhVar;
        zzb();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        if (entry.getKey() == null) {
            entry.getValue();
            throw null;
        }
        throw new ClassCastException();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        boolean z = this.zzc;
        zzlh<T, Object> zzlhVar = this.zza;
        if (z) {
            return new zzjq(zzlhVar.entrySet().iterator());
        }
        return zzlhVar.entrySet().iterator();
    }

    public final void zza(T t, Object obj) {
        if (t.zzd()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    zzd(t, obj2);
                }
                obj = arrayList;
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Wrong object type used with protocol message reflection.");
                return;
            }
        } else {
            zzd(t, obj);
        }
        this.zza.put(t, obj);
    }

    public final void zza(zziu<T> zziuVar) {
        zzlh<T, Object> zzlhVar;
        int i = 0;
        while (true) {
            int iZzc = zziuVar.zza.zzc();
            zzlhVar = zziuVar.zza;
            if (i >= iZzc) {
                break;
            }
            zzb(zzlhVar.zzb(i));
            i++;
        }
        Iterator it = zzlhVar.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    public static int zza(zzml zzmlVar, int i, Object obj) {
        int iZze = zzii.zze(i);
        if (zzmlVar == zzml.zzj) {
            zzjf.zza((zzkk) obj);
            iZze <<= 1;
        }
        return iZze + zza(zzmlVar, obj);
    }

    private static <T extends zziw<T>> boolean zza(Map.Entry<T, Object> entry) {
        throw Fragment$$ExternalSyntheticOutline1.m(entry);
    }
}
