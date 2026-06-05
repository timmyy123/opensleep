package com.google.android.gms.internal.serialization;

import adamb.ogg.OggIO;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.serialization.zzvx;
import com.google.android.gms.internal.serialization.zzvy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzvx<MessageType extends zzvy<MessageType, BuilderType>, BuilderType extends zzvx<MessageType, BuilderType>> implements zzaap {
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzzt.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzaab)) {
            if (iterable instanceof zzaaz) {
                list.addAll((Collection) iterable);
                return;
            } else {
                addAllCheckingNulls(iterable, list);
                return;
            }
        }
        List listZza = ((zzaab) iterable).zza();
        zzaab zzaabVar = (zzaab) list;
        int size = list.size();
        for (Object obj : listZza) {
            if (obj == null) {
                int size2 = zzaabVar.size() - size;
                String strM = zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(size2).length() + 26), "Element at index ", size2, " is null.");
                int size3 = zzaabVar.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        Types$$ExternalSyntheticBUOutline0.m$1(strM);
                        return;
                    }
                    zzaabVar.remove(size3);
                }
            } else if (obj instanceof zzwr) {
                zzaabVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj;
                zzwr.zzl(bArr2, 0, bArr2.length);
                zzaabVar.zzb();
            } else {
                zzaabVar.add((String) obj);
            }
        }
    }

    private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof zzabb) {
                ((zzabb) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    resetListAndThrow(list, size2);
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
                resetListAndThrow(list, size2);
            }
            list.add(oggIO);
        }
    }

    public static zzabq newUninitializedMessageException(zzaaq zzaaqVar) {
        return new zzabq(zzaaqVar);
    }

    private static void resetListAndThrow(List<?> list, int i) {
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

    public abstract BuilderType internalMergeFrom(MessageType messagetype);

    @Override // com.google.android.gms.internal.serialization.zzaap
    public BuilderType mergeFrom(zzaaq zzaaqVar) {
        if (getDefaultInstanceForType().getClass().isInstance(zzaaqVar)) {
            return (BuilderType) internalMergeFrom((zzvy) zzaaqVar);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("mergeFrom(MessageLite) can only merge messages of the same type.");
        return null;
    }
}
