package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzici;
import com.google.android.gms.internal.ads.zzicj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzici<MessageType extends zzicj<MessageType, BuilderType>, BuilderType extends zzici<MessageType, BuilderType>> implements zzifo {
    public static zzigs zzaR(zzifp zzifpVar) {
        return new zzigs(zzifpVar);
    }

    public static <T> void zzaT(Iterable<T> iterable, List<? super T> list) {
        iterable.getClass();
        if (!(iterable instanceof zzifa)) {
            if (iterable instanceof zzify) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List listZza = ((zzifa) iterable).zza();
        zzifa zzifaVar = (zzifa) list;
        int size = list.size();
        for (Object obj : listZza) {
            if (obj == null) {
                int size2 = zzifaVar.size() - size;
                String strM = zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(size2).length() + 26), "Element at index ", size2, " is null.");
                int size3 = zzifaVar.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        Types$$ExternalSyntheticBUOutline0.m$1(strM);
                        return;
                    }
                    zzifaVar.remove(size3);
                }
            } else if (obj instanceof zzida) {
                zzifaVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                zzida.zzt(bArr, 0, bArr.length);
                zzifaVar.zzb();
            } else {
                zzifaVar.add((String) obj);
            }
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof zziga) {
                ((zziga) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    zzc(list, size2);
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            OggIO oggIO = (Object) list2.get(i);
            if (oggIO == null) {
                zzc(list, size2);
            }
            list.add(oggIO);
        }
    }

    private static void zzc(List<?> list, int i) {
        int size = list.size() - i;
        String strM = zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(size).length() + 26), "Element at index ", size, " is null.");
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i) {
                throw new NullPointerException(strM);
            }
            list.remove(size2);
        }
    }

    public BuilderType zzaJ(byte[] bArr, zzido zzidoVar) {
        return (BuilderType) zzaK(bArr, 0, bArr.length, zzidoVar);
    }

    public abstract BuilderType zzaK(byte[] bArr, int i, int i2, zzido zzidoVar);
}
