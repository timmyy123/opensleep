package com.google.android.gms.internal.measurement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.util.HashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmw {
    private static final zzmw zza = new zzmw(ImmutableSortedSet.of());
    private final ImmutableSortedSet zzb;

    public zzmw(ImmutableSortedSet immutableSortedSet) {
        this.zzb = immutableSortedSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzmw zza(zzmw zzmwVar, ImmutableMap immutableMap) {
        zzmw zzmwVar2;
        long j;
        long j2;
        if (immutableMap.isEmpty()) {
            return zzmwVar;
        }
        HashMap mapNewHashMap = Maps.newHashMap(immutableMap);
        ImmutableSortedSet immutableSortedSet = zzmwVar.zzb;
        ImmutableSortedSet.Builder builderNaturalOrder = ImmutableSortedSet.naturalOrder();
        UnmodifiableIterator it = immutableSortedSet.iterator();
        while (true) {
            zzmw zzmwVar3 = null;
            if (!it.hasNext()) {
                for (String str : mapNewHashMap.keySet()) {
                    Object obj = mapNewHashMap.get(str);
                    int length = str.length();
                    if (length > 19) {
                        zzmwVar2 = zzmwVar3;
                        j = 0;
                        j2 = j;
                    } else {
                        if (length == 0) {
                            zzmwVar2 = zzmwVar3;
                            j = 0;
                            j2 = 0;
                            break;
                        }
                        boolean z = false;
                        long jCharAt = str.charAt(0) - '0';
                        if (jCharAt >= 1) {
                            if (jCharAt <= 9) {
                                int i = 1;
                                while (i < length) {
                                    int iCharAt = str.charAt(i) - '0';
                                    zzmwVar2 = zzmwVar3;
                                    if (!((iCharAt < 0 ? true : z) | (iCharAt > 9 ? true : z))) {
                                        jCharAt = (jCharAt * 10) + ((long) iCharAt);
                                        i++;
                                        z = false;
                                        zzmwVar3 = zzmwVar2;
                                    }
                                }
                                zzmwVar2 = zzmwVar3;
                                j = 0;
                                if (jCharAt >= 0 && jCharAt <= 2305843009213693951L) {
                                    j2 = jCharAt;
                                }
                            }
                            j = 0;
                            j2 = 0;
                            break;
                        }
                        j2 = j;
                    }
                    String str2 = j2 == j ? str : zzmwVar2;
                    if (obj instanceof String) {
                        builderNaturalOrder.add(new zzmv(j2, str2, 4, 0L, obj));
                    } else if (obj instanceof byte[]) {
                        builderNaturalOrder.add(new zzmv(j2, str2, 5, 0L, obj));
                    } else if (obj instanceof Boolean) {
                        builderNaturalOrder.add(new zzmv(j2, str2, ((Boolean) obj).booleanValue() ? 1 : 0, 0L, null));
                    } else if (obj instanceof Long) {
                        builderNaturalOrder.add(new zzmv(j2, str2, 2, ((Long) obj).longValue(), null));
                    } else {
                        if (!(obj instanceof Double)) {
                            String strValueOf = String.valueOf(obj);
                            Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + 28 + strValueOf.length()), "Cannot serialize override ", str, ": ", strValueOf));
                            return zzmwVar2;
                        }
                        builderNaturalOrder.add(new zzmv(j2, str2, 3, Double.doubleToRawLongBits(((Double) obj).doubleValue()), null));
                    }
                    zzmwVar3 = zzmwVar2;
                }
                return new zzmw(builderNaturalOrder.build());
            }
            zzmv zzmvVar = (zzmv) it.next();
            Object objRemove = mapNewHashMap.remove(zzmvVar.zza());
            if (objRemove == null) {
                builderNaturalOrder.add(zzmvVar);
            } else if (objRemove instanceof String) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 4, 0L, objRemove));
            } else if (objRemove instanceof byte[]) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 5, 0L, objRemove));
            } else if (objRemove instanceof Boolean) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, ((Boolean) objRemove).booleanValue() ? 1 : 0, 0L, null));
            } else if (objRemove instanceof Long) {
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 2, ((Long) objRemove).longValue(), null));
            } else {
                if (!(objRemove instanceof Double)) {
                    String strZza = zzmvVar.zza();
                    String string = objRemove.toString();
                    Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(zzba$$ExternalSyntheticOutline0.m(46, strZza) + string.length()), "Cannot serialize override for existing flag ", strZza, ": ", string));
                    return null;
                }
                builderNaturalOrder.add(new zzmv(zzmvVar.zza, zzmvVar.zzb, 3, Double.doubleToRawLongBits(((Double) objRemove).doubleValue()), null));
            }
        }
    }

    public static zzmw zzb() {
        return zza;
    }

    public static zzmw zzd(zzacv zzacvVar) throws zzaeh {
        String strZzl;
        long j;
        zzmv zzmvVar;
        int iZzx = zzacvVar.zzx();
        if (iZzx < 0) {
            Gson$$ExternalSyntheticBUOutline0.m$1("Negative number of flags");
            return null;
        }
        ImmutableSortedSet.Builder builderNaturalOrder = ImmutableSortedSet.naturalOrder();
        long j2 = 0;
        for (int i = 0; i < iZzx; i++) {
            long jZzz = zzacvVar.zzz();
            int i2 = (int) jZzz;
            long j3 = jZzz >>> 3;
            if (j3 == 0) {
                j = 0;
                strZzl = zzacvVar.zzl();
            } else {
                long j4 = j3 + j2;
                if (j4 > 2305843009213693951L) {
                    Gson$$ExternalSyntheticBUOutline0.m$1("Flag name larger than max size");
                    return null;
                }
                strZzl = null;
                j = j4;
            }
            int i3 = i2 & 7;
            if (i3 == 0 || i3 == 1) {
                zzmvVar = new zzmv(j, strZzl, i3, 0L, null);
            } else if (i3 == 2) {
                zzmvVar = new zzmv(j, strZzl, i3, zzacvVar.zzz(), null);
            } else if (i3 == 3) {
                zzmvVar = new zzmv(j, strZzl, i3, Double.doubleToRawLongBits(zzacvVar.zzd()), null);
            } else if (i3 == 4) {
                zzmvVar = new zzmv(j, strZzl, i3, 0L, zzacvVar.zzl());
            } else {
                if (i3 != 5) {
                    Gson$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(i3, "Unrecognized flag type ", new StringBuilder(String.valueOf(i3).length() + 23)));
                    return null;
                }
                zzmvVar = new zzmv(j, strZzl, i3, 0L, zzacvVar.zzo());
            }
            long j5 = zzmvVar.zza;
            if (j5 != 0) {
                j2 = j5;
            }
            builderNaturalOrder.add(zzmvVar);
        }
        return new zzmw(builderNaturalOrder.build());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzmw) {
            return this.zzb.equals(((zzmw) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(ImmutableMap.Builder builder) {
        UnmodifiableIterator it = this.zzb.iterator();
        while (it.hasNext()) {
            zzmv zzmvVar = (zzmv) it.next();
            builder.put(zzmvVar.zza(), zzmvVar.zzb());
        }
    }

    public final ImmutableSortedSet zze() {
        return this.zzb;
    }

    public final int zzf() {
        return this.zzb.size();
    }
}
